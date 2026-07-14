package e3;

/* loaded from: classes.dex */
public final class a extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public f3.l f3606i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f3607j;
    public final /* synthetic */ R1.c k;

    /* renamed from: l, reason: collision with root package name */
    public int f3608l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(R1.c cVar, K2.d dVar) {
        super(dVar);
        this.k = cVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f3607j = obj;
        this.f3608l |= Integer.MIN_VALUE;
        return this.k.u(null, this);
    }
}
