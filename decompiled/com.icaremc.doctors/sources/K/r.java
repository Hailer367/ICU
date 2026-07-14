package K;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class r extends V0.h implements c1.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f541c = 1;

    /* renamed from: d, reason: collision with root package name */
    public int f542d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f543e;

    public /* synthetic */ r(int i2, T0.d dVar) {
        super(i2, dVar);
    }

    @Override // c1.q
    public final Object a(Object obj, Object obj2, Object obj3) {
        switch (this.f541c) {
            case 0:
                return new r((Q) this.f543e, (T0.d) obj3).invokeSuspend(Q0.j.f722a);
            default:
                ((Boolean) obj2).getClass();
                r rVar = new r(3, (T0.d) obj3);
                rVar.f543e = (T) obj;
                return rVar.invokeSuspend(Q0.j.f722a);
        }
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f541c) {
            case 0:
                U0.a aVar = U0.a.f780c;
                int i2 = this.f542d;
                if (i2 != 0) {
                    if (i2 == 1) {
                        AbstractC0051a.V(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    AbstractC0051a.V(obj);
                    Q q = (Q) this.f543e;
                    this.f542d = 1;
                    if (Q.a(q, this) == aVar) {
                        return aVar;
                    }
                }
                return Q0.j.f722a;
            default:
                U0.a aVar2 = U0.a.f780c;
                int i3 = this.f542d;
                if (i3 != 0) {
                    if (i3 == 1) {
                        AbstractC0051a.V(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC0051a.V(obj);
                T t2 = (T) this.f543e;
                this.f542d = 1;
                t2.getClass();
                Object a2 = T.a(t2, this);
                if (a2 == aVar2) {
                    return aVar2;
                }
                return a2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Q q, T0.d dVar) {
        super(3, dVar);
        this.f543e = q;
    }
}
