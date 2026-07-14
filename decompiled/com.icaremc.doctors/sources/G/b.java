package G;

import android.view.inputmethod.EditorInfo;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
public abstract class b {
    public static void a(NestedScrollView nestedScrollView, float f2) {
        try {
            nestedScrollView.setFrameContentVelocity(f2);
        } catch (LinkageError unused) {
        }
    }

    public static void b(EditorInfo editorInfo) {
        editorInfo.setStylusHandwritingEnabled(true);
    }
}
