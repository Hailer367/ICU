package K;

/* renamed from: K.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0035j extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public B0.q f495c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f496d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ B0.q f497e;

    /* renamed from: f, reason: collision with root package name */
    public int f498f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0035j(B0.q qVar, V0.c cVar) {
        super(cVar);
        this.f497e = qVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f496d = obj;
        this.f498f |= Integer.MIN_VALUE;
        return this.f497e.a(this);
    }
}
