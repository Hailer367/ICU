package O;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class F extends M2.h implements S2.l {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1097j = 1;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ N f1098l;

    /* renamed from: m, reason: collision with root package name */
    public Object f1099m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f1100n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Serializable f1101o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public F(N n3, K2.i iVar, S2.p pVar, K2.d dVar) {
        super(1, dVar);
        this.f1098l = n3;
        this.f1100n = iVar;
        this.f1101o = (M2.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [S2.p, M2.h] */
    @Override // S2.l
    public final Object f(Object obj) {
        K2.d dVar = (K2.d) obj;
        switch (this.f1097j) {
            case 0:
                return new F((T2.p) this.f1100n, this.f1098l, (T2.o) this.f1101o, dVar).k(H2.i.f681a);
            default:
                return new F(this.f1098l, (K2.i) this.f1100n, (S2.p) this.f1101o, dVar).k(H2.i.f681a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Type inference failed for: r7v3, types: [S2.p, M2.h] */
    @Override // M2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O.F.k(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(T2.p pVar, N n3, T2.o oVar, K2.d dVar) {
        super(1, dVar);
        this.f1100n = pVar;
        this.f1098l = n3;
        this.f1101o = oVar;
    }
}
