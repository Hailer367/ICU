package M1;

import R.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1032a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1033b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1034c;

    /* renamed from: d, reason: collision with root package name */
    public final b f1035d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1036e;

    public a(String str, String str2, String str3, b bVar, int i4) {
        this.f1032a = str;
        this.f1033b = str2;
        this.f1034c = str3;
        this.f1035d = bVar;
        this.f1036e = i4;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                String str = this.f1032a;
                if (str == null) {
                    if (aVar.f1032a != null) {
                        return false;
                    }
                } else if (!str.equals(aVar.f1032a)) {
                    return false;
                }
                String str2 = this.f1033b;
                if (str2 == null) {
                    if (aVar.f1033b != null) {
                        return false;
                    }
                } else if (!str2.equals(aVar.f1033b)) {
                    return false;
                }
                String str3 = this.f1034c;
                if (str3 == null) {
                    if (aVar.f1034c != null) {
                        return false;
                    }
                } else if (!str3.equals(aVar.f1034c)) {
                    return false;
                }
                b bVar = this.f1035d;
                if (bVar == null) {
                    if (aVar.f1035d != null) {
                        return false;
                    }
                } else if (!bVar.equals(aVar.f1035d)) {
                    return false;
                }
                int i4 = this.f1036e;
                if (i4 == 0) {
                    if (aVar.f1036e == 0) {
                        return true;
                    }
                    return false;
                }
                if (i.a(i4, aVar.f1036e)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i4 = 0;
        String str = this.f1032a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode ^ 1000003) * 1000003;
        String str2 = this.f1033b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 ^ hashCode2) * 1000003;
        String str3 = this.f1034c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i7 = (i6 ^ hashCode3) * 1000003;
        b bVar = this.f1035d;
        if (bVar == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bVar.hashCode();
        }
        int i8 = (i7 ^ hashCode4) * 1000003;
        int i9 = this.f1036e;
        if (i9 != 0) {
            i4 = i.b(i9);
        }
        return i4 ^ i8;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("InstallationResponse{uri=");
        sb.append(this.f1032a);
        sb.append(", fid=");
        sb.append(this.f1033b);
        sb.append(", refreshToken=");
        sb.append(this.f1034c);
        sb.append(", authToken=");
        sb.append(this.f1035d);
        sb.append(", responseCode=");
        int i4 = this.f1036e;
        if (i4 != 1) {
            if (i4 != 2) {
                str = "null";
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
