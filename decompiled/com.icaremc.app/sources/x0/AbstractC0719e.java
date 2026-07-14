package x0;

import A2.i;
import I.a0;
import I.b0;
import I.c0;
import I.d0;
import I.e0;
import I.f0;
import I.g0;
import I.h0;
import I.v0;
import T2.h;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import v0.C0679b;
import v0.C0680c;
import v0.C0687j;
import v0.C0688k;
import v0.C0690m;

/* renamed from: x0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0719e {
    public static C0680c a(C0688k c0688k, FoldingFeature foldingFeature) {
        C0679b c0679b;
        C0679b c0679b2;
        int type = foldingFeature.getType();
        if (type != 1) {
            if (type == 2) {
                c0679b = C0679b.f6265m;
            } else {
                return null;
            }
        } else {
            c0679b = C0679b.f6264l;
        }
        int state = foldingFeature.getState();
        if (state != 1) {
            if (state == 2) {
                c0679b2 = C0679b.k;
            } else {
                return null;
            }
        } else {
            c0679b2 = C0679b.f6263j;
        }
        Rect bounds = foldingFeature.getBounds();
        h.d(bounds, "oemFeature.bounds");
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.right;
        int i7 = bounds.bottom;
        if (i4 <= i6) {
            if (i5 <= i7) {
                Rect a4 = c0688k.f6285a.a();
                int i8 = i7 - i5;
                if (i8 != 0 || i6 - i4 != 0) {
                    int i9 = i6 - i4;
                    if (i9 == a4.width() || i8 == a4.height()) {
                        if (i9 >= a4.width() || i8 >= a4.height()) {
                            if (i9 == a4.width() && i8 == a4.height()) {
                                return null;
                            }
                            Rect bounds2 = foldingFeature.getBounds();
                            h.d(bounds2, "oemFeature.bounds");
                            return new C0680c(new s0.b(bounds2), c0679b, c0679b2);
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            throw new IllegalArgumentException(i.h("top must be less than or equal to bottom, top: ", ", bottom: ", i5, i7).toString());
        }
        throw new IllegalArgumentException(i.h("Left must be less than or equal to right, left: ", ", right: ", i4, i6).toString());
    }

    public static C0687j b(Context context, WindowLayoutInfo windowLayoutInfo) {
        h0 a0Var;
        C0688k c0688k;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        WindowMetrics currentWindowMetrics2;
        Rect bounds;
        h.e(windowLayoutInfo, "info");
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            int i5 = C0690m.f6288b;
            if (i4 >= 30) {
                WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                windowInsets = currentWindowMetrics.getWindowInsets();
                v0 c4 = v0.c(windowInsets, null);
                currentWindowMetrics2 = windowManager.getCurrentWindowMetrics();
                bounds = currentWindowMetrics2.getBounds();
                h.d(bounds, "wm.currentWindowMetrics.bounds");
                c0688k = new C0688k(new s0.b(bounds), c4);
            } else {
                Context context2 = context;
                while (context2 instanceof ContextWrapper) {
                    boolean z = context2 instanceof Activity;
                    if (!z && !(context2 instanceof InputMethodService)) {
                        ContextWrapper contextWrapper = (ContextWrapper) context2;
                        if (contextWrapper.getBaseContext() != null) {
                            context2 = contextWrapper.getBaseContext();
                            h.d(context2, "iterator.baseContext");
                        }
                    }
                    if (z) {
                        c0688k = C0690m.a((Activity) context);
                    } else if (context2 instanceof InputMethodService) {
                        Object systemService = context.getSystemService("window");
                        h.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                        h.d(defaultDisplay, "wm.defaultDisplay");
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        Rect rect = new Rect(0, 0, point.x, point.y);
                        int i6 = Build.VERSION.SDK_INT;
                        if (i6 >= 36) {
                            a0Var = new g0();
                        } else if (i6 >= 35) {
                            a0Var = new f0();
                        } else if (i6 >= 34) {
                            a0Var = new e0();
                        } else if (i6 >= 31) {
                            a0Var = new d0();
                        } else if (i6 >= 30) {
                            a0Var = new c0();
                        } else if (i6 >= 29) {
                            a0Var = new b0();
                        } else {
                            a0Var = new a0();
                        }
                        v0 b4 = a0Var.b();
                        h.d(b4, "Builder().build()");
                        c0688k = new C0688k(new s0.b(rect), b4);
                    } else {
                        throw new IllegalArgumentException(context + " is not a UiContext");
                    }
                }
                throw new IllegalArgumentException("Context " + context + " is not a UiContext");
            }
            return c(c0688k, windowLayoutInfo);
        }
        if (i4 >= 29 && (context instanceof Activity)) {
            int i7 = C0690m.f6288b;
            return c(C0690m.a((Activity) context), windowLayoutInfo);
        }
        throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
    }

    public static C0687j c(C0688k c0688k, WindowLayoutInfo windowLayoutInfo) {
        C0680c c0680c;
        h.e(windowLayoutInfo, "info");
        List<FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        h.d(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            if (foldingFeature instanceof FoldingFeature) {
                h.d(foldingFeature, "feature");
                c0680c = a(c0688k, foldingFeature);
            } else {
                c0680c = null;
            }
            if (c0680c != null) {
                arrayList.add(c0680c);
            }
        }
        return new C0687j(arrayList);
    }
}
