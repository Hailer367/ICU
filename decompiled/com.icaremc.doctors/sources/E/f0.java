package E;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes.dex */
public final class f0 extends d0 {
    public f0(k0 k0Var, WindowInsets windowInsets) {
        super(k0Var, windowInsets);
    }

    @Override // E.W, E.g0
    public List<Rect> e(int i2) {
        List<Rect> boundingRects;
        boundingRects = this.f195c.getBoundingRects(j0.a(i2));
        return boundingRects;
    }

    @Override // E.W, E.g0
    public List<Rect> f(int i2) {
        List<Rect> boundingRectsIgnoringVisibility;
        boundingRectsIgnoringVisibility = this.f195c.getBoundingRectsIgnoringVisibility(j0.a(i2));
        return boundingRectsIgnoringVisibility;
    }

    @Override // E.W, E.g0
    public void n() {
    }
}
