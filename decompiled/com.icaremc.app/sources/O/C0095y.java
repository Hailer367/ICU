package O;

import b3.InterfaceC0243s;

/* renamed from: O.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0095y extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public int f1259j;
    public final /* synthetic */ N k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0095y(N n3, K2.d dVar) {
        super(2, dVar);
        this.k = n3;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0095y) i((K2.d) obj2, (InterfaceC0243s) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        return new C0095y(this.k, dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r9 == r5) goto L23;
     */
    @Override // M2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.f1259j
            H2.i r1 = H2.i.f681a
            r2 = 2
            r3 = 1
            O.N r4 = r8.k
            L2.a r5 = L2.a.f1019f
            if (r0 == 0) goto L20
            if (r0 == r3) goto L1c
            if (r0 != r2) goto L14
            k3.b.A(r9)
            return r1
        L14:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            k3.b.A(r9)
            goto L36
        L20:
            k3.b.A(r9)
            P1.y r9 = r4.f1127n
            r8.f1259j = r3
            java.lang.Object r9 = r9.f1470g
            b3.m r9 = (b3.C0238m) r9
            java.lang.Object r9 = r9.R(r8)
            if (r9 != r5) goto L32
            goto L33
        L32:
            r9 = r1
        L33:
            if (r9 != r5) goto L36
            goto L63
        L36:
            O.i0 r9 = r4.g()
            R1.c r9 = r9.f1203c
            boolean r0 = r9 instanceof f3.i
            r6 = 0
            d3.a r7 = d3.a.f3493g
            if (r0 == 0) goto L4d
            f3.i r9 = (f3.i) r9
            r0 = 0
            e3.c r9 = (e3.c) r9
            e3.d r9 = f3.k.a(r9, r0, r6, r7, r3)
            goto L55
        L4d:
            f3.g r0 = new f3.g
            K2.j r3 = K2.j.f942f
            r0.<init>(r9, r3, r6, r7)
            r9 = r0
        L55:
            O.x r0 = new O.x
            r3 = 0
            r0.<init>(r3, r4)
            r8.f1259j = r2
            java.lang.Object r9 = r9.u(r0, r8)
            if (r9 != r5) goto L64
        L63:
            return r5
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: O.C0095y.k(java.lang.Object):java.lang.Object");
    }
}
