package B2;

import android.util.Log;
import java.util.List;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;
import s2.InterfaceC0640l;

/* renamed from: B2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0011e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C0011e f192a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final H2.g f193b = new H2.g(new A2.f(1));

    public static InterfaceC0640l a() {
        return (InterfaceC0640l) f193b.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [s2.k, java.lang.Object] */
    public static void b(InterfaceC0634f interfaceC0634f, final InterfaceC0012f interfaceC0012f, String str) {
        String str2;
        T2.h.e(interfaceC0634f, "binaryMessenger");
        if (str.length() > 0) {
            str2 = ".".concat(str);
        } else {
            str2 = "";
        }
        W0.g h3 = interfaceC0634f.h(new Object());
        P1.y yVar = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setBool", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i4 = 6;
            yVar.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i4) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        P1.y yVar2 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setString", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i5 = 12;
            yVar2.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i5) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        P1.y yVar3 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setInt", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i6 = 13;
            yVar3.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i6) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        P1.y yVar4 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDouble", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i7 = 14;
            yVar4.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i7) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
        P1.y yVar5 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setEncodedStringList", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i8 = 0;
            yVar5.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i8) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar5.w(null);
        }
        P1.y yVar6 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDeprecatedStringList", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i9 = 1;
            yVar6.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i9) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar6.w(null);
        }
        P1.y yVar7 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getString", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i10 = 2;
            yVar7.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i10) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar7.w(null);
        }
        P1.y yVar8 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getBool", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i11 = 3;
            yVar8.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i11) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar8.w(null);
        }
        P1.y yVar9 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getDouble", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i12 = 4;
            yVar9.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i12) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar9.w(null);
        }
        P1.y yVar10 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getInt", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i13 = 5;
            yVar10.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i13) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar10.w(null);
        }
        P1.y yVar11 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getPlatformEncodedStringList", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i14 = 7;
            yVar11.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i14) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar11.w(null);
        }
        P1.y yVar12 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getStringList", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i15 = 8;
            yVar12.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i15) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar12.w(null);
        }
        P1.y yVar13 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.clear", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i16 = 9;
            yVar13.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i16) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar13.w(null);
        }
        P1.y yVar14 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getAll", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i17 = 10;
            yVar14.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i17) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar14.w(null);
        }
        P1.y yVar15 = new P1.y(interfaceC0634f, r2.k.d("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getKeys", str2), a(), h3);
        if (interfaceC0012f != null) {
            final int i18 = 11;
            yVar15.w(new InterfaceC0630b() { // from class: B2.d
                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    List C3;
                    List C4;
                    List C5;
                    List C6;
                    List C7;
                    List C8;
                    List C9;
                    List C10;
                    List C11;
                    List C12;
                    List C13;
                    List C14;
                    List C15;
                    List C16;
                    List C17;
                    switch (i18) {
                        case 0:
                            InterfaceC0012f interfaceC0012f2 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            T2.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj2;
                            Object obj3 = list.get(1);
                            T2.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj3;
                            Object obj4 = list.get(2);
                            T2.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f2.i(str3, str4, (C0013g) obj4);
                                C3 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th) {
                                C3 = I2.f.C(th.getClass().getSimpleName(), th.toString(), A2.i.i("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                            }
                            sVar.t(C3);
                            return;
                        case 1:
                            InterfaceC0012f interfaceC0012f3 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            T2.h.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj5;
                            Object obj6 = list2.get(1);
                            T2.h.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            T2.h.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f3.t(str5, list3, (C0013g) obj7);
                                C4 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th2) {
                                C4 = I2.f.C(th2.getClass().getSimpleName(), th2.toString(), A2.i.i("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                            }
                            sVar.t(C4);
                            return;
                        case 2:
                            InterfaceC0012f interfaceC0012f4 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            T2.h.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj8;
                            Object obj9 = list4.get(1);
                            T2.h.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C5 = android.support.v4.media.session.a.p(interfaceC0012f4.s(str6, (C0013g) obj9));
                            } catch (Throwable th3) {
                                C5 = I2.f.C(th3.getClass().getSimpleName(), th3.toString(), A2.i.i("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                            }
                            sVar.t(C5);
                            return;
                        case 3:
                            InterfaceC0012f interfaceC0012f5 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            T2.h.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj10;
                            Object obj11 = list5.get(1);
                            T2.h.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C6 = android.support.v4.media.session.a.p(interfaceC0012f5.l(str7, (C0013g) obj11));
                            } catch (Throwable th4) {
                                C6 = I2.f.C(th4.getClass().getSimpleName(), th4.toString(), A2.i.i("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                            }
                            sVar.t(C6);
                            return;
                        case 4:
                            InterfaceC0012f interfaceC0012f6 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            T2.h.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj12;
                            Object obj13 = list6.get(1);
                            T2.h.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C7 = android.support.v4.media.session.a.p(interfaceC0012f6.a(str8, (C0013g) obj13));
                            } catch (Throwable th5) {
                                C7 = I2.f.C(th5.getClass().getSimpleName(), th5.toString(), A2.i.i("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                            }
                            sVar.t(C7);
                            return;
                        case 5:
                            InterfaceC0012f interfaceC0012f7 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            T2.h.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj14;
                            Object obj15 = list7.get(1);
                            T2.h.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C8 = android.support.v4.media.session.a.p(interfaceC0012f7.e(str9, (C0013g) obj15));
                            } catch (Throwable th6) {
                                C8 = I2.f.C(th6.getClass().getSimpleName(), th6.toString(), A2.i.i("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                            }
                            sVar.t(C8);
                            return;
                        case 6:
                            InterfaceC0012f interfaceC0012f8 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            T2.h.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj16;
                            Object obj17 = list8.get(1);
                            T2.h.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean booleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            T2.h.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f8.b(str10, booleanValue, (C0013g) obj18);
                                C9 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th7) {
                                C9 = I2.f.C(th7.getClass().getSimpleName(), th7.toString(), A2.i.i("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                            }
                            sVar.t(C9);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            InterfaceC0012f interfaceC0012f9 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            T2.h.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj19;
                            Object obj20 = list9.get(1);
                            T2.h.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C10 = android.support.v4.media.session.a.p(interfaceC0012f9.o(str11, (C0013g) obj20));
                            } catch (Throwable th8) {
                                C10 = I2.f.C(th8.getClass().getSimpleName(), th8.toString(), A2.i.i("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                            }
                            sVar.t(C10);
                            return;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            InterfaceC0012f interfaceC0012f10 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            T2.h.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj21;
                            Object obj22 = list10.get(1);
                            T2.h.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C11 = android.support.v4.media.session.a.p(interfaceC0012f10.v(str12, (C0013g) obj22));
                            } catch (Throwable th9) {
                                C11 = I2.f.C(th9.getClass().getSimpleName(), th9.toString(), A2.i.i("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                            }
                            sVar.t(C11);
                            return;
                        case 9:
                            InterfaceC0012f interfaceC0012f11 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            T2.h.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f11.f(list12, (C0013g) obj23);
                                C12 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th10) {
                                C12 = I2.f.C(th10.getClass().getSimpleName(), th10.toString(), A2.i.i("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                            }
                            sVar.t(C12);
                            return;
                        case 10:
                            InterfaceC0012f interfaceC0012f12 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            T2.h.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C13 = android.support.v4.media.session.a.p(interfaceC0012f12.w(list14, (C0013g) obj24));
                            } catch (Throwable th11) {
                                C13 = I2.f.C(th11.getClass().getSimpleName(), th11.toString(), A2.i.i("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                            }
                            sVar.t(C13);
                            return;
                        case 11:
                            InterfaceC0012f interfaceC0012f13 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            T2.h.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                C14 = android.support.v4.media.session.a.p(interfaceC0012f13.d(list16, (C0013g) obj25));
                            } catch (Throwable th12) {
                                C14 = I2.f.C(th12.getClass().getSimpleName(), th12.toString(), A2.i.i("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                            }
                            sVar.t(C14);
                            return;
                        case 12:
                            InterfaceC0012f interfaceC0012f14 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            T2.h.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj26;
                            Object obj27 = list17.get(1);
                            T2.h.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj27;
                            Object obj28 = list17.get(2);
                            T2.h.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f14.c(str13, str14, (C0013g) obj28);
                                C15 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th13) {
                                C15 = I2.f.C(th13.getClass().getSimpleName(), th13.toString(), A2.i.i("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                            }
                            sVar.t(C15);
                            return;
                        case 13:
                            InterfaceC0012f interfaceC0012f15 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            T2.h.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj29;
                            Object obj30 = list18.get(1);
                            T2.h.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long longValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            T2.h.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f15.r(str15, longValue, (C0013g) obj31);
                                C16 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th14) {
                                C16 = I2.f.C(th14.getClass().getSimpleName(), th14.toString(), A2.i.i("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                            }
                            sVar.t(C16);
                            return;
                        default:
                            InterfaceC0012f interfaceC0012f16 = interfaceC0012f;
                            T2.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            T2.h.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str16 = (String) obj32;
                            Object obj33 = list19.get(1);
                            T2.h.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double doubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            T2.h.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0012f16.k(str16, doubleValue, (C0013g) obj34);
                                C17 = android.support.v4.media.session.a.p(null);
                            } catch (Throwable th15) {
                                C17 = I2.f.C(th15.getClass().getSimpleName(), th15.toString(), A2.i.i("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                            }
                            sVar.t(C17);
                            return;
                    }
                }
            });
        } else {
            yVar15.w(null);
        }
    }
}
