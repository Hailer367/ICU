package E;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class d0 extends c0 {

    /* renamed from: w, reason: collision with root package name */
    public static final k0 f222w;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f222w = k0.a(null, windowInsets);
    }

    public d0(k0 k0Var, WindowInsets windowInsets) {
        super(k0Var, windowInsets);
    }

    @Override // E.b0, E.W
    public x.b B(int i2) {
        Insets insets;
        insets = this.f195c.getInsets(j0.a(i2));
        return x.b.b(insets);
    }

    @Override // E.b0, E.W
    public x.b E(int i2) {
        Insets insetsIgnoringVisibility;
        insetsIgnoringVisibility = this.f195c.getInsetsIgnoringVisibility(j0.a(i2));
        return x.b.b(insetsIgnoringVisibility);
    }

    @Override // E.b0, E.W, E.g0
    public boolean q(int i2) {
        boolean isVisible;
        isVisible = this.f195c.isVisible(j0.a(i2));
        return isVisible;
    }

    @Override // E.W, E.g0
    public void m(View view) {
    }
}
