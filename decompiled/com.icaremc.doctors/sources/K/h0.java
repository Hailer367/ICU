package K;

import l1.InterfaceC0242u;

/* loaded from: classes.dex */
public final class h0 extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public N f487c;

    /* renamed from: d, reason: collision with root package name */
    public int f488d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ B0.q f489e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(B0.q qVar, T0.d dVar) {
        super(2, dVar);
        this.f489e = qVar;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        return new h0(this.f489e, dVar);
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((h0) create((InterfaceC0242u) obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x016c, code lost:
    
        if (r3 == r0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0147, code lost:
    
        if (r3 == n1.e.f3337n) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0149, code lost:
    
        r4.a();
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0158, code lost:
    
        throw new java.lang.IllegalStateException(r18);
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x018b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x017b -> B:6:0x017d). Please report as a decompilation issue!!! */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K.h0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
