package io.flutter.plugin.platform;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class D implements ViewTreeObserver.OnDrawListener {

    /* renamed from: f, reason: collision with root package name */
    public final View f4307f;

    /* renamed from: g, reason: collision with root package name */
    public B f4308g;

    public D(View view, B b4) {
        this.f4307f = view;
        this.f4308g = b4;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        B b4 = this.f4308g;
        if (b4 == null) {
            return;
        }
        b4.run();
        this.f4308g = null;
        this.f4307f.post(new B(1, this));
    }
}
