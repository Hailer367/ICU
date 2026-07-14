package D2;

import android.webkit.WebView;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final /* synthetic */ class X implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f336f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d0 f337g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ WebView f338h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f339i;

    public /* synthetic */ X(d0 d0Var, WebView webView, String str, int i4) {
        this.f336f = i4;
        this.f337g = d0Var;
        this.f338h = webView;
        this.f339i = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f336f) {
            case 0:
                d0 d0Var = this.f337g;
                C0034m c0034m = d0Var.f379a;
                C0037p c0037p = new C0037p(2);
                c0034m.getClass();
                WebView webView = this.f338h;
                T2.h.e(webView, "webViewArg");
                String str = this.f339i;
                T2.h.e(str, "urlArg");
                L l3 = c0034m.f416a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(d0Var)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onPageStarted` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageStarted", l3.b(), null).v(I2.f.C(d0Var, webView, str), new A1.c(27, c0037p));
                    return;
                }
            case 1:
                d0 d0Var2 = this.f337g;
                C0034m c0034m2 = d0Var2.f379a;
                C0037p c0037p2 = new C0037p(2);
                c0034m2.getClass();
                WebView webView2 = this.f338h;
                T2.h.e(webView2, "viewArg");
                String str2 = this.f339i;
                T2.h.e(str2, "urlArg");
                L l4 = c0034m2.f416a;
                l4.getClass();
                if (!((C0024c) l4.f297g).d(d0Var2)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onLoadResource` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l4.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onLoadResource", l4.b(), null).v(I2.f.C(d0Var2, webView2, str2), new A1.c(25, c0037p2));
                    return;
                }
            case 2:
                d0 d0Var3 = this.f337g;
                C0034m c0034m3 = d0Var3.f379a;
                C0037p c0037p3 = new C0037p(2);
                c0034m3.getClass();
                WebView webView3 = this.f338h;
                T2.h.e(webView3, "webViewArg");
                String str3 = this.f339i;
                T2.h.e(str3, "urlArg");
                L l5 = c0034m3.f416a;
                l5.getClass();
                if (!((C0024c) l5.f297g).d(d0Var3)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onPageFinished` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l5.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageFinished", l5.b(), null).v(I2.f.C(d0Var3, webView3, str3), new K(2, c0037p3));
                    return;
                }
            default:
                d0 d0Var4 = this.f337g;
                C0034m c0034m4 = d0Var4.f379a;
                C0037p c0037p4 = new C0037p(2);
                c0034m4.getClass();
                WebView webView4 = this.f338h;
                T2.h.e(webView4, "viewArg");
                String str4 = this.f339i;
                T2.h.e(str4, "urlArg");
                L l6 = c0034m4.f416a;
                l6.getClass();
                if (!((C0024c) l6.f297g).d(d0Var4)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onPageCommitVisible` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l6.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageCommitVisible", l6.b(), null).v(I2.f.C(d0Var4, webView4, str4), new K(0, c0037p4));
                    return;
                }
        }
    }
}
