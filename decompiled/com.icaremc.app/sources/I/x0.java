package I;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class x0 extends w0 {
    @Override // k3.b
    public final void w(boolean z) {
        Window window = this.f792m;
        if (z) {
            window.clearFlags(134217728);
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            return;
        }
        View decorView2 = window.getDecorView();
        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
    }
}
