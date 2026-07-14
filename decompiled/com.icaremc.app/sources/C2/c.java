package C2;

import D2.C0022a;
import D2.C0024c;
import D2.C0027f;
import D2.C0029h;
import D2.C0030i;
import D2.C0034m;
import D2.C0038q;
import D2.C0042v;
import D2.O;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.WebStorage;
import io.flutter.plugin.platform.s;
import java.util.List;
import s2.InterfaceC0630b;
import s2.InterfaceC0631c;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements InterfaceC0631c, InterfaceC0630b {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f260f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f261g;

    public /* synthetic */ c(int i4, Object obj) {
        this.f260f = i4;
        this.f261g = obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0098. Please report as an issue. */
    @Override // s2.InterfaceC0630b
    public void f(Object obj, s sVar) {
        List C3;
        List C4;
        List C5;
        List C6;
        switch (this.f260f) {
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                C0030i c0030i = (C0030i) this.f261g;
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj2 = ((List) obj).get(0);
                T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                try {
                    ((C0024c) c0030i.f401a.f297g).a(((Long) obj2).longValue(), new C0038q(c0030i));
                    C3 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th) {
                    if (th instanceof C0022a) {
                        C0022a c0022a = th;
                        C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                    } else {
                        C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                    }
                }
                sVar.t(C3);
                return;
            case 13:
                C0034m c0034m = (C0034m) this.f261g;
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list = (List) obj;
                Object obj3 = list.get(0);
                T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                long longValue = ((Long) obj3).longValue();
                Object obj4 = list.get(1);
                T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                try {
                    ((C0024c) c0034m.f416a.f297g).a(longValue, new C0042v((String) obj4, c0034m));
                    C4 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th2) {
                    if (th2 instanceof C0022a) {
                        C0022a c0022a2 = th2;
                        C4 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                    } else {
                        C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                    }
                }
                sVar.t(C4);
                return;
            case 19:
                C0030i c0030i2 = (C0030i) this.f261g;
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list2 = (List) obj;
                int i4 = 0;
                Object obj5 = list2.get(0);
                T2.h.c(obj5, "null cannot be cast to non-null type android.net.http.SslError");
                SslError sslError = (SslError) obj5;
                Object obj6 = list2.get(1);
                T2.h.c(obj6, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.SslErrorType");
                O o3 = (O) obj6;
                try {
                } catch (Throwable th3) {
                    if (th3 instanceof C0022a) {
                        C0022a c0022a3 = th3;
                        C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                    } else {
                        C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                    }
                }
                switch (o3.ordinal()) {
                    case 0:
                        i4 = 4;
                        C5 = android.support.v4.media.session.a.p(Boolean.valueOf(sslError.hasError(i4)));
                        sVar.t(C5);
                        return;
                    case 1:
                        i4 = 1;
                        C5 = android.support.v4.media.session.a.p(Boolean.valueOf(sslError.hasError(i4)));
                        sVar.t(C5);
                        return;
                    case 2:
                        i4 = 2;
                        C5 = android.support.v4.media.session.a.p(Boolean.valueOf(sslError.hasError(i4)));
                        sVar.t(C5);
                        return;
                    case 3:
                        i4 = 5;
                        C5 = android.support.v4.media.session.a.p(Boolean.valueOf(sslError.hasError(i4)));
                        sVar.t(C5);
                        return;
                    case 4:
                        C5 = android.support.v4.media.session.a.p(Boolean.valueOf(sslError.hasError(i4)));
                        sVar.t(C5);
                        return;
                    case 5:
                        i4 = 3;
                        C5 = android.support.v4.media.session.a.p(Boolean.valueOf(sslError.hasError(i4)));
                        sVar.t(C5);
                        return;
                    case 6:
                        c0030i2.f401a.getClass();
                        throw new IllegalArgumentException(o3 + " doesn't represent a native value.");
                    default:
                        i4 = -1;
                        C5 = android.support.v4.media.session.a.p(Boolean.valueOf(sslError.hasError(i4)));
                        sVar.t(C5);
                        return;
                }
            default:
                C0030i c0030i3 = (C0030i) this.f261g;
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj7 = ((List) obj).get(0);
                T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Long");
                try {
                    ((C0024c) c0030i3.f401a.f297g).a(((Long) obj7).longValue(), WebStorage.getInstance());
                    C6 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th4) {
                    if (th4 instanceof C0022a) {
                        C0022a c0022a4 = th4;
                        C6 = I2.f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                    } else {
                        C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                    }
                }
                sVar.t(C6);
                return;
        }
    }

    @Override // s2.InterfaceC0631c
    public void t(Object obj) {
        switch (this.f260f) {
            case 1:
                long j4 = ((C0029h) this.f261g).f396g;
                if (obj instanceof List) {
                    List list = (List) obj;
                    if (list.size() > 1) {
                        Object obj2 = list.get(0);
                        T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                        Object obj3 = list.get(1);
                        T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj2, (String) obj3, (String) list.get(2)));
                        Log.e("PigeonProxyApiRegistrar", "Failed to remove Dart strong reference with identifier: " + j4);
                        return;
                    }
                    return;
                }
                k3.b.f(new C0022a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference'.", ""));
                Log.e("PigeonProxyApiRegistrar", "Failed to remove Dart strong reference with identifier: " + j4);
                return;
            case 2:
                Object obj4 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list2 = (List) obj;
                    if (list2.size() > 1) {
                        Object obj5 = list2.get(0);
                        T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                        Object obj6 = list2.get(1);
                        T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj5, (String) obj6, (String) list2.get(2)), "AndroidMessage", obj4);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance'.", "", "AndroidMessage", obj4);
                return;
            case 3:
                Object obj7 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list3 = (List) obj;
                    if (list3.size() > 1) {
                        Object obj8 = list3.get(0);
                        T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                        Object obj9 = list3.get(1);
                        T2.h.c(obj9, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj8, (String) obj9, (String) list3.get(2)), "Certificate", obj7);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.Certificate.pigeon_newInstance'.", "", "Certificate", obj7);
                return;
            case 4:
                Object obj10 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list4 = (List) obj;
                    if (list4.size() > 1) {
                        Object obj11 = list4.get(0);
                        T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                        Object obj12 = list4.get(1);
                        T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj11, (String) obj12, (String) list4.get(2)), "ClientCertRequest", obj10);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.pigeon_newInstance'.", "", "ClientCertRequest", obj10);
                return;
            case 5:
                Object obj13 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list5 = (List) obj;
                    if (list5.size() > 1) {
                        Object obj14 = list5.get(0);
                        T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                        Object obj15 = list5.get(1);
                        T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj14, (String) obj15, (String) list5.get(2)), "ConsoleMessage", obj13);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.ConsoleMessage.pigeon_newInstance'.", "", "ConsoleMessage", obj13);
                return;
            case 6:
                Object obj16 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list6 = (List) obj;
                    if (list6.size() > 1) {
                        Object obj17 = list6.get(0);
                        T2.h.c(obj17, "null cannot be cast to non-null type kotlin.String");
                        Object obj18 = list6.get(1);
                        T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj17, (String) obj18, (String) list6.get(2)), "CookieManager", obj16);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.CookieManager.pigeon_newInstance'.", "", "CookieManager", obj16);
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                Object obj19 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list7 = (List) obj;
                    if (list7.size() > 1) {
                        Object obj20 = list7.get(0);
                        T2.h.c(obj20, "null cannot be cast to non-null type kotlin.String");
                        Object obj21 = list7.get(1);
                        T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj20, (String) obj21, (String) list7.get(2)), "CustomViewCallback", obj19);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.pigeon_newInstance'.", "", "CustomViewCallback", obj19);
                return;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
            case 13:
            case 19:
            default:
                Object obj22 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list8 = (List) obj;
                    if (list8.size() > 1) {
                        Object obj23 = list8.get(0);
                        T2.h.c(obj23, "null cannot be cast to non-null type kotlin.String");
                        Object obj24 = list8.get(1);
                        T2.h.c(obj24, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj23, (String) obj24, (String) list8.get(2)), "WebView", obj22);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_newInstance'.", "", "WebView", obj22);
                return;
            case 9:
                Object obj25 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list9 = (List) obj;
                    if (list9.size() > 1) {
                        Object obj26 = list9.get(0);
                        T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                        Object obj27 = list9.get(1);
                        T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj26, (String) obj27, (String) list9.get(2)), "FileChooserParams", obj25);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.FileChooserParams.pigeon_newInstance'.", "", "FileChooserParams", obj25);
                return;
            case 10:
                Object obj28 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list10 = (List) obj;
                    if (list10.size() > 1) {
                        Object obj29 = list10.get(0);
                        T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                        Object obj30 = list10.get(1);
                        T2.h.c(obj30, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj29, (String) obj30, (String) list10.get(2)), "FlutterAssetManager", obj28);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.pigeon_newInstance'.", "", "FlutterAssetManager", obj28);
                return;
            case 11:
                Object obj31 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list11 = (List) obj;
                    if (list11.size() > 1) {
                        Object obj32 = list11.get(0);
                        T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                        Object obj33 = list11.get(1);
                        T2.h.c(obj33, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj32, (String) obj33, (String) list11.get(2)), "GeolocationPermissionsCallback", obj31);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.pigeon_newInstance'.", "", "GeolocationPermissionsCallback", obj31);
                return;
            case 12:
                Object obj34 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list12 = (List) obj;
                    if (list12.size() > 1) {
                        Object obj35 = list12.get(0);
                        T2.h.c(obj35, "null cannot be cast to non-null type kotlin.String");
                        Object obj36 = list12.get(1);
                        T2.h.c(obj36, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj35, (String) obj36, (String) list12.get(2)), "HttpAuthHandler", obj34);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.pigeon_newInstance'.", "", "HttpAuthHandler", obj34);
                return;
            case 14:
                Object obj37 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list13 = (List) obj;
                    if (list13.size() > 1) {
                        Object obj38 = list13.get(0);
                        T2.h.c(obj38, "null cannot be cast to non-null type kotlin.String");
                        Object obj39 = list13.get(1);
                        T2.h.c(obj39, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj38, (String) obj39, (String) list13.get(2)), "PermissionRequest", obj37);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.PermissionRequest.pigeon_newInstance'.", "", "PermissionRequest", obj37);
                return;
            case 15:
                Object obj40 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list14 = (List) obj;
                    if (list14.size() > 1) {
                        Object obj41 = list14.get(0);
                        T2.h.c(obj41, "null cannot be cast to non-null type kotlin.String");
                        Object obj42 = list14.get(1);
                        T2.h.c(obj42, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj41, (String) obj42, (String) list14.get(2)), "PrivateKey", obj40);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.PrivateKey.pigeon_newInstance'.", "", "PrivateKey", obj40);
                return;
            case 16:
                Object obj43 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list15 = (List) obj;
                    if (list15.size() > 1) {
                        Object obj44 = list15.get(0);
                        T2.h.c(obj44, "null cannot be cast to non-null type kotlin.String");
                        Object obj45 = list15.get(1);
                        T2.h.c(obj45, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj44, (String) obj45, (String) list15.get(2)), "SslCertificate", obj43);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.SslCertificate.pigeon_newInstance'.", "", "SslCertificate", obj43);
                return;
            case 17:
                Object obj46 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list16 = (List) obj;
                    if (list16.size() > 1) {
                        Object obj47 = list16.get(0);
                        T2.h.c(obj47, "null cannot be cast to non-null type kotlin.String");
                        Object obj48 = list16.get(1);
                        T2.h.c(obj48, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj47, (String) obj48, (String) list16.get(2)), "SslCertificateDName", obj46);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.pigeon_newInstance'.", "", "SslCertificateDName", obj46);
                return;
            case 18:
                Object obj49 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list17 = (List) obj;
                    if (list17.size() > 1) {
                        Object obj50 = list17.get(0);
                        T2.h.c(obj50, "null cannot be cast to non-null type kotlin.String");
                        Object obj51 = list17.get(1);
                        T2.h.c(obj51, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj50, (String) obj51, (String) list17.get(2)), "SslError", obj49);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.SslError.pigeon_newInstance'.", "", "SslError", obj49);
                return;
            case 20:
                Object obj52 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list18 = (List) obj;
                    if (list18.size() > 1) {
                        Object obj53 = list18.get(0);
                        T2.h.c(obj53, "null cannot be cast to non-null type kotlin.String");
                        Object obj54 = list18.get(1);
                        T2.h.c(obj54, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj53, (String) obj54, (String) list18.get(2)), "SslErrorHandler", obj52);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.pigeon_newInstance'.", "", "SslErrorHandler", obj52);
                return;
            case 21:
                Object obj55 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list19 = (List) obj;
                    if (list19.size() > 1) {
                        Object obj56 = list19.get(0);
                        T2.h.c(obj56, "null cannot be cast to non-null type kotlin.String");
                        Object obj57 = list19.get(1);
                        T2.h.c(obj57, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj56, (String) obj57, (String) list19.get(2)), "View", obj55);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.View.pigeon_newInstance'.", "", "View", obj55);
                return;
            case 22:
                Object obj58 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list20 = (List) obj;
                    if (list20.size() > 1) {
                        Object obj59 = list20.get(0);
                        T2.h.c(obj59, "null cannot be cast to non-null type kotlin.String");
                        Object obj60 = list20.get(1);
                        T2.h.c(obj60, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj59, (String) obj60, (String) list20.get(2)), "WebResourceError", obj58);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebResourceError.pigeon_newInstance'.", "", "WebResourceError", obj58);
                return;
            case 23:
                Object obj61 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list21 = (List) obj;
                    if (list21.size() > 1) {
                        Object obj62 = list21.get(0);
                        T2.h.c(obj62, "null cannot be cast to non-null type kotlin.String");
                        Object obj63 = list21.get(1);
                        T2.h.c(obj63, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj62, (String) obj63, (String) list21.get(2)), "WebResourceErrorCompat", obj61);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebResourceErrorCompat.pigeon_newInstance'.", "", "WebResourceErrorCompat", obj61);
                return;
            case 24:
                Object obj64 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list22 = (List) obj;
                    if (list22.size() > 1) {
                        Object obj65 = list22.get(0);
                        T2.h.c(obj65, "null cannot be cast to non-null type kotlin.String");
                        Object obj66 = list22.get(1);
                        T2.h.c(obj66, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj65, (String) obj66, (String) list22.get(2)), "WebResourceRequest", obj64);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance'.", "", "WebResourceRequest", obj64);
                return;
            case 25:
                Object obj67 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list23 = (List) obj;
                    if (list23.size() > 1) {
                        Object obj68 = list23.get(0);
                        T2.h.c(obj68, "null cannot be cast to non-null type kotlin.String");
                        Object obj69 = list23.get(1);
                        T2.h.c(obj69, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj68, (String) obj69, (String) list23.get(2)), "WebResourceResponse", obj67);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebResourceResponse.pigeon_newInstance'.", "", "WebResourceResponse", obj67);
                return;
            case 26:
                Object obj70 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list24 = (List) obj;
                    if (list24.size() > 1) {
                        Object obj71 = list24.get(0);
                        T2.h.c(obj71, "null cannot be cast to non-null type kotlin.String");
                        Object obj72 = list24.get(1);
                        T2.h.c(obj72, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj71, (String) obj72, (String) list24.get(2)), "WebSettings", obj70);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebSettings.pigeon_newInstance'.", "", "WebSettings", obj70);
                return;
            case 27:
                Object obj73 = ((C0027f) this.f261g).f386g;
                if (obj instanceof List) {
                    List list25 = (List) obj;
                    if (list25.size() > 1) {
                        Object obj74 = list25.get(0);
                        T2.h.c(obj74, "null cannot be cast to non-null type kotlin.String");
                        Object obj75 = list25.get(1);
                        T2.h.c(obj75, "null cannot be cast to non-null type kotlin.String");
                        A2.i.n(new C0022a((String) obj74, (String) obj75, (String) list25.get(2)), "WebStorage", obj73);
                        return;
                    }
                    return;
                }
                A2.i.q("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebStorage.pigeon_newInstance'.", "", "WebStorage", obj73);
                return;
        }
    }
}
