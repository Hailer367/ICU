package E;

import com.google.firebase.encoders.json.BuildConfig;
import java.util.Objects;

/* renamed from: E.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0008h {

    /* renamed from: a, reason: collision with root package name */
    public final C0007g f229a;

    static {
        new C0008h(BuildConfig.FLAVOR, 0, 0);
    }

    public C0008h(String str, int i2, int i3) {
        this.f229a = new C0007g(str, i2, i3);
    }

    public static C0008h a(int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        String sb;
        if (z) {
            int i8 = i2 / 2;
            int i9 = i3 / 2;
            sb = "M0," + i9 + " A" + i8 + "," + i9 + " 0 1,1 " + i2 + "," + i9 + " A" + i8 + "," + i9 + " 0 1,1 0," + i9 + " Z";
        } else {
            StringBuilder sb2 = new StringBuilder("M ");
            int min = Math.min(i2 / 2, i3 / 2);
            int min2 = Math.min(min, i4);
            int min3 = Math.min(min, i5);
            int min4 = Math.min(min, i6);
            int min5 = Math.min(min, i7);
            sb2.append(min2);
            sb2.append(",0 L ");
            sb2.append(i2 - min3);
            sb2.append(",0");
            if (min3 > 0) {
                sb2.append(" A ");
                sb2.append(min3);
                sb2.append(",");
                sb2.append(min3);
                sb2.append(" 0 0,1 ");
                sb2.append(i2);
                sb2.append(",");
                sb2.append(min3);
            }
            sb2.append(" L ");
            sb2.append(i2);
            sb2.append(",");
            sb2.append(i3 - min4);
            if (min4 > 0) {
                sb2.append(" A ");
                sb2.append(min4);
                sb2.append(",");
                sb2.append(min4);
                sb2.append(" 0 0,1 ");
                sb2.append(i2 - min4);
                sb2.append(",");
                sb2.append(i3);
            }
            sb2.append(" L ");
            sb2.append(min5);
            sb2.append(",");
            sb2.append(i3);
            if (min5 > 0) {
                sb2.append(" A ");
                sb2.append(min5);
                sb2.append(",");
                sb2.append(min5);
                sb2.append(" 0 0,1 0,");
                sb2.append(i3 - min5);
            }
            if (min2 > 0) {
                sb2.append(" L 0,");
                sb2.append(min2);
                sb2.append(" A ");
                sb2.append(min2);
                sb2.append(",");
                sb2.append(min2);
                sb2.append(" 0 0,1 ");
                sb2.append(min2);
                sb2.append(",0");
            }
            sb2.append(" Z");
            sb = sb2.toString();
        }
        return new C0008h(sb, i2, i3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0008h)) {
            return false;
        }
        return Objects.equals(this.f229a, ((C0008h) obj).f229a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f229a);
    }

    public final String toString() {
        return this.f229a.toString();
    }
}
