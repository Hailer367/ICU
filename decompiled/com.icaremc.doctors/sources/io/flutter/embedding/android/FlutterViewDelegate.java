package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.Window;
import android.view.WindowInsets;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.util.ViewUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class FlutterViewDelegate {
    public List<Rect> getCaptionBarInsets(Context context) {
        int captionBar;
        List<Rect> boundingRects;
        WindowInsets windowInsets = getWindowInsets(context);
        if (windowInsets != null) {
            captionBar = WindowInsets.Type.captionBar();
            boundingRects = windowInsets.getBoundingRects(captionBar);
            return boundingRects;
        }
        return Collections.EMPTY_LIST;
    }

    public WindowInsets getWindowInsets(Context context) {
        Window window;
        Activity activity = ViewUtils.getActivity(context);
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView().getRootWindowInsets();
    }

    public void growViewportMetricsToCaptionBar(Context context, FlutterRenderer.ViewportMetrics viewportMetrics) {
        List<Rect> captionBarInsets = getCaptionBarInsets(context);
        int i2 = viewportMetrics.viewPaddingTop;
        Iterator<Rect> it = captionBarInsets.iterator();
        while (it.hasNext()) {
            i2 = Math.max(i2, it.next().bottom);
        }
        viewportMetrics.viewPaddingTop = i2;
    }
}
