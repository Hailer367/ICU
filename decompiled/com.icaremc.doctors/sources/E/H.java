package E;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class H {
    public static WindowInsets a(View view, WindowInsets windowInsets) {
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    public static CharSequence b(View view) {
        return view.getStateDescription();
    }
}
