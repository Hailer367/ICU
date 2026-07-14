package B;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f123e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f124a;

    /* renamed from: b, reason: collision with root package name */
    public final int f125b;

    /* renamed from: c, reason: collision with root package name */
    public final int f126c;

    /* renamed from: d, reason: collision with root package name */
    public final int f127d;

    public c(int i4, int i5, int i6, int i7) {
        this.f124a = i4;
        this.f125b = i5;
        this.f126c = i6;
        this.f127d = i7;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f124a, cVar2.f124a), Math.max(cVar.f125b, cVar2.f125b), Math.max(cVar.f126c, cVar2.f126c), Math.max(cVar.f127d, cVar2.f127d));
    }

    public static c b(int i4, int i5, int i6, int i7) {
        if (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            return f123e;
        }
        return new c(i4, i5, i6, i7);
    }

    public static c c(Insets insets) {
        int i4;
        int i5;
        int i6;
        int i7;
        i4 = insets.left;
        i5 = insets.top;
        i6 = insets.right;
        i7 = insets.bottom;
        return b(i4, i5, i6, i7);
    }

    public final Insets d() {
        return b.b(this.f124a, this.f125b, this.f126c, this.f127d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f127d == cVar.f127d && this.f124a == cVar.f124a && this.f126c == cVar.f126c && this.f125b == cVar.f125b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f124a * 31) + this.f125b) * 31) + this.f126c) * 31) + this.f127d;
    }

    public final String toString() {
        return "Insets{left=" + this.f124a + ", top=" + this.f125b + ", right=" + this.f126c + ", bottom=" + this.f127d + '}';
    }
}
