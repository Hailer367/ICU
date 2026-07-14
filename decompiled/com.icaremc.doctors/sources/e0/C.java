package e0;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public final class C extends B {
    @Override // a.AbstractC0051a
    public final float C(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // a.AbstractC0051a
    public final void P(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // e0.B, a.AbstractC0051a
    public final void Q(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    @Override // e0.B
    public final void X(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // e0.B
    public final void Y(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // e0.B
    public final void Z(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
