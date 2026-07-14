package e3;

/* loaded from: classes.dex */
public final class h extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f3621i;

    /* renamed from: j, reason: collision with root package name */
    public int f3622j;
    public final /* synthetic */ i k;

    /* renamed from: l, reason: collision with root package name */
    public Object f3623l;

    /* renamed from: m, reason: collision with root package name */
    public e f3624m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, K2.d dVar) {
        super(dVar);
        this.k = iVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f3621i = obj;
        this.f3622j |= Integer.MIN_VALUE;
        return this.k.u(null, this);
    }
}
