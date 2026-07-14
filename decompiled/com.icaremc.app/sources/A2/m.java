package A2;

import android.media.ImageReader;
import android.provider.MediaStore;
import android.view.SurfaceControl;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* loaded from: classes.dex */
public abstract /* synthetic */ class m {
    public static /* bridge */ /* synthetic */ void B(OnBackInvokedDispatcher onBackInvokedDispatcher, OnBackInvokedCallback onBackInvokedCallback) {
        onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
    }

    public static /* bridge */ /* synthetic */ int a() {
        return MediaStore.getPickImagesMaxLimit();
    }

    public static /* synthetic */ ImageReader.Builder h(int i4, int i5) {
        return new ImageReader.Builder(i4, i5);
    }

    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction j() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedCallback k(Object obj) {
        return (OnBackInvokedCallback) obj;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher p(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    public static /* synthetic */ void r() {
    }

    public static /* bridge */ /* synthetic */ void u(SurfaceControl.Builder builder) {
        builder.setHidden(false);
    }

    public static /* bridge */ /* synthetic */ void v(View view) {
        view.setAutoHandwritingEnabled(false);
    }

    public static /* bridge */ /* synthetic */ void w(InputMethodManager inputMethodManager, View view) {
        inputMethodManager.startStylusHandwriting(view);
    }

    public static /* bridge */ /* synthetic */ void x(OnBackInvokedDispatcher onBackInvokedDispatcher, int i4, OnBackInvokedCallback onBackInvokedCallback) {
        onBackInvokedDispatcher.registerOnBackInvokedCallback(i4, onBackInvokedCallback);
    }
}
