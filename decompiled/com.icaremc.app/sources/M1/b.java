package M1;

import R.i;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1037a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1038b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1039c;

    public b(long j4, String str, int i4) {
        this.f1037a = str;
        this.f1038b = j4;
        this.f1039c = i4;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                String str = this.f1037a;
                if (str == null) {
                    if (bVar.f1037a != null) {
                        return false;
                    }
                } else if (!str.equals(bVar.f1037a)) {
                    return false;
                }
                long j4 = bVar.f1038b;
                int i4 = bVar.f1039c;
                if (this.f1038b == j4) {
                    int i5 = this.f1039c;
                    if (i5 == 0) {
                        if (i4 == 0) {
                            return true;
                        }
                        return false;
                    }
                    if (i.a(i5, i4)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int i4 = 0;
        String str = this.f1037a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j4 = this.f1038b;
        int i5 = (((hashCode ^ 1000003) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        int i6 = this.f1039c;
        if (i6 != 0) {
            i4 = i.b(i6);
        }
        return i4 ^ i5;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("TokenResult{token=");
        sb.append(this.f1037a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f1038b);
        sb.append(", responseCode=");
        int i4 = this.f1039c;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    str = "null";
                } else {
                    str = "AUTH_ERROR";
                }
            } else {
                str = "BAD_CONFIG";
            }
        } else {
            str = "OK";
        }
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
