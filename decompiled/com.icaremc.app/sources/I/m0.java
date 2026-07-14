package I;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class m0 extends l0 {

    /* renamed from: v, reason: collision with root package name */
    public static final v0 f771v;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f771v = v0.c(windowInsets, null);
    }

    public m0(v0 v0Var, WindowInsets windowInsets) {
        super(v0Var, windowInsets);
    }

    @Override // I.i0
    public B.c F(int i4) {
        Insets insetsIgnoringVisibility;
        insetsIgnoringVisibility = this.f751c.getInsetsIgnoringVisibility(s0.a(i4));
        return B.c.c(insetsIgnoringVisibility);
    }

    @Override // I.i0, I.r0
    public B.c h(int i4) {
        Insets insets;
        insets = this.f751c.getInsets(s0.a(i4));
        return B.c.c(insets);
    }

    @Override // I.i0, I.r0
    public boolean s(int i4) {
        boolean isVisible;
        isVisible = this.f751c.isVisible(s0.a(i4));
        return isVisible;
    }

    @Override // I.i0, I.r0
    public final void d(View view) {
    }
}
