package K;

import a.AbstractC0051a;

/* renamed from: K.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0040o extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f532c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Q f533d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0040o(Q q, T0.d dVar) {
        super(2, dVar);
        this.f533d = q;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        return new C0040o(this.f533d, dVar);
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0040o) create((o1.e) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f532c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0051a.V(obj);
            this.f532c = 1;
            if (Q.c(this.f533d, this) == aVar) {
                return aVar;
            }
        }
        return Q0.j.f722a;
    }
}
