package K;

/* loaded from: classes.dex */
public final class Y extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Z f439c;

    /* renamed from: d, reason: collision with root package name */
    public Object f440d;

    /* renamed from: e, reason: collision with root package name */
    public Object f441e;

    /* renamed from: f, reason: collision with root package name */
    public b0 f442f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f443g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Z f444h;

    /* renamed from: i, reason: collision with root package name */
    public int f445i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(Z z, V0.c cVar) {
        super(cVar);
        this.f444h = z;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f443g = obj;
        this.f445i |= Integer.MIN_VALUE;
        return this.f444h.b(null, this);
    }
}
