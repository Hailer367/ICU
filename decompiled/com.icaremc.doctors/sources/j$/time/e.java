package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class e implements j$.time.temporal.p, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final e f2537c = new e(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a, reason: collision with root package name */
    public final long f2538a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2539b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        int compare = Long.compare(this.f2538a, eVar.f2538a);
        return compare != 0 ? compare : this.f2539b - eVar.f2539b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static e F(long j2) {
        long j3 = j2 / 1000000000;
        int i2 = (int) (j2 % 1000000000);
        if (i2 < 0) {
            i2 = (int) (i2 + 1000000000);
            j3--;
        }
        return A(j3, i2);
    }

    public static e A(long j2, int i2) {
        if ((i2 | j2) == 0) {
            return f2537c;
        }
        return new e(j2, i2);
    }

    public e(long j2, int i2) {
        this.f2538a = j2;
        this.f2539b = i2;
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        long j2 = this.f2538a;
        if (j2 != 0) {
            mVar = mVar.d(j2, j$.time.temporal.b.SECONDS);
        }
        int i2 = this.f2539b;
        return i2 != 0 ? mVar.d(i2, j$.time.temporal.b.NANOS) : mVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f2538a == eVar.f2538a && this.f2539b == eVar.f2539b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f2538a;
        return (this.f2539b * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        if (this == f2537c) {
            return "PT0S";
        }
        long j2 = this.f2538a;
        if (j2 < 0 && this.f2539b > 0) {
            j2++;
        }
        long j3 = j2 / 3600;
        int i2 = (int) ((j2 % 3600) / 60);
        int i3 = (int) (j2 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j3 != 0) {
            sb.append(j3);
            sb.append('H');
        }
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        if (i3 == 0 && this.f2539b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.f2538a >= 0 || this.f2539b <= 0) {
            sb.append(i3);
        } else if (i3 == 0) {
            sb.append("-0");
        } else {
            sb.append(i3);
        }
        if (this.f2539b > 0) {
            int length = sb.length();
            if (this.f2538a < 0) {
                sb.append(2000000000 - this.f2539b);
            } else {
                sb.append(this.f2539b + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
