package n;

import E.AbstractC0005e;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: n.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0281c extends android.support.v4.media.session.a {

    /* renamed from: f, reason: collision with root package name */
    public final Object f3289f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public final ExecutorService f3290g = Executors.newFixedThreadPool(4, new ThreadFactoryC0280b());

    /* renamed from: h, reason: collision with root package name */
    public volatile Handler f3291h;

    public static Handler N(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC0005e.b(looper);
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
