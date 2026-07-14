package j;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class u {
    public static OnBackInvokedDispatcher a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    public static OnBackInvokedCallback b(Object obj, LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A) {
        Objects.requireNonNull(layoutInflaterFactory2C0393A);
        d0.j jVar = new d0.j(2, layoutInflaterFactory2C0393A);
        A2.m.p(obj).registerOnBackInvokedCallback(1000000, jVar);
        return jVar;
    }

    public static void c(Object obj, Object obj2) {
        A2.m.p(obj).unregisterOnBackInvokedCallback(A2.m.k(obj2));
    }
}
