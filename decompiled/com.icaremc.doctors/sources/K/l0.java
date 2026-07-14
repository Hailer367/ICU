package K;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final t1.c f516a = new t1.c();

    /* renamed from: b, reason: collision with root package name */
    public final F.h f517b = new F.h(2);

    /* renamed from: c, reason: collision with root package name */
    public final C0045u f518c = new C0045u((c1.p) new V0.h(2, null));

    /* JADX WARN: Type inference failed for: r3v3, types: [V0.h, c1.p] */
    public l0(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.f517b.f274d).get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        if (r9.c(r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(c1.l r8, V0.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof K.i0
            if (r0 == 0) goto L13
            r0 = r9
            K.i0 r0 = (K.i0) r0
            int r1 = r0.f494g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f494g = r1
            goto L18
        L13:
            K.i0 r0 = new K.i0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f492e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f494g
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.f490c
            t1.a r8 = (t1.a) r8
            a.AbstractC0051a.V(r9)     // Catch: java.lang.Throwable -> L2f
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
            t1.c r8 = r0.f491d
            java.lang.Object r2 = r0.f490c
            c1.l r2 = (c1.l) r2
            a.AbstractC0051a.V(r9)
            r9 = r8
            r8 = r2
            goto L57
        L45:
            a.AbstractC0051a.V(r9)
            r0.f490c = r8
            t1.c r9 = r7.f516a
            r0.f491d = r9
            r0.f494g = r4
            java.lang.Object r2 = r9.c(r0)
            if (r2 != r1) goto L57
            goto L63
        L57:
            r0.f490c = r9     // Catch: java.lang.Throwable -> L6d
            r0.f491d = r5     // Catch: java.lang.Throwable -> L6d
            r0.f494g = r3     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L6d
            if (r8 != r1) goto L64
        L63:
            return r1
        L64:
            r6 = r9
            r9 = r8
            r8 = r6
        L67:
            t1.c r8 = (t1.c) r8
            r8.e(r5)
            return r9
        L6d:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L71:
            t1.c r8 = (t1.c) r8
            r8.e(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: K.l0.b(c1.l, V0.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(c1.p r7, V0.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof K.j0
            if (r0 == 0) goto L13
            r0 = r8
            K.j0 r0 = (K.j0) r0
            int r1 = r0.f503g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f503g = r1
            goto L18
        L13:
            K.j0 r0 = new K.j0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f501e
            U0.a r1 = U0.a.f780c
            int r2 = r0.f503g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            boolean r7 = r0.f500d
            t1.c r0 = r0.f499c
            a.AbstractC0051a.V(r8)     // Catch: java.lang.Throwable -> L2c
            goto L53
        L2c:
            r8 = move-exception
            goto L5d
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            a.AbstractC0051a.V(r8)
            t1.c r8 = r6.f516a
            boolean r2 = r8.d()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L59
            r0.f499c = r8     // Catch: java.lang.Throwable -> L59
            r0.f500d = r2     // Catch: java.lang.Throwable -> L59
            r0.f503g = r3     // Catch: java.lang.Throwable -> L59
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L59
            if (r7 != r1) goto L50
            return r1
        L50:
            r0 = r8
            r8 = r7
            r7 = r2
        L53:
            if (r7 == 0) goto L58
            r0.e(r4)
        L58:
            return r8
        L59:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r2
        L5d:
            if (r7 == 0) goto L62
            r0.e(r4)
        L62:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: K.l0.c(c1.p, V0.c):java.lang.Object");
    }
}
