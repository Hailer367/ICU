package io.flutter.view;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ AccessibilityNodeInfo.CollectionInfo d(int i4) {
        return new AccessibilityNodeInfo.CollectionInfo(i4, 1, false);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionItemInfo e(int i4, boolean z) {
        return new AccessibilityNodeInfo.CollectionItemInfo(i4, 1, 0, 1, z);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionInfo g(int i4) {
        return new AccessibilityNodeInfo.CollectionInfo(1, i4, false);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionItemInfo h(int i4, boolean z) {
        return new AccessibilityNodeInfo.CollectionItemInfo(0, 1, i4, 1, z);
    }
}
