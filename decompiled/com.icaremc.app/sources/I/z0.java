package I;

import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class z0 extends y0 {
    @Override // I.y0, k3.b
    public final void w(boolean z) {
        int i4;
        WindowInsetsController windowInsetsController = this.f797m;
        if (z) {
            i4 = 16;
        } else {
            i4 = 0;
        }
        windowInsetsController.setSystemBarsAppearance(i4, 16);
    }

    @Override // I.y0, k3.b
    public final void x(boolean z) {
        int i4;
        WindowInsetsController windowInsetsController = this.f797m;
        if (z) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        windowInsetsController.setSystemBarsAppearance(i4, 8);
    }
}
