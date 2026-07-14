package androidx.fragment.app;

import android.transition.Transition;

/* renamed from: androidx.fragment.app.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0120o extends AbstractC0116k {

    /* renamed from: b, reason: collision with root package name */
    public final Object f1706b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1707c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1708d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0120o(E0 e02, boolean z, boolean z2) {
        super(e02);
        Object exitTransition;
        boolean z3;
        Object obj;
        H h2 = e02.f1536c;
        if (e02.f1534a == 2) {
            if (z) {
                exitTransition = h2.getReenterTransition();
            } else {
                exitTransition = h2.getEnterTransition();
            }
        } else if (z) {
            exitTransition = h2.getReturnTransition();
        } else {
            exitTransition = h2.getExitTransition();
        }
        this.f1706b = exitTransition;
        if (e02.f1534a == 2) {
            if (z) {
                z3 = h2.getAllowReturnTransitionOverlap();
            } else {
                z3 = h2.getAllowEnterTransitionOverlap();
            }
        } else {
            z3 = true;
        }
        this.f1707c = z3;
        if (z2) {
            if (z) {
                obj = h2.getSharedElementReturnTransition();
            } else {
                obj = h2.getSharedElementEnterTransition();
            }
        } else {
            obj = null;
        }
        this.f1708d = obj;
    }

    public final z0 b() {
        Object obj = this.f1706b;
        z0 c2 = c(obj);
        Object obj2 = this.f1708d;
        z0 c3 = c(obj2);
        if (c2 != null && c3 != null && c2 != c3) {
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.f1665a.f1536c + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
        }
        if (c2 == null) {
            return c3;
        }
        return c2;
    }

    public final z0 c(Object obj) {
        if (obj == null) {
            return null;
        }
        x0 x0Var = s0.f1751a;
        if (obj instanceof Transition) {
            return x0Var;
        }
        z0 z0Var = s0.f1752b;
        if (z0Var != null && z0Var.e(obj)) {
            return z0Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f1665a.f1536c + " is not a valid framework Transition or AndroidX Transition");
    }
}
