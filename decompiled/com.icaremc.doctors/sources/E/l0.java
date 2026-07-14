package E;

import a.AbstractC0051a;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public class l0 extends AbstractC0051a {

    /* renamed from: f, reason: collision with root package name */
    public final Window f238f;

    public l0(Window window) {
        this.f238f = window;
    }

    @Override // a.AbstractC0051a
    public final void N(boolean z) {
        Window window = this.f238f;
        if (z) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            return;
        }
        View decorView2 = window.getDecorView();
        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
    }
}
