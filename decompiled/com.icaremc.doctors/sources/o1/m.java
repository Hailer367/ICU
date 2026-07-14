package o1;

import K.C0042q;

/* loaded from: classes.dex */
public final class m implements e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3432c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3433d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f3434e;

    /* renamed from: f, reason: collision with root package name */
    public final V0.h f3435f;

    public m(kotlin.jvm.internal.o oVar, e eVar, C0042q c0042q) {
        this.f3433d = oVar;
        this.f3434e = eVar;
        this.f3435f = c0042q;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    @Override // o1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, T0.d r9) {
        /*
            r7 = this;
            int r0 = r7.f3432c
            switch(r0) {
                case 0: goto L1b;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r7.f3433d
            T0.i r0 = (T0.i) r0
            V0.h r1 = r7.f3435f
            p1.r r1 = (p1.r) r1
            java.lang.Object r2 = r7.f3434e
            java.lang.Object r8 = p1.k.b(r0, r8, r2, r1, r9)
            U0.a r9 = U0.a.f780c
            if (r8 != r9) goto L18
            goto L1a
        L18:
            Q0.j r8 = Q0.j.f722a
        L1a:
            return r8
        L1b:
            boolean r0 = r9 instanceof o1.l
            if (r0 == 0) goto L2e
            r0 = r9
            o1.l r0 = (o1.l) r0
            int r1 = r0.f3431g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L2e
            int r1 = r1 - r2
            r0.f3431g = r1
            goto L33
        L2e:
            o1.l r0 = new o1.l
            r0.<init>(r7, r9)
        L33:
            java.lang.Object r9 = r0.f3429e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f3431g
            r3 = 3
            r4 = 2
            Q0.j r5 = Q0.j.f722a
            r6 = 1
            if (r2 == 0) goto L5b
            if (r2 == r6) goto L46
            if (r2 == r4) goto L53
            if (r2 != r3) goto L4b
        L46:
            a.AbstractC0051a.V(r9)
        L49:
            r1 = r5
            goto La4
        L4b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L53:
            java.lang.Object r8 = r0.f3428d
            o1.m r2 = r0.f3427c
            a.AbstractC0051a.V(r9)
            goto L85
        L5b:
            a.AbstractC0051a.V(r9)
            java.lang.Object r9 = r7.f3433d
            kotlin.jvm.internal.o r9 = (kotlin.jvm.internal.o) r9
            boolean r9 = r9.f2787c
            if (r9 == 0) goto L73
            java.lang.Object r9 = r7.f3434e
            o1.e r9 = (o1.e) r9
            r0.f3431g = r6
            java.lang.Object r8 = r9.emit(r8, r0)
            if (r8 != r1) goto L49
            goto La4
        L73:
            V0.h r9 = r7.f3435f
            K.q r9 = (K.C0042q) r9
            r0.f3427c = r7
            r0.f3428d = r8
            r0.f3431g = r4
            java.lang.Object r9 = r9.invoke(r8, r0)
            if (r9 != r1) goto L84
            goto La4
        L84:
            r2 = r7
        L85:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L49
            java.lang.Object r9 = r2.f3433d
            kotlin.jvm.internal.o r9 = (kotlin.jvm.internal.o) r9
            r9.f2787c = r6
            java.lang.Object r9 = r2.f3434e
            o1.e r9 = (o1.e) r9
            r2 = 0
            r0.f3427c = r2
            r0.f3428d = r2
            r0.f3431g = r3
            java.lang.Object r8 = r9.emit(r8, r0)
            if (r8 != r1) goto L49
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.m.emit(java.lang.Object, T0.d):java.lang.Object");
    }

    public m(e eVar, T0.i iVar) {
        this.f3433d = iVar;
        this.f3434e = q1.a.k(iVar);
        this.f3435f = new p1.r(eVar, null);
    }
}
