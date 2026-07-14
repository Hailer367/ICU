package e0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import r.C0293e;

/* loaded from: classes.dex */
public final class o extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0293e f2206a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f2207b;

    public o(s sVar, C0293e c0293e) {
        this.f2207b = sVar;
        this.f2206a = c0293e;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2206a.remove(animator);
        this.f2207b.f2228m.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2207b.f2228m.add(animator);
    }
}
