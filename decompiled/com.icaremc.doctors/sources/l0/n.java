package l0;

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
import p0.C0288a;

/* loaded from: classes.dex */
public final class n implements m {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2947b = 0;

    static {
        new ArrayList(new R0.g(new Integer[]{1, 2, 4, 8, 16, 32, 64, 128}, true));
    }

    public static l a(Activity activity) {
        Rect rect;
        int i2;
        V m2;
        k0 b2;
        WindowMetrics currentWindowMetrics;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            currentWindowMetrics = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            rect = currentWindowMetrics.getBounds();
            kotlin.jvm.internal.h.d(rect, "wm.currentWindowMetrics.bounds");
        } else if (i3 >= 29) {
            Configuration configuration = activity.getResources().getConfiguration();
            try {
                Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(configuration);
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                kotlin.jvm.internal.h.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect = new Rect((Rect) invoke);
            } catch (IllegalAccessException e2) {
                Log.w("n", e2);
                rect = b(activity);
            } catch (NoSuchFieldException e3) {
                Log.w("n", e3);
                rect = b(activity);
            } catch (NoSuchMethodException e4) {
                Log.w("n", e4);
                rect = b(activity);
            } catch (InvocationTargetException e5) {
                Log.w("n", e5);
                rect = b(activity);
            }
        } else if (i3 >= 28) {
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
                    i2 = resources.getDimensionPixelSize(identifier);
                } else {
                    i2 = 0;
                }
                int i4 = rect.bottom + i2;
                if (i4 == point.y) {
                    rect.bottom = i4;
                } else {
                    int i5 = rect.right + i2;
                    if (i5 == point.x) {
                        rect.right = i5;
                    }
                }
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            if (i6 >= 30) {
                b2 = C0288a.f3466a.a(activity);
            } else {
                throw new Exception("Incompatible SDK version");
            }
        } else {
            if (i6 >= 36) {
                m2 = new U();
            } else if (i6 >= 35) {
                m2 = new T();
            } else if (i6 >= 34) {
                m2 = new S();
            } else if (i6 >= 31) {
                m2 = new Q();
            } else if (i6 >= 30) {
                m2 = new P();
            } else if (i6 >= 29) {
                m2 = new O();
            } else {
                m2 = new M();
            }
            b2 = m2.b();
            kotlin.jvm.internal.h.d(b2, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new l(new i0.b(rect), b2);
    }

    public static Rect b(Activity activity) {
        int safeInsetLeft;
        int safeInsetRight;
        int safeInsetTop;
        int safeInsetBottom;
        int safeInsetBottom2;
        int safeInsetRight2;
        int i2;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        DisplayCutout displayCutout = null;
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (activity.isInMultiWindowMode()) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                kotlin.jvm.internal.h.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke);
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                kotlin.jvm.internal.h.c(invoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke2);
            }
        } catch (IllegalAccessException e2) {
            Log.w("n", e2);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchFieldException e3) {
            Log.w("n", e3);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchMethodException e4) {
            Log.w("n", e4);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (InvocationTargetException e5) {
            Log.w("n", e5);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        kotlin.jvm.internal.h.d(currentDisplay, "currentDisplay");
        currentDisplay.getRealSize(point);
        if (!activity.isInMultiWindowMode()) {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i2 = resources.getDimensionPixelSize(identifier);
            } else {
                i2 = 0;
            }
            int i3 = rect.bottom + i2;
            if (i3 == point.y) {
                rect.bottom = i3;
            } else {
                int i4 = rect.right + i2;
                if (i4 == point.x) {
                    rect.right = i4;
                } else if (rect.left == i2) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activity.isInMultiWindowMode()) {
            try {
                Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
                constructor.setAccessible(true);
                Object newInstance = constructor.newInstance(null);
                Method declaredMethod = currentDisplay.getClass().getDeclaredMethod("getDisplayInfo", newInstance.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(currentDisplay, newInstance);
                Field declaredField2 = newInstance.getClass().getDeclaredField("displayCutout");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(newInstance);
                if (io.flutter.embedding.engine.image.a.o(obj2)) {
                    displayCutout = io.flutter.embedding.engine.image.a.i(obj2);
                }
            } catch (ClassNotFoundException e6) {
                Log.w("n", e6);
            } catch (IllegalAccessException e7) {
                Log.w("n", e7);
            } catch (InstantiationException e8) {
                Log.w("n", e8);
            } catch (NoSuchFieldException e9) {
                Log.w("n", e9);
            } catch (NoSuchMethodException e10) {
                Log.w("n", e10);
            } catch (InvocationTargetException e11) {
                Log.w("n", e11);
            }
            if (displayCutout != null) {
                int i5 = rect.left;
                safeInsetLeft = displayCutout.getSafeInsetLeft();
                if (i5 == safeInsetLeft) {
                    rect.left = 0;
                }
                int i6 = point.x - rect.right;
                safeInsetRight = displayCutout.getSafeInsetRight();
                if (i6 == safeInsetRight) {
                    int i7 = rect.right;
                    safeInsetRight2 = displayCutout.getSafeInsetRight();
                    rect.right = safeInsetRight2 + i7;
                }
                int i8 = rect.top;
                safeInsetTop = displayCutout.getSafeInsetTop();
                if (i8 == safeInsetTop) {
                    rect.top = 0;
                }
                int i9 = point.y - rect.bottom;
                safeInsetBottom = displayCutout.getSafeInsetBottom();
                if (i9 == safeInsetBottom) {
                    int i10 = rect.bottom;
                    safeInsetBottom2 = displayCutout.getSafeInsetBottom();
                    rect.bottom = safeInsetBottom2 + i10;
                }
            }
        }
        return rect;
    }
}
