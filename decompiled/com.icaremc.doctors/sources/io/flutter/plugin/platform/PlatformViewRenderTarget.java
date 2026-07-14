package io.flutter.plugin.platform;

import android.view.Surface;

/* loaded from: classes.dex */
public interface PlatformViewRenderTarget {
    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    boolean isReleased();

    void release();

    void resize(int i2, int i3);

    default void scheduleFrame() {
    }
}
