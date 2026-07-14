package K;

/* loaded from: classes.dex */
public final class K extends V0.h implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public Object f382c;

    /* renamed from: d, reason: collision with root package name */
    public int f383d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q f384e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ T0.i f385f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ V0.h f386g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public K(Q q, T0.i iVar, c1.p pVar, T0.d dVar) {
        super(1, dVar);
        this.f384e = q;
        this.f385f = iVar;
        this.f386g = (V0.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [V0.h, c1.p] */
    @Override // V0.a
    public final T0.d create(T0.d dVar) {
        return new K(this.f384e, this.f385f, this.f386g, dVar);
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        return ((K) create((T0.d) obj)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        if (r9 == r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0034, code lost:
    
        if (r9 == r0) goto L29;
     */
    /* JADX WARN: Type inference failed for: r6v0, types: [V0.h, c1.p] */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            U0.a r0 = U0.a.f780c
            int r1 = r8.f383d
            K.Q r2 = r8.f384e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2b
            if (r1 == r5) goto L27
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            java.lang.Object r0 = r8.f382c
            a.AbstractC0051a.V(r9)
            return r0
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            java.lang.Object r1 = r8.f382c
            K.d r1 = (K.C0029d) r1
            a.AbstractC0051a.V(r9)
            goto L4f
        L27:
            a.AbstractC0051a.V(r9)
            goto L37
        L2b:
            a.AbstractC0051a.V(r9)
            r8.f383d = r5
            java.lang.Object r9 = K.Q.e(r2, r5, r8)
            if (r9 != r0) goto L37
            goto L6f
        L37:
            r1 = r9
            K.d r1 = (K.C0029d) r1
            K.J r9 = new K.J
            V0.h r6 = r8.f386g
            r7 = 0
            r9.<init>(r6, r1, r7)
            r8.f382c = r1
            r8.f383d = r4
            T0.i r4 = r8.f385f
            java.lang.Object r9 = l1.AbstractC0244w.m(r4, r9, r8)
            if (r9 != r0) goto L4f
            goto L6f
        L4f:
            java.lang.Object r4 = r1.f457b
            if (r4 == 0) goto L58
            int r4 = r4.hashCode()
            goto L59
        L58:
            r4 = 0
        L59:
            int r6 = r1.f458c
            if (r4 != r6) goto L71
            java.lang.Object r1 = r1.f457b
            boolean r1 = kotlin.jvm.internal.h.a(r1, r9)
            if (r1 != 0) goto L70
            r8.f382c = r9
            r8.f383d = r3
            java.lang.Object r1 = r2.k(r9, r5, r8)
            if (r1 != r0) goto L70
        L6f:
            return r0
        L70:
            return r9
        L71:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data in DataStore was mutated but DataStore is only compatible with Immutable types."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: K.K.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
