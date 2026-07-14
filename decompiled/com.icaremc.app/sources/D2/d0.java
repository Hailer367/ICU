package D2;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final class d0 extends WebViewClient {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f378c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final C0034m f379a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f380b = false;

    public d0(C0034m c0034m) {
        this.f379a = c0034m;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(final WebView webView, final String str, final boolean z) {
        this.f379a.f416a.d(new Runnable() { // from class: D2.b0
            @Override // java.lang.Runnable
            public final void run() {
                d0 d0Var = d0.this;
                C0034m c0034m = d0Var.f379a;
                C0037p c0037p = new C0037p(2);
                c0034m.getClass();
                WebView webView2 = webView;
                T2.h.e(webView2, "webViewArg");
                String str2 = str;
                T2.h.e(str2, "urlArg");
                L l3 = c0034m.f416a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(d0Var)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.doUpdateVisitedHistory` failed because native instance was not in the instance manager.", "");
                } else {
                    new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.doUpdateVisitedHistory", l3.b(), null).v(I2.f.C(d0Var, webView2, str2, Boolean.valueOf(z)), new K(7, c0037p));
                }
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        this.f379a.f416a.d(new Z(this, webView, message, message2, 0));
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        this.f379a.f416a.d(new X(this, webView, str, 1));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        this.f379a.f416a.d(new X(this, webView, str, 3));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.f379a.f416a.d(new X(this, webView, str, 2));
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f379a.f416a.d(new X(this, webView, str, 0));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        this.f379a.f416a.d(new Y(this, webView, clientCertRequest, 0));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.f379a.f416a.d(new Z(this, webView, webResourceRequest, webResourceError, 2));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f379a.f416a.d(new a0(this, webView, httpAuthHandler, str, str2));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.f379a.f416a.d(new Z(this, webView, webResourceRequest, webResourceResponse, 3));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        this.f379a.f416a.d(new a0(this, webView, str, str2, str3));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f379a.f416a.d(new Z(this, webView, sslErrorHandler, sslError, 1));
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(final WebView webView, final float f4, final float f5) {
        this.f379a.f416a.d(new Runnable() { // from class: D2.c0
            @Override // java.lang.Runnable
            public final void run() {
                d0 d0Var = d0.this;
                C0034m c0034m = d0Var.f379a;
                double d4 = f4;
                double d5 = f5;
                C0037p c0037p = new C0037p(2);
                c0034m.getClass();
                WebView webView2 = webView;
                T2.h.e(webView2, "viewArg");
                L l3 = c0034m.f416a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(d0Var)) {
                    A2.i.p("missing-instance-error", "Callback to `WebViewClient.onScaleChanged` failed because native instance was not in the instance manager.", "");
                } else {
                    new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onScaleChanged", l3.b(), null).v(I2.f.C(d0Var, webView2, Double.valueOf(d4), Double.valueOf(d5)), new K(6, c0037p));
                }
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        this.f379a.f416a.d(new Y(this, webView, webResourceRequest, 1));
        if (webResourceRequest.isForMainFrame() && this.f380b) {
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }
}
