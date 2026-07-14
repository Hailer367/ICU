package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: f, reason: collision with root package name */
    public static final d0 f2626f = new d0(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f2627a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2628b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f2629c;

    /* renamed from: d, reason: collision with root package name */
    public int f2630d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2631e;

    public d0(int i4, int[] iArr, Object[] objArr, boolean z) {
        this.f2627a = i4;
        this.f2628b = iArr;
        this.f2629c = objArr;
        this.f2631e = z;
    }

    public final void a(int i4) {
        int[] iArr = this.f2628b;
        if (i4 > iArr.length) {
            int i5 = this.f2627a;
            int i6 = (i5 / 2) + i5;
            if (i6 >= i4) {
                i4 = i6;
            }
            if (i4 < 8) {
                i4 = 8;
            }
            this.f2628b = Arrays.copyOf(iArr, i4);
            this.f2629c = Arrays.copyOf(this.f2629c, i4);
        }
    }

    public final int b() {
        int X3;
        int Z3;
        int X4;
        int i4 = this.f2630d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f2627a; i6++) {
            int i7 = this.f2628b[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            if (i9 == 5) {
                                ((Integer) this.f2629c[i6]).getClass();
                                X4 = C0156m.X(i8) + 4;
                            } else {
                                throw new IllegalStateException(A.b());
                            }
                        } else {
                            X3 = C0156m.X(i8) * 2;
                            Z3 = ((d0) this.f2629c[i6]).b();
                        }
                    } else {
                        X4 = C0156m.V(i8, (C0150g) this.f2629c[i6]);
                    }
                } else {
                    ((Long) this.f2629c[i6]).getClass();
                    X4 = C0156m.X(i8) + 8;
                }
                i5 = X4 + i5;
            } else {
                long longValue = ((Long) this.f2629c[i6]).longValue();
                X3 = C0156m.X(i8);
                Z3 = C0156m.Z(longValue);
            }
            i5 = Z3 + X3 + i5;
        }
        this.f2630d = i5;
        return i5;
    }

    public final void c(int i4, Object obj) {
        if (this.f2631e) {
            a(this.f2627a + 1);
            int[] iArr = this.f2628b;
            int i5 = this.f2627a;
            iArr[i5] = i4;
            this.f2629c[i5] = obj;
            this.f2627a = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void d(F f4) {
        if (this.f2627a != 0) {
            f4.getClass();
            C0156m c0156m = (C0156m) f4.f2563a;
            for (int i4 = 0; i4 < this.f2627a; i4++) {
                int i5 = this.f2628b[i4];
                Object obj = this.f2629c[i4];
                int i6 = i5 >>> 3;
                int i7 = i5 & 7;
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 != 2) {
                            if (i7 != 3) {
                                if (i7 == 5) {
                                    c0156m.h0(i6, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(A.b());
                                }
                            } else {
                                c0156m.q0(i6, 3);
                                ((d0) obj).d(f4);
                                c0156m.q0(i6, 4);
                            }
                        } else {
                            c0156m.f0(i6, (C0150g) obj);
                        }
                    } else {
                        c0156m.j0(((Long) obj).longValue(), i6);
                    }
                } else {
                    c0156m.t0(((Long) obj).longValue(), i6);
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
        int i4 = this.f2627a;
        if (i4 == d0Var.f2627a) {
            int[] iArr = this.f2628b;
            int[] iArr2 = d0Var.f2628b;
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    if (iArr[i5] != iArr2[i5]) {
                        break;
                    }
                    i5++;
                } else {
                    Object[] objArr = this.f2629c;
                    Object[] objArr2 = d0Var.f2629c;
                    int i6 = this.f2627a;
                    for (int i7 = 0; i7 < i6; i7++) {
                        if (objArr[i7].equals(objArr2[i7])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.f2627a;
        int i5 = (527 + i4) * 31;
        int[] iArr = this.f2628b;
        int i6 = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i4; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i5 + i7) * 31;
        Object[] objArr = this.f2629c;
        int i10 = this.f2627a;
        for (int i11 = 0; i11 < i10; i11++) {
            i6 = (i6 * 31) + objArr[i11].hashCode();
        }
        return i9 + i6;
    }
}
