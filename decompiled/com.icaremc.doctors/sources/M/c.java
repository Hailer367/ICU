package M;

/* loaded from: classes.dex */
public final class c extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public d f599c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f600d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f601e;

    /* renamed from: f, reason: collision with root package name */
    public int f602f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, V0.c cVar) {
        super(cVar);
        this.f601e = dVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f600d = obj;
        this.f602f |= Integer.MIN_VALUE;
        return this.f601e.a(null, this);
    }
}
