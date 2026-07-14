package q1;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f5969a;

    public l(int i4) {
        this.f5969a = i4;
    }

    public static l a(int i4) {
        byte b4 = (byte) (((byte) 1) | 2);
        if (b4 != 3) {
            StringBuilder sb = new StringBuilder();
            if ((b4 & 1) == 0) {
                sb.append(" appUpdateType");
            }
            if ((b4 & 2) == 0) {
                sb.append(" allowAssetPackDeletion");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new l(i4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof l) && this.f5969a == ((l) obj).f5969a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f5969a ^ 1000003) * 1000003) ^ 1237;
    }

    public final String toString() {
        return "AppUpdateOptions{appUpdateType=" + this.f5969a + ", allowAssetPackDeletion=false}";
    }
}
