package O;

/* loaded from: classes.dex */
public final class f0 extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public Object f1185i;

    /* renamed from: j, reason: collision with root package name */
    public j3.c f1186j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i0 f1187l;

    /* renamed from: m, reason: collision with root package name */
    public int f1188m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(i0 i0Var, M2.c cVar) {
        super(cVar);
        this.f1187l = i0Var;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.k = obj;
        this.f1188m |= Integer.MIN_VALUE;
        return this.f1187l.b(null, this);
    }
}
