package e3;

/* loaded from: classes.dex */
public final class i implements d {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ A2.q f3625f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ O.r f3626g;

    public i(A2.q qVar, O.r rVar) {
        this.f3625f = qVar;
        this.f3626g = rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // e3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(e3.e r9, K2.d r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof e3.h
            if (r0 == 0) goto L13
            r0 = r10
            e3.h r0 = (e3.h) r0
            int r1 = r0.f3622j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3622j = r1
            goto L18
        L13:
            e3.h r0 = new e3.h
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f3621i
            int r1 = r0.f3622j
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            L2.a r6 = L2.a.f1019f
            if (r1 == 0) goto L50
            if (r1 == r4) goto L44
            if (r1 == r3) goto L3c
            if (r1 != r2) goto L34
            java.lang.Object r9 = r0.f3623l
            f3.l r9 = (f3.l) r9
            k3.b.A(r10)     // Catch: java.lang.Throwable -> L32
            goto L7d
        L32:
            r10 = move-exception
            goto L87
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r9 = r0.f3623l
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            k3.b.A(r10)
            goto La1
        L44:
            e3.e r9 = r0.f3624m
            java.lang.Object r1 = r0.f3623l
            e3.i r1 = (e3.i) r1
            k3.b.A(r10)     // Catch: java.lang.Throwable -> L4e
            goto L63
        L4e:
            r9 = move-exception
            goto L8d
        L50:
            k3.b.A(r10)
            A2.q r10 = r8.f3625f     // Catch: java.lang.Throwable -> L8b
            r0.f3623l = r8     // Catch: java.lang.Throwable -> L8b
            r0.f3624m = r9     // Catch: java.lang.Throwable -> L8b
            r0.f3622j = r4     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r10 = r10.u(r9, r0)     // Catch: java.lang.Throwable -> L8b
            if (r10 != r6) goto L62
            goto La0
        L62:
            r1 = r8
        L63:
            f3.l r10 = new f3.l
            K2.i r3 = r0.f1052g
            T2.h.b(r3)
            r10.<init>(r9, r3)
            O.r r9 = r1.f3626g     // Catch: java.lang.Throwable -> L83
            r0.f3623l = r10     // Catch: java.lang.Throwable -> L83
            r0.f3624m = r5     // Catch: java.lang.Throwable -> L83
            r0.f3622j = r2     // Catch: java.lang.Throwable -> L83
            java.lang.Object r9 = r9.c(r10, r5, r0)     // Catch: java.lang.Throwable -> L83
            if (r9 != r6) goto L7c
            goto La0
        L7c:
            r9 = r10
        L7d:
            r9.m()
            H2.i r9 = H2.i.f681a
            return r9
        L83:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L87:
            r9.m()
            throw r10
        L8b:
            r9 = move-exception
            r1 = r8
        L8d:
            e3.u r10 = new e3.u
            r10.<init>(r9)
            O.r r1 = r1.f3626g
            r0.f3623l = r9
            r0.f3624m = r5
            r0.f3622j = r3
            java.lang.Object r10 = e3.s.a(r10, r1, r9, r0)
            if (r10 != r6) goto La1
        La0:
            return r6
        La1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.i.u(e3.e, K2.d):java.lang.Object");
    }
}
