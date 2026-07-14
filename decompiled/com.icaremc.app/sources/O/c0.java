package O;

/* loaded from: classes.dex */
public final class c0 extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public P1.y f1170i;

    /* renamed from: j, reason: collision with root package name */
    public j3.a f1171j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ P1.y f1172l;

    /* renamed from: m, reason: collision with root package name */
    public int f1173m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(P1.y yVar, M2.c cVar) {
        super(cVar);
        this.f1172l = yVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.k = obj;
        this.f1173m |= Integer.MIN_VALUE;
        return this.f1172l.t(this);
    }
}
