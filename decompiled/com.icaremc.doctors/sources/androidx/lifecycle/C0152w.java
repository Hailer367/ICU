package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import n.C0279a;
import o.C0282a;
import o.C0284c;

/* renamed from: androidx.lifecycle.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0152w extends AbstractC0146p {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1853a;

    /* renamed from: b, reason: collision with root package name */
    public C0282a f1854b;

    /* renamed from: c, reason: collision with root package name */
    public EnumC0145o f1855c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f1856d;

    /* renamed from: e, reason: collision with root package name */
    public int f1857e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1858f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1859g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1860h;

    /* renamed from: i, reason: collision with root package name */
    public final o1.v f1861i;

    public C0152w(InterfaceC0150u interfaceC0150u) {
        new AtomicReference();
        this.f1853a = true;
        this.f1854b = new C0282a();
        EnumC0145o enumC0145o = EnumC0145o.f1845d;
        this.f1855c = enumC0145o;
        this.f1860h = new ArrayList();
        this.f1856d = new WeakReference(interfaceC0150u);
        this.f1861i = new o1.v(enumC0145o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.lifecycle.v, java.lang.Object] */
    @Override // androidx.lifecycle.AbstractC0146p
    public final void a(InterfaceC0149t observer) {
        InterfaceC0148s c0137g;
        InterfaceC0150u interfaceC0150u;
        EnumC0144n enumC0144n;
        kotlin.jvm.internal.h.e(observer, "observer");
        d("addObserver");
        EnumC0145o enumC0145o = this.f1855c;
        EnumC0145o enumC0145o2 = EnumC0145o.f1844c;
        if (enumC0145o != enumC0145o2) {
            enumC0145o2 = EnumC0145o.f1845d;
        }
        ?? obj = new Object();
        HashMap hashMap = AbstractC0153x.f1862a;
        boolean z = observer instanceof InterfaceC0148s;
        boolean z2 = observer instanceof DefaultLifecycleObserver;
        int i2 = 0;
        if (z && z2) {
            c0137g = new C0137g((DefaultLifecycleObserver) observer, (InterfaceC0148s) observer);
        } else if (z2) {
            c0137g = new C0137g((DefaultLifecycleObserver) observer, (InterfaceC0148s) null);
        } else if (z) {
            c0137g = (InterfaceC0148s) observer;
        } else {
            Class<?> cls = observer.getClass();
            if (AbstractC0153x.c(cls) == 2) {
                Object obj2 = AbstractC0153x.f1863b.get(cls);
                kotlin.jvm.internal.h.b(obj2);
                List list = (List) obj2;
                if (list.size() != 1) {
                    int size = list.size();
                    InterfaceC0139i[] interfaceC0139iArr = new InterfaceC0139i[size];
                    if (size <= 0) {
                        c0137g = new C0135e(i2, interfaceC0139iArr);
                    } else {
                        AbstractC0153x.a((Constructor) list.get(0), observer);
                        throw null;
                    }
                } else {
                    AbstractC0153x.a((Constructor) list.get(0), observer);
                    throw null;
                }
            } else {
                c0137g = new C0137g(observer);
            }
        }
        obj.f1852b = c0137g;
        obj.f1851a = enumC0145o2;
        if (((C0151v) this.f1854b.b(observer, obj)) != null || (interfaceC0150u = (InterfaceC0150u) this.f1856d.get()) == null) {
            return;
        }
        if (this.f1857e != 0 || this.f1858f) {
            i2 = 1;
        }
        EnumC0145o c2 = c(observer);
        this.f1857e++;
        while (obj.f1851a.compareTo(c2) < 0 && this.f1854b.f3355g.containsKey(observer)) {
            EnumC0145o enumC0145o3 = obj.f1851a;
            ArrayList arrayList = this.f1860h;
            arrayList.add(enumC0145o3);
            C0142l c0142l = EnumC0144n.Companion;
            EnumC0145o state = obj.f1851a;
            c0142l.getClass();
            kotlin.jvm.internal.h.e(state, "state");
            int ordinal = state.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        enumC0144n = null;
                    } else {
                        enumC0144n = EnumC0144n.ON_RESUME;
                    }
                } else {
                    enumC0144n = EnumC0144n.ON_START;
                }
            } else {
                enumC0144n = EnumC0144n.ON_CREATE;
            }
            if (enumC0144n != null) {
                obj.a(interfaceC0150u, enumC0144n);
                arrayList.remove(arrayList.size() - 1);
                c2 = c(observer);
            } else {
                throw new IllegalStateException("no event up from " + obj.f1851a);
            }
        }
        if (i2 == 0) {
            h();
        }
        this.f1857e--;
    }

    @Override // androidx.lifecycle.AbstractC0146p
    public final void b(InterfaceC0149t observer) {
        kotlin.jvm.internal.h.e(observer, "observer");
        d("removeObserver");
        this.f1854b.c(observer);
    }

    public final EnumC0145o c(InterfaceC0149t interfaceC0149t) {
        C0284c c0284c;
        EnumC0145o enumC0145o;
        C0151v c0151v;
        HashMap hashMap = this.f1854b.f3355g;
        EnumC0145o enumC0145o2 = null;
        if (hashMap.containsKey(interfaceC0149t)) {
            c0284c = ((C0284c) hashMap.get(interfaceC0149t)).f3362f;
        } else {
            c0284c = null;
        }
        if (c0284c != null && (c0151v = (C0151v) c0284c.f3360d) != null) {
            enumC0145o = c0151v.f1851a;
        } else {
            enumC0145o = null;
        }
        ArrayList arrayList = this.f1860h;
        if (!arrayList.isEmpty()) {
            enumC0145o2 = (EnumC0145o) arrayList.get(arrayList.size() - 1);
        }
        EnumC0145o state1 = this.f1855c;
        kotlin.jvm.internal.h.e(state1, "state1");
        if (enumC0145o == null || enumC0145o.compareTo(state1) >= 0) {
            enumC0145o = state1;
        }
        if (enumC0145o2 != null && enumC0145o2.compareTo(enumC0145o) < 0) {
            return enumC0145o2;
        }
        return enumC0145o;
    }

    public final void d(String str) {
        if (this.f1853a) {
            C0279a.N().f3287f.getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            } else {
                throw new IllegalStateException(O.a.g("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void e(EnumC0144n event) {
        kotlin.jvm.internal.h.e(event, "event");
        d("handleLifecycleEvent");
        f(event.a());
    }

    public final void f(EnumC0145o enumC0145o) {
        EnumC0145o enumC0145o2 = this.f1855c;
        if (enumC0145o2 != enumC0145o) {
            EnumC0145o enumC0145o3 = EnumC0145o.f1845d;
            EnumC0145o enumC0145o4 = EnumC0145o.f1844c;
            if (enumC0145o2 == enumC0145o3 && enumC0145o == enumC0145o4) {
                throw new IllegalStateException(("no event down from " + this.f1855c + " in component " + this.f1856d.get()).toString());
            }
            this.f1855c = enumC0145o;
            if (!this.f1858f && this.f1857e == 0) {
                this.f1858f = true;
                h();
                this.f1858f = false;
                if (this.f1855c == enumC0145o4) {
                    this.f1854b = new C0282a();
                    return;
                }
                return;
            }
            this.f1859g = true;
        }
    }

    public final void g() {
        d("setCurrentState");
        f(EnumC0145o.f1846e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        r12.f1859g = false;
        r0 = r12.f1855c;
        r1 = r12.f1861i;
        r1.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        r0 = p1.k.f3488a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        r1.c(null, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.C0152w.h():void");
    }
}
