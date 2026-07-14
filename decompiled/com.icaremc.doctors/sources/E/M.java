package E;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class M extends V {

    /* renamed from: d, reason: collision with root package name */
    public static Field f184d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f185e = false;

    /* renamed from: f, reason: collision with root package name */
    public static Constructor f186f = null;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f187g = false;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f188c = d();

    private static WindowInsets d() {
        if (!f185e) {
            try {
                f184d = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
            }
            f185e = true;
        }
        Field field = f184d;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
            }
        }
        if (!f187g) {
            try {
                f186f = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
            }
            f187g = true;
        }
        Constructor constructor = f186f;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
            }
        }
        return null;
    }

    @Override // E.V
    public k0 b() {
        a();
        k0 a2 = k0.a(null, this.f188c);
        g0 g0Var = a2.f234a;
        g0Var.s(null);
        g0Var.u(null);
        g0Var.r(null);
        g0Var.w(this.f190a);
        g0Var.x(this.f191b);
        return a2;
    }
}
