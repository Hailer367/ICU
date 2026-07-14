package O;

/* loaded from: classes.dex */
public final class C extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public Throwable f1081j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ boolean f1082l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ N f1083m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f1084n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(N n3, int i4, K2.d dVar) {
        super(2, dVar);
        this.f1083m = n3;
        this.f1084n = i4;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((C) i((K2.d) obj2, bool)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C c4 = new C(this.f1083m, this.f1084n, dVar);
        c4.f1082l = ((Boolean) obj).booleanValue();
        return c4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // M2.a
    public final Object k(Object obj) {
        Throwable th;
        int i4;
        j0 j0Var;
        boolean z;
        boolean z3;
        boolean z4;
        boolean z5 = this.k;
        N n3 = this.f1083m;
        L2.a aVar = L2.a.f1019f;
        try {
        } catch (Throwable th2) {
            if (z5 != 0) {
                i0 g4 = n3.g();
                this.f1081j = th2;
                this.f1082l = z5;
                this.k = 2;
                Integer a4 = g4.a();
                if (a4 != aVar) {
                    th = th2;
                    obj = a4;
                    z4 = z5;
                }
            } else {
                th = th2;
                i4 = this.f1084n;
                z3 = z5;
            }
        }
        if (z5 != 0) {
            if (z5 != 1) {
                if (z5 == 2) {
                    boolean z6 = this.f1082l;
                    th = this.f1081j;
                    k3.b.A(obj);
                    z4 = z6;
                    i4 = ((Number) obj).intValue();
                    z3 = z4;
                    j0Var = new b0(th, i4);
                    z = z3;
                    return new H2.d(j0Var, Boolean.valueOf(z));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z7 = this.f1082l;
            k3.b.A(obj);
            z5 = z7;
        } else {
            k3.b.A(obj);
            boolean z8 = this.f1082l;
            this.f1082l = z8;
            this.k = 1;
            obj = N.f(n3, z8, this);
            z5 = z8;
            if (obj == aVar) {
                return aVar;
            }
        }
        j0Var = (j0) obj;
        z = z5;
        return new H2.d(j0Var, Boolean.valueOf(z));
    }
}
