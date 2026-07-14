package p1;

import a.AbstractC0051a;
import l1.AbstractC0244w;
import l1.C;
import l1.EnumC0243v;
import l1.InterfaceC0242u;
import o1.w;

/* loaded from: classes.dex */
public final class c extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f3471c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3472d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o1.e f3473e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f3474f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(o1.e eVar, e eVar2, T0.d dVar) {
        super(2, dVar);
        this.f3473e = eVar;
        this.f3474f = eVar2;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        c cVar = new c(this.f3473e, this.f3474f, dVar);
        cVar.f3472d = obj;
        return cVar;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((InterfaceC0242u) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f3471c;
        Q0.j jVar = Q0.j.f722a;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
                return jVar;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0051a.V(obj);
        InterfaceC0242u interfaceC0242u = (InterfaceC0242u) this.f3472d;
        e eVar = this.f3474f;
        T0.i iVar = eVar.f3478c;
        int i3 = eVar.f3479d;
        if (i3 == -3) {
            i3 = -2;
        }
        n1.a aVar2 = eVar.f3480e;
        EnumC0243v enumC0243v = EnumC0243v.f3014d;
        c1.p dVar = new d(eVar, null);
        n1.c a2 = n1.j.a(i3, aVar2, 4);
        T0.i a3 = AbstractC0244w.a(interfaceC0242u.e(), iVar, true);
        s1.e eVar2 = C.f2950a;
        if (a3 != eVar2 && a3.k(T0.e.f773c) == null) {
            a3 = a3.d(eVar2);
        }
        n1.q qVar = new n1.q(a3, a2);
        qVar.S(enumC0243v, qVar, dVar);
        this.f3471c = 1;
        Object b2 = w.b(this.f3473e, qVar, true, this);
        if (b2 != aVar) {
            b2 = jVar;
        }
        if (b2 == aVar) {
            return aVar;
        }
        return jVar;
    }
}
