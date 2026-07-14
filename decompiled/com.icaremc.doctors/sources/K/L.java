package K;

import a.AbstractC0051a;
import java.util.concurrent.atomic.AtomicInteger;
import l1.AbstractC0244w;
import l1.InterfaceC0242u;

/* loaded from: classes.dex */
public final class L extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f387c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f388d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q f389e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ V0.h f390f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public L(Q q, c1.p pVar, T0.d dVar) {
        super(2, dVar);
        this.f389e = q;
        this.f390f = (V0.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [V0.h, c1.p] */
    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        L l2 = new L(this.f389e, this.f390f, dVar);
        l2.f388d = obj;
        return l2;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((L) create((InterfaceC0242u) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [l1.n, l1.X] */
    /* JADX WARN: Type inference failed for: r7v0, types: [V0.h, c1.p] */
    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f387c;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0051a.V(obj);
        InterfaceC0242u interfaceC0242u = (InterfaceC0242u) this.f388d;
        ?? x2 = new l1.X(true);
        Throwable th = null;
        x2.B(null);
        Q q = this.f389e;
        d0 d0Var = new d0(this.f390f, x2, q.f414j.k(), interfaceC0242u.e());
        B0.q qVar = q.f418n;
        Object i3 = ((n1.c) qVar.f132e).i(d0Var);
        if (i3 instanceof n1.h) {
            n1.h hVar = (n1.h) i3;
            if (hVar == null) {
                hVar = null;
            }
            if (hVar != null) {
                th = hVar.f3344a;
            }
            if (th == null) {
                throw new IllegalStateException("Channel was closed normally");
            }
            throw th;
        }
        if (!(i3 instanceof n1.i)) {
            if (((AtomicInteger) ((F.h) qVar.f133f).f274d).getAndIncrement() == 0) {
                AbstractC0244w.f((InterfaceC0242u) qVar.f130c, new h0(qVar, null));
            }
            this.f387c = 1;
            Object Q2 = x2.Q(this);
            if (Q2 == aVar) {
                return aVar;
            }
            return Q2;
        }
        throw new IllegalStateException("Check failed.");
    }
}
