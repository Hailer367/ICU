package androidx.lifecycle;

import android.os.Looper;
import i0.C0359b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import q.C0587a;
import q.C0589c;

/* renamed from: androidx.lifecycle.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0214v extends AbstractC0208o {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3022a;

    /* renamed from: b, reason: collision with root package name */
    public C0587a f3023b;

    /* renamed from: c, reason: collision with root package name */
    public EnumC0207n f3024c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f3025d;

    /* renamed from: e, reason: collision with root package name */
    public int f3026e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3027f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3028g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3029h;

    /* renamed from: i, reason: collision with root package name */
    public final e3.r f3030i;

    public C0214v(InterfaceC0212t interfaceC0212t) {
        new AtomicReference();
        this.f3022a = true;
        this.f3023b = new C0587a();
        EnumC0207n enumC0207n = EnumC0207n.f3015g;
        this.f3024c = enumC0207n;
        this.f3029h = new ArrayList();
        this.f3025d = new WeakReference(interfaceC0212t);
        this.f3030i = new e3.r(enumC0207n);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.lifecycle.u, java.lang.Object] */
    @Override // androidx.lifecycle.AbstractC0208o
    public final void a(InterfaceC0211s interfaceC0211s) {
        r c0199f;
        Object obj;
        InterfaceC0212t interfaceC0212t;
        EnumC0206m enumC0206m;
        T2.h.e(interfaceC0211s, "observer");
        d("addObserver");
        EnumC0207n enumC0207n = this.f3024c;
        EnumC0207n enumC0207n2 = EnumC0207n.f3014f;
        if (enumC0207n != enumC0207n2) {
            enumC0207n2 = EnumC0207n.f3015g;
        }
        ?? obj2 = new Object();
        HashMap hashMap = AbstractC0215w.f3031a;
        boolean z = interfaceC0211s instanceof r;
        boolean z3 = interfaceC0211s instanceof DefaultLifecycleObserver;
        int i4 = 2;
        boolean z4 = false;
        if (z && z3) {
            c0199f = new C0199f((DefaultLifecycleObserver) interfaceC0211s, (r) interfaceC0211s);
        } else if (z3) {
            c0199f = new C0199f((DefaultLifecycleObserver) interfaceC0211s, (r) null);
        } else if (z) {
            c0199f = (r) interfaceC0211s;
        } else {
            Class<?> cls = interfaceC0211s.getClass();
            if (AbstractC0215w.c(cls) == 2) {
                Object obj3 = AbstractC0215w.f3032b.get(cls);
                T2.h.b(obj3);
                List list = (List) obj3;
                if (list.size() != 1) {
                    int size = list.size();
                    InterfaceC0201h[] interfaceC0201hArr = new InterfaceC0201h[size];
                    if (size <= 0) {
                        c0199f = new C0359b(i4, interfaceC0201hArr);
                    } else {
                        AbstractC0215w.a((Constructor) list.get(0), interfaceC0211s);
                        throw null;
                    }
                } else {
                    AbstractC0215w.a((Constructor) list.get(0), interfaceC0211s);
                    throw null;
                }
            } else {
                c0199f = new C0199f(interfaceC0211s);
            }
        }
        obj2.f3021b = c0199f;
        obj2.f3020a = enumC0207n2;
        C0587a c0587a = this.f3023b;
        C0589c a4 = c0587a.a(interfaceC0211s);
        if (a4 != null) {
            obj = a4.f5843g;
        } else {
            HashMap hashMap2 = c0587a.f5838j;
            C0589c c0589c = new C0589c(interfaceC0211s, obj2);
            c0587a.f5852i++;
            C0589c c0589c2 = c0587a.f5850g;
            if (c0589c2 == null) {
                c0587a.f5849f = c0589c;
                c0587a.f5850g = c0589c;
            } else {
                c0589c2.f5844h = c0589c;
                c0589c.f5845i = c0589c2;
                c0587a.f5850g = c0589c;
            }
            hashMap2.put(interfaceC0211s, c0589c);
            obj = null;
        }
        if (((C0213u) obj) != null || (interfaceC0212t = (InterfaceC0212t) this.f3025d.get()) == null) {
            return;
        }
        if (this.f3026e != 0 || this.f3027f) {
            z4 = true;
        }
        EnumC0207n c4 = c(interfaceC0211s);
        this.f3026e++;
        while (obj2.f3020a.compareTo(c4) < 0 && this.f3023b.f5838j.containsKey(interfaceC0211s)) {
            EnumC0207n enumC0207n3 = obj2.f3020a;
            ArrayList arrayList = this.f3029h;
            arrayList.add(enumC0207n3);
            C0204k c0204k = EnumC0206m.Companion;
            EnumC0207n enumC0207n4 = obj2.f3020a;
            c0204k.getClass();
            T2.h.e(enumC0207n4, "state");
            int ordinal = enumC0207n4.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        enumC0206m = null;
                    } else {
                        enumC0206m = EnumC0206m.ON_RESUME;
                    }
                } else {
                    enumC0206m = EnumC0206m.ON_START;
                }
            } else {
                enumC0206m = EnumC0206m.ON_CREATE;
            }
            if (enumC0206m != null) {
                obj2.a(interfaceC0212t, enumC0206m);
                arrayList.remove(arrayList.size() - 1);
                c4 = c(interfaceC0211s);
            } else {
                throw new IllegalStateException("no event up from " + obj2.f3020a);
            }
        }
        if (!z4) {
            h();
        }
        this.f3026e--;
    }

    @Override // androidx.lifecycle.AbstractC0208o
    public final void b(InterfaceC0211s interfaceC0211s) {
        T2.h.e(interfaceC0211s, "observer");
        d("removeObserver");
        this.f3023b.b(interfaceC0211s);
    }

    public final EnumC0207n c(InterfaceC0211s interfaceC0211s) {
        C0589c c0589c;
        EnumC0207n enumC0207n;
        C0213u c0213u;
        HashMap hashMap = this.f3023b.f5838j;
        EnumC0207n enumC0207n2 = null;
        if (hashMap.containsKey(interfaceC0211s)) {
            c0589c = ((C0589c) hashMap.get(interfaceC0211s)).f5845i;
        } else {
            c0589c = null;
        }
        if (c0589c != null && (c0213u = (C0213u) c0589c.f5843g) != null) {
            enumC0207n = c0213u.f3020a;
        } else {
            enumC0207n = null;
        }
        ArrayList arrayList = this.f3029h;
        if (!arrayList.isEmpty()) {
            enumC0207n2 = (EnumC0207n) arrayList.get(arrayList.size() - 1);
        }
        EnumC0207n enumC0207n3 = this.f3024c;
        T2.h.e(enumC0207n3, "state1");
        if (enumC0207n == null || enumC0207n.compareTo(enumC0207n3) >= 0) {
            enumC0207n = enumC0207n3;
        }
        if (enumC0207n2 != null && enumC0207n2.compareTo(enumC0207n) < 0) {
            return enumC0207n2;
        }
        return enumC0207n;
    }

    public final void d(String str) {
        if (this.f3022a) {
            p.a.D().f5794m.getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            } else {
                throw new IllegalStateException(r2.k.b("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void e(EnumC0206m enumC0206m) {
        T2.h.e(enumC0206m, "event");
        d("handleLifecycleEvent");
        f(enumC0206m.a());
    }

    public final void f(EnumC0207n enumC0207n) {
        EnumC0207n enumC0207n2 = this.f3024c;
        if (enumC0207n2 != enumC0207n) {
            EnumC0207n enumC0207n3 = EnumC0207n.f3015g;
            EnumC0207n enumC0207n4 = EnumC0207n.f3014f;
            if (enumC0207n2 == enumC0207n3 && enumC0207n == enumC0207n4) {
                throw new IllegalStateException(("no event down from " + this.f3024c + " in component " + this.f3025d.get()).toString());
            }
            this.f3024c = enumC0207n;
            if (!this.f3027f && this.f3026e == 0) {
                this.f3027f = true;
                h();
                this.f3027f = false;
                if (this.f3024c == enumC0207n4) {
                    this.f3023b = new C0587a();
                    return;
                }
                return;
            }
            this.f3028g = true;
        }
    }

    public final void g() {
        d("setCurrentState");
        f(EnumC0207n.f3016h);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        r12.f3028g = false;
        r12.f3030i.b(r12.f3024c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.C0214v.h():void");
    }
}
