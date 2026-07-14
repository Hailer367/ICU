package E;

import android.os.ext.SdkExtensions;
import android.view.WindowInsetsAnimation;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a0 {
    public static /* bridge */ /* synthetic */ int C() {
        return SdkExtensions.getExtensionVersion(30);
    }

    public static /* bridge */ /* synthetic */ WindowInsetsAnimation g(Object obj) {
        return (WindowInsetsAnimation) obj;
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionInfo j(int i2) {
        return new AccessibilityNodeInfo.CollectionInfo(i2, 1, false);
    }
}
