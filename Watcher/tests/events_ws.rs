//! WebSocket state-machine tests using a tiny in-process mock server.
//!
//! These do not need Alchemy or any network access. They cover the two bugs
//! that are easy to miss in review:
//!   1. the first successful connection must not be reported as a reconnect;
//!   2. subscription request ids keep increasing after a reconnect, so the
//!      ack must be mapped through the per-connection pending table, not `id-1`.

use std::time::Duration;

use futures_util::{SinkExt, StreamExt};
use ryo_watch::config::EventSource;
use ryo_watch::events::{EventStream, Trigger};
use serde_json::{Value, json};
use tokio::net::{TcpListener, TcpStream};
use tokio::time::timeout;
use tokio_tungstenite::tungstenite::Message;
use tokio_tungstenite::{WebSocketStream, accept_async};

type ServerWs = WebSocketStream<TcpStream>;

async fn read_subscription(ws: &mut ServerWs) -> (u64, String) {
    loop {
        let message = timeout(Duration::from_secs(5), ws.next())
            .await
            .expect("client went quiet")
            .expect("socket closed")
            .expect("socket error");
        match message {
            Message::Text(text) => {
                let value: Value = serde_json::from_str(text.as_str()).unwrap();
                if value.get("method").and_then(Value::as_str) == Some("eth_subscribe") {
                    let id = value.get("id").and_then(Value::as_u64).unwrap();
                    let name = value["params"][0].as_str().unwrap().to_string();
                    return (id, name);
                }
            }
            Message::Ping(payload) => {
                ws.send(Message::Pong(payload)).await.unwrap();
            }
            _ => {}
        }
    }
}

async fn ack(ws: &mut ServerWs, id: u64, subscription: &str) {
    let value = json!({ "jsonrpc": "2.0", "id": id, "result": subscription });
    ws.send(Message::text(value.to_string())).await.unwrap();
}

fn head_notification(subscription: &str, number: u64) -> Value {
    json!({
        "jsonrpc": "2.0",
        "method": "eth_subscription",
        "params": {
            "subscription": subscription,
            "result": {
                "number": format!("0x{number:x}"),
                "hash": "0x0000000000000000000000000000000000000000000000000000000000000001",
                "parentHash": "0x0000000000000000000000000000000000000000000000000000000000000000",
            }
        }
    })
}

#[tokio::test]
async fn first_connect_is_not_a_reconnect_and_ack_ids_survive_reconnect() {
    let listener = TcpListener::bind("127.0.0.1:0").await.unwrap();
    let addr = listener.local_addr().unwrap();

    let server = tokio::spawn(async move {
        // --- connection 1 -----------------------------------------------------
        let (tcp, _) = listener.accept().await.unwrap();
        let mut ws = accept_async(tcp).await.unwrap();
        let mut heads_sub = String::new();
        for index in 0..3 {
            let (id, name) = read_subscription(&mut ws).await;
            let subscription = format!("0xsub{index}");
            if name == "newHeads" {
                heads_sub = subscription.clone();
            }
            ack(&mut ws, id, &subscription).await;
        }

        // Two notifications in one frame: both must be queued, not dropped.
        let batch = json!([
            head_notification(&heads_sub, 42),
            head_notification(&heads_sub, 43),
        ]);
        ws.send(Message::text(batch.to_string())).await.unwrap();
        ws.send(Message::Close(None)).await.unwrap();

        // --- connection 2 -----------------------------------------------------
        let (tcp, _) = listener.accept().await.unwrap();
        let mut ws = accept_async(tcp).await.unwrap();
        let mut heads_sub = String::new();
        for index in 0..3 {
            let (id, name) = read_subscription(&mut ws).await;
            // Reconnect request ids are 4,5,6 rather than 1,2,3. An `id-1`
            // lookup would map 5/6 outside the spec list.
            let subscription = format!("0xsub{index}");
            if name == "newHeads" {
                heads_sub = subscription.clone();
            }
            ack(&mut ws, id, &subscription).await;
        }
        tokio::time::sleep(Duration::from_millis(250)).await;
        ws.send(Message::text(head_notification(&heads_sub, 44).to_string()))
            .await
            .unwrap();
        tokio::time::sleep(Duration::from_secs(2)).await;
    });

    let url = format!("ws://{addr}");
    let mut stream = EventStream::new(url, EventSource::Flashblocks, &[]);

    let first = timeout(Duration::from_secs(5), stream.next())
        .await
        .expect("first trigger timed out")
        .unwrap();
    assert!(matches!(first, Trigger::Head { number: 42 }), "{first:?}");

    let second = timeout(Duration::from_secs(5), stream.next())
        .await
        .expect("queued trigger timed out")
        .unwrap();
    assert!(matches!(second, Trigger::Head { number: 43 }), "{second:?}");

    let reconnect = timeout(Duration::from_secs(8), stream.next())
        .await
        .expect("reconnect trigger timed out")
        .unwrap();
    assert!(matches!(reconnect, Trigger::Reconnect), "{reconnect:?}");

    let after = timeout(Duration::from_secs(8), stream.next())
        .await
        .expect("post-reconnect head timed out")
        .unwrap();
    assert!(
        matches!(after, Trigger::Head { number: 44 }),
        "ack after reconnect was mapped to the wrong kind: {after:?}"
    );

    server.abort();
}
