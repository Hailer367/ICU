package o1;

/* loaded from: classes.dex */
public final class o extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public p f3440c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3441d;

    /* renamed from: e, reason: collision with root package name */
    public int f3442e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f3443f;

    /* renamed from: g, reason: collision with root package name */
    public Object f3444g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar, T0.d dVar) {
        super(dVar);
        this.f3443f = pVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f3441d = obj;
        this.f3442e |= Integer.MIN_VALUE;
        return this.f3443f.emit(null, this);
    }
}
