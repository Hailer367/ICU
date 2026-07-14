package androidx.lifecycle;

import b0.C0163e;
import java.util.HashMap;
import java.util.List;

/* renamed from: androidx.lifecycle.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0137g implements InterfaceC0148s {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1840c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1841d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1842e;

    public C0137g(DefaultLifecycleObserver defaultLifecycleObserver, InterfaceC0148s interfaceC0148s) {
        kotlin.jvm.internal.h.e(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f1841d = defaultLifecycleObserver;
        this.f1842e = interfaceC0148s;
    }

    @Override // androidx.lifecycle.InterfaceC0148s
    public final void a(InterfaceC0150u interfaceC0150u, EnumC0144n enumC0144n) {
        switch (this.f1840c) {
            case 0:
                DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) this.f1841d;
                switch (AbstractC0136f.f1839a[enumC0144n.ordinal()]) {
                    case 1:
                        defaultLifecycleObserver.onCreate(interfaceC0150u);
                        break;
                    case 2:
                        defaultLifecycleObserver.onStart(interfaceC0150u);
                        break;
                    case 3:
                        defaultLifecycleObserver.onResume(interfaceC0150u);
                        break;
                    case 4:
                        defaultLifecycleObserver.onPause(interfaceC0150u);
                        break;
                    case 5:
                        defaultLifecycleObserver.onStop(interfaceC0150u);
                        break;
                    case 6:
                        defaultLifecycleObserver.onDestroy(interfaceC0150u);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                }
                InterfaceC0148s interfaceC0148s = (InterfaceC0148s) this.f1842e;
                if (interfaceC0148s != null) {
                    interfaceC0148s.a(interfaceC0150u, enumC0144n);
                    return;
                }
                return;
            case 1:
                if (enumC0144n == EnumC0144n.ON_START) {
                    ((AbstractC0146p) this.f1841d).b(this);
                    ((C0163e) this.f1842e).d();
                    return;
                }
                return;
            default:
                HashMap hashMap = ((C0132b) this.f1842e).f1828a;
                List list = (List) hashMap.get(enumC0144n);
                Object obj = this.f1841d;
                C0132b.a(list, interfaceC0150u, enumC0144n, obj);
                C0132b.a((List) hashMap.get(EnumC0144n.ON_ANY), interfaceC0150u, enumC0144n, obj);
                return;
        }
    }

    public C0137g(InterfaceC0149t interfaceC0149t) {
        this.f1841d = interfaceC0149t;
        C0134d c0134d = C0134d.f1834c;
        Class<?> cls = interfaceC0149t.getClass();
        C0132b c0132b = (C0132b) c0134d.f1835a.get(cls);
        this.f1842e = c0132b == null ? c0134d.a(cls, null) : c0132b;
    }

    public C0137g(AbstractC0146p abstractC0146p, C0163e c0163e) {
        this.f1841d = abstractC0146p;
        this.f1842e = c0163e;
    }
}
