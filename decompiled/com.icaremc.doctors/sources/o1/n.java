package o1;

/* loaded from: classes.dex */
public final class n extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3436c;

    /* renamed from: d, reason: collision with root package name */
    public int f3437d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ k f3438e;

    /* renamed from: f, reason: collision with root package name */
    public p f3439f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, T0.d dVar) {
        super(dVar);
        this.f3438e = kVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f3436c = obj;
        this.f3437d |= Integer.MIN_VALUE;
        return this.f3438e.collect(null, this);
    }
}
