package io.flutter.view;

import D2.C0035n;
import android.hardware.display.DisplayManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: e, reason: collision with root package name */
    public static t f4546e;

    /* renamed from: f, reason: collision with root package name */
    public static C0035n f4547f;

    /* renamed from: b, reason: collision with root package name */
    public final FlutterJNI f4549b;

    /* renamed from: a, reason: collision with root package name */
    public long f4548a = -1;

    /* renamed from: c, reason: collision with root package name */
    public s f4550c = new s(this, 0);

    /* renamed from: d, reason: collision with root package name */
    public final d f4551d = new d(this);

    public t(FlutterJNI flutterJNI) {
        this.f4549b = flutterJNI;
    }

    public static t a(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f4546e == null) {
            f4546e = new t(flutterJNI);
        }
        if (f4547f == null) {
            t tVar = f4546e;
            Objects.requireNonNull(tVar);
            C0035n c0035n = new C0035n(tVar, displayManager, 1);
            f4547f = c0035n;
            displayManager.registerDisplayListener(c0035n, null);
        }
        if (f4546e.f4548a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f4546e.f4548a = (long) (1.0E9d / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f4546e;
    }
}
