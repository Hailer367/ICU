package K;

/* loaded from: classes.dex */
public final class X extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Z f433c;

    /* renamed from: d, reason: collision with root package name */
    public T f434d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f435e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f436f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Z f437g;

    /* renamed from: h, reason: collision with root package name */
    public int f438h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(Z z, V0.c cVar) {
        super(cVar);
        this.f437g = z;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f436f = obj;
        this.f438h |= Integer.MIN_VALUE;
        return this.f437g.a(null, this);
    }
}
