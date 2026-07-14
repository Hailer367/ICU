package io.flutter.plugin.platform;

import android.view.Surface;

/* loaded from: classes.dex */
public interface i {
    void b(int i4, int i5);

    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    void release();

    default void scheduleFrame() {
    }
}
