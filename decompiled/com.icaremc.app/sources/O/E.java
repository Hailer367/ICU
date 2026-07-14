package O;

/* loaded from: classes.dex */
public final class E extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public Object f1093j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ boolean f1094l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ N f1095m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f1096n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(N n3, int i4, K2.d dVar) {
        super(2, dVar);
        this.f1095m = n3;
        this.f1096n = i4;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((E) i((K2.d) obj2, bool)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        E e4 = new E(this.f1095m, this.f1096n, dVar);
        e4.f1094l = ((Boolean) obj).booleanValue();
        return e4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002f, code lost:
    
        if (r7 == r4) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0056  */
    @Override // M2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = r6.k
            O.N r1 = r6.f1095m
            r2 = 2
            r3 = 1
            L2.a r4 = L2.a.f1019f
            if (r0 == 0) goto L22
            if (r0 == r3) goto L1c
            if (r0 != r2) goto L14
            java.lang.Object r0 = r6.f1093j
            k3.b.A(r7)
            goto L46
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            boolean r0 = r6.f1094l
            k3.b.A(r7)
            goto L32
        L22:
            k3.b.A(r7)
            boolean r0 = r6.f1094l
            r6.f1094l = r0
            r6.k = r3
            java.lang.Object r7 = r1.i(r6)
            if (r7 != r4) goto L32
            goto L42
        L32:
            if (r0 == 0) goto L4d
            O.i0 r0 = r1.g()
            r6.f1093j = r7
            r6.k = r2
            java.lang.Integer r0 = r0.a()
            if (r0 != r4) goto L43
        L42:
            return r4
        L43:
            r5 = r0
            r0 = r7
            r7 = r5
        L46:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            goto L52
        L4d:
            int r0 = r6.f1096n
            r5 = r0
            r0 = r7
            r7 = r5
        L52:
            O.d r1 = new O.d
            if (r0 == 0) goto L5b
            int r2 = r0.hashCode()
            goto L5c
        L5b:
            r2 = 0
        L5c:
            r1.<init>(r0, r2, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: O.E.k(java.lang.Object):java.lang.Object");
    }
}
