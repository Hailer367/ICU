package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class g extends Animation {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3180f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3181g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ m f3182h;

    public g(m mVar, int i4, int i5) {
        this.f3182h = mVar;
        this.f3180f = i4;
        this.f3181g = i5;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f4, Transformation transformation) {
        this.f3182h.mProgress.setAlpha((int) (((this.f3181g - r0) * f4) + this.f3180f));
    }
}
