package K;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class N extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f393c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f394d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q f395e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(Q q, T0.d dVar) {
        super(2, dVar);
        this.f395e = q;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        N n2 = new N(this.f395e, dVar);
        n2.f394d = obj;
        return n2;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((N) create((d0) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f393c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            d0 d0Var = (d0) this.f394d;
            this.f393c = 1;
            if (Q.b(this.f395e, d0Var, this) == aVar) {
                return aVar;
            }
        }
        return Q0.j.f722a;
    }
}
