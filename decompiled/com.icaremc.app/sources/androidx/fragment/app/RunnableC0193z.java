package androidx.fragment.app;

import I.ViewTreeObserverOnPreDrawListenerC0068w;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* renamed from: androidx.fragment.app.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0193z extends AnimationSet implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final ViewGroup f2953f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2954g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2955h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2956i;

    public RunnableC0193z(Animation animation, ViewGroup viewGroup) {
        super(false);
        this.f2956i = true;
        this.f2953f = viewGroup;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation) {
        this.f2956i = true;
        if (this.f2954g) {
            return !this.f2955h;
        }
        if (!super.getTransformation(j4, transformation)) {
            this.f2954g = true;
            ViewTreeObserverOnPreDrawListenerC0068w.a(this.f2953f, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.f2954g;
        ViewGroup viewGroup = this.f2953f;
        if (!z && this.f2956i) {
            this.f2956i = false;
            viewGroup.post(this);
        } else {
            viewGroup.endViewTransition(null);
            this.f2955h = true;
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation, float f4) {
        this.f2956i = true;
        if (this.f2954g) {
            return !this.f2955h;
        }
        if (!super.getTransformation(j4, transformation, f4)) {
            this.f2954g = true;
            ViewTreeObserverOnPreDrawListenerC0068w.a(this.f2953f, this);
        }
        return true;
    }
}
