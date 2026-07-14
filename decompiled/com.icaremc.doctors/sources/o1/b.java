package o1;

/* loaded from: classes.dex */
public final class b extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public n1.r f3396c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3397d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c f3398e;

    /* renamed from: f, reason: collision with root package name */
    public int f3399f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, V0.c cVar2) {
        super(cVar2);
        this.f3398e = cVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f3397d = obj;
        this.f3399f |= Integer.MIN_VALUE;
        return this.f3398e.b(null, this);
    }
}
