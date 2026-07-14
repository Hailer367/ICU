package I;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes.dex */
public final class q0 extends o0 {
    public q0(v0 v0Var, WindowInsets windowInsets) {
        super(v0Var, windowInsets);
    }

    @Override // I.i0, I.r0
    public List<Rect> e(int i4) {
        List<Rect> boundingRects;
        boundingRects = this.f751c.getBoundingRects(u0.a(i4));
        return boundingRects;
    }

    @Override // I.i0, I.r0
    public List<Rect> f(int i4) {
        List<Rect> boundingRectsIgnoringVisibility;
        boundingRectsIgnoringVisibility = this.f751c.getBoundingRectsIgnoringVisibility(u0.a(i4));
        return boundingRectsIgnoringVisibility;
    }

    @Override // I.i0, I.r0
    public void o() {
    }
}
