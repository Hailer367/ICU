package I;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class j0 extends i0 {

    /* renamed from: r, reason: collision with root package name */
    public B.c f761r;

    public j0(v0 v0Var, WindowInsets windowInsets) {
        super(v0Var, windowInsets);
        this.f761r = null;
    }

    @Override // I.r0
    public v0 b() {
        return v0.c(this.f751c.consumeStableInsets(), null);
    }

    @Override // I.r0
    public v0 c() {
        return v0.c(this.f751c.consumeSystemWindowInsets(), null);
    }

    @Override // I.r0
    public final B.c j() {
        if (this.f761r == null) {
            WindowInsets windowInsets = this.f751c;
            this.f761r = B.c.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f761r;
    }

    @Override // I.r0
    public boolean q() {
        return this.f751c.isConsumed();
    }

    @Override // I.r0
    public void w(B.c cVar) {
        this.f761r = cVar;
    }
}
