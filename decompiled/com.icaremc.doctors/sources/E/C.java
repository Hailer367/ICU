package E;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class C {
    public static WindowInsets a(View view, WindowInsets windowInsets) {
        int i2 = L.f183a;
        return view.dispatchApplyWindowInsets(windowInsets);
    }
}
