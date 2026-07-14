package h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: h0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0317e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3873a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0319g f3874b;

    public C0317e(C0319g c0319g) {
        this.f3874b = c0319g;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f3873a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f3873a) {
            this.f3873a = false;
            return;
        }
        C0319g c0319g = this.f3874b;
        if (((Float) c0319g.f3897u.getAnimatedValue()).floatValue() == 0.0f) {
            c0319g.f3898v = 0;
            c0319g.e(0);
        } else {
            c0319g.f3898v = 2;
            c0319g.f3890n.invalidate();
        }
    }
}
