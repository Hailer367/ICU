package I;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class u0 {
    public static int a(int i4) {
        int statusBars;
        int i5 = 0;
        for (int i6 = 1; i6 <= 512; i6 <<= 1) {
            if ((i4 & i6) != 0) {
                if (i6 == 1) {
                    statusBars = WindowInsets.Type.statusBars();
                } else if (i6 == 2) {
                    statusBars = WindowInsets.Type.navigationBars();
                } else if (i6 == 4) {
                    statusBars = WindowInsets.Type.captionBar();
                } else if (i6 == 8) {
                    statusBars = WindowInsets.Type.ime();
                } else if (i6 == 16) {
                    statusBars = WindowInsets.Type.systemGestures();
                } else if (i6 == 32) {
                    statusBars = WindowInsets.Type.mandatorySystemGestures();
                } else if (i6 == 64) {
                    statusBars = WindowInsets.Type.tappableElement();
                } else if (i6 == 128) {
                    statusBars = WindowInsets.Type.displayCutout();
                } else if (i6 == 512) {
                    statusBars = WindowInsets.Type.systemOverlays();
                }
                i5 |= statusBars;
            }
        }
        return i5;
    }
}
