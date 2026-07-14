package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* renamed from: androidx.fragment.app.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class AnimationAnimationListenerC0173e implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2855a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0174f f2856b;

    public AnimationAnimationListenerC0173e(c0 c0Var, ViewGroup viewGroup, C0174f c0174f) {
        this.f2855a = viewGroup;
        this.f2856b = c0174f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        T2.h.e(animation, "animation");
        ViewGroup viewGroup = this.f2855a;
        viewGroup.post(new A.j(5, viewGroup, this.f2856b));
        if (P.J(2)) {
            Log.v("FragmentManager", "Animation from operation " + ((Object) null) + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        T2.h.e(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        T2.h.e(animation, "animation");
        if (P.J(2)) {
            Log.v("FragmentManager", "Animation from operation " + ((Object) null) + " has reached onAnimationStart.");
        }
    }
}
