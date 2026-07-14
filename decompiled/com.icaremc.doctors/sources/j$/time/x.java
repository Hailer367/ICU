package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class x implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2685c = 0;
    private static final long serialVersionUID = 4183400860270640070L;

    /* renamed from: a, reason: collision with root package name */
    public final int f2686a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2687b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        x xVar = (x) obj;
        int i2 = this.f2686a - xVar.f2686a;
        return i2 == 0 ? this.f2687b - xVar.f2687b : i2;
    }

    static {
        j$.time.format.o oVar = new j$.time.format.o();
        oVar.h(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.y.EXCEEDS_PAD);
        oVar.c('-');
        oVar.g(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        oVar.l(Locale.getDefault(), j$.time.format.x.SMART, null);
    }

    public x(int i2, int i3) {
        this.f2686a = i2;
        this.f2687b = i3;
    }

    public final x P(int i2, int i3) {
        return (this.f2686a == i2 && this.f2687b == i3) ? this : new x(i2, i3);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.YEAR || qVar == j$.time.temporal.a.MONTH_OF_YEAR || qVar == j$.time.temporal.a.PROLEPTIC_MONTH || qVar == j$.time.temporal.a.YEAR_OF_ERA || qVar == j$.time.temporal.a.ERA : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.u.f(1L, this.f2686a <= 0 ? 1000000000L : 999999999L);
        }
        return super.l(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        return l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        int i2;
        if (qVar instanceof j$.time.temporal.a) {
            int i3 = w.f2683a[((j$.time.temporal.a) qVar).ordinal()];
            if (i3 == 1) {
                i2 = this.f2687b;
            } else {
                if (i3 == 2) {
                    return s();
                }
                if (i3 == 3) {
                    int i4 = this.f2686a;
                    if (i4 < 1) {
                        i4 = 1 - i4;
                    }
                    return i4;
                }
                if (i3 != 4) {
                    if (i3 == 5) {
                        return this.f2686a < 1 ? 0 : 1;
                    }
                    throw new RuntimeException(d.a("Unsupported field: ", qVar));
                }
                i2 = this.f2686a;
            }
            return i2;
        }
        return qVar.P(this);
    }

    public final long s() {
        return ((this.f2686a * 12) + this.f2687b) - 1;
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (x) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final x c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j2);
            int i2 = w.f2683a[aVar.ordinal()];
            if (i2 == 1) {
                int i3 = (int) j2;
                j$.time.temporal.a.MONTH_OF_YEAR.X(i3);
                return P(this.f2686a, i3);
            }
            if (i2 == 2) {
                return F(j2 - s());
            }
            if (i2 == 3) {
                if (this.f2686a < 1) {
                    j2 = 1 - j2;
                }
                int i4 = (int) j2;
                j$.time.temporal.a.YEAR.X(i4);
                return P(i4, this.f2687b);
            }
            if (i2 == 4) {
                int i5 = (int) j2;
                j$.time.temporal.a.YEAR.X(i5);
                return P(i5, this.f2687b);
            }
            if (i2 != 5) {
                throw new RuntimeException(d.a("Unsupported field: ", qVar));
            }
            if (i(j$.time.temporal.a.ERA) == j2) {
                return this;
            }
            int i6 = 1 - this.f2686a;
            j$.time.temporal.a.YEAR.X(i6);
            return P(i6, this.f2687b);
        }
        return (x) qVar.V(this, j2);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final x d(long j2, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (w.f2684b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return F(j2);
                case 2:
                    return I(j2);
                case 3:
                    return I(Math.multiplyExact(j2, 10));
                case 4:
                    return I(Math.multiplyExact(j2, 100));
                case 5:
                    return I(Math.multiplyExact(j2, 1000));
                case 6:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return c(Math.addExact(i(aVar), j2), aVar);
                default:
                    throw new RuntimeException("Unsupported unit: " + sVar);
            }
        }
        return (x) sVar.s(this, j2);
    }

    public final x I(long j2) {
        if (j2 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return P(aVar.f2650b.a(this.f2686a + j2, aVar), this.f2687b);
    }

    public final x F(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (this.f2686a * 12) + (this.f2687b - 1) + j2;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j4 = 12;
        return P(aVar.f2650b.a(Math.floorDiv(j3, j4), aVar), ((int) Math.floorMod(j3, j4)) + 1);
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
            return j$.time.temporal.b.MONTHS;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.r(mVar).equals(j$.time.chrono.s.f2522c)) {
            throw new RuntimeException("Adjustment only supported on ISO date-time");
        }
        return mVar.c(s(), j$.time.temporal.a.PROLEPTIC_MONTH);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f2686a == xVar.f2686a && this.f2687b == xVar.f2687b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2686a ^ (this.f2687b << 27);
    }

    public final String toString() {
        int abs = Math.abs(this.f2686a);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i2 = this.f2686a;
            if (i2 < 0) {
                sb.append(i2 - 10000);
                sb.deleteCharAt(1);
            } else {
                sb.append(i2 + 10000);
                sb.deleteCharAt(0);
            }
        } else {
            sb.append(this.f2686a);
        }
        sb.append(this.f2687b < 10 ? "-0" : "-");
        sb.append(this.f2687b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 12, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
