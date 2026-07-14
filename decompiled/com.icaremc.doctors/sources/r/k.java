package r;

import java.util.Arrays;
import s.AbstractC0298a;

/* loaded from: classes.dex */
public final class k implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int[] f3574c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object[] f3575d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ int f3576e;

    public k() {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.f3574c = new int[i5];
        this.f3575d = new Object[i5];
    }

    public final void a(int i2, Object obj) {
        int i3 = this.f3576e;
        if (i3 != 0 && i2 <= this.f3574c[i3 - 1]) {
            int a2 = AbstractC0298a.a(this.f3576e, i2, this.f3574c);
            if (a2 >= 0) {
                this.f3575d[a2] = obj;
                return;
            }
            int i4 = ~a2;
            int i5 = this.f3576e;
            if (i4 < i5) {
                Object[] objArr = this.f3575d;
                if (objArr[i4] == AbstractC0296h.f3570b) {
                    this.f3574c[i4] = i2;
                    objArr[i4] = obj;
                    return;
                }
            }
            if (i5 >= this.f3574c.length) {
                int i6 = (i5 + 1) * 4;
                int i7 = 4;
                while (true) {
                    if (i7 >= 32) {
                        break;
                    }
                    int i8 = (1 << i7) - 12;
                    if (i6 <= i8) {
                        i6 = i8;
                        break;
                    }
                    i7++;
                }
                int i9 = i6 / 4;
                int[] copyOf = Arrays.copyOf(this.f3574c, i9);
                kotlin.jvm.internal.h.d(copyOf, "copyOf(this, newSize)");
                this.f3574c = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.f3575d, i9);
                kotlin.jvm.internal.h.d(copyOf2, "copyOf(this, newSize)");
                this.f3575d = copyOf2;
            }
            int i10 = this.f3576e;
            if (i10 - i4 != 0) {
                int[] iArr = this.f3574c;
                int i11 = i4 + 1;
                R0.i.X(i11, i4, i10, iArr, iArr);
                Object[] objArr2 = this.f3575d;
                R0.i.Y(objArr2, objArr2, i11, i4, this.f3576e);
            }
            this.f3574c[i4] = i2;
            this.f3575d[i4] = obj;
            this.f3576e++;
            return;
        }
        if (i3 >= this.f3574c.length) {
            int i12 = (i3 + 1) * 4;
            int i13 = 4;
            while (true) {
                if (i13 >= 32) {
                    break;
                }
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
                i13++;
            }
            int i15 = i12 / 4;
            int[] copyOf3 = Arrays.copyOf(this.f3574c, i15);
            kotlin.jvm.internal.h.d(copyOf3, "copyOf(this, newSize)");
            this.f3574c = copyOf3;
            Object[] copyOf4 = Arrays.copyOf(this.f3575d, i15);
            kotlin.jvm.internal.h.d(copyOf4, "copyOf(this, newSize)");
            this.f3575d = copyOf4;
        }
        this.f3574c[i3] = i2;
        this.f3575d[i3] = obj;
        this.f3576e = i3 + 1;
    }

    public final Object clone() {
        Object clone = super.clone();
        kotlin.jvm.internal.h.c(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        k kVar = (k) clone;
        kVar.f3574c = (int[]) this.f3574c.clone();
        kVar.f3575d = (Object[]) this.f3575d.clone();
        return kVar;
    }

    public final String toString() {
        int i2 = this.f3576e;
        if (i2 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i2 * 28);
        sb.append('{');
        int i3 = this.f3576e;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(this.f3574c[i4]);
            sb.append('=');
            Object obj = this.f3575d[i4];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.d(sb2, "buffer.toString()");
        return sb2;
    }
}
