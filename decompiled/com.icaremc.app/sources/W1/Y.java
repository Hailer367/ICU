package W1;

import a2.C0143a;

/* loaded from: classes.dex */
public final class Y implements T1.t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1896f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1897g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ T1.s f1898h;

    public /* synthetic */ Y(Object obj, T1.s sVar, int i4) {
        this.f1896f = i4;
        this.f1897g = obj;
        this.f1898h = sVar;
    }

    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        switch (this.f1896f) {
            case 0:
                if (c0143a.f2216a == ((Class) this.f1897g)) {
                    return this.f1898h;
                }
                return null;
            case 1:
                Class<?> cls = c0143a.f2216a;
                if (!((Class) this.f1897g).isAssignableFrom(cls)) {
                    return null;
                }
                return new C0112c(this, cls);
            default:
                if (c0143a.equals((C0143a) this.f1897g)) {
                    return this.f1898h;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f1896f) {
            case 0:
                return "Factory[type=" + ((Class) this.f1897g).getName() + ",adapter=" + this.f1898h + "]";
            case 1:
                return "Factory[typeHierarchy=" + ((Class) this.f1897g).getName() + ",adapter=" + this.f1898h + "]";
            default:
                return super.toString();
        }
    }
}
