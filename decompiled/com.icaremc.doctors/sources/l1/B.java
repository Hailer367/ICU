package l1;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class B extends s1.i {

    /* renamed from: e, reason: collision with root package name */
    public int f2949e;

    public B(int i2) {
        super(0L, false);
        this.f2949e = i2;
    }

    public abstract T0.d c();

    public Throwable d(Object obj) {
        C0238p c0238p;
        if (obj instanceof C0238p) {
            c0238p = (C0238p) obj;
        } else {
            c0238p = null;
        }
        if (c0238p == null) {
            return null;
        }
        return c0238p.f3007a;
    }

    public final void g(Throwable th) {
        AbstractC0244w.d(c().getContext(), new Error("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object h();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        r4 = (l1.O) r5.k(l1.C0241t.f3012d);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            T0.d r0 = r11.c()     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.h.c(r0, r1)     // Catch: java.lang.Throwable -> L21
            q1.f r0 = (q1.f) r0     // Catch: java.lang.Throwable -> L21
            V0.c r1 = r0.f3517g     // Catch: java.lang.Throwable -> L21
            java.lang.Object r0 = r0.f3519i     // Catch: java.lang.Throwable -> L21
            T0.i r2 = r1.getContext()     // Catch: java.lang.Throwable -> L21
            java.lang.Object r0 = q1.a.l(r2, r0)     // Catch: java.lang.Throwable -> L21
            F.h r3 = q1.a.f3506d     // Catch: java.lang.Throwable -> L21
            r4 = 0
            if (r0 == r3) goto L24
            l1.h0 r3 = l1.AbstractC0244w.l(r1, r2, r0)     // Catch: java.lang.Throwable -> L21
            goto L25
        L21:
            r0 = move-exception
            goto L8e
        L24:
            r3 = r4
        L25:
            T0.i r5 = r1.getContext()     // Catch: java.lang.Throwable -> L48
            java.lang.Object r6 = r11.h()     // Catch: java.lang.Throwable -> L48
            java.lang.Throwable r7 = r11.d(r6)     // Catch: java.lang.Throwable -> L48
            if (r7 != 0) goto L4a
            int r8 = r11.f2949e     // Catch: java.lang.Throwable -> L48
            r9 = 1
            if (r8 == r9) goto L3d
            r10 = 2
            if (r8 != r10) goto L3c
            goto L3d
        L3c:
            r9 = 0
        L3d:
            if (r9 == 0) goto L4a
            l1.t r4 = l1.C0241t.f3012d     // Catch: java.lang.Throwable -> L48
            T0.g r4 = r5.k(r4)     // Catch: java.lang.Throwable -> L48
            l1.O r4 = (l1.O) r4     // Catch: java.lang.Throwable -> L48
            goto L4a
        L48:
            r1 = move-exception
            goto L82
        L4a:
            if (r4 == 0) goto L63
            boolean r5 = r4.a()     // Catch: java.lang.Throwable -> L48
            if (r5 != 0) goto L63
            l1.X r4 = (l1.X) r4     // Catch: java.lang.Throwable -> L48
            java.util.concurrent.CancellationException r4 = r4.v()     // Catch: java.lang.Throwable -> L48
            r11.b(r4)     // Catch: java.lang.Throwable -> L48
            Q0.f r4 = a.AbstractC0051a.j(r4)     // Catch: java.lang.Throwable -> L48
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L48
            goto L74
        L63:
            if (r7 == 0) goto L6d
            Q0.f r4 = a.AbstractC0051a.j(r7)     // Catch: java.lang.Throwable -> L48
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L48
            goto L74
        L6d:
            java.lang.Object r4 = r11.e(r6)     // Catch: java.lang.Throwable -> L48
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L48
        L74:
            if (r3 == 0) goto L7e
            boolean r1 = r3.T()     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L7d
            goto L7e
        L7d:
            return
        L7e:
            q1.a.g(r2, r0)     // Catch: java.lang.Throwable -> L21
            return
        L82:
            if (r3 == 0) goto L8a
            boolean r3 = r3.T()     // Catch: java.lang.Throwable -> L21
            if (r3 == 0) goto L8d
        L8a:
            q1.a.g(r2, r0)     // Catch: java.lang.Throwable -> L21
        L8d:
            throw r1     // Catch: java.lang.Throwable -> L21
        L8e:
            r11.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.B.run():void");
    }

    public void b(CancellationException cancellationException) {
    }

    public Object e(Object obj) {
        return obj;
    }
}
