package D2;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.List;
import java.util.Objects;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final class W extends S {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f329h = 0;

    /* renamed from: b, reason: collision with root package name */
    public final C0030i f330b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f331c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f332d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f333e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f334f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f335g = false;

    public W(C0030i c0030i) {
        this.f330b = c0030i;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        C0037p c0037p = new C0037p(1);
        C0030i c0030i = this.f330b;
        c0030i.getClass();
        T2.h.e(consoleMessage, "messageArg");
        L l3 = c0030i.f401a;
        l3.getClass();
        if (!((C0024c) l3.f297g).d(this)) {
            A2.i.p("missing-instance-error", "Callback to `WebChromeClient.onConsoleMessage` failed because native instance was not in the instance manager.", "");
        } else {
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage", l3.b(), null).v(I2.f.C(this, consoleMessage), new A1.c(18, c0037p));
        }
        return this.f332d;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        C0037p c0037p = new C0037p(1);
        C0030i c0030i = this.f330b;
        c0030i.getClass();
        L l3 = c0030i.f401a;
        l3.getClass();
        if (!((C0024c) l3.f297g).d(this)) {
            A2.i.p("missing-instance-error", "Callback to `WebChromeClient.onGeolocationPermissionsHidePrompt` failed because native instance was not in the instance manager.", "");
        } else {
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt", l3.b(), null).v(android.support.v4.media.session.a.p(this), new A1.c(20, c0037p));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        C0037p c0037p = new C0037p(1);
        C0030i c0030i = this.f330b;
        c0030i.getClass();
        T2.h.e(str, "originArg");
        T2.h.e(callback, "callbackArg");
        L l3 = c0030i.f401a;
        l3.getClass();
        if (!((C0024c) l3.f297g).d(this)) {
            A2.i.p("missing-instance-error", "Callback to `WebChromeClient.onGeolocationPermissionsShowPrompt` failed because native instance was not in the instance manager.", "");
        } else {
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt", l3.b(), null).v(I2.f.C(this, str, callback), new A1.c(19, c0037p));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        C0037p c0037p = new C0037p(1);
        C0030i c0030i = this.f330b;
        c0030i.getClass();
        L l3 = c0030i.f401a;
        l3.getClass();
        if (!((C0024c) l3.f297g).d(this)) {
            A2.i.p("missing-instance-error", "Callback to `WebChromeClient.onHideCustomView` failed because native instance was not in the instance manager.", "");
        } else {
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView", l3.b(), null).v(android.support.v4.media.session.a.p(this), new A1.c(14, c0037p));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.f333e) {
            T t3 = new T(this, jsResult, 1);
            M m3 = new M(0, t3);
            C0030i c0030i = this.f330b;
            c0030i.getClass();
            T2.h.e(webView, "webViewArg");
            T2.h.e(str, "urlArg");
            T2.h.e(str2, "messageArg");
            L l3 = c0030i.f401a;
            l3.getClass();
            if (!((C0024c) l3.f297g).d(this)) {
                Throwable a4 = H2.f.a(k3.b.f(new C0022a("missing-instance-error", "Callback to `WebChromeClient.onJsAlert` failed because native instance was not in the instance manager.", "")));
                L l4 = t3.f321g.f330b.f401a;
                Objects.requireNonNull(a4);
                l4.getClass();
                L.c(a4);
                return true;
            }
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert", l3.b(), null).v(I2.f.C(this, webView, str, str2), new F(m3, 1));
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.f334f) {
            T t3 = new T(this, jsResult, 0);
            M m3 = new M(0, t3);
            C0030i c0030i = this.f330b;
            c0030i.getClass();
            T2.h.e(webView, "webViewArg");
            T2.h.e(str, "urlArg");
            T2.h.e(str2, "messageArg");
            L l3 = c0030i.f401a;
            l3.getClass();
            if (!((C0024c) l3.f297g).d(this)) {
                Throwable a4 = H2.f.a(k3.b.f(new C0022a("missing-instance-error", "Callback to `WebChromeClient.onJsConfirm` failed because native instance was not in the instance manager.", "")));
                L l4 = t3.f321g.f330b.f401a;
                Objects.requireNonNull(a4);
                l4.getClass();
                L.c(a4);
                return true;
            }
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm", l3.b(), null).v(I2.f.C(this, webView, str, str2), new F(m3, 3));
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.f335g) {
            U u3 = new U(0, this, jsPromptResult);
            M m3 = new M(0, u3);
            C0030i c0030i = this.f330b;
            c0030i.getClass();
            T2.h.e(webView, "webViewArg");
            T2.h.e(str, "urlArg");
            T2.h.e(str2, "messageArg");
            T2.h.e(str3, "defaultValueArg");
            L l3 = c0030i.f401a;
            l3.getClass();
            if (!((C0024c) l3.f297g).d(this)) {
                Throwable a4 = H2.f.a(k3.b.f(new C0022a("missing-instance-error", "Callback to `WebChromeClient.onJsPrompt` failed because native instance was not in the instance manager.", "")));
                L l4 = ((W) u3.f324g).f330b.f401a;
                Objects.requireNonNull(a4);
                l4.getClass();
                L.c(a4);
                return true;
            }
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt", l3.b(), null).v(I2.f.C(this, webView, str, str2, str3), new F(m3, 0));
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        C0037p c0037p = new C0037p(1);
        C0030i c0030i = this.f330b;
        c0030i.getClass();
        T2.h.e(permissionRequest, "requestArg");
        L l3 = c0030i.f401a;
        l3.getClass();
        if (!((C0024c) l3.f297g).d(this)) {
            A2.i.p("missing-instance-error", "Callback to `WebChromeClient.onPermissionRequest` failed because native instance was not in the instance manager.", "");
        } else {
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest", l3.b(), null).v(I2.f.C(this, permissionRequest), new A1.c(16, c0037p));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i4) {
        long j4 = i4;
        C0037p c0037p = new C0037p(1);
        C0030i c0030i = this.f330b;
        c0030i.getClass();
        T2.h.e(webView, "webViewArg");
        L l3 = c0030i.f401a;
        l3.getClass();
        if (!((C0024c) l3.f297g).d(this)) {
            A2.i.p("missing-instance-error", "Callback to `WebChromeClient.onProgressChanged` failed because native instance was not in the instance manager.", "");
        } else {
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged", l3.b(), null).v(I2.f.C(this, webView, Long.valueOf(j4)), new A1.c(15, c0037p));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        C0037p c0037p = new C0037p(1);
        C0030i c0030i = this.f330b;
        c0030i.getClass();
        T2.h.e(view, "viewArg");
        T2.h.e(customViewCallback, "callbackArg");
        L l3 = c0030i.f401a;
        l3.getClass();
        if (!((C0024c) l3.f297g).d(this)) {
            A2.i.p("missing-instance-error", "Callback to `WebChromeClient.onShowCustomView` failed because native instance was not in the instance manager.", "");
        } else {
            new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView", l3.b(), null).v(I2.f.C(this, view, customViewCallback), new A1.c(17, c0037p));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView webView, final ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        final boolean z = this.f331c;
        S2.l lVar = new S2.l() { // from class: D2.V
            @Override // S2.l
            public final Object f(Object obj) {
                N n3 = (N) obj;
                if (n3.f306d) {
                    L l3 = W.this.f330b.f401a;
                    Throwable th = n3.f305c;
                    Objects.requireNonNull(th);
                    l3.getClass();
                    L.c(th);
                    return null;
                }
                List list = (List) n3.f304b;
                Objects.requireNonNull(list);
                if (z) {
                    Uri[] uriArr = new Uri[list.size()];
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        uriArr[i4] = Uri.parse((String) list.get(i4));
                    }
                    valueCallback.onReceiveValue(uriArr);
                    return null;
                }
                return null;
            }
        };
        M m3 = new M(0, lVar);
        C0030i c0030i = this.f330b;
        c0030i.getClass();
        T2.h.e(webView, "webViewArg");
        T2.h.e(fileChooserParams, "paramsArg");
        L l3 = c0030i.f401a;
        l3.getClass();
        if (!((C0024c) l3.f297g).d(this)) {
            lVar.f(new N(k3.b.f(new C0022a("missing-instance-error", "Callback to `WebChromeClient.onShowFileChooser` failed because native instance was not in the instance manager.", ""))));
            return z;
        }
        new P1.y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser", l3.b(), null).v(I2.f.C(this, webView, fileChooserParams), new F(m3, 2));
        return z;
    }
}
