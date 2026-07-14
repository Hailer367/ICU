package io.flutter.plugin.platform;

import android.os.Build;

/* loaded from: classes.dex */
public final class y implements io.flutter.view.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f4403a;

    public y(z zVar) {
        this.f4403a = zVar;
    }

    @Override // io.flutter.view.q
    public final void onTrimMemory(int i4) {
        if (i4 == 80 && Build.VERSION.SDK_INT >= 29) {
            this.f4403a.k = true;
        }
    }
}
