package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class h0 extends i0 {
    @Override // androidx.datastore.preferences.protobuf.i0
    public final boolean c(long j2, Object obj) {
        return this.f1437a.getBoolean(obj, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final double d(long j2, Object obj) {
        return this.f1437a.getDouble(obj, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final float e(long j2, Object obj) {
        return this.f1437a.getFloat(obj, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void j(Object obj, long j2, boolean z) {
        this.f1437a.putBoolean(obj, j2, z);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void k(Object obj, long j2, byte b2) {
        this.f1437a.putByte(obj, j2, b2);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void l(Object obj, long j2, double d2) {
        this.f1437a.putDouble(obj, j2, d2);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void m(Object obj, long j2, float f2) {
        this.f1437a.putFloat(obj, j2, f2);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final boolean q() {
        if (!super.q()) {
            return false;
        }
        try {
            Class<?> cls = this.f1437a.getClass();
            Class cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            j0.a(th);
            return false;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final boolean r() {
        Unsafe unsafe = this.f1437a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (j0.g() != null) {
                    try {
                        Class<?> cls3 = this.f1437a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        j0.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                j0.a(th2);
            }
        }
        return false;
    }
}
