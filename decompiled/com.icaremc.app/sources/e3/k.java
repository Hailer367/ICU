package e3;

/* loaded from: classes.dex */
public final class k extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public B2.q f3632i;

    /* renamed from: j, reason: collision with root package name */
    public Object f3633j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ B2.q f3634l;

    /* renamed from: m, reason: collision with root package name */
    public int f3635m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(B2.q qVar, K2.d dVar) {
        super(dVar);
        this.f3634l = qVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.k = obj;
        this.f3635m |= Integer.MIN_VALUE;
        return this.f3634l.g(null, this);
    }
}
