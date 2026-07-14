package p;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class c extends k3.b {

    /* renamed from: m, reason: collision with root package name */
    public final Object f5796m = new Object();

    /* renamed from: n, reason: collision with root package name */
    public volatile Handler f5797n;

    public c() {
        Executors.newFixedThreadPool(4, new b());
    }

    public static Handler D(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return C.b.b(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
