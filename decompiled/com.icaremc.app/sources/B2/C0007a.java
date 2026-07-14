package B2;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;

/* renamed from: B2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0007a implements o2.c {

    /* renamed from: f, reason: collision with root package name */
    public SharedPreferences f184f;

    /* renamed from: g, reason: collision with root package name */
    public final Z0.g f185g = new Object();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [s2.k, java.lang.Object] */
    public static void d(InterfaceC0634f interfaceC0634f, final C0007a c0007a) {
        W0.g h3 = interfaceC0634f.h(new Object());
        C0008b c0008b = C0008b.f186e;
        P1.y yVar = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.remove", c0008b, h3);
        if (c0007a != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i4) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        P1.y yVar2 = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setBool", c0008b, h3);
        if (c0007a != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i5) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        P1.y yVar3 = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setString", c0008b, h3);
        if (c0007a != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i6) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
        P1.y yVar4 = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setInt", c0008b, h3);
        if (c0007a != null) {
            final int i7 = 3;
            yVar4.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i7) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar4.w(null);
        }
        P1.y yVar5 = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDouble", c0008b, h3);
        if (c0007a != null) {
            final int i8 = 4;
            yVar5.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i8) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar5.w(null);
        }
        P1.y yVar6 = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setEncodedStringList", c0008b, h3);
        if (c0007a != null) {
            final int i9 = 5;
            yVar6.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i9) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar6.w(null);
        }
        P1.y yVar7 = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDeprecatedStringList", c0008b, h3);
        if (c0007a != null) {
            final int i10 = 6;
            yVar7.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i10) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar7.w(null);
        }
        P1.y yVar8 = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.clear", c0008b, h3);
        if (c0007a != null) {
            final int i11 = 7;
            yVar8.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i11) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar8.w(null);
        }
        P1.y yVar9 = new P1.y(interfaceC0634f, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.getAll", c0008b, h3);
        if (c0007a != null) {
            final int i12 = 8;
            yVar9.w(new InterfaceC0630b(c0007a) { // from class: B2.c

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ C0007a f189g;

                {
                    this.f189g = c0007a;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, io.flutter.plugin.platform.s sVar) {
                    switch (i12) {
                        case 0:
                            C0007a c0007a2 = this.f189g;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(c0007a2.f184f.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = android.support.v4.media.session.a.z(th);
                            }
                            sVar.t(arrayList);
                            return;
                        case 1:
                            C0007a c0007a3 = this.f189g;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(c0007a3.f184f.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = android.support.v4.media.session.a.z(th2);
                            }
                            sVar.t(arrayList2);
                            return;
                        case 2:
                            C0007a c0007a4 = this.f189g;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, c0007a4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = android.support.v4.media.session.a.z(th3);
                            }
                            sVar.t(arrayList4);
                            return;
                        case 3:
                            C0007a c0007a5 = this.f189g;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(c0007a5.f184f.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = android.support.v4.media.session.a.z(th4);
                            }
                            sVar.t(arrayList6);
                            return;
                        case 4:
                            C0007a c0007a6 = this.f189g;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d4 = (Double) arrayList9.get(1);
                            try {
                                c0007a6.getClass();
                                String d5 = Double.toString(d4.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(c0007a6.f184f.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d5).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = android.support.v4.media.session.a.z(th5);
                            }
                            sVar.t(arrayList8);
                            return;
                        case 5:
                            C0007a c0007a7 = this.f189g;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(c0007a7.f184f.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = android.support.v4.media.session.a.z(th6);
                            }
                            sVar.t(arrayList10);
                            return;
                        case 6:
                            C0007a c0007a8 = this.f189g;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(c0007a8.f184f.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0007a8.f185g.c(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = android.support.v4.media.session.a.z(th7);
                            }
                            sVar.t(arrayList12);
                            return;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            C0007a c0007a9 = this.f189g;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, c0007a9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = android.support.v4.media.session.a.z(th8);
                            }
                            sVar.t(arrayList14);
                            return;
                        default:
                            C0007a c0007a10 = this.f189g;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, c0007a10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = android.support.v4.media.session.a.z(th9);
                            }
                            sVar.t(arrayList16);
                            return;
                    }
                }
            });
        } else {
            yVar9.w(null);
        }
    }

    public final Boolean a(String str, List list) {
        SharedPreferences.Editor edit = this.f184f.edit();
        Map<String, ?> all = this.f184f.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (list == null || list.contains(str2))) {
                arrayList.add(str2);
            }
        }
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            edit.remove((String) obj);
        }
        return Boolean.valueOf(edit.commit());
    }

    public final HashMap b(String str, List list) {
        Set hashSet;
        Object obj;
        if (list == null) {
            hashSet = null;
        } else {
            hashSet = new HashSet(list);
        }
        Map<String, ?> all = this.f184f.getAll();
        HashMap hashMap = new HashMap();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (hashSet == null || hashSet.contains(str2))) {
                Object obj2 = all.get(str2);
                Objects.requireNonNull(obj2);
                boolean z = obj2 instanceof String;
                Z0.g gVar = this.f185g;
                if (z) {
                    String str3 = (String) obj2;
                    if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                        if (!str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!")) {
                            String substring = str3.substring(40);
                            gVar.getClass();
                            try {
                                obj2 = (List) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(substring, 0))).readObject();
                            } catch (IOException | ClassNotFoundException e4) {
                                throw new RuntimeException(e4);
                            }
                        }
                    } else if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
                        obj = new BigInteger(str3.substring(44), 36);
                        obj2 = obj;
                    } else if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                        obj2 = Double.valueOf(str3.substring(40));
                    }
                    hashMap.put(str2, obj2);
                } else {
                    if (obj2 instanceof Set) {
                        ArrayList arrayList = new ArrayList((Set) obj2);
                        this.f184f.edit().remove(str2).putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + gVar.c(arrayList)).apply();
                        obj = arrayList;
                        obj2 = obj;
                    }
                    hashMap.put(str2, obj2);
                }
            }
        }
        return hashMap;
    }

    public final Boolean c(String str, String str2) {
        if (!str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") && !str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy") && !str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
            return Boolean.valueOf(this.f184f.edit().putString(str, str2).commit());
        }
        throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        this.f184f = bVar.f5785a.getSharedPreferences("FlutterSharedPreferences", 0);
        try {
            d(interfaceC0634f, this);
        } catch (Exception e4) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e4);
        }
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        d(bVar.f5787c, null);
    }
}
