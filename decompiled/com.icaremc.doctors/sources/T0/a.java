package T0;

import a.AbstractC0051a;
import c1.p;

/* loaded from: classes.dex */
public abstract class a implements g {

    /* renamed from: c, reason: collision with root package name */
    public final h f769c;

    public a(h hVar) {
        this.f769c = hVar;
    }

    @Override // T0.i
    public final Object c(Object obj, p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // T0.i
    public final i d(i context) {
        kotlin.jvm.internal.h.e(context, "context");
        if (context == j.f774c) {
            return this;
        }
        return (i) context.c(this, new b(1));
    }

    @Override // T0.i
    public /* bridge */ i g(h hVar) {
        return AbstractC0051a.H(this, hVar);
    }

    @Override // T0.g
    public final h getKey() {
        return this.f769c;
    }

    @Override // T0.i
    public /* bridge */ g k(h hVar) {
        return AbstractC0051a.w(this, hVar);
    }
}
