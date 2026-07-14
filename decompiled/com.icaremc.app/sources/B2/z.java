package B2;

/* loaded from: classes.dex */
public final class z extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f249i;

    /* renamed from: j, reason: collision with root package name */
    public int f250j;
    public final /* synthetic */ A k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(A a4, K2.d dVar) {
        super(dVar);
        this.k = a4;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f249i = obj;
        this.f250j |= Integer.MIN_VALUE;
        return this.k.g(null, this);
    }
}
