package B2;

/* loaded from: classes.dex */
public final class s extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f226i;

    /* renamed from: j, reason: collision with root package name */
    public int f227j;
    public final /* synthetic */ C0019m k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(C0019m c0019m, K2.d dVar) {
        super(dVar);
        this.k = c0019m;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f226i = obj;
        this.f227j |= Integer.MIN_VALUE;
        return this.k.g(null, this);
    }
}
