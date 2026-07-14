package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* renamed from: androidx.fragment.app.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0107e extends D0 {

    /* renamed from: c, reason: collision with root package name */
    public final C0109f f1605c;

    public C0107e(C0109f c0109f) {
        this.f1605c = c0109f;
    }

    @Override // androidx.fragment.app.D0
    public final void b(ViewGroup container) {
        kotlin.jvm.internal.h.e(container, "container");
        C0109f c0109f = this.f1605c;
        E0 e02 = c0109f.f1665a;
        View view = e02.f1536c.mView;
        view.clearAnimation();
        container.endViewTransition(view);
        c0109f.f1665a.c(this);
        if (h0.K(2)) {
            Log.v("FragmentManager", "Animation from operation " + e02 + " has been cancelled.");
        }
    }

    @Override // androidx.fragment.app.D0
    public final void c(ViewGroup container) {
        kotlin.jvm.internal.h.e(container, "container");
        C0109f c0109f = this.f1605c;
        E0 e02 = c0109f.f1665a;
        if (c0109f.a()) {
            e02.c(this);
            return;
        }
        Context context = container.getContext();
        View view = e02.f1536c.mView;
        kotlin.jvm.internal.h.d(context, "context");
        N b2 = c0109f.b(context);
        if (b2 != null) {
            Animation animation = (Animation) b2.f1554a;
            if (animation != null) {
                if (e02.f1534a != 1) {
                    view.startAnimation(animation);
                    e02.c(this);
                    return;
                }
                container.startViewTransition(view);
                O o2 = new O(animation, container, view);
                o2.setAnimationListener(new AnimationAnimationListenerC0105d(e02, container, view, this));
                view.startAnimation(o2);
                if (h0.K(2)) {
                    Log.v("FragmentManager", "Animation from operation " + e02 + " has started.");
                    return;
                }
                return;
            }
            throw new IllegalStateException("Required value was null.");
        }
        throw new IllegalStateException("Required value was null.");
    }
}
