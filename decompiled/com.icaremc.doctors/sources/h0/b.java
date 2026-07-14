package h0;

import android.app.Activity;
import i0.c;
import i0.d;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f2320a;

    public d a(Object obj, kotlin.jvm.internal.d dVar, Activity activity, n0.b bVar) {
        c cVar = new c(dVar, bVar);
        Object newProxyInstance = Proxy.newProxyInstance(this.f2320a, new Class[]{b()}, cVar);
        h.d(newProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        obj.getClass().getMethod("addWindowLayoutInfoListener", Activity.class, b()).invoke(obj, activity, newProxyInstance);
        return new d(obj.getClass().getMethod("removeWindowLayoutInfoListener", b()), obj, newProxyInstance);
    }

    public Class b() {
        Class<?> loadClass = this.f2320a.loadClass("java.util.function.Consumer");
        h.d(loadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return loadClass;
    }
}
