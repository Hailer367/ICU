package o1;

/* loaded from: classes.dex */
public final class c extends p1.e {

    /* renamed from: f, reason: collision with root package name */
    public final V0.h f3400f;

    /* renamed from: g, reason: collision with root package name */
    public final V0.h f3401g;

    /* JADX WARN: Multi-variable type inference failed */
    public c(c1.p pVar, T0.i iVar, int i2, n1.a aVar) {
        super(iVar, i2, aVar);
        V0.h hVar = (V0.h) pVar;
        this.f3400f = hVar;
        this.f3401g = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r7v3, types: [V0.h, c1.p] */
    @Override // p1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(n1.r r6, T0.d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof o1.b
            if (r0 == 0) goto L13
            r0 = r7
            o1.b r0 = (o1.b) r0
            int r1 = r0.f3399f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3399f = r1
            goto L1a
        L13:
            o1.b r0 = new o1.b
            V0.c r7 = (V0.c) r7
            r0.<init>(r5, r7)
        L1a:
            java.lang.Object r7 = r0.f3397d
            U0.a r1 = U0.a.f780c
            int r2 = r0.f3399f
            Q0.j r3 = Q0.j.f722a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            n1.r r6 = r0.f3396c
            a.AbstractC0051a.V(r7)
            goto L49
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            a.AbstractC0051a.V(r7)
            r0.f3396c = r6
            r0.f3399f = r4
            V0.h r7 = r5.f3400f
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L45
            goto L46
        L45:
            r7 = r3
        L46:
            if (r7 != r1) goto L49
            return r1
        L49:
            n1.q r6 = (n1.q) r6
            n1.c r6 = r6.f3353f
            boolean r6 = r6.s()
            if (r6 == 0) goto L54
            return r3
        L54:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.c.b(n1.r, T0.d):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [V0.h, c1.p] */
    @Override // p1.e
    public final p1.e c(T0.i iVar, int i2, n1.a aVar) {
        return new c(this.f3401g, iVar, i2, aVar);
    }

    @Override // p1.e
    public final String toString() {
        return "block[" + this.f3400f + "] -> " + super.toString();
    }
}
