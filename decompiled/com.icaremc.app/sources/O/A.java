package O;

/* loaded from: classes.dex */
public final class A extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public N f1074i;

    /* renamed from: j, reason: collision with root package name */
    public j0 f1075j;
    public boolean k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f1076l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ N f1077m;

    /* renamed from: n, reason: collision with root package name */
    public int f1078n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(N n3, K2.d dVar) {
        super(dVar);
        this.f1077m = n3;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f1076l = obj;
        this.f1078n |= Integer.MIN_VALUE;
        return N.e(this.f1077m, false, this);
    }
}
