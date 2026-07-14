package W1;

import b2.C0223a;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* renamed from: W1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0124o extends C0223a {

    /* renamed from: y, reason: collision with root package name */
    public static final C0123n f1949y = new C0123n();
    public static final Object z = new Object();

    /* renamed from: u, reason: collision with root package name */
    public Object[] f1950u;

    /* renamed from: v, reason: collision with root package name */
    public int f1951v;

    /* renamed from: w, reason: collision with root package name */
    public String[] f1952w;

    /* renamed from: x, reason: collision with root package name */
    public int[] f1953x;

    @Override // b2.C0223a
    public final void D() {
        int b4 = R.i.b(x());
        if (b4 != 1) {
            if (b4 != 9) {
                if (b4 != 3) {
                    if (b4 != 4) {
                        L();
                        int i4 = this.f1951v;
                        if (i4 > 0) {
                            int[] iArr = this.f1953x;
                            int i5 = i4 - 1;
                            iArr[i5] = iArr[i5] + 1;
                            return;
                        }
                        return;
                    }
                    J(true);
                    return;
                }
                f();
                return;
            }
            return;
        }
        e();
    }

    public final void G(int i4) {
        if (x() == i4) {
            return;
        }
        throw new IllegalStateException("Expected " + A2.i.s(i4) + " but was " + A2.i.s(x()) + I());
    }

    public final String H(boolean z3) {
        StringBuilder sb = new StringBuilder("$");
        int i4 = 0;
        while (true) {
            int i5 = this.f1951v;
            if (i4 < i5) {
                Object[] objArr = this.f1950u;
                Object obj = objArr[i4];
                if (obj instanceof T1.f) {
                    i4++;
                    if (i4 < i5 && (objArr[i4] instanceof Iterator)) {
                        int i6 = this.f1953x[i4];
                        if (z3 && i6 > 0 && (i4 == i5 - 1 || i4 == i5 - 2)) {
                            i6--;
                        }
                        sb.append('[');
                        sb.append(i6);
                        sb.append(']');
                    }
                } else if ((obj instanceof T1.k) && (i4 = i4 + 1) < i5 && (objArr[i4] instanceof Iterator)) {
                    sb.append('.');
                    String str = this.f1952w[i4];
                    if (str != null) {
                        sb.append(str);
                    }
                }
                i4++;
            } else {
                return sb.toString();
            }
        }
    }

    public final String I() {
        return " at path " + H(false);
    }

    public final String J(boolean z3) {
        String str;
        G(5);
        Map.Entry entry = (Map.Entry) ((Iterator) K()).next();
        String str2 = (String) entry.getKey();
        String[] strArr = this.f1952w;
        int i4 = this.f1951v - 1;
        if (z3) {
            str = "<skipped>";
        } else {
            str = str2;
        }
        strArr[i4] = str;
        M(entry.getValue());
        return str2;
    }

    public final Object K() {
        return this.f1950u[this.f1951v - 1];
    }

    public final Object L() {
        Object[] objArr = this.f1950u;
        int i4 = this.f1951v - 1;
        this.f1951v = i4;
        Object obj = objArr[i4];
        objArr[i4] = null;
        return obj;
    }

    public final void M(Object obj) {
        int i4 = this.f1951v;
        Object[] objArr = this.f1950u;
        if (i4 == objArr.length) {
            int i5 = i4 * 2;
            this.f1950u = Arrays.copyOf(objArr, i5);
            this.f1953x = Arrays.copyOf(this.f1953x, i5);
            this.f1952w = (String[]) Arrays.copyOf(this.f1952w, i5);
        }
        Object[] objArr2 = this.f1950u;
        int i6 = this.f1951v;
        this.f1951v = i6 + 1;
        objArr2[i6] = obj;
    }

    @Override // b2.C0223a
    public final void a() {
        G(1);
        M(((T1.f) K()).f1619f.iterator());
        this.f1953x[this.f1951v - 1] = 0;
    }

    @Override // b2.C0223a
    public final void b() {
        G(3);
        M(((V1.m) ((T1.k) K()).f1621f.entrySet()).iterator());
    }

    @Override // b2.C0223a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1950u = new Object[]{z};
        this.f1951v = 1;
    }

    @Override // b2.C0223a
    public final void e() {
        G(2);
        L();
        L();
        int i4 = this.f1951v;
        if (i4 > 0) {
            int[] iArr = this.f1953x;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // b2.C0223a
    public final void f() {
        G(4);
        this.f1952w[this.f1951v - 1] = null;
        L();
        L();
        int i4 = this.f1951v;
        if (i4 > 0) {
            int[] iArr = this.f1953x;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // b2.C0223a
    public final String h() {
        return H(false);
    }

    @Override // b2.C0223a
    public final String j() {
        return H(true);
    }

    @Override // b2.C0223a
    public final boolean k() {
        int x3 = x();
        if (x3 != 4 && x3 != 2 && x3 != 10) {
            return true;
        }
        return false;
    }

    @Override // b2.C0223a
    public final boolean n() {
        G(8);
        boolean a4 = ((T1.l) L()).a();
        int i4 = this.f1951v;
        if (i4 > 0) {
            int[] iArr = this.f1953x;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return a4;
    }

    @Override // b2.C0223a
    public final double o() {
        int x3 = x();
        if (x3 != 7 && x3 != 6) {
            throw new IllegalStateException("Expected " + A2.i.s(7) + " but was " + A2.i.s(x3) + I());
        }
        double e4 = ((T1.l) K()).e();
        if (this.f3222t == 1 || (!Double.isNaN(e4) && !Double.isInfinite(e4))) {
            L();
            int i4 = this.f1951v;
            if (i4 > 0) {
                int[] iArr = this.f1953x;
                int i5 = i4 - 1;
                iArr[i5] = iArr[i5] + 1;
            }
            return e4;
        }
        throw new IOException("JSON forbids NaN and infinities: " + e4);
    }

    @Override // b2.C0223a
    public final int p() {
        int parseInt;
        int x3 = x();
        if (x3 != 7 && x3 != 6) {
            throw new IllegalStateException("Expected " + A2.i.s(7) + " but was " + A2.i.s(x3) + I());
        }
        T1.l lVar = (T1.l) K();
        if (lVar.f1622f instanceof Number) {
            parseInt = lVar.f().intValue();
        } else {
            parseInt = Integer.parseInt(lVar.c());
        }
        L();
        int i4 = this.f1951v;
        if (i4 > 0) {
            int[] iArr = this.f1953x;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return parseInt;
    }

    @Override // b2.C0223a
    public final long q() {
        long parseLong;
        int x3 = x();
        if (x3 != 7 && x3 != 6) {
            throw new IllegalStateException("Expected " + A2.i.s(7) + " but was " + A2.i.s(x3) + I());
        }
        T1.l lVar = (T1.l) K();
        if (lVar.f1622f instanceof Number) {
            parseLong = lVar.f().longValue();
        } else {
            parseLong = Long.parseLong(lVar.c());
        }
        L();
        int i4 = this.f1951v;
        if (i4 > 0) {
            int[] iArr = this.f1953x;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return parseLong;
    }

    @Override // b2.C0223a
    public final String r() {
        return J(false);
    }

    @Override // b2.C0223a
    public final void t() {
        G(9);
        L();
        int i4 = this.f1951v;
        if (i4 > 0) {
            int[] iArr = this.f1953x;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // b2.C0223a
    public final String toString() {
        return C0124o.class.getSimpleName() + I();
    }

    @Override // b2.C0223a
    public final String v() {
        int x3 = x();
        if (x3 != 6 && x3 != 7) {
            throw new IllegalStateException("Expected " + A2.i.s(6) + " but was " + A2.i.s(x3) + I());
        }
        String c4 = ((T1.l) L()).c();
        int i4 = this.f1951v;
        if (i4 > 0) {
            int[] iArr = this.f1953x;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return c4;
    }

    @Override // b2.C0223a
    public final int x() {
        if (this.f1951v == 0) {
            return 10;
        }
        Object K3 = K();
        if (K3 instanceof Iterator) {
            boolean z3 = this.f1950u[this.f1951v - 2] instanceof T1.k;
            Iterator it = (Iterator) K3;
            if (it.hasNext()) {
                if (z3) {
                    return 5;
                }
                M(it.next());
                return x();
            }
            if (!z3) {
                return 2;
            }
            return 4;
        }
        if (K3 instanceof T1.k) {
            return 3;
        }
        if (K3 instanceof T1.f) {
            return 1;
        }
        if (K3 instanceof T1.l) {
            Serializable serializable = ((T1.l) K3).f1622f;
            if (serializable instanceof String) {
                return 6;
            }
            if (serializable instanceof Boolean) {
                return 8;
            }
            if (serializable instanceof Number) {
                return 7;
            }
            throw new AssertionError();
        }
        if (K3 instanceof T1.j) {
            return 9;
        }
        if (K3 == z) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new IOException("Custom JsonElement subclass " + K3.getClass().getName() + " is not supported");
    }
}
