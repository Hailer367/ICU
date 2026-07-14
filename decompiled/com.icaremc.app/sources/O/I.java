package O;

import b3.AbstractC0245u;
import b3.InterfaceC0243s;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class I extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f1105j;
    public /* synthetic */ Object k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ N f1106l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ M2.h f1107m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public I(N n3, S2.p pVar, K2.d dVar) {
        super(2, dVar);
        this.f1106l = n3;
        this.f1107m = (M2.h) pVar;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((I) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [S2.p, M2.h] */
    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        I i4 = new I(this.f1106l, this.f1107m, dVar);
        i4.k = obj;
        return i4;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [b3.W, b3.m] */
    /* JADX WARN: Type inference failed for: r6v0, types: [S2.p, M2.h] */
    @Override // M2.a
    public final Object k(Object obj) {
        int i4 = this.f1105j;
        if (i4 != 0) {
            if (i4 == 1) {
                k3.b.A(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k3.b.A(obj);
        InterfaceC0243s interfaceC0243s = (InterfaceC0243s) this.k;
        ?? w2 = new b3.W(true);
        Throwable th = null;
        w2.C(null);
        N n3 = this.f1106l;
        a0 a0Var = new a0(this.f1107m, w2, n3.f1126m.k(), interfaceC0243s.f());
        P1.y yVar = n3.f1130q;
        Object i5 = ((d3.c) yVar.f1471h).i(a0Var);
        if (i5 instanceof d3.h) {
            d3.h hVar = (d3.h) i5;
            if (hVar == null) {
                hVar = null;
            }
            if (hVar != null) {
                th = hVar.f3530a;
            }
            if (th == null) {
                throw new IllegalStateException("Channel was closed normally");
            }
            throw th;
        }
        if (!(i5 instanceof d3.i)) {
            if (((AtomicInteger) ((R1.c) yVar.f1472i).f1532g).getAndIncrement() == 0) {
                AbstractC0245u.f((InterfaceC0243s) yVar.f1469f, new e0(yVar, null));
            }
            this.f1105j = 1;
            Object R3 = w2.R(this);
            L2.a aVar = L2.a.f1019f;
            if (R3 == aVar) {
                return aVar;
            }
            return R3;
        }
        throw new IllegalStateException("Check failed.");
    }
}
