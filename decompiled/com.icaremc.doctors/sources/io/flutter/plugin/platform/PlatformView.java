package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.view.View;

/* loaded from: classes.dex */
public interface PlatformView {
    void dispose();

    View getView();

    @SuppressLint({"NewApi"})
    default void onFlutterViewAttached(View view) {
    }

    @SuppressLint({"NewApi"})
    default void onFlutterViewDetached() {
    }

    @SuppressLint({"NewApi"})
    default void onInputConnectionLocked() {
    }

    @SuppressLint({"NewApi"})
    default void onInputConnectionUnlocked() {
    }
}
