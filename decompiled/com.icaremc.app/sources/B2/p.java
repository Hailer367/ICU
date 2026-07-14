package B2;

/* loaded from: classes.dex */
public final class p extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f216i;

    /* renamed from: j, reason: collision with root package name */
    public int f217j;
    public final /* synthetic */ q k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, K2.d dVar) {
        super(dVar);
        this.k = qVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f216i = obj;
        this.f217j |= Integer.MIN_VALUE;
        return this.k.g(null, this);
    }
}
