package K;

import a.AbstractC0051a;

/* renamed from: K.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0042q extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f537c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m0 f538d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0042q(m0 m0Var, T0.d dVar) {
        super(2, dVar);
        this.f538d = m0Var;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        C0042q c0042q = new C0042q(this.f538d, dVar);
        c0042q.f537c = obj;
        return c0042q;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0042q) create((m0) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        boolean z;
        U0.a aVar = U0.a.f780c;
        AbstractC0051a.V(obj);
        m0 m0Var = (m0) this.f537c;
        if ((m0Var instanceof C0029d) && m0Var.f528a <= this.f538d.f528a) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
