package io.flutter.embedding.android;

import android.view.View;

/* loaded from: classes.dex */
class FlutterMeasureSpec {

    /* loaded from: classes.dex */
    public interface MeasureCallback {
        void onMeasure(int i2, int i3);
    }

    public static void onMeasure(int i2, int i3, MeasureCallback measureCallback) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int i5 = 0;
        if (mode2 == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        int max = Math.max(size2, i4);
        if (mode == 0) {
            i5 = 1;
        }
        measureCallback.onMeasure(Math.max(size, i5), max);
    }
}
