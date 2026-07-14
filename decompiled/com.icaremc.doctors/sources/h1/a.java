package h1;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class a implements Iterable, d1.a {

    /* renamed from: c, reason: collision with root package name */
    public final int f2321c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2322d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2323e;

    public a(int i2, int i3, int i4) {
        if (i4 != 0) {
            if (i4 != Integer.MIN_VALUE) {
                this.f2321c = i2;
                if (i4 > 0) {
                    if (i2 < i3) {
                        int i5 = i3 % i4;
                        int i6 = i2 % i4;
                        int i7 = ((i5 < 0 ? i5 + i4 : i5) - (i6 < 0 ? i6 + i4 : i6)) % i4;
                        i3 -= i7 < 0 ? i7 + i4 : i7;
                    }
                } else if (i4 < 0) {
                    if (i2 > i3) {
                        int i8 = -i4;
                        int i9 = i2 % i8;
                        int i10 = i3 % i8;
                        int i11 = ((i9 < 0 ? i9 + i8 : i9) - (i10 < 0 ? i10 + i8 : i10)) % i8;
                        i3 += i11 < 0 ? i11 + i8 : i11;
                    }
                } else {
                    throw new IllegalArgumentException("Step is zero.");
                }
                this.f2322d = i3;
                this.f2323e = i4;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f2321c, this.f2322d, this.f2323e);
    }
}
