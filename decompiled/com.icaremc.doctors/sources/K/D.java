package K;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class D extends V0.h implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public Throwable f350c;

    /* renamed from: d, reason: collision with root package name */
    public int f351d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q f352e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(Q q, T0.d dVar) {
        super(1, dVar);
        this.f352e = q;
    }

    @Override // V0.a
    public final T0.d create(T0.d dVar) {
        return new D(this.f352e, dVar);
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        return ((D) create((T0.d) obj)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        m0 m0Var;
        U0.a aVar = U0.a.f780c;
        int i2 = this.f351d;
        Q q = this.f352e;
        try {
        } catch (Throwable th2) {
            l0 f2 = q.f();
            this.f350c = th2;
            this.f351d = 2;
            Integer a2 = f2.a();
            if (a2 != aVar) {
                th = th2;
                obj = a2;
            }
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    th = this.f350c;
                    AbstractC0051a.V(obj);
                    m0Var = new e0(th, ((Number) obj).intValue());
                    return new Q0.e(m0Var, Boolean.TRUE);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC0051a.V(obj);
        } else {
            AbstractC0051a.V(obj);
            this.f351d = 1;
            obj = Q.e(q, true, this);
            if (obj == aVar) {
                return aVar;
            }
        }
        m0Var = (m0) obj;
        return new Q0.e(m0Var, Boolean.TRUE);
    }
}
