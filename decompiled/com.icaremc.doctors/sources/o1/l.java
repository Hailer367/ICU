package o1;

/* loaded from: classes.dex */
public final class l extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public m f3427c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3428d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f3429e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f3430f;

    /* renamed from: g, reason: collision with root package name */
    public int f3431g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, T0.d dVar) {
        super(dVar);
        this.f3430f = mVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f3429e = obj;
        this.f3431g |= Integer.MIN_VALUE;
        return this.f3430f.emit(null, this);
    }
}
