package f3;

import b3.A;
import b3.AbstractC0245u;
import b3.EnumC0244t;
import b3.InterfaceC0243s;
import e3.s;

/* loaded from: classes.dex */
public final class c extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f3713j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e3.e f3714l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e f3715m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e3.e eVar, e eVar2, K2.d dVar) {
        super(2, dVar);
        this.f3714l = eVar;
        this.f3715m = eVar2;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((c) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        c cVar = new c(this.f3714l, this.f3715m, dVar);
        cVar.k = obj;
        return cVar;
    }

    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f3713j;
        H2.i iVar = H2.i.f681a;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
                return iVar;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k3.b.A(obj);
        InterfaceC0243s interfaceC0243s = (InterfaceC0243s) this.k;
        e eVar = this.f3715m;
        K2.i iVar2 = eVar.f3718f;
        int i5 = eVar.f3719g;
        if (i5 == -3) {
            i5 = -2;
        }
        d3.a aVar = eVar.f3720h;
        S2.p dVar = new d(eVar, null);
        d3.c a4 = d3.j.a(i5, aVar, 4);
        K2.i a5 = AbstractC0245u.a(interfaceC0243s.f(), iVar2, true);
        i3.e eVar2 = A.f3236a;
        if (a5 != eVar2 && a5.e(K2.e.f941f) == null) {
            a5 = a5.j(eVar2);
        }
        d3.q qVar = new d3.q(a5, a4);
        qVar.T(EnumC0244t.f3297g, qVar, dVar);
        this.f3713j = 1;
        Object b4 = s.b(this.f3714l, qVar, true, this);
        L2.a aVar2 = L2.a.f1019f;
        if (b4 != aVar2) {
            b4 = iVar;
        }
        if (b4 == aVar2) {
            return aVar2;
        }
        return iVar;
    }
}
