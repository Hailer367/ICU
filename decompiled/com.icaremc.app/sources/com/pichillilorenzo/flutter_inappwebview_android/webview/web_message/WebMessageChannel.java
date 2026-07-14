package com.pichillilorenzo.flutter_inappwebview_android.webview.web_message;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessageCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePort;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePortCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewInterface;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k3.a;
import p0.AbstractC0565d;
import p0.n;
import p0.o;
import p0.w;
import q0.C0595C;
import q0.r;
import q0.s;
import q0.x;
import r2.k;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class WebMessageChannel implements Disposable {
    protected static final String LOG_TAG = "WebMessageChannel";
    public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappwebview_web_message_channel_";
    public WebMessageChannelChannelDelegate channelDelegate;
    public final List<o> compatPorts;
    public String id;
    public final List<WebMessagePort> ports;
    public InAppWebViewInterface webView;

    public WebMessageChannel(String str, InAppWebViewInterface inAppWebViewInterface) {
        o[] oVarArr;
        this.id = str;
        this.channelDelegate = new WebMessageChannelChannelDelegate(this, new C0644p(inAppWebViewInterface.getPlugin().messenger, k.d(METHOD_CHANNEL_NAME_PREFIX, str)));
        if (inAppWebViewInterface instanceof InAppWebView) {
            Uri uri = w.f5818a;
            android.webkit.WebMessagePort[] createWebMessageChannel = ((InAppWebView) inAppWebViewInterface).createWebMessageChannel();
            if (createWebMessageChannel == null) {
                oVarArr = null;
            } else {
                o[] oVarArr2 = new o[createWebMessageChannel.length];
                for (int i4 = 0; i4 < createWebMessageChannel.length; i4++) {
                    oVarArr2[i4] = new s(createWebMessageChannel[i4]);
                }
                oVarArr = oVarArr2;
            }
            this.compatPorts = new ArrayList(Arrays.asList(oVarArr));
            this.ports = new ArrayList();
        } else {
            this.ports = Arrays.asList(new WebMessagePort("port1", this), new WebMessagePort("port2", this));
            this.compatPorts = new ArrayList();
        }
        this.webView = inAppWebViewInterface;
    }

    public void closeForInAppWebView(Integer num, InterfaceC0643o interfaceC0643o) {
        if (this.webView != null && this.compatPorts.size() > 0 && AbstractC0565d.a("WEB_MESSAGE_PORT_CLOSE")) {
            try {
                ((s) this.compatPorts.get(num.intValue())).d().close();
                interfaceC0643o.success(Boolean.TRUE);
                return;
            } catch (Exception e4) {
                interfaceC0643o.error(LOG_TAG, e4.getMessage(), null);
                return;
            }
        }
        interfaceC0643o.success(Boolean.TRUE);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        if (AbstractC0565d.a("WEB_MESSAGE_PORT_CLOSE")) {
            Iterator<o> it = this.compatPorts.iterator();
            while (it.hasNext()) {
                try {
                    ((s) it.next()).d().close();
                } catch (Exception unused) {
                }
            }
        }
        WebMessageChannelChannelDelegate webMessageChannelChannelDelegate = this.channelDelegate;
        if (webMessageChannelChannelDelegate != null) {
            webMessageChannelChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.compatPorts.clear();
        this.webView = null;
    }

    public void initJsInstance(InAppWebViewInterface inAppWebViewInterface, final ValueCallback<WebMessageChannel> valueCallback) {
        if (inAppWebViewInterface != null) {
            inAppWebViewInterface.evaluateJavascript(k.c(new StringBuilder("(function() {window.flutter_inappwebview._webMessageChannels['"), this.id, "'] = new MessageChannel();})();"), null, new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageChannel.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                    valueCallback.onReceiveValue(this);
                }
            });
        } else {
            valueCallback.onReceiveValue(this);
        }
    }

    public void onMessage(int i4, WebMessageCompatExt webMessageCompatExt) {
        WebMessageChannelChannelDelegate webMessageChannelChannelDelegate = this.channelDelegate;
        if (webMessageChannelChannelDelegate != null) {
            webMessageChannelChannelDelegate.onMessage(i4, webMessageCompatExt);
        }
    }

    public void postMessageForInAppWebView(Integer num, WebMessageCompatExt webMessageCompatExt, InterfaceC0643o interfaceC0643o) {
        String str;
        if (this.webView != null && this.compatPorts.size() > 0 && AbstractC0565d.a("WEB_MESSAGE_PORT_POST_MESSAGE")) {
            o oVar = this.compatPorts.get(num.intValue());
            ArrayList arrayList = new ArrayList();
            List<WebMessagePortCompatExt> ports = webMessageCompatExt.getPorts();
            if (ports != null) {
                for (WebMessagePortCompatExt webMessagePortCompatExt : ports) {
                    WebMessageChannel webMessageChannel = this.webView.getWebMessageChannels().get(webMessagePortCompatExt.getWebMessageChannelId());
                    if (webMessageChannel != null) {
                        arrayList.add(webMessageChannel.compatPorts.get(webMessagePortCompatExt.getIndex()));
                    }
                }
            }
            Object data = webMessageCompatExt.getData();
            try {
                if (AbstractC0565d.a("WEB_MESSAGE_ARRAY_BUFFER") && data != null && webMessageCompatExt.getType() == 1) {
                    oVar.a(new n((byte[]) data, (o[]) arrayList.toArray(new o[0])));
                } else {
                    if (data != null) {
                        str = data.toString();
                    } else {
                        str = null;
                    }
                    oVar.a(new n(str, (o[]) arrayList.toArray(new o[0])));
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            } catch (Exception e4) {
                interfaceC0643o.error(LOG_TAG, e4.getMessage(), null);
                return;
            }
        }
        interfaceC0643o.success(Boolean.TRUE);
    }

    public void setWebMessageCallbackForInAppWebView(final int i4, InterfaceC0643o interfaceC0643o) {
        if (this.webView != null && this.compatPorts.size() > 0 && AbstractC0565d.a("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK")) {
            o oVar = this.compatPorts.get(i4);
            try {
                AbstractC0565d abstractC0565d = new AbstractC0565d() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageChannel.2
                    @Override // p0.AbstractC0565d
                    public void onMessage(o oVar2, n nVar) {
                        WebMessageCompatExt webMessageCompatExt;
                        WebMessageChannel webMessageChannel = this;
                        int i5 = i4;
                        if (nVar != null) {
                            webMessageCompatExt = WebMessageCompatExt.fromMapWebMessageCompat(nVar);
                        } else {
                            webMessageCompatExt = null;
                        }
                        webMessageChannel.onMessage(i5, webMessageCompatExt);
                    }
                };
                s sVar = (s) oVar;
                sVar.getClass();
                if (x.f5923r.b()) {
                    sVar.c().setWebMessageCallback(new a(new C0595C(3, abstractC0565d)));
                } else {
                    sVar.d().setWebMessageCallback(new r(abstractC0565d));
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            } catch (Exception e4) {
                interfaceC0643o.error(LOG_TAG, e4.getMessage(), null);
                return;
            }
        }
        interfaceC0643o.success(Boolean.TRUE);
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", this.id);
        return hashMap;
    }
}
