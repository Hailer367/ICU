package t;

import java.util.Arrays;
import u.AbstractC0665a;

/* renamed from: t.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0658g implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f6182f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ long[] f6183g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object[] f6184h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ int f6185i;

    public C0658g() {
        int i4;
        int i5 = 4;
        while (true) {
            i4 = 80;
            if (i5 >= 32) {
                break;
            }
            int i6 = (1 << i5) - 12;
            if (80 <= i6) {
                i4 = i6;
                break;
            }
            i5++;
        }
        int i7 = i4 / 8;
        this.f6183g = new long[i7];
        this.f6184h = new Object[i7];
    }

    public final void a(long j4, Object obj) {
        Object obj2 = AbstractC0659h.f6186a;
        int b4 = AbstractC0665a.b(this.f6183g, this.f6185i, j4);
        if (b4 >= 0) {
            this.f6184h[b4] = obj;
            return;
        }
        int i4 = ~b4;
        int i5 = this.f6185i;
        if (i4 < i5) {
            Object[] objArr = this.f6184h;
            if (objArr[i4] == obj2) {
                this.f6183g[i4] = j4;
                objArr[i4] = obj;
                return;
            }
        }
        if (this.f6182f) {
            long[] jArr = this.f6183g;
            if (i5 >= jArr.length) {
                Object[] objArr2 = this.f6184h;
                int i6 = 0;
                for (int i7 = 0; i7 < i5; i7++) {
                    Object obj3 = objArr2[i7];
                    if (obj3 != obj2) {
                        if (i7 != i6) {
                            jArr[i6] = jArr[i7];
                            objArr2[i6] = obj3;
                            objArr2[i7] = null;
                        }
                        i6++;
                    }
                }
                this.f6182f = false;
                this.f6185i = i6;
                i4 = ~AbstractC0665a.b(this.f6183g, i6, j4);
            }
        }
        int i8 = this.f6185i;
        if (i8 >= this.f6183g.length) {
            int i9 = (i8 + 1) * 8;
            int i10 = 4;
            while (true) {
                if (i10 >= 32) {
                    break;
                }
                int i11 = (1 << i10) - 12;
                if (i9 <= i11) {
                    i9 = i11;
                    break;
                }
                i10++;
            }
            int i12 = i9 / 8;
            long[] copyOf = Arrays.copyOf(this.f6183g, i12);
            T2.h.d(copyOf, "copyOf(this, newSize)");
            this.f6183g = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f6184h, i12);
            T2.h.d(copyOf2, "copyOf(this, newSize)");
            this.f6184h = copyOf2;
        }
        int i13 = this.f6185i - i4;
        if (i13 != 0) {
            long[] jArr2 = this.f6183g;
            int i14 = i4 + 1;
            T2.h.e(jArr2, "<this>");
            System.arraycopy(jArr2, i4, jArr2, i14, i13);
            Object[] objArr3 = this.f6184h;
            I2.d.W(objArr3, objArr3, i14, i4, this.f6185i);
        }
        this.f6183g[i4] = j4;
        this.f6184h[i4] = obj;
        this.f6185i++;
    }

    public final Object clone() {
        Object clone = super.clone();
        T2.h.c(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        C0658g c0658g = (C0658g) clone;
        c0658g.f6183g = (long[]) this.f6183g.clone();
        c0658g.f6184h = (Object[]) this.f6184h.clone();
        return c0658g;
    }

    public final String toString() {
        int i4;
        int i5;
        if (this.f6182f) {
            int i6 = this.f6185i;
            long[] jArr = this.f6183g;
            Object[] objArr = this.f6184h;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != AbstractC0659h.f6186a) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.f6182f = false;
            this.f6185i = i7;
        }
        if (this.f6185i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6185i * 28);
        sb.append('{');
        int i9 = this.f6185i;
        for (int i10 = 0; i10 < i9; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            if (i10 >= 0 && i10 < (i4 = this.f6185i)) {
                if (this.f6182f) {
                    long[] jArr2 = this.f6183g;
                    Object[] objArr2 = this.f6184h;
                    int i11 = 0;
                    for (int i12 = 0; i12 < i4; i12++) {
                        Object obj2 = objArr2[i12];
                        if (obj2 != AbstractC0659h.f6186a) {
                            if (i12 != i11) {
                                jArr2[i11] = jArr2[i12];
                                objArr2[i11] = obj2;
                                objArr2[i12] = null;
                            }
                            i11++;
                        }
                    }
                    this.f6182f = false;
                    this.f6185i = i11;
                }
                sb.append(this.f6183g[i10]);
                sb.append('=');
                if (i10 >= 0 && i10 < (i5 = this.f6185i)) {
                    if (this.f6182f) {
                        long[] jArr3 = this.f6183g;
                        Object[] objArr3 = this.f6184h;
                        int i13 = 0;
                        for (int i14 = 0; i14 < i5; i14++) {
                            Object obj3 = objArr3[i14];
                            if (obj3 != AbstractC0659h.f6186a) {
                                if (i14 != i13) {
                                    jArr3[i13] = jArr3[i14];
                                    objArr3[i13] = obj3;
                                    objArr3[i14] = null;
                                }
                                i13++;
                            }
                        }
                        this.f6182f = false;
                        this.f6185i = i13;
                    }
                    Object obj4 = this.f6184h[i10];
                    if (obj4 != sb) {
                        sb.append(obj4);
                    } else {
                        sb.append("(this Map)");
                    }
                } else {
                    throw new IllegalArgumentException(A2.i.g(i10, "Expected index to be within 0..size()-1, but was ").toString());
                }
            } else {
                throw new IllegalArgumentException(A2.i.g(i10, "Expected index to be within 0..size()-1, but was ").toString());
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        T2.h.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
