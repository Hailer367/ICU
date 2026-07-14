package p1;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class r extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f3500c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3501d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o1.e f3502e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(o1.e eVar, T0.d dVar) {
        super(2, dVar);
        this.f3502e = eVar;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        r rVar = new r(this.f3502e, dVar);
        rVar.f3501d = obj;
        return rVar;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((r) create(obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f3500c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            Object obj2 = this.f3501d;
            this.f3500c = 1;
            if (this.f3502e.emit(obj2, this) == aVar) {
                return aVar;
            }
        }
        return Q0.j.f722a;
    }
}
