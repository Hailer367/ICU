package t0;

import H2.i;
import M2.h;
import O.C0094x;
import S2.p;
import b3.InterfaceC0243s;
import e3.d;
import k3.b;

/* loaded from: classes.dex */
public final class a extends h implements p {

    /* renamed from: j, reason: collision with root package name */
    public int f6200j;
    public final /* synthetic */ d k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ H.a f6201l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, H.a aVar, K2.d dVar2) {
        super(2, dVar2);
        this.k = dVar;
        this.f6201l = aVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((a) i((K2.d) obj2, (InterfaceC0243s) obj)).k(i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new a(this.k, this.f6201l, dVar);
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f6200j;
        if (i4 != 0) {
            if (i4 == 1) {
                b.A(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            b.A(obj);
            C0094x c0094x = new C0094x(2, this.f6201l);
            this.f6200j = 1;
            Object u3 = this.k.u(c0094x, this);
            L2.a aVar = L2.a.f1019f;
            if (u3 == aVar) {
                return aVar;
            }
        }
        return i.f681a;
    }
}
