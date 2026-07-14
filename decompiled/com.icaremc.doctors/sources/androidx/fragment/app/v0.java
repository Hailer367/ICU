package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class v0 implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1760a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1761b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1762c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1763d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ x0 f1764e;

    public v0(x0 x0Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f1764e = x0Var;
        this.f1760a = obj;
        this.f1761b = arrayList;
        this.f1762c = obj2;
        this.f1763d = arrayList2;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        x0 x0Var = this.f1764e;
        Object obj = this.f1760a;
        if (obj != null) {
            x0Var.u(obj, this.f1761b, null);
        }
        Object obj2 = this.f1762c;
        if (obj2 != null) {
            x0Var.u(obj2, this.f1763d, null);
        }
    }
}
