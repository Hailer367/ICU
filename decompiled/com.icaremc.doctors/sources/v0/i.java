package v0;

import com.google.firebase.encoders.json.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import m.C0267n;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f3907a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f3908b;

    /* renamed from: c, reason: collision with root package name */
    public final m f3909c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3910d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3911e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f3912f;

    public i(String str, Integer num, m mVar, long j2, long j3, HashMap hashMap) {
        this.f3907a = str;
        this.f3908b = num;
        this.f3909c = mVar;
        this.f3910d = j2;
        this.f3911e = j3;
        this.f3912f = hashMap;
    }

    public final String a(String str) {
        String str2 = (String) this.f3912f.get(str);
        if (str2 == null) {
            return BuildConfig.FLAVOR;
        }
        return str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f3912f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, m.n] */
    public final C0267n c() {
        ?? obj = new Object();
        String str = this.f3907a;
        if (str != null) {
            obj.f3197a = str;
            obj.f3198b = this.f3908b;
            m mVar = this.f3909c;
            if (mVar != null) {
                obj.f3199c = mVar;
                obj.f3200d = Long.valueOf(this.f3910d);
                obj.f3201e = Long.valueOf(this.f3911e);
                obj.f3202f = new HashMap(this.f3912f);
                return obj;
            }
            throw new NullPointerException("Null encodedPayload");
        }
        throw new NullPointerException("Null transportName");
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            String str = iVar.f3907a;
            Integer num2 = iVar.f3908b;
            if (this.f3907a.equals(str) && ((num = this.f3908b) != null ? num.equals(num2) : num2 == null) && this.f3909c.equals(iVar.f3909c) && this.f3910d == iVar.f3910d && this.f3911e == iVar.f3911e && this.f3912f.equals(iVar.f3912f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.f3907a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f3908b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode3 = (((hashCode2 ^ hashCode) * 1000003) ^ this.f3909c.hashCode()) * 1000003;
        long j2 = this.f3910d;
        int i2 = (hashCode3 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f3911e;
        return ((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f3912f.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f3907a + ", code=" + this.f3908b + ", encodedPayload=" + this.f3909c + ", eventMillis=" + this.f3910d + ", uptimeMillis=" + this.f3911e + ", autoMetadata=" + this.f3912f + "}";
    }
}
