package a0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: a0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0063e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f950a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f951b = false;

    /* renamed from: c, reason: collision with root package name */
    public final Object f952c;

    public C0063e(View view) {
        this.f952c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f950a) {
            case 0:
                this.f951b = true;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f950a) {
            case 0:
                C0065g c0065g = (C0065g) this.f952c;
                if (this.f951b) {
                    this.f951b = false;
                    return;
                } else if (((Float) c0065g.f973u.getAnimatedValue()).floatValue() == 0.0f) {
                    c0065g.f974v = 0;
                    c0065g.e(0);
                    return;
                } else {
                    c0065g.f974v = 2;
                    c0065g.f968n.invalidate();
                    return;
                }
            default:
                View view = (View) this.f952c;
                e0.A.f2157a.P(view, 1.0f);
                if (this.f951b) {
                    view.setLayerType(0, null);
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f950a) {
            case 1:
                View view = (View) this.f952c;
                Field field = E.J.f180a;
                if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                    this.f951b = true;
                    view.setLayerType(2, null);
                    return;
                }
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public C0063e(C0065g c0065g) {
        this.f952c = c0065g;
    }
}
