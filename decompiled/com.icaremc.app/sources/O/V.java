package O;

/* loaded from: classes.dex */
public final class V extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public W f1149i;

    /* renamed from: j, reason: collision with root package name */
    public Object f1150j;
    public Object k;

    /* renamed from: l, reason: collision with root package name */
    public Y f1151l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f1152m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ W f1153n;

    /* renamed from: o, reason: collision with root package name */
    public int f1154o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(W w2, M2.c cVar) {
        super(cVar);
        this.f1153n = w2;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f1152m = obj;
        this.f1154o |= Integer.MIN_VALUE;
        return this.f1153n.b(null, this);
    }
}
