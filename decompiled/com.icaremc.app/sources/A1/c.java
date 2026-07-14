package A1;

import A2.i;
import D2.C0022a;
import D2.O;
import D2.W;
import D2.d0;
import D2.h0;
import I0.h;
import I2.f;
import R.j;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import com.google.firebase.datatransport.TransportRegistrar;
import io.flutter.plugin.platform.s;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import p0.q;
import q0.x;
import s2.InterfaceC0630b;
import s2.InterfaceC0631c;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements x1.c, InterfaceC0630b, InterfaceC0631c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f48f;

    public /* synthetic */ c(int i4) {
        this.f48f = i4;
    }

    @Override // x1.c
    public Object a(h hVar) {
        switch (this.f48f) {
            case 0:
                return TransportRegistrar.c(hVar);
            case 1:
                return TransportRegistrar.b(hVar);
            default:
                return TransportRegistrar.a(hVar);
        }
    }

    @Override // s2.InterfaceC0630b
    public void f(Object obj, s sVar) {
        List C3;
        List C4;
        List C5;
        List C6;
        List C7;
        List C8;
        List C9;
        O o3;
        List C10;
        List C11;
        List C12;
        List C13;
        switch (this.f48f) {
            case 3:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj2 = ((List) obj).get(0);
                T2.h.c(obj2, "null cannot be cast to non-null type android.os.Message");
                try {
                    ((Message) obj2).sendToTarget();
                    C3 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th) {
                    if (th instanceof C0022a) {
                        C0022a c0022a = th;
                        C3 = f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                    } else {
                        C3 = f.C(th.getClass().getSimpleName(), th.toString(), i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                    }
                }
                sVar.t(C3);
                return;
            case 4:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj3 = ((List) obj).get(0);
                T2.h.c(obj3, "null cannot be cast to non-null type java.security.cert.Certificate");
                try {
                    try {
                        C4 = android.support.v4.media.session.a.p(((Certificate) obj3).getEncoded());
                    } catch (Throwable th2) {
                        if (th2 instanceof C0022a) {
                            C0022a c0022a2 = th2;
                            C4 = f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                        } else {
                            C4 = f.C(th2.getClass().getSimpleName(), th2.toString(), i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                        }
                    }
                    sVar.t(C4);
                    return;
                } catch (CertificateEncodingException e4) {
                    throw new RuntimeException(e4);
                }
            case 5:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj4 = ((List) obj).get(0);
                T2.h.c(obj4, "null cannot be cast to non-null type android.webkit.WebChromeClient.CustomViewCallback");
                try {
                    ((WebChromeClient.CustomViewCallback) obj4).onCustomViewHidden();
                    C5 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th3) {
                    if (th3 instanceof C0022a) {
                        C0022a c0022a3 = th3;
                        C5 = f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                    } else {
                        C5 = f.C(th3.getClass().getSimpleName(), th3.toString(), i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                    }
                }
                sVar.t(C5);
                return;
            case 6:
            case j.BYTES_FIELD_NUMBER /* 8 */:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            default:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj5 = ((List) obj).get(0);
                T2.h.c(obj5, "null cannot be cast to non-null type android.webkit.WebStorage");
                try {
                    ((WebStorage) obj5).deleteAllData();
                    C13 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th4) {
                    if (th4 instanceof C0022a) {
                        C0022a c0022a4 = th4;
                        C13 = f.C(c0022a4.f349f, c0022a4.f350g, c0022a4.f351h);
                    } else {
                        C13 = f.C(th4.getClass().getSimpleName(), th4.toString(), i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                    }
                }
                sVar.t(C13);
                return;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list = (List) obj;
                Object obj6 = list.get(0);
                T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.GeolocationPermissions.Callback");
                GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback) obj6;
                Object obj7 = list.get(1);
                T2.h.c(obj7, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj7;
                Object obj8 = list.get(2);
                T2.h.c(obj8, "null cannot be cast to non-null type kotlin.Boolean");
                boolean booleanValue = ((Boolean) obj8).booleanValue();
                Object obj9 = list.get(3);
                T2.h.c(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                try {
                    callback.invoke(str, booleanValue, ((Boolean) obj9).booleanValue());
                    C6 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th5) {
                    if (th5 instanceof C0022a) {
                        C0022a c0022a5 = th5;
                        C6 = f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                    } else {
                        C6 = f.C(th5.getClass().getSimpleName(), th5.toString(), i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                    }
                }
                sVar.t(C6);
                return;
            case 9:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list2 = (List) obj;
                Object obj10 = list2.get(0);
                T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.PermissionRequest");
                PermissionRequest permissionRequest = (PermissionRequest) obj10;
                Object obj11 = list2.get(1);
                T2.h.c(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                try {
                    permissionRequest.grant((String[]) ((List) obj11).toArray(new String[0]));
                    C7 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th6) {
                    if (th6 instanceof C0022a) {
                        C0022a c0022a6 = th6;
                        C7 = f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                    } else {
                        C7 = f.C(th6.getClass().getSimpleName(), th6.toString(), i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                    }
                }
                sVar.t(C7);
                return;
            case 10:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj12 = ((List) obj).get(0);
                T2.h.c(obj12, "null cannot be cast to non-null type android.webkit.PermissionRequest");
                try {
                    ((PermissionRequest) obj12).deny();
                    C8 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th7) {
                    if (th7 instanceof C0022a) {
                        C0022a c0022a7 = th7;
                        C8 = f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                    } else {
                        C8 = f.C(th7.getClass().getSimpleName(), th7.toString(), i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                    }
                }
                sVar.t(C8);
                return;
            case 11:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj13 = ((List) obj).get(0);
                T2.h.c(obj13, "null cannot be cast to non-null type android.net.http.SslError");
                try {
                    int primaryError = ((SslError) obj13).getPrimaryError();
                    if (primaryError != 0) {
                        if (primaryError != 1) {
                            if (primaryError != 2) {
                                if (primaryError != 3) {
                                    if (primaryError != 4) {
                                        if (primaryError != 5) {
                                            o3 = O.UNKNOWN;
                                        } else {
                                            o3 = O.INVALID;
                                        }
                                    } else {
                                        o3 = O.DATE_INVALID;
                                    }
                                } else {
                                    o3 = O.UNTRUSTED;
                                }
                            } else {
                                o3 = O.ID_MISMATCH;
                            }
                        } else {
                            o3 = O.EXPIRED;
                        }
                    } else {
                        o3 = O.NOT_YET_VALID;
                    }
                    C9 = android.support.v4.media.session.a.p(o3);
                } catch (Throwable th8) {
                    if (th8 instanceof C0022a) {
                        C0022a c0022a8 = th8;
                        C9 = f.C(c0022a8.f349f, c0022a8.f350g, c0022a8.f351h);
                    } else {
                        C9 = f.C(th8.getClass().getSimpleName(), th8.toString(), i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                    }
                }
                sVar.t(C9);
                return;
            case 12:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj14 = ((List) obj).get(0);
                T2.h.c(obj14, "null cannot be cast to non-null type android.webkit.SslErrorHandler");
                try {
                    ((SslErrorHandler) obj14).cancel();
                    C10 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th9) {
                    if (th9 instanceof C0022a) {
                        C0022a c0022a9 = th9;
                        C10 = f.C(c0022a9.f349f, c0022a9.f350g, c0022a9.f351h);
                    } else {
                        C10 = f.C(th9.getClass().getSimpleName(), th9.toString(), i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                    }
                }
                sVar.t(C10);
                return;
            case 13:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj15 = ((List) obj).get(0);
                T2.h.c(obj15, "null cannot be cast to non-null type android.webkit.SslErrorHandler");
                try {
                    ((SslErrorHandler) obj15).proceed();
                    C11 = android.support.v4.media.session.a.p(null);
                } catch (Throwable th10) {
                    if (th10 instanceof C0022a) {
                        C0022a c0022a10 = th10;
                        C11 = f.C(c0022a10.f349f, c0022a10.f350g, c0022a10.f351h);
                    } else {
                        C11 = f.C(th10.getClass().getSimpleName(), th10.toString(), i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                    }
                }
                sVar.t(C11);
                return;
            case 21:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list3 = (List) obj;
                Object obj16 = list3.get(0);
                T2.h.c(obj16, "null cannot be cast to non-null type android.webkit.WebSettings");
                WebSettings webSettings = (WebSettings) obj16;
                Object obj17 = list3.get(1);
                T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                boolean booleanValue2 = ((Boolean) obj17).booleanValue();
                try {
                } catch (Throwable th11) {
                    if (th11 instanceof C0022a) {
                        C0022a c0022a11 = th11;
                        C12 = f.C(c0022a11.f349f, c0022a11.f350g, c0022a11.f351h);
                    } else {
                        C12 = f.C(th11.getClass().getSimpleName(), th11.toString(), i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                    }
                }
                if (x.f5906K.b()) {
                    q.a(webSettings).n(booleanValue2);
                    C12 = android.support.v4.media.session.a.p(null);
                    sVar.t(C12);
                    return;
                }
                throw x.a();
        }
    }

    @Override // s2.InterfaceC0631c
    public void t(Object obj) {
        switch (this.f48f) {
            case 6:
                if (obj instanceof List) {
                    List list = (List) obj;
                    if (list.size() > 1) {
                        Object obj2 = list.get(0);
                        T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                        Object obj3 = list.get(1);
                        T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj2, (String) obj3, (String) list.get(2)));
                        return;
                    }
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.DownloadListener.onDownloadStart'.", "");
                return;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 21:
            case 22:
            default:
                if (obj instanceof List) {
                    List list2 = (List) obj;
                    if (list2.size() > 1) {
                        Object obj4 = list2.get(0);
                        T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                        Object obj5 = list2.get(1);
                        T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj4, (String) obj5, (String) list2.get(2)));
                        int i4 = d0.f378c;
                        return;
                    }
                    int i5 = d0.f378c;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.requestLoading'.", "");
                int i6 = d0.f378c;
                return;
            case j.BYTES_FIELD_NUMBER /* 8 */:
                if (obj instanceof List) {
                    List list3 = (List) obj;
                    if (list3.size() > 1) {
                        Object obj6 = list3.get(0);
                        T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                        Object obj7 = list3.get(1);
                        T2.h.c(obj7, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj6, (String) obj7, (String) list3.get(2)));
                        return;
                    }
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.postMessage'.", "");
                return;
            case 14:
                if (obj instanceof List) {
                    List list4 = (List) obj;
                    if (list4.size() > 1) {
                        Object obj8 = list4.get(0);
                        T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                        Object obj9 = list4.get(1);
                        T2.h.c(obj9, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj8, (String) obj9, (String) list4.get(2)));
                        int i7 = W.f329h;
                        return;
                    }
                    int i8 = W.f329h;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView'.", "");
                int i9 = W.f329h;
                return;
            case 15:
                if (obj instanceof List) {
                    List list5 = (List) obj;
                    if (list5.size() > 1) {
                        Object obj10 = list5.get(0);
                        T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                        Object obj11 = list5.get(1);
                        T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj10, (String) obj11, (String) list5.get(2)));
                        int i10 = W.f329h;
                        return;
                    }
                    int i11 = W.f329h;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged'.", "");
                int i12 = W.f329h;
                return;
            case 16:
                if (obj instanceof List) {
                    List list6 = (List) obj;
                    if (list6.size() > 1) {
                        Object obj12 = list6.get(0);
                        T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                        Object obj13 = list6.get(1);
                        T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj12, (String) obj13, (String) list6.get(2)));
                        int i13 = W.f329h;
                        return;
                    }
                    int i14 = W.f329h;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest'.", "");
                int i15 = W.f329h;
                return;
            case 17:
                if (obj instanceof List) {
                    List list7 = (List) obj;
                    if (list7.size() > 1) {
                        Object obj14 = list7.get(0);
                        T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                        Object obj15 = list7.get(1);
                        T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj14, (String) obj15, (String) list7.get(2)));
                        int i16 = W.f329h;
                        return;
                    }
                    int i17 = W.f329h;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView'.", "");
                int i18 = W.f329h;
                return;
            case 18:
                if (obj instanceof List) {
                    List list8 = (List) obj;
                    if (list8.size() > 1) {
                        Object obj16 = list8.get(0);
                        T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                        Object obj17 = list8.get(1);
                        T2.h.c(obj17, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj16, (String) obj17, (String) list8.get(2)));
                        int i19 = W.f329h;
                        return;
                    }
                    int i20 = W.f329h;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage'.", "");
                int i21 = W.f329h;
                return;
            case 19:
                if (obj instanceof List) {
                    List list9 = (List) obj;
                    if (list9.size() > 1) {
                        Object obj18 = list9.get(0);
                        T2.h.c(obj18, "null cannot be cast to non-null type kotlin.String");
                        Object obj19 = list9.get(1);
                        T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj18, (String) obj19, (String) list9.get(2)));
                        int i22 = W.f329h;
                        return;
                    }
                    int i23 = W.f329h;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt'.", "");
                int i24 = W.f329h;
                return;
            case 20:
                if (obj instanceof List) {
                    List list10 = (List) obj;
                    if (list10.size() > 1) {
                        Object obj20 = list10.get(0);
                        T2.h.c(obj20, "null cannot be cast to non-null type kotlin.String");
                        Object obj21 = list10.get(1);
                        T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj20, (String) obj21, (String) list10.get(2)));
                        int i25 = W.f329h;
                        return;
                    }
                    int i26 = W.f329h;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt'.", "");
                int i27 = W.f329h;
                return;
            case 23:
                if (obj instanceof List) {
                    List list11 = (List) obj;
                    if (list11.size() > 1) {
                        Object obj22 = list11.get(0);
                        T2.h.c(obj22, "null cannot be cast to non-null type kotlin.String");
                        Object obj23 = list11.get(1);
                        T2.h.c(obj23, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj22, (String) obj23, (String) list11.get(2)));
                        int i28 = h0.f397i;
                        return;
                    }
                    int i29 = h0.f397i;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebView.onScrollChanged'.", "");
                int i30 = h0.f397i;
                return;
            case 24:
                if (obj instanceof List) {
                    List list12 = (List) obj;
                    if (list12.size() > 1) {
                        Object obj24 = list12.get(0);
                        T2.h.c(obj24, "null cannot be cast to non-null type kotlin.String");
                        Object obj25 = list12.get(1);
                        T2.h.c(obj25, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj24, (String) obj25, (String) list12.get(2)));
                        int i31 = d0.f378c;
                        return;
                    }
                    int i32 = d0.f378c;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpError'.", "");
                int i33 = d0.f378c;
                return;
            case 25:
                if (obj instanceof List) {
                    List list13 = (List) obj;
                    if (list13.size() > 1) {
                        Object obj26 = list13.get(0);
                        T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                        Object obj27 = list13.get(1);
                        T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj26, (String) obj27, (String) list13.get(2)));
                        int i34 = d0.f378c;
                        return;
                    }
                    int i35 = d0.f378c;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onLoadResource'.", "");
                int i36 = d0.f378c;
                return;
            case 26:
                if (obj instanceof List) {
                    List list14 = (List) obj;
                    if (list14.size() > 1) {
                        Object obj28 = list14.get(0);
                        T2.h.c(obj28, "null cannot be cast to non-null type kotlin.String");
                        Object obj29 = list14.get(1);
                        T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj28, (String) obj29, (String) list14.get(2)));
                        int i37 = d0.f378c;
                        return;
                    }
                    int i38 = d0.f378c;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedLoginRequest'.", "");
                int i39 = d0.f378c;
                return;
            case 27:
                if (obj instanceof List) {
                    List list15 = (List) obj;
                    if (list15.size() > 1) {
                        Object obj30 = list15.get(0);
                        T2.h.c(obj30, "null cannot be cast to non-null type kotlin.String");
                        Object obj31 = list15.get(1);
                        T2.h.c(obj31, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj30, (String) obj31, (String) list15.get(2)));
                        int i40 = d0.f378c;
                        return;
                    }
                    int i41 = d0.f378c;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageStarted'.", "");
                int i42 = d0.f378c;
                return;
            case 28:
                if (obj instanceof List) {
                    List list16 = (List) obj;
                    if (list16.size() > 1) {
                        Object obj32 = list16.get(0);
                        T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                        Object obj33 = list16.get(1);
                        T2.h.c(obj33, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj32, (String) obj33, (String) list16.get(2)));
                        int i43 = d0.f378c;
                        return;
                    }
                    int i44 = d0.f378c;
                    return;
                }
                i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedClientCertRequest'.", "");
                int i45 = d0.f378c;
                return;
        }
    }

    public /* synthetic */ c(int i4, Object obj) {
        this.f48f = i4;
    }
}
