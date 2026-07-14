package o1;

import K.C0045u;

/* loaded from: classes.dex */
public final class a extends V0.c {

    /* renamed from: c, reason: collision with root package name */
    public p1.l f3392c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3393d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0045u f3394e;

    /* renamed from: f, reason: collision with root package name */
    public int f3395f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(C0045u c0045u, T0.d dVar) {
        super(dVar);
        this.f3394e = c0045u;
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        this.f3393d = obj;
        this.f3395f |= Integer.MIN_VALUE;
        return this.f3394e.collect(null, this);
    }
}
