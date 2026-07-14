package K;

/* loaded from: classes.dex */
public final class B extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Q f339c;

    /* renamed from: d, reason: collision with root package name */
    public int f340d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f341e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Q f342f;

    /* renamed from: g, reason: collision with root package name */
    public int f343g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(Q q, V0.c cVar) {
        super(cVar);
        this.f342f = q;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f341e = obj;
        this.f343g |= Integer.MIN_VALUE;
        return this.f342f.g(this);
    }
}
