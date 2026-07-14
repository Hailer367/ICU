package t;

import java.util.Arrays;
import u.AbstractC0665a;

/* renamed from: t.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0662k implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int[] f6197f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object[] f6198g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ int f6199h;

    public C0662k() {
        int i4;
        int i5 = 4;
        while (true) {
            i4 = 40;
            if (i5 >= 32) {
                break;
            }
            int i6 = (1 << i5) - 12;
            if (40 <= i6) {
                i4 = i6;
                break;
            }
            i5++;
        }
        int i7 = i4 / 4;
        this.f6197f = new int[i7];
        this.f6198g = new Object[i7];
    }

    public final void a(int i4, Object obj) {
        int i5 = this.f6199h;
        if (i5 != 0 && i4 <= this.f6197f[i5 - 1]) {
            int a4 = AbstractC0665a.a(this.f6199h, i4, this.f6197f);
            if (a4 >= 0) {
                this.f6198g[a4] = obj;
                return;
            }
            int i6 = ~a4;
            int i7 = this.f6199h;
            if (i6 < i7) {
                Object[] objArr = this.f6198g;
                if (objArr[i6] == AbstractC0659h.f6187b) {
                    this.f6197f[i6] = i4;
                    objArr[i6] = obj;
                    return;
                }
            }
            if (i7 >= this.f6197f.length) {
                int i8 = (i7 + 1) * 4;
                int i9 = 4;
                while (true) {
                    if (i9 >= 32) {
                        break;
                    }
                    int i10 = (1 << i9) - 12;
                    if (i8 <= i10) {
                        i8 = i10;
                        break;
                    }
                    i9++;
                }
                int i11 = i8 / 4;
                int[] copyOf = Arrays.copyOf(this.f6197f, i11);
                T2.h.d(copyOf, "copyOf(this, newSize)");
                this.f6197f = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.f6198g, i11);
                T2.h.d(copyOf2, "copyOf(this, newSize)");
                this.f6198g = copyOf2;
            }
            int i12 = this.f6199h;
            if (i12 - i6 != 0) {
                int[] iArr = this.f6197f;
                int i13 = i6 + 1;
                I2.d.V(i13, i6, iArr, iArr, i12);
                Object[] objArr2 = this.f6198g;
                I2.d.W(objArr2, objArr2, i13, i6, this.f6199h);
            }
            this.f6197f[i6] = i4;
            this.f6198g[i6] = obj;
            this.f6199h++;
            return;
        }
        if (i5 >= this.f6197f.length) {
            int i14 = (i5 + 1) * 4;
            int i15 = 4;
            while (true) {
                if (i15 >= 32) {
                    break;
                }
                int i16 = (1 << i15) - 12;
                if (i14 <= i16) {
                    i14 = i16;
                    break;
                }
                i15++;
            }
            int i17 = i14 / 4;
            int[] copyOf3 = Arrays.copyOf(this.f6197f, i17);
            T2.h.d(copyOf3, "copyOf(this, newSize)");
            this.f6197f = copyOf3;
            Object[] copyOf4 = Arrays.copyOf(this.f6198g, i17);
            T2.h.d(copyOf4, "copyOf(this, newSize)");
            this.f6198g = copyOf4;
        }
        this.f6197f[i5] = i4;
        this.f6198g[i5] = obj;
        this.f6199h = i5 + 1;
    }

    public final Object clone() {
        Object clone = super.clone();
        T2.h.c(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        C0662k c0662k = (C0662k) clone;
        c0662k.f6197f = (int[]) this.f6197f.clone();
        c0662k.f6198g = (Object[]) this.f6198g.clone();
        return c0662k;
    }

    public final String toString() {
        int i4 = this.f6199h;
        if (i4 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i4 * 28);
        sb.append('{');
        int i5 = this.f6199h;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(this.f6197f[i6]);
            sb.append('=');
            Object obj = this.f6198g[i6];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        T2.h.d(sb2, "buffer.toString()");
        return sb2;
    }
}
