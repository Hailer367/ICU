package K;

/* renamed from: K.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0046v extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public C0029d f551c;

    /* renamed from: d, reason: collision with root package name */
    public int f552d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f553e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Q f554f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0046v(Q q, T0.d dVar) {
        super(2, dVar);
        this.f554f = q;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        C0046v c0046v = new C0046v(this.f554f, dVar);
        c0046v.f553e = obj;
        return c0046v;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0046v) create((o1.e) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r3.emit(r12, r11) == r0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
    
        if ((r1 instanceof K.c0) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c8  */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K.C0046v.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
