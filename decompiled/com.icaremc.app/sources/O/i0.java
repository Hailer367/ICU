package O;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final j3.c f1201a = new j3.c();

    /* renamed from: b, reason: collision with root package name */
    public final R1.c f1202b = new R1.c(7);

    /* renamed from: c, reason: collision with root package name */
    public final R1.c f1203c = new R1.c((S2.p) new M2.h(2, null));

    /* JADX WARN: Type inference failed for: r3v3, types: [S2.p, M2.h] */
    public i0(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.f1202b.f1532g).get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        if (r9.c(r0) == r5) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(S2.l r8, M2.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof O.f0
            if (r0 == 0) goto L13
            r0 = r9
            O.f0 r0 = (O.f0) r0
            int r1 = r0.f1188m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1188m = r1
            goto L18
        L13:
            O.f0 r0 = new O.f0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.k
            int r1 = r0.f1188m
            r2 = 2
            r3 = 1
            r4 = 0
            L2.a r5 = L2.a.f1019f
            if (r1 == 0) goto L45
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r8 = r0.f1185i
            j3.a r8 = (j3.a) r8
            k3.b.A(r9)     // Catch: java.lang.Throwable -> L2f
            goto L67
        L2f:
            r9 = move-exception
            goto L71
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            j3.c r8 = r0.f1186j
            java.lang.Object r1 = r0.f1185i
            S2.l r1 = (S2.l) r1
            k3.b.A(r9)
            r9 = r8
            r8 = r1
            goto L57
        L45:
            k3.b.A(r9)
            r0.f1185i = r8
            j3.c r9 = r7.f1201a
            r0.f1186j = r9
            r0.f1188m = r3
            java.lang.Object r1 = r9.c(r0)
            if (r1 != r5) goto L57
            goto L63
        L57:
            r0.f1185i = r9     // Catch: java.lang.Throwable -> L6d
            r0.f1186j = r4     // Catch: java.lang.Throwable -> L6d
            r0.f1188m = r2     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r8 = r8.f(r0)     // Catch: java.lang.Throwable -> L6d
            if (r8 != r5) goto L64
        L63:
            return r5
        L64:
            r6 = r9
            r9 = r8
            r8 = r6
        L67:
            j3.c r8 = (j3.c) r8
            r8.e(r4)
            return r9
        L6d:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L71:
            j3.c r8 = (j3.c) r8
            r8.e(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: O.i0.b(S2.l, M2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(S2.p r6, M2.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof O.g0
            if (r0 == 0) goto L13
            r0 = r7
            O.g0 r0 = (O.g0) r0
            int r1 = r0.f1194m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1194m = r1
            goto L18
        L13:
            O.g0 r0 = new O.g0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.k
            int r1 = r0.f1194m
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            boolean r6 = r0.f1192j
            j3.c r0 = r0.f1191i
            k3.b.A(r7)     // Catch: java.lang.Throwable -> L2a
            goto L53
        L2a:
            r7 = move-exception
            goto L5d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            k3.b.A(r7)
            j3.c r7 = r5.f1201a
            boolean r1 = r7.d()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L59
            r0.f1191i = r7     // Catch: java.lang.Throwable -> L59
            r0.f1192j = r1     // Catch: java.lang.Throwable -> L59
            r0.f1194m = r2     // Catch: java.lang.Throwable -> L59
            java.lang.Object r6 = r6.e(r4, r0)     // Catch: java.lang.Throwable -> L59
            L2.a r0 = L2.a.f1019f
            if (r6 != r0) goto L50
            return r0
        L50:
            r0 = r7
            r7 = r6
            r6 = r1
        L53:
            if (r6 == 0) goto L58
            r0.e(r3)
        L58:
            return r7
        L59:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r1
        L5d:
            if (r6 == 0) goto L62
            r0.e(r3)
        L62:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: O.i0.c(S2.p, M2.c):java.lang.Object");
    }
}
