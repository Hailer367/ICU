package E;

import a.AbstractC0051a;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public class n0 extends AbstractC0051a {

    /* renamed from: f, reason: collision with root package name */
    public final WindowInsetsController f244f;

    /* renamed from: g, reason: collision with root package name */
    public final Window f245g;

    public n0(Window window) {
        WindowInsetsController insetsController;
        insetsController = window.getInsetsController();
        this.f244f = insetsController;
        this.f245g = window;
    }

    @Override // a.AbstractC0051a
    public void M(boolean z) {
        X(16, z, 16);
    }

    @Override // a.AbstractC0051a
    public void N(boolean z) {
        X(8192, z, 8);
    }

    public final void X(int i2, boolean z, int i3) {
        Window window = this.f245g;
        if (window != null) {
            if (z) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
                return;
            } else {
                View decorView2 = window.getDecorView();
                decorView2.setSystemUiVisibility((~i2) & decorView2.getSystemUiVisibility());
                return;
            }
        }
        if (z) {
            this.f244f.setSystemBarsAppearance(i3, i3);
        } else {
            this.f244f.setSystemBarsAppearance(0, i3);
        }
    }
}
