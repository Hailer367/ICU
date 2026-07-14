package K;

import a.AbstractC0051a;
import l1.InterfaceC0242u;

/* loaded from: classes.dex */
public final class J extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f379c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ V0.h f380d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0029d f381e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public J(c1.p pVar, C0029d c0029d, T0.d dVar) {
        super(2, dVar);
        this.f380d = (V0.h) pVar;
        this.f381e = c0029d;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [V0.h, c1.p] */
    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        return new J(this.f380d, this.f381e, dVar);
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((J) create((InterfaceC0242u) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [V0.h, c1.p] */
    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f379c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0051a.V(obj);
        Object obj2 = this.f381e.f457b;
        this.f379c = 1;
        Object invoke = this.f380d.invoke(obj2, this);
        if (invoke == aVar) {
            return aVar;
        }
        return invoke;
    }
}
