package androidx.fragment.app;

import java.lang.reflect.InvocationTargetException;
import t.C0661j;

/* loaded from: classes.dex */
public final class I {

    /* renamed from: b, reason: collision with root package name */
    public static final C0661j f2726b = new C0661j(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f2727a;

    public I(P p3) {
        this.f2727a = p3;
    }

    public static Class b(ClassLoader classLoader, String str) {
        C0661j c0661j = f2726b;
        C0661j c0661j2 = (C0661j) c0661j.get(classLoader);
        if (c0661j2 == null) {
            c0661j2 = new C0661j(0);
            c0661j.put(classLoader, c0661j2);
        }
        Class cls = (Class) c0661j2.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            c0661j2.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e4) {
            throw new RuntimeException(r2.k.b("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(r2.k.b("Unable to instantiate fragment ", str, ": make sure class name exists"), e5);
        }
    }

    public final AbstractComponentCallbacksC0187t a(String str) {
        try {
            return (AbstractComponentCallbacksC0187t) c(this.f2727a.f2770v.f2949g.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(r2.k.b("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException(r2.k.b("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(r2.k.b("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(r2.k.b("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e7);
        }
    }
}
