package j$.time;

import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class p implements TemporalAccessor, j$.time.temporal.n, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f4732c = 0;
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a, reason: collision with root package name */
    public final int f4733a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4734b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        p pVar = (p) obj;
        int i4 = this.f4733a - pVar.f4733a;
        return i4 == 0 ? this.f4734b - pVar.f4734b : i4;
    }

    static {
        j$.time.format.o oVar = new j$.time.format.o();
        oVar.d("--");
        oVar.g(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        oVar.c('-');
        oVar.g(j$.time.temporal.a.DAY_OF_MONTH, 2);
        oVar.l(Locale.getDefault(), j$.time.format.x.SMART, null);
    }

    public p(int i4, int i5) {
        this.f4733a = i4;
        this.f4734b = i5;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.MONTH_OF_YEAR || qVar == j$.time.temporal.a.DAY_OF_MONTH : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return qVar.I();
        }
        if (qVar != j$.time.temporal.a.DAY_OF_MONTH) {
            return super.l(qVar);
        }
        n I3 = n.I(this.f4733a);
        I3.getClass();
        int i4 = m.f4728a[I3.ordinal()];
        return j$.time.temporal.u.g(i4 != 1 ? (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) ? 30 : 31 : 28, n.I(this.f4733a).F());
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        return l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        int i4;
        if (qVar instanceof j$.time.temporal.a) {
            int i5 = o.f4731a[((j$.time.temporal.a) qVar).ordinal()];
            if (i5 == 1) {
                i4 = this.f4734b;
            } else if (i5 == 2) {
                i4 = this.f4733a;
            } else {
                throw new RuntimeException(d.a("Unsupported field: ", qVar));
            }
            return i4;
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f4766b) {
            return j$.time.chrono.s.f4619c;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.r(mVar).equals(j$.time.chrono.s.f4619c)) {
            throw new RuntimeException("Adjustment only supported on ISO date-time");
        }
        j$.time.temporal.m c4 = mVar.c(this.f4733a, j$.time.temporal.a.MONTH_OF_YEAR);
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return c4.c(Math.min(c4.l(aVar).f4775d, this.f4734b), aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f4733a == pVar.f4733a && this.f4734b == pVar.f4734b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f4733a << 6) + this.f4734b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f4733a < 10 ? "0" : "");
        sb.append(this.f4733a);
        sb.append(this.f4734b < 10 ? "-0" : "-");
        sb.append(this.f4734b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
