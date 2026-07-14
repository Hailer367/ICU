package K;

/* loaded from: classes.dex */
public final class b0 extends T {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r7, V0.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof K.a0
            if (r0 == 0) goto L13
            r0 = r8
            K.a0 r0 = (K.a0) r0
            int r1 = r0.f455g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f455g = r1
            goto L18
        L13:
            K.a0 r0 = new K.a0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f453e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f455g
            Q0.j r3 = Q0.j.f722a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.io.FileOutputStream r7 = r0.f452d
            java.io.FileOutputStream r0 = r0.f451c
            a.AbstractC0051a.V(r8)     // Catch: java.lang.Throwable -> L2d
            goto L5e
        L2d:
            r7 = move-exception
            goto L6c
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            a.AbstractC0051a.V(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r6.f425b
            boolean r8 = r8.get()
            if (r8 != 0) goto L72
            java.io.FileOutputStream r8 = new java.io.FileOutputStream
            java.io.File r2 = r6.f424a
            r8.<init>(r2)
            O.i r2 = O.i.f634a     // Catch: java.lang.Throwable -> L6a
            K.o0 r5 = new K.o0     // Catch: java.lang.Throwable -> L6a
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L6a
            r0.f451c = r8     // Catch: java.lang.Throwable -> L6a
            r0.f452d = r8     // Catch: java.lang.Throwable -> L6a
            r0.f455g = r4     // Catch: java.lang.Throwable -> L6a
            r2.b(r7, r5)     // Catch: java.lang.Throwable -> L6a
            if (r3 != r1) goto L5c
            return r1
        L5c:
            r7 = r8
            r0 = r7
        L5e:
            java.io.FileDescriptor r7 = r7.getFD()     // Catch: java.lang.Throwable -> L2d
            r7.sync()     // Catch: java.lang.Throwable -> L2d
            r7 = 0
            a.AbstractC0051a.d(r0, r7)
            return r3
        L6a:
            r7 = move-exception
            r0 = r8
        L6c:
            throw r7     // Catch: java.lang.Throwable -> L6d
        L6d:
            r8 = move-exception
            a.AbstractC0051a.d(r0, r7)
            throw r8
        L72:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "This scope has already been closed."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: K.b0.b(java.lang.Object, V0.c):java.lang.Object");
    }
}
