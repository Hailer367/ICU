package e0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class E extends AnimatorListenerAdapter implements r {

    /* renamed from: a, reason: collision with root package name */
    public final View f2167a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2168b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f2169c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2171e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2172f = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2170d = true;

    public E(View view, int i2) {
        this.f2167a = view;
        this.f2168b = i2;
        this.f2169c = (ViewGroup) view.getParent();
        f(true);
    }

    @Override // e0.r
    public final void b(s sVar) {
        if (!this.f2172f) {
            A.f2157a.Q(this.f2167a, this.f2168b);
            ViewGroup viewGroup = this.f2169c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
        sVar.w(this);
    }

    @Override // e0.r
    public final void c() {
        f(false);
    }

    @Override // e0.r
    public final void d() {
        f(true);
    }

    public final void f(boolean z) {
        ViewGroup viewGroup;
        if (this.f2170d && this.f2171e != z && (viewGroup = this.f2169c) != null) {
            this.f2171e = z;
            android.support.v4.media.session.a.H(viewGroup, z);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2172f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f2172f) {
            A.f2157a.Q(this.f2167a, this.f2168b);
            ViewGroup viewGroup = this.f2169c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        if (!this.f2172f) {
            A.f2157a.Q(this.f2167a, this.f2168b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        if (!this.f2172f) {
            A.f2157a.Q(this.f2167a, 0);
        }
    }

    @Override // e0.r
    public final void e() {
    }

    @Override // e0.r
    public final void a(s sVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
