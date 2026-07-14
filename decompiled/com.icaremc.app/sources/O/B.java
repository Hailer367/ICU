package O;

/* loaded from: classes.dex */
public final class B extends M2.h implements S2.l {

    /* renamed from: j, reason: collision with root package name */
    public Throwable f1079j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ N f1080l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(N n3, K2.d dVar) {
        super(1, dVar);
        this.f1080l = n3;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        return new B(this.f1080l, (K2.d) obj).k(H2.i.f681a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        if (r6 != r4) goto L22;
     */
    @Override // M2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.k
            O.N r1 = r5.f1080l
            r2 = 2
            r3 = 1
            L2.a r4 = L2.a.f1019f
            if (r0 == 0) goto L23
            if (r0 == r3) goto L1c
            if (r0 != r2) goto L14
            java.lang.Throwable r0 = r5.f1079j
            k3.b.A(r6)
            goto L41
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1c:
            k3.b.A(r6)     // Catch: java.lang.Throwable -> L20
            goto L2f
        L20:
            r6 = move-exception
            r0 = r6
            goto L32
        L23:
            k3.b.A(r6)
            r5.k = r3     // Catch: java.lang.Throwable -> L20
            java.lang.Object r6 = O.N.f(r1, r3, r5)     // Catch: java.lang.Throwable -> L20
            if (r6 != r4) goto L2f
            goto L40
        L2f:
            O.j0 r6 = (O.j0) r6     // Catch: java.lang.Throwable -> L20
            goto L4d
        L32:
            O.i0 r6 = r1.g()
            r5.f1079j = r0
            r5.k = r2
            java.lang.Integer r6 = r6.a()
            if (r6 != r4) goto L41
        L40:
            return r4
        L41:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            O.b0 r1 = new O.b0
            r1.<init>(r0, r6)
            r6 = r1
        L4d:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            H2.d r1 = new H2.d
            r1.<init>(r6, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: O.B.k(java.lang.Object):java.lang.Object");
    }
}
