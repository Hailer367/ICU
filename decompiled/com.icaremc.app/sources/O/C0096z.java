package O;

/* renamed from: O.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0096z extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public N f1260i;

    /* renamed from: j, reason: collision with root package name */
    public int f1261j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ N f1262l;

    /* renamed from: m, reason: collision with root package name */
    public int f1263m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0096z(N n3, M2.c cVar) {
        super(cVar);
        this.f1262l = n3;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.k = obj;
        this.f1263m |= Integer.MIN_VALUE;
        return this.f1262l.h(this);
    }
}
