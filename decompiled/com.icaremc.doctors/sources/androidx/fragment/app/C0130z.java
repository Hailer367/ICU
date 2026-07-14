package androidx.fragment.app;

import android.os.Bundle;

/* renamed from: androidx.fragment.app.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0130z extends F {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ H f1776a;

    public C0130z(H h2) {
        this.f1776a = h2;
    }

    @Override // androidx.fragment.app.F
    public final void a() {
        Bundle bundle;
        H h2 = this.f1776a;
        h2.mSavedStateRegistryController.a();
        androidx.lifecycle.S.d(h2);
        Bundle bundle2 = h2.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("registryState");
        } else {
            bundle = null;
        }
        h2.mSavedStateRegistryController.b(bundle);
    }
}
