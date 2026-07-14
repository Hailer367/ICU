package p1;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class f extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f3481c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3482d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f3483e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, T0.d dVar) {
        super(2, dVar);
        this.f3483e = gVar;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        f fVar = new f(this.f3483e, dVar);
        fVar.f3482d = obj;
        return fVar;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((f) create((o1.e) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f3481c;
        Q0.j jVar = Q0.j.f722a;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            o1.e eVar = (o1.e) this.f3482d;
            this.f3481c = 1;
            Object collect = this.f3483e.f3484f.collect(eVar, this);
            if (collect != aVar) {
                collect = jVar;
            }
            if (collect == aVar) {
                return aVar;
            }
        }
        return jVar;
    }
}
