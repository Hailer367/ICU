package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f1437a;

    public i0(Unsafe unsafe) {
        this.f1437a = unsafe;
    }

    public final int a(Class cls) {
        return this.f1437a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f1437a.arrayIndexScale(cls);
    }

    public abstract boolean c(long j2, Object obj);

    public abstract double d(long j2, Object obj);

    public abstract float e(long j2, Object obj);

    public final int f(long j2, Object obj) {
        return this.f1437a.getInt(obj, j2);
    }

    public final long g(long j2, Object obj) {
        return this.f1437a.getLong(obj, j2);
    }

    public final Object h(long j2, Object obj) {
        return this.f1437a.getObject(obj, j2);
    }

    public final long i(Field field) {
        return this.f1437a.objectFieldOffset(field);
    }

    public abstract void j(Object obj, long j2, boolean z);

    public abstract void k(Object obj, long j2, byte b2);

    public abstract void l(Object obj, long j2, double d2);

    public abstract void m(Object obj, long j2, float f2);

    public final void n(Object obj, long j2, int i2) {
        this.f1437a.putInt(obj, j2, i2);
    }

    public final void o(Object obj, long j2, long j3) {
        this.f1437a.putLong(obj, j2, j3);
    }

    public final void p(long j2, Object obj, Object obj2) {
        this.f1437a.putObject(obj, j2, obj2);
    }

    public boolean q() {
        Unsafe unsafe = this.f1437a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            return true;
        } catch (Throwable th) {
            j0.a(th);
            return false;
        }
    }

    public abstract boolean r();
}
