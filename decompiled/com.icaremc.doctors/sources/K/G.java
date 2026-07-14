package K;

/* loaded from: classes.dex */
public final class G extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public Object f367c;

    /* renamed from: d, reason: collision with root package name */
    public int f368d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ boolean f369e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Q f370f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f371g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(Q q, int i2, T0.d dVar) {
        super(2, dVar);
        this.f370f = q;
        this.f371g = i2;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        G g2 = new G(this.f370f, this.f371g, dVar);
        g2.f369e = ((Boolean) obj).booleanValue();
        return g2;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((G) create(bool, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002f, code lost:
    
        if (r7 == r0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0055  */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            U0.a r0 = U0.a.f780c
            int r1 = r6.f368d
            K.Q r2 = r6.f370f
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L22
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L14
            java.lang.Object r0 = r6.f367c
            a.AbstractC0051a.V(r7)
            goto L45
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            boolean r1 = r6.f369e
            a.AbstractC0051a.V(r7)
            goto L32
        L22:
            a.AbstractC0051a.V(r7)
            boolean r1 = r6.f369e
            r6.f369e = r1
            r6.f368d = r4
            java.lang.Object r7 = r2.j(r6)
            if (r7 != r0) goto L32
            goto L42
        L32:
            if (r1 == 0) goto L4c
            K.l0 r1 = r2.f()
            r6.f367c = r7
            r6.f368d = r3
            java.lang.Integer r1 = r1.a()
            if (r1 != r0) goto L43
        L42:
            return r0
        L43:
            r0 = r7
            r7 = r1
        L45:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            goto L51
        L4c:
            int r0 = r6.f371g
            r5 = r0
            r0 = r7
            r7 = r5
        L51:
            K.d r1 = new K.d
            if (r0 == 0) goto L5a
            int r2 = r0.hashCode()
            goto L5b
        L5a:
            r2 = 0
        L5b:
            r1.<init>(r0, r2, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: K.G.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
