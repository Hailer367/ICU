package b3;

/* loaded from: classes.dex */
public final class g0 extends g3.q {

    /* renamed from: j, reason: collision with root package name */
    public final ThreadLocal f3278j;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g0(K2.i r3, M2.h r4) {
        /*
            r2 = this;
            b3.h0 r0 = b3.h0.f3280f
            K2.g r1 = r3.e(r0)
            if (r1 != 0) goto Ld
            K2.i r0 = r3.j(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r4, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f3278j = r0
            K2.i r4 = r4.f1052g
            T2.h.b(r4)
            K2.e r0 = K2.e.f941f
            K2.g r4 = r4.e(r0)
            boolean r4 = r4 instanceof b3.AbstractC0242q
            if (r4 != 0) goto L32
            r4 = 0
            java.lang.Object r4 = g3.a.l(r3, r4)
            g3.a.g(r3, r4)
            r2.V(r3, r4)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.g0.<init>(K2.i, M2.h):void");
    }

    public final boolean U() {
        boolean z;
        if (this.threadLocalIsSet && this.f3278j.get() == null) {
            z = true;
        } else {
            z = false;
        }
        this.f3278j.remove();
        return !z;
    }

    public final void V(K2.i iVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f3278j.set(new H2.d(iVar, obj));
    }

    @Override // g3.q, b3.W
    public final void n(Object obj) {
        if (this.threadLocalIsSet) {
            H2.d dVar = (H2.d) this.f3278j.get();
            if (dVar != null) {
                g3.a.g((K2.i) dVar.f673f, dVar.f674g);
            }
            this.f3278j.remove();
        }
        Object g4 = AbstractC0245u.g(obj);
        K2.d dVar2 = this.f3805i;
        K2.i context = dVar2.getContext();
        g0 g0Var = null;
        Object l3 = g3.a.l(context, null);
        if (l3 != g3.a.f3773d) {
            g0Var = AbstractC0245u.l(dVar2, context, l3);
        }
        try {
            this.f3805i.resumeWith(g4);
            if (g0Var != null && !g0Var.U()) {
                return;
            }
            g3.a.g(context, l3);
        } catch (Throwable th) {
            if (g0Var == null || g0Var.U()) {
                g3.a.g(context, l3);
            }
            throw th;
        }
    }
}
