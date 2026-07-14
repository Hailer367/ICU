package x;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f3959e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f3960a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3961b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3962c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3963d;

    public b(int i2, int i3, int i4, int i5) {
        this.f3960a = i2;
        this.f3961b = i3;
        this.f3962c = i4;
        this.f3963d = i5;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return f3959e;
        }
        return new b(i2, i3, i4, i5);
    }

    public static b b(Insets insets) {
        int i2;
        int i3;
        int i4;
        int i5;
        i2 = insets.left;
        i3 = insets.top;
        i4 = insets.right;
        i5 = insets.bottom;
        return a(i2, i3, i4, i5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f3963d == bVar.f3963d && this.f3960a == bVar.f3960a && this.f3962c == bVar.f3962c && this.f3961b == bVar.f3961b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f3960a * 31) + this.f3961b) * 31) + this.f3962c) * 31) + this.f3963d;
    }

    public final String toString() {
        return "Insets{left=" + this.f3960a + ", top=" + this.f3961b + ", right=" + this.f3962c + ", bottom=" + this.f3963d + '}';
    }
}
