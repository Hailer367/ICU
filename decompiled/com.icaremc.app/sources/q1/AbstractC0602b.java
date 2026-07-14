package q1;

import A2.A;
import D2.C0034m;
import D2.L;
import I.InterfaceC0066u;
import I.a0;
import I.b0;
import I.c0;
import I.d0;
import I.e0;
import I.f0;
import I.g0;
import I.h0;
import I.v0;
import P1.y;
import V0.m;
import V0.n;
import Z0.r;
import a.AbstractC0141a;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.CookieManager;
import android.webkit.WebView;
import i2.C0368c;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n.p;
import org.json.JSONArray;
import org.json.JSONObject;
import p1.AbstractC0579h;
import p1.AbstractC0581j;
import p1.C0583l;
import p1.C0585n;
import p1.InterfaceC0573b;
import p1.InterfaceC0576e;
import q1.AbstractC0602b;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;
import v0.C0690m;
import v0.InterfaceC0689l;
import z0.C0747a;

/* renamed from: q1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0602b {

    /* renamed from: a, reason: collision with root package name */
    public static p f5943a;

    public AbstractC0602b() {
        new ConcurrentHashMap();
    }

    public static C0585n A(Object obj) {
        C0585n c0585n = new C0585n();
        c0585n.l(obj);
        return c0585n;
    }

    public static Activity B(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return B(((ContextWrapper) context).getBaseContext());
    }

    public static final Object D(S.b bVar, S.d dVar, Serializable serializable) {
        T2.h.e(bVar, "<this>");
        T2.h.e(dVar, "key");
        Object c4 = bVar.c(dVar);
        if (c4 == null) {
            return serializable;
        }
        return c4;
    }

    public static SharedPreferences E(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r2 = r2.getRoundedCorner(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static I.C0069x F(android.view.Display r2, int r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L37
            android.view.RoundedCorner r2 = B.e.o(r2, r3)
            if (r2 == 0) goto L37
            I.x r3 = new I.x
            int r0 = B.e.c(r2)
            if (r0 == 0) goto L2a
            r1 = 1
            if (r0 == r1) goto L2b
            r1 = 2
            if (r0 == r1) goto L2b
            r1 = 3
            if (r0 != r1) goto L1e
            goto L2b
        L1e:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid position: "
            java.lang.String r3 = A2.i.g(r0, r3)
            r2.<init>(r3)
            throw r2
        L2a:
            r1 = 0
        L2b:
            int r0 = B.e.C(r2)
            android.graphics.Point r2 = B.e.f(r2)
            r3.<init>(r1, r0, r2)
            return r3
        L37:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.AbstractC0602b.F(android.view.Display, int):I.x");
    }

    public static String G(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            String concat = "TRuntime.".concat(str);
            if (concat.length() > 23) {
                return concat.substring(0, 23);
            }
            return concat;
        }
        return "TRuntime.".concat(str);
    }

    public static boolean I(Context context) {
        Bundle bundle;
        Context applicationContext = context.getApplicationContext();
        try {
            bundle = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("ContentSizingFlag", "Could not get metadata");
            bundle = null;
        }
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean("io.flutter.embedding.android.EnableContentSizing", false);
    }

    public static boolean J(byte b4) {
        if (b4 > -65) {
            return true;
        }
        return false;
    }

    public static final S.d K(String str) {
        T2.h.e(str, "name");
        return new S.d(str);
    }

    public static boolean L(Parcel parcel, int i4) {
        c0(parcel, i4, 4);
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static int M(Parcel parcel, int i4) {
        c0(parcel, i4, 4);
        return parcel.readInt();
    }

    public static int N(Parcel parcel, int i4) {
        if ((i4 & (-65536)) != -65536) {
            return (char) (i4 >> 16);
        }
        return parcel.readInt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.concurrent.Executor, java.lang.Object] */
    public static void Q(final Context context, I0.h hVar, final boolean z) {
        C0585n c0585n;
        int i4;
        if (Build.VERSION.SDK_INT >= 29) {
            SharedPreferences E3 = E(context);
            if (E3.contains("proxy_retention") && E3.getBoolean("proxy_retention", false) == z) {
                return;
            }
            V0.b bVar = (V0.b) hVar.f821c;
            if (bVar.f1678c.a() >= 241100000) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("proxy_retention", z);
                n a4 = n.a(bVar.f1677b);
                synchronized (a4) {
                    i4 = a4.f1716d;
                    a4.f1716d = i4 + 1;
                }
                c0585n = a4.b(new m(i4, 4, bundle, 0));
            } else {
                c0585n = z(new IOException("SERVICE_NOT_AVAILABLE"));
            }
            c0585n.b(new Object(), new InterfaceC0576e() { // from class: P1.u
                @Override // p1.InterfaceC0576e
                public final void e(Object obj) {
                    SharedPreferences.Editor edit = AbstractC0602b.E(context).edit();
                    edit.putBoolean("proxy_retention", z);
                    edit.apply();
                }
            });
        }
    }

    public static void R(InterfaceC0634f interfaceC0634f, final C0034m c0034m) {
        InterfaceC0640l a4;
        L l3;
        T2.h.e(interfaceC0634f, "binaryMessenger");
        if (c0034m != null && (l3 = c0034m.f416a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.CookieManager.instance", a4, null);
        if (c0034m != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.z
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i4) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0034m2.f416a.f297g).a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj5;
                            try {
                                c0034m3.getClass();
                                cookieManager.setCookie(str, str2);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.CookieManager");
                            A2.h hVar = new A2.h(sVar, 3);
                            c0034m.getClass();
                            ((CookieManager) obj6).removeAllCookies(new C0033l(hVar, 0));
                            return;
                        case 3:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            T2.h.c(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c0034m4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, booleanValue);
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj10 = list3.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager3 = (CookieManager) obj10;
                            Object obj11 = list3.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj11;
                            try {
                                c0034m5.getClass();
                                C6 = android.support.v4.media.session.a.p(cookieManager3.getCookie(str3));
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
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.CookieManager.setCookie", a4, null);
        if (c0034m != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.z
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i5) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0034m2.f416a.f297g).a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj5;
                            try {
                                c0034m3.getClass();
                                cookieManager.setCookie(str, str2);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.CookieManager");
                            A2.h hVar = new A2.h(sVar, 3);
                            c0034m.getClass();
                            ((CookieManager) obj6).removeAllCookies(new C0033l(hVar, 0));
                            return;
                        case 3:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            T2.h.c(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c0034m4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, booleanValue);
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj10 = list3.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager3 = (CookieManager) obj10;
                            Object obj11 = list3.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj11;
                            try {
                                c0034m5.getClass();
                                C6 = android.support.v4.media.session.a.p(cookieManager3.getCookie(str3));
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
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.CookieManager.removeAllCookies", a4, null);
        if (c0034m != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: D2.z
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i6) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0034m2.f416a.f297g).a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj5;
                            try {
                                c0034m3.getClass();
                                cookieManager.setCookie(str, str2);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.CookieManager");
                            A2.h hVar = new A2.h(sVar, 3);
                            c0034m.getClass();
                            ((CookieManager) obj6).removeAllCookies(new C0033l(hVar, 0));
                            return;
                        case 3:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            T2.h.c(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c0034m4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, booleanValue);
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj10 = list3.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager3 = (CookieManager) obj10;
                            Object obj11 = list3.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj11;
                            try {
                                c0034m5.getClass();
                                C6 = android.support.v4.media.session.a.p(cookieManager3.getCookie(str3));
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
            });
        } else {
            yVar3.w(null);
        }
        y yVar4 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.CookieManager.setAcceptThirdPartyCookies", a4, null);
        if (c0034m != null) {
            final int i7 = 3;
            yVar4.w(new InterfaceC0630b() { // from class: D2.z
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i7) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0034m2.f416a.f297g).a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj5;
                            try {
                                c0034m3.getClass();
                                cookieManager.setCookie(str, str2);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.CookieManager");
                            A2.h hVar = new A2.h(sVar, 3);
                            c0034m.getClass();
                            ((CookieManager) obj6).removeAllCookies(new C0033l(hVar, 0));
                            return;
                        case 3:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            T2.h.c(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c0034m4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, booleanValue);
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj10 = list3.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager3 = (CookieManager) obj10;
                            Object obj11 = list3.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj11;
                            try {
                                c0034m5.getClass();
                                C6 = android.support.v4.media.session.a.p(cookieManager3.getCookie(str3));
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
            });
        } else {
            yVar4.w(null);
        }
        y yVar5 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.CookieManager.getCookies", a4, null);
        if (c0034m != null) {
            final int i8 = 4;
            yVar5.w(new InterfaceC0630b() { // from class: D2.z
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    switch (i8) {
                        case 0:
                            C0034m c0034m2 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                ((C0024c) c0034m2.f416a.f297g).a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                        case 1:
                            C0034m c0034m3 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj5;
                            try {
                                c0034m3.getClass();
                                cookieManager.setCookie(str, str2);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type android.webkit.CookieManager");
                            A2.h hVar = new A2.h(sVar, 3);
                            c0034m.getClass();
                            ((CookieManager) obj6).removeAllCookies(new C0033l(hVar, 0));
                            return;
                        case 3:
                            C0034m c0034m4 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            T2.h.c(obj7, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.webkit.WebView");
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            T2.h.c(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c0034m4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, booleanValue);
                                C5 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        default:
                            C0034m c0034m5 = c0034m;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj10 = list3.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type android.webkit.CookieManager");
                            CookieManager cookieManager3 = (CookieManager) obj10;
                            Object obj11 = list3.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj11;
                            try {
                                c0034m5.getClass();
                                C6 = android.support.v4.media.session.a.p(cookieManager3.getCookie(str3));
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
            });
        } else {
            yVar5.w(null);
        }
    }

    public static void S(InterfaceC0634f interfaceC0634f, final C0034m c0034m) {
        InterfaceC0640l a4;
        L l3;
        T2.h.e(interfaceC0634f, "binaryMessenger");
        if (c0034m != null && (l3 = c0034m.f416a) != null) {
            a4 = l3.b();
        } else {
            a4 = new A(2);
        }
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.View.scrollTo", a4, null);
        if (c0034m != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: D2.E
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    int i5;
                    int i6 = i4;
                    final int i7 = 0;
                    C0034m c0034m2 = c0034m;
                    switch (i6) {
                        case 0:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.view.View");
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                            long longValue2 = ((Long) obj4).longValue();
                            try {
                                c0034m2.getClass();
                                view.scrollTo((int) longValue, (int) longValue2);
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
                        case 1:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.view.View");
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Long");
                            long longValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Long");
                            long longValue4 = ((Long) obj7).longValue();
                            try {
                                c0034m2.getClass();
                                view2.scrollBy((int) longValue3, (int) longValue4);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.view.View");
                            View view3 = (View) obj8;
                            try {
                                c0034m2.getClass();
                                C5 = android.support.v4.media.session.a.p(new f0(view3.getScrollX(), view3.getScrollY()));
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.view.View");
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m2.getClass();
                                view4.setVerticalScrollBarEnabled(booleanValue);
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
                        case 4:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.view.View");
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m2.getClass();
                                view5.setHorizontalScrollBarEnabled(booleanValue2);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.view.View");
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode");
                            EnumC0044x enumC0044x = (EnumC0044x) obj14;
                            try {
                                c0034m2.getClass();
                                int ordinal = enumC0044x.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal != 2) {
                                            if (ordinal == 3) {
                                                L l4 = c0034m2.f416a;
                                                EnumC0044x enumC0044x2 = EnumC0044x.UNKNOWN;
                                                l4.getClass();
                                                throw new IllegalArgumentException(enumC0044x2 + " doesn't represent a native value.");
                                            }
                                        } else {
                                            view6.setOverScrollMode(2);
                                        }
                                    } else {
                                        view6.setOverScrollMode(1);
                                    }
                                } else {
                                    view6.setOverScrollMode(0);
                                }
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        default:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.view.View");
                            View view7 = (View) obj15;
                            Object obj16 = list6.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.List<io.flutter.plugins.webviewflutter.WindowInsetsType>");
                            List list7 = (List) obj16;
                            try {
                                c0034m2.getClass();
                                if (list7.isEmpty()) {
                                    K k = new K(10);
                                    WeakHashMap weakHashMap = I.T.f702a;
                                    I.K.c(view7, k);
                                } else {
                                    Iterator it = list7.iterator();
                                    while (it.hasNext()) {
                                        switch (((i0) it.next()).ordinal()) {
                                            case 0:
                                                i5 = i7 | 519;
                                                break;
                                            case 1:
                                                i5 = i7 | 128;
                                                break;
                                            case 2:
                                                i5 = i7 | 4;
                                                break;
                                            case 3:
                                                i5 = i7 | 8;
                                                break;
                                            case 4:
                                                i5 = i7 | 32;
                                                break;
                                            case 5:
                                                i5 = i7 | 2;
                                                break;
                                            case 6:
                                                i5 = i7 | 1;
                                                break;
                                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                i5 = i7 | 16;
                                                break;
                                            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                                                i5 = i7 | 64;
                                                break;
                                            default:
                                                continue;
                                        }
                                        i7 = i5;
                                    }
                                    InterfaceC0066u interfaceC0066u = new InterfaceC0066u() { // from class: D2.P
                                        @Override // I.InterfaceC0066u
                                        public final v0 d(View view8, v0 v0Var) {
                                            I.h0 a0Var;
                                            int i8 = Build.VERSION.SDK_INT;
                                            if (i8 >= 36) {
                                                a0Var = new I.g0(v0Var);
                                            } else if (i8 >= 35) {
                                                a0Var = new I.f0(v0Var);
                                            } else if (i8 >= 34) {
                                                a0Var = new I.e0(v0Var);
                                            } else if (i8 >= 31) {
                                                a0Var = new I.d0(v0Var);
                                            } else if (i8 >= 30) {
                                                a0Var = new I.c0(v0Var);
                                            } else if (i8 >= 29) {
                                                a0Var = new I.b0(v0Var);
                                            } else {
                                                a0Var = new I.a0(v0Var);
                                            }
                                            a0Var.d(i7, B.c.f123e);
                                            return a0Var.b();
                                        }
                                    };
                                    WeakHashMap weakHashMap2 = I.T.f702a;
                                    I.K.c(view7, interfaceC0066u);
                                }
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.View.scrollBy", a4, null);
        if (c0034m != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: D2.E
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    int i52;
                    int i6 = i5;
                    final int i7 = 0;
                    C0034m c0034m2 = c0034m;
                    switch (i6) {
                        case 0:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.view.View");
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                            long longValue2 = ((Long) obj4).longValue();
                            try {
                                c0034m2.getClass();
                                view.scrollTo((int) longValue, (int) longValue2);
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
                        case 1:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.view.View");
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Long");
                            long longValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Long");
                            long longValue4 = ((Long) obj7).longValue();
                            try {
                                c0034m2.getClass();
                                view2.scrollBy((int) longValue3, (int) longValue4);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.view.View");
                            View view3 = (View) obj8;
                            try {
                                c0034m2.getClass();
                                C5 = android.support.v4.media.session.a.p(new f0(view3.getScrollX(), view3.getScrollY()));
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.view.View");
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m2.getClass();
                                view4.setVerticalScrollBarEnabled(booleanValue);
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
                        case 4:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.view.View");
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m2.getClass();
                                view5.setHorizontalScrollBarEnabled(booleanValue2);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.view.View");
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode");
                            EnumC0044x enumC0044x = (EnumC0044x) obj14;
                            try {
                                c0034m2.getClass();
                                int ordinal = enumC0044x.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal != 2) {
                                            if (ordinal == 3) {
                                                L l4 = c0034m2.f416a;
                                                EnumC0044x enumC0044x2 = EnumC0044x.UNKNOWN;
                                                l4.getClass();
                                                throw new IllegalArgumentException(enumC0044x2 + " doesn't represent a native value.");
                                            }
                                        } else {
                                            view6.setOverScrollMode(2);
                                        }
                                    } else {
                                        view6.setOverScrollMode(1);
                                    }
                                } else {
                                    view6.setOverScrollMode(0);
                                }
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        default:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.view.View");
                            View view7 = (View) obj15;
                            Object obj16 = list6.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.List<io.flutter.plugins.webviewflutter.WindowInsetsType>");
                            List list7 = (List) obj16;
                            try {
                                c0034m2.getClass();
                                if (list7.isEmpty()) {
                                    K k = new K(10);
                                    WeakHashMap weakHashMap = I.T.f702a;
                                    I.K.c(view7, k);
                                } else {
                                    Iterator it = list7.iterator();
                                    while (it.hasNext()) {
                                        switch (((i0) it.next()).ordinal()) {
                                            case 0:
                                                i52 = i7 | 519;
                                                break;
                                            case 1:
                                                i52 = i7 | 128;
                                                break;
                                            case 2:
                                                i52 = i7 | 4;
                                                break;
                                            case 3:
                                                i52 = i7 | 8;
                                                break;
                                            case 4:
                                                i52 = i7 | 32;
                                                break;
                                            case 5:
                                                i52 = i7 | 2;
                                                break;
                                            case 6:
                                                i52 = i7 | 1;
                                                break;
                                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                i52 = i7 | 16;
                                                break;
                                            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                                                i52 = i7 | 64;
                                                break;
                                            default:
                                                continue;
                                        }
                                        i7 = i52;
                                    }
                                    InterfaceC0066u interfaceC0066u = new InterfaceC0066u() { // from class: D2.P
                                        @Override // I.InterfaceC0066u
                                        public final v0 d(View view8, v0 v0Var) {
                                            I.h0 a0Var;
                                            int i8 = Build.VERSION.SDK_INT;
                                            if (i8 >= 36) {
                                                a0Var = new I.g0(v0Var);
                                            } else if (i8 >= 35) {
                                                a0Var = new I.f0(v0Var);
                                            } else if (i8 >= 34) {
                                                a0Var = new I.e0(v0Var);
                                            } else if (i8 >= 31) {
                                                a0Var = new I.d0(v0Var);
                                            } else if (i8 >= 30) {
                                                a0Var = new I.c0(v0Var);
                                            } else if (i8 >= 29) {
                                                a0Var = new I.b0(v0Var);
                                            } else {
                                                a0Var = new I.a0(v0Var);
                                            }
                                            a0Var.d(i7, B.c.f123e);
                                            return a0Var.b();
                                        }
                                    };
                                    WeakHashMap weakHashMap2 = I.T.f702a;
                                    I.K.c(view7, interfaceC0066u);
                                }
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.View.getScrollPosition", a4, null);
        if (c0034m != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: D2.E
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    int i52;
                    int i62 = i6;
                    final int i7 = 0;
                    C0034m c0034m2 = c0034m;
                    switch (i62) {
                        case 0:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.view.View");
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                            long longValue2 = ((Long) obj4).longValue();
                            try {
                                c0034m2.getClass();
                                view.scrollTo((int) longValue, (int) longValue2);
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
                        case 1:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.view.View");
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Long");
                            long longValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Long");
                            long longValue4 = ((Long) obj7).longValue();
                            try {
                                c0034m2.getClass();
                                view2.scrollBy((int) longValue3, (int) longValue4);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.view.View");
                            View view3 = (View) obj8;
                            try {
                                c0034m2.getClass();
                                C5 = android.support.v4.media.session.a.p(new f0(view3.getScrollX(), view3.getScrollY()));
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.view.View");
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m2.getClass();
                                view4.setVerticalScrollBarEnabled(booleanValue);
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
                        case 4:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.view.View");
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m2.getClass();
                                view5.setHorizontalScrollBarEnabled(booleanValue2);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.view.View");
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode");
                            EnumC0044x enumC0044x = (EnumC0044x) obj14;
                            try {
                                c0034m2.getClass();
                                int ordinal = enumC0044x.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal != 2) {
                                            if (ordinal == 3) {
                                                L l4 = c0034m2.f416a;
                                                EnumC0044x enumC0044x2 = EnumC0044x.UNKNOWN;
                                                l4.getClass();
                                                throw new IllegalArgumentException(enumC0044x2 + " doesn't represent a native value.");
                                            }
                                        } else {
                                            view6.setOverScrollMode(2);
                                        }
                                    } else {
                                        view6.setOverScrollMode(1);
                                    }
                                } else {
                                    view6.setOverScrollMode(0);
                                }
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        default:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.view.View");
                            View view7 = (View) obj15;
                            Object obj16 = list6.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.List<io.flutter.plugins.webviewflutter.WindowInsetsType>");
                            List list7 = (List) obj16;
                            try {
                                c0034m2.getClass();
                                if (list7.isEmpty()) {
                                    K k = new K(10);
                                    WeakHashMap weakHashMap = I.T.f702a;
                                    I.K.c(view7, k);
                                } else {
                                    Iterator it = list7.iterator();
                                    while (it.hasNext()) {
                                        switch (((i0) it.next()).ordinal()) {
                                            case 0:
                                                i52 = i7 | 519;
                                                break;
                                            case 1:
                                                i52 = i7 | 128;
                                                break;
                                            case 2:
                                                i52 = i7 | 4;
                                                break;
                                            case 3:
                                                i52 = i7 | 8;
                                                break;
                                            case 4:
                                                i52 = i7 | 32;
                                                break;
                                            case 5:
                                                i52 = i7 | 2;
                                                break;
                                            case 6:
                                                i52 = i7 | 1;
                                                break;
                                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                i52 = i7 | 16;
                                                break;
                                            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                                                i52 = i7 | 64;
                                                break;
                                            default:
                                                continue;
                                        }
                                        i7 = i52;
                                    }
                                    InterfaceC0066u interfaceC0066u = new InterfaceC0066u() { // from class: D2.P
                                        @Override // I.InterfaceC0066u
                                        public final v0 d(View view8, v0 v0Var) {
                                            I.h0 a0Var;
                                            int i8 = Build.VERSION.SDK_INT;
                                            if (i8 >= 36) {
                                                a0Var = new I.g0(v0Var);
                                            } else if (i8 >= 35) {
                                                a0Var = new I.f0(v0Var);
                                            } else if (i8 >= 34) {
                                                a0Var = new I.e0(v0Var);
                                            } else if (i8 >= 31) {
                                                a0Var = new I.d0(v0Var);
                                            } else if (i8 >= 30) {
                                                a0Var = new I.c0(v0Var);
                                            } else if (i8 >= 29) {
                                                a0Var = new I.b0(v0Var);
                                            } else {
                                                a0Var = new I.a0(v0Var);
                                            }
                                            a0Var.d(i7, B.c.f123e);
                                            return a0Var.b();
                                        }
                                    };
                                    WeakHashMap weakHashMap2 = I.T.f702a;
                                    I.K.c(view7, interfaceC0066u);
                                }
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        y yVar4 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.View.setVerticalScrollBarEnabled", a4, null);
        if (c0034m != null) {
            final int i7 = 3;
            yVar4.w(new InterfaceC0630b() { // from class: D2.E
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    int i52;
                    int i62 = i7;
                    final int i72 = 0;
                    C0034m c0034m2 = c0034m;
                    switch (i62) {
                        case 0:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.view.View");
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                            long longValue2 = ((Long) obj4).longValue();
                            try {
                                c0034m2.getClass();
                                view.scrollTo((int) longValue, (int) longValue2);
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
                        case 1:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.view.View");
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Long");
                            long longValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Long");
                            long longValue4 = ((Long) obj7).longValue();
                            try {
                                c0034m2.getClass();
                                view2.scrollBy((int) longValue3, (int) longValue4);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.view.View");
                            View view3 = (View) obj8;
                            try {
                                c0034m2.getClass();
                                C5 = android.support.v4.media.session.a.p(new f0(view3.getScrollX(), view3.getScrollY()));
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.view.View");
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m2.getClass();
                                view4.setVerticalScrollBarEnabled(booleanValue);
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
                        case 4:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.view.View");
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m2.getClass();
                                view5.setHorizontalScrollBarEnabled(booleanValue2);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.view.View");
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode");
                            EnumC0044x enumC0044x = (EnumC0044x) obj14;
                            try {
                                c0034m2.getClass();
                                int ordinal = enumC0044x.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal != 2) {
                                            if (ordinal == 3) {
                                                L l4 = c0034m2.f416a;
                                                EnumC0044x enumC0044x2 = EnumC0044x.UNKNOWN;
                                                l4.getClass();
                                                throw new IllegalArgumentException(enumC0044x2 + " doesn't represent a native value.");
                                            }
                                        } else {
                                            view6.setOverScrollMode(2);
                                        }
                                    } else {
                                        view6.setOverScrollMode(1);
                                    }
                                } else {
                                    view6.setOverScrollMode(0);
                                }
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        default:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.view.View");
                            View view7 = (View) obj15;
                            Object obj16 = list6.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.List<io.flutter.plugins.webviewflutter.WindowInsetsType>");
                            List list7 = (List) obj16;
                            try {
                                c0034m2.getClass();
                                if (list7.isEmpty()) {
                                    K k = new K(10);
                                    WeakHashMap weakHashMap = I.T.f702a;
                                    I.K.c(view7, k);
                                } else {
                                    Iterator it = list7.iterator();
                                    while (it.hasNext()) {
                                        switch (((i0) it.next()).ordinal()) {
                                            case 0:
                                                i52 = i72 | 519;
                                                break;
                                            case 1:
                                                i52 = i72 | 128;
                                                break;
                                            case 2:
                                                i52 = i72 | 4;
                                                break;
                                            case 3:
                                                i52 = i72 | 8;
                                                break;
                                            case 4:
                                                i52 = i72 | 32;
                                                break;
                                            case 5:
                                                i52 = i72 | 2;
                                                break;
                                            case 6:
                                                i52 = i72 | 1;
                                                break;
                                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                i52 = i72 | 16;
                                                break;
                                            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                                                i52 = i72 | 64;
                                                break;
                                            default:
                                                continue;
                                        }
                                        i72 = i52;
                                    }
                                    InterfaceC0066u interfaceC0066u = new InterfaceC0066u() { // from class: D2.P
                                        @Override // I.InterfaceC0066u
                                        public final v0 d(View view8, v0 v0Var) {
                                            I.h0 a0Var;
                                            int i8 = Build.VERSION.SDK_INT;
                                            if (i8 >= 36) {
                                                a0Var = new I.g0(v0Var);
                                            } else if (i8 >= 35) {
                                                a0Var = new I.f0(v0Var);
                                            } else if (i8 >= 34) {
                                                a0Var = new I.e0(v0Var);
                                            } else if (i8 >= 31) {
                                                a0Var = new I.d0(v0Var);
                                            } else if (i8 >= 30) {
                                                a0Var = new I.c0(v0Var);
                                            } else if (i8 >= 29) {
                                                a0Var = new I.b0(v0Var);
                                            } else {
                                                a0Var = new I.a0(v0Var);
                                            }
                                            a0Var.d(i72, B.c.f123e);
                                            return a0Var.b();
                                        }
                                    };
                                    WeakHashMap weakHashMap2 = I.T.f702a;
                                    I.K.c(view7, interfaceC0066u);
                                }
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
        y yVar5 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.View.setHorizontalScrollBarEnabled", a4, null);
        if (c0034m != null) {
            final int i8 = 4;
            yVar5.w(new InterfaceC0630b() { // from class: D2.E
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    int i52;
                    int i62 = i8;
                    final int i72 = 0;
                    C0034m c0034m2 = c0034m;
                    switch (i62) {
                        case 0:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.view.View");
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                            long longValue2 = ((Long) obj4).longValue();
                            try {
                                c0034m2.getClass();
                                view.scrollTo((int) longValue, (int) longValue2);
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
                        case 1:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.view.View");
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Long");
                            long longValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Long");
                            long longValue4 = ((Long) obj7).longValue();
                            try {
                                c0034m2.getClass();
                                view2.scrollBy((int) longValue3, (int) longValue4);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.view.View");
                            View view3 = (View) obj8;
                            try {
                                c0034m2.getClass();
                                C5 = android.support.v4.media.session.a.p(new f0(view3.getScrollX(), view3.getScrollY()));
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.view.View");
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m2.getClass();
                                view4.setVerticalScrollBarEnabled(booleanValue);
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
                        case 4:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.view.View");
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m2.getClass();
                                view5.setHorizontalScrollBarEnabled(booleanValue2);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.view.View");
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode");
                            EnumC0044x enumC0044x = (EnumC0044x) obj14;
                            try {
                                c0034m2.getClass();
                                int ordinal = enumC0044x.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal != 2) {
                                            if (ordinal == 3) {
                                                L l4 = c0034m2.f416a;
                                                EnumC0044x enumC0044x2 = EnumC0044x.UNKNOWN;
                                                l4.getClass();
                                                throw new IllegalArgumentException(enumC0044x2 + " doesn't represent a native value.");
                                            }
                                        } else {
                                            view6.setOverScrollMode(2);
                                        }
                                    } else {
                                        view6.setOverScrollMode(1);
                                    }
                                } else {
                                    view6.setOverScrollMode(0);
                                }
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        default:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.view.View");
                            View view7 = (View) obj15;
                            Object obj16 = list6.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.List<io.flutter.plugins.webviewflutter.WindowInsetsType>");
                            List list7 = (List) obj16;
                            try {
                                c0034m2.getClass();
                                if (list7.isEmpty()) {
                                    K k = new K(10);
                                    WeakHashMap weakHashMap = I.T.f702a;
                                    I.K.c(view7, k);
                                } else {
                                    Iterator it = list7.iterator();
                                    while (it.hasNext()) {
                                        switch (((i0) it.next()).ordinal()) {
                                            case 0:
                                                i52 = i72 | 519;
                                                break;
                                            case 1:
                                                i52 = i72 | 128;
                                                break;
                                            case 2:
                                                i52 = i72 | 4;
                                                break;
                                            case 3:
                                                i52 = i72 | 8;
                                                break;
                                            case 4:
                                                i52 = i72 | 32;
                                                break;
                                            case 5:
                                                i52 = i72 | 2;
                                                break;
                                            case 6:
                                                i52 = i72 | 1;
                                                break;
                                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                i52 = i72 | 16;
                                                break;
                                            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                                                i52 = i72 | 64;
                                                break;
                                            default:
                                                continue;
                                        }
                                        i72 = i52;
                                    }
                                    InterfaceC0066u interfaceC0066u = new InterfaceC0066u() { // from class: D2.P
                                        @Override // I.InterfaceC0066u
                                        public final v0 d(View view8, v0 v0Var) {
                                            I.h0 a0Var;
                                            int i82 = Build.VERSION.SDK_INT;
                                            if (i82 >= 36) {
                                                a0Var = new I.g0(v0Var);
                                            } else if (i82 >= 35) {
                                                a0Var = new I.f0(v0Var);
                                            } else if (i82 >= 34) {
                                                a0Var = new I.e0(v0Var);
                                            } else if (i82 >= 31) {
                                                a0Var = new I.d0(v0Var);
                                            } else if (i82 >= 30) {
                                                a0Var = new I.c0(v0Var);
                                            } else if (i82 >= 29) {
                                                a0Var = new I.b0(v0Var);
                                            } else {
                                                a0Var = new I.a0(v0Var);
                                            }
                                            a0Var.d(i72, B.c.f123e);
                                            return a0Var.b();
                                        }
                                    };
                                    WeakHashMap weakHashMap2 = I.T.f702a;
                                    I.K.c(view7, interfaceC0066u);
                                }
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                    }
                }
            });
        } else {
            yVar5.w(null);
        }
        y yVar6 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.View.setOverScrollMode", a4, null);
        if (c0034m != null) {
            final int i9 = 5;
            yVar6.w(new InterfaceC0630b() { // from class: D2.E
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    int i52;
                    int i62 = i9;
                    final int i72 = 0;
                    C0034m c0034m2 = c0034m;
                    switch (i62) {
                        case 0:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.view.View");
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                            long longValue2 = ((Long) obj4).longValue();
                            try {
                                c0034m2.getClass();
                                view.scrollTo((int) longValue, (int) longValue2);
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
                        case 1:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.view.View");
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Long");
                            long longValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Long");
                            long longValue4 = ((Long) obj7).longValue();
                            try {
                                c0034m2.getClass();
                                view2.scrollBy((int) longValue3, (int) longValue4);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.view.View");
                            View view3 = (View) obj8;
                            try {
                                c0034m2.getClass();
                                C5 = android.support.v4.media.session.a.p(new f0(view3.getScrollX(), view3.getScrollY()));
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.view.View");
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m2.getClass();
                                view4.setVerticalScrollBarEnabled(booleanValue);
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
                        case 4:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.view.View");
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m2.getClass();
                                view5.setHorizontalScrollBarEnabled(booleanValue2);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.view.View");
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode");
                            EnumC0044x enumC0044x = (EnumC0044x) obj14;
                            try {
                                c0034m2.getClass();
                                int ordinal = enumC0044x.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal != 2) {
                                            if (ordinal == 3) {
                                                L l4 = c0034m2.f416a;
                                                EnumC0044x enumC0044x2 = EnumC0044x.UNKNOWN;
                                                l4.getClass();
                                                throw new IllegalArgumentException(enumC0044x2 + " doesn't represent a native value.");
                                            }
                                        } else {
                                            view6.setOverScrollMode(2);
                                        }
                                    } else {
                                        view6.setOverScrollMode(1);
                                    }
                                } else {
                                    view6.setOverScrollMode(0);
                                }
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        default:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.view.View");
                            View view7 = (View) obj15;
                            Object obj16 = list6.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.List<io.flutter.plugins.webviewflutter.WindowInsetsType>");
                            List list7 = (List) obj16;
                            try {
                                c0034m2.getClass();
                                if (list7.isEmpty()) {
                                    K k = new K(10);
                                    WeakHashMap weakHashMap = I.T.f702a;
                                    I.K.c(view7, k);
                                } else {
                                    Iterator it = list7.iterator();
                                    while (it.hasNext()) {
                                        switch (((i0) it.next()).ordinal()) {
                                            case 0:
                                                i52 = i72 | 519;
                                                break;
                                            case 1:
                                                i52 = i72 | 128;
                                                break;
                                            case 2:
                                                i52 = i72 | 4;
                                                break;
                                            case 3:
                                                i52 = i72 | 8;
                                                break;
                                            case 4:
                                                i52 = i72 | 32;
                                                break;
                                            case 5:
                                                i52 = i72 | 2;
                                                break;
                                            case 6:
                                                i52 = i72 | 1;
                                                break;
                                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                i52 = i72 | 16;
                                                break;
                                            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                                                i52 = i72 | 64;
                                                break;
                                            default:
                                                continue;
                                        }
                                        i72 = i52;
                                    }
                                    InterfaceC0066u interfaceC0066u = new InterfaceC0066u() { // from class: D2.P
                                        @Override // I.InterfaceC0066u
                                        public final v0 d(View view8, v0 v0Var) {
                                            I.h0 a0Var;
                                            int i82 = Build.VERSION.SDK_INT;
                                            if (i82 >= 36) {
                                                a0Var = new I.g0(v0Var);
                                            } else if (i82 >= 35) {
                                                a0Var = new I.f0(v0Var);
                                            } else if (i82 >= 34) {
                                                a0Var = new I.e0(v0Var);
                                            } else if (i82 >= 31) {
                                                a0Var = new I.d0(v0Var);
                                            } else if (i82 >= 30) {
                                                a0Var = new I.c0(v0Var);
                                            } else if (i82 >= 29) {
                                                a0Var = new I.b0(v0Var);
                                            } else {
                                                a0Var = new I.a0(v0Var);
                                            }
                                            a0Var.d(i72, B.c.f123e);
                                            return a0Var.b();
                                        }
                                    };
                                    WeakHashMap weakHashMap2 = I.T.f702a;
                                    I.K.c(view7, interfaceC0066u);
                                }
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                    }
                }
            });
        } else {
            yVar6.w(null);
        }
        y yVar7 = new y(interfaceC0634f, "dev.flutter.pigeon.webview_flutter_android.View.setInsetListenerToSetInsetsToZero", a4, null);
        if (c0034m != null) {
            final int i10 = 6;
            yVar7.w(new InterfaceC0630b() { // from class: D2.E
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    int i52;
                    int i62 = i10;
                    final int i72 = 0;
                    C0034m c0034m2 = c0034m;
                    switch (i62) {
                        case 0:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type android.view.View");
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                            long longValue2 = ((Long) obj4).longValue();
                            try {
                                c0034m2.getClass();
                                view.scrollTo((int) longValue, (int) longValue2);
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
                        case 1:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type android.view.View");
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.Long");
                            long longValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Long");
                            long longValue4 = ((Long) obj7).longValue();
                            try {
                                c0034m2.getClass();
                                view2.scrollBy((int) longValue3, (int) longValue4);
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
                        case 2:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type android.view.View");
                            View view3 = (View) obj8;
                            try {
                                c0034m2.getClass();
                                C5 = android.support.v4.media.session.a.p(new f0(view3.getScrollX(), view3.getScrollY()));
                            } catch (Throwable th3) {
                                if (th3 instanceof C0022a) {
                                    C0022a c0022a3 = th3;
                                    C5 = I2.f.C(c0022a3.f349f, c0022a3.f350g, c0022a3.f351h);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            T2.h.c(obj9, "null cannot be cast to non-null type android.view.View");
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c0034m2.getClass();
                                view4.setVerticalScrollBarEnabled(booleanValue);
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
                        case 4:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            T2.h.c(obj11, "null cannot be cast to non-null type android.view.View");
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c0034m2.getClass();
                                view5.setHorizontalScrollBarEnabled(booleanValue2);
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof C0022a) {
                                    C0022a c0022a5 = th5;
                                    C7 = I2.f.C(c0022a5.f349f, c0022a5.f350g, c0022a5.f351h);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            T2.h.c(obj13, "null cannot be cast to non-null type android.view.View");
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            T2.h.c(obj14, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode");
                            EnumC0044x enumC0044x = (EnumC0044x) obj14;
                            try {
                                c0034m2.getClass();
                                int ordinal = enumC0044x.ordinal();
                                if (ordinal != 0) {
                                    if (ordinal != 1) {
                                        if (ordinal != 2) {
                                            if (ordinal == 3) {
                                                L l4 = c0034m2.f416a;
                                                EnumC0044x enumC0044x2 = EnumC0044x.UNKNOWN;
                                                l4.getClass();
                                                throw new IllegalArgumentException(enumC0044x2 + " doesn't represent a native value.");
                                            }
                                        } else {
                                            view6.setOverScrollMode(2);
                                        }
                                    } else {
                                        view6.setOverScrollMode(1);
                                    }
                                } else {
                                    view6.setOverScrollMode(0);
                                }
                                C8 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof C0022a) {
                                    C0022a c0022a6 = th6;
                                    C8 = I2.f.C(c0022a6.f349f, c0022a6.f350g, c0022a6.f351h);
                                } else {
                                    C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            sVar.t(C8);
                            return;
                        default:
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            T2.h.c(obj15, "null cannot be cast to non-null type android.view.View");
                            View view7 = (View) obj15;
                            Object obj16 = list6.get(1);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.collections.List<io.flutter.plugins.webviewflutter.WindowInsetsType>");
                            List list7 = (List) obj16;
                            try {
                                c0034m2.getClass();
                                if (list7.isEmpty()) {
                                    K k = new K(10);
                                    WeakHashMap weakHashMap = I.T.f702a;
                                    I.K.c(view7, k);
                                } else {
                                    Iterator it = list7.iterator();
                                    while (it.hasNext()) {
                                        switch (((i0) it.next()).ordinal()) {
                                            case 0:
                                                i52 = i72 | 519;
                                                break;
                                            case 1:
                                                i52 = i72 | 128;
                                                break;
                                            case 2:
                                                i52 = i72 | 4;
                                                break;
                                            case 3:
                                                i52 = i72 | 8;
                                                break;
                                            case 4:
                                                i52 = i72 | 32;
                                                break;
                                            case 5:
                                                i52 = i72 | 2;
                                                break;
                                            case 6:
                                                i52 = i72 | 1;
                                                break;
                                            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                i52 = i72 | 16;
                                                break;
                                            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                                                i52 = i72 | 64;
                                                break;
                                            default:
                                                continue;
                                        }
                                        i72 = i52;
                                    }
                                    InterfaceC0066u interfaceC0066u = new InterfaceC0066u() { // from class: D2.P
                                        @Override // I.InterfaceC0066u
                                        public final v0 d(View view8, v0 v0Var) {
                                            I.h0 a0Var;
                                            int i82 = Build.VERSION.SDK_INT;
                                            if (i82 >= 36) {
                                                a0Var = new I.g0(v0Var);
                                            } else if (i82 >= 35) {
                                                a0Var = new I.f0(v0Var);
                                            } else if (i82 >= 34) {
                                                a0Var = new I.e0(v0Var);
                                            } else if (i82 >= 31) {
                                                a0Var = new I.d0(v0Var);
                                            } else if (i82 >= 30) {
                                                a0Var = new I.c0(v0Var);
                                            } else if (i82 >= 29) {
                                                a0Var = new I.b0(v0Var);
                                            } else {
                                                a0Var = new I.a0(v0Var);
                                            }
                                            a0Var.d(i72, B.c.f123e);
                                            return a0Var.b();
                                        }
                                    };
                                    WeakHashMap weakHashMap2 = I.T.f702a;
                                    I.K.c(view7, interfaceC0066u);
                                }
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                if (th7 instanceof C0022a) {
                                    C0022a c0022a7 = th7;
                                    C9 = I2.f.C(c0022a7.f349f, c0022a7.f350g, c0022a7.f351h);
                                } else {
                                    C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            sVar.t(C9);
                            return;
                    }
                }
            });
        } else {
            yVar7.w(null);
        }
    }

    public static void T(Parcel parcel, int i4) {
        parcel.setDataPosition(parcel.dataPosition() + N(parcel, i4));
    }

    public static final S.d U(String str) {
        T2.h.e(str, "name");
        return new S.d(str);
    }

    public static final S.d V(String str) {
        T2.h.e(str, "name");
        return new S.d(str);
    }

    public static boolean W(View view, E2.c cVar) {
        if (view != null) {
            if (!cVar.c(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                        if (W(viewGroup.getChildAt(i4), cVar)) {
                            return true;
                        }
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static int X(Parcel parcel) {
        int readInt = parcel.readInt();
        int N3 = N(parcel, readInt);
        char c4 = (char) readInt;
        int dataPosition = parcel.dataPosition();
        if (c4 == 20293) {
            int i4 = N3 + dataPosition;
            if (i4 >= dataPosition && i4 <= parcel.dataSize()) {
                return i4;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(dataPosition).length() + 32 + String.valueOf(i4).length());
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i4);
            throw new E0.b(sb.toString(), parcel);
        }
        throw new E0.b("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(readInt))), parcel);
    }

    public static Object Y(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (!(obj instanceof JSONArray)) {
            if (obj instanceof JSONObject) {
                return obj;
            }
            if (obj.equals(JSONObject.NULL)) {
                return obj;
            }
            if (obj instanceof Collection) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    jSONArray.put(Y(it.next()));
                }
                return jSONArray;
            }
            if (obj.getClass().isArray()) {
                JSONArray jSONArray2 = new JSONArray();
                int length = Array.getLength(obj);
                for (int i4 = 0; i4 < length; i4++) {
                    jSONArray2.put(Y(Array.get(obj, i4)));
                }
                return jSONArray2;
            }
            if (obj instanceof Map) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    jSONObject.put((String) entry.getKey(), Y(entry.getValue()));
                }
                return jSONObject;
            }
            if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short)) {
                if (obj instanceof String) {
                    return obj;
                }
                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                    return obj.toString();
                }
                return null;
            }
            return obj;
        }
        return obj;
    }

    public static final String a(Object[] objArr, int i4, int i5, I2.a aVar) {
        StringBuilder sb = new StringBuilder((i5 * 3) + 2);
        sb.append("[");
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i4 + i6];
            if (obj == aVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        T2.h.d(sb2, "toString(...)");
        return sb2;
    }

    public static void a0(Parcel parcel, Parcelable parcelable) {
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
    }

    public static Bitmap b(Bitmap bitmap, int i4) {
        if (bitmap != null) {
            switch (i4) {
                case 1:
                case 3:
                case 6:
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    break;
                case 2:
                case 4:
                case 5:
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    Matrix matrix = new Matrix();
                    if (i4 != 2) {
                        if (i4 != 7) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    return bitmap;
                                }
                                matrix.setScale(1.0f, -1.0f, width / 2.0f, height / 2.0f);
                            } else {
                                matrix.setScale(1.0f, -1.0f, width / 2.0f, height / 2.0f);
                            }
                        } else {
                            matrix.setScale(-1.0f, 1.0f, width / 2.0f, height / 2.0f);
                        }
                    } else {
                        matrix.setScale(-1.0f, 1.0f, width / 2.0f, height / 2.0f);
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                    if (createBitmap != bitmap) {
                        bitmap.recycle();
                    }
                    return createBitmap;
                default:
                    Log.e("ImageUtils", "Unknown EXIF orientation: " + i4);
                    return bitmap;
            }
        }
        return bitmap;
    }

    public static Object b0(AbstractC0579h abstractC0579h) {
        if (abstractC0579h.f()) {
            return abstractC0579h.d();
        }
        if (((C0585n) abstractC0579h).f5835d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(abstractC0579h.c());
    }

    public static Object c(AbstractC0579h abstractC0579h) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null && Objects.equals(myLooper.getThread().getName(), "GoogleApiHandler")) {
                throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
            }
            r.f(abstractC0579h, "Task must not be null");
            if (abstractC0579h.e()) {
                return b0(abstractC0579h);
            }
            p pVar = new p();
            Executor executor = AbstractC0581j.f5823b;
            abstractC0579h.b(executor, pVar);
            abstractC0579h.a(executor, pVar);
            C0585n c0585n = (C0585n) abstractC0579h;
            c0585n.f5833b.b(new C0583l(executor, (InterfaceC0573b) pVar));
            c0585n.p();
            ((CountDownLatch) pVar.f5322g).await();
            return b0(abstractC0579h);
        }
        throw new IllegalStateException("Must not be called on the main application thread");
    }

    public static void c0(Parcel parcel, int i4, int i5) {
        int N3 = N(parcel, i4);
        if (N3 == i5) {
            return;
        }
        String hexString = Integer.toHexString(N3);
        int length = String.valueOf(i5).length();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + length + 19 + String.valueOf(N3).length() + 4 + 1);
        sb.append("Expected size ");
        sb.append(i5);
        sb.append(" got ");
        sb.append(N3);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new E0.b(sb.toString(), parcel);
    }

    public static Object d(AbstractC0579h abstractC0579h, long j4) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null && Objects.equals(myLooper.getThread().getName(), "GoogleApiHandler")) {
                throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
            }
            r.f(abstractC0579h, "Task must not be null");
            r.f(timeUnit, "TimeUnit must not be null");
            if (abstractC0579h.e()) {
                return b0(abstractC0579h);
            }
            p pVar = new p();
            Executor executor = AbstractC0581j.f5823b;
            abstractC0579h.b(executor, pVar);
            abstractC0579h.a(executor, pVar);
            C0585n c0585n = (C0585n) abstractC0579h;
            c0585n.f5833b.b(new C0583l(executor, (InterfaceC0573b) pVar));
            c0585n.p();
            if (((CountDownLatch) pVar.f5322g).await(j4, timeUnit)) {
                return b0(abstractC0579h);
            }
            throw new TimeoutException("Timed out waiting for Task");
        }
        throw new IllegalStateException("Must not be called on the main application thread");
    }

    public static void d0(Object[] objArr, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (objArr[i5] == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 9);
                sb.append("at index ");
                sb.append(i5);
                throw new NullPointerException(sb.toString());
            }
        }
    }

    public static final S.d e(String str) {
        T2.h.e(str, "name");
        return new S.d(str);
    }

    public static void f(Context context, E2.b bVar) {
        Rect rect;
        h0 a0Var;
        v0 b4;
        WindowMetrics maximumWindowMetrics;
        Activity B3 = B(context);
        if (B3 != null) {
            InterfaceC0689l.f6287a.getClass();
            int i4 = C0690m.f6288b;
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30) {
                maximumWindowMetrics = ((WindowManager) B3.getSystemService(WindowManager.class)).getMaximumWindowMetrics();
                rect = maximumWindowMetrics.getBounds();
                T2.h.d(rect, "wm.maximumWindowMetrics.bounds");
            } else {
                Object systemService = B3.getSystemService("window");
                T2.h.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                T2.h.d(defaultDisplay, "display");
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                rect = new Rect(0, 0, point.x, point.y);
            }
            if (i5 >= 30) {
                if (i5 >= 30) {
                    b4 = C0747a.f6633a.a(B3);
                } else {
                    throw new Exception("Incompatible SDK version");
                }
            } else {
                if (i5 >= 36) {
                    a0Var = new g0();
                } else if (i5 >= 35) {
                    a0Var = new f0();
                } else if (i5 >= 34) {
                    a0Var = new e0();
                } else if (i5 >= 31) {
                    a0Var = new d0();
                } else if (i5 >= 30) {
                    a0Var = new c0();
                } else if (i5 >= 29) {
                    a0Var = new b0();
                } else {
                    a0Var = new a0();
                }
                b4 = a0Var.b();
                T2.h.d(b4, "{\n            WindowInse…ilder().build()\n        }");
            }
            int i6 = rect.left;
            int i7 = rect.top;
            int i8 = rect.right;
            int i9 = rect.bottom;
            if (i6 <= i8) {
                if (i7 <= i9) {
                    T2.h.e(b4, "_windowInsetsCompat");
                    ((C0368c) bVar).f4106a.updateDisplayMetrics(0, new Rect(i6, i7, i8, i9).width(), new Rect(i6, i7, i8, i9).height(), context.getResources().getDisplayMetrics().density);
                    return;
                }
                throw new IllegalArgumentException(A2.i.h("top must be less than or equal to bottom, top: ", ", bottom: ", i7, i9).toString());
            }
            throw new IllegalArgumentException(A2.i.h("Left must be less than or equal to right, left: ", ", right: ", i6, i8).toString());
        }
    }

    public static C0585n g(Executor executor, Callable callable) {
        r.f(executor, "Executor must not be null");
        C0585n c0585n = new C0585n();
        executor.execute(new F.a(13, c0585n, callable));
        return c0585n;
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    public static void i(int i4, int i5, int i6) {
        if (i4 >= 0 && i5 <= i6) {
            if (i4 <= i5) {
                return;
            } else {
                throw new IllegalArgumentException(A2.i.h("fromIndex: ", " > toIndex: ", i4, i5));
            }
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i4 + ", toIndex: " + i5 + ", size: " + i6);
    }

    public static Bundle j(Parcel parcel, int i4) {
        int N3 = N(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (N3 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + N3);
        return readBundle;
    }

    public static Parcelable o(Parcel parcel, int i4, Parcelable.Creator creator) {
        int N3 = N(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (N3 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + N3);
        return parcelable;
    }

    public static String p(Parcel parcel, int i4) {
        int N3 = N(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (N3 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + N3);
        return readString;
    }

    public static Object[] q(Parcel parcel, int i4, Parcelable.Creator creator) {
        int N3 = N(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (N3 == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + N3);
        return createTypedArray;
    }

    public static void r(String str, String str2, Object obj) {
        String G3 = G(str);
        if (Log.isLoggable(G3, 3)) {
            Log.d(G3, String.format(str2, obj));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0143, code lost:
    
        if (s(r1.getValue(), r4.getValue()) == false) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean s(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.AbstractC0602b.s(java.lang.Object, java.lang.Object):boolean");
    }

    public static int t(Object obj) {
        int i4 = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.hashCode((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.hashCode((long[]) obj);
        }
        double d4 = 0.0d;
        int i5 = 1;
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length;
            while (i4 < length) {
                double d5 = dArr[i4];
                int i6 = i5 * 31;
                if (d5 == 0.0d) {
                    d5 = 0.0d;
                }
                long doubleToLongBits = Double.doubleToLongBits(d5);
                i5 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                i4++;
            }
            return i5;
        }
        float f4 = 0.0f;
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length;
            while (i4 < length2) {
                float f5 = fArr[i4];
                int i7 = i5 * 31;
                if (f5 == 0.0f) {
                    f5 = 0.0f;
                }
                i5 = i7 + Float.floatToIntBits(f5);
                i4++;
            }
            return i5;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length3 = objArr.length;
            while (i4 < length3) {
                i5 = (i5 * 31) + t(objArr[i4]);
                i4++;
            }
            return i5;
        }
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                i5 = (i5 * 31) + t(it.next());
            }
            return i5;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                i4 += t(entry.getValue()) ^ (t(entry.getKey()) * 31);
            }
            return i4;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue != 0.0d) {
                d4 = doubleValue;
            }
            long doubleToLongBits2 = Double.doubleToLongBits(d4);
            return (int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32));
        }
        if (obj instanceof Float) {
            float floatValue = ((Number) obj).floatValue();
            if (floatValue != 0.0f) {
                f4 = floatValue;
            }
            return Float.floatToIntBits(f4);
        }
        return obj.hashCode();
    }

    public static boolean u(double d4, double d5) {
        double d6;
        double d7 = 0.0d;
        if (d4 == 0.0d) {
            d6 = 0.0d;
        } else {
            d6 = d4;
        }
        if (d5 != 0.0d) {
            d7 = d5;
        }
        if (d6 != d7) {
            if (Double.isNaN(d4) && Double.isNaN(d5)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void v(String str, String str2, Exception exc) {
        String G3 = G(str);
        if (Log.isLoggable(G3, 6)) {
            Log.e(G3, str2, exc);
        }
    }

    public static void w(Parcel parcel, int i4) {
        if (parcel.dataPosition() == i4) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 26);
        sb.append("Overread allowed size end=");
        sb.append(i4);
        throw new E0.b(sb.toString(), parcel);
    }

    public static F.l x(F.l[] lVarArr, int i4) {
        int i5;
        boolean z;
        int i6;
        if ((i4 & 1) == 0) {
            i5 = 400;
        } else {
            i5 = 700;
        }
        if ((i4 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        F.l lVar = null;
        int i7 = Integer.MAX_VALUE;
        for (F.l lVar2 : lVarArr) {
            int abs = Math.abs(lVar2.f513c - i5) * 2;
            if (lVar2.f514d == z) {
                i6 = 0;
            } else {
                i6 = 1;
            }
            int i8 = abs + i6;
            if (lVar == null || i7 > i8) {
                lVar = lVar2;
                i7 = i8;
            }
        }
        return lVar;
    }

    public static boolean y(float f4, float f5) {
        float f6;
        float f7 = 0.0f;
        if (f4 == 0.0f) {
            f6 = 0.0f;
        } else {
            f6 = f4;
        }
        if (f5 != 0.0f) {
            f7 = f5;
        }
        if (f6 != f7) {
            if (Float.isNaN(f4) && Float.isNaN(f5)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static C0585n z(Exception exc) {
        C0585n c0585n = new C0585n();
        c0585n.m(exc);
        return c0585n;
    }

    public abstract InputFilter[] C(InputFilter[] inputFilterArr);

    public abstract boolean H();

    public abstract void O(boolean z);

    public abstract void P(boolean z);

    public abstract TransformationMethod Z(TransformationMethod transformationMethod);

    public abstract Typeface k(Context context, A.e eVar, Resources resources, int i4);

    public abstract Typeface l(Context context, F.l[] lVarArr, int i4);

    public Typeface m(Context context, List list, int i4) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface n(Context context, Resources resources, int i4, String str, int i5) {
        File t3 = AbstractC0141a.t(context);
        if (t3 == null) {
            return null;
        }
        try {
            if (!AbstractC0141a.j(t3, resources, i4)) {
                return null;
            }
            return Typeface.createFromFile(t3.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            t3.delete();
        }
    }
}
