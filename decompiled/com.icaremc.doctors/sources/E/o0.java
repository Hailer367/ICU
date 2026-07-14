package E;

import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class o0 extends n0 {
    @Override // E.n0, a.AbstractC0051a
    public final void M(boolean z) {
        int i2;
        WindowInsetsController windowInsetsController = this.f244f;
        if (z) {
            i2 = 16;
        } else {
            i2 = 0;
        }
        windowInsetsController.setSystemBarsAppearance(i2, 16);
    }

    @Override // E.n0, a.AbstractC0051a
    public final void N(boolean z) {
        int i2;
        WindowInsetsController windowInsetsController = this.f244f;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        windowInsetsController.setSystemBarsAppearance(i2, 8);
    }
}
