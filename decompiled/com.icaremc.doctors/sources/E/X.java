package E;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class X extends W {

    /* renamed from: r, reason: collision with root package name */
    public x.b f205r;

    public X(k0 k0Var, WindowInsets windowInsets) {
        super(k0Var, windowInsets);
        this.f205r = null;
    }

    @Override // E.g0
    public k0 b() {
        return k0.a(null, this.f195c.consumeStableInsets());
    }

    @Override // E.g0
    public k0 c() {
        return k0.a(null, this.f195c.consumeSystemWindowInsets());
    }

    @Override // E.g0
    public final x.b i() {
        if (this.f205r == null) {
            WindowInsets windowInsets = this.f195c;
            this.f205r = x.b.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f205r;
    }

    @Override // E.g0
    public boolean o() {
        return this.f195c.isConsumed();
    }

    @Override // E.g0
    public void u(x.b bVar) {
        this.f205r = bVar;
    }
}
