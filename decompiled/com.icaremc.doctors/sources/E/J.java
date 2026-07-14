package E;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class J {

    /* renamed from: a, reason: collision with root package name */
    public static Field f180a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f181b = false;

    static {
        new WeakHashMap();
    }

    public static void a(ViewGroup viewGroup, C0002b c0002b) {
        View.AccessibilityDelegate accessibilityDelegate;
        C0001a c0001a = null;
        if (c0002b == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                accessibilityDelegate = G.a(viewGroup);
            } else {
                if (!f181b) {
                    if (f180a == null) {
                        try {
                            Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                            f180a = declaredField;
                            declaredField.setAccessible(true);
                        } catch (Throwable unused) {
                            f181b = true;
                        }
                    }
                    try {
                        Object obj = f180a.get(viewGroup);
                        if (obj instanceof View.AccessibilityDelegate) {
                            accessibilityDelegate = (View.AccessibilityDelegate) obj;
                        }
                    } catch (Throwable unused2) {
                        f181b = true;
                    }
                }
                accessibilityDelegate = null;
            }
            if (accessibilityDelegate instanceof C0001a) {
                c0002b = new C0002b();
            }
        }
        if (viewGroup.getImportantForAccessibility() == 0) {
            viewGroup.setImportantForAccessibility(1);
        }
        if (c0002b != null) {
            c0001a = c0002b.f212b;
        }
        viewGroup.setAccessibilityDelegate(c0001a);
    }
}
