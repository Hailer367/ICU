package H0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class k extends r {

    /* renamed from: a, reason: collision with root package name */
    public final long f622a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f623b;

    /* renamed from: c, reason: collision with root package name */
    public final long f624c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f625d;

    /* renamed from: e, reason: collision with root package name */
    public final String f626e;

    /* renamed from: f, reason: collision with root package name */
    public final long f627f;

    /* renamed from: g, reason: collision with root package name */
    public final v f628g;

    public k(long j4, Integer num, long j5, byte[] bArr, String str, long j6, v vVar) {
        this.f622a = j4;
        this.f623b = num;
        this.f624c = j5;
        this.f625d = bArr;
        this.f626e = str;
        this.f627f = j6;
        this.f628g = vVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        byte[] bArr;
        String str;
        v vVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f622a == ((k) rVar).f622a && ((num = this.f623b) != null ? num.equals(((k) rVar).f623b) : ((k) rVar).f623b == null)) {
                k kVar = (k) rVar;
                v vVar2 = kVar.f628g;
                String str2 = kVar.f626e;
                if (this.f624c == kVar.f624c) {
                    if (rVar instanceof k) {
                        bArr = ((k) rVar).f625d;
                    } else {
                        bArr = kVar.f625d;
                    }
                    if (Arrays.equals(this.f625d, bArr) && ((str = this.f626e) != null ? str.equals(str2) : str2 == null) && this.f627f == kVar.f627f && ((vVar = this.f628g) != null ? vVar.equals(vVar2) : vVar2 == null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        long j4 = this.f622a;
        int i4 = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        int i5 = 0;
        Integer num = this.f623b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i6 = (i4 ^ hashCode) * 1000003;
        long j5 = this.f624c;
        int hashCode3 = (((i6 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f625d)) * 1000003;
        String str = this.f626e;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i7 = (hashCode3 ^ hashCode2) * 1000003;
        long j6 = this.f627f;
        int i8 = (i7 ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        v vVar = this.f628g;
        if (vVar != null) {
            i5 = vVar.hashCode();
        }
        return i8 ^ i5;
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f622a + ", eventCode=" + this.f623b + ", eventUptimeMs=" + this.f624c + ", sourceExtension=" + Arrays.toString(this.f625d) + ", sourceExtensionJsonProto3=" + this.f626e + ", timezoneOffsetSeconds=" + this.f627f + ", networkConnectionInfo=" + this.f628g + "}";
    }
}
