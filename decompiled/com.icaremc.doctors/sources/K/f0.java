package K;

/* loaded from: classes.dex */
public final class f0 extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public B0.q f471c;

    /* renamed from: d, reason: collision with root package name */
    public t1.a f472d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f473e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ B0.q f474f;

    /* renamed from: g, reason: collision with root package name */
    public int f475g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(B0.q qVar, V0.c cVar) {
        super(cVar);
        this.f474f = qVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f473e = obj;
        this.f475g |= Integer.MIN_VALUE;
        return this.f474f.d(this);
    }
}
