package K;

/* loaded from: classes.dex */
public final class P extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public kotlin.jvm.internal.p f400c;

    /* renamed from: d, reason: collision with root package name */
    public int f401d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f402e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.p f403f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Q f404g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f405h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f406i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(kotlin.jvm.internal.p pVar, Q q, Object obj, boolean z, T0.d dVar) {
        super(2, dVar);
        this.f403f = pVar;
        this.f404g = q;
        this.f405h = obj;
        this.f406i = z;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        P p = new P(this.f403f, this.f404g, this.f405h, this.f406i, dVar);
        p.f402e = obj;
        return p;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((P) create((b0) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r6.b(r2, r7) == r0) goto L16;
     */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            U0.a r0 = U0.a.f780c
            int r1 = r7.f401d
            java.lang.Object r2 = r7.f405h
            K.Q r3 = r7.f404g
            kotlin.jvm.internal.p r4 = r7.f403f
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L28
            if (r1 == r6) goto L1e
            if (r1 != r5) goto L16
            a.AbstractC0051a.V(r8)
            goto L65
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            kotlin.jvm.internal.p r1 = r7.f400c
            java.lang.Object r6 = r7.f402e
            K.b0 r6 = (K.b0) r6
            a.AbstractC0051a.V(r8)
            goto L4f
        L28:
            a.AbstractC0051a.V(r8)
            java.lang.Object r8 = r7.f402e
            K.b0 r8 = (K.b0) r8
            K.l0 r1 = r3.f()
            r7.f402e = r8
            r7.f400c = r4
            r7.f401d = r6
            F.h r1 = r1.f517b
            java.lang.Object r1 = r1.f274d
            java.util.concurrent.atomic.AtomicInteger r1 = (java.util.concurrent.atomic.AtomicInteger) r1
            int r1 = r1.incrementAndGet()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r1)
            if (r6 != r0) goto L4b
            goto L64
        L4b:
            r1 = r6
            r6 = r8
            r8 = r1
            r1 = r4
        L4f:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r1.f2788c = r8
            r8 = 0
            r7.f402e = r8
            r7.f400c = r8
            r7.f401d = r5
            java.lang.Object r8 = r6.b(r2, r7)
            if (r8 != r0) goto L65
        L64:
            return r0
        L65:
            boolean r8 = r7.f406i
            if (r8 == 0) goto L7d
            F.h r8 = r3.f414j
            K.d r0 = new K.d
            if (r2 == 0) goto L74
            int r1 = r2.hashCode()
            goto L75
        L74:
            r1 = 0
        L75:
            int r3 = r4.f2788c
            r0.<init>(r2, r1, r3)
            r8.m(r0)
        L7d:
            Q0.j r8 = Q0.j.f722a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: K.P.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
