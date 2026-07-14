package io.flutter.plugin.platform;

import android.view.View;

/* loaded from: classes.dex */
public final class B implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4302f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4303g;

    public /* synthetic */ B(int i4, Object obj) {
        this.f4302f = i4;
        this.f4303g = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4302f) {
            case 0:
                C c4 = (C) this.f4303g;
                ((View) c4.f4305g).postDelayed((o) c4.f4306h, 128L);
                return;
            default:
                D d4 = (D) this.f4303g;
                d4.f4307f.getViewTreeObserver().removeOnDrawListener(d4);
                return;
        }
    }
}
