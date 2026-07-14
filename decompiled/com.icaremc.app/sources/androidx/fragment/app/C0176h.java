package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

/* renamed from: androidx.fragment.app.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0176h extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2861a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2862b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0177i f2863c;

    public C0176h(ViewGroup viewGroup, boolean z, c0 c0Var, C0177i c0177i) {
        this.f2861a = viewGroup;
        this.f2862b = z;
        this.f2863c = c0177i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        T2.h.e(animator, "anim");
        this.f2861a.endViewTransition(null);
        if (!this.f2862b) {
            throw null;
        }
        throw null;
    }
}
