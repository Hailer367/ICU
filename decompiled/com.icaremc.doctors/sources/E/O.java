package E;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class O extends V {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets.Builder f189c = N.f();

    @Override // E.V
    public k0 b() {
        WindowInsets build;
        a();
        build = this.f189c.build();
        k0 a2 = k0.a(null, build);
        g0 g0Var = a2.f234a;
        g0Var.s(null);
        g0Var.r(null);
        g0Var.w(this.f190a);
        g0Var.x(this.f191b);
        return a2;
    }
}
