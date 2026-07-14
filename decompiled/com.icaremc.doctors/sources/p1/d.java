package p1;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class d extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f3475c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3476d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e f3477e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, T0.d dVar) {
        super(2, dVar);
        this.f3477e = eVar;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        d dVar2 = new d(this.f3477e, dVar);
        dVar2.f3476d = obj;
        return dVar2;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((n1.r) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f3475c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            n1.r rVar = (n1.r) this.f3476d;
            this.f3475c = 1;
            if (this.f3477e.b(rVar, this) == aVar) {
                return aVar;
            }
        }
        return Q0.j.f722a;
    }
}
