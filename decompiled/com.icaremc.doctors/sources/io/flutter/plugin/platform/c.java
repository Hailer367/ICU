package io.flutter.plugin.platform;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2387a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2388b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PlatformViewsAccessibilityDelegate f2389c;

    public /* synthetic */ c(PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate, int i2, int i3) {
        this.f2387a = i3;
        this.f2389c = platformViewsAccessibilityDelegate;
        this.f2388b = i2;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f2387a) {
            case 0:
                ((PlatformViewsController) this.f2389c).lambda$initializePlatformViewIfNeeded$2(this.f2388b, view, z);
                return;
            default:
                PlatformViewsController2.a((PlatformViewsController2) this.f2389c, this.f2388b, view, z);
                return;
        }
    }
}
