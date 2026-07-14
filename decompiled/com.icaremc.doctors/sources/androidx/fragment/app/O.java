package androidx.fragment.app;

import E.ViewTreeObserverOnPreDrawListenerC0020u;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class O extends AnimationSet implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f1556c;

    /* renamed from: d, reason: collision with root package name */
    public final View f1557d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1558e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1559f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1560g;

    public O(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f1560g = true;
        this.f1556c = viewGroup;
        this.f1557d = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j2, Transformation transformation) {
        this.f1560g = true;
        if (this.f1558e) {
            return !this.f1559f;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f1558e = true;
            ViewTreeObserverOnPreDrawListenerC0020u.a(this.f1556c, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.f1558e;
        ViewGroup viewGroup = this.f1556c;
        if (!z && this.f1560g) {
            this.f1560g = false;
            viewGroup.post(this);
        } else {
            viewGroup.endViewTransition(this.f1557d);
            this.f1559f = true;
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j2, Transformation transformation, float f2) {
        this.f1560g = true;
        if (this.f1558e) {
            return !this.f1559f;
        }
        if (!super.getTransformation(j2, transformation, f2)) {
            this.f1558e = true;
            ViewTreeObserverOnPreDrawListenerC0020u.a(this.f1556c, this);
        }
        return true;
    }
}
