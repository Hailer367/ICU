package io.flutter.plugin.platform;

import android.view.View;

/* renamed from: io.flutter.plugin.platform.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnSystemUiVisibilityChangeListenerC0380d implements View.OnSystemUiVisibilityChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f4323a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0381e f4324b;

    public ViewOnSystemUiVisibilityChangeListenerC0380d(C0381e c0381e, View view) {
        this.f4324b = c0381e;
        this.f4323a = view;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i4) {
        this.f4323a.post(new A2.o(this, i4, 2));
    }
}
