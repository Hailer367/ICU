package androidx.fragment.app;

import android.view.ViewGroup;

/* renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0174f extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public final C0175g f2857b;

    public C0174f(C0175g c0175g) {
        this.f2857b = c0175g;
    }

    @Override // androidx.fragment.app.b0
    public final void a(ViewGroup viewGroup) {
        T2.h.e(viewGroup, "container");
        if (this.f2857b.o()) {
            throw null;
        }
        viewGroup.getContext();
        throw null;
    }
}
