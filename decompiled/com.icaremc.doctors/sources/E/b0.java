package E;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class b0 extends Z {

    /* renamed from: v, reason: collision with root package name */
    public static final k0 f213v;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f213v = k0.a(null, windowInsets);
    }

    public b0(k0 k0Var, WindowInsets windowInsets) {
        super(k0Var, windowInsets);
    }

    @Override // E.W
    public x.b B(int i2) {
        Insets insets;
        insets = this.f195c.getInsets(h0.a(i2));
        return x.b.b(insets);
    }

    @Override // E.W
    public x.b E(int i2) {
        Insets insetsIgnoringVisibility;
        insetsIgnoringVisibility = this.f195c.getInsetsIgnoringVisibility(h0.a(i2));
        return x.b.b(insetsIgnoringVisibility);
    }

    @Override // E.W, E.g0
    public boolean q(int i2) {
        boolean isVisible;
        isVisible = this.f195c.isVisible(h0.a(i2));
        return isVisible;
    }

    @Override // E.W, E.g0
    public final void d(View view) {
    }
}
