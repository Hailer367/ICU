package I0;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f825a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f826b;

    /* renamed from: c, reason: collision with root package name */
    public final m f827c;

    /* renamed from: d, reason: collision with root package name */
    public final long f828d;

    /* renamed from: e, reason: collision with root package name */
    public final long f829e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f830f;

    public i(String str, Integer num, m mVar, long j4, long j5, HashMap hashMap) {
        this.f825a = str;
        this.f826b = num;
        this.f827c = mVar;
        this.f828d = j4;
        this.f829e = j5;
        this.f830f = hashMap;
    }

    public final String a(String str) {
        String str2 = (String) this.f830f.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f830f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [I0.h, java.lang.Object] */
    public final h c() {
        ?? obj = new Object();
        String str = this.f825a;
        if (str != null) {
            obj.f819a = str;
            obj.f820b = this.f826b;
            m mVar = this.f827c;
            if (mVar != null) {
                obj.f821c = mVar;
                obj.f822d = Long.valueOf(this.f828d);
                obj.f823e = Long.valueOf(this.f829e);
                obj.f824f = new HashMap(this.f830f);
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
            String str = iVar.f825a;
            Integer num2 = iVar.f826b;
            if (this.f825a.equals(str) && ((num = this.f826b) != null ? num.equals(num2) : num2 == null) && this.f827c.equals(iVar.f827c) && this.f828d == iVar.f828d && this.f829e == iVar.f829e && this.f830f.equals(iVar.f830f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.f825a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f826b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode3 = (((hashCode2 ^ hashCode) * 1000003) ^ this.f827c.hashCode()) * 1000003;
        long j4 = this.f828d;
        int i4 = (hashCode3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j5 = this.f829e;
        return ((i4 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ this.f830f.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f825a + ", code=" + this.f826b + ", encodedPayload=" + this.f827c + ", eventMillis=" + this.f828d + ", uptimeMillis=" + this.f829e + ", autoMetadata=" + this.f830f + "}";
    }
}
