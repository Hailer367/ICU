package O;

/* renamed from: O.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0093w extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public N f1253i;

    /* renamed from: j, reason: collision with root package name */
    public j3.c f1254j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ N f1255l;

    /* renamed from: m, reason: collision with root package name */
    public int f1256m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0093w(N n3, M2.c cVar) {
        super(cVar);
        this.f1255l = n3;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.k = obj;
        this.f1256m |= Integer.MIN_VALUE;
        return N.d(this.f1255l, this);
    }
}
