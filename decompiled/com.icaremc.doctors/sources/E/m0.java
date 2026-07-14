package E;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class m0 extends l0 {
    @Override // a.AbstractC0051a
    public final void M(boolean z) {
        Window window = this.f238f;
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
