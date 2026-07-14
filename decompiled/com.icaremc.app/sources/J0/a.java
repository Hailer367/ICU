package J0;

import R.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f876a;

    /* renamed from: b, reason: collision with root package name */
    public final long f877b;

    public a(long j4, int i4) {
        if (i4 != 0) {
            this.f876a = i4;
            this.f877b = j4;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (i.a(this.f876a, aVar.f876a) && this.f877b == aVar.f877b) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int b4 = (i.b(this.f876a) ^ 1000003) * 1000003;
        long j4 = this.f877b;
        return b4 ^ ((int) ((j4 >>> 32) ^ j4));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i4 = this.f876a;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
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
        sb.append(this.f877b);
        sb.append("}");
        return sb.toString();
    }
}
