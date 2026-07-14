package o1;

/* loaded from: classes.dex */
public final class h extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3411c;

    /* renamed from: d, reason: collision with root package name */
    public int f3412d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f3413e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3414f;

    /* renamed from: g, reason: collision with root package name */
    public e f3415g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, T0.d dVar) {
        super(dVar);
        this.f3413e = iVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f3411c = obj;
        this.f3412d |= Integer.MIN_VALUE;
        return this.f3413e.collect(null, this);
    }
}
