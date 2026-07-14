package io.flutter.view;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ AccessibilityNodeInfo.CollectionInfo d(int i2) {
        return new AccessibilityNodeInfo.CollectionInfo(1, i2, false);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionItemInfo e(int i2, boolean z) {
        return new AccessibilityNodeInfo.CollectionItemInfo(i2, 1, 0, 1, z);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionItemInfo g(int i2, boolean z) {
        return new AccessibilityNodeInfo.CollectionItemInfo(0, 1, i2, 1, z);
    }
}
