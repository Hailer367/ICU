package D2;

import android.net.http.SslError;
import android.os.Looper;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import java.util.HashMap;
import p1.C0580i;
import q1.AbstractC0602b;
import s2.InterfaceC0634f;
import x2.RunnableC0724c;

/* loaded from: classes.dex */
public final /* synthetic */ class Z implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f344f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f345g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f346h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f347i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f348j;

    public /* synthetic */ Z(Object obj, Object obj2, Object obj3, Object obj4, int i4) {
        this.f344f = i4;
        this.f345g = obj;
        this.f346h = obj2;
        this.f347i = obj3;
        this.f348j = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f344f;
        int i5 = 2;
        Object obj = this.f348j;
        Object obj2 = this.f347i;
        Object obj3 = this.f346h;
        Object obj4 = this.f345g;
        switch (i4) {
            case 0:
                d0 d0Var = (d0) obj4;
                WebView webView = (WebView) obj3;
                Message message = (Message) obj2;
                Message message2 = (Message) obj;
                C0034m c0034m = d0Var.f379a;
                C0037p c0037p = new C0037p(i5);
                c0034m.getClass();
                T2.h.e(webView, "viewArg");
                T2.h.e(message, "dontResendArg");
                T2.h.e(message2, "resendArg");
                L l3 = c0034m.f416a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(d0Var)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onFormResubmission` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onFormResubmission", l3.b(), null).v(I2.f.C(d0Var, webView, message, message2), new K(4, c0037p));
                    return;
                }
            case 1:
                d0 d0Var2 = (d0) obj4;
                WebView webView2 = (WebView) obj3;
                SslErrorHandler sslErrorHandler = (SslErrorHandler) obj2;
                SslError sslError = (SslError) obj;
                C0034m c0034m2 = d0Var2.f379a;
                C0037p c0037p2 = new C0037p(i5);
                c0034m2.getClass();
                T2.h.e(webView2, "viewArg");
                T2.h.e(sslErrorHandler, "handlerArg");
                T2.h.e(sslError, "errorArg");
                L l4 = c0034m2.f416a;
                l4.getClass();
                if (!((C0024c) l4.f297g).d(d0Var2)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onReceivedSslError` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l4.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedSslError", l4.b(), null).v(I2.f.C(d0Var2, webView2, sslErrorHandler, sslError), new K(5, c0037p2));
                    return;
                }
            case 2:
                d0 d0Var3 = (d0) obj4;
                WebView webView3 = (WebView) obj3;
                WebResourceRequest webResourceRequest = (WebResourceRequest) obj2;
                WebResourceError webResourceError = (WebResourceError) obj;
                C0034m c0034m3 = d0Var3.f379a;
                C0037p c0037p3 = new C0037p(i5);
                c0034m3.getClass();
                T2.h.e(webView3, "webViewArg");
                T2.h.e(webResourceRequest, "requestArg");
                T2.h.e(webResourceError, "errorArg");
                L l5 = c0034m3.f416a;
                l5.getClass();
                if (!((C0024c) l5.f297g).d(d0Var3)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onReceivedRequestError` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l5.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedRequestError", l5.b(), null).v(I2.f.C(d0Var3, webView3, webResourceRequest, webResourceError), new K(1, c0037p3));
                    return;
                }
            case 3:
                d0 d0Var4 = (d0) obj4;
                WebView webView4 = (WebView) obj3;
                WebResourceRequest webResourceRequest2 = (WebResourceRequest) obj2;
                WebResourceResponse webResourceResponse = (WebResourceResponse) obj;
                C0034m c0034m4 = d0Var4.f379a;
                C0037p c0037p4 = new C0037p(i5);
                c0034m4.getClass();
                T2.h.e(webView4, "webViewArg");
                T2.h.e(webResourceRequest2, "requestArg");
                T2.h.e(webResourceResponse, "responseArg");
                L l6 = c0034m4.f416a;
                l6.getClass();
                if (!((C0024c) l6.f297g).d(d0Var4)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onReceivedHttpError` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new P1.y((InterfaceC0634f) l6.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpError", l6.b(), null).v(I2.f.C(d0Var4, webView4, webResourceRequest2, webResourceResponse), new A1.c(24, c0037p4));
                    return;
                }
            default:
                x2.d dVar = (x2.d) obj4;
                x2.f fVar = (x2.f) obj3;
                String str = (String) obj2;
                C0580i c0580i = (C0580i) obj;
                HashMap hashMap = x2.d.f6504h;
                dVar.getClass();
                try {
                    String str2 = fVar.f6509a;
                    Z0.r.d(str2, "ApiKey must be set.");
                    String str3 = fVar.f6510b;
                    Z0.r.d(str3, "ApplicationId must be set.");
                    String str4 = fVar.f6514f;
                    String str5 = fVar.f6511c;
                    String str6 = fVar.f6512d;
                    u1.g gVar = new u1.g(str3, str2, str4, fVar.f6517i, str5, fVar.f6515g, str6);
                    try {
                        Looper.prepare();
                    } catch (Exception unused) {
                    }
                    String str7 = fVar.f6513e;
                    if (str7 != null) {
                        x2.d.f6504h.put(str, str7);
                    }
                    u1.f i6 = u1.f.i(dVar.f6505f, str, gVar);
                    C0580i c0580i2 = new C0580i();
                    FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(dVar, i6, c0580i2));
                    c0580i.b((x2.g) AbstractC0602b.c(c0580i2.f5821a));
                    return;
                } catch (Exception e4) {
                    c0580i.a(e4);
                    return;
                }
        }
    }
}
