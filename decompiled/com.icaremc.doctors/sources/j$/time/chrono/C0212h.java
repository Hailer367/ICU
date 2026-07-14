package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* renamed from: j$.time.chrono.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0212h implements j$.time.temporal.p, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f2495e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a, reason: collision with root package name */
    public final l f2496a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2497b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2498c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2499d;

    static {
        j$.time.b.a(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public C0212h(l lVar, int i2, int i3, int i4) {
        this.f2496a = lVar;
        this.f2497b = i2;
        this.f2498c = i3;
        this.f2499d = i4;
    }

    public final String toString() {
        if (this.f2497b == 0 && this.f2498c == 0 && this.f2499d == 0) {
            return this.f2496a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2496a.toString());
        sb.append(" P");
        int i2 = this.f2497b;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('Y');
        }
        int i3 = this.f2498c;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        int i4 = this.f2499d;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('D');
        }
        return sb.toString();
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        l lVar = (l) mVar.b(j$.time.temporal.r.f2669b);
        if (lVar == null || this.f2496a.equals(lVar)) {
            if (this.f2498c != 0) {
                j$.time.temporal.u y = this.f2496a.y(j$.time.temporal.a.MONTH_OF_YEAR);
                long j2 = (y.f2675a == y.f2676b && y.f2677c == y.f2678d && y.d()) ? (y.f2678d - y.f2675a) + 1 : -1L;
                if (j2 > 0) {
                    mVar = mVar.d((this.f2497b * j2) + this.f2498c, j$.time.temporal.b.MONTHS);
                } else {
                    int i2 = this.f2497b;
                    if (i2 != 0) {
                        mVar = mVar.d(i2, j$.time.temporal.b.YEARS);
                    }
                    mVar = mVar.d(this.f2498c, j$.time.temporal.b.MONTHS);
                }
            } else {
                int i3 = this.f2497b;
                if (i3 != 0) {
                    mVar = mVar.d(i3, j$.time.temporal.b.YEARS);
                }
            }
            int i4 = this.f2499d;
            return i4 != 0 ? mVar.d(i4, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new RuntimeException("Chronology mismatch, expected: " + this.f2496a.q() + ", actual: " + lVar.q());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0212h) {
            C0212h c0212h = (C0212h) obj;
            if (this.f2497b == c0212h.f2497b && this.f2498c == c0212h.f2498c && this.f2499d == c0212h.f2499d && this.f2496a.equals(c0212h.f2496a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.f2499d, 16) + (Integer.rotateLeft(this.f2498c, 8) + this.f2497b)) ^ this.f2496a.hashCode();
    }

    public Object writeReplace() {
        return new E((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
