package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class X {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2603a;

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f2604b;

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f2605c;

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.datastore.preferences.protobuf.e0, java.lang.Object] */
    static {
        Class<?> cls;
        Class<?> cls2;
        T t3 = T.f2593c;
        e0 e0Var = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f2603a = cls;
        try {
            T t4 = T.f2593c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                e0Var = (e0) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        f2604b = e0Var;
        f2605c = new Object();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += C0156m.Z(((Integer) list.get(i5)).intValue());
        }
        return i4;
    }

    public static int b(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0156m.X(i4) + 4) * size;
    }

    public static int c(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0156m.X(i4) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += C0156m.Z(((Integer) list.get(i5)).intValue());
        }
        return i4;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += C0156m.Z(((Long) list.get(i5)).longValue());
        }
        return i4;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = ((Integer) list.get(i5)).intValue();
            i4 += C0156m.Y((intValue >> 31) ^ (intValue << 1));
        }
        return i4;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            long longValue = ((Long) list.get(i5)).longValue();
            i4 += C0156m.Z((longValue >> 63) ^ (longValue << 1));
        }
        return i4;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += C0156m.Y(((Integer) list.get(i5)).intValue());
        }
        return i4;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += C0156m.Z(((Long) list.get(i5)).longValue());
        }
        return i4;
    }

    public static void k(e0 e0Var, Object obj, Object obj2) {
        e0Var.getClass();
        AbstractC0165w abstractC0165w = (AbstractC0165w) obj;
        d0 d0Var = abstractC0165w.unknownFields;
        d0 d0Var2 = ((AbstractC0165w) obj2).unknownFields;
        d0 d0Var3 = d0.f2626f;
        if (!d0Var3.equals(d0Var2)) {
            if (d0Var3.equals(d0Var)) {
                int i4 = d0Var.f2627a + d0Var2.f2627a;
                int[] copyOf = Arrays.copyOf(d0Var.f2628b, i4);
                System.arraycopy(d0Var2.f2628b, 0, copyOf, d0Var.f2627a, d0Var2.f2627a);
                Object[] copyOf2 = Arrays.copyOf(d0Var.f2629c, i4);
                System.arraycopy(d0Var2.f2629c, 0, copyOf2, d0Var.f2627a, d0Var2.f2627a);
                d0Var = new d0(i4, copyOf, copyOf2, true);
            } else {
                d0Var.getClass();
                if (!d0Var2.equals(d0Var3)) {
                    if (d0Var.f2631e) {
                        int i5 = d0Var.f2627a + d0Var2.f2627a;
                        d0Var.a(i5);
                        System.arraycopy(d0Var2.f2628b, 0, d0Var.f2628b, d0Var.f2627a, d0Var2.f2627a);
                        System.arraycopy(d0Var2.f2629c, 0, d0Var.f2629c, d0Var.f2627a, d0Var2.f2627a);
                        d0Var.f2627a = i5;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        abstractC0165w.unknownFields = d0Var;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void m(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    ((Boolean) list.get(i7)).getClass();
                    Logger logger = C0156m.f2669i;
                    i6++;
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.c0(((Boolean) list.get(i5)).booleanValue() ? (byte) 1 : (byte) 0);
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.e0(i4, ((Boolean) list.get(i5)).booleanValue());
                i5++;
            }
        }
    }

    public static void n(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    ((Double) list.get(i7)).getClass();
                    Logger logger = C0156m.f2669i;
                    i6 += 8;
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.k0(Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                double doubleValue = ((Double) list.get(i5)).doubleValue();
                c0156m.getClass();
                c0156m.j0(Double.doubleToRawLongBits(doubleValue), i4);
                i5++;
            }
        }
    }

    public static void o(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    i6 += C0156m.Z(((Integer) list.get(i7)).intValue());
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.m0(((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.l0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public static void p(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    ((Integer) list.get(i7)).getClass();
                    Logger logger = C0156m.f2669i;
                    i6 += 4;
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.i0(((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.h0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public static void q(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    ((Long) list.get(i7)).getClass();
                    Logger logger = C0156m.f2669i;
                    i6 += 8;
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.k0(((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.j0(((Long) list.get(i5)).longValue(), i4);
                i5++;
            }
        }
    }

    public static void r(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    ((Float) list.get(i7)).getClass();
                    Logger logger = C0156m.f2669i;
                    i6 += 4;
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.i0(Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                float floatValue = ((Float) list.get(i5)).floatValue();
                c0156m.getClass();
                c0156m.h0(i4, Float.floatToRawIntBits(floatValue));
                i5++;
            }
        }
    }

    public static void s(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    i6 += C0156m.Z(((Integer) list.get(i7)).intValue());
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.m0(((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.l0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public static void t(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    i6 += C0156m.Z(((Long) list.get(i7)).longValue());
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.u0(((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.t0(((Long) list.get(i5)).longValue(), i4);
                i5++;
            }
        }
    }

    public static void u(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    ((Integer) list.get(i7)).getClass();
                    Logger logger = C0156m.f2669i;
                    i6 += 4;
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.i0(((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.h0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public static void v(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    ((Long) list.get(i7)).getClass();
                    Logger logger = C0156m.f2669i;
                    i6 += 8;
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.k0(((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.j0(((Long) list.get(i5)).longValue(), i4);
                i5++;
            }
        }
    }

    public static void w(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    int intValue = ((Integer) list.get(i7)).intValue();
                    i6 += C0156m.Y((intValue >> 31) ^ (intValue << 1));
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    int intValue2 = ((Integer) list.get(i5)).intValue();
                    c0156m.s0((intValue2 >> 31) ^ (intValue2 << 1));
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                int intValue3 = ((Integer) list.get(i5)).intValue();
                c0156m.r0(i4, (intValue3 >> 31) ^ (intValue3 << 1));
                i5++;
            }
        }
    }

    public static void x(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    long longValue = ((Long) list.get(i7)).longValue();
                    i6 += C0156m.Z((longValue >> 63) ^ (longValue << 1));
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    long longValue2 = ((Long) list.get(i5)).longValue();
                    c0156m.u0((longValue2 >> 63) ^ (longValue2 << 1));
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                long longValue3 = ((Long) list.get(i5)).longValue();
                c0156m.t0((longValue3 >> 63) ^ (longValue3 << 1), i4);
                i5++;
            }
        }
    }

    public static void y(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    i6 += C0156m.Y(((Integer) list.get(i7)).intValue());
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.s0(((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.r0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public static void z(int i4, List list, F f4, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0156m c0156m = (C0156m) f4.f2563a;
            int i5 = 0;
            if (z) {
                c0156m.q0(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    i6 += C0156m.Z(((Long) list.get(i7)).longValue());
                }
                c0156m.s0(i6);
                while (i5 < list.size()) {
                    c0156m.u0(((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                c0156m.t0(((Long) list.get(i5)).longValue(), i4);
                i5++;
            }
        }
    }

    public static Object j(Object obj, int i4, InterfaceC0166x interfaceC0166x, Object obj2, e0 e0Var) {
        return obj2;
    }
}
