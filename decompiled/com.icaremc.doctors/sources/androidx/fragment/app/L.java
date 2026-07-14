package androidx.fragment.app;

import E.InterfaceC0010j;
import E.InterfaceC0016p;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC0146p;
import b0.C0163e;
import b0.InterfaceC0165g;
import f.AbstractC0193i;
import f.InterfaceC0194j;
import io.flutter.embedding.android.FlutterFragmentActivity;

/* loaded from: classes.dex */
public final class L extends T implements v.d, v.e, u.I, u.J, androidx.lifecycle.d0, d.u, InterfaceC0194j, InterfaceC0165g, l0, InterfaceC0010j {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ FlutterFragmentActivity f1553g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(FlutterFragmentActivity flutterFragmentActivity) {
        super(flutterFragmentActivity);
        this.f1553g = flutterFragmentActivity;
    }

    @Override // androidx.fragment.app.l0
    public final void a(H h2) {
        this.f1553g.onAttachFragment(h2);
    }

    @Override // E.InterfaceC0010j
    public final void addMenuProvider(InterfaceC0016p interfaceC0016p) {
        this.f1553g.addMenuProvider(interfaceC0016p);
    }

    @Override // v.d
    public final void addOnConfigurationChangedListener(D.a aVar) {
        this.f1553g.addOnConfigurationChangedListener(aVar);
    }

    @Override // u.I
    public final void addOnMultiWindowModeChangedListener(D.a aVar) {
        this.f1553g.addOnMultiWindowModeChangedListener(aVar);
    }

    @Override // u.J
    public final void addOnPictureInPictureModeChangedListener(D.a aVar) {
        this.f1553g.addOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // v.e
    public final void addOnTrimMemoryListener(D.a aVar) {
        this.f1553g.addOnTrimMemoryListener(aVar);
    }

    @Override // androidx.fragment.app.P
    public final View b(int i2) {
        return this.f1553g.findViewById(i2);
    }

    @Override // androidx.fragment.app.P
    public final boolean c() {
        Window window = this.f1553g.getWindow();
        if (window != null && window.peekDecorView() != null) {
            return true;
        }
        return false;
    }

    @Override // f.InterfaceC0194j
    public final AbstractC0193i getActivityResultRegistry() {
        return this.f1553g.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.InterfaceC0150u
    public final AbstractC0146p getLifecycle() {
        return this.f1553g.mFragmentLifecycleRegistry;
    }

    @Override // d.u
    public final d.t getOnBackPressedDispatcher() {
        return this.f1553g.getOnBackPressedDispatcher();
    }

    @Override // b0.InterfaceC0165g
    public final C0163e getSavedStateRegistry() {
        return this.f1553g.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.d0
    public final androidx.lifecycle.c0 getViewModelStore() {
        return this.f1553g.getViewModelStore();
    }

    @Override // E.InterfaceC0010j
    public final void removeMenuProvider(InterfaceC0016p interfaceC0016p) {
        this.f1553g.removeMenuProvider(interfaceC0016p);
    }

    @Override // v.d
    public final void removeOnConfigurationChangedListener(D.a aVar) {
        this.f1553g.removeOnConfigurationChangedListener(aVar);
    }

    @Override // u.I
    public final void removeOnMultiWindowModeChangedListener(D.a aVar) {
        this.f1553g.removeOnMultiWindowModeChangedListener(aVar);
    }

    @Override // u.J
    public final void removeOnPictureInPictureModeChangedListener(D.a aVar) {
        this.f1553g.removeOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // v.e
    public final void removeOnTrimMemoryListener(D.a aVar) {
        this.f1553g.removeOnTrimMemoryListener(aVar);
    }
}
