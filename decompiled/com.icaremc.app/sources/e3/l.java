package e3;

import B2.C0019m;

/* loaded from: classes.dex */
public final class l extends M2.c {

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f3636i;

    /* renamed from: j, reason: collision with root package name */
    public int f3637j;
    public final /* synthetic */ E0.a k;

    /* renamed from: l, reason: collision with root package name */
    public C0019m f3638l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(E0.a aVar, K2.d dVar) {
        super(dVar);
        this.k = aVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        this.f3636i = obj;
        this.f3637j |= Integer.MIN_VALUE;
        return this.k.u(null, this);
    }
}
