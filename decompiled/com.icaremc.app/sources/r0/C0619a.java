package r0;

import T2.e;
import T2.h;
import android.app.Activity;
import java.lang.reflect.Proxy;
import s0.c;
import s0.d;
import x0.C0716b;

/* renamed from: r0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0619a {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f6015a;

    public /* synthetic */ C0619a(ClassLoader classLoader) {
        this.f6015a = classLoader;
    }

    public d a(Object obj, e eVar, Activity activity, C0716b c0716b) {
        c cVar = new c(eVar, c0716b);
        Object newProxyInstance = Proxy.newProxyInstance(this.f6015a, new Class[]{b()}, cVar);
        h.d(newProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        obj.getClass().getMethod("addWindowLayoutInfoListener", Activity.class, b()).invoke(obj, activity, newProxyInstance);
        return new d(obj.getClass().getMethod("removeWindowLayoutInfoListener", b()), obj, newProxyInstance);
    }

    public Class b() {
        Class<?> loadClass = this.f6015a.loadClass("java.util.function.Consumer");
        h.d(loadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return loadClass;
    }
}
