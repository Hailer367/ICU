package K;

/* renamed from: K.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0050z extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Q f568c;

    /* renamed from: d, reason: collision with root package name */
    public t1.c f569d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f570e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Q f571f;

    /* renamed from: g, reason: collision with root package name */
    public int f572g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0050z(Q q, V0.c cVar) {
        super(cVar);
        this.f571f = q;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f570e = obj;
        this.f572g |= Integer.MIN_VALUE;
        return Q.c(this.f571f, this);
    }
}
