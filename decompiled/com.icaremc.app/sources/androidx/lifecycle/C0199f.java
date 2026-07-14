package androidx.lifecycle;

import i0.C0362e;
import java.util.HashMap;
import java.util.List;

/* renamed from: androidx.lifecycle.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0199f implements r {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3010f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3011g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3012h;

    public C0199f(DefaultLifecycleObserver defaultLifecycleObserver, r rVar) {
        T2.h.e(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f3011g = defaultLifecycleObserver;
        this.f3012h = rVar;
    }

    @Override // androidx.lifecycle.r
    public final void d(InterfaceC0212t interfaceC0212t, EnumC0206m enumC0206m) {
        switch (this.f3010f) {
            case 0:
                DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) this.f3011g;
                switch (AbstractC0198e.f3009a[enumC0206m.ordinal()]) {
                    case 1:
                        defaultLifecycleObserver.c(interfaceC0212t);
                        break;
                    case 2:
                        defaultLifecycleObserver.f(interfaceC0212t);
                        break;
                    case 3:
                        defaultLifecycleObserver.a(interfaceC0212t);
                        break;
                    case 4:
                        defaultLifecycleObserver.e(interfaceC0212t);
                        break;
                    case 5:
                        defaultLifecycleObserver.g(interfaceC0212t);
                        break;
                    case 6:
                        defaultLifecycleObserver.b(interfaceC0212t);
                        break;
                    case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                }
                r rVar = (r) this.f3012h;
                if (rVar != null) {
                    rVar.d(interfaceC0212t, enumC0206m);
                    return;
                }
                return;
            case 1:
                if (enumC0206m == EnumC0206m.ON_START) {
                    ((AbstractC0208o) this.f3011g).b(this);
                    ((C0362e) this.f3012h).d();
                    return;
                }
                return;
            default:
                HashMap hashMap = ((C0195b) this.f3012h).f3002a;
                List list = (List) hashMap.get(enumC0206m);
                Object obj = this.f3011g;
                C0195b.a(list, interfaceC0212t, enumC0206m, obj);
                C0195b.a((List) hashMap.get(EnumC0206m.ON_ANY), interfaceC0212t, enumC0206m, obj);
                return;
        }
    }

    public C0199f(InterfaceC0211s interfaceC0211s) {
        this.f3011g = interfaceC0211s;
        C0197d c0197d = C0197d.f3006c;
        Class<?> cls = interfaceC0211s.getClass();
        C0195b c0195b = (C0195b) c0197d.f3007a.get(cls);
        this.f3012h = c0195b == null ? c0197d.a(cls, null) : c0195b;
    }

    public C0199f(AbstractC0208o abstractC0208o, C0362e c0362e) {
        this.f3011g = abstractC0208o;
        this.f3012h = c0362e;
    }
}
