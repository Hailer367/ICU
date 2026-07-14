package io.flutter.plugin.common;

import android.content.Intent;

/* loaded from: classes.dex */
public interface PluginRegistry {

    /* loaded from: classes.dex */
    public interface ActivityResultListener {
        boolean onActivityResult(int i2, int i3, Intent intent);
    }

    /* loaded from: classes.dex */
    public interface NewIntentListener {
        boolean onNewIntent(Intent intent);
    }

    /* loaded from: classes.dex */
    public interface RequestPermissionsResultListener {
        boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface UserLeaveHintListener {
        void onUserLeaveHint();
    }

    /* loaded from: classes.dex */
    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(boolean z);
    }
}
