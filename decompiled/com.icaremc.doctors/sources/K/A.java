package K;

import l1.InterfaceC0242u;

/* loaded from: classes.dex */
public final class A extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public int f337c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Q f338d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(Q q, T0.d dVar) {
        super(2, dVar);
        this.f338d = q;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        return new A(this.f338d, dVar);
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((A) create((InterfaceC0242u) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r9 == r0) goto L23;
     */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            U0.a r0 = U0.a.f780c
            int r1 = r8.f337c
            Q0.j r2 = Q0.j.f722a
            r3 = 2
            r4 = 1
            K.Q r5 = r8.f338d
            if (r1 == 0) goto L20
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L14
            a.AbstractC0051a.V(r9)
            return r2
        L14:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            a.AbstractC0051a.V(r9)
            goto L36
        L20:
            a.AbstractC0051a.V(r9)
            B0.q r9 = r5.f415k
            r8.f337c = r4
            java.lang.Object r9 = r9.f131d
            l1.n r9 = (l1.C0236n) r9
            java.lang.Object r9 = r9.Q(r8)
            if (r9 != r0) goto L32
            goto L33
        L32:
            r9 = r2
        L33:
            if (r9 != r0) goto L36
            goto L61
        L36:
            K.l0 r9 = r5.f()
            K.u r9 = r9.f518c
            n1.a r1 = n1.a.f3307d
            boolean r6 = r9 instanceof p1.i
            r7 = 0
            if (r6 == 0) goto L4b
            p1.i r9 = (p1.i) r9
            r6 = 0
            o1.d r9 = p1.k.a(r9, r6, r7, r1, r4)
            goto L53
        L4b:
            p1.g r4 = new p1.g
            T0.j r6 = T0.j.f774c
            r4.<init>(r9, r6, r7, r1)
            r9 = r4
        L53:
            K.t r1 = new K.t
            r4 = 1
            r1.<init>(r4, r5)
            r8.f337c = r3
            java.lang.Object r9 = r9.collect(r1, r8)
            if (r9 != r0) goto L62
        L61:
            return r0
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: K.A.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
