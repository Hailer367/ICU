package w0;

import N.i;

/* renamed from: w0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0341a {

    /* renamed from: a, reason: collision with root package name */
    public final int f3946a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3947b;

    public C0341a(int i2, long j2) {
        if (i2 != 0) {
            this.f3946a = i2;
            this.f3947b = j2;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C0341a) {
                C0341a c0341a = (C0341a) obj;
                if (i.a(this.f3946a, c0341a.f3946a) && this.f3947b == c0341a.f3947b) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int b2 = (i.b(this.f3946a) ^ 1000003) * 1000003;
        long j2 = this.f3947b;
        return b2 ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i2 = this.f3946a;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        str = "null";
                    } else {
                        str = "INVALID_PAYLOAD";
                    }
                } else {
                    str = "FATAL_ERROR";
                }
            } else {
                str = "TRANSIENT_ERROR";
            }
        } else {
            str = "OK";
        }
        sb.append(str);
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.f3947b);
        sb.append("}");
        return sb.toString();
    }
}
