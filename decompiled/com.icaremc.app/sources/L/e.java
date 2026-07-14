package L;

import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
public abstract class e {
    public static void a(NestedScrollView nestedScrollView, float f4) {
        try {
            nestedScrollView.setFrameContentVelocity(f4);
        } catch (LinkageError unused) {
        }
    }
}
