package O;

import b3.InterfaceC0243s;

/* loaded from: classes.dex */
public final class G extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f1102j;
    public final /* synthetic */ N k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(N n3, K2.d dVar) {
        super(2, dVar);
        this.k = n3;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((G) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new G(this.k, dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r7 == r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        if (r0.h(r6) == r5) goto L22;
     */
    @Override // M2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r7) {
        /*
            r6 = this;
            O.N r0 = r6.k
            R1.c r1 = r0.f1126m
            int r2 = r6.f1102j
            r3 = 2
            r4 = 1
            L2.a r5 = L2.a.f1019f
            if (r2 == 0) goto L22
            if (r2 == r4) goto L1c
            if (r2 != r3) goto L14
            k3.b.A(r7)
            goto L45
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            k3.b.A(r7)     // Catch: java.lang.Throwable -> L20
            goto L3b
        L20:
            r7 = move-exception
            goto L48
        L22:
            k3.b.A(r7)
            O.j0 r7 = r1.k()
            boolean r7 = r7 instanceof O.Z
            if (r7 == 0) goto L32
            O.j0 r7 = r1.k()
            return r7
        L32:
            r6.f1102j = r4     // Catch: java.lang.Throwable -> L20
            java.lang.Object r7 = r0.h(r6)     // Catch: java.lang.Throwable -> L20
            if (r7 != r5) goto L3b
            goto L44
        L3b:
            r6.f1102j = r3
            r7 = 0
            java.lang.Object r7 = O.N.e(r0, r7, r6)
            if (r7 != r5) goto L45
        L44:
            return r5
        L45:
            O.j0 r7 = (O.j0) r7
            return r7
        L48:
            O.b0 r0 = new O.b0
            r1 = -1
            r0.<init>(r7, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: O.G.k(java.lang.Object):java.lang.Object");
    }
}
