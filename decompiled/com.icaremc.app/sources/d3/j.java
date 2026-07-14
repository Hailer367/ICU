package d3;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final i f3531a = new Object();

    public static c a(int i4, a aVar, int i5) {
        int i6 = i5 & 2;
        a aVar2 = a.f3492f;
        if (i6 != 0) {
            aVar = aVar2;
        }
        if (i4 != -2) {
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != Integer.MAX_VALUE) {
                        if (aVar == aVar2) {
                            return new c(i4);
                        }
                        return new n(i4, aVar);
                    }
                    return new c(Integer.MAX_VALUE);
                }
                if (aVar == aVar2) {
                    return new c(0);
                }
                return new n(1, aVar);
            }
            if (aVar == aVar2) {
                return new n(1, a.f3493g);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (aVar == aVar2) {
            g.f3529d.getClass();
            return new c(f.f3528b);
        }
        return new n(1, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(d3.r r4, Q.a r5, M2.c r6) {
        /*
            boolean r0 = r6 instanceof d3.o
            if (r0 == 0) goto L13
            r0 = r6
            d3.o r0 = (d3.o) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            d3.o r0 = new d3.o
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f3537j
            int r1 = r0.k
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            Q.a r5 = r0.f3536i
            k3.b.A(r6)     // Catch: java.lang.Throwable -> L27
            goto L64
        L27:
            r4 = move-exception
            goto L6a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            k3.b.A(r6)
            K2.i r6 = r0.f1052g
            T2.h.b(r6)
            b3.r r1 = b3.r.f3295g
            K2.g r6 = r6.e(r1)
            if (r6 != r4) goto L6e
            r0.f3536i = r5     // Catch: java.lang.Throwable -> L27
            r0.k = r2     // Catch: java.lang.Throwable -> L27
            b3.g r6 = new b3.g     // Catch: java.lang.Throwable -> L27
            K2.d r0 = k3.b.r(r0)     // Catch: java.lang.Throwable -> L27
            r6.<init>(r2, r0)     // Catch: java.lang.Throwable -> L27
            r6.s()     // Catch: java.lang.Throwable -> L27
            d3.p r0 = new d3.p     // Catch: java.lang.Throwable -> L27
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L27
            d3.q r4 = (d3.q) r4     // Catch: java.lang.Throwable -> L27
            r4.U(r0)     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r6.r()     // Catch: java.lang.Throwable -> L27
            L2.a r6 = L2.a.f1019f
            if (r4 != r6) goto L64
            return r6
        L64:
            r5.a()
            H2.i r4 = H2.i.f681a
            return r4
        L6a:
            r5.a()
            throw r4
        L6e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.j.b(d3.r, Q.a, M2.c):java.lang.Object");
    }
}
