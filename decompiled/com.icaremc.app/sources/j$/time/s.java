package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class s implements j$.time.temporal.p, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final s f4739d = new s(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a, reason: collision with root package name */
    public final int f4740a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4741b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4742c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        b.a(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public static s a(int i4, int i5, int i6) {
        if ((i4 | i5 | i6) == 0) {
            return f4739d;
        }
        return new s(i4, i5, i6);
    }

    public s(int i4, int i5, int i6) {
        this.f4740a = i4;
        this.f4741b = i5;
        this.f4742c = i6;
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        j$.time.chrono.l lVar = (j$.time.chrono.l) mVar.b(j$.time.temporal.r.f4766b);
        if (lVar == null || j$.time.chrono.s.f4619c.equals(lVar)) {
            int i4 = this.f4741b;
            if (i4 != 0) {
                long j4 = (this.f4740a * 12) + i4;
                if (j4 != 0) {
                    mVar = mVar.d(j4, j$.time.temporal.b.MONTHS);
                }
            } else {
                int i5 = this.f4740a;
                if (i5 != 0) {
                    mVar = mVar.d(i5, j$.time.temporal.b.YEARS);
                }
            }
            int i6 = this.f4742c;
            return i6 != 0 ? mVar.d(i6, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new RuntimeException("Chronology mismatch, expected: ISO, actual: " + lVar.q());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.f4740a == sVar.f4740a && this.f4741b == sVar.f4741b && this.f4742c == sVar.f4742c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f4742c, 16) + Integer.rotateLeft(this.f4741b, 8) + this.f4740a;
    }

    public final String toString() {
        if (this == f4739d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i4 = this.f4740a;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('Y');
        }
        int i5 = this.f4741b;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        int i6 = this.f4742c;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
