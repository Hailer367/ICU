package o1;

import K.C0045u;

/* loaded from: classes.dex */
public final class i implements d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0045u f3416c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ K.r f3417d;

    public i(C0045u c0045u, K.r rVar) {
        this.f3416c = c0045u;
        this.f3417d = rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // o1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(o1.e r9, T0.d r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof o1.h
            if (r0 == 0) goto L13
            r0 = r10
            o1.h r0 = (o1.h) r0
            int r1 = r0.f3412d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3412d = r1
            goto L18
        L13:
            o1.h r0 = new o1.h
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f3411c
            U0.a r1 = U0.a.f780c
            int r2 = r0.f3412d
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L50
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r9 = r0.f3414f
            p1.l r9 = (p1.l) r9
            a.AbstractC0051a.V(r10)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r10 = move-exception
            goto L86
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r9 = r0.f3414f
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            a.AbstractC0051a.V(r10)
            goto La0
        L44:
            o1.e r9 = r0.f3415g
            java.lang.Object r2 = r0.f3414f
            o1.i r2 = (o1.i) r2
            a.AbstractC0051a.V(r10)     // Catch: java.lang.Throwable -> L4e
            goto L63
        L4e:
            r9 = move-exception
            goto L8c
        L50:
            a.AbstractC0051a.V(r10)
            K.u r10 = r8.f3416c     // Catch: java.lang.Throwable -> L8a
            r0.f3414f = r8     // Catch: java.lang.Throwable -> L8a
            r0.f3415g = r9     // Catch: java.lang.Throwable -> L8a
            r0.f3412d = r5     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L8a
            if (r10 != r1) goto L62
            goto L9f
        L62:
            r2 = r8
        L63:
            p1.l r10 = new p1.l
            T0.i r4 = r0.getContext()
            r10.<init>(r9, r4)
            K.r r9 = r2.f3417d     // Catch: java.lang.Throwable -> L82
            r0.f3414f = r10     // Catch: java.lang.Throwable -> L82
            r0.f3415g = r6     // Catch: java.lang.Throwable -> L82
            r0.f3412d = r3     // Catch: java.lang.Throwable -> L82
            java.lang.Object r9 = r9.a(r10, r6, r0)     // Catch: java.lang.Throwable -> L82
            if (r9 != r1) goto L7b
            goto L9f
        L7b:
            r9 = r10
        L7c:
            r9.releaseIntercepted()
            Q0.j r9 = Q0.j.f722a
            return r9
        L82:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L86:
            r9.releaseIntercepted()
            throw r10
        L8a:
            r9 = move-exception
            r2 = r8
        L8c:
            o1.y r10 = new o1.y
            r10.<init>(r9)
            K.r r2 = r2.f3417d
            r0.f3414f = r9
            r0.f3415g = r6
            r0.f3412d = r4
            java.lang.Object r10 = o1.w.a(r10, r2, r9, r0)
            if (r10 != r1) goto La0
        L9f:
            return r1
        La0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.i.collect(o1.e, T0.d):java.lang.Object");
    }
}
