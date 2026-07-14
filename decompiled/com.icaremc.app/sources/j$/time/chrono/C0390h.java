package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* renamed from: j$.time.chrono.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0390h implements j$.time.temporal.p, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f4593e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a, reason: collision with root package name */
    public final l f4594a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4595b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4596c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4597d;

    static {
        j$.time.b.a(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public C0390h(l lVar, int i4, int i5, int i6) {
        this.f4594a = lVar;
        this.f4595b = i4;
        this.f4596c = i5;
        this.f4597d = i6;
    }

    public final String toString() {
        if (this.f4595b == 0 && this.f4596c == 0 && this.f4597d == 0) {
            return this.f4594a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4594a.toString());
        sb.append(" P");
        int i4 = this.f4595b;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('Y');
        }
        int i5 = this.f4596c;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        int i6 = this.f4597d;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('D');
        }
        return sb.toString();
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        l lVar = (l) mVar.b(j$.time.temporal.r.f4766b);
        if (lVar == null || this.f4594a.equals(lVar)) {
            if (this.f4596c != 0) {
                j$.time.temporal.u y3 = this.f4594a.y(j$.time.temporal.a.MONTH_OF_YEAR);
                long j4 = (y3.f4772a == y3.f4773b && y3.f4774c == y3.f4775d && y3.d()) ? (y3.f4775d - y3.f4772a) + 1 : -1L;
                if (j4 > 0) {
                    mVar = mVar.d((this.f4595b * j4) + this.f4596c, j$.time.temporal.b.MONTHS);
                } else {
                    int i4 = this.f4595b;
                    if (i4 != 0) {
                        mVar = mVar.d(i4, j$.time.temporal.b.YEARS);
                    }
                    mVar = mVar.d(this.f4596c, j$.time.temporal.b.MONTHS);
                }
            } else {
                int i5 = this.f4595b;
                if (i5 != 0) {
                    mVar = mVar.d(i5, j$.time.temporal.b.YEARS);
                }
            }
            int i6 = this.f4597d;
            return i6 != 0 ? mVar.d(i6, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new RuntimeException("Chronology mismatch, expected: " + this.f4594a.q() + ", actual: " + lVar.q());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0390h) {
            C0390h c0390h = (C0390h) obj;
            if (this.f4595b == c0390h.f4595b && this.f4596c == c0390h.f4596c && this.f4597d == c0390h.f4597d && this.f4594a.equals(c0390h.f4594a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.f4597d, 16) + (Integer.rotateLeft(this.f4596c, 8) + this.f4595b)) ^ this.f4594a.hashCode();
    }

    public Object writeReplace() {
        return new E((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
