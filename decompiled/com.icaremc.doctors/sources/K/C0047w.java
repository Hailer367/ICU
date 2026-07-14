package K;

/* renamed from: K.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0047w extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public Q f555c;

    /* renamed from: d, reason: collision with root package name */
    public t1.c f556d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f557e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Q f558f;

    /* renamed from: g, reason: collision with root package name */
    public int f559g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0047w(Q q, V0.c cVar) {
        super(cVar);
        this.f558f = q;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f557e = obj;
        this.f559g |= Integer.MIN_VALUE;
        return Q.a(this.f558f, this);
    }
}
