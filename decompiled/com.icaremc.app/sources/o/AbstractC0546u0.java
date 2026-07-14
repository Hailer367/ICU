package o;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* renamed from: o.u0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0546u0 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5713a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5714b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f5715c = new Rect();

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29 && i4 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state != null && state.length != 0) {
                drawable.setState(f5714b);
            } else {
                drawable.setState(f5713a);
            }
            drawable.setState(state);
        }
    }

    public static Rect b(Drawable drawable) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            Insets a4 = AbstractC0544t0.a(drawable);
            i4 = a4.left;
            i5 = a4.top;
            i6 = a4.right;
            i7 = a4.bottom;
            return new Rect(i4, i5, i6, i7);
        }
        if (i8 < 29) {
            if (AbstractC0542s0.f5698a) {
                try {
                    Object invoke = AbstractC0542s0.f5699b.invoke(drawable, null);
                    if (invoke != null) {
                        return new Rect(AbstractC0542s0.f5700c.getInt(invoke), AbstractC0542s0.f5701d.getInt(invoke), AbstractC0542s0.f5702e.getInt(invoke), AbstractC0542s0.f5703f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
        } else {
            boolean z = AbstractC0542s0.f5698a;
        }
        return f5715c;
    }

    public static PorterDuff.Mode c(int i4, PorterDuff.Mode mode) {
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 9) {
                    switch (i4) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
