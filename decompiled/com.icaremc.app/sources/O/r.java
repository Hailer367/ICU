package O;

/* loaded from: classes.dex */
public final class r extends M2.h implements S2.q {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1237j = 1;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f1238l;

    public /* synthetic */ r(int i4, K2.d dVar) {
        super(i4, dVar);
    }

    @Override // S2.q
    public final Object c(Object obj, Object obj2, Object obj3) {
        switch (this.f1237j) {
            case 0:
                return new r((N) this.f1238l, (K2.d) obj3).k(H2.i.f681a);
            default:
                ((Boolean) obj2).getClass();
                r rVar = new r(3, (K2.d) obj3);
                rVar.f1238l = (P) obj;
                return rVar.k(H2.i.f681a);
        }
    }

    @Override // M2.a
    public final Object k(Object obj) {
        switch (this.f1237j) {
            case 0:
                int i4 = this.k;
                if (i4 != 0) {
                    if (i4 == 1) {
                        k3.b.A(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    k3.b.A(obj);
                    N n3 = (N) this.f1238l;
                    this.k = 1;
                    Object b4 = N.b(n3, this);
                    L2.a aVar = L2.a.f1019f;
                    if (b4 == aVar) {
                        return aVar;
                    }
                }
                return H2.i.f681a;
            default:
                int i5 = this.k;
                if (i5 != 0) {
                    if (i5 == 1) {
                        k3.b.A(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                k3.b.A(obj);
                P p3 = (P) this.f1238l;
                this.k = 1;
                p3.getClass();
                Object a4 = P.a(p3, this);
                L2.a aVar2 = L2.a.f1019f;
                if (a4 == aVar2) {
                    return aVar2;
                }
                return a4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(N n3, K2.d dVar) {
        super(3, dVar);
        this.f1238l = n3;
    }
}
