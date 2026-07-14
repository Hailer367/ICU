package x2;

import D2.J;
import D2.Z;
import P1.y;
import io.flutter.plugin.platform.s;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import p1.C0580i;
import q1.AbstractC0602b;
import s2.InterfaceC0630b;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public interface l {
    static void a(InterfaceC0634f interfaceC0634f, final d dVar) {
        m mVar = m.f6533d;
        y yVar = new y(interfaceC0634f, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.initializeApp", mVar, null);
        if (dVar != null) {
            final int i4 = 0;
            yVar.w(new InterfaceC0630b(dVar) { // from class: x2.k

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ l f6532g;

                {
                    this.f6532g = dVar;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    switch (i4) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) obj;
                            String str = (String) arrayList2.get(0);
                            f fVar = (f) arrayList2.get(1);
                            i iVar = new i(arrayList, sVar, 3);
                            d dVar2 = (d) this.f6532g;
                            dVar2.getClass();
                            C0580i c0580i = new C0580i();
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Z(dVar2, fVar, str, c0580i, 4));
                            c0580i.f5821a.h(new J(23, iVar));
                            return;
                        case 1:
                            i iVar2 = new i(new ArrayList(), sVar, 4);
                            final d dVar3 = (d) this.f6532g;
                            dVar3.getClass();
                            final C0580i c0580i2 = new C0580i();
                            final int i5 = 1;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ArrayList arrayList3;
                                    switch (i5) {
                                        case 0:
                                            d dVar4 = dVar3;
                                            C0580i c0580i3 = c0580i2;
                                            HashMap hashMap = d.f6504h;
                                            dVar4.getClass();
                                            try {
                                                u1.g a4 = u1.g.a(dVar4.f6505f);
                                                if (a4 == null) {
                                                    c0580i3.a(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
                                                } else {
                                                    c0580i3.b(d.c(a4));
                                                }
                                                return;
                                            } catch (Exception e4) {
                                                c0580i3.a(e4);
                                                return;
                                            }
                                        default:
                                            d dVar5 = dVar3;
                                            C0580i c0580i4 = c0580i2;
                                            HashMap hashMap2 = d.f6504h;
                                            dVar5.getClass();
                                            try {
                                                if (!dVar5.f6506g) {
                                                    dVar5.f6506g = true;
                                                } else {
                                                    AbstractC0602b.c(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
                                                }
                                                synchronized (u1.f.k) {
                                                    arrayList3 = new ArrayList(u1.f.f6220l.values());
                                                }
                                                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                                                int size = arrayList3.size();
                                                int i6 = 0;
                                                while (i6 < size) {
                                                    Object obj2 = arrayList3.get(i6);
                                                    i6++;
                                                    C0580i c0580i5 = new C0580i();
                                                    FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(dVar5, (u1.f) obj2, c0580i5));
                                                    arrayList4.add((g) AbstractC0602b.c(c0580i5.f5821a));
                                                }
                                                c0580i4.b(arrayList4);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i4.a(e5);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i2.f5821a.h(new J(23, iVar2));
                            return;
                        default:
                            i iVar3 = new i(new ArrayList(), sVar, 5);
                            final d dVar4 = (d) this.f6532g;
                            dVar4.getClass();
                            final C0580i c0580i3 = new C0580i();
                            final int i6 = 0;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ArrayList arrayList3;
                                    switch (i6) {
                                        case 0:
                                            d dVar42 = dVar4;
                                            C0580i c0580i32 = c0580i3;
                                            HashMap hashMap = d.f6504h;
                                            dVar42.getClass();
                                            try {
                                                u1.g a4 = u1.g.a(dVar42.f6505f);
                                                if (a4 == null) {
                                                    c0580i32.a(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
                                                } else {
                                                    c0580i32.b(d.c(a4));
                                                }
                                                return;
                                            } catch (Exception e4) {
                                                c0580i32.a(e4);
                                                return;
                                            }
                                        default:
                                            d dVar5 = dVar4;
                                            C0580i c0580i4 = c0580i3;
                                            HashMap hashMap2 = d.f6504h;
                                            dVar5.getClass();
                                            try {
                                                if (!dVar5.f6506g) {
                                                    dVar5.f6506g = true;
                                                } else {
                                                    AbstractC0602b.c(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
                                                }
                                                synchronized (u1.f.k) {
                                                    arrayList3 = new ArrayList(u1.f.f6220l.values());
                                                }
                                                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                                                int size = arrayList3.size();
                                                int i62 = 0;
                                                while (i62 < size) {
                                                    Object obj2 = arrayList3.get(i62);
                                                    i62++;
                                                    C0580i c0580i5 = new C0580i();
                                                    FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(dVar5, (u1.f) obj2, c0580i5));
                                                    arrayList4.add((g) AbstractC0602b.c(c0580i5.f5821a));
                                                }
                                                c0580i4.b(arrayList4);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i4.a(e5);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i3.f5821a.h(new J(23, iVar3));
                            return;
                    }
                }
            });
        } else {
            yVar.w(null);
        }
        y yVar2 = new y(interfaceC0634f, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.initializeCore", mVar, null);
        if (dVar != null) {
            final int i5 = 1;
            yVar2.w(new InterfaceC0630b(dVar) { // from class: x2.k

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ l f6532g;

                {
                    this.f6532g = dVar;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    switch (i5) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) obj;
                            String str = (String) arrayList2.get(0);
                            f fVar = (f) arrayList2.get(1);
                            i iVar = new i(arrayList, sVar, 3);
                            d dVar2 = (d) this.f6532g;
                            dVar2.getClass();
                            C0580i c0580i = new C0580i();
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Z(dVar2, fVar, str, c0580i, 4));
                            c0580i.f5821a.h(new J(23, iVar));
                            return;
                        case 1:
                            i iVar2 = new i(new ArrayList(), sVar, 4);
                            final d dVar3 = (d) this.f6532g;
                            dVar3.getClass();
                            final C0580i c0580i2 = new C0580i();
                            final int i52 = 1;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ArrayList arrayList3;
                                    switch (i52) {
                                        case 0:
                                            d dVar42 = dVar3;
                                            C0580i c0580i32 = c0580i2;
                                            HashMap hashMap = d.f6504h;
                                            dVar42.getClass();
                                            try {
                                                u1.g a4 = u1.g.a(dVar42.f6505f);
                                                if (a4 == null) {
                                                    c0580i32.a(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
                                                } else {
                                                    c0580i32.b(d.c(a4));
                                                }
                                                return;
                                            } catch (Exception e4) {
                                                c0580i32.a(e4);
                                                return;
                                            }
                                        default:
                                            d dVar5 = dVar3;
                                            C0580i c0580i4 = c0580i2;
                                            HashMap hashMap2 = d.f6504h;
                                            dVar5.getClass();
                                            try {
                                                if (!dVar5.f6506g) {
                                                    dVar5.f6506g = true;
                                                } else {
                                                    AbstractC0602b.c(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
                                                }
                                                synchronized (u1.f.k) {
                                                    arrayList3 = new ArrayList(u1.f.f6220l.values());
                                                }
                                                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                                                int size = arrayList3.size();
                                                int i62 = 0;
                                                while (i62 < size) {
                                                    Object obj2 = arrayList3.get(i62);
                                                    i62++;
                                                    C0580i c0580i5 = new C0580i();
                                                    FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(dVar5, (u1.f) obj2, c0580i5));
                                                    arrayList4.add((g) AbstractC0602b.c(c0580i5.f5821a));
                                                }
                                                c0580i4.b(arrayList4);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i4.a(e5);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i2.f5821a.h(new J(23, iVar2));
                            return;
                        default:
                            i iVar3 = new i(new ArrayList(), sVar, 5);
                            final d dVar4 = (d) this.f6532g;
                            dVar4.getClass();
                            final C0580i c0580i3 = new C0580i();
                            final int i6 = 0;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ArrayList arrayList3;
                                    switch (i6) {
                                        case 0:
                                            d dVar42 = dVar4;
                                            C0580i c0580i32 = c0580i3;
                                            HashMap hashMap = d.f6504h;
                                            dVar42.getClass();
                                            try {
                                                u1.g a4 = u1.g.a(dVar42.f6505f);
                                                if (a4 == null) {
                                                    c0580i32.a(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
                                                } else {
                                                    c0580i32.b(d.c(a4));
                                                }
                                                return;
                                            } catch (Exception e4) {
                                                c0580i32.a(e4);
                                                return;
                                            }
                                        default:
                                            d dVar5 = dVar4;
                                            C0580i c0580i4 = c0580i3;
                                            HashMap hashMap2 = d.f6504h;
                                            dVar5.getClass();
                                            try {
                                                if (!dVar5.f6506g) {
                                                    dVar5.f6506g = true;
                                                } else {
                                                    AbstractC0602b.c(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
                                                }
                                                synchronized (u1.f.k) {
                                                    arrayList3 = new ArrayList(u1.f.f6220l.values());
                                                }
                                                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                                                int size = arrayList3.size();
                                                int i62 = 0;
                                                while (i62 < size) {
                                                    Object obj2 = arrayList3.get(i62);
                                                    i62++;
                                                    C0580i c0580i5 = new C0580i();
                                                    FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(dVar5, (u1.f) obj2, c0580i5));
                                                    arrayList4.add((g) AbstractC0602b.c(c0580i5.f5821a));
                                                }
                                                c0580i4.b(arrayList4);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i4.a(e5);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i3.f5821a.h(new J(23, iVar3));
                            return;
                    }
                }
            });
        } else {
            yVar2.w(null);
        }
        y yVar3 = new y(interfaceC0634f, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.optionsFromResource", mVar, null);
        if (dVar != null) {
            final int i6 = 2;
            yVar3.w(new InterfaceC0630b(dVar) { // from class: x2.k

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ l f6532g;

                {
                    this.f6532g = dVar;
                }

                @Override // s2.InterfaceC0630b
                public final void f(Object obj, s sVar) {
                    switch (i6) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) obj;
                            String str = (String) arrayList2.get(0);
                            f fVar = (f) arrayList2.get(1);
                            i iVar = new i(arrayList, sVar, 3);
                            d dVar2 = (d) this.f6532g;
                            dVar2.getClass();
                            C0580i c0580i = new C0580i();
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Z(dVar2, fVar, str, c0580i, 4));
                            c0580i.f5821a.h(new J(23, iVar));
                            return;
                        case 1:
                            i iVar2 = new i(new ArrayList(), sVar, 4);
                            final d dVar3 = (d) this.f6532g;
                            dVar3.getClass();
                            final C0580i c0580i2 = new C0580i();
                            final int i52 = 1;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ArrayList arrayList3;
                                    switch (i52) {
                                        case 0:
                                            d dVar42 = dVar3;
                                            C0580i c0580i32 = c0580i2;
                                            HashMap hashMap = d.f6504h;
                                            dVar42.getClass();
                                            try {
                                                u1.g a4 = u1.g.a(dVar42.f6505f);
                                                if (a4 == null) {
                                                    c0580i32.a(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
                                                } else {
                                                    c0580i32.b(d.c(a4));
                                                }
                                                return;
                                            } catch (Exception e4) {
                                                c0580i32.a(e4);
                                                return;
                                            }
                                        default:
                                            d dVar5 = dVar3;
                                            C0580i c0580i4 = c0580i2;
                                            HashMap hashMap2 = d.f6504h;
                                            dVar5.getClass();
                                            try {
                                                if (!dVar5.f6506g) {
                                                    dVar5.f6506g = true;
                                                } else {
                                                    AbstractC0602b.c(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
                                                }
                                                synchronized (u1.f.k) {
                                                    arrayList3 = new ArrayList(u1.f.f6220l.values());
                                                }
                                                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                                                int size = arrayList3.size();
                                                int i62 = 0;
                                                while (i62 < size) {
                                                    Object obj2 = arrayList3.get(i62);
                                                    i62++;
                                                    C0580i c0580i5 = new C0580i();
                                                    FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(dVar5, (u1.f) obj2, c0580i5));
                                                    arrayList4.add((g) AbstractC0602b.c(c0580i5.f5821a));
                                                }
                                                c0580i4.b(arrayList4);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i4.a(e5);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i2.f5821a.h(new J(23, iVar2));
                            return;
                        default:
                            i iVar3 = new i(new ArrayList(), sVar, 5);
                            final d dVar4 = (d) this.f6532g;
                            dVar4.getClass();
                            final C0580i c0580i3 = new C0580i();
                            final int i62 = 0;
                            FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: x2.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ArrayList arrayList3;
                                    switch (i62) {
                                        case 0:
                                            d dVar42 = dVar4;
                                            C0580i c0580i32 = c0580i3;
                                            HashMap hashMap = d.f6504h;
                                            dVar42.getClass();
                                            try {
                                                u1.g a4 = u1.g.a(dVar42.f6505f);
                                                if (a4 == null) {
                                                    c0580i32.a(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
                                                } else {
                                                    c0580i32.b(d.c(a4));
                                                }
                                                return;
                                            } catch (Exception e4) {
                                                c0580i32.a(e4);
                                                return;
                                            }
                                        default:
                                            d dVar5 = dVar4;
                                            C0580i c0580i4 = c0580i3;
                                            HashMap hashMap2 = d.f6504h;
                                            dVar5.getClass();
                                            try {
                                                if (!dVar5.f6506g) {
                                                    dVar5.f6506g = true;
                                                } else {
                                                    AbstractC0602b.c(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
                                                }
                                                synchronized (u1.f.k) {
                                                    arrayList3 = new ArrayList(u1.f.f6220l.values());
                                                }
                                                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                                                int size = arrayList3.size();
                                                int i622 = 0;
                                                while (i622 < size) {
                                                    Object obj2 = arrayList3.get(i622);
                                                    i622++;
                                                    C0580i c0580i5 = new C0580i();
                                                    FlutterFirebasePlugin.cachedThreadPool.execute(new RunnableC0724c(dVar5, (u1.f) obj2, c0580i5));
                                                    arrayList4.add((g) AbstractC0602b.c(c0580i5.f5821a));
                                                }
                                                c0580i4.b(arrayList4);
                                                return;
                                            } catch (Exception e5) {
                                                c0580i4.a(e5);
                                                return;
                                            }
                                    }
                                }
                            });
                            c0580i3.f5821a.h(new J(23, iVar3));
                            return;
                    }
                }
            });
        } else {
            yVar3.w(null);
        }
    }
}
