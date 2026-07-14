package n1;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final i f3345a = new Object();

    public static c a(int i2, a aVar, int i3) {
        if ((i3 & 2) != 0) {
            aVar = a.f3306c;
        }
        if (i2 != -2) {
            if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 != Integer.MAX_VALUE) {
                        if (aVar == a.f3306c) {
                            return new c(i2);
                        }
                        return new n(i2, aVar);
                    }
                    return new c(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                }
                if (aVar == a.f3306c) {
                    return new c(0);
                }
                return new n(1, aVar);
            }
            if (aVar == a.f3306c) {
                return new n(1, a.f3307d);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (aVar == a.f3306c) {
            g.f3343b.getClass();
            return new c(f.f3342b);
        }
        return new n(1, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(n1.r r4, c1.a r5, V0.c r6) {
        /*
            boolean r0 = r6 instanceof n1.o
            if (r0 == 0) goto L13
            r0 = r6
            n1.o r0 = (n1.o) r0
            int r1 = r0.f3351e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3351e = r1
            goto L18
        L13:
            n1.o r0 = new n1.o
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f3350d
            U0.a r1 = U0.a.f780c
            int r2 = r0.f3351e
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlin.jvm.internal.i r4 = r0.f3349c
            r5 = r4
            c1.a r5 = (c1.a) r5
            a.AbstractC0051a.V(r6)     // Catch: java.lang.Throwable -> L2c
            goto L69
        L2c:
            r4 = move-exception
            goto L6f
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            a.AbstractC0051a.V(r6)
            T0.i r6 = r0.getContext()
            l1.t r2 = l1.C0241t.f3012d
            T0.g r6 = r6.k(r2)
            if (r6 != r4) goto L73
            r6 = r5
            kotlin.jvm.internal.i r6 = (kotlin.jvm.internal.i) r6     // Catch: java.lang.Throwable -> L2c
            r0.f3349c = r6     // Catch: java.lang.Throwable -> L2c
            r0.f3351e = r3     // Catch: java.lang.Throwable -> L2c
            l1.h r6 = new l1.h     // Catch: java.lang.Throwable -> L2c
            T0.d r0 = android.support.v4.media.session.a.v(r0)     // Catch: java.lang.Throwable -> L2c
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L2c
            r6.r()     // Catch: java.lang.Throwable -> L2c
            n1.p r0 = new n1.p     // Catch: java.lang.Throwable -> L2c
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L2c
            n1.q r4 = (n1.q) r4     // Catch: java.lang.Throwable -> L2c
            r4.U(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r4 = r6.q()     // Catch: java.lang.Throwable -> L2c
            if (r4 != r1) goto L69
            return r1
        L69:
            r5.invoke()
            Q0.j r4 = Q0.j.f722a
            return r4
        L6f:
            r5.invoke()
            throw r4
        L73:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.j.b(n1.r, c1.a, V0.c):java.lang.Object");
    }
}
