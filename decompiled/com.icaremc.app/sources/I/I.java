package I;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class I {
    public static WindowInsets a(View view, WindowInsets windowInsets) {
        int i4 = V.f708a;
        return view.dispatchApplyWindowInsets(windowInsets);
    }
}
