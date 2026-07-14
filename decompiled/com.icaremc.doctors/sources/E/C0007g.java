package E;

import java.util.Objects;

/* renamed from: E.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0007g {

    /* renamed from: a, reason: collision with root package name */
    public final String f224a;

    /* renamed from: b, reason: collision with root package name */
    public final int f225b;

    /* renamed from: c, reason: collision with root package name */
    public final int f226c;

    public C0007g(String str, int i2, int i3) {
        this.f224a = str;
        this.f225b = i2;
        this.f226c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0007g) {
            C0007g c0007g = (C0007g) obj;
            if (Objects.equals(this.f224a, c0007g.f224a) && this.f225b == c0007g.f225b && this.f226c == c0007g.f226c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        Integer valueOf = Integer.valueOf(this.f225b);
        Integer valueOf2 = Integer.valueOf(this.f226c);
        Float valueOf3 = Float.valueOf(1.0f);
        return Objects.hash(this.f224a, valueOf, valueOf2, valueOf3, 0, 0, 0, valueOf3);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("DisplayShapeCompat{ spec=");
        String str = this.f224a;
        if (str != null) {
            obj = Integer.valueOf(str.hashCode());
        } else {
            obj = "null";
        }
        sb.append(obj);
        sb.append(" displayWidth=");
        sb.append(this.f225b);
        sb.append(" displayHeight=");
        sb.append(this.f226c);
        sb.append(" physicalPixelDisplaySizeRatio=1.0 rotation=0 offsetX=0 offsetY=0 scale=1.0}");
        return sb.toString();
    }
}
