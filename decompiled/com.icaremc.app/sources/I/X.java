package I;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;

/* loaded from: classes.dex */
public final class X extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f710a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f711b;

    public X(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f711b = actionBarOverlayLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f710a) {
            case 0:
                ((Z) this.f711b).b();
                return;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f711b;
                actionBarOverlayLayout.f2320B = null;
                actionBarOverlayLayout.f2334p = false;
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f710a) {
            case 0:
                ((Z) this.f711b).a();
                return;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f711b;
                actionBarOverlayLayout.f2320B = null;
                actionBarOverlayLayout.f2334p = false;
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f710a) {
            case 0:
                ((Z) this.f711b).c();
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public X(Z z, View view) {
        this.f711b = z;
    }
}
