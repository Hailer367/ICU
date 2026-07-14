package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import d.C0172a;

/* renamed from: androidx.fragment.app.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0113h extends D0 {

    /* renamed from: c, reason: collision with root package name */
    public final C0109f f1617c;

    /* renamed from: d, reason: collision with root package name */
    public AnimatorSet f1618d;

    public C0113h(C0109f c0109f) {
        this.f1617c = c0109f;
    }

    @Override // androidx.fragment.app.D0
    public final void b(ViewGroup container) {
        String str;
        E0 e02 = this.f1617c.f1665a;
        kotlin.jvm.internal.h.e(container, "container");
        AnimatorSet animatorSet = this.f1618d;
        if (animatorSet == null) {
            e02.c(this);
            return;
        }
        if (e02.f1540g) {
            if (Build.VERSION.SDK_INT >= 26) {
                C0115j.f1656a.a(animatorSet);
            }
        } else {
            animatorSet.end();
        }
        if (h0.K(2)) {
            StringBuilder sb = new StringBuilder("Animator from operation ");
            sb.append(e02);
            sb.append(" has been canceled");
            if (e02.f1540g) {
                str = " with seeking.";
            } else {
                str = ".";
            }
            sb.append(str);
            sb.append(' ');
            Log.v("FragmentManager", sb.toString());
        }
    }

    @Override // androidx.fragment.app.D0
    public final void c(ViewGroup container) {
        kotlin.jvm.internal.h.e(container, "container");
        E0 e02 = this.f1617c.f1665a;
        AnimatorSet animatorSet = this.f1618d;
        if (animatorSet == null) {
            e02.c(this);
            return;
        }
        animatorSet.start();
        if (h0.K(2)) {
            Log.v("FragmentManager", "Animator from operation " + e02 + " has started.");
        }
    }

    @Override // androidx.fragment.app.D0
    public final void d(C0172a c0172a, ViewGroup container) {
        kotlin.jvm.internal.h.e(container, "container");
        E0 e02 = this.f1617c.f1665a;
        AnimatorSet animatorSet = this.f1618d;
        if (animatorSet == null) {
            e02.c(this);
            return;
        }
        if (Build.VERSION.SDK_INT >= 34 && e02.f1536c.mTransitioning) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + e02);
            }
            long a2 = C0114i.f1655a.a(animatorSet);
            long j2 = c0172a.f2113c * ((float) a2);
            if (j2 == 0) {
                j2 = 1;
            }
            if (j2 == a2) {
                j2 = a2 - 1;
            }
            if (h0.K(2)) {
                Log.v("FragmentManager", "Setting currentPlayTime to " + j2 + " for Animator " + animatorSet + " on operation " + e02);
            }
            C0115j.f1656a.b(animatorSet, j2);
        }
    }

    @Override // androidx.fragment.app.D0
    public final void e(ViewGroup container) {
        AnimatorSet animatorSet;
        boolean z;
        C0113h c0113h;
        kotlin.jvm.internal.h.e(container, "container");
        C0109f c0109f = this.f1617c;
        if (!c0109f.a()) {
            Context context = container.getContext();
            kotlin.jvm.internal.h.d(context, "context");
            N b2 = c0109f.b(context);
            if (b2 != null) {
                animatorSet = (AnimatorSet) b2.f1555b;
            } else {
                animatorSet = null;
            }
            this.f1618d = animatorSet;
            E0 e02 = c0109f.f1665a;
            H h2 = e02.f1536c;
            if (e02.f1534a == 3) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            View view = h2.mView;
            container.startViewTransition(view);
            AnimatorSet animatorSet2 = this.f1618d;
            if (animatorSet2 != null) {
                c0113h = this;
                animatorSet2.addListener(new C0111g(container, view, z2, e02, c0113h));
            } else {
                c0113h = this;
            }
            AnimatorSet animatorSet3 = c0113h.f1618d;
            if (animatorSet3 != null) {
                animatorSet3.setTarget(view);
            }
        }
    }
}
