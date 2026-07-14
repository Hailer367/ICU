package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewCreationRequest;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2390a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f2391b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PlatformViewCreationRequest f2392c;

    public /* synthetic */ d(PlatformViewsController platformViewsController, PlatformViewCreationRequest platformViewCreationRequest, int i2) {
        this.f2390a = i2;
        this.f2391b = platformViewsController;
        this.f2392c = platformViewCreationRequest;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f2390a) {
            case 0:
                PlatformViewsController.a(this.f2391b, this.f2392c, view, z);
                return;
            default:
                PlatformViewsController.c(this.f2391b, this.f2392c, view, z);
                return;
        }
    }
}
