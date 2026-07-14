package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: f, reason: collision with root package name */
    public static final d0 f1408f = new d0(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f1409a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1410b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1411c;

    /* renamed from: d, reason: collision with root package name */
    public int f1412d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1413e;

    public d0(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f1409a = i2;
        this.f1410b = iArr;
        this.f1411c = objArr;
        this.f1413e = z;
    }

    public final void a(int i2) {
        int[] iArr = this.f1410b;
        if (i2 > iArr.length) {
            int i3 = this.f1409a;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i2) {
                i2 = i4;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.f1410b = Arrays.copyOf(iArr, i2);
            this.f1411c = Arrays.copyOf(this.f1411c, i2);
        }
    }

    public final int b() {
        int U2;
        int W2;
        int U3;
        int i2 = this.f1412d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1409a; i4++) {
            int i5 = this.f1410b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                ((Integer) this.f1411c[i4]).getClass();
                                U3 = C0086m.U(i6) + 4;
                            } else {
                                throw new IllegalStateException(A.b());
                            }
                        } else {
                            U2 = C0086m.U(i6) * 2;
                            W2 = ((d0) this.f1411c[i4]).b();
                        }
                    } else {
                        U3 = C0086m.S(i6, (C0080g) this.f1411c[i4]);
                    }
                } else {
                    ((Long) this.f1411c[i4]).getClass();
                    U3 = C0086m.U(i6) + 8;
                }
                i3 = U3 + i3;
            } else {
                long longValue = ((Long) this.f1411c[i4]).longValue();
                U2 = C0086m.U(i6);
                W2 = C0086m.W(longValue);
            }
            i3 = W2 + U2 + i3;
        }
        this.f1412d = i3;
        return i3;
    }

    public final void c(int i2, Object obj) {
        if (this.f1413e) {
            a(this.f1409a + 1);
            int[] iArr = this.f1410b;
            int i3 = this.f1409a;
            iArr[i3] = i2;
            this.f1411c[i3] = obj;
            this.f1409a = i3 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void d(F f2) {
        if (this.f1409a != 0) {
            f2.getClass();
            C0086m c0086m = (C0086m) f2.f1343a;
            for (int i2 = 0; i2 < this.f1409a; i2++) {
                int i3 = this.f1410b[i2];
                Object obj = this.f1411c[i2];
                int i4 = i3 >>> 3;
                int i5 = i3 & 7;
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                if (i5 == 5) {
                                    c0086m.e0(i4, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(A.b());
                                }
                            } else {
                                c0086m.n0(i4, 3);
                                ((d0) obj).d(f2);
                                c0086m.n0(i4, 4);
                            }
                        } else {
                            c0086m.c0(i4, (C0080g) obj);
                        }
                    } else {
                        c0086m.g0(i4, ((Long) obj).longValue());
                    }
                } else {
                    c0086m.q0(i4, ((Long) obj).longValue());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        int i2 = this.f1409a;
        if (i2 == d0Var.f1409a) {
            int[] iArr = this.f1410b;
            int[] iArr2 = d0Var.f1410b;
            int i3 = 0;
            while (true) {
                if (i3 < i2) {
                    if (iArr[i3] != iArr2[i3]) {
                        break;
                    }
                    i3++;
                } else {
                    Object[] objArr = this.f1411c;
                    Object[] objArr2 = d0Var.f1411c;
                    int i4 = this.f1409a;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (objArr[i5].equals(objArr2[i5])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f1409a;
        int i3 = (527 + i2) * 31;
        int[] iArr = this.f1410b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f1411c;
        int i8 = this.f1409a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }
}
