package r;

import java.util.Arrays;
import s.AbstractC0298a;

/* renamed from: r.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0295g implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f3565c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ long[] f3566d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object[] f3567e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f3568f;

    public C0295g() {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 80;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (80 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 8;
        this.f3566d = new long[i5];
        this.f3567e = new Object[i5];
    }

    public final void a() {
        int i2 = this.f3568f;
        Object[] objArr = this.f3567e;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f3568f = 0;
        this.f3565c = false;
    }

    public final Object b(long j2) {
        Object obj;
        int b2 = AbstractC0298a.b(this.f3566d, this.f3568f, j2);
        if (b2 >= 0 && (obj = this.f3567e[b2]) != AbstractC0296h.f3569a) {
            return obj;
        }
        return null;
    }

    public final long c(int i2) {
        int i3;
        if (i2 >= 0 && i2 < (i3 = this.f3568f)) {
            if (this.f3565c) {
                long[] jArr = this.f3566d;
                Object[] objArr = this.f3567e;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj = objArr[i5];
                    if (obj != AbstractC0296h.f3569a) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr[i4] = obj;
                            objArr[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f3565c = false;
                this.f3568f = i4;
            }
            return this.f3566d[i2];
        }
        throw new IllegalArgumentException(O.a.c(i2, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final Object clone() {
        Object clone = super.clone();
        kotlin.jvm.internal.h.c(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        C0295g c0295g = (C0295g) clone;
        c0295g.f3566d = (long[]) this.f3566d.clone();
        c0295g.f3567e = (Object[]) this.f3567e.clone();
        return c0295g;
    }

    public final void d(long j2, Object obj) {
        Object obj2 = AbstractC0296h.f3569a;
        int b2 = AbstractC0298a.b(this.f3566d, this.f3568f, j2);
        if (b2 >= 0) {
            this.f3567e[b2] = obj;
            return;
        }
        int i2 = ~b2;
        int i3 = this.f3568f;
        if (i2 < i3) {
            Object[] objArr = this.f3567e;
            if (objArr[i2] == obj2) {
                this.f3566d[i2] = j2;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f3565c) {
            long[] jArr = this.f3566d;
            if (i3 >= jArr.length) {
                Object[] objArr2 = this.f3567e;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj3 = objArr2[i5];
                    if (obj3 != obj2) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr2[i4] = obj3;
                            objArr2[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f3565c = false;
                this.f3568f = i4;
                i2 = ~AbstractC0298a.b(this.f3566d, i4, j2);
            }
        }
        int i6 = this.f3568f;
        if (i6 >= this.f3566d.length) {
            int i7 = (i6 + 1) * 8;
            int i8 = 4;
            while (true) {
                if (i8 >= 32) {
                    break;
                }
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
                i8++;
            }
            int i10 = i7 / 8;
            long[] copyOf = Arrays.copyOf(this.f3566d, i10);
            kotlin.jvm.internal.h.d(copyOf, "copyOf(this, newSize)");
            this.f3566d = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f3567e, i10);
            kotlin.jvm.internal.h.d(copyOf2, "copyOf(this, newSize)");
            this.f3567e = copyOf2;
        }
        int i11 = this.f3568f - i2;
        if (i11 != 0) {
            long[] jArr2 = this.f3566d;
            int i12 = i2 + 1;
            kotlin.jvm.internal.h.e(jArr2, "<this>");
            System.arraycopy(jArr2, i2, jArr2, i12, i11);
            Object[] objArr3 = this.f3567e;
            R0.i.Y(objArr3, objArr3, i12, i2, this.f3568f);
        }
        this.f3566d[i2] = j2;
        this.f3567e[i2] = obj;
        this.f3568f++;
    }

    public final int e() {
        if (this.f3565c) {
            int i2 = this.f3568f;
            long[] jArr = this.f3566d;
            Object[] objArr = this.f3567e;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != AbstractC0296h.f3569a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f3565c = false;
            this.f3568f = i3;
        }
        return this.f3568f;
    }

    public final Object f(int i2) {
        int i3;
        if (i2 >= 0 && i2 < (i3 = this.f3568f)) {
            if (this.f3565c) {
                long[] jArr = this.f3566d;
                Object[] objArr = this.f3567e;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj = objArr[i5];
                    if (obj != AbstractC0296h.f3569a) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr[i4] = obj;
                            objArr[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f3565c = false;
                this.f3568f = i4;
            }
            return this.f3567e[i2];
        }
        throw new IllegalArgumentException(O.a.c(i2, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3568f * 28);
        sb.append('{');
        int i2 = this.f3568f;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(c(i3));
            sb.append('=');
            Object f2 = f(i3);
            if (f2 != sb) {
                sb.append(f2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
