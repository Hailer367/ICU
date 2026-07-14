package e3;

import B2.C0019m;

/* loaded from: classes.dex */
public final class m extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public C0019m f3639i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f3640j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0019m f3641l;

    /* renamed from: m, reason: collision with root package name */
    public Object f3642m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(C0019m c0019m, K2.d dVar) {
        super(dVar);
        this.f3641l = c0019m;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f3640j = obj;
        this.k |= Integer.MIN_VALUE;
        return this.f3641l.g(null, this);
    }
}
