package C2;

import A2.t;
import P1.y;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import io.flutter.plugin.platform.s;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import r.AbstractC0613h;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ e f264a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final H2.g f265b = new H2.g(new A2.f(2));

    public static void a(InterfaceC0634f interfaceC0634f, final t tVar) {
        T2.h.e(interfaceC0634f, "binaryMessenger");
        String d4 = r2.k.d("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.canLaunchUrl", "");
        H2.g gVar = f265b;
        y yVar = new y(interfaceC0634f, d4, (InterfaceC0640l) gVar.a(), null);
        if (tVar != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b() { // from class: C2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    List C3;
                    String shortString;
                    List C4;
                    t tVar2;
                    List C5;
                    List C6;
                    List C7;
                    switch (i4) {
                        case 0:
                            f fVar = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            try {
                                t tVar3 = (t) fVar;
                                tVar3.getClass();
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(str));
                                ComponentName resolveActivity = intent.resolveActivity(((Context) ((c) tVar3.f100h).f261g).getPackageManager());
                                if (resolveActivity == null) {
                                    shortString = null;
                                } else {
                                    shortString = resolveActivity.toShortString();
                                }
                                if (shortString != null) {
                                    z = !"{com.android.fallback/com.android.fallback.Fallback}".equals(shortString);
                                }
                                C3 = android.support.v4.media.session.a.p(Boolean.valueOf(z));
                            } catch (Throwable th) {
                                if (th instanceof b) {
                                    b bVar = th;
                                    C3 = I2.f.C(bVar.f258f, bVar.f259g, null);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            f fVar2 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            boolean z3 = false;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map map = (Map) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj5).booleanValue();
                            try {
                                tVar2 = (t) fVar2;
                            } catch (Throwable th2) {
                                if (th2 instanceof b) {
                                    b bVar2 = th2;
                                    C4 = I2.f.C(bVar2.f258f, bVar2.f259g, null);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            if (((Activity) tVar2.f101i) != null) {
                                Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(str2)).putExtra("com.android.browser.headers", t.D(map));
                                if (booleanValue && Build.VERSION.SDK_INT >= 30) {
                                    putExtra.addFlags(1024);
                                }
                                try {
                                    ((Activity) tVar2.f101i).startActivity(putExtra);
                                    z3 = true;
                                } catch (ActivityNotFoundException unused) {
                                }
                                C4 = android.support.v4.media.session.a.p(Boolean.valueOf(z3));
                                sVar.t(C4);
                                return;
                            }
                            throw new b();
                        case 2:
                            f fVar3 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj6 = list2.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list2.get(1);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj7).booleanValue();
                            Object obj8 = list2.get(2);
                            T2.h.c(obj8, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.WebViewOptions");
                            l lVar = (l) obj8;
                            Object obj9 = list2.get(3);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.BrowserOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(Boolean.valueOf(((t) fVar3).S(str3, booleanValue2, lVar, (a) obj9)));
                            } catch (Throwable th3) {
                                if (th3 instanceof b) {
                                    b bVar3 = th3;
                                    C5 = I2.f.C(bVar3.f258f, bVar3.f259g, null);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            try {
                                boolean z4 = false;
                                if (AbstractC0613h.a((Context) ((t) tVar).f99g, Collections.EMPTY_LIST, false) != null) {
                                    z4 = true;
                                }
                                C6 = android.support.v4.media.session.a.p(Boolean.valueOf(z4));
                            } catch (Throwable th4) {
                                if (th4 instanceof b) {
                                    b bVar4 = th4;
                                    C6 = I2.f.C(bVar4.f258f, bVar4.f259g, null);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            try {
                                ((Context) ((t) tVar).f99g).sendBroadcast(new Intent("close action"));
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof b) {
                                    b bVar5 = th5;
                                    C7 = I2.f.C(bVar5.f258f, bVar5.f259g, null);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.launchUrl", ""), (InterfaceC0640l) gVar.a(), null);
        if (tVar != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b() { // from class: C2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    List C3;
                    String shortString;
                    List C4;
                    t tVar2;
                    List C5;
                    List C6;
                    List C7;
                    switch (i5) {
                        case 0:
                            f fVar = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            try {
                                t tVar3 = (t) fVar;
                                tVar3.getClass();
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(str));
                                ComponentName resolveActivity = intent.resolveActivity(((Context) ((c) tVar3.f100h).f261g).getPackageManager());
                                if (resolveActivity == null) {
                                    shortString = null;
                                } else {
                                    shortString = resolveActivity.toShortString();
                                }
                                if (shortString != null) {
                                    z = !"{com.android.fallback/com.android.fallback.Fallback}".equals(shortString);
                                }
                                C3 = android.support.v4.media.session.a.p(Boolean.valueOf(z));
                            } catch (Throwable th) {
                                if (th instanceof b) {
                                    b bVar = th;
                                    C3 = I2.f.C(bVar.f258f, bVar.f259g, null);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            f fVar2 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            boolean z3 = false;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map map = (Map) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj5).booleanValue();
                            try {
                                tVar2 = (t) fVar2;
                            } catch (Throwable th2) {
                                if (th2 instanceof b) {
                                    b bVar2 = th2;
                                    C4 = I2.f.C(bVar2.f258f, bVar2.f259g, null);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            if (((Activity) tVar2.f101i) != null) {
                                Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(str2)).putExtra("com.android.browser.headers", t.D(map));
                                if (booleanValue && Build.VERSION.SDK_INT >= 30) {
                                    putExtra.addFlags(1024);
                                }
                                try {
                                    ((Activity) tVar2.f101i).startActivity(putExtra);
                                    z3 = true;
                                } catch (ActivityNotFoundException unused) {
                                }
                                C4 = android.support.v4.media.session.a.p(Boolean.valueOf(z3));
                                sVar.t(C4);
                                return;
                            }
                            throw new b();
                        case 2:
                            f fVar3 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj6 = list2.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list2.get(1);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj7).booleanValue();
                            Object obj8 = list2.get(2);
                            T2.h.c(obj8, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.WebViewOptions");
                            l lVar = (l) obj8;
                            Object obj9 = list2.get(3);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.BrowserOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(Boolean.valueOf(((t) fVar3).S(str3, booleanValue2, lVar, (a) obj9)));
                            } catch (Throwable th3) {
                                if (th3 instanceof b) {
                                    b bVar3 = th3;
                                    C5 = I2.f.C(bVar3.f258f, bVar3.f259g, null);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            try {
                                boolean z4 = false;
                                if (AbstractC0613h.a((Context) ((t) tVar).f99g, Collections.EMPTY_LIST, false) != null) {
                                    z4 = true;
                                }
                                C6 = android.support.v4.media.session.a.p(Boolean.valueOf(z4));
                            } catch (Throwable th4) {
                                if (th4 instanceof b) {
                                    b bVar4 = th4;
                                    C6 = I2.f.C(bVar4.f258f, bVar4.f259g, null);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            try {
                                ((Context) ((t) tVar).f99g).sendBroadcast(new Intent("close action"));
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof b) {
                                    b bVar5 = th5;
                                    C7 = I2.f.C(bVar5.f258f, bVar5.f259g, null);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.openUrlInApp", ""), (InterfaceC0640l) gVar.a(), null);
        if (tVar != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b() { // from class: C2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    List C3;
                    String shortString;
                    List C4;
                    t tVar2;
                    List C5;
                    List C6;
                    List C7;
                    switch (i6) {
                        case 0:
                            f fVar = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            try {
                                t tVar3 = (t) fVar;
                                tVar3.getClass();
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(str));
                                ComponentName resolveActivity = intent.resolveActivity(((Context) ((c) tVar3.f100h).f261g).getPackageManager());
                                if (resolveActivity == null) {
                                    shortString = null;
                                } else {
                                    shortString = resolveActivity.toShortString();
                                }
                                if (shortString != null) {
                                    z = !"{com.android.fallback/com.android.fallback.Fallback}".equals(shortString);
                                }
                                C3 = android.support.v4.media.session.a.p(Boolean.valueOf(z));
                            } catch (Throwable th) {
                                if (th instanceof b) {
                                    b bVar = th;
                                    C3 = I2.f.C(bVar.f258f, bVar.f259g, null);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            f fVar2 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            boolean z3 = false;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map map = (Map) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj5).booleanValue();
                            try {
                                tVar2 = (t) fVar2;
                            } catch (Throwable th2) {
                                if (th2 instanceof b) {
                                    b bVar2 = th2;
                                    C4 = I2.f.C(bVar2.f258f, bVar2.f259g, null);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            if (((Activity) tVar2.f101i) != null) {
                                Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(str2)).putExtra("com.android.browser.headers", t.D(map));
                                if (booleanValue && Build.VERSION.SDK_INT >= 30) {
                                    putExtra.addFlags(1024);
                                }
                                try {
                                    ((Activity) tVar2.f101i).startActivity(putExtra);
                                    z3 = true;
                                } catch (ActivityNotFoundException unused) {
                                }
                                C4 = android.support.v4.media.session.a.p(Boolean.valueOf(z3));
                                sVar.t(C4);
                                return;
                            }
                            throw new b();
                        case 2:
                            f fVar3 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj6 = list2.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list2.get(1);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj7).booleanValue();
                            Object obj8 = list2.get(2);
                            T2.h.c(obj8, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.WebViewOptions");
                            l lVar = (l) obj8;
                            Object obj9 = list2.get(3);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.BrowserOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(Boolean.valueOf(((t) fVar3).S(str3, booleanValue2, lVar, (a) obj9)));
                            } catch (Throwable th3) {
                                if (th3 instanceof b) {
                                    b bVar3 = th3;
                                    C5 = I2.f.C(bVar3.f258f, bVar3.f259g, null);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            try {
                                boolean z4 = false;
                                if (AbstractC0613h.a((Context) ((t) tVar).f99g, Collections.EMPTY_LIST, false) != null) {
                                    z4 = true;
                                }
                                C6 = android.support.v4.media.session.a.p(Boolean.valueOf(z4));
                            } catch (Throwable th4) {
                                if (th4 instanceof b) {
                                    b bVar4 = th4;
                                    C6 = I2.f.C(bVar4.f258f, bVar4.f259g, null);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            try {
                                ((Context) ((t) tVar).f99g).sendBroadcast(new Intent("close action"));
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof b) {
                                    b bVar5 = th5;
                                    C7 = I2.f.C(bVar5.f258f, bVar5.f259g, null);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        y yVar4 = new y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.supportsCustomTabs", ""), (InterfaceC0640l) gVar.a(), null);
        if (tVar != null) {
            final int i7 = 3;
            yVar4.w(new InterfaceC0630b() { // from class: C2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    List C3;
                    String shortString;
                    List C4;
                    t tVar2;
                    List C5;
                    List C6;
                    List C7;
                    switch (i7) {
                        case 0:
                            f fVar = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            try {
                                t tVar3 = (t) fVar;
                                tVar3.getClass();
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(str));
                                ComponentName resolveActivity = intent.resolveActivity(((Context) ((c) tVar3.f100h).f261g).getPackageManager());
                                if (resolveActivity == null) {
                                    shortString = null;
                                } else {
                                    shortString = resolveActivity.toShortString();
                                }
                                if (shortString != null) {
                                    z = !"{com.android.fallback/com.android.fallback.Fallback}".equals(shortString);
                                }
                                C3 = android.support.v4.media.session.a.p(Boolean.valueOf(z));
                            } catch (Throwable th) {
                                if (th instanceof b) {
                                    b bVar = th;
                                    C3 = I2.f.C(bVar.f258f, bVar.f259g, null);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            f fVar2 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            boolean z3 = false;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map map = (Map) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj5).booleanValue();
                            try {
                                tVar2 = (t) fVar2;
                            } catch (Throwable th2) {
                                if (th2 instanceof b) {
                                    b bVar2 = th2;
                                    C4 = I2.f.C(bVar2.f258f, bVar2.f259g, null);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            if (((Activity) tVar2.f101i) != null) {
                                Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(str2)).putExtra("com.android.browser.headers", t.D(map));
                                if (booleanValue && Build.VERSION.SDK_INT >= 30) {
                                    putExtra.addFlags(1024);
                                }
                                try {
                                    ((Activity) tVar2.f101i).startActivity(putExtra);
                                    z3 = true;
                                } catch (ActivityNotFoundException unused) {
                                }
                                C4 = android.support.v4.media.session.a.p(Boolean.valueOf(z3));
                                sVar.t(C4);
                                return;
                            }
                            throw new b();
                        case 2:
                            f fVar3 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj6 = list2.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list2.get(1);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj7).booleanValue();
                            Object obj8 = list2.get(2);
                            T2.h.c(obj8, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.WebViewOptions");
                            l lVar = (l) obj8;
                            Object obj9 = list2.get(3);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.BrowserOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(Boolean.valueOf(((t) fVar3).S(str3, booleanValue2, lVar, (a) obj9)));
                            } catch (Throwable th3) {
                                if (th3 instanceof b) {
                                    b bVar3 = th3;
                                    C5 = I2.f.C(bVar3.f258f, bVar3.f259g, null);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            try {
                                boolean z4 = false;
                                if (AbstractC0613h.a((Context) ((t) tVar).f99g, Collections.EMPTY_LIST, false) != null) {
                                    z4 = true;
                                }
                                C6 = android.support.v4.media.session.a.p(Boolean.valueOf(z4));
                            } catch (Throwable th4) {
                                if (th4 instanceof b) {
                                    b bVar4 = th4;
                                    C6 = I2.f.C(bVar4.f258f, bVar4.f259g, null);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            try {
                                ((Context) ((t) tVar).f99g).sendBroadcast(new Intent("close action"));
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof b) {
                                    b bVar5 = th5;
                                    C7 = I2.f.C(bVar5.f258f, bVar5.f259g, null);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
        y yVar5 = new y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.closeWebView", ""), (InterfaceC0640l) gVar.a(), null);
        if (tVar != null) {
            final int i8 = 4;
            yVar5.w(new InterfaceC0630b() { // from class: C2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    List C3;
                    String shortString;
                    List C4;
                    t tVar2;
                    List C5;
                    List C6;
                    List C7;
                    switch (i8) {
                        case 0:
                            f fVar = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            boolean z = false;
                            Object obj2 = ((List) obj).get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            try {
                                t tVar3 = (t) fVar;
                                tVar3.getClass();
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(str));
                                ComponentName resolveActivity = intent.resolveActivity(((Context) ((c) tVar3.f100h).f261g).getPackageManager());
                                if (resolveActivity == null) {
                                    shortString = null;
                                } else {
                                    shortString = resolveActivity.toShortString();
                                }
                                if (shortString != null) {
                                    z = !"{com.android.fallback/com.android.fallback.Fallback}".equals(shortString);
                                }
                                C3 = android.support.v4.media.session.a.p(Boolean.valueOf(z));
                            } catch (Throwable th) {
                                if (th instanceof b) {
                                    b bVar = th;
                                    C3 = I2.f.C(bVar.f258f, bVar.f259g, null);
                                } else {
                                    C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            f fVar2 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            boolean z3 = false;
                            Object obj3 = list.get(0);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj3;
                            Object obj4 = list.get(1);
                            T2.h.c(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            Map map = (Map) obj4;
                            Object obj5 = list.get(2);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj5).booleanValue();
                            try {
                                tVar2 = (t) fVar2;
                            } catch (Throwable th2) {
                                if (th2 instanceof b) {
                                    b bVar2 = th2;
                                    C4 = I2.f.C(bVar2.f258f, bVar2.f259g, null);
                                } else {
                                    C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            if (((Activity) tVar2.f101i) != null) {
                                Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(str2)).putExtra("com.android.browser.headers", t.D(map));
                                if (booleanValue && Build.VERSION.SDK_INT >= 30) {
                                    putExtra.addFlags(1024);
                                }
                                try {
                                    ((Activity) tVar2.f101i).startActivity(putExtra);
                                    z3 = true;
                                } catch (ActivityNotFoundException unused) {
                                }
                                C4 = android.support.v4.media.session.a.p(Boolean.valueOf(z3));
                                sVar.t(C4);
                                return;
                            }
                            throw new b();
                        case 2:
                            f fVar3 = tVar;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj6 = list2.get(0);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list2.get(1);
                            T2.h.c(obj7, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue2 = ((Boolean) obj7).booleanValue();
                            Object obj8 = list2.get(2);
                            T2.h.c(obj8, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.WebViewOptions");
                            l lVar = (l) obj8;
                            Object obj9 = list2.get(3);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.BrowserOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(Boolean.valueOf(((t) fVar3).S(str3, booleanValue2, lVar, (a) obj9)));
                            } catch (Throwable th3) {
                                if (th3 instanceof b) {
                                    b bVar3 = th3;
                                    C5 = I2.f.C(bVar3.f258f, bVar3.f259g, null);
                                } else {
                                    C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            try {
                                boolean z4 = false;
                                if (AbstractC0613h.a((Context) ((t) tVar).f99g, Collections.EMPTY_LIST, false) != null) {
                                    z4 = true;
                                }
                                C6 = android.support.v4.media.session.a.p(Boolean.valueOf(z4));
                            } catch (Throwable th4) {
                                if (th4 instanceof b) {
                                    b bVar4 = th4;
                                    C6 = I2.f.C(bVar4.f258f, bVar4.f259g, null);
                                } else {
                                    C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            sVar.t(C6);
                            return;
                        default:
                            try {
                                ((Context) ((t) tVar).f99g).sendBroadcast(new Intent("close action"));
                                C7 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th5) {
                                if (th5 instanceof b) {
                                    b bVar5 = th5;
                                    C7 = I2.f.C(bVar5.f258f, bVar5.f259g, null);
                                } else {
                                    C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            sVar.t(C7);
                            return;
                    }
                }
            });
        } else {
            yVar5.w(null);
        }
    }
}
