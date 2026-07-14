package K;

import a.AbstractC0051a;

/* renamed from: K.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0041p extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f535c;

    /* JADX WARN: Type inference failed for: r0v0, types: [V0.h, T0.d, K.p] */
    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        ?? hVar = new V0.h(2, dVar);
        hVar.f535c = obj;
        return hVar;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0041p) create((m0) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        AbstractC0051a.V(obj);
        return Boolean.valueOf(!(((m0) this.f535c) instanceof c0));
    }
}
