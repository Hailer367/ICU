package androidx.fragment.app;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC0208o;
import i0.C0362e;
import i0.InterfaceC0364g;
import j.AbstractActivityC0416k;
import y.InterfaceC0728d;

/* renamed from: androidx.fragment.app.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0191x extends A implements InterfaceC0728d, androidx.lifecycle.Y, e.u, InterfaceC0364g, V {

    /* renamed from: f, reason: collision with root package name */
    public final AbstractActivityC0416k f2948f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractActivityC0416k f2949g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f2950h;

    /* renamed from: i, reason: collision with root package name */
    public final Q f2951i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0416k f2952j;

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.fragment.app.P, androidx.fragment.app.Q] */
    public C0191x(AbstractActivityC0416k abstractActivityC0416k) {
        this.f2952j = abstractActivityC0416k;
        Handler handler = new Handler();
        this.f2948f = abstractActivityC0416k;
        this.f2949g = abstractActivityC0416k;
        this.f2950h = handler;
        this.f2951i = new P();
    }

    @Override // androidx.fragment.app.V
    public final void a(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        this.f2952j.onAttachFragment(abstractComponentCallbacksC0187t);
    }

    @Override // y.InterfaceC0728d
    public final void addOnConfigurationChangedListener(H.a aVar) {
        this.f2952j.addOnConfigurationChangedListener(aVar);
    }

    @Override // androidx.fragment.app.A
    public final View b(int i4) {
        return this.f2952j.findViewById(i4);
    }

    @Override // androidx.fragment.app.A
    public final boolean c() {
        Window window = this.f2952j.getWindow();
        if (window != null && window.peekDecorView() != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.lifecycle.InterfaceC0212t
    public final AbstractC0208o getLifecycle() {
        return this.f2952j.mFragmentLifecycleRegistry;
    }

    @Override // e.u
    public final e.t getOnBackPressedDispatcher() {
        return this.f2952j.getOnBackPressedDispatcher();
    }

    @Override // i0.InterfaceC0364g
    public final C0362e getSavedStateRegistry() {
        return this.f2952j.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.Y
    public final androidx.lifecycle.X getViewModelStore() {
        return this.f2952j.getViewModelStore();
    }

    @Override // y.InterfaceC0728d
    public final void removeOnConfigurationChangedListener(H.a aVar) {
        this.f2952j.removeOnConfigurationChangedListener(aVar);
    }
}
