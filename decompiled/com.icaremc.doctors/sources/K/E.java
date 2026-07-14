package K;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class E extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public Throwable f353c;

    /* renamed from: d, reason: collision with root package name */
    public int f354d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ boolean f355e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Q f356f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f357g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(Q q, int i2, T0.d dVar) {
        super(2, dVar);
        this.f356f = q;
        this.f357g = i2;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        E e2 = new E(this.f356f, this.f357g, dVar);
        e2.f355e = ((Boolean) obj).booleanValue();
        return e2;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((E) create(bool, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        int i2;
        boolean z;
        m0 m0Var;
        boolean z2;
        U0.a aVar = U0.a.f780c;
        boolean z3 = this.f354d;
        Q q = this.f356f;
        try {
        } catch (Throwable th2) {
            if (z3 != 0) {
                l0 f2 = q.f();
                this.f353c = th2;
                this.f355e = z3;
                this.f354d = 2;
                Integer a2 = f2.a();
                if (a2 != aVar) {
                    z = z3;
                    th = th2;
                    obj = a2;
                }
            } else {
                boolean z4 = z3;
                th = th2;
                i2 = this.f357g;
                z = z4;
            }
        }
        if (z3 != 0) {
            if (z3 != 1) {
                if (z3 == 2) {
                    z = this.f355e;
                    th = this.f353c;
                    AbstractC0051a.V(obj);
                    i2 = ((Number) obj).intValue();
                    e0 e0Var = new e0(th, i2);
                    z2 = z;
                    m0Var = e0Var;
                    return new Q0.e(m0Var, Boolean.valueOf(z2));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z5 = this.f355e;
            AbstractC0051a.V(obj);
            z3 = z5;
        } else {
            AbstractC0051a.V(obj);
            boolean z6 = this.f355e;
            this.f355e = z6;
            this.f354d = 1;
            obj = Q.e(q, z6, this);
            z3 = z6;
            if (obj == aVar) {
                return aVar;
            }
        }
        m0Var = (m0) obj;
        z2 = z3;
        return new Q0.e(m0Var, Boolean.valueOf(z2));
    }
}
