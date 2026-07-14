package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class v implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f4778b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a, reason: collision with root package name */
    public final int f4779a;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f4779a - ((v) obj).f4779a;
    }

    static {
        j$.time.format.o oVar = new j$.time.format.o();
        oVar.h(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.y.EXCEEDS_PAD);
        oVar.l(Locale.getDefault(), j$.time.format.x.SMART, null);
    }

    public static v s(int i4) {
        j$.time.temporal.a.YEAR.X(i4);
        return new v(i4);
    }

    public v(int i4) {
        this.f4779a = i4;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.YEAR || qVar == j$.time.temporal.a.YEAR_OF_ERA || qVar == j$.time.temporal.a.ERA : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.u.f(1L, this.f4779a <= 0 ? 1000000000L : 999999999L);
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
            int i4 = u.f4776a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 1) {
                int i5 = this.f4779a;
                if (i5 < 1) {
                    i5 = 1 - i5;
                }
                return i5;
            }
            if (i4 == 2) {
                return this.f4779a;
            }
            if (i4 == 3) {
                return this.f4779a < 1 ? 0 : 1;
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
    public final v c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j4);
            int i4 = u.f4776a[aVar.ordinal()];
            if (i4 == 1) {
                if (this.f4779a < 1) {
                    j4 = 1 - j4;
                }
                return s((int) j4);
            }
            if (i4 == 2) {
                return s((int) j4);
            }
            if (i4 == 3) {
                return i(j$.time.temporal.a.ERA) == j4 ? this : s(1 - this.f4779a);
            }
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return (v) qVar.V(this, j4);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final v d(long j4, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            int i4 = u.f4777b[((j$.time.temporal.b) sVar).ordinal()];
            if (i4 == 1) {
                return F(j4);
            }
            if (i4 == 2) {
                return F(Math.multiplyExact(j4, 10));
            }
            if (i4 == 3) {
                return F(Math.multiplyExact(j4, 100));
            }
            if (i4 == 4) {
                return F(Math.multiplyExact(j4, 1000));
            }
            if (i4 == 5) {
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j4), aVar);
            }
            throw new RuntimeException("Unsupported unit: " + sVar);
        }
        return (v) sVar.s(this, j4);
    }

    public final v F(long j4) {
        if (j4 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return s(aVar.f4747b.a(this.f4779a + j4, aVar));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f4766b) {
            return j$.time.chrono.s.f4619c;
        }
        if (iVar == j$.time.temporal.r.f4767c) {
            return j$.time.temporal.b.YEARS;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.r(mVar).equals(j$.time.chrono.s.f4619c)) {
            throw new RuntimeException("Adjustment only supported on ISO date-time");
        }
        return mVar.c(this.f4779a, j$.time.temporal.a.YEAR);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && this.f4779a == ((v) obj).f4779a;
    }

    public final int hashCode() {
        return this.f4779a;
    }

    public final String toString() {
        return Integer.toString(this.f4779a);
    }

    private Object writeReplace() {
        return new t((byte) 11, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
