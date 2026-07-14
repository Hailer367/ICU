package v0;

import S2.p;
import android.app.Activity;
import d3.r;
import w0.InterfaceC0695a;

/* renamed from: v0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0686i extends M2.h implements p {

    /* renamed from: j, reason: collision with root package name */
    public int f6281j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0679b f6282l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Activity f6283m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0686i(C0679b c0679b, Activity activity, K2.d dVar) {
        super(2, dVar);
        this.f6282l = c0679b;
        this.f6283m = activity;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0686i) i((K2.d) obj2, (r) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C0686i c0686i = new C0686i(this.f6282l, this.f6283m, dVar);
        c0686i.k = obj;
        return c0686i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [f0.c, java.lang.Object] */
    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f6281j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            k3.b.A(obj);
            r rVar = (r) this.k;
            h2.m mVar = new h2.m(1, rVar);
            C0679b c0679b = this.f6282l;
            ((InterfaceC0695a) c0679b.f6267g).b(this.f6283m, new Object(), mVar);
            Q.a aVar = new Q.a(2, c0679b, mVar);
            this.f6281j = 1;
            Object b4 = d3.j.b(rVar, aVar, this);
            L2.a aVar2 = L2.a.f1019f;
            if (b4 == aVar2) {
                return aVar2;
            }
        }
        return H2.i.f681a;
    }
}
