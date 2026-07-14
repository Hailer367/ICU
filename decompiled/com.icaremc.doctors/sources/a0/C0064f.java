package a0;

import android.animation.ValueAnimator;

/* renamed from: a0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0064f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0065g f953a;

    public C0064f(C0065g c0065g) {
        this.f953a = c0065g;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        C0065g c0065g = this.f953a;
        c0065g.f956b.setAlpha(floatValue);
        c0065g.f957c.setAlpha(floatValue);
        c0065g.f968n.invalidate();
    }
}
