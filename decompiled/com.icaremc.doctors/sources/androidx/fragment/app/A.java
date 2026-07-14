package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
public final class A extends P {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ H f1496c;

    public A(H h2) {
        this.f1496c = h2;
    }

    @Override // androidx.fragment.app.P
    public final View b(int i2) {
        H h2 = this.f1496c;
        View view = h2.mView;
        if (view != null) {
            return view.findViewById(i2);
        }
        throw new IllegalStateException("Fragment " + h2 + " does not have a view");
    }

    @Override // androidx.fragment.app.P
    public final boolean c() {
        if (this.f1496c.mView != null) {
            return true;
        }
        return false;
    }
}
