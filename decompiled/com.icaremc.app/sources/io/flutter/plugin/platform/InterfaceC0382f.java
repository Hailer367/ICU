package io.flutter.plugin.platform;

import android.view.View;

/* renamed from: io.flutter.plugin.platform.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0382f {
    void dispose();

    View getView();

    default void onFlutterViewAttached(View view) {
    }

    default void onFlutterViewDetached() {
    }

    default void onInputConnectionLocked() {
    }

    default void onInputConnectionUnlocked() {
    }
}
