package I;

import java.util.Objects;

/* renamed from: I.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0056j {

    /* renamed from: a, reason: collision with root package name */
    public final C0055i f760a;

    static {
        new C0056j("", 0, 0);
    }

    public C0056j(String str, int i4, int i5) {
        this.f760a = new C0055i(str, i4, i5);
    }

    public static C0056j a(int i4, int i5, boolean z, int i6, int i7, int i8, int i9) {
        String sb;
        if (z) {
            int i10 = i4 / 2;
            int i11 = i5 / 2;
            sb = "M0," + i11 + " A" + i10 + "," + i11 + " 0 1,1 " + i4 + "," + i11 + " A" + i10 + "," + i11 + " 0 1,1 0," + i11 + " Z";
        } else {
            StringBuilder sb2 = new StringBuilder("M ");
            int min = Math.min(i4 / 2, i5 / 2);
            int min2 = Math.min(min, i6);
            int min3 = Math.min(min, i7);
            int min4 = Math.min(min, i8);
            int min5 = Math.min(min, i9);
            sb2.append(min2);
            sb2.append(",0 L ");
            sb2.append(i4 - min3);
            sb2.append(",0");
            if (min3 > 0) {
                sb2.append(" A ");
                sb2.append(min3);
                sb2.append(",");
                sb2.append(min3);
                sb2.append(" 0 0,1 ");
                sb2.append(i4);
                sb2.append(",");
                sb2.append(min3);
            }
            sb2.append(" L ");
            sb2.append(i4);
            sb2.append(",");
            sb2.append(i5 - min4);
            if (min4 > 0) {
                sb2.append(" A ");
                sb2.append(min4);
                sb2.append(",");
                sb2.append(min4);
                sb2.append(" 0 0,1 ");
                sb2.append(i4 - min4);
                sb2.append(",");
                sb2.append(i5);
            }
            sb2.append(" L ");
            sb2.append(min5);
            sb2.append(",");
            sb2.append(i5);
            if (min5 > 0) {
                sb2.append(" A ");
                sb2.append(min5);
                sb2.append(",");
                sb2.append(min5);
                sb2.append(" 0 0,1 0,");
                sb2.append(i5 - min5);
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
        return new C0056j(sb, i4, i5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0056j)) {
            return false;
        }
        return Objects.equals(this.f760a, ((C0056j) obj).f760a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f760a);
    }

    public final String toString() {
        return this.f760a.toString();
    }
}
