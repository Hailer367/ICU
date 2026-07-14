package x2;

import D2.J;
import P1.y;
import io.flutter.plugin.platform.s;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import java.util.ArrayList;
import java.util.HashMap;
import p1.C0580i;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public interface j {
    static void b(InterfaceC0634f interfaceC0634f, final d dVar) {
        m mVar = m.f6533d;
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.setAutomaticDataCollectionEnabled", mVar, null);
        if (dVar != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b(dVar) { // from class: x2.h

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ j f6527g;

                {
                    this.f6527g = dVar;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    switch (i4) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) obj;
                            final String str = (String) arrayList2.get(0);
                            final Boolean bool = (Boolean) arrayList2.get(1);
                            i iVar = new i(arrayList, sVar, 0);
                            ((d) this.f6527g).getClass();
                            final C0580i c0580i = new C0580i();
                            final int i5 = 1;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i6 = i5;
                                    C0580i c0580i2 = c0580i;
                                    Boolean bool2 = bool;
                                    String str2 = str;
                                    switch (i6) {
                                        case 0:
                                            HashMap hashMap = d.f6504h;
                                            try {
                                                u1.f e4 = u1.f.e(str2);
                                                boolean booleanValue = bool2.booleanValue();
                                                e4.a();
                                                if (e4.f6225e.compareAndSet(!booleanValue, booleanValue)) {
                                                    boolean z = Y0.c.f2021j.f2022f.get();
                                                    if (booleanValue && z) {
                                                        e4.j(true);
                                                    } else if (!booleanValue && z) {
                                                        e4.j(false);
                                                    }
                                                }
                                                c0580i2.b(null);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i2.a(e5);
                                                return;
                                            }
                                        default:
                                            HashMap hashMap2 = d.f6504h;
                                            try {
                                                u1.f.e(str2).k(bool2);
                                                c0580i2.b(null);
                                                return;
                                            } catch (Exception e6) {
                                                c0580i2.a(e6);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i.f5821a.h(new J(22, iVar));
                            return;
                        case 1:
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = (ArrayList) obj;
                            final String str2 = (String) arrayList4.get(0);
                            final Boolean bool2 = (Boolean) arrayList4.get(1);
                            i iVar2 = new i(arrayList3, sVar, 1);
                            ((d) this.f6527g).getClass();
                            final C0580i c0580i2 = new C0580i();
                            final int i6 = 0;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i62 = i6;
                                    C0580i c0580i22 = c0580i2;
                                    Boolean bool22 = bool2;
                                    String str22 = str2;
                                    switch (i62) {
                                        case 0:
                                            HashMap hashMap = d.f6504h;
                                            try {
                                                u1.f e4 = u1.f.e(str22);
                                                boolean booleanValue = bool22.booleanValue();
                                                e4.a();
                                                if (e4.f6225e.compareAndSet(!booleanValue, booleanValue)) {
                                                    boolean z = Y0.c.f2021j.f2022f.get();
                                                    if (booleanValue && z) {
                                                        e4.j(true);
                                                    } else if (!booleanValue && z) {
                                                        e4.j(false);
                                                    }
                                                }
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i22.a(e5);
                                                return;
                                            }
                                        default:
                                            HashMap hashMap2 = d.f6504h;
                                            try {
                                                u1.f.e(str22).k(bool22);
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e6) {
                                                c0580i22.a(e6);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i2.f5821a.h(new J(22, iVar2));
                            return;
                        default:
                            ArrayList arrayList5 = new ArrayList();
                            String str3 = (String) ((ArrayList) obj).get(0);
                            i iVar3 = new i(arrayList5, sVar, 2);
                            ((d) this.f6527g).getClass();
                            C0580i c0580i3 = new C0580i();
                            FlutterFirebasePlugin.cachedThreadPool.execute(new A.j(11, str3, c0580i3));
                            c0580i3.f5821a.h(new J(22, iVar3));
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.setAutomaticResourceManagementEnabled", mVar, null);
        if (dVar != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b(dVar) { // from class: x2.h

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ j f6527g;

                {
                    this.f6527g = dVar;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    switch (i5) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) obj;
                            final String str = (String) arrayList2.get(0);
                            final Boolean bool = (Boolean) arrayList2.get(1);
                            i iVar = new i(arrayList, sVar, 0);
                            ((d) this.f6527g).getClass();
                            final C0580i c0580i = new C0580i();
                            final int i52 = 1;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i62 = i52;
                                    C0580i c0580i22 = c0580i;
                                    Boolean bool22 = bool;
                                    String str22 = str;
                                    switch (i62) {
                                        case 0:
                                            HashMap hashMap = d.f6504h;
                                            try {
                                                u1.f e4 = u1.f.e(str22);
                                                boolean booleanValue = bool22.booleanValue();
                                                e4.a();
                                                if (e4.f6225e.compareAndSet(!booleanValue, booleanValue)) {
                                                    boolean z = Y0.c.f2021j.f2022f.get();
                                                    if (booleanValue && z) {
                                                        e4.j(true);
                                                    } else if (!booleanValue && z) {
                                                        e4.j(false);
                                                    }
                                                }
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i22.a(e5);
                                                return;
                                            }
                                        default:
                                            HashMap hashMap2 = d.f6504h;
                                            try {
                                                u1.f.e(str22).k(bool22);
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e6) {
                                                c0580i22.a(e6);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i.f5821a.h(new J(22, iVar));
                            return;
                        case 1:
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = (ArrayList) obj;
                            final String str2 = (String) arrayList4.get(0);
                            final Boolean bool2 = (Boolean) arrayList4.get(1);
                            i iVar2 = new i(arrayList3, sVar, 1);
                            ((d) this.f6527g).getClass();
                            final C0580i c0580i2 = new C0580i();
                            final int i6 = 0;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i62 = i6;
                                    C0580i c0580i22 = c0580i2;
                                    Boolean bool22 = bool2;
                                    String str22 = str2;
                                    switch (i62) {
                                        case 0:
                                            HashMap hashMap = d.f6504h;
                                            try {
                                                u1.f e4 = u1.f.e(str22);
                                                boolean booleanValue = bool22.booleanValue();
                                                e4.a();
                                                if (e4.f6225e.compareAndSet(!booleanValue, booleanValue)) {
                                                    boolean z = Y0.c.f2021j.f2022f.get();
                                                    if (booleanValue && z) {
                                                        e4.j(true);
                                                    } else if (!booleanValue && z) {
                                                        e4.j(false);
                                                    }
                                                }
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i22.a(e5);
                                                return;
                                            }
                                        default:
                                            HashMap hashMap2 = d.f6504h;
                                            try {
                                                u1.f.e(str22).k(bool22);
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e6) {
                                                c0580i22.a(e6);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i2.f5821a.h(new J(22, iVar2));
                            return;
                        default:
                            ArrayList arrayList5 = new ArrayList();
                            String str3 = (String) ((ArrayList) obj).get(0);
                            i iVar3 = new i(arrayList5, sVar, 2);
                            ((d) this.f6527g).getClass();
                            C0580i c0580i3 = new C0580i();
                            FlutterFirebasePlugin.cachedThreadPool.execute(new A.j(11, str3, c0580i3));
                            c0580i3.f5821a.h(new J(22, iVar3));
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.delete", mVar, null);
        if (dVar != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b(dVar) { // from class: x2.h

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ j f6527g;

                {
                    this.f6527g = dVar;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    switch (i6) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) obj;
                            final String str = (String) arrayList2.get(0);
                            final Boolean bool = (Boolean) arrayList2.get(1);
                            i iVar = new i(arrayList, sVar, 0);
                            ((d) this.f6527g).getClass();
                            final C0580i c0580i = new C0580i();
                            final int i52 = 1;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i62 = i52;
                                    C0580i c0580i22 = c0580i;
                                    Boolean bool22 = bool;
                                    String str22 = str;
                                    switch (i62) {
                                        case 0:
                                            HashMap hashMap = d.f6504h;
                                            try {
                                                u1.f e4 = u1.f.e(str22);
                                                boolean booleanValue = bool22.booleanValue();
                                                e4.a();
                                                if (e4.f6225e.compareAndSet(!booleanValue, booleanValue)) {
                                                    boolean z = Y0.c.f2021j.f2022f.get();
                                                    if (booleanValue && z) {
                                                        e4.j(true);
                                                    } else if (!booleanValue && z) {
                                                        e4.j(false);
                                                    }
                                                }
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i22.a(e5);
                                                return;
                                            }
                                        default:
                                            HashMap hashMap2 = d.f6504h;
                                            try {
                                                u1.f.e(str22).k(bool22);
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e6) {
                                                c0580i22.a(e6);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i.f5821a.h(new J(22, iVar));
                            return;
                        case 1:
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = (ArrayList) obj;
                            final String str2 = (String) arrayList4.get(0);
                            final Boolean bool2 = (Boolean) arrayList4.get(1);
                            i iVar2 = new i(arrayList3, sVar, 1);
                            ((d) this.f6527g).getClass();
                            final C0580i c0580i2 = new C0580i();
                            final int i62 = 0;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i622 = i62;
                                    C0580i c0580i22 = c0580i2;
                                    Boolean bool22 = bool2;
                                    String str22 = str2;
                                    switch (i622) {
                                        case 0:
                                            HashMap hashMap = d.f6504h;
                                            try {
                                                u1.f e4 = u1.f.e(str22);
                                                boolean booleanValue = bool22.booleanValue();
                                                e4.a();
                                                if (e4.f6225e.compareAndSet(!booleanValue, booleanValue)) {
                                                    boolean z = Y0.c.f2021j.f2022f.get();
                                                    if (booleanValue && z) {
                                                        e4.j(true);
                                                    } else if (!booleanValue && z) {
                                                        e4.j(false);
                                                    }
                                                }
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i22.a(e5);
                                                return;
                                            }
                                        default:
                                            HashMap hashMap2 = d.f6504h;
                                            try {
                                                u1.f.e(str22).k(bool22);
                                                c0580i22.b(null);
                                                return;
                                            } catch (Exception e6) {
                                                c0580i22.a(e6);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i2.f5821a.h(new J(22, iVar2));
                            return;
                        default:
                            ArrayList arrayList5 = new ArrayList();
                            String str3 = (String) ((ArrayList) obj).get(0);
                            i iVar3 = new i(arrayList5, sVar, 2);
                            ((d) this.f6527g).getClass();
                            C0580i c0580i3 = new C0580i();
                            FlutterFirebasePlugin.cachedThreadPool.execute(new A.j(11, str3, c0580i3));
                            c0580i3.f5821a.h(new J(22, iVar3));
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
    }
}
