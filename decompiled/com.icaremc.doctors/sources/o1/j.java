package o1;

/* loaded from: classes.dex */
public final class j extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3418c;

    /* renamed from: d, reason: collision with root package name */
    public int f3419d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ k f3420e;

    /* renamed from: f, reason: collision with root package name */
    public k f3421f;

    /* renamed from: g, reason: collision with root package name */
    public e f3422g;

    /* renamed from: h, reason: collision with root package name */
    public p1.l f3423h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, T0.d dVar) {
        super(dVar);
        this.f3420e = kVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f3418c = obj;
        this.f3419d |= Integer.MIN_VALUE;
        return this.f3420e.collect(null, this);
    }
}
