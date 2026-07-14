package O;

/* loaded from: classes.dex */
public final class M extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public T2.o f1114j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f1115l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ T2.o f1116m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ N f1117n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f1118o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f1119p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(T2.o oVar, N n3, Object obj, boolean z, K2.d dVar) {
        super(2, dVar);
        this.f1116m = oVar;
        this.f1117n = n3;
        this.f1118o = obj;
        this.f1119p = z;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((M) i((K2.d) obj2, (Y) obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        M m3 = new M(this.f1116m, this.f1117n, this.f1118o, this.f1119p, dVar);
        m3.f1115l = obj;
        return m3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r5.b(r1, r7) == r6) goto L16;
     */
    @Override // M2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.k
            java.lang.Object r1 = r7.f1118o
            O.N r2 = r7.f1117n
            T2.o r3 = r7.f1116m
            r4 = 2
            r5 = 1
            L2.a r6 = L2.a.f1019f
            if (r0 == 0) goto L28
            if (r0 == r5) goto L1e
            if (r0 != r4) goto L16
            k3.b.A(r8)
            goto L65
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            T2.o r0 = r7.f1114j
            java.lang.Object r5 = r7.f1115l
            O.Y r5 = (O.Y) r5
            k3.b.A(r8)
            goto L4f
        L28:
            k3.b.A(r8)
            java.lang.Object r8 = r7.f1115l
            O.Y r8 = (O.Y) r8
            O.i0 r0 = r2.g()
            r7.f1115l = r8
            r7.f1114j = r3
            r7.k = r5
            R1.c r0 = r0.f1202b
            java.lang.Object r0 = r0.f1532g
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            int r0 = r0.incrementAndGet()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r0)
            if (r5 != r6) goto L4b
            goto L64
        L4b:
            r0 = r5
            r5 = r8
            r8 = r0
            r0 = r3
        L4f:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r0.f1644f = r8
            r8 = 0
            r7.f1115l = r8
            r7.f1114j = r8
            r7.k = r4
            java.lang.Object r8 = r5.b(r1, r7)
            if (r8 != r6) goto L65
        L64:
            return r6
        L65:
            boolean r8 = r7.f1119p
            if (r8 == 0) goto L7d
            R1.c r8 = r2.f1126m
            O.d r0 = new O.d
            if (r1 == 0) goto L74
            int r2 = r1.hashCode()
            goto L75
        L74:
            r2 = 0
        L75:
            int r3 = r3.f1644f
            r0.<init>(r1, r2, r3)
            r8.w(r0)
        L7d:
            H2.i r8 = H2.i.f681a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: O.M.k(java.lang.Object):java.lang.Object");
    }
}
