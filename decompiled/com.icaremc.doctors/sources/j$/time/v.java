package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class v implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2681b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a, reason: collision with root package name */
    public final int f2682a;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f2682a - ((v) obj).f2682a;
    }

    static {
        j$.time.format.o oVar = new j$.time.format.o();
        oVar.h(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.y.EXCEEDS_PAD);
        oVar.l(Locale.getDefault(), j$.time.format.x.SMART, null);
    }

    public static v s(int i2) {
        j$.time.temporal.a.YEAR.X(i2);
        return new v(i2);
    }

    public v(int i2) {
        this.f2682a = i2;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.YEAR || qVar == j$.time.temporal.a.YEAR_OF_ERA || qVar == j$.time.temporal.a.ERA : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.u.f(1L, this.f2682a <= 0 ? 1000000000L : 999999999L);
        }
        return super.l(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        return l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i2 = u.f2679a[((j$.time.temporal.a) qVar).ordinal()];
            if (i2 == 1) {
                int i3 = this.f2682a;
                if (i3 < 1) {
                    i3 = 1 - i3;
                }
                return i3;
            }
            if (i2 == 2) {
                return this.f2682a;
            }
            if (i2 == 3) {
                return this.f2682a < 1 ? 0 : 1;
            }
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (v) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final v c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j2);
            int i2 = u.f2679a[aVar.ordinal()];
            if (i2 == 1) {
                if (this.f2682a < 1) {
                    j2 = 1 - j2;
                }
                return s((int) j2);
            }
            if (i2 == 2) {
                return s((int) j2);
            }
            if (i2 == 3) {
                return i(j$.time.temporal.a.ERA) == j2 ? this : s(1 - this.f2682a);
            }
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return (v) qVar.V(this, j2);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final v d(long j2, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            int i2 = u.f2680b[((j$.time.temporal.b) sVar).ordinal()];
            if (i2 == 1) {
                return F(j2);
            }
            if (i2 == 2) {
                return F(Math.multiplyExact(j2, 10));
            }
            if (i2 == 3) {
                return F(Math.multiplyExact(j2, 100));
            }
            if (i2 == 4) {
                return F(Math.multiplyExact(j2, 1000));
            }
            if (i2 == 5) {
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j2), aVar);
            }
            throw new RuntimeException("Unsupported unit: " + sVar);
        }
        return (v) sVar.s(this, j2);
    }

    public final v F(long j2) {
        if (j2 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return s(aVar.f2650b.a(this.f2682a + j2, aVar));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2669b) {
            return j$.time.chrono.s.f2522c;
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.YEARS;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.r(mVar).equals(j$.time.chrono.s.f2522c)) {
            throw new RuntimeException("Adjustment only supported on ISO date-time");
        }
        return mVar.c(this.f2682a, j$.time.temporal.a.YEAR);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && this.f2682a == ((v) obj).f2682a;
    }

    public final int hashCode() {
        return this.f2682a;
    }

    public final String toString() {
        return Integer.toString(this.f2682a);
    }

    private Object writeReplace() {
        return new t((byte) 11, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
