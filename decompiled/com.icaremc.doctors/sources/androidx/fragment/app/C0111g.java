package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.fragment.app.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0111g extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1611a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1612b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f1613c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ E0 f1614d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0113h f1615e;

    public C0111g(ViewGroup viewGroup, View view, boolean z, E0 e02, C0113h c0113h) {
        this.f1611a = viewGroup;
        this.f1612b = view;
        this.f1613c = z;
        this.f1614d = e02;
        this.f1615e = c0113h;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator anim) {
        kotlin.jvm.internal.h.e(anim, "anim");
        ViewGroup viewGroup = this.f1611a;
        View viewToAnimate = this.f1612b;
        viewGroup.endViewTransition(viewToAnimate);
        boolean z = this.f1613c;
        E0 e02 = this.f1614d;
        if (z) {
            int i2 = e02.f1534a;
            kotlin.jvm.internal.h.d(viewToAnimate, "viewToAnimate");
            O.a.a(i2, viewToAnimate, viewGroup);
        }
        C0113h c0113h = this.f1615e;
        c0113h.f1617c.f1665a.c(c0113h);
        if (h0.K(2)) {
            Log.v("FragmentManager", "Animator from operation " + e02 + " has ended.");
        }
    }
}
