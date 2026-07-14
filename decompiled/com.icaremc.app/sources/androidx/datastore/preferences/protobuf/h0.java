package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class h0 extends i0 {
    @Override // androidx.datastore.preferences.protobuf.i0
    public final boolean c(long j4, Object obj) {
        return this.f2654a.getBoolean(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final double d(long j4, Object obj) {
        return this.f2654a.getDouble(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final float e(long j4, Object obj) {
        return this.f2654a.getFloat(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void j(Object obj, long j4, boolean z) {
        this.f2654a.putBoolean(obj, j4, z);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void k(Object obj, long j4, byte b4) {
        this.f2654a.putByte(obj, j4, b4);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void l(Object obj, long j4, double d4) {
        this.f2654a.putDouble(obj, j4, d4);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final void m(Object obj, long j4, float f4) {
        this.f2654a.putFloat(obj, j4, f4);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public final boolean q() {
        if (!super.q()) {
            return false;
        }
        try {
            Class<?> cls = this.f2654a.getClass();
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
        Unsafe unsafe = this.f2654a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (j0.g() != null) {
                    try {
                        Class<?> cls3 = this.f2654a.getClass();
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
