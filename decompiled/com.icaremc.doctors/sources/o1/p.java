package o1;

import K.C0041p;

/* loaded from: classes.dex */
public final class p implements e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0041p f3445c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f3446d;

    public p(C0041p c0041p, e eVar) {
        this.f3445c = c0041p;
        this.f3446d = eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        if (r2.emit(r9, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // o1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, T0.d r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof o1.o
            if (r0 == 0) goto L13
            r0 = r9
            o1.o r0 = (o1.o) r0
            int r1 = r0.f3442e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3442e = r1
            goto L18
        L13:
            o1.o r0 = new o1.o
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f3441d
            U0.a r1 = U0.a.f780c
            int r2 = r0.f3442e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            o1.p r8 = r0.f3440c
            a.AbstractC0051a.V(r9)
            goto L6e
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.f3444g
            o1.p r2 = r0.f3440c
            a.AbstractC0051a.V(r9)
            r6 = r9
            r9 = r8
            r8 = r2
            r2 = r6
            goto L55
        L40:
            a.AbstractC0051a.V(r9)
            r0.f3440c = r7
            r0.f3444g = r8
            r0.f3442e = r4
            K.p r9 = r7.f3445c
            java.lang.Object r9 = r9.invoke(r8, r0)
            if (r9 != r1) goto L52
            goto L6c
        L52:
            r2 = r9
            r9 = r8
            r8 = r7
        L55:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L6d
            o1.e r2 = r8.f3446d
            r0.f3440c = r8
            r5 = 0
            r0.f3444g = r5
            r0.f3442e = r3
            java.lang.Object r9 = r2.emit(r9, r0)
            if (r9 != r1) goto L6e
        L6c:
            return r1
        L6d:
            r4 = 0
        L6e:
            if (r4 == 0) goto L73
            Q0.j r8 = Q0.j.f722a
            return r8
        L73:
            p1.a r9 = new p1.a
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.p.emit(java.lang.Object, T0.d):java.lang.Object");
    }
}
