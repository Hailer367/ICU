package j$.time;

import com.google.firebase.encoders.json.BuildConfig;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class p implements TemporalAccessor, j$.time.temporal.n, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2635c = 0;
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a, reason: collision with root package name */
    public final int f2636a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2637b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        p pVar = (p) obj;
        int i2 = this.f2636a - pVar.f2636a;
        return i2 == 0 ? this.f2637b - pVar.f2637b : i2;
    }

    static {
        j$.time.format.o oVar = new j$.time.format.o();
        oVar.d("--");
        oVar.g(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        oVar.c('-');
        oVar.g(j$.time.temporal.a.DAY_OF_MONTH, 2);
        oVar.l(Locale.getDefault(), j$.time.format.x.SMART, null);
    }

    public p(int i2, int i3) {
        this.f2636a = i2;
        this.f2637b = i3;
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
        n I2 = n.I(this.f2636a);
        I2.getClass();
        int i2 = m.f2631a[I2.ordinal()];
        return j$.time.temporal.u.g(i2 != 1 ? (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) ? 30 : 31 : 28, n.I(this.f2636a).F());
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        return l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        int i2;
        if (qVar instanceof j$.time.temporal.a) {
            int i3 = o.f2634a[((j$.time.temporal.a) qVar).ordinal()];
            if (i3 == 1) {
                i2 = this.f2637b;
            } else if (i3 == 2) {
                i2 = this.f2636a;
            } else {
                throw new RuntimeException(d.a("Unsupported field: ", qVar));
            }
            return i2;
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2669b) {
            return j$.time.chrono.s.f2522c;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.r(mVar).equals(j$.time.chrono.s.f2522c)) {
            throw new RuntimeException("Adjustment only supported on ISO date-time");
        }
        j$.time.temporal.m c2 = mVar.c(this.f2636a, j$.time.temporal.a.MONTH_OF_YEAR);
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return c2.c(Math.min(c2.l(aVar).f2678d, this.f2637b), aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f2636a == pVar.f2636a && this.f2637b == pVar.f2637b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f2636a << 6) + this.f2637b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f2636a < 10 ? "0" : BuildConfig.FLAVOR);
        sb.append(this.f2636a);
        sb.append(this.f2637b < 10 ? "-0" : "-");
        sb.append(this.f2637b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
