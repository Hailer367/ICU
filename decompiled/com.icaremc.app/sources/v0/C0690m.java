package v0;

import I.a0;
import I.b0;
import I.c0;
import I.d0;
import I.e0;
import I.f0;
import I.g0;
import I.h0;
import I.v0;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import z0.C0747a;

/* renamed from: v0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0690m implements InterfaceC0689l {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f6288b = 0;

    static {
        new ArrayList(new I2.b(new Integer[]{1, 2, 4, 8, 16, 32, 64, 128}, true));
    }

    public static C0688k a(Activity activity) {
        Rect rect;
        int i4;
        h0 a0Var;
        v0 b4;
        WindowMetrics currentWindowMetrics;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            currentWindowMetrics = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            rect = currentWindowMetrics.getBounds();
            T2.h.d(rect, "wm.currentWindowMetrics.bounds");
        } else if (i5 >= 29) {
            Configuration configuration = activity.getResources().getConfiguration();
            try {
                Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(configuration);
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                T2.h.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect = new Rect((Rect) invoke);
            } catch (IllegalAccessException e4) {
                Log.w("m", e4);
                rect = b(activity);
            } catch (NoSuchFieldException e5) {
                Log.w("m", e5);
                rect = b(activity);
            } catch (NoSuchMethodException e6) {
                Log.w("m", e6);
                rect = b(activity);
            } catch (InvocationTargetException e7) {
                Log.w("m", e7);
                rect = b(activity);
            }
        } else if (i5 >= 28) {
            rect = b(activity);
        } else {
            rect = new Rect();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getRectSize(rect);
            if (!activity.isInMultiWindowMode()) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                Resources resources = activity.getResources();
                int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                if (identifier > 0) {
                    i4 = resources.getDimensionPixelSize(identifier);
                } else {
                    i4 = 0;
                }
                int i6 = rect.bottom + i4;
                if (i6 == point.y) {
                    rect.bottom = i6;
                } else {
                    int i7 = rect.right + i4;
                    if (i7 == point.x) {
                        rect.right = i7;
                    }
                }
            }
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 30) {
            if (i8 >= 30) {
                b4 = C0747a.f6633a.a(activity);
            } else {
                throw new Exception("Incompatible SDK version");
            }
        } else {
            if (i8 >= 36) {
                a0Var = new g0();
            } else if (i8 >= 35) {
                a0Var = new f0();
            } else if (i8 >= 34) {
                a0Var = new e0();
            } else if (i8 >= 31) {
                a0Var = new d0();
            } else if (i8 >= 30) {
                a0Var = new c0();
            } else if (i8 >= 29) {
                a0Var = new b0();
            } else {
                a0Var = new a0();
            }
            b4 = a0Var.b();
            T2.h.d(b4, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new C0688k(new s0.b(rect), b4);
    }

    public static Rect b(Activity activity) {
        int safeInsetLeft;
        int safeInsetRight;
        int safeInsetTop;
        int safeInsetBottom;
        int safeInsetBottom2;
        int safeInsetRight2;
        int i4;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        DisplayCutout displayCutout = null;
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (activity.isInMultiWindowMode()) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                T2.h.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke);
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                T2.h.c(invoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke2);
            }
        } catch (IllegalAccessException e4) {
            Log.w("m", e4);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchFieldException e5) {
            Log.w("m", e5);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchMethodException e6) {
            Log.w("m", e6);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (InvocationTargetException e7) {
            Log.w("m", e7);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        T2.h.d(defaultDisplay, "currentDisplay");
        defaultDisplay.getRealSize(point);
        if (!activity.isInMultiWindowMode()) {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i4 = resources.getDimensionPixelSize(identifier);
            } else {
                i4 = 0;
            }
            int i5 = rect.bottom + i4;
            if (i5 == point.y) {
                rect.bottom = i5;
            } else {
                int i6 = rect.right + i4;
                if (i6 == point.x) {
                    rect.right = i6;
                } else if (rect.left == i4) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activity.isInMultiWindowMode()) {
            try {
                Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
                constructor.setAccessible(true);
                Object newInstance = constructor.newInstance(null);
                Method declaredMethod = defaultDisplay.getClass().getDeclaredMethod("getDisplayInfo", newInstance.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(defaultDisplay, newInstance);
                Field declaredField2 = newInstance.getClass().getDeclaredField("displayCutout");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(newInstance);
                if (h2.l.z(obj2)) {
                    displayCutout = h2.l.h(obj2);
                }
            } catch (ClassNotFoundException e8) {
                Log.w("m", e8);
            } catch (IllegalAccessException e9) {
                Log.w("m", e9);
            } catch (InstantiationException e10) {
                Log.w("m", e10);
            } catch (NoSuchFieldException e11) {
                Log.w("m", e11);
            } catch (NoSuchMethodException e12) {
                Log.w("m", e12);
            } catch (InvocationTargetException e13) {
                Log.w("m", e13);
            }
            if (displayCutout != null) {
                int i7 = rect.left;
                safeInsetLeft = displayCutout.getSafeInsetLeft();
                if (i7 == safeInsetLeft) {
                    rect.left = 0;
                }
                int i8 = point.x - rect.right;
                safeInsetRight = displayCutout.getSafeInsetRight();
                if (i8 == safeInsetRight) {
                    int i9 = rect.right;
                    safeInsetRight2 = displayCutout.getSafeInsetRight();
                    rect.right = safeInsetRight2 + i9;
                }
                int i10 = rect.top;
                safeInsetTop = displayCutout.getSafeInsetTop();
                if (i10 == safeInsetTop) {
                    rect.top = 0;
                }
                int i11 = point.y - rect.bottom;
                safeInsetBottom = displayCutout.getSafeInsetBottom();
                if (i11 == safeInsetBottom) {
                    int i12 = rect.bottom;
                    safeInsetBottom2 = displayCutout.getSafeInsetBottom();
                    rect.bottom = safeInsetBottom2 + i12;
                }
            }
        }
        return rect;
    }
}
