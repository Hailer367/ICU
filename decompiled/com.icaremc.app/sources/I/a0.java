package I;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class a0 extends h0 {

    /* renamed from: g, reason: collision with root package name */
    public static Field f714g = null;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f715h = false;

    /* renamed from: i, reason: collision with root package name */
    public static Constructor f716i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f717j = false;

    /* renamed from: e, reason: collision with root package name */
    public WindowInsets f718e;

    /* renamed from: f, reason: collision with root package name */
    public B.c f719f;

    public a0() {
        this.f718e = j();
    }

    private static WindowInsets j() {
        if (!f715h) {
            try {
                f714g = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e4);
            }
            f715h = true;
        }
        Field field = f714g;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e5);
            }
        }
        if (!f717j) {
            try {
                f716i = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e6) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e6);
            }
            f717j = true;
        }
        Constructor constructor = f716i;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e7) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e7);
            }
        }
        return null;
    }

    @Override // I.h0
    public v0 b() {
        a();
        v0 c4 = v0.c(this.f718e, null);
        B.c[] cVarArr = this.f740b;
        r0 r0Var = c4.f788a;
        r0Var.u(cVarArr);
        r0Var.w(this.f719f);
        r0Var.t(null);
        r0Var.y(this.f741c);
        r0Var.z(this.f742d);
        return c4;
    }

    @Override // I.h0
    public void f(B.c cVar) {
        this.f719f = cVar;
    }

    @Override // I.h0
    public void h(B.c cVar) {
        WindowInsets windowInsets = this.f718e;
        if (windowInsets != null) {
            this.f718e = windowInsets.replaceSystemWindowInsets(cVar.f124a, cVar.f125b, cVar.f126c, cVar.f127d);
        }
    }

    public a0(v0 v0Var) {
        super(v0Var);
        this.f718e = v0Var.b();
    }
}
