package b3;

import java.util.concurrent.CancellationException;

/* renamed from: b3.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0250z extends i3.i {

    /* renamed from: h, reason: collision with root package name */
    public int f3312h;

    public AbstractC0250z(int i4) {
        super(0L, false);
        this.f3312h = i4;
    }

    public abstract K2.d c();

    public Throwable e(Object obj) {
        C0240o c0240o;
        if (obj instanceof C0240o) {
            c0240o = (C0240o) obj;
        } else {
            c0240o = null;
        }
        if (c0240o == null) {
            return null;
        }
        return c0240o.f3290a;
    }

    public final void g(Throwable th) {
        AbstractC0245u.d(c().getContext(), new Error("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        r4 = (b3.N) r5.e(b3.r.f3295g);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            K2.d r0 = r11.c()     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            T2.h.c(r0, r1)     // Catch: java.lang.Throwable -> L21
            g3.f r0 = (g3.f) r0     // Catch: java.lang.Throwable -> L21
            M2.c r1 = r0.f3784j     // Catch: java.lang.Throwable -> L21
            java.lang.Object r0 = r0.f3785l     // Catch: java.lang.Throwable -> L21
            K2.i r2 = r1.getContext()     // Catch: java.lang.Throwable -> L21
            java.lang.Object r0 = g3.a.l(r2, r0)     // Catch: java.lang.Throwable -> L21
            R1.c r3 = g3.a.f3773d     // Catch: java.lang.Throwable -> L21
            r4 = 0
            if (r0 == r3) goto L24
            b3.g0 r3 = b3.AbstractC0245u.l(r1, r2, r0)     // Catch: java.lang.Throwable -> L21
            goto L25
        L21:
            r0 = move-exception
            goto L8e
        L24:
            r3 = r4
        L25:
            K2.i r5 = r1.getContext()     // Catch: java.lang.Throwable -> L48
            java.lang.Object r6 = r11.i()     // Catch: java.lang.Throwable -> L48
            java.lang.Throwable r7 = r11.e(r6)     // Catch: java.lang.Throwable -> L48
            if (r7 != 0) goto L4a
            int r8 = r11.f3312h     // Catch: java.lang.Throwable -> L48
            r9 = 1
            if (r8 == r9) goto L3d
            r10 = 2
            if (r8 != r10) goto L3c
            goto L3d
        L3c:
            r9 = 0
        L3d:
            if (r9 == 0) goto L4a
            b3.r r4 = b3.r.f3295g     // Catch: java.lang.Throwable -> L48
            K2.g r4 = r5.e(r4)     // Catch: java.lang.Throwable -> L48
            b3.N r4 = (b3.N) r4     // Catch: java.lang.Throwable -> L48
            goto L4a
        L48:
            r1 = move-exception
            goto L82
        L4a:
            if (r4 == 0) goto L63
            boolean r5 = r4.a()     // Catch: java.lang.Throwable -> L48
            if (r5 != 0) goto L63
            b3.W r4 = (b3.W) r4     // Catch: java.lang.Throwable -> L48
            java.util.concurrent.CancellationException r4 = r4.w()     // Catch: java.lang.Throwable -> L48
            r11.b(r4)     // Catch: java.lang.Throwable -> L48
            H2.e r4 = k3.b.f(r4)     // Catch: java.lang.Throwable -> L48
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L48
            goto L74
        L63:
            if (r7 == 0) goto L6d
            H2.e r4 = k3.b.f(r7)     // Catch: java.lang.Throwable -> L48
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L48
            goto L74
        L6d:
            java.lang.Object r4 = r11.f(r6)     // Catch: java.lang.Throwable -> L48
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L48
        L74:
            if (r3 == 0) goto L7e
            boolean r1 = r3.U()     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L7d
            goto L7e
        L7d:
            return
        L7e:
            g3.a.g(r2, r0)     // Catch: java.lang.Throwable -> L21
            return
        L82:
            if (r3 == 0) goto L8a
            boolean r3 = r3.U()     // Catch: java.lang.Throwable -> L21
            if (r3 == 0) goto L8d
        L8a:
            g3.a.g(r2, r0)     // Catch: java.lang.Throwable -> L21
        L8d:
            throw r1     // Catch: java.lang.Throwable -> L21
        L8e:
            r11.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.AbstractC0250z.run():void");
    }

    public void b(CancellationException cancellationException) {
    }

    public Object f(Object obj) {
        return obj;
    }
}
