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
    public static final Unsafe f2657a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f2658b;

    /* renamed from: c, reason: collision with root package name */
    public static final i0 f2659c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f2660d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f2661e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f2662f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f2663g;

    static {
        boolean r3;
        boolean q2;
        Unsafe i4 = i();
        f2657a = i4;
        f2658b = AbstractC0146c.f2621a;
        boolean h3 = h(Long.TYPE);
        boolean h4 = h(Integer.TYPE);
        i0 i0Var = null;
        if (i4 != null) {
            if (AbstractC0146c.a()) {
                if (h3) {
                    i0Var = new g0(i4, 1);
                } else if (h4) {
                    i0Var = new g0(i4, 0);
                }
            } else {
                i0Var = new i0(i4);
            }
        }
        f2659c = i0Var;
        boolean z = false;
        if (i0Var == null) {
            r3 = false;
        } else {
            r3 = i0Var.r();
        }
        f2660d = r3;
        if (i0Var == null) {
            q2 = false;
        } else {
            q2 = i0Var.q();
        }
        f2661e = q2;
        f2662f = e(byte[].class);
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
        Field g4 = g();
        if (g4 != null && i0Var != null) {
            i0Var.i(g4);
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z = true;
        }
        f2663g = z;
    }

    public static void a(Throwable th) {
        Logger.getLogger(j0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(long j4, Object obj) {
        if (((byte) ((f2659c.f((-4) & j4, obj) >>> ((int) (((~j4) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean c(long j4, Object obj) {
        if (((byte) ((f2659c.f((-4) & j4, obj) >>> ((int) ((j4 & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static Object d(Class cls) {
        try {
            return f2657a.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static int e(Class cls) {
        if (f2661e) {
            return f2659c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (f2661e) {
            f2659c.b(cls);
        }
    }

    public static Field g() {
        Field field;
        Field field2;
        if (AbstractC0146c.a()) {
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
        if (!AbstractC0146c.a()) {
            return false;
        }
        try {
            Class cls2 = f2658b;
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

    public static void j(byte[] bArr, long j4, byte b4) {
        f2659c.k(bArr, f2662f + j4, b4);
    }

    public static void k(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int f4 = f2659c.f(j5, obj);
        int i4 = ((~((int) j4)) & 3) << 3;
        m(obj, j5, ((255 & b4) << i4) | (f4 & (~(255 << i4))));
    }

    public static void l(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int i4 = (((int) j4) & 3) << 3;
        m(obj, j5, ((255 & b4) << i4) | (f2659c.f(j5, obj) & (~(255 << i4))));
    }

    public static void m(Object obj, long j4, int i4) {
        f2659c.n(obj, j4, i4);
    }

    public static void n(Object obj, long j4, long j5) {
        f2659c.o(obj, j4, j5);
    }

    public static void o(long j4, Object obj, Object obj2) {
        f2659c.p(j4, obj, obj2);
    }
}
