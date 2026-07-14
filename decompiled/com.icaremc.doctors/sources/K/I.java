package K;

import l1.InterfaceC0242u;

/* loaded from: classes.dex */
public final class I extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f377c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Q f378d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(Q q, T0.d dVar) {
        super(2, dVar);
        this.f378d = q;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        return new I(this.f378d, dVar);
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((I) create((InterfaceC0242u) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r7 == r2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        if (r0.g(r6) == r2) goto L22;
     */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            K.Q r0 = r6.f378d
            F.h r1 = r0.f414j
            U0.a r2 = U0.a.f780c
            int r3 = r6.f377c
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L22
            if (r3 == r5) goto L1c
            if (r3 != r4) goto L14
            a.AbstractC0051a.V(r7)
            goto L45
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            a.AbstractC0051a.V(r7)     // Catch: java.lang.Throwable -> L20
            goto L3b
        L20:
            r7 = move-exception
            goto L48
        L22:
            a.AbstractC0051a.V(r7)
            K.m0 r7 = r1.k()
            boolean r7 = r7 instanceof K.c0
            if (r7 == 0) goto L32
            K.m0 r7 = r1.k()
            return r7
        L32:
            r6.f377c = r5     // Catch: java.lang.Throwable -> L20
            java.lang.Object r7 = r0.g(r6)     // Catch: java.lang.Throwable -> L20
            if (r7 != r2) goto L3b
            goto L44
        L3b:
            r6.f377c = r4
            r7 = 0
            java.lang.Object r7 = K.Q.d(r0, r7, r6)
            if (r7 != r2) goto L45
        L44:
            return r2
        L45:
            K.m0 r7 = (K.m0) r7
            return r7
        L48:
            K.e0 r0 = new K.e0
            r1 = -1
            r0.<init>(r7, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: K.I.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
