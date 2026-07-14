package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class X {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f1384a;

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f1385b;

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f1386c;

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.datastore.preferences.protobuf.e0, java.lang.Object] */
    static {
        Class<?> cls;
        Class<?> cls2;
        T t2 = T.f1374c;
        e0 e0Var = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f1384a = cls;
        try {
            T t3 = T.f1374c;
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
        f1385b = e0Var;
        f1386c = new Object();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += C0086m.W(((Integer) list.get(i3)).intValue());
        }
        return i2;
    }

    public static int b(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0086m.U(i2) + 4) * size;
    }

    public static int c(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (C0086m.U(i2) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += C0086m.W(((Integer) list.get(i3)).intValue());
        }
        return i2;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += C0086m.W(((Long) list.get(i3)).longValue());
        }
        return i2;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = ((Integer) list.get(i3)).intValue();
            i2 += C0086m.V((intValue >> 31) ^ (intValue << 1));
        }
        return i2;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            long longValue = ((Long) list.get(i3)).longValue();
            i2 += C0086m.W((longValue >> 63) ^ (longValue << 1));
        }
        return i2;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += C0086m.V(((Integer) list.get(i3)).intValue());
        }
        return i2;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += C0086m.W(((Long) list.get(i3)).longValue());
        }
        return i2;
    }

    public static void k(e0 e0Var, Object obj, Object obj2) {
        e0Var.getClass();
        AbstractC0095w abstractC0095w = (AbstractC0095w) obj;
        d0 d0Var = abstractC0095w.unknownFields;
        d0 d0Var2 = ((AbstractC0095w) obj2).unknownFields;
        d0 d0Var3 = d0.f1408f;
        if (!d0Var3.equals(d0Var2)) {
            if (d0Var3.equals(d0Var)) {
                int i2 = d0Var.f1409a + d0Var2.f1409a;
                int[] copyOf = Arrays.copyOf(d0Var.f1410b, i2);
                System.arraycopy(d0Var2.f1410b, 0, copyOf, d0Var.f1409a, d0Var2.f1409a);
                Object[] copyOf2 = Arrays.copyOf(d0Var.f1411c, i2);
                System.arraycopy(d0Var2.f1411c, 0, copyOf2, d0Var.f1409a, d0Var2.f1409a);
                d0Var = new d0(i2, copyOf, copyOf2, true);
            } else {
                d0Var.getClass();
                if (!d0Var2.equals(d0Var3)) {
                    if (d0Var.f1413e) {
                        int i3 = d0Var.f1409a + d0Var2.f1409a;
                        d0Var.a(i3);
                        System.arraycopy(d0Var2.f1410b, 0, d0Var.f1410b, d0Var.f1409a, d0Var2.f1409a);
                        System.arraycopy(d0Var2.f1411c, 0, d0Var.f1411c, d0Var.f1409a, d0Var2.f1409a);
                        d0Var.f1409a = i3;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        abstractC0095w.unknownFields = d0Var;
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

    public static void m(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Boolean) list.get(i5)).getClass();
                    Logger logger = C0086m.f1452k;
                    i4++;
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.Z(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.b0(i2, ((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
        }
    }

    public static void n(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Double) list.get(i5)).getClass();
                    Logger logger = C0086m.f1452k;
                    i4 += 8;
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.h0(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                double doubleValue = ((Double) list.get(i3)).doubleValue();
                c0086m.getClass();
                c0086m.g0(i2, Double.doubleToRawLongBits(doubleValue));
                i3++;
            }
        }
    }

    public static void o(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0086m.W(((Integer) list.get(i5)).intValue());
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.j0(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.i0(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void p(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Integer) list.get(i5)).getClass();
                    Logger logger = C0086m.f1452k;
                    i4 += 4;
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.f0(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.e0(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void q(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Long) list.get(i5)).getClass();
                    Logger logger = C0086m.f1452k;
                    i4 += 8;
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.h0(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.g0(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void r(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Float) list.get(i5)).getClass();
                    Logger logger = C0086m.f1452k;
                    i4 += 4;
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.f0(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                float floatValue = ((Float) list.get(i3)).floatValue();
                c0086m.getClass();
                c0086m.e0(i2, Float.floatToRawIntBits(floatValue));
                i3++;
            }
        }
    }

    public static void s(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0086m.W(((Integer) list.get(i5)).intValue());
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.j0(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.i0(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void t(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0086m.W(((Long) list.get(i5)).longValue());
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.r0(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.q0(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void u(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Integer) list.get(i5)).getClass();
                    Logger logger = C0086m.f1452k;
                    i4 += 4;
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.f0(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.e0(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void v(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ((Long) list.get(i5)).getClass();
                    Logger logger = C0086m.f1452k;
                    i4 += 8;
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.h0(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.g0(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static void w(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    int intValue = ((Integer) list.get(i5)).intValue();
                    i4 += C0086m.V((intValue >> 31) ^ (intValue << 1));
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    int intValue2 = ((Integer) list.get(i3)).intValue();
                    c0086m.p0((intValue2 >> 31) ^ (intValue2 << 1));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                int intValue3 = ((Integer) list.get(i3)).intValue();
                c0086m.o0(i2, (intValue3 >> 31) ^ (intValue3 << 1));
                i3++;
            }
        }
    }

    public static void x(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    long longValue = ((Long) list.get(i5)).longValue();
                    i4 += C0086m.W((longValue >> 63) ^ (longValue << 1));
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    long longValue2 = ((Long) list.get(i3)).longValue();
                    c0086m.r0((longValue2 >> 63) ^ (longValue2 << 1));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                long longValue3 = ((Long) list.get(i3)).longValue();
                c0086m.q0(i2, (longValue3 >> 63) ^ (longValue3 << 1));
                i3++;
            }
        }
    }

    public static void y(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0086m.V(((Integer) list.get(i5)).intValue());
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.p0(((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.o0(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
    }

    public static void z(int i2, List list, F f2, boolean z) {
        if (list != null && !list.isEmpty()) {
            C0086m c0086m = (C0086m) f2.f1343a;
            int i3 = 0;
            if (z) {
                c0086m.n0(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += C0086m.W(((Long) list.get(i5)).longValue());
                }
                c0086m.p0(i4);
                while (i3 < list.size()) {
                    c0086m.r0(((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                c0086m.q0(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
        }
    }

    public static Object j(Object obj, int i2, InterfaceC0096x interfaceC0096x, Object obj2, e0 e0Var) {
        return obj2;
    }
}
