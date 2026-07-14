package K;

/* loaded from: classes.dex */
public final class C extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Q f344c;

    /* renamed from: d, reason: collision with root package name */
    public m0 f345d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f346e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f347f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Q f348g;

    /* renamed from: h, reason: collision with root package name */
    public int f349h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(Q q, T0.d dVar) {
        super(dVar);
        this.f348g = q;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f347f = obj;
        this.f349h |= Integer.MIN_VALUE;
        return Q.d(this.f348g, false, this);
    }
}
