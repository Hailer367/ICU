package K;

/* loaded from: classes.dex */
public final class i0 extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f490c;

    /* renamed from: d, reason: collision with root package name */
    public t1.c f491d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f492e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l0 f493f;

    /* renamed from: g, reason: collision with root package name */
    public int f494g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(l0 l0Var, V0.c cVar) {
        super(cVar);
        this.f493f = l0Var;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f492e = obj;
        this.f494g |= Integer.MIN_VALUE;
        return this.f493f.b(null, this);
    }
}
