package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class AnimationAnimationListenerC0105d implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E0 f1599a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1600b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1601c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0107e f1602d;

    public AnimationAnimationListenerC0105d(E0 e02, ViewGroup viewGroup, View view, C0107e c0107e) {
        this.f1599a = e02;
        this.f1600b = viewGroup;
        this.f1601c = view;
        this.f1602d = c0107e;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        kotlin.jvm.internal.h.e(animation, "animation");
        ViewGroup viewGroup = this.f1600b;
        viewGroup.post(new A0.a(viewGroup, this.f1601c, this.f1602d, 1));
        if (h0.K(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f1599a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        kotlin.jvm.internal.h.e(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        kotlin.jvm.internal.h.e(animation, "animation");
        if (h0.K(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f1599a + " has reached onAnimationStart.");
        }
    }
}
