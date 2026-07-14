package I;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public class w0 extends k3.b {

    /* renamed from: m, reason: collision with root package name */
    public final Window f792m;

    public w0(Window window) {
        this.f792m = window;
    }

    @Override // k3.b
    public final void x(boolean z) {
        Window window = this.f792m;
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
