package u0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m extends t {

    /* renamed from: a, reason: collision with root package name */
    public final long f3867a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3868b;

    /* renamed from: c, reason: collision with root package name */
    public final k f3869c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f3870d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3871e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f3872f;

    public m(long j2, long j3, k kVar, Integer num, String str, ArrayList arrayList) {
        x xVar = x.f3882c;
        this.f3867a = j2;
        this.f3868b = j3;
        this.f3869c = kVar;
        this.f3870d = num;
        this.f3871e = str;
        this.f3872f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof t) {
                m mVar = (m) ((t) obj);
                if (this.f3867a == mVar.f3867a) {
                    mVar.getClass();
                    Object obj2 = x.f3882c;
                    ArrayList arrayList = mVar.f3872f;
                    String str = mVar.f3871e;
                    Integer num = mVar.f3870d;
                    k kVar = mVar.f3869c;
                    if (this.f3868b == mVar.f3868b && this.f3869c.equals(kVar)) {
                        Integer num2 = this.f3870d;
                        if (num2 == null) {
                            if (num != null) {
                                return false;
                            }
                        } else if (!num2.equals(num)) {
                            return false;
                        }
                        String str2 = this.f3871e;
                        if (str2 == null) {
                            if (str != null) {
                                return false;
                            }
                        } else if (!str2.equals(str)) {
                            return false;
                        }
                        if (this.f3872f.equals(arrayList) && obj2.equals(obj2)) {
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
        long j2 = this.f3867a;
        long j3 = this.f3868b;
        int hashCode2 = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f3869c.hashCode()) * 1000003;
        int i2 = 0;
        Integer num = this.f3870d;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i3 = (hashCode2 ^ hashCode) * 1000003;
        String str = this.f3871e;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((((i3 ^ i2) * 1000003) ^ this.f3872f.hashCode()) * 1000003) ^ x.f3882c.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f3867a + ", requestUptimeMs=" + this.f3868b + ", clientInfo=" + this.f3869c + ", logSource=" + this.f3870d + ", logSourceName=" + this.f3871e + ", logEvents=" + this.f3872f + ", qosTier=" + x.f3882c + "}";
    }
}
