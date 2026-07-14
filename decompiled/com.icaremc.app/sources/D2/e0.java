package D2;

import a.AbstractC0141a;
import android.app.Activity;
import android.content.Context;
import f1.AbstractC0286a;
import java.util.HashMap;
import o.B1;
import p2.InterfaceC0586a;
import q1.AbstractC0602b;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;

/* loaded from: classes.dex */
public class e0 implements o2.c, InterfaceC0586a {

    /* renamed from: f, reason: collision with root package name */
    public o2.b f383f;

    /* renamed from: g, reason: collision with root package name */
    public L f384g;

    @Override // p2.InterfaceC0586a
    public final void onAttachedToActivity(p2.b bVar) {
        L l3 = this.f384g;
        if (l3 != null) {
            l3.f299i = (Activity) ((B1) bVar).f5414f;
        }
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        this.f383f = bVar;
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        Context context = bVar.f5785a;
        L l3 = new L(interfaceC0634f, context, new C0039s(context.getAssets(), bVar.f5789e));
        this.f384g = l3;
        io.flutter.plugin.platform.h hVar = bVar.f5788d;
        C0041u c0041u = new C0041u((C0024c) l3.f297g);
        HashMap hashMap = (HashMap) ((io.flutter.plugin.platform.p) hVar).f4350g;
        if (!hashMap.containsKey("plugins.flutter.io/webview")) {
            hashMap.put("plugins.flutter.io/webview", c0041u);
        }
        L l4 = this.f384g;
        l4.getClass();
        H2.g gVar = C0026e.f381b;
        InterfaceC0634f interfaceC0634f2 = (InterfaceC0634f) l4.f296f;
        android.support.v4.media.session.a.v(interfaceC0634f2, (C0024c) l4.f297g);
        AbstractC0602b.R(interfaceC0634f2, new C0034m(l4, 0));
        AbstractC0286a.I(interfaceC0634f2, new C0030i(l4, 7));
        android.support.v4.media.session.a.x(interfaceC0634f2, new C0034m(l4, 5));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.pigeon_defaultConstructor", l4.b(), null).w(new C2.c(13, new C0034m(l4, 2)));
        C0034m c0034m = new C0034m(l4, 6);
        InterfaceC0640l b4 = l4.b();
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_defaultConstructor", b4, null).w(new J(1, c0034m));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.setSynchronousReturnValueForShouldOverrideUrlLoading", b4, null).w(new K(8, c0034m));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.DownloadListener.pigeon_defaultConstructor", l4.b(), null).w(new C2.c(8, new C0030i(l4, 1)));
        AbstractC0141a.E(interfaceC0634f2, new C0030i(l4, 5));
        AbstractC0141a.F(interfaceC0634f2, new C0034m(l4, 1));
        C0030i c0030i = new C0030i(l4, 6);
        InterfaceC0640l b5 = l4.b();
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.WebStorage.instance", b5, null).w(new C2.c(28, c0030i));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.WebStorage.deleteAllData", b5, null).w(new A1.c(22, c0030i));
        Object obj = new Object();
        InterfaceC0640l b6 = l4.b();
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.grant", b6, null).w(new A1.c(9, obj));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.deny", b6, null).w(new A1.c(10, obj));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.onCustomViewHidden", l4.b(), null).w(new A1.c(5, new Object()));
        AbstractC0602b.S(interfaceC0634f2, new C0034m(l4, 4));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.invoke", l4.b(), null).w(new A1.c(7, new Object()));
        android.support.v4.media.session.a.w(interfaceC0634f2, new C0030i(l4, 2));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.sendToTarget", l4.b(), null).w(new A1.c(3, new Object()));
        k3.b.y(interfaceC0634f2, new C0030i(l4, 0));
        Object obj2 = new Object();
        InterfaceC0640l b7 = l4.b();
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.cancel", b7, null).w(new A1.c(12, obj2));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.proceed", b7, null).w(new A1.c(13, obj2));
        C0030i c0030i2 = new C0030i(l4, 4);
        InterfaceC0640l b8 = l4.b();
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.SslError.getPrimaryError", b8, null).w(new A1.c(11, c0030i2));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.SslError.hasError", b8, null).w(new C2.c(19, c0030i2));
        k3.b.z(interfaceC0634f2, new C0030i(l4, 3));
        AbstractC0286a.J(interfaceC0634f2, new C0034m(l4, 3));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.Certificate.getEncoded", l4.b(), null).w(new A1.c(4, new Object()));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.WebSettingsCompat.setPaymentRequestEnabled", l4.b(), null).w(new A1.c(21, new Object()));
        new P1.y(interfaceC0634f2, "dev.flutter.pigeon.webview_flutter_android.WebViewFeature.isFeatureSupported", l4.b(), null).w(new K(9, new Object()));
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivity() {
        this.f384g.f299i = this.f383f.f5785a;
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivityForConfigChanges() {
        this.f384g.f299i = this.f383f.f5785a;
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        L l3 = this.f384g;
        if (l3 != null) {
            H2.g gVar = C0026e.f381b;
            InterfaceC0634f interfaceC0634f = (InterfaceC0634f) l3.f296f;
            android.support.v4.media.session.a.v(interfaceC0634f, null);
            AbstractC0602b.R(interfaceC0634f, null);
            AbstractC0286a.I(interfaceC0634f, null);
            android.support.v4.media.session.a.x(interfaceC0634f, null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.pigeon_defaultConstructor", new A2.A(2), null).w(null);
            A2.A a4 = new A2.A(2);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_defaultConstructor", a4, null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.setSynchronousReturnValueForShouldOverrideUrlLoading", a4, null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.DownloadListener.pigeon_defaultConstructor", new A2.A(2), null).w(null);
            AbstractC0141a.E(interfaceC0634f, null);
            AbstractC0141a.F(interfaceC0634f, null);
            A2.A a5 = new A2.A(2);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebStorage.instance", a5, null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebStorage.deleteAllData", a5, null).w(null);
            A2.A a6 = new A2.A(2);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.grant", a6, null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.deny", a6, null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.onCustomViewHidden", new A2.A(2), null).w(null);
            AbstractC0602b.S(interfaceC0634f, null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.invoke", new A2.A(2), null).w(null);
            android.support.v4.media.session.a.w(interfaceC0634f, null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.sendToTarget", new A2.A(2), null).w(null);
            k3.b.y(interfaceC0634f, null);
            A2.A a7 = new A2.A(2);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.cancel", a7, null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.proceed", a7, null).w(null);
            A2.A a8 = new A2.A(2);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslError.getPrimaryError", a8, null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.SslError.hasError", a8, null).w(null);
            k3.b.z(interfaceC0634f, null);
            AbstractC0286a.J(interfaceC0634f, null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.Certificate.getEncoded", new A2.A(2), null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebSettingsCompat.setPaymentRequestEnabled", new A2.A(2), null).w(null);
            new P1.y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.WebViewFeature.isFeatureSupported", new A2.A(2), null).w(null);
            C0024c c0024c = (C0024c) this.f384g.f297g;
            c0024c.f368g.removeCallbacks(c0024c.f369h);
            c0024c.f371j = true;
            this.f384g = null;
        }
    }

    @Override // p2.InterfaceC0586a
    public final void onReattachedToActivityForConfigChanges(p2.b bVar) {
        this.f384g.f299i = (Activity) ((B1) bVar).f5414f;
    }
}
