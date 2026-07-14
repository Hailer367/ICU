package I;

import android.graphics.Point;

/* renamed from: I.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0069x {

    /* renamed from: a, reason: collision with root package name */
    public final int f793a;

    /* renamed from: b, reason: collision with root package name */
    public final int f794b;

    /* renamed from: c, reason: collision with root package name */
    public final Point f795c;

    public C0069x(int i4, int i5, Point point) {
        int i6 = point.x;
        int i7 = point.y;
        this.f793a = i4;
        this.f794b = i5;
        this.f795c = new Point(i6, i7);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0069x) {
            C0069x c0069x = (C0069x) obj;
            if (this.f793a == c0069x.f793a && this.f794b == c0069x.f794b && this.f795c.equals(c0069x.f795c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f795c.hashCode() + (((this.f793a * 31) + this.f794b) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("RoundedCornerCompat{position=");
        int i4 = this.f793a;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        str = "Invalid";
                    } else {
                        str = "BottomLeft";
                    }
                } else {
                    str = "BottomRight";
                }
            } else {
                str = "TopRight";
            }
        } else {
            str = "TopLeft";
        }
        sb.append(str);
        sb.append(", radius=");
        sb.append(this.f794b);
        sb.append(", center=");
        sb.append(this.f795c);
        sb.append('}');
        return sb.toString();
    }
}
