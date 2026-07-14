package W1;

import a2.C0143a;

/* loaded from: classes.dex */
public final class a0 implements T1.t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Class f1899f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Class f1900g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ T1.s f1901h;

    public a0(Class cls, Class cls2, T1.s sVar) {
        this.f1899f = cls;
        this.f1900g = cls2;
        this.f1901h = sVar;
    }

    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        Class cls = c0143a.f2216a;
        if (cls != this.f1899f && cls != this.f1900g) {
            return null;
        }
        return this.f1901h;
    }

    public final String toString() {
        return "Factory[type=" + this.f1900g.getName() + "+" + this.f1899f.getName() + ",adapter=" + this.f1901h + "]";
    }
}
