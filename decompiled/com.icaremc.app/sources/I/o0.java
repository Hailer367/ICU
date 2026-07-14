package I;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class o0 extends n0 {

    /* renamed from: w, reason: collision with root package name */
    public static final v0 f777w;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f777w = v0.c(windowInsets, null);
    }

    public o0(v0 v0Var, WindowInsets windowInsets) {
        super(v0Var, windowInsets);
    }

    @Override // I.m0, I.i0
    public B.c F(int i4) {
        Insets insetsIgnoringVisibility;
        insetsIgnoringVisibility = this.f751c.getInsetsIgnoringVisibility(u0.a(i4));
        return B.c.c(insetsIgnoringVisibility);
    }

    @Override // I.m0, I.i0, I.r0
    public B.c h(int i4) {
        Insets insets;
        insets = this.f751c.getInsets(u0.a(i4));
        return B.c.c(insets);
    }

    @Override // I.m0, I.i0, I.r0
    public boolean s(int i4) {
        boolean isVisible;
        isVisible = this.f751c.isVisible(u0.a(i4));
        return isVisible;
    }

    @Override // I.i0, I.r0
    public void n(View view) {
    }
}
