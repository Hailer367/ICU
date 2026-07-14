package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f1440a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f1441b;

    /* renamed from: c, reason: collision with root package name */
    public static final i0 f1442c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f1443d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f1444e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f1445f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f1446g;

    static {
        boolean r2;
        boolean q;
        Unsafe i2 = i();
        f1440a = i2;
        f1441b = AbstractC0076c.f1403a;
        boolean h2 = h(Long.TYPE);
        boolean h3 = h(Integer.TYPE);
        i0 i0Var = null;
        if (i2 != null) {
            if (AbstractC0076c.a()) {
                if (h2) {
                    i0Var = new g0(i2, 1);
                } else if (h3) {
                    i0Var = new g0(i2, 0);
                }
            } else {
                i0Var = new i0(i2);
            }
        }
        f1442c = i0Var;
        boolean z = false;
        if (i0Var == null) {
            r2 = false;
        } else {
            r2 = i0Var.r();
        }
        f1443d = r2;
        if (i0Var == null) {
            q = false;
        } else {
            q = i0Var.q();
        }
        f1444e = q;
        f1445f = e(byte[].class);
        e(boolean[].class);
        f(boolean[].class);
        e(int[].class);
        f(int[].class);
        e(long[].class);
        f(long[].class);
        e(float[].class);
        f(float[].class);
        e(double[].class);
        f(double[].class);
        e(Object[].class);
        f(Object[].class);
        Field g2 = g();
        if (g2 != null && i0Var != null) {
            i0Var.i(g2);
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z = true;
        }
        f1446g = z;
    }

    public static void a(Throwable th) {
        Logger.getLogger(j0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(long j2, Object obj) {
        if (((byte) ((f1442c.f((-4) & j2, obj) >>> ((int) (((~j2) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean c(long j2, Object obj) {
        if (((byte) ((f1442c.f((-4) & j2, obj) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static Object d(Class cls) {
        try {
            return f1440a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int e(Class cls) {
        if (f1444e) {
            return f1442c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (f1444e) {
            f1442c.b(cls);
        }
    }

    public static Field g() {
        Field field;
        Field field2;
        if (AbstractC0076c.a()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    public static boolean h(Class cls) {
        if (!AbstractC0076c.a()) {
            return false;
        }
        try {
            Class cls2 = f1441b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.security.PrivilegedExceptionAction] */
    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged((PrivilegedExceptionAction) new Object());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j2, byte b2) {
        f1442c.k(bArr, f1445f + j2, b2);
    }

    public static void k(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int f2 = f1442c.f(j3, obj);
        int i2 = ((~((int) j2)) & 3) << 3;
        m(obj, j3, ((255 & b2) << i2) | (f2 & (~(255 << i2))));
    }

    public static void l(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        m(obj, j3, ((255 & b2) << i2) | (f1442c.f(j3, obj) & (~(255 << i2))));
    }

    public static void m(Object obj, long j2, int i2) {
        f1442c.n(obj, j2, i2);
    }

    public static void n(Object obj, long j2, long j3) {
        f1442c.o(obj, j2, j3);
    }

    public static void o(long j2, Object obj, Object obj2) {
        f1442c.p(j2, obj, obj2);
    }
}
