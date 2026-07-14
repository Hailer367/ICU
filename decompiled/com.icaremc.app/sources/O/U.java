package O;

/* loaded from: classes.dex */
public final class U extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public W f1144i;

    /* renamed from: j, reason: collision with root package name */
    public P f1145j;
    public boolean k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f1146l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ W f1147m;

    /* renamed from: n, reason: collision with root package name */
    public int f1148n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(W w2, M2.c cVar) {
        super(cVar);
        this.f1147m = w2;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f1146l = obj;
        this.f1148n |= Integer.MIN_VALUE;
        return this.f1147m.a(null, this);
    }
}
