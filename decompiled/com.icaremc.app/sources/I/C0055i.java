package I;

import java.util.Objects;

/* renamed from: I.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0055i {

    /* renamed from: a, reason: collision with root package name */
    public final String f743a;

    /* renamed from: b, reason: collision with root package name */
    public final int f744b;

    /* renamed from: c, reason: collision with root package name */
    public final int f745c;

    public C0055i(String str, int i4, int i5) {
        this.f743a = str;
        this.f744b = i4;
        this.f745c = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0055i) {
            C0055i c0055i = (C0055i) obj;
            if (Objects.equals(this.f743a, c0055i.f743a) && this.f744b == c0055i.f744b && this.f745c == c0055i.f745c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        Integer valueOf = Integer.valueOf(this.f744b);
        Integer valueOf2 = Integer.valueOf(this.f745c);
        Float valueOf3 = Float.valueOf(1.0f);
        return Objects.hash(this.f743a, valueOf, valueOf2, valueOf3, 0, 0, 0, valueOf3);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("DisplayShapeCompat{ spec=");
        String str = this.f743a;
        if (str != null) {
            obj = Integer.valueOf(str.hashCode());
        } else {
            obj = "null";
        }
        sb.append(obj);
        sb.append(" displayWidth=");
        sb.append(this.f744b);
        sb.append(" displayHeight=");
        sb.append(this.f745c);
        sb.append(" physicalPixelDisplaySizeRatio=1.0 rotation=0 offsetX=0 offsetY=0 scale=1.0}");
        return sb.toString();
    }
}
