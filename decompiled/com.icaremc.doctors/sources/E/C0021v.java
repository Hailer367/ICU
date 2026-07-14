package E;

import android.graphics.Point;

/* renamed from: E.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0021v {

    /* renamed from: a, reason: collision with root package name */
    public final int f257a;

    /* renamed from: b, reason: collision with root package name */
    public final int f258b;

    /* renamed from: c, reason: collision with root package name */
    public final Point f259c;

    public C0021v(int i2, int i3, Point point) {
        int i4 = point.x;
        int i5 = point.y;
        this.f257a = i2;
        this.f258b = i3;
        this.f259c = new Point(i4, i5);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0021v) {
            C0021v c0021v = (C0021v) obj;
            if (this.f257a == c0021v.f257a && this.f258b == c0021v.f258b && this.f259c.equals(c0021v.f259c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f259c.hashCode() + (((this.f257a * 31) + this.f258b) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("RoundedCornerCompat{position=");
        int i2 = this.f257a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
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
        sb.append(this.f258b);
        sb.append(", center=");
        sb.append(this.f259c);
        sb.append('}');
        return sb.toString();
    }
}
