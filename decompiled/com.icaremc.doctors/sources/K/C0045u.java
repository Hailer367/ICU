package K;

/* renamed from: K.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0045u implements o1.d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f549c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final Object f550d;

    public C0045u(o1.k kVar) {
        this.f550d = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Type inference failed for: r7v6, types: [V0.h, c1.p] */
    @Override // o1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(o1.e r7, T0.d r8) {
        /*
            r6 = this;
            int r0 = r6.f549c
            switch(r0) {
                case 0: goto L69;
                default: goto L5;
            }
        L5:
            boolean r0 = r8 instanceof o1.a
            if (r0 == 0) goto L18
            r0 = r8
            o1.a r0 = (o1.a) r0
            int r1 = r0.f3395f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L18
            int r1 = r1 - r2
            r0.f3395f = r1
            goto L1d
        L18:
            o1.a r0 = new o1.a
            r0.<init>(r6, r8)
        L1d:
            java.lang.Object r8 = r0.f3393d
            U0.a r1 = U0.a.f780c
            int r2 = r0.f3395f
            Q0.j r3 = Q0.j.f722a
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            p1.l r7 = r0.f3392c
            a.AbstractC0051a.V(r8)     // Catch: java.lang.Throwable -> L30
            goto L5a
        L30:
            r8 = move-exception
            goto L65
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            a.AbstractC0051a.V(r8)
            p1.l r8 = new p1.l
            T0.i r2 = r0.getContext()
            r8.<init>(r7, r2)
            r0.f3392c = r8     // Catch: java.lang.Throwable -> L63
            r0.f3395f = r4     // Catch: java.lang.Throwable -> L63
            java.lang.Object r7 = r6.f550d     // Catch: java.lang.Throwable -> L63
            V0.h r7 = (V0.h) r7     // Catch: java.lang.Throwable -> L63
            java.lang.Object r7 = r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L63
            if (r7 != r1) goto L55
            goto L56
        L55:
            r7 = r3
        L56:
            if (r7 != r1) goto L59
            goto L5e
        L59:
            r7 = r8
        L5a:
            r7.releaseIntercepted()
            r1 = r3
        L5e:
            return r1
        L5f:
            r5 = r8
            r8 = r7
            r7 = r5
            goto L65
        L63:
            r7 = move-exception
            goto L5f
        L65:
            r7.releaseIntercepted()
            throw r8
        L69:
            java.lang.Object r0 = r6.f550d
            o1.k r0 = (o1.k) r0
            K.t r1 = new K.t
            r2 = 0
            r1.<init>(r2, r7)
            java.lang.Object r7 = r0.collect(r1, r8)
            U0.a r8 = U0.a.f780c
            if (r7 != r8) goto L7c
            goto L7e
        L7c:
            Q0.j r7 = Q0.j.f722a
        L7e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: K.C0045u.collect(o1.e, T0.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0045u(c1.p pVar) {
        this.f550d = (V0.h) pVar;
    }
}
