package D2;

import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f352f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d0 f353g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ WebView f354h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f355i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f356j;
    public final /* synthetic */ Object k;

    public /* synthetic */ a0(d0 d0Var, WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f353g = d0Var;
        this.f354h = webView;
        this.k = httpAuthHandler;
        this.f355i = str;
        this.f356j = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f352f) {
            case 0:
                String str = (String) this.k;
                d0 d0Var = this.f353g;
                C0034m c0034m = d0Var.f379a;
                C0037p c0037p = new C0037p(2);
                c0034m.getClass();
                WebView webView = this.f354h;
                T2.h.e(webView, "viewArg");
                String str2 = this.f355i;
                T2.h.e(str2, "realmArg");
                T2.h.e(str, "argsArg");
                L l3 = c0034m.f416a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(d0Var)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onReceivedLoginRequest` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedLoginRequest", l3.b(), null).v(I2.f.C(d0Var, webView, str2, this.f356j, str), new A1.c(26, c0037p));
                    return;
                }
            default:
                HttpAuthHandler httpAuthHandler = (HttpAuthHandler) this.k;
                d0 d0Var2 = this.f353g;
                C0034m c0034m2 = d0Var2.f379a;
                C0037p c0037p2 = new C0037p(2);
                c0034m2.getClass();
                WebView webView2 = this.f354h;
                T2.h.e(webView2, "webViewArg");
                T2.h.e(httpAuthHandler, "handlerArg");
                String str3 = this.f355i;
                T2.h.e(str3, "hostArg");
                String str4 = this.f356j;
                T2.h.e(str4, "realmArg");
                L l4 = c0034m2.f416a;
                l4.getClass();
                if (!((C0024c) l4.f297g).d(d0Var2)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onReceivedHttpAuthRequest` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l4.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpAuthRequest", l4.b(), null).v(I2.f.C(d0Var2, webView2, httpAuthHandler, str3, str4), new K(3, c0037p2));
                    return;
                }
        }
    }

    public /* synthetic */ a0(d0 d0Var, WebView webView, String str, String str2, String str3) {
        this.f353g = d0Var;
        this.f354h = webView;
        this.f355i = str;
        this.f356j = str2;
        this.k = str3;
    }
}
