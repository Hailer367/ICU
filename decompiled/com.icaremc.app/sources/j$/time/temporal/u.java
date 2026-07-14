package j$.time.temporal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a, reason: collision with root package name */
    public final long f4772a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4773b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4774c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4775d;

    public static u f(long j4, long j5) {
        if (j4 > j5) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new u(j4, j4, j5, j5);
    }

    public static u g(long j4, long j5) {
        if (j4 > j5) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 > j5) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new u(1L, 1L, j4, j5);
    }

    public u(long j4, long j5, long j6, long j7) {
        this.f4772a = j4;
        this.f4773b = j5;
        this.f4774c = j6;
        this.f4775d = j7;
    }

    public final boolean d() {
        return this.f4772a >= -2147483648L && this.f4775d <= 2147483647L;
    }

    public final boolean e(long j4) {
        return j4 >= this.f4772a && j4 <= this.f4775d;
    }

    public final int a(long j4, q qVar) {
        if (d() && e(j4)) {
            return (int) j4;
        }
        throw new RuntimeException(c(j4, qVar));
    }

    public final void b(long j4, q qVar) {
        if (!e(j4)) {
            throw new RuntimeException(c(j4, qVar));
        }
    }

    public final String c(long j4, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j4;
        }
        return "Invalid value (valid values " + this + "): " + j4;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        long j4 = this.f4772a;
        long j5 = this.f4773b;
        if (j4 > j5) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j6 = this.f4774c;
        long j7 = this.f4775d;
        if (j6 > j7) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j5 > j7) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f4772a == uVar.f4772a && this.f4773b == uVar.f4773b && this.f4774c == uVar.f4774c && this.f4775d == uVar.f4775d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f4772a;
        long j5 = this.f4773b;
        long j6 = j4 + (j5 << 16) + (j5 >> 48);
        long j7 = this.f4774c;
        long j8 = j6 + (j7 << 32) + (j7 >> 32);
        long j9 = this.f4775d;
        long j10 = j8 + (j9 << 48) + (j9 >> 16);
        return (int) (j10 ^ (j10 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4772a);
        if (this.f4772a != this.f4773b) {
            sb.append('/');
            sb.append(this.f4773b);
        }
        sb.append(" - ");
        sb.append(this.f4774c);
        if (this.f4774c != this.f4775d) {
            sb.append('/');
            sb.append(this.f4775d);
        }
        return sb.toString();
    }
}
