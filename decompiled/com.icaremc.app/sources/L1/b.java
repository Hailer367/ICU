package L1;

import R.i;
import r2.k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f1008h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f1009a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1010b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1011c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1012d;

    /* renamed from: e, reason: collision with root package name */
    public final long f1013e;

    /* renamed from: f, reason: collision with root package name */
    public final long f1014f;

    /* renamed from: g, reason: collision with root package name */
    public final String f1015g;

    static {
        byte b4 = (byte) (((byte) (0 | 2)) | 1);
        if (b4 == 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if ((b4 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b4 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb));
    }

    public b(String str, int i4, String str2, String str3, long j4, long j5, String str4) {
        this.f1009a = str;
        this.f1010b = i4;
        this.f1011c = str2;
        this.f1012d = str3;
        this.f1013e = j4;
        this.f1014f = j5;
        this.f1015g = str4;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, L1.a] */
    public final a a() {
        ?? obj = new Object();
        obj.f1000a = this.f1009a;
        obj.f1001b = this.f1010b;
        obj.f1002c = this.f1011c;
        obj.f1003d = this.f1012d;
        obj.f1004e = this.f1013e;
        obj.f1005f = this.f1014f;
        obj.f1006g = this.f1015g;
        obj.f1007h = (byte) 3;
        return obj;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                String str = this.f1009a;
                if (str == null) {
                    if (bVar.f1009a != null) {
                        return false;
                    }
                } else if (!str.equals(bVar.f1009a)) {
                    return false;
                }
                int i4 = bVar.f1010b;
                String str2 = bVar.f1015g;
                String str3 = bVar.f1012d;
                String str4 = bVar.f1011c;
                if (i.a(this.f1010b, i4)) {
                    String str5 = this.f1011c;
                    if (str5 == null) {
                        if (str4 != null) {
                            return false;
                        }
                    } else if (!str5.equals(str4)) {
                        return false;
                    }
                    String str6 = this.f1012d;
                    if (str6 == null) {
                        if (str3 != null) {
                            return false;
                        }
                    } else if (!str6.equals(str3)) {
                        return false;
                    }
                    if (this.f1013e == bVar.f1013e && this.f1014f == bVar.f1014f) {
                        String str7 = this.f1015g;
                        if (str7 == null) {
                            if (str2 == null) {
                                return true;
                            }
                            return false;
                        }
                        if (str7.equals(str2)) {
                            return true;
                        }
                        return false;
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
        int hashCode2;
        int hashCode3;
        int i4 = 0;
        String str = this.f1009a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int b4 = (((hashCode ^ 1000003) * 1000003) ^ i.b(this.f1010b)) * 1000003;
        String str2 = this.f1011c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i5 = (b4 ^ hashCode2) * 1000003;
        String str3 = this.f1012d;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i6 = (i5 ^ hashCode3) * 1000003;
        long j4 = this.f1013e;
        int i7 = (i6 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j5 = this.f1014f;
        int i8 = (i7 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        String str4 = this.f1015g;
        if (str4 != null) {
            i4 = str4.hashCode();
        }
        return i4 ^ i8;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.f1009a);
        sb.append(", registrationStatus=");
        int i4 = this.f1010b;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            str = "null";
                        } else {
                            str = "REGISTER_ERROR";
                        }
                    } else {
                        str = "REGISTERED";
                    }
                } else {
                    str = "UNREGISTERED";
                }
            } else {
                str = "NOT_GENERATED";
            }
        } else {
            str = "ATTEMPT_MIGRATION";
        }
        sb.append(str);
        sb.append(", authToken=");
        sb.append(this.f1011c);
        sb.append(", refreshToken=");
        sb.append(this.f1012d);
        sb.append(", expiresInSecs=");
        sb.append(this.f1013e);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.f1014f);
        sb.append(", fisError=");
        return k.c(sb, this.f1015g, "}");
    }
}
