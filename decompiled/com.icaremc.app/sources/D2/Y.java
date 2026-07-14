package D2;

import P1.AbstractServiceC0103g;
import android.content.Intent;
import android.webkit.ClientCertRequest;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import f1.AbstractC0286a;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import p1.C0580i;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final /* synthetic */ class Y implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f340f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f341g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f342h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f343i;

    public /* synthetic */ Y(N0.b bVar, I0.j jVar, K k, I0.i iVar) {
        this.f340f = 2;
        this.f341g = bVar;
        this.f342h = jVar;
        this.f343i = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f340f) {
            case 0:
                d0 d0Var = (d0) this.f341g;
                WebView webView = (WebView) this.f342h;
                ClientCertRequest clientCertRequest = (ClientCertRequest) this.f343i;
                C0034m c0034m = d0Var.f379a;
                C0037p c0037p = new C0037p(2);
                c0034m.getClass();
                T2.h.e(webView, "viewArg");
                T2.h.e(clientCertRequest, "requestArg");
                L l3 = c0034m.f416a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(d0Var)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onReceivedClientCertRequest` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedClientCertRequest", l3.b(), null).v(I2.f.C(d0Var, webView, clientCertRequest), new A1.c(28, c0037p));
                    return;
                }
            case 1:
                d0 d0Var2 = (d0) this.f341g;
                WebView webView2 = (WebView) this.f342h;
                WebResourceRequest webResourceRequest = (WebResourceRequest) this.f343i;
                C0034m c0034m2 = d0Var2.f379a;
                C0037p c0037p2 = new C0037p(2);
                c0034m2.getClass();
                T2.h.e(webView2, "webViewArg");
                T2.h.e(webResourceRequest, "requestArg");
                L l4 = c0034m2.f416a;
                l4.getClass();
                if (!((C0024c) l4.f297g).d(d0Var2)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.requestLoading` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l4.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.requestLoading", l4.b(), null).v(I2.f.C(d0Var2, webView2, webResourceRequest), new A1.c(29, c0037p2));
                    return;
                }
            case 2:
                N0.b bVar = (N0.b) this.f341g;
                I0.j jVar = (I0.j) this.f342h;
                String str = jVar.f831a;
                I0.i iVar = (I0.i) this.f343i;
                bVar.getClass();
                Logger logger = N0.b.f1067f;
                try {
                    J0.f a4 = bVar.f1070c.a(str);
                    if (a4 == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        new IllegalArgumentException(str2);
                    } else {
                        ((P0.h) bVar.f1072e).f(new N0.a(bVar, jVar, ((G0.c) a4).a(iVar), 0));
                    }
                    return;
                } catch (Exception e4) {
                    logger.warning("Error scheduling event " + e4.getMessage());
                    return;
                }
            case 3:
                AbstractServiceC0103g abstractServiceC0103g = (AbstractServiceC0103g) this.f341g;
                Intent intent = (Intent) this.f342h;
                C0580i c0580i = (C0580i) this.f343i;
                try {
                    abstractServiceC0103g.b(intent);
                    return;
                } finally {
                    c0580i.b(null);
                }
            default:
                A2.x xVar = (A2.x) this.f341g;
                AbstractC0286a abstractC0286a = (AbstractC0286a) this.f342h;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f343i;
                try {
                    T.r l5 = android.support.v4.media.session.a.l(xVar.f117a);
                    if (l5 != null) {
                        T.q qVar = (T.q) l5.f1587a;
                        synchronized (qVar.f1581d) {
                            qVar.f1583f = threadPoolExecutor;
                        }
                        l5.f1587a.a(new T.m(abstractC0286a, threadPoolExecutor));
                        return;
                    }
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                } catch (Throwable th) {
                    abstractC0286a.A(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
        }
    }

    public /* synthetic */ Y(Object obj, Object obj2, Object obj3, int i4) {
        this.f340f = i4;
        this.f341g = obj;
        this.f342h = obj2;
        this.f343i = obj3;
    }
}
