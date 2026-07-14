package I;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public class y0 extends k3.b {

    /* renamed from: m, reason: collision with root package name */
    public final WindowInsetsController f797m;

    /* renamed from: n, reason: collision with root package name */
    public final Window f798n;

    public y0(Window window) {
        WindowInsetsController insetsController;
        insetsController = window.getInsetsController();
        this.f797m = insetsController;
        this.f798n = window;
    }

    public final void D(int i4, int i5, boolean z) {
        Window window = this.f798n;
        if (window != null) {
            if (z) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(i4 | decorView.getSystemUiVisibility());
                return;
            } else {
                View decorView2 = window.getDecorView();
                decorView2.setSystemUiVisibility((~i4) & decorView2.getSystemUiVisibility());
                return;
            }
        }
        if (z) {
            this.f797m.setSystemBarsAppearance(i5, i5);
        } else {
            this.f797m.setSystemBarsAppearance(0, i5);
        }
    }

    @Override // k3.b
    public void w(boolean z) {
        D(16, 16, z);
    }

    @Override // k3.b
    public void x(boolean z) {
        D(8192, 8, z);
    }
}
