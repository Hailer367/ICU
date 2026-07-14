package K;

/* renamed from: K.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0043s extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f544c;

    /* renamed from: d, reason: collision with root package name */
    public int f545d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0044t f546e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0043s(C0044t c0044t, T0.d dVar) {
        super(dVar);
        this.f546e = c0044t;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f544c = obj;
        this.f545d |= Integer.MIN_VALUE;
        return this.f546e.emit(null, this);
    }
}
