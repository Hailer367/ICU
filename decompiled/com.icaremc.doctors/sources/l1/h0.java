package l1;

/* loaded from: classes.dex */
public final class h0 extends q1.q {

    /* renamed from: g, reason: collision with root package name */
    public final ThreadLocal f2995g;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h0(T0.d r3, T0.i r4) {
        /*
            r2 = this;
            l1.i0 r0 = l1.i0.f2997c
            T0.g r1 = r4.k(r0)
            if (r1 != 0) goto Ld
            T0.i r0 = r4.d(r0)
            goto Le
        Ld:
            r0 = r4
        Le:
            r2.<init>(r3, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f2995g = r0
            T0.i r3 = r3.getContext()
            T0.e r0 = T0.e.f773c
            T0.g r3 = r3.k(r0)
            boolean r3 = r3 instanceof l1.AbstractC0240s
            if (r3 != 0) goto L31
            r3 = 0
            java.lang.Object r3 = q1.a.l(r4, r3)
            q1.a.g(r4, r3)
            r2.U(r4, r3)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.h0.<init>(T0.d, T0.i):void");
    }

    public final boolean T() {
        boolean z;
        if (this.threadLocalIsSet && this.f2995g.get() == null) {
            z = true;
        } else {
            z = false;
        }
        this.f2995g.remove();
        return !z;
    }

    public final void U(T0.i iVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f2995g.set(new Q0.e(iVar, obj));
    }

    @Override // q1.q, l1.X
    public final void m(Object obj) {
        if (this.threadLocalIsSet) {
            Q0.e eVar = (Q0.e) this.f2995g.get();
            if (eVar != null) {
                q1.a.g((T0.i) eVar.f714c, eVar.f715d);
            }
            this.f2995g.remove();
        }
        Object g2 = AbstractC0244w.g(obj);
        T0.d dVar = this.f3540f;
        T0.i context = dVar.getContext();
        h0 h0Var = null;
        Object l2 = q1.a.l(context, null);
        if (l2 != q1.a.f3506d) {
            h0Var = AbstractC0244w.l(dVar, context, l2);
        }
        try {
            this.f3540f.resumeWith(g2);
            if (h0Var != null && !h0Var.T()) {
                return;
            }
            q1.a.g(context, l2);
        } catch (Throwable th) {
            if (h0Var == null || h0Var.T()) {
                q1.a.g(context, l2);
            }
            throw th;
        }
    }
}
