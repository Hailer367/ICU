package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class s implements j$.time.temporal.p, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final s f2642d = new s(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a, reason: collision with root package name */
    public final int f2643a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2644b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2645c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        b.a(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public static s a(int i2, int i3, int i4) {
        if ((i2 | i3 | i4) == 0) {
            return f2642d;
        }
        return new s(i2, i3, i4);
    }

    public s(int i2, int i3, int i4) {
        this.f2643a = i2;
        this.f2644b = i3;
        this.f2645c = i4;
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        j$.time.chrono.l lVar = (j$.time.chrono.l) mVar.b(j$.time.temporal.r.f2669b);
        if (lVar == null || j$.time.chrono.s.f2522c.equals(lVar)) {
            int i2 = this.f2644b;
            if (i2 != 0) {
                long j2 = (this.f2643a * 12) + i2;
                if (j2 != 0) {
                    mVar = mVar.d(j2, j$.time.temporal.b.MONTHS);
                }
            } else {
                int i3 = this.f2643a;
                if (i3 != 0) {
                    mVar = mVar.d(i3, j$.time.temporal.b.YEARS);
                }
            }
            int i4 = this.f2645c;
            return i4 != 0 ? mVar.d(i4, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new RuntimeException("Chronology mismatch, expected: ISO, actual: " + lVar.q());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.f2643a == sVar.f2643a && this.f2644b == sVar.f2644b && this.f2645c == sVar.f2645c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f2645c, 16) + Integer.rotateLeft(this.f2644b, 8) + this.f2643a;
    }

    public final String toString() {
        if (this == f2642d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i2 = this.f2643a;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('Y');
        }
        int i3 = this.f2644b;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        int i4 = this.f2645c;
        if (i4 != 0) {
            sb.append(i4);
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
