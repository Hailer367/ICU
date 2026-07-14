package e3;

import v0.C0686i;

/* loaded from: classes.dex */
public final class c extends f3.e {

    /* renamed from: i, reason: collision with root package name */
    public final C0686i f3612i;

    /* renamed from: j, reason: collision with root package name */
    public final C0686i f3613j;

    public c(C0686i c0686i, K2.i iVar, int i4, d3.a aVar) {
        super(iVar, i4, aVar);
        this.f3612i = c0686i;
        this.f3613j = c0686i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // f3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(d3.r r5, K2.d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof e3.b
            if (r0 == 0) goto L13
            r0 = r6
            e3.b r0 = (e3.b) r0
            int r1 = r0.f3611l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3611l = r1
            goto L1a
        L13:
            e3.b r0 = new e3.b
            M2.c r6 = (M2.c) r6
            r0.<init>(r4, r6)
        L1a:
            java.lang.Object r6 = r0.f3610j
            int r1 = r0.f3611l
            H2.i r2 = H2.i.f681a
            r3 = 1
            if (r1 == 0) goto L33
            if (r1 != r3) goto L2b
            d3.r r5 = r0.f3609i
            k3.b.A(r6)
            goto L49
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            k3.b.A(r6)
            r0.f3609i = r5
            r0.f3611l = r3
            v0.i r6 = r4.f3612i
            java.lang.Object r6 = r6.e(r5, r0)
            L2.a r0 = L2.a.f1019f
            if (r6 != r0) goto L45
            goto L46
        L45:
            r6 = r2
        L46:
            if (r6 != r0) goto L49
            return r0
        L49:
            d3.q r5 = (d3.q) r5
            d3.c r5 = r5.f3539i
            boolean r5 = r5.s()
            if (r5 == 0) goto L54
            return r2
        L54:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.c.a(d3.r, K2.d):java.lang.Object");
    }

    @Override // f3.e
    public final String toString() {
        return "block[" + this.f3612i + "] -> " + super.toString();
    }
}
