package K;

/* loaded from: classes.dex */
public final class O extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public kotlin.jvm.internal.p f396c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f397d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q f398e;

    /* renamed from: f, reason: collision with root package name */
    public int f399f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(Q q, V0.c cVar) {
        super(cVar);
        this.f398e = q;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f397d = obj;
        this.f399f |= Integer.MIN_VALUE;
        return this.f398e.k(null, false, this);
    }
}
