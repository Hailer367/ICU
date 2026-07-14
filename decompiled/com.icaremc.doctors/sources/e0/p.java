package e0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionBarOverlayLayout;

/* loaded from: classes.dex */
public final class p extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2208a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2209b;

    public /* synthetic */ p(int i2, Object obj) {
        this.f2208a = i2;
        this.f2209b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f2208a) {
            case 1:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f2209b;
                actionBarOverlayLayout.f1122v = null;
                actionBarOverlayLayout.f1114l = false;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2208a) {
            case 0:
                ((s) this.f2209b).n();
                animator.removeListener(this);
                return;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f2209b;
                actionBarOverlayLayout.f1122v = null;
                actionBarOverlayLayout.f1114l = false;
                return;
        }
    }
}
