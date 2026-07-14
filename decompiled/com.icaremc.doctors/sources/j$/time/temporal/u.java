package j$.time.temporal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a, reason: collision with root package name */
    public final long f2675a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2676b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2677c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2678d;

    public static u f(long j2, long j3) {
        if (j2 > j3) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new u(j2, j2, j3, j3);
    }

    public static u g(long j2, long j3) {
        if (j2 > j3) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 > j3) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new u(1L, 1L, j2, j3);
    }

    public u(long j2, long j3, long j4, long j5) {
        this.f2675a = j2;
        this.f2676b = j3;
        this.f2677c = j4;
        this.f2678d = j5;
    }

    public final boolean d() {
        return this.f2675a >= -2147483648L && this.f2678d <= 2147483647L;
    }

    public final boolean e(long j2) {
        return j2 >= this.f2675a && j2 <= this.f2678d;
    }

    public final int a(long j2, q qVar) {
        if (d() && e(j2)) {
            return (int) j2;
        }
        throw new RuntimeException(c(j2, qVar));
    }

    public final void b(long j2, q qVar) {
        if (!e(j2)) {
            throw new RuntimeException(c(j2, qVar));
        }
    }

    public final String c(long j2, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j2;
        }
        return "Invalid value (valid values " + this + "): " + j2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        long j2 = this.f2675a;
        long j3 = this.f2676b;
        if (j2 > j3) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j4 = this.f2677c;
        long j5 = this.f2678d;
        if (j4 > j5) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j3 > j5) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f2675a == uVar.f2675a && this.f2676b == uVar.f2676b && this.f2677c == uVar.f2677c && this.f2678d == uVar.f2678d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f2675a;
        long j3 = this.f2676b;
        long j4 = j2 + (j3 << 16) + (j3 >> 48);
        long j5 = this.f2677c;
        long j6 = j4 + (j5 << 32) + (j5 >> 32);
        long j7 = this.f2678d;
        long j8 = j6 + (j7 << 48) + (j7 >> 16);
        return (int) (j8 ^ (j8 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2675a);
        if (this.f2675a != this.f2676b) {
            sb.append('/');
            sb.append(this.f2676b);
        }
        sb.append(" - ");
        sb.append(this.f2677c);
        if (this.f2677c != this.f2678d) {
            sb.append('/');
            sb.append(this.f2678d);
        }
        return sb.toString();
    }
}
