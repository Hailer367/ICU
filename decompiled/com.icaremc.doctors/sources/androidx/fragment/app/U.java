package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class U implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o0 f1570c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ V f1571d;

    public U(V v2, o0 o0Var) {
        this.f1571d = v2;
        this.f1570c = o0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        o0 o0Var = this.f1570c;
        H h2 = o0Var.f1711c;
        o0Var.k();
        C0121p.j((ViewGroup) h2.mView.getParent(), this.f1571d.f1572c).i();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
