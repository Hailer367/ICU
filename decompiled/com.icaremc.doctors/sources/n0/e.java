package n0;

import E.M;
import E.O;
import E.P;
import E.Q;
import E.S;
import E.T;
import E.U;
import E.V;
import E.k0;
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
import kotlin.jvm.internal.h;
import l0.k;
import l0.l;
import l0.n;

/* loaded from: classes.dex */
public abstract class e {
    public static l0.c a(l lVar, FoldingFeature foldingFeature) {
        l0.b bVar;
        l0.b bVar2;
        int type = foldingFeature.getType();
        if (type != 1) {
            if (type == 2) {
                bVar = l0.b.f2922i;
            } else {
                return null;
            }
        } else {
            bVar = l0.b.f2921h;
        }
        int state = foldingFeature.getState();
        if (state != 1) {
            if (state == 2) {
                bVar2 = l0.b.f2920g;
            } else {
                return null;
            }
        } else {
            bVar2 = l0.b.f2919f;
        }
        Rect bounds = foldingFeature.getBounds();
        h.d(bounds, "oemFeature.bounds");
        int i2 = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        if (i2 <= i4) {
            if (i3 <= i5) {
                Rect a2 = lVar.f2944a.a();
                int i6 = i5 - i3;
                if (i6 != 0 || i4 - i2 != 0) {
                    int i7 = i4 - i2;
                    if (i7 == a2.width() || i6 == a2.height()) {
                        if (i7 >= a2.width() || i6 >= a2.height()) {
                            if (i7 == a2.width() && i6 == a2.height()) {
                                return null;
                            }
                            Rect bounds2 = foldingFeature.getBounds();
                            h.d(bounds2, "oemFeature.bounds");
                            return new l0.c(new i0.b(bounds2), bVar, bVar2);
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            throw new IllegalArgumentException(O.a.d("top must be less than or equal to bottom, top: ", i3, ", bottom: ", i5).toString());
        }
        throw new IllegalArgumentException(O.a.d("Left must be less than or equal to right, left: ", i2, ", right: ", i4).toString());
    }

    public static k b(Context context, WindowLayoutInfo info) {
        V m2;
        l lVar;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        WindowMetrics currentWindowMetrics2;
        Rect bounds;
        h.e(info, "info");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            int i3 = n.f2947b;
            if (i2 >= 30) {
                WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                windowInsets = currentWindowMetrics.getWindowInsets();
                k0 a2 = k0.a(null, windowInsets);
                currentWindowMetrics2 = windowManager.getCurrentWindowMetrics();
                bounds = currentWindowMetrics2.getBounds();
                h.d(bounds, "wm.currentWindowMetrics.bounds");
                lVar = new l(new i0.b(bounds), a2);
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
                        lVar = n.a((Activity) context);
                    } else if (context2 instanceof InputMethodService) {
                        Object systemService = context.getSystemService("window");
                        h.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                        h.d(defaultDisplay, "wm.defaultDisplay");
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        Rect rect = new Rect(0, 0, point.x, point.y);
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 >= 36) {
                            m2 = new U();
                        } else if (i4 >= 35) {
                            m2 = new T();
                        } else if (i4 >= 34) {
                            m2 = new S();
                        } else if (i4 >= 31) {
                            m2 = new Q();
                        } else if (i4 >= 30) {
                            m2 = new P();
                        } else if (i4 >= 29) {
                            m2 = new O();
                        } else {
                            m2 = new M();
                        }
                        k0 b2 = m2.b();
                        h.d(b2, "Builder().build()");
                        lVar = new l(new i0.b(rect), b2);
                    } else {
                        throw new IllegalArgumentException(context + " is not a UiContext");
                    }
                }
                throw new IllegalArgumentException("Context " + context + " is not a UiContext");
            }
            return c(lVar, info);
        }
        if (i2 >= 29 && (context instanceof Activity)) {
            int i5 = n.f2947b;
            return c(n.a((Activity) context), info);
        }
        throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
    }

    public static k c(l lVar, WindowLayoutInfo info) {
        l0.c cVar;
        h.e(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        h.d(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature feature : displayFeatures) {
            if (feature instanceof FoldingFeature) {
                h.d(feature, "feature");
                cVar = a(lVar, feature);
            } else {
                cVar = null;
            }
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return new k(arrayList);
    }
}
