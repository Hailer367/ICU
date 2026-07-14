package D2;

import I.InterfaceC0066u;
import I.v0;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.WebViewClient;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import p0.AbstractC0565d;
import p1.AbstractC0579h;
import p1.C0585n;
import p1.InterfaceC0572a;
import s2.InterfaceC0630b;
import s2.InterfaceC0631c;

/* loaded from: classes.dex */
public final /* synthetic */ class K implements InterfaceC0631c, InterfaceC0630b, InterfaceC0066u, E2.c, x1.c, P0.f, InterfaceC0572a, V1.p {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f295f;

    public /* synthetic */ K(int i4) {
        this.f295f = i4;
    }

    @Override // x1.c
    public Object a(I0.h hVar) {
        switch (this.f295f) {
            case 15:
                return FirebaseInstallationsRegistrar.a(hVar);
            default:
                Set c4 = hVar.c(x1.o.a(R1.a.class));
                R1.c cVar = R1.c.f1530h;
                if (cVar == null) {
                    synchronized (R1.c.class) {
                        try {
                            cVar = R1.c.f1530h;
                            if (cVar == null) {
                                cVar = new R1.c(0);
                                R1.c.f1530h = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return new R1.b(c4, cVar);
        }
    }

    @Override // P0.f
    public Object apply(Object obj) {
        byte[] decode;
        Cursor rawQuery = ((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
        try {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                A2.t a4 = I0.j.a();
                a4.W(rawQuery.getString(1));
                a4.f101i = S0.a.b(rawQuery.getInt(2));
                String string = rawQuery.getString(3);
                if (string == null) {
                    decode = null;
                } else {
                    decode = Base64.decode(string, 0);
                }
                a4.f100h = decode;
                arrayList.add(a4.x());
            }
            return arrayList;
        } finally {
            rawQuery.close();
        }
    }

    @Override // p1.InterfaceC0572a
    public Object b(AbstractC0579h abstractC0579h) {
        int i4;
        Object obj;
        switch (this.f295f) {
            case 17:
                i4 = 403;
                break;
            case 18:
                i4 = -1;
                break;
            default:
                C0585n c0585n = (C0585n) abstractC0579h;
                synchronized (c0585n.f5832a) {
                    if (c0585n.f5834c) {
                        if (!c0585n.f5835d) {
                            if (!IOException.class.isInstance(c0585n.f5837f)) {
                                Exception exc = c0585n.f5837f;
                                if (exc == null) {
                                    obj = c0585n.f5836e;
                                } else {
                                    throw new RuntimeException(exc);
                                }
                            } else {
                                throw ((Throwable) IOException.class.cast(c0585n.f5837f));
                            }
                        } else {
                            throw new CancellationException("Task is already canceled.");
                        }
                    } else {
                        throw new IllegalStateException("Task is not yet complete");
                    }
                }
                Bundle bundle = (Bundle) obj;
                if (bundle != null) {
                    String string = bundle.getString("registration_id");
                    if (string != null || (string = bundle.getString("unregistered")) != null) {
                        return string;
                    }
                    String string2 = bundle.getString("error");
                    if (!"RST".equals(string2)) {
                        if (string2 != null) {
                            throw new IOException(string2);
                        }
                        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
                        throw new IOException("SERVICE_NOT_AVAILABLE");
                    }
                    throw new IOException("INSTANCE_ID_RESET");
                }
                throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        return Integer.valueOf(i4);
    }

    @Override // E2.c
    public boolean c(View view) {
        return view.hasFocus();
    }

    @Override // I.InterfaceC0066u
    public v0 d(View view, v0 v0Var) {
        return v0Var;
    }

    @Override // s2.InterfaceC0630b
    public void f(Object obj, io.flutter.plugin.platform.s sVar) {
        List C3;
        List C4;
        switch (this.f295f) {
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list = (List) obj;
                Object obj2 = list.get(0);
                T2.h.c(obj2, "null cannot be cast to non-null type android.webkit.WebViewClient");
                WebViewClient webViewClient = (WebViewClient) obj2;
                Object obj3 = list.get(1);
                T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                boolean booleanValue = ((Boolean) obj3).booleanValue();
                try {
                } catch (Throwable th) {
                    if (th instanceof C0022a) {
                        C0022a c0022a = th;
                        C3 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                    } else {
                        C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                    }
                }
                if (webViewClient instanceof d0) {
                    ((d0) webViewClient).f380b = booleanValue;
                    C3 = android.support.v4.media.session.a.p(null);
                    sVar.t(C3);
                    return;
                }
                throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
            default:
                T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj4 = ((List) obj).get(0);
                T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                try {
                    C4 = android.support.v4.media.session.a.p(Boolean.valueOf(AbstractC0565d.a((String) obj4)));
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
        }
    }

    @Override // V1.p
    public Object g() {
        switch (this.f295f) {
            case 22:
                return new V1.o(true);
            case 23:
                return new TreeSet();
            case 24:
                return new LinkedHashSet();
            case 25:
                return new ArrayDeque();
            case 26:
                return new ArrayList();
            case 27:
                return new ConcurrentSkipListMap();
            case 28:
                return new ConcurrentHashMap();
            default:
                return new TreeMap();
        }
    }

    @Override // s2.InterfaceC0631c
    public void t(Object obj) {
        switch (this.f295f) {
            case 0:
                if (obj instanceof List) {
                    List list = (List) obj;
                    if (list.size() > 1) {
                        Object obj2 = list.get(0);
                        T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                        Object obj3 = list.get(1);
                        T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj2, (String) obj3, (String) list.get(2)));
                        int i4 = d0.f378c;
                        return;
                    }
                    int i5 = d0.f378c;
                    return;
                }
                A2.i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageCommitVisible'.", "");
                int i6 = d0.f378c;
                return;
            case 1:
                if (obj instanceof List) {
                    List list2 = (List) obj;
                    if (list2.size() > 1) {
                        Object obj4 = list2.get(0);
                        T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                        Object obj5 = list2.get(1);
                        T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj4, (String) obj5, (String) list2.get(2)));
                        int i7 = d0.f378c;
                        return;
                    }
                    int i8 = d0.f378c;
                    return;
                }
                A2.i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedRequestError'.", "");
                int i9 = d0.f378c;
                return;
            case 2:
                if (obj instanceof List) {
                    List list3 = (List) obj;
                    if (list3.size() > 1) {
                        Object obj6 = list3.get(0);
                        T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                        Object obj7 = list3.get(1);
                        T2.h.c(obj7, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj6, (String) obj7, (String) list3.get(2)));
                        int i10 = d0.f378c;
                        return;
                    }
                    int i11 = d0.f378c;
                    return;
                }
                A2.i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageFinished'.", "");
                int i12 = d0.f378c;
                return;
            case 3:
                if (obj instanceof List) {
                    List list4 = (List) obj;
                    if (list4.size() > 1) {
                        Object obj8 = list4.get(0);
                        T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                        Object obj9 = list4.get(1);
                        T2.h.c(obj9, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj8, (String) obj9, (String) list4.get(2)));
                        int i13 = d0.f378c;
                        return;
                    }
                    int i14 = d0.f378c;
                    return;
                }
                A2.i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpAuthRequest'.", "");
                int i15 = d0.f378c;
                return;
            case 4:
                if (obj instanceof List) {
                    List list5 = (List) obj;
                    if (list5.size() > 1) {
                        Object obj10 = list5.get(0);
                        T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                        Object obj11 = list5.get(1);
                        T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj10, (String) obj11, (String) list5.get(2)));
                        int i16 = d0.f378c;
                        return;
                    }
                    int i17 = d0.f378c;
                    return;
                }
                A2.i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onFormResubmission'.", "");
                int i18 = d0.f378c;
                return;
            case 5:
                if (obj instanceof List) {
                    List list6 = (List) obj;
                    if (list6.size() > 1) {
                        Object obj12 = list6.get(0);
                        T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                        Object obj13 = list6.get(1);
                        T2.h.c(obj13, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj12, (String) obj13, (String) list6.get(2)));
                        int i19 = d0.f378c;
                        return;
                    }
                    int i20 = d0.f378c;
                    return;
                }
                A2.i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedSslError'.", "");
                int i21 = d0.f378c;
                return;
            case 6:
                if (obj instanceof List) {
                    List list7 = (List) obj;
                    if (list7.size() > 1) {
                        Object obj14 = list7.get(0);
                        T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                        Object obj15 = list7.get(1);
                        T2.h.c(obj15, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj14, (String) obj15, (String) list7.get(2)));
                        int i22 = d0.f378c;
                        return;
                    }
                    int i23 = d0.f378c;
                    return;
                }
                A2.i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onScaleChanged'.", "");
                int i24 = d0.f378c;
                return;
            default:
                if (obj instanceof List) {
                    List list8 = (List) obj;
                    if (list8.size() > 1) {
                        Object obj16 = list8.get(0);
                        T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                        Object obj17 = list8.get(1);
                        T2.h.c(obj17, "null cannot be cast to non-null type kotlin.String");
                        k3.b.f(new C0022a((String) obj16, (String) obj17, (String) list8.get(2)));
                        int i25 = d0.f378c;
                        return;
                    }
                    int i26 = d0.f378c;
                    return;
                }
                A2.i.p("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.doUpdateVisitedHistory'.", "");
                int i27 = d0.f378c;
                return;
        }
    }

    public /* synthetic */ K(int i4, Object obj) {
        this.f295f = i4;
    }
}
