package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class N implements W {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f2574n = new int[0];

    /* renamed from: o, reason: collision with root package name */
    public static final Unsafe f2575o = j0.i();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2576a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2577b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2578c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2579d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0144a f2580e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2581f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f2582g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2583h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2584i;

    /* renamed from: j, reason: collision with root package name */
    public final P f2585j;
    public final C k;

    /* renamed from: l, reason: collision with root package name */
    public final e0 f2586l;

    /* renamed from: m, reason: collision with root package name */
    public final J f2587m;

    public N(int[] iArr, Object[] objArr, int i4, int i5, AbstractC0144a abstractC0144a, int[] iArr2, int i6, int i7, P p3, C c4, e0 e0Var, C0159p c0159p, J j4) {
        this.f2576a = iArr;
        this.f2577b = objArr;
        this.f2578c = i4;
        this.f2579d = i5;
        this.f2581f = abstractC0144a instanceof AbstractC0165w;
        this.f2582g = iArr2;
        this.f2583h = i6;
        this.f2584i = i7;
        this.f2585j = p3;
        this.k = c4;
        this.f2586l = e0Var;
        this.f2580e = abstractC0144a;
        this.f2587m = j4;
    }

    public static Field F(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static int K(int i4) {
        return (i4 & 267386880) >>> 20;
    }

    public static boolean p(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC0165w) {
            return ((AbstractC0165w) obj).g();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.datastore.preferences.protobuf.N w(androidx.datastore.preferences.protobuf.V r34, androidx.datastore.preferences.protobuf.P r35, androidx.datastore.preferences.protobuf.C r36, androidx.datastore.preferences.protobuf.e0 r37, androidx.datastore.preferences.protobuf.C0159p r38, androidx.datastore.preferences.protobuf.J r39) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.w(androidx.datastore.preferences.protobuf.V, androidx.datastore.preferences.protobuf.P, androidx.datastore.preferences.protobuf.C, androidx.datastore.preferences.protobuf.e0, androidx.datastore.preferences.protobuf.p, androidx.datastore.preferences.protobuf.J):androidx.datastore.preferences.protobuf.N");
    }

    public static long x(int i4) {
        return i4 & 1048575;
    }

    public static int y(long j4, Object obj) {
        return ((Integer) j0.f2659c.h(j4, obj)).intValue();
    }

    public static long z(long j4, Object obj) {
        return ((Long) j0.f2659c.h(j4, obj)).longValue();
    }

    public final int A(int i4) {
        if (i4 >= this.f2578c && i4 <= this.f2579d) {
            int[] iArr = this.f2576a;
            int length = (iArr.length / 3) - 1;
            int i5 = 0;
            while (i5 <= length) {
                int i6 = (length + i5) >>> 1;
                int i7 = i6 * 3;
                int i8 = iArr[i7];
                if (i4 == i8) {
                    return i7;
                }
                if (i4 < i8) {
                    length = i6 - 1;
                } else {
                    i5 = i6 + 1;
                }
            }
        }
        return -1;
    }

    public final void B(Object obj, long j4, C0154k c0154k, W w2, C0158o c0158o) {
        int u3;
        this.k.getClass();
        InterfaceC0166x a4 = C.a(j4, obj);
        AbstractC0153j abstractC0153j = c0154k.f2664a;
        int i4 = c0154k.f2665b;
        if ((i4 & 7) != 3) {
            throw A.b();
        }
        do {
            AbstractC0165w i5 = w2.i();
            c0154k.b(i5, w2, c0158o);
            w2.d(i5);
            ((U) a4).add(i5);
            if (!abstractC0153j.c() && c0154k.f2667d == 0) {
                u3 = abstractC0153j.u();
            } else {
                return;
            }
        } while (u3 == i4);
        c0154k.f2667d = u3;
    }

    public final void C(Object obj, int i4, C0154k c0154k, W w2, C0158o c0158o) {
        int u3;
        this.k.getClass();
        InterfaceC0166x a4 = C.a(i4 & 1048575, obj);
        AbstractC0153j abstractC0153j = c0154k.f2664a;
        int i5 = c0154k.f2665b;
        if ((i5 & 7) != 2) {
            throw A.b();
        }
        do {
            AbstractC0165w i6 = w2.i();
            c0154k.c(i6, w2, c0158o);
            w2.d(i6);
            ((U) a4).add(i6);
            if (!abstractC0153j.c() && c0154k.f2667d == 0) {
                u3 = abstractC0153j.u();
            } else {
                return;
            }
        } while (u3 == i5);
        c0154k.f2667d = u3;
    }

    public final void D(int i4, C0154k c0154k, Object obj) {
        AbstractC0153j abstractC0153j = c0154k.f2664a;
        if ((536870912 & i4) != 0) {
            c0154k.w(2);
            j0.o(i4 & 1048575, obj, abstractC0153j.t());
        } else if (this.f2581f) {
            c0154k.w(2);
            j0.o(i4 & 1048575, obj, abstractC0153j.s());
        } else {
            j0.o(i4 & 1048575, obj, c0154k.e());
        }
    }

    public final void E(int i4, C0154k c0154k, Object obj) {
        int i5 = 536870912 & i4;
        C c4 = this.k;
        if (i5 != 0) {
            c4.getClass();
            c0154k.s(C.a(i4 & 1048575, obj), true);
        } else {
            c4.getClass();
            c0154k.s(C.a(i4 & 1048575, obj), false);
        }
    }

    public final void G(int i4, Object obj) {
        int i5 = this.f2576a[i4 + 2];
        long j4 = 1048575 & i5;
        if (j4 == 1048575) {
            return;
        }
        j0.m(obj, j4, (1 << (i5 >>> 20)) | j0.f2659c.f(j4, obj));
    }

    public final void H(Object obj, int i4, int i5) {
        j0.m(obj, this.f2576a[i5 + 2] & 1048575, i4);
    }

    public final void I(Object obj, int i4, AbstractC0144a abstractC0144a) {
        f2575o.putObject(obj, L(i4) & 1048575, abstractC0144a);
        G(i4, obj);
    }

    public final void J(Object obj, int i4, int i5, AbstractC0144a abstractC0144a) {
        f2575o.putObject(obj, L(i5) & 1048575, abstractC0144a);
        H(obj, i4, i5);
    }

    public final int L(int i4) {
        return this.f2576a[i4 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0045. Please report as an issue. */
    public final void M(Object obj, F f4) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        N n3 = this;
        int[] iArr = n3.f2576a;
        int length = iArr.length;
        Unsafe unsafe = f2575o;
        int i8 = 1048575;
        int i9 = 1048575;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int L3 = n3.L(i10);
            int i12 = iArr[i10];
            int K3 = K(L3);
            if (K3 <= 17) {
                int i13 = iArr[i10 + 2];
                int i14 = i13 & i8;
                if (i14 != i9) {
                    if (i14 == i8) {
                        i11 = 0;
                    } else {
                        i11 = unsafe.getInt(obj, i14);
                    }
                    i9 = i14;
                }
                i4 = L3;
                i5 = 1 << (i13 >>> 20);
            } else {
                i4 = L3;
                i5 = 0;
            }
            long j4 = i4 & i8;
            switch (K3) {
                case 0:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        double d4 = j0.f2659c.d(j4, obj);
                        C0156m c0156m = (C0156m) f4.f2563a;
                        c0156m.getClass();
                        c0156m.j0(Double.doubleToRawLongBits(d4), i12);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        float e4 = j0.f2659c.e(j4, obj);
                        C0156m c0156m2 = (C0156m) f4.f2563a;
                        c0156m2.getClass();
                        c0156m2.h0(i12, Float.floatToRawIntBits(e4));
                    }
                    n3 = this;
                    break;
                case 2:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).t0(unsafe.getLong(obj, j4), i12);
                    }
                    n3 = this;
                    break;
                case 3:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).t0(unsafe.getLong(obj, j4), i12);
                    }
                    n3 = this;
                    break;
                case 4:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).l0(i12, unsafe.getInt(obj, j4));
                    }
                    n3 = this;
                    break;
                case 5:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).j0(unsafe.getLong(obj, j4), i12);
                    }
                    n3 = this;
                    break;
                case 6:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).h0(i12, unsafe.getInt(obj, j4));
                    }
                    n3 = this;
                    break;
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).e0(i12, j0.f2659c.c(j4, obj));
                    }
                    n3 = this;
                    break;
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        Object object = unsafe.getObject(obj, j4);
                        if (object instanceof String) {
                            ((C0156m) f4.f2563a).o0(i12, (String) object);
                        } else {
                            ((C0156m) f4.f2563a).f0(i12, (C0150g) object);
                        }
                    }
                    n3 = this;
                    break;
                case 9:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).n0(i12, (AbstractC0144a) unsafe.getObject(obj, j4), n3.m(i10));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).f0(i12, (C0150g) unsafe.getObject(obj, j4));
                    }
                    n3 = this;
                    break;
                case 11:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).r0(i12, unsafe.getInt(obj, j4));
                    }
                    n3 = this;
                    break;
                case 12:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).l0(i12, unsafe.getInt(obj, j4));
                    }
                    n3 = this;
                    break;
                case 13:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).h0(i12, unsafe.getInt(obj, j4));
                    }
                    n3 = this;
                    break;
                case 14:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        ((C0156m) f4.f2563a).j0(unsafe.getLong(obj, j4), i12);
                    }
                    n3 = this;
                    break;
                case 15:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        int i15 = unsafe.getInt(obj, j4);
                        ((C0156m) f4.f2563a).r0(i12, (i15 >> 31) ^ (i15 << 1));
                    }
                    n3 = this;
                    break;
                case 16:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        long j5 = unsafe.getLong(obj, j4);
                        ((C0156m) f4.f2563a).t0((j5 >> 63) ^ (j5 << 1), i12);
                    }
                    n3 = this;
                    break;
                case 17:
                    if (n3.o(obj, i10, i9, i11, i5)) {
                        f4.a(i12, unsafe.getObject(obj, j4), n3.m(i10));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i6 = i9;
                    X.n(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 19:
                    i6 = i9;
                    X.r(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 20:
                    i6 = i9;
                    X.t(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 21:
                    i6 = i9;
                    X.z(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 22:
                    i6 = i9;
                    X.s(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 23:
                    i6 = i9;
                    X.q(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 24:
                    i6 = i9;
                    X.p(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 25:
                    i6 = i9;
                    X.m(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 26:
                    i7 = i9;
                    int i16 = iArr[i10];
                    List list = (List) unsafe.getObject(obj, j4);
                    Class cls = X.f2603a;
                    if (list != null && !list.isEmpty()) {
                        f4.getClass();
                        for (int i17 = 0; i17 < list.size(); i17++) {
                            ((C0156m) f4.f2563a).o0(i16, (String) list.get(i17));
                        }
                    }
                    i9 = i7;
                    break;
                case 27:
                    i7 = i9;
                    int i18 = iArr[i10];
                    List list2 = (List) unsafe.getObject(obj, j4);
                    W m3 = n3.m(i10);
                    Class cls2 = X.f2603a;
                    if (list2 != null && !list2.isEmpty()) {
                        f4.getClass();
                        for (int i19 = 0; i19 < list2.size(); i19++) {
                            ((C0156m) f4.f2563a).n0(i18, (AbstractC0144a) list2.get(i19), m3);
                        }
                    }
                    i9 = i7;
                    break;
                case 28:
                    i7 = i9;
                    int i20 = iArr[i10];
                    List list3 = (List) unsafe.getObject(obj, j4);
                    Class cls3 = X.f2603a;
                    if (list3 != null && !list3.isEmpty()) {
                        f4.getClass();
                        for (int i21 = 0; i21 < list3.size(); i21++) {
                            ((C0156m) f4.f2563a).f0(i20, (C0150g) list3.get(i21));
                        }
                    }
                    i9 = i7;
                    break;
                case 29:
                    i6 = i9;
                    z = false;
                    X.y(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 30:
                    i6 = i9;
                    z = false;
                    X.o(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 31:
                    i6 = i9;
                    z = false;
                    X.u(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 32:
                    i6 = i9;
                    z = false;
                    X.v(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 33:
                    i6 = i9;
                    z = false;
                    X.w(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 34:
                    i6 = i9;
                    z = false;
                    X.x(iArr[i10], (List) unsafe.getObject(obj, j4), f4, false);
                    i9 = i6;
                    break;
                case 35:
                    i7 = i9;
                    X.n(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 36:
                    i7 = i9;
                    X.r(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 37:
                    i7 = i9;
                    X.t(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 38:
                    i7 = i9;
                    X.z(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 39:
                    i7 = i9;
                    X.s(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 40:
                    i7 = i9;
                    X.q(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 41:
                    i7 = i9;
                    X.p(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 42:
                    i7 = i9;
                    X.m(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 43:
                    i7 = i9;
                    X.y(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 44:
                    i7 = i9;
                    X.o(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 45:
                    i7 = i9;
                    X.u(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 46:
                    i7 = i9;
                    X.v(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 47:
                    i7 = i9;
                    X.w(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 48:
                    i7 = i9;
                    X.x(iArr[i10], (List) unsafe.getObject(obj, j4), f4, true);
                    i9 = i7;
                    break;
                case 49:
                    i7 = i9;
                    int i22 = iArr[i10];
                    List list4 = (List) unsafe.getObject(obj, j4);
                    W m4 = n3.m(i10);
                    Class cls4 = X.f2603a;
                    if (list4 != null && !list4.isEmpty()) {
                        f4.getClass();
                        for (int i23 = 0; i23 < list4.size(); i23++) {
                            f4.a(i22, list4.get(i23), m4);
                        }
                    }
                    i9 = i7;
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j4);
                    if (object2 != null) {
                        int i24 = 2;
                        Object obj2 = n3.f2577b[(i10 / 3) * 2];
                        n3.f2587m.getClass();
                        G g4 = ((H) obj2).f2567a;
                        C0156m c0156m3 = (C0156m) f4.f2563a;
                        c0156m3.getClass();
                        for (Map.Entry entry : ((I) object2).entrySet()) {
                            c0156m3.q0(i12, i24);
                            c0156m3.s0(H.a(g4, entry.getKey(), entry.getValue()));
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            r.b(c0156m3, g4.f2564a, 1, key);
                            i24 = 2;
                            r.b(c0156m3, g4.f2565b, 2, value);
                            i9 = i9;
                        }
                    }
                    i7 = i9;
                    i9 = i7;
                    break;
                case 51:
                    if (n3.q(obj, i12, i10)) {
                        double doubleValue = ((Double) j0.f2659c.h(j4, obj)).doubleValue();
                        C0156m c0156m4 = (C0156m) f4.f2563a;
                        c0156m4.getClass();
                        c0156m4.j0(Double.doubleToRawLongBits(doubleValue), i12);
                    }
                    break;
                case 52:
                    if (n3.q(obj, i12, i10)) {
                        float floatValue = ((Float) j0.f2659c.h(j4, obj)).floatValue();
                        C0156m c0156m5 = (C0156m) f4.f2563a;
                        c0156m5.getClass();
                        c0156m5.h0(i12, Float.floatToRawIntBits(floatValue));
                    }
                    break;
                case 53:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).t0(z(j4, obj), i12);
                    }
                    break;
                case 54:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).t0(z(j4, obj), i12);
                    }
                    break;
                case 55:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).l0(i12, y(j4, obj));
                    }
                    break;
                case 56:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).j0(z(j4, obj), i12);
                    }
                    break;
                case 57:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).h0(i12, y(j4, obj));
                    }
                    break;
                case 58:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).e0(i12, ((Boolean) j0.f2659c.h(j4, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (n3.q(obj, i12, i10)) {
                        Object object3 = unsafe.getObject(obj, j4);
                        if (object3 instanceof String) {
                            ((C0156m) f4.f2563a).o0(i12, (String) object3);
                        } else {
                            ((C0156m) f4.f2563a).f0(i12, (C0150g) object3);
                        }
                    }
                    break;
                case 60:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).n0(i12, (AbstractC0144a) unsafe.getObject(obj, j4), n3.m(i10));
                    }
                    break;
                case 61:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).f0(i12, (C0150g) unsafe.getObject(obj, j4));
                    }
                    break;
                case 62:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).r0(i12, y(j4, obj));
                    }
                    break;
                case 63:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).l0(i12, y(j4, obj));
                    }
                    break;
                case 64:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).h0(i12, y(j4, obj));
                    }
                    break;
                case 65:
                    if (n3.q(obj, i12, i10)) {
                        ((C0156m) f4.f2563a).j0(z(j4, obj), i12);
                    }
                    break;
                case 66:
                    if (n3.q(obj, i12, i10)) {
                        int y3 = y(j4, obj);
                        ((C0156m) f4.f2563a).r0(i12, (y3 >> 31) ^ (y3 << 1));
                    }
                    break;
                case 67:
                    if (n3.q(obj, i12, i10)) {
                        long z3 = z(j4, obj);
                        ((C0156m) f4.f2563a).t0((z3 << 1) ^ (z3 >> 63), i12);
                    }
                    break;
                case 68:
                    if (n3.q(obj, i12, i10)) {
                        f4.a(i12, unsafe.getObject(obj, j4), n3.m(i10));
                    }
                    break;
            }
            i10 += 3;
            i8 = 1048575;
        }
        n3.f2586l.getClass();
        ((AbstractC0165w) obj).unknownFields.d(f4);
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void a(Object obj, Object obj2) {
        Object obj3;
        if (p(obj)) {
            obj2.getClass();
            int i4 = 0;
            while (true) {
                int[] iArr = this.f2576a;
                if (i4 < iArr.length) {
                    int L3 = L(i4);
                    long j4 = 1048575 & L3;
                    int i5 = iArr[i4];
                    switch (K(L3)) {
                        case 0:
                            if (n(i4, obj2)) {
                                i0 i0Var = j0.f2659c;
                                obj3 = obj;
                                i0Var.l(obj3, j4, i0Var.d(j4, obj2));
                                G(i4, obj3);
                                break;
                            }
                            break;
                        case 1:
                            if (n(i4, obj2)) {
                                i0 i0Var2 = j0.f2659c;
                                i0Var2.m(obj, j4, i0Var2.e(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 2:
                            if (n(i4, obj2)) {
                                j0.n(obj, j4, j0.f2659c.g(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 3:
                            if (n(i4, obj2)) {
                                j0.n(obj, j4, j0.f2659c.g(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 4:
                            if (n(i4, obj2)) {
                                j0.m(obj, j4, j0.f2659c.f(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 5:
                            if (n(i4, obj2)) {
                                j0.n(obj, j4, j0.f2659c.g(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 6:
                            if (n(i4, obj2)) {
                                j0.m(obj, j4, j0.f2659c.f(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            if (n(i4, obj2)) {
                                i0 i0Var3 = j0.f2659c;
                                i0Var3.j(obj, j4, i0Var3.c(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case R.j.BYTES_FIELD_NUMBER /* 8 */:
                            if (n(i4, obj2)) {
                                j0.o(j4, obj, j0.f2659c.h(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 9:
                            s(i4, obj, obj2);
                            break;
                        case 10:
                            if (n(i4, obj2)) {
                                j0.o(j4, obj, j0.f2659c.h(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 11:
                            if (n(i4, obj2)) {
                                j0.m(obj, j4, j0.f2659c.f(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 12:
                            if (n(i4, obj2)) {
                                j0.m(obj, j4, j0.f2659c.f(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 13:
                            if (n(i4, obj2)) {
                                j0.m(obj, j4, j0.f2659c.f(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 14:
                            if (n(i4, obj2)) {
                                j0.n(obj, j4, j0.f2659c.g(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 15:
                            if (n(i4, obj2)) {
                                j0.m(obj, j4, j0.f2659c.f(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 16:
                            if (n(i4, obj2)) {
                                j0.n(obj, j4, j0.f2659c.g(j4, obj2));
                                G(i4, obj);
                                break;
                            }
                            break;
                        case 17:
                            s(i4, obj, obj2);
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.k.getClass();
                            i0 i0Var4 = j0.f2659c;
                            InterfaceC0166x interfaceC0166x = (InterfaceC0166x) i0Var4.h(j4, obj);
                            InterfaceC0166x interfaceC0166x2 = (InterfaceC0166x) i0Var4.h(j4, obj2);
                            U u3 = (U) interfaceC0166x;
                            int i6 = u3.f2598h;
                            int i7 = ((U) interfaceC0166x2).f2598h;
                            if (i6 > 0 && i7 > 0) {
                                if (!((AbstractC0145b) interfaceC0166x).f2618f) {
                                    interfaceC0166x = u3.c(i7 + i6);
                                }
                                ((AbstractC0145b) interfaceC0166x).addAll(interfaceC0166x2);
                            }
                            if (i6 > 0) {
                                interfaceC0166x2 = interfaceC0166x;
                            }
                            j0.o(j4, obj, interfaceC0166x2);
                            break;
                        case 50:
                            Class cls = X.f2603a;
                            i0 i0Var5 = j0.f2659c;
                            Object h3 = i0Var5.h(j4, obj);
                            Object h4 = i0Var5.h(j4, obj2);
                            this.f2587m.getClass();
                            j0.o(j4, obj, J.a(h3, h4));
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                            if (q(obj2, i5, i4)) {
                                j0.o(j4, obj, j0.f2659c.h(j4, obj2));
                                H(obj, i5, i4);
                                break;
                            }
                            break;
                        case 60:
                            t(i4, obj, obj2);
                            break;
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                            if (q(obj2, i5, i4)) {
                                j0.o(j4, obj, j0.f2659c.h(j4, obj2));
                                H(obj, i5, i4);
                                break;
                            }
                            break;
                        case 68:
                            t(i4, obj, obj2);
                            break;
                    }
                    obj3 = obj;
                    i4 += 3;
                    obj = obj3;
                } else {
                    X.k(this.f2586l, obj, obj2);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Mutating immutable message: " + obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void b(Object obj, F f4) {
        f4.getClass();
        M(obj, f4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0216, code lost:
    
        if (r4 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00df, code lost:
    
        if (r4 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e1, code lost:
    
        r8 = 1231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e2, code lost:
    
        r3 = r8 + r3;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001c. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.W
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(androidx.datastore.preferences.protobuf.AbstractC0165w r12) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.c(androidx.datastore.preferences.protobuf.w):int");
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void d(Object obj) {
        if (p(obj)) {
            if (obj instanceof AbstractC0165w) {
                AbstractC0165w abstractC0165w = (AbstractC0165w) obj;
                abstractC0165w.k(Integer.MAX_VALUE);
                abstractC0165w.memoizedHashCode = 0;
                abstractC0165w.h();
            }
            int[] iArr = this.f2576a;
            int length = iArr.length;
            for (int i4 = 0; i4 < length; i4 += 3) {
                int L3 = L(i4);
                long j4 = 1048575 & L3;
                int K3 = K(L3);
                if (K3 != 9) {
                    if (K3 != 60 && K3 != 68) {
                        switch (K3) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.k.getClass();
                                AbstractC0145b abstractC0145b = (AbstractC0145b) ((InterfaceC0166x) j0.f2659c.h(j4, obj));
                                if (abstractC0145b.f2618f) {
                                    abstractC0145b.f2618f = false;
                                    break;
                                } else {
                                    break;
                                }
                            case 50:
                                Unsafe unsafe = f2575o;
                                Object object = unsafe.getObject(obj, j4);
                                if (object != null) {
                                    this.f2587m.getClass();
                                    ((I) object).f2570f = false;
                                    unsafe.putObject(obj, j4, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (q(obj, iArr[i4], i4)) {
                        m(i4).d(f2575o.getObject(obj, j4));
                    }
                }
                if (n(i4, obj)) {
                    m(i4).d(f2575o.getObject(obj, j4));
                }
            }
            this.f2586l.getClass();
            d0 d0Var = ((AbstractC0165w) obj).unknownFields;
            if (d0Var.f2631e) {
                d0Var.f2631e = false;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final boolean e(Object obj) {
        int i4;
        int i5;
        int i6;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i9 < this.f2583h) {
            int i10 = this.f2582g[i9];
            int[] iArr = this.f2576a;
            int i11 = iArr[i10];
            int L3 = L(i10);
            int i12 = iArr[i10 + 2];
            int i13 = i12 & 1048575;
            int i14 = 1 << (i12 >>> 20);
            if (i13 != i7) {
                if (i13 != 1048575) {
                    i8 = f2575o.getInt(obj, i13);
                }
                i5 = i10;
                i6 = i8;
                i4 = i13;
            } else {
                int i15 = i8;
                i4 = i7;
                i5 = i10;
                i6 = i15;
            }
            if ((268435456 & L3) == 0 || o(obj, i5, i4, i6, i14)) {
                int K3 = K(L3);
                if (K3 != 9 && K3 != 17) {
                    if (K3 != 27) {
                        if (K3 != 60 && K3 != 68) {
                            if (K3 != 49) {
                                if (K3 != 50) {
                                    continue;
                                } else {
                                    Object h3 = j0.f2659c.h(L3 & 1048575, obj);
                                    this.f2587m.getClass();
                                    I i16 = (I) h3;
                                    if (i16.isEmpty()) {
                                        continue;
                                    } else {
                                        if (((H) this.f2577b[(i5 / 3) * 2]).f2567a.f2565b.f2688f != s0.MESSAGE) {
                                            continue;
                                        } else {
                                            W w2 = null;
                                            for (Object obj2 : i16.values()) {
                                                if (w2 == null) {
                                                    w2 = T.f2593c.a(obj2.getClass());
                                                }
                                                if (!w2.e(obj2)) {
                                                }
                                            }
                                        }
                                    }
                                }
                                i9++;
                                i7 = i4;
                                i8 = i6;
                            }
                        } else {
                            if (q(obj, i11, i5)) {
                                if (!m(i5).e(j0.f2659c.h(L3 & 1048575, obj))) {
                                }
                            } else {
                                continue;
                            }
                            i9++;
                            i7 = i4;
                            i8 = i6;
                        }
                    }
                    List list = (List) j0.f2659c.h(L3 & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        W m3 = m(i5);
                        for (int i17 = 0; i17 < list.size(); i17++) {
                            if (m3.e(list.get(i17))) {
                            }
                        }
                    }
                    i9++;
                    i7 = i4;
                    i8 = i6;
                } else {
                    if (o(obj, i5, i4, i6, i14)) {
                        if (!m(i5).e(j0.f2659c.h(L3 & 1048575, obj))) {
                        }
                    } else {
                        continue;
                    }
                    i9++;
                    i7 = i4;
                    i8 = i6;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        if (androidx.datastore.preferences.protobuf.X.l(r5.h(r7, r12), r5.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0108, code lost:
    
        if (androidx.datastore.preferences.protobuf.X.l(r5.h(r7, r12), r5.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (androidx.datastore.preferences.protobuf.X.l(r5.h(r7, r12), r5.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0138, code lost:
    
        if (androidx.datastore.preferences.protobuf.X.l(r5.h(r7, r12), r5.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014c, code lost:
    
        if (r5.c(r7, r12) == r5.c(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0176, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018a, code lost:
    
        if (r5.f(r7, r12) == r5.f(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019f, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b4, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cf, code lost:
    
        if (java.lang.Float.floatToIntBits(r5.e(r7, r12)) == java.lang.Float.floatToIntBits(r5.e(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ec, code lost:
    
        if (java.lang.Double.doubleToLongBits(r5.d(r7, r12)) == java.lang.Double.doubleToLongBits(r5.d(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (androidx.datastore.preferences.protobuf.X.l(r9.h(r7, r12), r9.h(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0016. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.W
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(androidx.datastore.preferences.protobuf.AbstractC0165w r12, androidx.datastore.preferences.protobuf.AbstractC0165w r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.f(androidx.datastore.preferences.protobuf.w, androidx.datastore.preferences.protobuf.w):boolean");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // androidx.datastore.preferences.protobuf.W
    public final void g(java.lang.Object r19, androidx.datastore.preferences.protobuf.C0154k r20, androidx.datastore.preferences.protobuf.C0158o r21) {
        /*
            Method dump skipped, instructions count: 1884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.g(java.lang.Object, androidx.datastore.preferences.protobuf.k, androidx.datastore.preferences.protobuf.o):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0048. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.W
    public final int h(AbstractC0165w abstractC0165w) {
        int i4;
        int X3;
        int X4;
        int X5;
        int Z3;
        int X6;
        int Z4;
        int X7;
        int X8;
        int W3;
        int V3;
        int X9;
        int a4;
        int c4;
        int X10;
        int size;
        int i5;
        int X11;
        int X12;
        int X13;
        int size2;
        int X14;
        int Y3;
        int i6;
        int i7;
        int X15;
        int W4;
        int Y4;
        N n3 = this;
        AbstractC0165w abstractC0165w2 = abstractC0165w;
        Unsafe unsafe = f2575o;
        int i8 = 1048575;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = n3.f2576a;
            if (i9 < iArr.length) {
                int L3 = n3.L(i9);
                int K3 = K(L3);
                int i12 = iArr[i9];
                int i13 = iArr[i9 + 2];
                int i14 = i13 & 1048575;
                if (K3 <= 17) {
                    if (i14 != i8) {
                        if (i14 == 1048575) {
                            i10 = 0;
                        } else {
                            i10 = unsafe.getInt(abstractC0165w2, i14);
                        }
                        i8 = i14;
                    }
                    i4 = 1 << (i13 >>> 20);
                } else {
                    i4 = 0;
                }
                long j4 = L3 & 1048575;
                if (K3 >= EnumC0161s.f2690g.f2694f) {
                    int i15 = EnumC0161s.f2691h.f2694f;
                }
                switch (K3) {
                    case 0:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            X3 = C0156m.X(i12);
                            c4 = X3 + 8;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            X4 = C0156m.X(i12);
                            X8 = X4 + 4;
                            i11 += X8;
                        }
                        n3 = this;
                        abstractC0165w2 = abstractC0165w;
                        break;
                    case 2:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            long j5 = unsafe.getLong(abstractC0165w2, j4);
                            X5 = C0156m.X(i12);
                            Z3 = C0156m.Z(j5);
                            i11 += Z3 + X5;
                        }
                        n3 = this;
                        break;
                    case 3:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            long j6 = unsafe.getLong(abstractC0165w2, j4);
                            X5 = C0156m.X(i12);
                            Z3 = C0156m.Z(j6);
                            i11 += Z3 + X5;
                        }
                        n3 = this;
                        break;
                    case 4:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            int i16 = unsafe.getInt(abstractC0165w2, j4);
                            X6 = C0156m.X(i12);
                            Z4 = C0156m.Z(i16);
                            V3 = Z4 + X6;
                            i11 += V3;
                        }
                        n3 = this;
                        break;
                    case 5:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            X7 = C0156m.X(i12);
                            X8 = X7 + 8;
                            i11 += X8;
                        }
                        n3 = this;
                        abstractC0165w2 = abstractC0165w;
                        break;
                    case 6:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            X4 = C0156m.X(i12);
                            X8 = X4 + 4;
                            i11 += X8;
                        }
                        n3 = this;
                        abstractC0165w2 = abstractC0165w;
                        break;
                    case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            X8 = C0156m.X(i12) + 1;
                            i11 += X8;
                        }
                        n3 = this;
                        abstractC0165w2 = abstractC0165w;
                        break;
                    case R.j.BYTES_FIELD_NUMBER /* 8 */:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            Object object = unsafe.getObject(abstractC0165w2, j4);
                            if (object instanceof C0150g) {
                                W3 = C0156m.V(i12, (C0150g) object);
                            } else {
                                W3 = C0156m.W((String) object) + C0156m.X(i12);
                            }
                            i11 = W3 + i11;
                        }
                        n3 = this;
                        break;
                    case 9:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            Object object2 = unsafe.getObject(abstractC0165w2, j4);
                            W m3 = n3.m(i9);
                            Class cls = X.f2603a;
                            int X16 = C0156m.X(i12);
                            int a5 = ((AbstractC0144a) object2).a(m3);
                            i11 += C0156m.Y(a5) + a5 + X16;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            V3 = C0156m.V(i12, (C0150g) unsafe.getObject(abstractC0165w2, j4));
                            i11 += V3;
                        }
                        n3 = this;
                        break;
                    case 11:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            int i17 = unsafe.getInt(abstractC0165w2, j4);
                            X6 = C0156m.X(i12);
                            Z4 = C0156m.Y(i17);
                            V3 = Z4 + X6;
                            i11 += V3;
                        }
                        n3 = this;
                        break;
                    case 12:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            int i18 = unsafe.getInt(abstractC0165w2, j4);
                            X6 = C0156m.X(i12);
                            Z4 = C0156m.Z(i18);
                            V3 = Z4 + X6;
                            i11 += V3;
                        }
                        n3 = this;
                        break;
                    case 13:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            X4 = C0156m.X(i12);
                            X8 = X4 + 4;
                            i11 += X8;
                        }
                        n3 = this;
                        abstractC0165w2 = abstractC0165w;
                        break;
                    case 14:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            X7 = C0156m.X(i12);
                            X8 = X7 + 8;
                            i11 += X8;
                        }
                        n3 = this;
                        abstractC0165w2 = abstractC0165w;
                        break;
                    case 15:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            int i19 = unsafe.getInt(abstractC0165w2, j4);
                            X6 = C0156m.X(i12);
                            Z4 = C0156m.Y((i19 >> 31) ^ (i19 << 1));
                            V3 = Z4 + X6;
                            i11 += V3;
                        }
                        n3 = this;
                        break;
                    case 16:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            long j7 = unsafe.getLong(abstractC0165w2, j4);
                            X5 = C0156m.X(i12);
                            Z3 = C0156m.Z((j7 << 1) ^ (j7 >> 63));
                            i11 += Z3 + X5;
                        }
                        n3 = this;
                        break;
                    case 17:
                        if (n3.o(abstractC0165w2, i9, i8, i10, i4)) {
                            AbstractC0144a abstractC0144a = (AbstractC0144a) unsafe.getObject(abstractC0165w2, j4);
                            W m4 = n3.m(i9);
                            X9 = C0156m.X(i12) * 2;
                            a4 = abstractC0144a.a(m4);
                            c4 = a4 + X9;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        c4 = X.c(i12, (List) unsafe.getObject(abstractC0165w2, j4));
                        i11 += c4;
                        break;
                    case 19:
                        c4 = X.b(i12, (List) unsafe.getObject(abstractC0165w2, j4));
                        i11 += c4;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls2 = X.f2603a;
                        if (list.size() != 0) {
                            X10 = (C0156m.X(i12) * list.size()) + X.e(list);
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 21:
                        List list2 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls3 = X.f2603a;
                        size = list2.size();
                        if (size != 0) {
                            i5 = X.i(list2);
                            X11 = C0156m.X(i12);
                            X10 = (X11 * size) + i5;
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 22:
                        List list3 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls4 = X.f2603a;
                        size = list3.size();
                        if (size != 0) {
                            i5 = X.d(list3);
                            X11 = C0156m.X(i12);
                            X10 = (X11 * size) + i5;
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 23:
                        c4 = X.c(i12, (List) unsafe.getObject(abstractC0165w2, j4));
                        i11 += c4;
                        break;
                    case 24:
                        c4 = X.b(i12, (List) unsafe.getObject(abstractC0165w2, j4));
                        i11 += c4;
                        break;
                    case 25:
                        List list4 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls5 = X.f2603a;
                        int size3 = list4.size();
                        if (size3 == 0) {
                            X12 = 0;
                        } else {
                            X12 = (C0156m.X(i12) + 1) * size3;
                        }
                        i11 += X12;
                        break;
                    case 26:
                        List list5 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls6 = X.f2603a;
                        int size4 = list5.size();
                        if (size4 != 0) {
                            X10 = C0156m.X(i12) * size4;
                            for (int i20 = 0; i20 < size4; i20++) {
                                Object obj = list5.get(i20);
                                if (obj instanceof C0150g) {
                                    int size5 = ((C0150g) obj).size();
                                    X10 = C0156m.Y(size5) + size5 + X10;
                                } else {
                                    X10 = C0156m.W((String) obj) + X10;
                                }
                            }
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 27:
                        List list6 = (List) unsafe.getObject(abstractC0165w2, j4);
                        W m5 = n3.m(i9);
                        Class cls7 = X.f2603a;
                        int size6 = list6.size();
                        if (size6 != 0) {
                            X13 = C0156m.X(i12) * size6;
                            for (int i21 = 0; i21 < size6; i21++) {
                                int a6 = ((AbstractC0144a) list6.get(i21)).a(m5);
                                X13 += C0156m.Y(a6) + a6;
                            }
                            i11 += X13;
                            break;
                        }
                        X13 = 0;
                        i11 += X13;
                    case 28:
                        List list7 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls8 = X.f2603a;
                        int size7 = list7.size();
                        if (size7 != 0) {
                            X10 = C0156m.X(i12) * size7;
                            for (int i22 = 0; i22 < list7.size(); i22++) {
                                int size8 = ((C0150g) list7.get(i22)).size();
                                X10 += C0156m.Y(size8) + size8;
                            }
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 29:
                        List list8 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls9 = X.f2603a;
                        size = list8.size();
                        if (size != 0) {
                            i5 = X.h(list8);
                            X11 = C0156m.X(i12);
                            X10 = (X11 * size) + i5;
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 30:
                        List list9 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls10 = X.f2603a;
                        size = list9.size();
                        if (size != 0) {
                            i5 = X.a(list9);
                            X11 = C0156m.X(i12);
                            X10 = (X11 * size) + i5;
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 31:
                        c4 = X.b(i12, (List) unsafe.getObject(abstractC0165w2, j4));
                        i11 += c4;
                        break;
                    case 32:
                        c4 = X.c(i12, (List) unsafe.getObject(abstractC0165w2, j4));
                        i11 += c4;
                        break;
                    case 33:
                        List list10 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls11 = X.f2603a;
                        size = list10.size();
                        if (size != 0) {
                            i5 = X.f(list10);
                            X11 = C0156m.X(i12);
                            X10 = (X11 * size) + i5;
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 34:
                        List list11 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls12 = X.f2603a;
                        size = list11.size();
                        if (size != 0) {
                            i5 = X.g(list11);
                            X11 = C0156m.X(i12);
                            X10 = (X11 * size) + i5;
                            i11 += X10;
                            break;
                        }
                        X10 = 0;
                        i11 += X10;
                    case 35:
                        List list12 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls13 = X.f2603a;
                        size2 = list12.size() * 8;
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        List list13 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls14 = X.f2603a;
                        size2 = list13.size() * 4;
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        size2 = X.e((List) unsafe.getObject(abstractC0165w2, j4));
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        size2 = X.i((List) unsafe.getObject(abstractC0165w2, j4));
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        size2 = X.d((List) unsafe.getObject(abstractC0165w2, j4));
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        List list14 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls15 = X.f2603a;
                        size2 = list14.size() * 8;
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        List list15 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls16 = X.f2603a;
                        size2 = list15.size() * 4;
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list16 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls17 = X.f2603a;
                        size2 = list16.size();
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        size2 = X.h((List) unsafe.getObject(abstractC0165w2, j4));
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        size2 = X.a((List) unsafe.getObject(abstractC0165w2, j4));
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        List list17 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls18 = X.f2603a;
                        size2 = list17.size() * 4;
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        List list18 = (List) unsafe.getObject(abstractC0165w2, j4);
                        Class cls19 = X.f2603a;
                        size2 = list18.size() * 8;
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        size2 = X.f((List) unsafe.getObject(abstractC0165w2, j4));
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        size2 = X.g((List) unsafe.getObject(abstractC0165w2, j4));
                        if (size2 > 0) {
                            X14 = C0156m.X(i12);
                            Y3 = C0156m.Y(size2);
                            i6 = Y3 + X14;
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list19 = (List) unsafe.getObject(abstractC0165w2, j4);
                        W m6 = n3.m(i9);
                        Class cls20 = X.f2603a;
                        int size9 = list19.size();
                        if (size9 == 0) {
                            i7 = 0;
                        } else {
                            i7 = 0;
                            for (int i23 = 0; i23 < size9; i23++) {
                                i7 += ((AbstractC0144a) list19.get(i23)).a(m6) + (C0156m.X(i12) * 2);
                            }
                        }
                        i11 += i7;
                        break;
                    case 50:
                        Object object3 = unsafe.getObject(abstractC0165w2, j4);
                        Object obj2 = n3.f2577b[(i9 / 3) * 2];
                        n3.f2587m.getClass();
                        I i24 = (I) object3;
                        H h3 = (H) obj2;
                        if (!i24.isEmpty()) {
                            X13 = 0;
                            for (Map.Entry entry : i24.entrySet()) {
                                Object key = entry.getKey();
                                Object value = entry.getValue();
                                h3.getClass();
                                int X17 = C0156m.X(i12);
                                int a7 = H.a(h3.f2567a, key, value);
                                X13 += C0156m.Y(a7) + a7 + X17;
                            }
                            i11 += X13;
                            break;
                        }
                        X13 = 0;
                        i11 += X13;
                    case 51:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            X3 = C0156m.X(i12);
                            c4 = X3 + 8;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            X15 = C0156m.X(i12);
                            c4 = X15 + 4;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            long z = z(j4, abstractC0165w2);
                            size2 = C0156m.X(i12);
                            i6 = C0156m.Z(z);
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            long z3 = z(j4, abstractC0165w2);
                            size2 = C0156m.X(i12);
                            i6 = C0156m.Z(z3);
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            int y3 = y(j4, abstractC0165w2);
                            X9 = C0156m.X(i12);
                            a4 = C0156m.Z(y3);
                            c4 = a4 + X9;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            X3 = C0156m.X(i12);
                            c4 = X3 + 8;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            X15 = C0156m.X(i12);
                            c4 = X15 + 4;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            c4 = C0156m.X(i12) + 1;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            Object object4 = unsafe.getObject(abstractC0165w2, j4);
                            if (object4 instanceof C0150g) {
                                W4 = C0156m.V(i12, (C0150g) object4);
                            } else {
                                W4 = C0156m.W((String) object4) + C0156m.X(i12);
                            }
                            i11 = W4 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            Object object5 = unsafe.getObject(abstractC0165w2, j4);
                            W m7 = n3.m(i9);
                            Class cls21 = X.f2603a;
                            int X18 = C0156m.X(i12);
                            int a8 = ((AbstractC0144a) object5).a(m7);
                            Y4 = C0156m.Y(a8) + a8 + X18;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            c4 = C0156m.V(i12, (C0150g) unsafe.getObject(abstractC0165w2, j4));
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            int y4 = y(j4, abstractC0165w2);
                            X9 = C0156m.X(i12);
                            a4 = C0156m.Y(y4);
                            c4 = a4 + X9;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            int y5 = y(j4, abstractC0165w2);
                            X9 = C0156m.X(i12);
                            a4 = C0156m.Z(y5);
                            c4 = a4 + X9;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            X15 = C0156m.X(i12);
                            c4 = X15 + 4;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            X3 = C0156m.X(i12);
                            c4 = X3 + 8;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            int y6 = y(j4, abstractC0165w2);
                            X9 = C0156m.X(i12);
                            a4 = C0156m.Y((y6 >> 31) ^ (y6 << 1));
                            c4 = a4 + X9;
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            long z4 = z(j4, abstractC0165w2);
                            size2 = C0156m.X(i12);
                            i6 = C0156m.Z((z4 << 1) ^ (z4 >> 63));
                            Y4 = i6 + size2;
                            i11 += Y4;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (n3.q(abstractC0165w2, i12, i9)) {
                            c4 = ((AbstractC0144a) unsafe.getObject(abstractC0165w2, j4)).a(n3.m(i9)) + (C0156m.X(i12) * 2);
                            i11 += c4;
                            break;
                        } else {
                            break;
                        }
                }
                i9 += 3;
            } else {
                n3.f2586l.getClass();
                return abstractC0165w2.unknownFields.b() + i11;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final AbstractC0165w i() {
        this.f2585j.getClass();
        return ((AbstractC0165w) this.f2580e).i();
    }

    public final boolean j(AbstractC0165w abstractC0165w, AbstractC0165w abstractC0165w2, int i4) {
        if (n(i4, abstractC0165w) == n(i4, abstractC0165w2)) {
            return true;
        }
        return false;
    }

    public final void k(int i4, Object obj, Object obj2) {
        int i5 = this.f2576a[i4];
        if (j0.f2659c.h(L(i4) & 1048575, obj) == null) {
            return;
        }
        l(i4);
    }

    public final void l(int i4) {
        if (this.f2577b[((i4 / 3) * 2) + 1] == null) {
        } else {
            throw new ClassCastException();
        }
    }

    public final W m(int i4) {
        int i5 = (i4 / 3) * 2;
        Object[] objArr = this.f2577b;
        W w2 = (W) objArr[i5];
        if (w2 != null) {
            return w2;
        }
        W a4 = T.f2593c.a((Class) objArr[i5 + 1]);
        objArr[i5] = a4;
        return a4;
    }

    public final boolean n(int i4, Object obj) {
        int i5 = this.f2576a[i4 + 2];
        long j4 = i5 & 1048575;
        if (j4 == 1048575) {
            int L3 = L(i4);
            long j5 = L3 & 1048575;
            switch (K(L3)) {
                case 0:
                    if (Double.doubleToRawLongBits(j0.f2659c.d(j5, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(j0.f2659c.e(j5, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (j0.f2659c.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (j0.f2659c.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (j0.f2659c.f(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (j0.f2659c.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (j0.f2659c.f(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    return j0.f2659c.c(j5, obj);
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    Object h3 = j0.f2659c.h(j5, obj);
                    if (h3 instanceof String) {
                        return !((String) h3).isEmpty();
                    }
                    if (h3 instanceof C0150g) {
                        return !C0150g.f2634h.equals(h3);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (j0.f2659c.h(j5, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !C0150g.f2634h.equals(j0.f2659c.h(j5, obj));
                case 11:
                    if (j0.f2659c.f(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (j0.f2659c.f(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (j0.f2659c.f(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (j0.f2659c.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (j0.f2659c.f(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (j0.f2659c.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (j0.f2659c.h(j5, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i5 >>> 20)) & j0.f2659c.f(j4, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean o(Object obj, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return n(i4, obj);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    public final boolean q(Object obj, int i4, int i5) {
        if (j0.f2659c.f(this.f2576a[i5 + 2] & 1048575, obj) == i4) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
    
        r10.put(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009c, code lost:
    
        r0.d(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.lang.Object r9, int r10, java.lang.Object r11, androidx.datastore.preferences.protobuf.C0158o r12, androidx.datastore.preferences.protobuf.C0154k r13) {
        /*
            r8 = this;
            int r10 = r8.L(r10)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r0
            long r0 = (long) r10
            androidx.datastore.preferences.protobuf.i0 r10 = androidx.datastore.preferences.protobuf.j0.f2659c
            java.lang.Object r10 = r10.h(r0, r9)
            androidx.datastore.preferences.protobuf.J r2 = r8.f2587m
            if (r10 != 0) goto L20
            r2.getClass()
            androidx.datastore.preferences.protobuf.I r10 = androidx.datastore.preferences.protobuf.I.f2569g
            androidx.datastore.preferences.protobuf.I r10 = r10.b()
            androidx.datastore.preferences.protobuf.j0.o(r0, r9, r10)
            goto L37
        L20:
            r2.getClass()
            r3 = r10
            androidx.datastore.preferences.protobuf.I r3 = (androidx.datastore.preferences.protobuf.I) r3
            boolean r3 = r3.f2570f
            if (r3 != 0) goto L37
            androidx.datastore.preferences.protobuf.I r3 = androidx.datastore.preferences.protobuf.I.f2569g
            androidx.datastore.preferences.protobuf.I r3 = r3.b()
            androidx.datastore.preferences.protobuf.J.a(r3, r10)
            androidx.datastore.preferences.protobuf.j0.o(r0, r9, r3)
            r10 = r3
        L37:
            r2.getClass()
            androidx.datastore.preferences.protobuf.I r10 = (androidx.datastore.preferences.protobuf.I) r10
            androidx.datastore.preferences.protobuf.H r11 = (androidx.datastore.preferences.protobuf.H) r11
            androidx.datastore.preferences.protobuf.G r9 = r11.f2567a
            r11 = 2
            r13.w(r11)
            androidx.datastore.preferences.protobuf.j r0 = r13.f2664a
            int r1 = r0.v()
            int r1 = r0.e(r1)
            java.lang.Object r2 = r9.f2566c
            java.lang.String r3 = ""
            r4 = r2
        L53:
            int r5 = r13.a()     // Catch: java.lang.Throwable -> L77
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r5 == r6) goto L99
            boolean r6 = r0.c()     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L63
            goto L99
        L63:
            r6 = 1
            java.lang.String r7 = "Unable to parse map entry."
            if (r5 == r6) goto L84
            if (r5 == r11) goto L79
            boolean r5 = r13.x()     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
            if (r5 == 0) goto L71
            goto L53
        L71:
            androidx.datastore.preferences.protobuf.A r5 = new androidx.datastore.preferences.protobuf.A     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
            throw r5     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
        L77:
            r9 = move-exception
            goto La0
        L79:
            androidx.datastore.preferences.protobuf.r0 r5 = r9.f2565b     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
            java.lang.Class r6 = r2.getClass()     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
            java.lang.Object r4 = r13.i(r5, r6, r12)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
            goto L53
        L84:
            androidx.datastore.preferences.protobuf.r0 r5 = r9.f2564a     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
            r6 = 0
            java.lang.Object r3 = r13.i(r5, r6, r6)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0168z -> L8c
            goto L53
        L8c:
            boolean r5 = r13.x()     // Catch: java.lang.Throwable -> L77
            if (r5 == 0) goto L93
            goto L53
        L93:
            androidx.datastore.preferences.protobuf.A r9 = new androidx.datastore.preferences.protobuf.A     // Catch: java.lang.Throwable -> L77
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L77
            throw r9     // Catch: java.lang.Throwable -> L77
        L99:
            r10.put(r3, r4)     // Catch: java.lang.Throwable -> L77
            r0.d(r1)
            return
        La0:
            r0.d(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.r(java.lang.Object, int, java.lang.Object, androidx.datastore.preferences.protobuf.o, androidx.datastore.preferences.protobuf.k):void");
    }

    public final void s(int i4, Object obj, Object obj2) {
        if (!n(i4, obj2)) {
            return;
        }
        long L3 = L(i4) & 1048575;
        Unsafe unsafe = f2575o;
        Object object = unsafe.getObject(obj2, L3);
        if (object != null) {
            W m3 = m(i4);
            if (!n(i4, obj)) {
                if (!p(object)) {
                    unsafe.putObject(obj, L3, object);
                } else {
                    AbstractC0165w i5 = m3.i();
                    m3.a(i5, object);
                    unsafe.putObject(obj, L3, i5);
                }
                G(i4, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, L3);
            if (!p(object2)) {
                AbstractC0165w i6 = m3.i();
                m3.a(i6, object2);
                unsafe.putObject(obj, L3, i6);
                object2 = i6;
            }
            m3.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.f2576a[i4] + " is present but null: " + obj2);
    }

    public final void t(int i4, Object obj, Object obj2) {
        int[] iArr = this.f2576a;
        int i5 = iArr[i4];
        if (!q(obj2, i5, i4)) {
            return;
        }
        long L3 = L(i4) & 1048575;
        Unsafe unsafe = f2575o;
        Object object = unsafe.getObject(obj2, L3);
        if (object != null) {
            W m3 = m(i4);
            if (!q(obj, i5, i4)) {
                if (!p(object)) {
                    unsafe.putObject(obj, L3, object);
                } else {
                    AbstractC0165w i6 = m3.i();
                    m3.a(i6, object);
                    unsafe.putObject(obj, L3, i6);
                }
                H(obj, i5, i4);
                return;
            }
            Object object2 = unsafe.getObject(obj, L3);
            if (!p(object2)) {
                AbstractC0165w i7 = m3.i();
                m3.a(i7, object2);
                unsafe.putObject(obj, L3, i7);
                object2 = i7;
            }
            m3.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + iArr[i4] + " is present but null: " + obj2);
    }

    public final Object u(int i4, Object obj) {
        W m3 = m(i4);
        long L3 = L(i4) & 1048575;
        if (!n(i4, obj)) {
            return m3.i();
        }
        Object object = f2575o.getObject(obj, L3);
        if (p(object)) {
            return object;
        }
        AbstractC0165w i5 = m3.i();
        if (object != null) {
            m3.a(i5, object);
        }
        return i5;
    }

    public final Object v(Object obj, int i4, int i5) {
        W m3 = m(i5);
        if (!q(obj, i4, i5)) {
            return m3.i();
        }
        Object object = f2575o.getObject(obj, L(i5) & 1048575);
        if (p(object)) {
            return object;
        }
        AbstractC0165w i6 = m3.i();
        if (object != null) {
            m3.a(i6, object);
        }
        return i6;
    }
}
