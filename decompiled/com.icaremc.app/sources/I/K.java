package I;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.icaremc.app.R;

/* loaded from: classes.dex */
public abstract class K {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static v0 b(View view, v0 v0Var, Rect rect) {
        WindowInsets b4 = v0Var.b();
        if (b4 != null) {
            return v0.c(view.computeSystemWindowInsets(b4, rect), view);
        }
        rect.setEmpty();
        return v0Var;
    }

    public static void c(View view, InterfaceC0066u interfaceC0066u) {
        J j4;
        if (interfaceC0066u != null) {
            j4 = new J(view, interfaceC0066u);
        } else {
            j4 = null;
        }
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, j4);
        }
        if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (j4 != null) {
            view.setOnApplyWindowInsetsListener(j4);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        }
    }
}
