package o;

import android.graphics.Rect;
import android.widget.PopupWindow;

/* renamed from: o.I0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0478I0 {
    public static void a(PopupWindow popupWindow, Rect rect) {
        popupWindow.setEpicenterBounds(rect);
    }

    public static void b(PopupWindow popupWindow, boolean z) {
        popupWindow.setIsClippedToScreen(z);
    }
}
