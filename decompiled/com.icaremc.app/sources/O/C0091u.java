package O;

/* renamed from: O.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0091u extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public N f1244i;

    /* renamed from: j, reason: collision with root package name */
    public j3.c f1245j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ N f1246l;

    /* renamed from: m, reason: collision with root package name */
    public int f1247m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0091u(N n3, M2.c cVar) {
        super(cVar);
        this.f1246l = n3;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.k = obj;
        this.f1247m |= Integer.MIN_VALUE;
        return N.b(this.f1246l, this);
    }
}
