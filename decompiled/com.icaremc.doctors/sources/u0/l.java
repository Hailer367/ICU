package u0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l extends s {

    /* renamed from: a, reason: collision with root package name */
    public final long f3860a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f3861b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3862c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f3863d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3864e;

    /* renamed from: f, reason: collision with root package name */
    public final long f3865f;

    /* renamed from: g, reason: collision with root package name */
    public final w f3866g;

    public l(long j2, Integer num, long j3, byte[] bArr, String str, long j4, w wVar) {
        this.f3860a = j2;
        this.f3861b = num;
        this.f3862c = j3;
        this.f3863d = bArr;
        this.f3864e = str;
        this.f3865f = j4;
        this.f3866g = wVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        byte[] bArr;
        String str;
        w wVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.f3860a == ((l) sVar).f3860a && ((num = this.f3861b) != null ? num.equals(((l) sVar).f3861b) : ((l) sVar).f3861b == null)) {
                l lVar = (l) sVar;
                w wVar2 = lVar.f3866g;
                String str2 = lVar.f3864e;
                if (this.f3862c == lVar.f3862c) {
                    if (sVar instanceof l) {
                        bArr = ((l) sVar).f3863d;
                    } else {
                        bArr = lVar.f3863d;
                    }
                    if (Arrays.equals(this.f3863d, bArr) && ((str = this.f3864e) != null ? str.equals(str2) : str2 == null) && this.f3865f == lVar.f3865f && ((wVar = this.f3866g) != null ? wVar.equals(wVar2) : wVar2 == null)) {
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
        long j2 = this.f3860a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        int i3 = 0;
        Integer num = this.f3861b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i4 = (i2 ^ hashCode) * 1000003;
        long j3 = this.f3862c;
        int hashCode3 = (((i4 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f3863d)) * 1000003;
        String str = this.f3864e;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i5 = (hashCode3 ^ hashCode2) * 1000003;
        long j4 = this.f3865f;
        int i6 = (i5 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        w wVar = this.f3866g;
        if (wVar != null) {
            i3 = wVar.hashCode();
        }
        return i6 ^ i3;
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f3860a + ", eventCode=" + this.f3861b + ", eventUptimeMs=" + this.f3862c + ", sourceExtension=" + Arrays.toString(this.f3863d) + ", sourceExtensionJsonProto3=" + this.f3864e + ", timezoneOffsetSeconds=" + this.f3865f + ", networkConnectionInfo=" + this.f3866g + "}";
    }
}
