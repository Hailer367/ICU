package K;

/* loaded from: classes.dex */
public final class j0 extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public t1.c f499c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f500d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f501e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l0 f502f;

    /* renamed from: g, reason: collision with root package name */
    public int f503g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(l0 l0Var, V0.c cVar) {
        super(cVar);
        this.f502f = l0Var;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f501e = obj;
        this.f503g |= Integer.MIN_VALUE;
        return this.f502f.c(null, this);
    }
}
