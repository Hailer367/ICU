package X2;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class a implements Iterable, U2.a {

    /* renamed from: f, reason: collision with root package name */
    public final int f2003f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2004g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2005h;

    public a(int i4, int i5, int i6) {
        if (i6 != 0) {
            if (i6 != Integer.MIN_VALUE) {
                this.f2003f = i4;
                if (i6 > 0) {
                    if (i4 < i5) {
                        int i7 = i5 % i6;
                        int i8 = i4 % i6;
                        int i9 = ((i7 < 0 ? i7 + i6 : i7) - (i8 < 0 ? i8 + i6 : i8)) % i6;
                        i5 -= i9 < 0 ? i9 + i6 : i9;
                    }
                } else if (i6 < 0) {
                    if (i4 > i5) {
                        int i10 = -i6;
                        int i11 = i4 % i10;
                        int i12 = i5 % i10;
                        int i13 = ((i11 < 0 ? i11 + i10 : i11) - (i12 < 0 ? i12 + i10 : i12)) % i10;
                        i5 += i13 < 0 ? i13 + i10 : i13;
                    }
                } else {
                    throw new IllegalArgumentException("Step is zero.");
                }
                this.f2004g = i5;
                this.f2005h = i6;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f2003f, this.f2004g, this.f2005h);
    }
}
