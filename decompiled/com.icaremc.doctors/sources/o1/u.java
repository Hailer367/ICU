package o1;

import l1.O;

/* loaded from: classes.dex */
public final class u extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public v f3452c;

    /* renamed from: d, reason: collision with root package name */
    public e f3453d;

    /* renamed from: e, reason: collision with root package name */
    public x f3454e;

    /* renamed from: f, reason: collision with root package name */
    public O f3455f;

    /* renamed from: g, reason: collision with root package name */
    public Object f3456g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f3457h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ v f3458i;

    /* renamed from: j, reason: collision with root package name */
    public int f3459j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, T0.d dVar) {
        super(dVar);
        this.f3458i = vVar;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f3457h = obj;
        this.f3459j |= Integer.MIN_VALUE;
        this.f3458i.collect(null, this);
        return U0.a.f780c;
    }
}
