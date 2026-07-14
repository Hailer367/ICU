package io.flutter.util;

import C0.f;
import E.M;
import E.O;
import E.P;
import E.Q;
import E.S;
import E.T;
import E.U;
import E.V;
import E.k0;
import O.a;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.jvm.internal.h;
import l0.m;
import l0.n;
import p0.C0288a;

/* loaded from: classes.dex */
public final class ViewUtils {

    /* loaded from: classes.dex */
    public interface DisplayUpdater {
        void updateDisplayMetrics(float f2, float f3, float f4);
    }

    /* loaded from: classes.dex */
    public interface ViewVisitor {
        boolean run(View view);
    }

    public static /* synthetic */ boolean a(View view) {
        return view.hasFocus();
    }

    public static /* synthetic */ boolean b(Class[] clsArr, View view) {
        return lambda$hasChildViewOfType$1(clsArr, view);
    }

    public static void calculateMaximumDisplayMetrics(Context context, DisplayUpdater displayUpdater) {
        Rect rect;
        V m2;
        k0 _windowInsetsCompat;
        WindowMetrics maximumWindowMetrics;
        Activity activity = getActivity(context);
        if (activity != null) {
            m.f2946a.getClass();
            int i2 = n.f2947b;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                maximumWindowMetrics = ((WindowManager) activity.getSystemService(WindowManager.class)).getMaximumWindowMetrics();
                rect = maximumWindowMetrics.getBounds();
                h.d(rect, "wm.maximumWindowMetrics.bounds");
            } else {
                Object systemService = activity.getSystemService("window");
                h.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                Display display = ((WindowManager) systemService).getDefaultDisplay();
                h.d(display, "display");
                Point point = new Point();
                display.getRealSize(point);
                rect = new Rect(0, 0, point.x, point.y);
            }
            if (i3 >= 30) {
                if (i3 >= 30) {
                    _windowInsetsCompat = C0288a.f3466a.a(activity);
                } else {
                    throw new Exception("Incompatible SDK version");
                }
            } else {
                if (i3 >= 36) {
                    m2 = new U();
                } else if (i3 >= 35) {
                    m2 = new T();
                } else if (i3 >= 34) {
                    m2 = new S();
                } else if (i3 >= 31) {
                    m2 = new Q();
                } else if (i3 >= 30) {
                    m2 = new P();
                } else if (i3 >= 29) {
                    m2 = new O();
                } else {
                    m2 = new M();
                }
                _windowInsetsCompat = m2.b();
                h.d(_windowInsetsCompat, "{\n            WindowInse…ilder().build()\n        }");
            }
            int i4 = rect.left;
            int i5 = rect.top;
            int i6 = rect.right;
            int i7 = rect.bottom;
            if (i4 <= i6) {
                if (i5 <= i7) {
                    h.e(_windowInsetsCompat, "_windowInsetsCompat");
                    displayUpdater.updateDisplayMetrics(new Rect(i4, i5, i6, i7).width(), new Rect(i4, i5, i6, i7).height(), context.getResources().getDisplayMetrics().density);
                    return;
                }
                throw new IllegalArgumentException(a.d("top must be less than or equal to bottom, top: ", i5, ", bottom: ", i7).toString());
            }
            throw new IllegalArgumentException(a.d("Left must be less than or equal to right, left: ", i4, ", right: ", i6).toString());
        }
    }

    public static boolean childHasFocus(View view) {
        return traverseHierarchy(view, new f(3));
    }

    public static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return getActivity(((ContextWrapper) context).getBaseContext());
    }

    public static boolean hasChildViewOfType(View view, Class<? extends View>[] clsArr) {
        return traverseHierarchy(view, new B0.h(7, clsArr));
    }

    public static /* synthetic */ boolean lambda$hasChildViewOfType$1(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean traverseHierarchy(View view, ViewVisitor viewVisitor) {
        if (view != null) {
            if (!viewVisitor.run(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (traverseHierarchy(viewGroup.getChildAt(i2), viewVisitor)) {
                            return true;
                        }
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
