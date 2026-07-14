package K;

import a.AbstractC0051a;

/* renamed from: K.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0048x extends V0.h implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public int f560c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ H f561d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0048x(H h2, T0.d dVar) {
        super(1, dVar);
        this.f561d = h2;
    }

    @Override // V0.a
    public final T0.d create(T0.d dVar) {
        return new C0048x(this.f561d, dVar);
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        return ((C0048x) create((T0.d) obj)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f560c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0051a.V(obj);
        this.f560c = 1;
        Object invoke = this.f561d.invoke(this);
        if (invoke == aVar) {
            return aVar;
        }
        return invoke;
    }
}
