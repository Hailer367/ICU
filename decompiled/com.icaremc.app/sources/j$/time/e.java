package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class e implements j$.time.temporal.p, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final e f4634c = new e(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a, reason: collision with root package name */
    public final long f4635a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4636b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        int compare = Long.compare(this.f4635a, eVar.f4635a);
        return compare != 0 ? compare : this.f4636b - eVar.f4636b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static e F(long j4) {
        long j5 = j4 / 1000000000;
        int i4 = (int) (j4 % 1000000000);
        if (i4 < 0) {
            i4 = (int) (i4 + 1000000000);
            j5--;
        }
        return A(j5, i4);
    }

    public static e A(long j4, int i4) {
        if ((i4 | j4) == 0) {
            return f4634c;
        }
        return new e(j4, i4);
    }

    public e(long j4, int i4) {
        this.f4635a = j4;
        this.f4636b = i4;
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        long j4 = this.f4635a;
        if (j4 != 0) {
            mVar = mVar.d(j4, j$.time.temporal.b.SECONDS);
        }
        int i4 = this.f4636b;
        return i4 != 0 ? mVar.d(i4, j$.time.temporal.b.NANOS) : mVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f4635a == eVar.f4635a && this.f4636b == eVar.f4636b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f4635a;
        return (this.f4636b * 51) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        if (this == f4634c) {
            return "PT0S";
        }
        long j4 = this.f4635a;
        if (j4 < 0 && this.f4636b > 0) {
            j4++;
        }
        long j5 = j4 / 3600;
        int i4 = (int) ((j4 % 3600) / 60);
        int i5 = (int) (j4 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j5 != 0) {
            sb.append(j5);
            sb.append('H');
        }
        if (i4 != 0) {
            sb.append(i4);
            sb.append('M');
        }
        if (i5 == 0 && this.f4636b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.f4635a >= 0 || this.f4636b <= 0) {
            sb.append(i5);
        } else if (i5 == 0) {
            sb.append("-0");
        } else {
            sb.append(i5);
        }
        if (this.f4636b > 0) {
            int length = sb.length();
            if (this.f4635a < 0) {
                sb.append(2000000000 - this.f4636b);
            } else {
                sb.append(this.f4636b + 1000000000);
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
