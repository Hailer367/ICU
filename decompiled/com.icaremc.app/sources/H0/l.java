package H0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l extends s {

    /* renamed from: a, reason: collision with root package name */
    public final long f629a;

    /* renamed from: b, reason: collision with root package name */
    public final long f630b;

    /* renamed from: c, reason: collision with root package name */
    public final j f631c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f632d;

    /* renamed from: e, reason: collision with root package name */
    public final String f633e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f634f;

    public l(long j4, long j5, j jVar, Integer num, String str, ArrayList arrayList) {
        w wVar = w.f644f;
        this.f629a = j4;
        this.f630b = j5;
        this.f631c = jVar;
        this.f632d = num;
        this.f633e = str;
        this.f634f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof s) {
                l lVar = (l) ((s) obj);
                if (this.f629a == lVar.f629a) {
                    lVar.getClass();
                    Object obj2 = w.f644f;
                    ArrayList arrayList = lVar.f634f;
                    String str = lVar.f633e;
                    Integer num = lVar.f632d;
                    j jVar = lVar.f631c;
                    if (this.f630b == lVar.f630b && this.f631c.equals(jVar)) {
                        Integer num2 = this.f632d;
                        if (num2 == null) {
                            if (num != null) {
                                return false;
                            }
                        } else if (!num2.equals(num)) {
                            return false;
                        }
                        String str2 = this.f633e;
                        if (str2 == null) {
                            if (str != null) {
                                return false;
                            }
                        } else if (!str2.equals(str)) {
                            return false;
                        }
                        if (this.f634f.equals(arrayList) && obj2.equals(obj2)) {
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
        long j4 = this.f629a;
        long j5 = this.f630b;
        int hashCode2 = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003) ^ this.f631c.hashCode()) * 1000003;
        int i4 = 0;
        Integer num = this.f632d;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i5 = (hashCode2 ^ hashCode) * 1000003;
        String str = this.f633e;
        if (str != null) {
            i4 = str.hashCode();
        }
        return ((((i5 ^ i4) * 1000003) ^ this.f634f.hashCode()) * 1000003) ^ w.f644f.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f629a + ", requestUptimeMs=" + this.f630b + ", clientInfo=" + this.f631c + ", logSource=" + this.f632d + ", logSourceName=" + this.f633e + ", logEvents=" + this.f634f + ", qosTier=" + w.f644f + "}";
    }
}
