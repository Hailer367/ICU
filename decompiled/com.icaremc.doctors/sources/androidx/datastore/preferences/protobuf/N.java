package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import io.flutter.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class N implements W {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f1354n = new int[0];

    /* renamed from: o, reason: collision with root package name */
    public static final Unsafe f1355o = j0.i();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f1356a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f1357b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1358c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1359d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0074a f1360e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1361f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f1362g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1363h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1364i;

    /* renamed from: j, reason: collision with root package name */
    public final P f1365j;

    /* renamed from: k, reason: collision with root package name */
    public final C f1366k;

    /* renamed from: l, reason: collision with root package name */
    public final e0 f1367l;

    /* renamed from: m, reason: collision with root package name */
    public final J f1368m;

    public N(int[] iArr, Object[] objArr, int i2, int i3, AbstractC0074a abstractC0074a, int[] iArr2, int i4, int i5, P p, C c2, e0 e0Var, C0089p c0089p, J j2) {
        this.f1356a = iArr;
        this.f1357b = objArr;
        this.f1358c = i2;
        this.f1359d = i3;
        this.f1361f = abstractC0074a instanceof AbstractC0095w;
        this.f1362g = iArr2;
        this.f1363h = i4;
        this.f1364i = i5;
        this.f1365j = p;
        this.f1366k = c2;
        this.f1367l = e0Var;
        this.f1360e = abstractC0074a;
        this.f1368m = j2;
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

    public static int K(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static boolean p(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC0095w) {
            return ((AbstractC0095w) obj).g();
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
    public static androidx.datastore.preferences.protobuf.N w(androidx.datastore.preferences.protobuf.V r34, androidx.datastore.preferences.protobuf.P r35, androidx.datastore.preferences.protobuf.C r36, androidx.datastore.preferences.protobuf.e0 r37, androidx.datastore.preferences.protobuf.C0089p r38, androidx.datastore.preferences.protobuf.J r39) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.w(androidx.datastore.preferences.protobuf.V, androidx.datastore.preferences.protobuf.P, androidx.datastore.preferences.protobuf.C, androidx.datastore.preferences.protobuf.e0, androidx.datastore.preferences.protobuf.p, androidx.datastore.preferences.protobuf.J):androidx.datastore.preferences.protobuf.N");
    }

    public static long x(int i2) {
        return i2 & 1048575;
    }

    public static int y(long j2, Object obj) {
        return ((Integer) j0.f1442c.h(j2, obj)).intValue();
    }

    public static long z(long j2, Object obj) {
        return ((Long) j0.f1442c.h(j2, obj)).longValue();
    }

    public final int A(int i2) {
        if (i2 >= this.f1358c && i2 <= this.f1359d) {
            int[] iArr = this.f1356a;
            int length = (iArr.length / 3) - 1;
            int i3 = 0;
            while (i3 <= length) {
                int i4 = (length + i3) >>> 1;
                int i5 = i4 * 3;
                int i6 = iArr[i5];
                if (i2 == i6) {
                    return i5;
                }
                if (i2 < i6) {
                    length = i4 - 1;
                } else {
                    i3 = i4 + 1;
                }
            }
        }
        return -1;
    }

    public final void B(Object obj, long j2, C0084k c0084k, W w2, C0088o c0088o) {
        int u2;
        this.f1366k.getClass();
        InterfaceC0096x a2 = C.a(j2, obj);
        AbstractC0083j abstractC0083j = c0084k.f1447a;
        int i2 = c0084k.f1448b;
        if ((i2 & 7) != 3) {
            throw A.b();
        }
        do {
            AbstractC0095w i3 = w2.i();
            c0084k.b(i3, w2, c0088o);
            w2.d(i3);
            ((U) a2).add(i3);
            if (!abstractC0083j.c() && c0084k.f1450d == 0) {
                u2 = abstractC0083j.u();
            } else {
                return;
            }
        } while (u2 == i2);
        c0084k.f1450d = u2;
    }

    public final void C(Object obj, int i2, C0084k c0084k, W w2, C0088o c0088o) {
        int u2;
        this.f1366k.getClass();
        InterfaceC0096x a2 = C.a(i2 & 1048575, obj);
        AbstractC0083j abstractC0083j = c0084k.f1447a;
        int i3 = c0084k.f1448b;
        if ((i3 & 7) != 2) {
            throw A.b();
        }
        do {
            AbstractC0095w i4 = w2.i();
            c0084k.c(i4, w2, c0088o);
            w2.d(i4);
            ((U) a2).add(i4);
            if (!abstractC0083j.c() && c0084k.f1450d == 0) {
                u2 = abstractC0083j.u();
            } else {
                return;
            }
        } while (u2 == i3);
        c0084k.f1450d = u2;
    }

    public final void D(int i2, C0084k c0084k, Object obj) {
        AbstractC0083j abstractC0083j = c0084k.f1447a;
        if ((536870912 & i2) != 0) {
            c0084k.w(2);
            j0.o(i2 & 1048575, obj, abstractC0083j.t());
        } else if (this.f1361f) {
            c0084k.w(2);
            j0.o(i2 & 1048575, obj, abstractC0083j.s());
        } else {
            j0.o(i2 & 1048575, obj, c0084k.e());
        }
    }

    public final void E(int i2, C0084k c0084k, Object obj) {
        int i3 = 536870912 & i2;
        C c2 = this.f1366k;
        if (i3 != 0) {
            c2.getClass();
            c0084k.s(C.a(i2 & 1048575, obj), true);
        } else {
            c2.getClass();
            c0084k.s(C.a(i2 & 1048575, obj), false);
        }
    }

    public final void G(int i2, Object obj) {
        int i3 = this.f1356a[i2 + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        j0.m(obj, j2, (1 << (i3 >>> 20)) | j0.f1442c.f(j2, obj));
    }

    public final void H(Object obj, int i2, int i3) {
        j0.m(obj, this.f1356a[i3 + 2] & 1048575, i2);
    }

    public final void I(Object obj, int i2, AbstractC0074a abstractC0074a) {
        f1355o.putObject(obj, L(i2) & 1048575, abstractC0074a);
        G(i2, obj);
    }

    public final void J(Object obj, int i2, int i3, AbstractC0074a abstractC0074a) {
        f1355o.putObject(obj, L(i3) & 1048575, abstractC0074a);
        H(obj, i2, i3);
    }

    public final int L(int i2) {
        return this.f1356a[i2 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0045. Please report as an issue. */
    public final void M(Object obj, F f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        N n2 = this;
        int[] iArr = n2.f1356a;
        int length = iArr.length;
        Unsafe unsafe = f1355o;
        int i6 = 1048575;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            int L = n2.L(i8);
            int i10 = iArr[i8];
            int K2 = K(L);
            if (K2 <= 17) {
                int i11 = iArr[i8 + 2];
                int i12 = i11 & i6;
                if (i12 != i7) {
                    if (i12 == i6) {
                        i9 = 0;
                    } else {
                        i9 = unsafe.getInt(obj, i12);
                    }
                    i7 = i12;
                }
                i2 = L;
                i3 = 1 << (i11 >>> 20);
            } else {
                i2 = L;
                i3 = 0;
            }
            long j2 = i2 & i6;
            switch (K2) {
                case 0:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        double d2 = j0.f1442c.d(j2, obj);
                        C0086m c0086m = (C0086m) f2.f1343a;
                        c0086m.getClass();
                        c0086m.g0(i10, Double.doubleToRawLongBits(d2));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        float e2 = j0.f1442c.e(j2, obj);
                        C0086m c0086m2 = (C0086m) f2.f1343a;
                        c0086m2.getClass();
                        c0086m2.e0(i10, Float.floatToRawIntBits(e2));
                    }
                    n2 = this;
                    break;
                case 2:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).q0(i10, unsafe.getLong(obj, j2));
                    }
                    n2 = this;
                    break;
                case 3:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).q0(i10, unsafe.getLong(obj, j2));
                    }
                    n2 = this;
                    break;
                case 4:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).i0(i10, unsafe.getInt(obj, j2));
                    }
                    n2 = this;
                    break;
                case 5:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).g0(i10, unsafe.getLong(obj, j2));
                    }
                    n2 = this;
                    break;
                case 6:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).e0(i10, unsafe.getInt(obj, j2));
                    }
                    n2 = this;
                    break;
                case 7:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).b0(i10, j0.f1442c.c(j2, obj));
                    }
                    n2 = this;
                    break;
                case 8:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        Object object = unsafe.getObject(obj, j2);
                        if (object instanceof String) {
                            ((C0086m) f2.f1343a).l0(i10, (String) object);
                        } else {
                            ((C0086m) f2.f1343a).c0(i10, (C0080g) object);
                        }
                    }
                    n2 = this;
                    break;
                case 9:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).k0(i10, (AbstractC0074a) unsafe.getObject(obj, j2), n2.m(i8));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).c0(i10, (C0080g) unsafe.getObject(obj, j2));
                    }
                    n2 = this;
                    break;
                case 11:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).o0(i10, unsafe.getInt(obj, j2));
                    }
                    n2 = this;
                    break;
                case 12:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).i0(i10, unsafe.getInt(obj, j2));
                    }
                    n2 = this;
                    break;
                case 13:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).e0(i10, unsafe.getInt(obj, j2));
                    }
                    n2 = this;
                    break;
                case 14:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        ((C0086m) f2.f1343a).g0(i10, unsafe.getLong(obj, j2));
                    }
                    n2 = this;
                    break;
                case 15:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        int i13 = unsafe.getInt(obj, j2);
                        ((C0086m) f2.f1343a).o0(i10, (i13 >> 31) ^ (i13 << 1));
                    }
                    n2 = this;
                    break;
                case 16:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        long j3 = unsafe.getLong(obj, j2);
                        ((C0086m) f2.f1343a).q0(i10, (j3 >> 63) ^ (j3 << 1));
                    }
                    n2 = this;
                    break;
                case 17:
                    if (n2.o(obj, i8, i7, i9, i3)) {
                        f2.a(i10, unsafe.getObject(obj, j2), n2.m(i8));
                        break;
                    } else {
                        break;
                    }
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    i4 = i7;
                    X.n(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case 19:
                    i4 = i7;
                    X.r(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case 20:
                    i4 = i7;
                    X.t(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case 21:
                    i4 = i7;
                    X.z(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case 22:
                    i4 = i7;
                    X.s(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case 23:
                    i4 = i7;
                    X.q(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case 24:
                    i4 = i7;
                    X.p(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    i4 = i7;
                    X.m(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    i5 = i7;
                    int i14 = iArr[i8];
                    List list = (List) unsafe.getObject(obj, j2);
                    Class cls = X.f1384a;
                    if (list != null && !list.isEmpty()) {
                        f2.getClass();
                        for (int i15 = 0; i15 < list.size(); i15++) {
                            ((C0086m) f2.f1343a).l0(i14, (String) list.get(i15));
                        }
                    }
                    i7 = i5;
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    i5 = i7;
                    int i16 = iArr[i8];
                    List list2 = (List) unsafe.getObject(obj, j2);
                    W m2 = n2.m(i8);
                    Class cls2 = X.f1384a;
                    if (list2 != null && !list2.isEmpty()) {
                        f2.getClass();
                        for (int i17 = 0; i17 < list2.size(); i17++) {
                            ((C0086m) f2.f1343a).k0(i16, (AbstractC0074a) list2.get(i17), m2);
                        }
                    }
                    i7 = i5;
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    i5 = i7;
                    int i18 = iArr[i8];
                    List list3 = (List) unsafe.getObject(obj, j2);
                    Class cls3 = X.f1384a;
                    if (list3 != null && !list3.isEmpty()) {
                        f2.getClass();
                        for (int i19 = 0; i19 < list3.size(); i19++) {
                            ((C0086m) f2.f1343a).c0(i18, (C0080g) list3.get(i19));
                        }
                    }
                    i7 = i5;
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    i4 = i7;
                    z = false;
                    X.y(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    i4 = i7;
                    z = false;
                    X.o(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    i4 = i7;
                    z = false;
                    X.u(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_32 /* 32 */:
                    i4 = i7;
                    z = false;
                    X.v(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    i4 = i7;
                    z = false;
                    X.w(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    i4 = i7;
                    z = false;
                    X.x(iArr[i8], (List) unsafe.getObject(obj, j2), f2, false);
                    i7 = i4;
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    i5 = i7;
                    X.n(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    i5 = i7;
                    X.r(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 37:
                    i5 = i7;
                    X.t(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 38:
                    i5 = i7;
                    X.z(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 39:
                    i5 = i7;
                    X.s(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 40:
                    i5 = i7;
                    X.q(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 41:
                    i5 = i7;
                    X.p(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 42:
                    i5 = i7;
                    X.m(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 43:
                    i5 = i7;
                    X.y(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 44:
                    i5 = i7;
                    X.o(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 45:
                    i5 = i7;
                    X.u(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 46:
                    i5 = i7;
                    X.v(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 47:
                    i5 = i7;
                    X.w(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 48:
                    i5 = i7;
                    X.x(iArr[i8], (List) unsafe.getObject(obj, j2), f2, true);
                    i7 = i5;
                    break;
                case 49:
                    i5 = i7;
                    int i20 = iArr[i8];
                    List list4 = (List) unsafe.getObject(obj, j2);
                    W m3 = n2.m(i8);
                    Class cls4 = X.f1384a;
                    if (list4 != null && !list4.isEmpty()) {
                        f2.getClass();
                        for (int i21 = 0; i21 < list4.size(); i21++) {
                            f2.a(i20, list4.get(i21), m3);
                        }
                    }
                    i7 = i5;
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j2);
                    if (object2 != null) {
                        int i22 = 2;
                        Object obj2 = n2.f1357b[(i8 / 3) * 2];
                        n2.f1368m.getClass();
                        G g2 = ((H) obj2).f1347a;
                        C0086m c0086m3 = (C0086m) f2.f1343a;
                        c0086m3.getClass();
                        for (Map.Entry entry : ((I) object2).entrySet()) {
                            c0086m3.n0(i10, i22);
                            c0086m3.p0(H.a(g2, entry.getKey(), entry.getValue()));
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            r.b(c0086m3, g2.f1344a, 1, key);
                            i22 = 2;
                            r.b(c0086m3, g2.f1345b, 2, value);
                            i7 = i7;
                        }
                    }
                    i5 = i7;
                    i7 = i5;
                    break;
                case 51:
                    if (n2.q(obj, i10, i8)) {
                        double doubleValue = ((Double) j0.f1442c.h(j2, obj)).doubleValue();
                        C0086m c0086m4 = (C0086m) f2.f1343a;
                        c0086m4.getClass();
                        c0086m4.g0(i10, Double.doubleToRawLongBits(doubleValue));
                    }
                    break;
                case 52:
                    if (n2.q(obj, i10, i8)) {
                        float floatValue = ((Float) j0.f1442c.h(j2, obj)).floatValue();
                        C0086m c0086m5 = (C0086m) f2.f1343a;
                        c0086m5.getClass();
                        c0086m5.e0(i10, Float.floatToRawIntBits(floatValue));
                    }
                    break;
                case 53:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).q0(i10, z(j2, obj));
                    }
                    break;
                case 54:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).q0(i10, z(j2, obj));
                    }
                    break;
                case 55:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).i0(i10, y(j2, obj));
                    }
                    break;
                case 56:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).g0(i10, z(j2, obj));
                    }
                    break;
                case 57:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).e0(i10, y(j2, obj));
                    }
                    break;
                case 58:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).b0(i10, ((Boolean) j0.f1442c.h(j2, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (n2.q(obj, i10, i8)) {
                        Object object3 = unsafe.getObject(obj, j2);
                        if (object3 instanceof String) {
                            ((C0086m) f2.f1343a).l0(i10, (String) object3);
                        } else {
                            ((C0086m) f2.f1343a).c0(i10, (C0080g) object3);
                        }
                    }
                    break;
                case 60:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).k0(i10, (AbstractC0074a) unsafe.getObject(obj, j2), n2.m(i8));
                    }
                    break;
                case 61:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).c0(i10, (C0080g) unsafe.getObject(obj, j2));
                    }
                    break;
                case 62:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).o0(i10, y(j2, obj));
                    }
                    break;
                case 63:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).i0(i10, y(j2, obj));
                    }
                    break;
                case 64:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).e0(i10, y(j2, obj));
                    }
                    break;
                case 65:
                    if (n2.q(obj, i10, i8)) {
                        ((C0086m) f2.f1343a).g0(i10, z(j2, obj));
                    }
                    break;
                case 66:
                    if (n2.q(obj, i10, i8)) {
                        int y = y(j2, obj);
                        ((C0086m) f2.f1343a).o0(i10, (y >> 31) ^ (y << 1));
                    }
                    break;
                case 67:
                    if (n2.q(obj, i10, i8)) {
                        long z2 = z(j2, obj);
                        ((C0086m) f2.f1343a).q0(i10, (z2 << 1) ^ (z2 >> 63));
                    }
                    break;
                case 68:
                    if (n2.q(obj, i10, i8)) {
                        f2.a(i10, unsafe.getObject(obj, j2), n2.m(i8));
                    }
                    break;
            }
            i8 += 3;
            i6 = 1048575;
        }
        n2.f1367l.getClass();
        ((AbstractC0095w) obj).unknownFields.d(f2);
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void a(Object obj, Object obj2) {
        Object obj3;
        if (p(obj)) {
            obj2.getClass();
            int i2 = 0;
            while (true) {
                int[] iArr = this.f1356a;
                if (i2 < iArr.length) {
                    int L = L(i2);
                    long j2 = 1048575 & L;
                    int i3 = iArr[i2];
                    switch (K(L)) {
                        case 0:
                            if (n(i2, obj2)) {
                                i0 i0Var = j0.f1442c;
                                obj3 = obj;
                                i0Var.l(obj3, j2, i0Var.d(j2, obj2));
                                G(i2, obj3);
                                break;
                            }
                            break;
                        case 1:
                            if (n(i2, obj2)) {
                                i0 i0Var2 = j0.f1442c;
                                i0Var2.m(obj, j2, i0Var2.e(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 2:
                            if (n(i2, obj2)) {
                                j0.n(obj, j2, j0.f1442c.g(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 3:
                            if (n(i2, obj2)) {
                                j0.n(obj, j2, j0.f1442c.g(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 4:
                            if (n(i2, obj2)) {
                                j0.m(obj, j2, j0.f1442c.f(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 5:
                            if (n(i2, obj2)) {
                                j0.n(obj, j2, j0.f1442c.g(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 6:
                            if (n(i2, obj2)) {
                                j0.m(obj, j2, j0.f1442c.f(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 7:
                            if (n(i2, obj2)) {
                                i0 i0Var3 = j0.f1442c;
                                i0Var3.j(obj, j2, i0Var3.c(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 8:
                            if (n(i2, obj2)) {
                                j0.o(j2, obj, j0.f1442c.h(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 9:
                            s(i2, obj, obj2);
                            break;
                        case 10:
                            if (n(i2, obj2)) {
                                j0.o(j2, obj, j0.f1442c.h(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 11:
                            if (n(i2, obj2)) {
                                j0.m(obj, j2, j0.f1442c.f(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 12:
                            if (n(i2, obj2)) {
                                j0.m(obj, j2, j0.f1442c.f(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 13:
                            if (n(i2, obj2)) {
                                j0.m(obj, j2, j0.f1442c.f(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 14:
                            if (n(i2, obj2)) {
                                j0.n(obj, j2, j0.f1442c.g(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 15:
                            if (n(i2, obj2)) {
                                j0.m(obj, j2, j0.f1442c.f(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 16:
                            if (n(i2, obj2)) {
                                j0.n(obj, j2, j0.f1442c.g(j2, obj2));
                                G(i2, obj);
                                break;
                            }
                            break;
                        case 17:
                            s(i2, obj, obj2);
                            break;
                        case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case Build.API_LEVELS.API_25 /* 25 */:
                        case Build.API_LEVELS.API_26 /* 26 */:
                        case Build.API_LEVELS.API_27 /* 27 */:
                        case Build.API_LEVELS.API_28 /* 28 */:
                        case Build.API_LEVELS.API_29 /* 29 */:
                        case Build.API_LEVELS.API_30 /* 30 */:
                        case Build.API_LEVELS.API_31 /* 31 */:
                        case Build.API_LEVELS.API_32 /* 32 */:
                        case Build.API_LEVELS.API_33 /* 33 */:
                        case Build.API_LEVELS.API_34 /* 34 */:
                        case Build.API_LEVELS.API_35 /* 35 */:
                        case Build.API_LEVELS.API_36 /* 36 */:
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
                            this.f1366k.getClass();
                            i0 i0Var4 = j0.f1442c;
                            InterfaceC0096x interfaceC0096x = (InterfaceC0096x) i0Var4.h(j2, obj);
                            InterfaceC0096x interfaceC0096x2 = (InterfaceC0096x) i0Var4.h(j2, obj2);
                            U u2 = (U) interfaceC0096x;
                            int i4 = u2.f1379e;
                            int i5 = ((U) interfaceC0096x2).f1379e;
                            if (i4 > 0 && i5 > 0) {
                                if (!((AbstractC0075b) interfaceC0096x).f1400c) {
                                    interfaceC0096x = u2.c(i5 + i4);
                                }
                                ((AbstractC0075b) interfaceC0096x).addAll(interfaceC0096x2);
                            }
                            if (i4 > 0) {
                                interfaceC0096x2 = interfaceC0096x;
                            }
                            j0.o(j2, obj, interfaceC0096x2);
                            break;
                        case 50:
                            Class cls = X.f1384a;
                            i0 i0Var5 = j0.f1442c;
                            Object h2 = i0Var5.h(j2, obj);
                            Object h3 = i0Var5.h(j2, obj2);
                            this.f1368m.getClass();
                            j0.o(j2, obj, J.a(h2, h3));
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
                            if (q(obj2, i3, i2)) {
                                j0.o(j2, obj, j0.f1442c.h(j2, obj2));
                                H(obj, i3, i2);
                                break;
                            }
                            break;
                        case 60:
                            t(i2, obj, obj2);
                            break;
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                            if (q(obj2, i3, i2)) {
                                j0.o(j2, obj, j0.f1442c.h(j2, obj2));
                                H(obj, i3, i2);
                                break;
                            }
                            break;
                        case 68:
                            t(i2, obj, obj2);
                            break;
                    }
                    obj3 = obj;
                    i2 += 3;
                    obj = obj3;
                } else {
                    X.k(this.f1367l, obj, obj2);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Mutating immutable message: " + obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void b(Object obj, F f2) {
        f2.getClass();
        M(obj, f2);
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
    public final int c(androidx.datastore.preferences.protobuf.AbstractC0095w r12) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.c(androidx.datastore.preferences.protobuf.w):int");
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void d(Object obj) {
        if (p(obj)) {
            if (obj instanceof AbstractC0095w) {
                AbstractC0095w abstractC0095w = (AbstractC0095w) obj;
                abstractC0095w.k(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                abstractC0095w.memoizedHashCode = 0;
                abstractC0095w.h();
            }
            int[] iArr = this.f1356a;
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2 += 3) {
                int L = L(i2);
                long j2 = 1048575 & L;
                int K2 = K(L);
                if (K2 != 9) {
                    if (K2 != 60 && K2 != 68) {
                        switch (K2) {
                            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case Build.API_LEVELS.API_25 /* 25 */:
                            case Build.API_LEVELS.API_26 /* 26 */:
                            case Build.API_LEVELS.API_27 /* 27 */:
                            case Build.API_LEVELS.API_28 /* 28 */:
                            case Build.API_LEVELS.API_29 /* 29 */:
                            case Build.API_LEVELS.API_30 /* 30 */:
                            case Build.API_LEVELS.API_31 /* 31 */:
                            case Build.API_LEVELS.API_32 /* 32 */:
                            case Build.API_LEVELS.API_33 /* 33 */:
                            case Build.API_LEVELS.API_34 /* 34 */:
                            case Build.API_LEVELS.API_35 /* 35 */:
                            case Build.API_LEVELS.API_36 /* 36 */:
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
                                this.f1366k.getClass();
                                AbstractC0075b abstractC0075b = (AbstractC0075b) ((InterfaceC0096x) j0.f1442c.h(j2, obj));
                                if (abstractC0075b.f1400c) {
                                    abstractC0075b.f1400c = false;
                                    break;
                                } else {
                                    break;
                                }
                            case 50:
                                Unsafe unsafe = f1355o;
                                Object object = unsafe.getObject(obj, j2);
                                if (object != null) {
                                    this.f1368m.getClass();
                                    ((I) object).f1350c = false;
                                    unsafe.putObject(obj, j2, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (q(obj, iArr[i2], i2)) {
                        m(i2).d(f1355o.getObject(obj, j2));
                    }
                }
                if (n(i2, obj)) {
                    m(i2).d(f1355o.getObject(obj, j2));
                }
            }
            this.f1367l.getClass();
            d0 d0Var = ((AbstractC0095w) obj).unknownFields;
            if (d0Var.f1413e) {
                d0Var.f1413e = false;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final boolean e(Object obj) {
        int i2;
        int i3;
        int i4;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < this.f1363h) {
            int i8 = this.f1362g[i7];
            int[] iArr = this.f1356a;
            int i9 = iArr[i8];
            int L = L(i8);
            int i10 = iArr[i8 + 2];
            int i11 = i10 & 1048575;
            int i12 = 1 << (i10 >>> 20);
            if (i11 != i5) {
                if (i11 != 1048575) {
                    i6 = f1355o.getInt(obj, i11);
                }
                i3 = i8;
                i4 = i6;
                i2 = i11;
            } else {
                int i13 = i6;
                i2 = i5;
                i3 = i8;
                i4 = i13;
            }
            if ((268435456 & L) == 0 || o(obj, i3, i2, i4, i12)) {
                int K2 = K(L);
                if (K2 != 9 && K2 != 17) {
                    if (K2 != 27) {
                        if (K2 != 60 && K2 != 68) {
                            if (K2 != 49) {
                                if (K2 != 50) {
                                    continue;
                                } else {
                                    Object h2 = j0.f1442c.h(L & 1048575, obj);
                                    this.f1368m.getClass();
                                    I i14 = (I) h2;
                                    if (i14.isEmpty()) {
                                        continue;
                                    } else {
                                        if (((H) this.f1357b[(i3 / 3) * 2]).f1347a.f1345b.f1472c != s0.MESSAGE) {
                                            continue;
                                        } else {
                                            W w2 = null;
                                            for (Object obj2 : i14.values()) {
                                                if (w2 == null) {
                                                    w2 = T.f1374c.a(obj2.getClass());
                                                }
                                                if (!w2.e(obj2)) {
                                                }
                                            }
                                        }
                                    }
                                }
                                i7++;
                                i5 = i2;
                                i6 = i4;
                            }
                        } else {
                            if (q(obj, i9, i3)) {
                                if (!m(i3).e(j0.f1442c.h(L & 1048575, obj))) {
                                }
                            } else {
                                continue;
                            }
                            i7++;
                            i5 = i2;
                            i6 = i4;
                        }
                    }
                    List list = (List) j0.f1442c.h(L & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        W m2 = m(i3);
                        for (int i15 = 0; i15 < list.size(); i15++) {
                            if (m2.e(list.get(i15))) {
                            }
                        }
                    }
                    i7++;
                    i5 = i2;
                    i6 = i4;
                } else {
                    if (o(obj, i3, i2, i4, i12)) {
                        if (!m(i3).e(j0.f1442c.h(L & 1048575, obj))) {
                        }
                    } else {
                        continue;
                    }
                    i7++;
                    i5 = i2;
                    i6 = i4;
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
    public final boolean f(androidx.datastore.preferences.protobuf.AbstractC0095w r12, androidx.datastore.preferences.protobuf.AbstractC0095w r13) {
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
    public final void g(java.lang.Object r19, androidx.datastore.preferences.protobuf.C0084k r20, androidx.datastore.preferences.protobuf.C0088o r21) {
        /*
            Method dump skipped, instructions count: 1884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.g(java.lang.Object, androidx.datastore.preferences.protobuf.k, androidx.datastore.preferences.protobuf.o):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0048. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.W
    public final int h(AbstractC0095w abstractC0095w) {
        int i2;
        int U2;
        int U3;
        int U4;
        int W2;
        int U5;
        int W3;
        int U6;
        int U7;
        int T2;
        int S2;
        int U8;
        int a2;
        int c2;
        int U9;
        int size;
        int i3;
        int U10;
        int U11;
        int U12;
        int size2;
        int U13;
        int V2;
        int i4;
        int i5;
        int U14;
        int T3;
        int V3;
        N n2 = this;
        AbstractC0095w abstractC0095w2 = abstractC0095w;
        Unsafe unsafe = f1355o;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = n2.f1356a;
            if (i7 < iArr.length) {
                int L = n2.L(i7);
                int K2 = K(L);
                int i10 = iArr[i7];
                int i11 = iArr[i7 + 2];
                int i12 = i11 & 1048575;
                if (K2 <= 17) {
                    if (i12 != i6) {
                        if (i12 == 1048575) {
                            i8 = 0;
                        } else {
                            i8 = unsafe.getInt(abstractC0095w2, i12);
                        }
                        i6 = i12;
                    }
                    i2 = 1 << (i11 >>> 20);
                } else {
                    i2 = 0;
                }
                long j2 = L & 1048575;
                if (K2 >= EnumC0091s.f1474d.f1478c) {
                    int i13 = EnumC0091s.f1475e.f1478c;
                }
                switch (K2) {
                    case 0:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            U2 = C0086m.U(i10);
                            c2 = U2 + 8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            U3 = C0086m.U(i10);
                            U7 = U3 + 4;
                            i9 += U7;
                        }
                        n2 = this;
                        abstractC0095w2 = abstractC0095w;
                        break;
                    case 2:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            long j3 = unsafe.getLong(abstractC0095w2, j2);
                            U4 = C0086m.U(i10);
                            W2 = C0086m.W(j3);
                            i9 += W2 + U4;
                        }
                        n2 = this;
                        break;
                    case 3:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            long j4 = unsafe.getLong(abstractC0095w2, j2);
                            U4 = C0086m.U(i10);
                            W2 = C0086m.W(j4);
                            i9 += W2 + U4;
                        }
                        n2 = this;
                        break;
                    case 4:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            int i14 = unsafe.getInt(abstractC0095w2, j2);
                            U5 = C0086m.U(i10);
                            W3 = C0086m.W(i14);
                            S2 = W3 + U5;
                            i9 += S2;
                        }
                        n2 = this;
                        break;
                    case 5:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            U6 = C0086m.U(i10);
                            U7 = U6 + 8;
                            i9 += U7;
                        }
                        n2 = this;
                        abstractC0095w2 = abstractC0095w;
                        break;
                    case 6:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            U3 = C0086m.U(i10);
                            U7 = U3 + 4;
                            i9 += U7;
                        }
                        n2 = this;
                        abstractC0095w2 = abstractC0095w;
                        break;
                    case 7:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            U7 = C0086m.U(i10) + 1;
                            i9 += U7;
                        }
                        n2 = this;
                        abstractC0095w2 = abstractC0095w;
                        break;
                    case 8:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            Object object = unsafe.getObject(abstractC0095w2, j2);
                            if (object instanceof C0080g) {
                                T2 = C0086m.S(i10, (C0080g) object);
                            } else {
                                T2 = C0086m.T((String) object) + C0086m.U(i10);
                            }
                            i9 = T2 + i9;
                        }
                        n2 = this;
                        break;
                    case 9:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            Object object2 = unsafe.getObject(abstractC0095w2, j2);
                            W m2 = n2.m(i7);
                            Class cls = X.f1384a;
                            int U15 = C0086m.U(i10);
                            int a3 = ((AbstractC0074a) object2).a(m2);
                            i9 += C0086m.V(a3) + a3 + U15;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            S2 = C0086m.S(i10, (C0080g) unsafe.getObject(abstractC0095w2, j2));
                            i9 += S2;
                        }
                        n2 = this;
                        break;
                    case 11:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            int i15 = unsafe.getInt(abstractC0095w2, j2);
                            U5 = C0086m.U(i10);
                            W3 = C0086m.V(i15);
                            S2 = W3 + U5;
                            i9 += S2;
                        }
                        n2 = this;
                        break;
                    case 12:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            int i16 = unsafe.getInt(abstractC0095w2, j2);
                            U5 = C0086m.U(i10);
                            W3 = C0086m.W(i16);
                            S2 = W3 + U5;
                            i9 += S2;
                        }
                        n2 = this;
                        break;
                    case 13:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            U3 = C0086m.U(i10);
                            U7 = U3 + 4;
                            i9 += U7;
                        }
                        n2 = this;
                        abstractC0095w2 = abstractC0095w;
                        break;
                    case 14:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            U6 = C0086m.U(i10);
                            U7 = U6 + 8;
                            i9 += U7;
                        }
                        n2 = this;
                        abstractC0095w2 = abstractC0095w;
                        break;
                    case 15:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            int i17 = unsafe.getInt(abstractC0095w2, j2);
                            U5 = C0086m.U(i10);
                            W3 = C0086m.V((i17 >> 31) ^ (i17 << 1));
                            S2 = W3 + U5;
                            i9 += S2;
                        }
                        n2 = this;
                        break;
                    case 16:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            long j5 = unsafe.getLong(abstractC0095w2, j2);
                            U4 = C0086m.U(i10);
                            W2 = C0086m.W((j5 << 1) ^ (j5 >> 63));
                            i9 += W2 + U4;
                        }
                        n2 = this;
                        break;
                    case 17:
                        if (n2.o(abstractC0095w2, i7, i6, i8, i2)) {
                            AbstractC0074a abstractC0074a = (AbstractC0074a) unsafe.getObject(abstractC0095w2, j2);
                            W m3 = n2.m(i7);
                            U8 = C0086m.U(i10) * 2;
                            a2 = abstractC0074a.a(m3);
                            c2 = a2 + U8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        c2 = X.c(i10, (List) unsafe.getObject(abstractC0095w2, j2));
                        i9 += c2;
                        break;
                    case 19:
                        c2 = X.b(i10, (List) unsafe.getObject(abstractC0095w2, j2));
                        i9 += c2;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls2 = X.f1384a;
                        if (list.size() != 0) {
                            U9 = (C0086m.U(i10) * list.size()) + X.e(list);
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case 21:
                        List list2 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls3 = X.f1384a;
                        size = list2.size();
                        if (size != 0) {
                            i3 = X.i(list2);
                            U10 = C0086m.U(i10);
                            U9 = (U10 * size) + i3;
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case 22:
                        List list3 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls4 = X.f1384a;
                        size = list3.size();
                        if (size != 0) {
                            i3 = X.d(list3);
                            U10 = C0086m.U(i10);
                            U9 = (U10 * size) + i3;
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case 23:
                        c2 = X.c(i10, (List) unsafe.getObject(abstractC0095w2, j2));
                        i9 += c2;
                        break;
                    case 24:
                        c2 = X.b(i10, (List) unsafe.getObject(abstractC0095w2, j2));
                        i9 += c2;
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        List list4 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls5 = X.f1384a;
                        int size3 = list4.size();
                        if (size3 == 0) {
                            U11 = 0;
                        } else {
                            U11 = (C0086m.U(i10) + 1) * size3;
                        }
                        i9 += U11;
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        List list5 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls6 = X.f1384a;
                        int size4 = list5.size();
                        if (size4 != 0) {
                            U9 = C0086m.U(i10) * size4;
                            for (int i18 = 0; i18 < size4; i18++) {
                                Object obj = list5.get(i18);
                                if (obj instanceof C0080g) {
                                    int size5 = ((C0080g) obj).size();
                                    U9 = C0086m.V(size5) + size5 + U9;
                                } else {
                                    U9 = C0086m.T((String) obj) + U9;
                                }
                            }
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        List list6 = (List) unsafe.getObject(abstractC0095w2, j2);
                        W m4 = n2.m(i7);
                        Class cls7 = X.f1384a;
                        int size6 = list6.size();
                        if (size6 != 0) {
                            U12 = C0086m.U(i10) * size6;
                            for (int i19 = 0; i19 < size6; i19++) {
                                int a4 = ((AbstractC0074a) list6.get(i19)).a(m4);
                                U12 += C0086m.V(a4) + a4;
                            }
                            i9 += U12;
                            break;
                        }
                        U12 = 0;
                        i9 += U12;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        List list7 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls8 = X.f1384a;
                        int size7 = list7.size();
                        if (size7 != 0) {
                            U9 = C0086m.U(i10) * size7;
                            for (int i20 = 0; i20 < list7.size(); i20++) {
                                int size8 = ((C0080g) list7.get(i20)).size();
                                U9 += C0086m.V(size8) + size8;
                            }
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        List list8 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls9 = X.f1384a;
                        size = list8.size();
                        if (size != 0) {
                            i3 = X.h(list8);
                            U10 = C0086m.U(i10);
                            U9 = (U10 * size) + i3;
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        List list9 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls10 = X.f1384a;
                        size = list9.size();
                        if (size != 0) {
                            i3 = X.a(list9);
                            U10 = C0086m.U(i10);
                            U9 = (U10 * size) + i3;
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        c2 = X.b(i10, (List) unsafe.getObject(abstractC0095w2, j2));
                        i9 += c2;
                        break;
                    case Build.API_LEVELS.API_32 /* 32 */:
                        c2 = X.c(i10, (List) unsafe.getObject(abstractC0095w2, j2));
                        i9 += c2;
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        List list10 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls11 = X.f1384a;
                        size = list10.size();
                        if (size != 0) {
                            i3 = X.f(list10);
                            U10 = C0086m.U(i10);
                            U9 = (U10 * size) + i3;
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        List list11 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls12 = X.f1384a;
                        size = list11.size();
                        if (size != 0) {
                            i3 = X.g(list11);
                            U10 = C0086m.U(i10);
                            U9 = (U10 * size) + i3;
                            i9 += U9;
                            break;
                        }
                        U9 = 0;
                        i9 += U9;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        List list12 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls13 = X.f1384a;
                        size2 = list12.size() * 8;
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case Build.API_LEVELS.API_36 /* 36 */:
                        List list13 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls14 = X.f1384a;
                        size2 = list13.size() * 4;
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        size2 = X.e((List) unsafe.getObject(abstractC0095w2, j2));
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        size2 = X.i((List) unsafe.getObject(abstractC0095w2, j2));
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        size2 = X.d((List) unsafe.getObject(abstractC0095w2, j2));
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        List list14 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls15 = X.f1384a;
                        size2 = list14.size() * 8;
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        List list15 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls16 = X.f1384a;
                        size2 = list15.size() * 4;
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list16 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls17 = X.f1384a;
                        size2 = list16.size();
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        size2 = X.h((List) unsafe.getObject(abstractC0095w2, j2));
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        size2 = X.a((List) unsafe.getObject(abstractC0095w2, j2));
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        List list17 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls18 = X.f1384a;
                        size2 = list17.size() * 4;
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        List list18 = (List) unsafe.getObject(abstractC0095w2, j2);
                        Class cls19 = X.f1384a;
                        size2 = list18.size() * 8;
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        size2 = X.f((List) unsafe.getObject(abstractC0095w2, j2));
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        size2 = X.g((List) unsafe.getObject(abstractC0095w2, j2));
                        if (size2 > 0) {
                            U13 = C0086m.U(i10);
                            V2 = C0086m.V(size2);
                            i4 = V2 + U13;
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list19 = (List) unsafe.getObject(abstractC0095w2, j2);
                        W m5 = n2.m(i7);
                        Class cls20 = X.f1384a;
                        int size9 = list19.size();
                        if (size9 == 0) {
                            i5 = 0;
                        } else {
                            i5 = 0;
                            for (int i21 = 0; i21 < size9; i21++) {
                                i5 += ((AbstractC0074a) list19.get(i21)).a(m5) + (C0086m.U(i10) * 2);
                            }
                        }
                        i9 += i5;
                        break;
                    case 50:
                        Object object3 = unsafe.getObject(abstractC0095w2, j2);
                        Object obj2 = n2.f1357b[(i7 / 3) * 2];
                        n2.f1368m.getClass();
                        I i22 = (I) object3;
                        H h2 = (H) obj2;
                        if (!i22.isEmpty()) {
                            U12 = 0;
                            for (Map.Entry entry : i22.entrySet()) {
                                Object key = entry.getKey();
                                Object value = entry.getValue();
                                h2.getClass();
                                int U16 = C0086m.U(i10);
                                int a5 = H.a(h2.f1347a, key, value);
                                U12 += C0086m.V(a5) + a5 + U16;
                            }
                            i9 += U12;
                            break;
                        }
                        U12 = 0;
                        i9 += U12;
                    case 51:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            U2 = C0086m.U(i10);
                            c2 = U2 + 8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            U14 = C0086m.U(i10);
                            c2 = U14 + 4;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            long z = z(j2, abstractC0095w2);
                            size2 = C0086m.U(i10);
                            i4 = C0086m.W(z);
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            long z2 = z(j2, abstractC0095w2);
                            size2 = C0086m.U(i10);
                            i4 = C0086m.W(z2);
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            int y = y(j2, abstractC0095w2);
                            U8 = C0086m.U(i10);
                            a2 = C0086m.W(y);
                            c2 = a2 + U8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            U2 = C0086m.U(i10);
                            c2 = U2 + 8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            U14 = C0086m.U(i10);
                            c2 = U14 + 4;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            c2 = C0086m.U(i10) + 1;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            Object object4 = unsafe.getObject(abstractC0095w2, j2);
                            if (object4 instanceof C0080g) {
                                T3 = C0086m.S(i10, (C0080g) object4);
                            } else {
                                T3 = C0086m.T((String) object4) + C0086m.U(i10);
                            }
                            i9 = T3 + i9;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            Object object5 = unsafe.getObject(abstractC0095w2, j2);
                            W m6 = n2.m(i7);
                            Class cls21 = X.f1384a;
                            int U17 = C0086m.U(i10);
                            int a6 = ((AbstractC0074a) object5).a(m6);
                            V3 = C0086m.V(a6) + a6 + U17;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            c2 = C0086m.S(i10, (C0080g) unsafe.getObject(abstractC0095w2, j2));
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            int y2 = y(j2, abstractC0095w2);
                            U8 = C0086m.U(i10);
                            a2 = C0086m.V(y2);
                            c2 = a2 + U8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            int y3 = y(j2, abstractC0095w2);
                            U8 = C0086m.U(i10);
                            a2 = C0086m.W(y3);
                            c2 = a2 + U8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            U14 = C0086m.U(i10);
                            c2 = U14 + 4;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            U2 = C0086m.U(i10);
                            c2 = U2 + 8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            int y4 = y(j2, abstractC0095w2);
                            U8 = C0086m.U(i10);
                            a2 = C0086m.V((y4 >> 31) ^ (y4 << 1));
                            c2 = a2 + U8;
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            long z3 = z(j2, abstractC0095w2);
                            size2 = C0086m.U(i10);
                            i4 = C0086m.W((z3 << 1) ^ (z3 >> 63));
                            V3 = i4 + size2;
                            i9 += V3;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (n2.q(abstractC0095w2, i10, i7)) {
                            c2 = ((AbstractC0074a) unsafe.getObject(abstractC0095w2, j2)).a(n2.m(i7)) + (C0086m.U(i10) * 2);
                            i9 += c2;
                            break;
                        } else {
                            break;
                        }
                }
                i7 += 3;
            } else {
                n2.f1367l.getClass();
                return abstractC0095w2.unknownFields.b() + i9;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final AbstractC0095w i() {
        this.f1365j.getClass();
        return ((AbstractC0095w) this.f1360e).i();
    }

    public final boolean j(AbstractC0095w abstractC0095w, AbstractC0095w abstractC0095w2, int i2) {
        if (n(i2, abstractC0095w) == n(i2, abstractC0095w2)) {
            return true;
        }
        return false;
    }

    public final void k(int i2, Object obj, Object obj2) {
        int i3 = this.f1356a[i2];
        if (j0.f1442c.h(L(i2) & 1048575, obj) == null) {
            return;
        }
        l(i2);
    }

    public final void l(int i2) {
        if (this.f1357b[((i2 / 3) * 2) + 1] == null) {
        } else {
            throw new ClassCastException();
        }
    }

    public final W m(int i2) {
        int i3 = (i2 / 3) * 2;
        Object[] objArr = this.f1357b;
        W w2 = (W) objArr[i3];
        if (w2 != null) {
            return w2;
        }
        W a2 = T.f1374c.a((Class) objArr[i3 + 1]);
        objArr[i3] = a2;
        return a2;
    }

    public final boolean n(int i2, Object obj) {
        int i3 = this.f1356a[i2 + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int L = L(i2);
            long j3 = L & 1048575;
            switch (K(L)) {
                case 0:
                    if (Double.doubleToRawLongBits(j0.f1442c.d(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(j0.f1442c.e(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (j0.f1442c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (j0.f1442c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (j0.f1442c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (j0.f1442c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (j0.f1442c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return j0.f1442c.c(j3, obj);
                case 8:
                    Object h2 = j0.f1442c.h(j3, obj);
                    if (h2 instanceof String) {
                        return !((String) h2).isEmpty();
                    }
                    if (h2 instanceof C0080g) {
                        return !C0080g.f1417e.equals(h2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (j0.f1442c.h(j3, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !C0080g.f1417e.equals(j0.f1442c.h(j3, obj));
                case 11:
                    if (j0.f1442c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (j0.f1442c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (j0.f1442c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (j0.f1442c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (j0.f1442c.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (j0.f1442c.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (j0.f1442c.h(j3, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i3 >>> 20)) & j0.f1442c.f(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean o(Object obj, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return n(i2, obj);
        }
        if ((i4 & i5) != 0) {
            return true;
        }
        return false;
    }

    public final boolean q(Object obj, int i2, int i3) {
        if (j0.f1442c.f(this.f1356a[i3 + 2] & 1048575, obj) == i2) {
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
    public final void r(java.lang.Object r9, int r10, java.lang.Object r11, androidx.datastore.preferences.protobuf.C0088o r12, androidx.datastore.preferences.protobuf.C0084k r13) {
        /*
            r8 = this;
            int r10 = r8.L(r10)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r0
            long r0 = (long) r10
            androidx.datastore.preferences.protobuf.i0 r10 = androidx.datastore.preferences.protobuf.j0.f1442c
            java.lang.Object r10 = r10.h(r0, r9)
            androidx.datastore.preferences.protobuf.J r2 = r8.f1368m
            if (r10 != 0) goto L20
            r2.getClass()
            androidx.datastore.preferences.protobuf.I r10 = androidx.datastore.preferences.protobuf.I.f1349d
            androidx.datastore.preferences.protobuf.I r10 = r10.b()
            androidx.datastore.preferences.protobuf.j0.o(r0, r9, r10)
            goto L37
        L20:
            r2.getClass()
            r3 = r10
            androidx.datastore.preferences.protobuf.I r3 = (androidx.datastore.preferences.protobuf.I) r3
            boolean r3 = r3.f1350c
            if (r3 != 0) goto L37
            androidx.datastore.preferences.protobuf.I r3 = androidx.datastore.preferences.protobuf.I.f1349d
            androidx.datastore.preferences.protobuf.I r3 = r3.b()
            androidx.datastore.preferences.protobuf.J.a(r3, r10)
            androidx.datastore.preferences.protobuf.j0.o(r0, r9, r3)
            r10 = r3
        L37:
            r2.getClass()
            androidx.datastore.preferences.protobuf.I r10 = (androidx.datastore.preferences.protobuf.I) r10
            androidx.datastore.preferences.protobuf.H r11 = (androidx.datastore.preferences.protobuf.H) r11
            androidx.datastore.preferences.protobuf.G r9 = r11.f1347a
            r11 = 2
            r13.w(r11)
            androidx.datastore.preferences.protobuf.j r0 = r13.f1447a
            int r1 = r0.v()
            int r1 = r0.e(r1)
            java.lang.Object r2 = r9.f1346c
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
            boolean r5 = r13.x()     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
            if (r5 == 0) goto L71
            goto L53
        L71:
            androidx.datastore.preferences.protobuf.A r5 = new androidx.datastore.preferences.protobuf.A     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
            throw r5     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
        L77:
            r9 = move-exception
            goto La0
        L79:
            androidx.datastore.preferences.protobuf.r0 r5 = r9.f1345b     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
            java.lang.Class r6 = r2.getClass()     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
            java.lang.Object r4 = r13.i(r5, r6, r12)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
            goto L53
        L84:
            androidx.datastore.preferences.protobuf.r0 r5 = r9.f1344a     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
            r6 = 0
            java.lang.Object r3 = r13.i(r5, r6, r6)     // Catch: java.lang.Throwable -> L77 androidx.datastore.preferences.protobuf.C0098z -> L8c
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

    public final void s(int i2, Object obj, Object obj2) {
        if (!n(i2, obj2)) {
            return;
        }
        long L = L(i2) & 1048575;
        Unsafe unsafe = f1355o;
        Object object = unsafe.getObject(obj2, L);
        if (object != null) {
            W m2 = m(i2);
            if (!n(i2, obj)) {
                if (!p(object)) {
                    unsafe.putObject(obj, L, object);
                } else {
                    AbstractC0095w i3 = m2.i();
                    m2.a(i3, object);
                    unsafe.putObject(obj, L, i3);
                }
                G(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, L);
            if (!p(object2)) {
                AbstractC0095w i4 = m2.i();
                m2.a(i4, object2);
                unsafe.putObject(obj, L, i4);
                object2 = i4;
            }
            m2.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.f1356a[i2] + " is present but null: " + obj2);
    }

    public final void t(int i2, Object obj, Object obj2) {
        int[] iArr = this.f1356a;
        int i3 = iArr[i2];
        if (!q(obj2, i3, i2)) {
            return;
        }
        long L = L(i2) & 1048575;
        Unsafe unsafe = f1355o;
        Object object = unsafe.getObject(obj2, L);
        if (object != null) {
            W m2 = m(i2);
            if (!q(obj, i3, i2)) {
                if (!p(object)) {
                    unsafe.putObject(obj, L, object);
                } else {
                    AbstractC0095w i4 = m2.i();
                    m2.a(i4, object);
                    unsafe.putObject(obj, L, i4);
                }
                H(obj, i3, i2);
                return;
            }
            Object object2 = unsafe.getObject(obj, L);
            if (!p(object2)) {
                AbstractC0095w i5 = m2.i();
                m2.a(i5, object2);
                unsafe.putObject(obj, L, i5);
                object2 = i5;
            }
            m2.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + iArr[i2] + " is present but null: " + obj2);
    }

    public final Object u(int i2, Object obj) {
        W m2 = m(i2);
        long L = L(i2) & 1048575;
        if (!n(i2, obj)) {
            return m2.i();
        }
        Object object = f1355o.getObject(obj, L);
        if (p(object)) {
            return object;
        }
        AbstractC0095w i3 = m2.i();
        if (object != null) {
            m2.a(i3, object);
        }
        return i3;
    }

    public final Object v(Object obj, int i2, int i3) {
        W m2 = m(i3);
        if (!q(obj, i2, i3)) {
            return m2.i();
        }
        Object object = f1355o.getObject(obj, L(i3) & 1048575);
        if (p(object)) {
            return object;
        }
        AbstractC0095w i4 = m2.i();
        if (object != null) {
            m2.a(i4, object);
        }
        return i4;
    }
}
