package I;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class b0 extends h0 {

    /* renamed from: e, reason: collision with root package name */
    public final WindowInsets.Builder f723e;

    public b0() {
        this.f723e = B.d.h();
    }

    @Override // I.h0
    public v0 b() {
        WindowInsets build;
        a();
        build = this.f723e.build();
        v0 c4 = v0.c(build, null);
        B.c[] cVarArr = this.f740b;
        r0 r0Var = c4.f788a;
        r0Var.u(cVarArr);
        r0Var.t(null);
        r0Var.y(this.f741c);
        r0Var.z(this.f742d);
        return c4;
    }

    @Override // I.h0
    public void e(B.c cVar) {
        this.f723e.setMandatorySystemGestureInsets(cVar.d());
    }

    @Override // I.h0
    public void f(B.c cVar) {
        this.f723e.setStableInsets(cVar.d());
    }

    @Override // I.h0
    public void g(B.c cVar) {
        this.f723e.setSystemGestureInsets(cVar.d());
    }

    @Override // I.h0
    public void h(B.c cVar) {
        this.f723e.setSystemWindowInsets(cVar.d());
    }

    @Override // I.h0
    public void i(B.c cVar) {
        this.f723e.setTappableElementInsets(cVar.d());
    }

    public b0(v0 v0Var) {
        super(v0Var);
        WindowInsets.Builder h3;
        WindowInsets b4 = v0Var.b();
        if (b4 != null) {
            h3 = B.d.i(b4);
        } else {
            h3 = B.d.h();
        }
        this.f723e = h3;
    }
}
