package h0;

import android.animation.ValueAnimator;

/* renamed from: h0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0318f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0319g f3875a;

    public C0318f(C0319g c0319g) {
        this.f3875a = c0319g;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        C0319g c0319g = this.f3875a;
        c0319g.f3879b.setAlpha(floatValue);
        c0319g.f3880c.setAlpha(floatValue);
        c0319g.f3890n.invalidate();
    }
}
