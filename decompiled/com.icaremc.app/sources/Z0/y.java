package Z0;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class y extends p {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f2187g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(com.google.android.gms.common.internal.a aVar, int i4, Bundle bundle) {
        super(aVar, i4, bundle);
        this.f2187g = aVar;
    }

    @Override // Z0.p
    public final boolean a() {
        this.f2187g.f3379i.b(W0.a.k);
        return true;
    }

    @Override // Z0.p
    public final void b(W0.a aVar) {
        com.google.android.gms.common.internal.a aVar2 = this.f2187g;
        aVar2.getClass();
        aVar2.f3379i.b(aVar);
        System.currentTimeMillis();
    }
}
