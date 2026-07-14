package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import e.C0266a;

/* renamed from: androidx.fragment.app.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0177i extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public final C0175g f2864b;

    /* renamed from: c, reason: collision with root package name */
    public AnimatorSet f2865c;

    public C0177i(C0175g c0175g) {
        this.f2864b = c0175g;
    }

    @Override // androidx.fragment.app.b0
    public final void a(ViewGroup viewGroup) {
        T2.h.e(viewGroup, "container");
        AnimatorSet animatorSet = this.f2865c;
        animatorSet.getClass();
        animatorSet.start();
        if (P.J(2)) {
            Log.v("FragmentManager", "Animator from operation " + ((Object) null) + " has started.");
        }
    }

    @Override // androidx.fragment.app.b0
    public final void b(C0266a c0266a, ViewGroup viewGroup) {
        T2.h.e(viewGroup, "container");
        this.f2865c.getClass();
        if (Build.VERSION.SDK_INT < 34) {
        } else {
            throw null;
        }
    }

    @Override // androidx.fragment.app.b0
    public final void c(ViewGroup viewGroup) {
        AnimatorSet animatorSet;
        T2.h.e(viewGroup, "container");
        C0175g c0175g = this.f2864b;
        if (c0175g.o()) {
            return;
        }
        Context context = viewGroup.getContext();
        T2.h.d(context, "context");
        E0.a C3 = c0175g.C(context);
        if (C3 != null) {
            animatorSet = (AnimatorSet) C3.f460h;
        } else {
            animatorSet = null;
        }
        this.f2865c = animatorSet;
        throw null;
    }
}
