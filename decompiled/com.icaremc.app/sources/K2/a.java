package K2;

import S2.p;
import a.AbstractC0141a;

/* loaded from: classes.dex */
public abstract class a implements g {

    /* renamed from: f, reason: collision with root package name */
    public final h f937f;

    public a(h hVar) {
        this.f937f = hVar;
    }

    @Override // K2.i
    public /* bridge */ i c(h hVar) {
        return AbstractC0141a.v(this, hVar);
    }

    @Override // K2.i
    public /* bridge */ g e(h hVar) {
        return AbstractC0141a.s(this, hVar);
    }

    @Override // K2.g
    public final h getKey() {
        return this.f937f;
    }

    @Override // K2.i
    public final i j(i iVar) {
        T2.h.e(iVar, "context");
        if (iVar == j.f942f) {
            return this;
        }
        return (i) iVar.k(this, new b(1));
    }

    @Override // K2.i
    public final Object k(Object obj, p pVar) {
        return pVar.e(obj, this);
    }
}
