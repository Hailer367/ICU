package O;

/* loaded from: classes.dex */
public final class Y extends P {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r6, M2.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof O.X
            if (r0 == 0) goto L13
            r0 = r7
            O.X r0 = (O.X) r0
            int r1 = r0.f1163m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1163m = r1
            goto L18
        L13:
            O.X r0 = new O.X
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.k
            int r1 = r0.f1163m
            H2.i r2 = H2.i.f681a
            r3 = 1
            if (r1 == 0) goto L35
            if (r1 != r3) goto L2d
            java.io.FileOutputStream r6 = r0.f1161j
            java.io.FileOutputStream r0 = r0.f1160i
            k3.b.A(r7)     // Catch: java.lang.Throwable -> L2b
            goto L5e
        L2b:
            r6 = move-exception
            goto L6c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            k3.b.A(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.f1136b
            boolean r7 = r7.get()
            if (r7 != 0) goto L72
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r1 = r5.f1135a
            r7.<init>(r1)
            S.g r1 = S.g.f1540a     // Catch: java.lang.Throwable -> L6a
            O.l0 r4 = new O.l0     // Catch: java.lang.Throwable -> L6a
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L6a
            r0.f1160i = r7     // Catch: java.lang.Throwable -> L6a
            r0.f1161j = r7     // Catch: java.lang.Throwable -> L6a
            r0.f1163m = r3     // Catch: java.lang.Throwable -> L6a
            r1.b(r6, r4)     // Catch: java.lang.Throwable -> L6a
            L2.a r6 = L2.a.f1019f
            if (r2 != r6) goto L5c
            return r6
        L5c:
            r6 = r7
            r0 = r6
        L5e:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L2b
            r6.sync()     // Catch: java.lang.Throwable -> L2b
            r6 = 0
            a.AbstractC0141a.e(r0, r6)
            return r2
        L6a:
            r6 = move-exception
            r0 = r7
        L6c:
            throw r6     // Catch: java.lang.Throwable -> L6d
        L6d:
            r7 = move-exception
            a.AbstractC0141a.e(r0, r6)
            throw r7
        L72:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "This scope has already been closed."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: O.Y.b(java.lang.Object, M2.c):java.lang.Object");
    }
}
