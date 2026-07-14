package D2;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.flutter.plugin.platform.InterfaceC0382f;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final class h0 extends WebView implements InterfaceC0382f {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f397i = 0;

    /* renamed from: f, reason: collision with root package name */
    public final C0030i f398f;

    /* renamed from: g, reason: collision with root package name */
    public WebViewClient f399g;

    /* renamed from: h, reason: collision with root package name */
    public S f400h;

    /* JADX WARN: Type inference failed for: r2v2, types: [D2.S, android.webkit.WebChromeClient] */
    public h0(C0030i c0030i) {
        super((Context) c0030i.f401a.f299i);
        this.f398f = c0030i;
        this.f399g = new WebViewClient();
        this.f400h = new WebChromeClient();
        setWebViewClient(this.f399g);
        setWebChromeClient(this.f400h);
    }

    @Override // android.webkit.WebView
    public WebChromeClient getWebChromeClient() {
        return this.f400h;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        h2.p pVar;
        super.onAttachedToWindow();
        this.f398f.f401a.getClass();
        if (Build.VERSION.SDK_INT >= 26) {
            ViewParent viewParent = this;
            while (true) {
                if (viewParent.getParent() != null) {
                    viewParent = viewParent.getParent();
                    if (viewParent instanceof h2.p) {
                        pVar = (h2.p) viewParent;
                        break;
                    }
                } else {
                    pVar = null;
                    break;
                }
            }
            if (pVar != null) {
                pVar.setImportantForAutofill(1);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onScrollChanged(final int i4, final int i5, final int i6, final int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        this.f398f.f401a.d(new Runnable() { // from class: D2.g0
            @Override // java.lang.Runnable
            public final void run() {
                h0 h0Var = h0.this;
                C0030i c0030i = h0Var.f398f;
                long j4 = i4;
                long j5 = i5;
                long j6 = i6;
                long j7 = i7;
                C0037p c0037p = new C0037p(3);
                c0030i.getClass();
                L l3 = c0030i.f401a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(h0Var)) {
                    A2.i.p("missing-instance-error", "Callback to `WebView.onScrollChanged` failed because native instance was not in the instance manager.", "");
                } else {
                    new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebView.onScrollChanged", l3.b(), null).v(I2.f.C(h0Var, Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7)), new A1.c(23, c0037p));
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        super.setWebChromeClient(webChromeClient);
        if (webChromeClient instanceof S) {
            S s3 = (S) webChromeClient;
            this.f400h = s3;
            s3.f319a = this.f399g;
            return;
        }
        throw new AssertionError("Client must be a SecureWebChromeClient.");
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        this.f399g = webViewClient;
        this.f400h.f319a = webViewClient;
    }

    @Override // io.flutter.plugin.platform.InterfaceC0382f
    public final void dispose() {
    }

    @Override // io.flutter.plugin.platform.InterfaceC0382f
    public View getView() {
        return this;
    }
}
