package j$.time;

import j$.time.chrono.InterfaceC0384b;
import j$.time.chrono.InterfaceC0387e;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class h implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC0384b, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final h f4711d = b0(-999999999, 1, 1);

    /* renamed from: e, reason: collision with root package name */
    public static final h f4712e = b0(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a, reason: collision with root package name */
    public final int f4713a;

    /* renamed from: b, reason: collision with root package name */
    public final short f4714b;

    /* renamed from: c, reason: collision with root package name */
    public final short f4715c;

    static {
        b0(1970, 1, 1);
    }

    public static h b0(int i4, int i5, int i6) {
        j$.time.temporal.a.YEAR.X(i4);
        j$.time.temporal.a.MONTH_OF_YEAR.X(i5);
        j$.time.temporal.a.DAY_OF_MONTH.X(i6);
        return A(i4, i5, i6);
    }

    public static h d0(int i4, int i5) {
        long j4 = i4;
        j$.time.temporal.a.YEAR.X(j4);
        j$.time.temporal.a.DAY_OF_YEAR.X(i5);
        j$.time.chrono.s.f4619c.getClass();
        boolean X3 = j$.time.chrono.s.X(j4);
        if (i5 == 366 && !X3) {
            throw new RuntimeException("Invalid date 'DayOfYear 366' as '" + i4 + "' is not a leap year");
        }
        n I3 = n.I(((i5 - 1) / 31) + 1);
        if (i5 > (I3.A(X3) + I3.s(X3)) - 1) {
            I3 = n.f4729a[((((int) 1) + 12) + I3.ordinal()) % 12];
        }
        return new h(i4, I3.getValue(), (i5 - I3.s(X3)) + 1);
    }

    public static h c0(long j4) {
        long j5;
        j$.time.temporal.a.EPOCH_DAY.X(j4);
        long j6 = 719468 + j4;
        if (j6 < 0) {
            long j7 = ((j4 + 719469) / 146097) - 1;
            j5 = j7 * 400;
            j6 += (-j7) * 146097;
        } else {
            j5 = 0;
        }
        long j8 = ((j6 * 400) + 591) / 146097;
        long j9 = j6 - ((j8 / 400) + (((j8 / 4) + (j8 * 365)) - (j8 / 100)));
        if (j9 < 0) {
            j8--;
            j9 = j6 - ((j8 / 400) + (((j8 / 4) + (365 * j8)) - (j8 / 100)));
        }
        int i4 = (int) j9;
        int i5 = ((i4 * 5) + 2) / 153;
        int i6 = ((i5 + 2) % 12) + 1;
        int i7 = (i4 - (((i5 * 306) + 5) / 10)) + 1;
        long j10 = j8 + j5 + (i5 / 10);
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new h(aVar.f4747b.a(j10, aVar), i6, i7);
    }

    public static h F(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        h hVar = (h) temporalAccessor.b(j$.time.temporal.r.f4770f);
        if (hVar != null) {
            return hVar;
        }
        throw new RuntimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static h A(int i4, int i5, int i6) {
        int i7 = 28;
        if (i6 > 28) {
            if (i5 != 2) {
                i7 = (i5 == 4 || i5 == 6 || i5 == 9 || i5 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.f4619c.getClass();
                if (j$.time.chrono.s.X(i4)) {
                    i7 = 29;
                }
            }
            if (i6 > i7) {
                if (i6 == 29) {
                    throw new RuntimeException("Invalid date 'February 29' as '" + i4 + "' is not a leap year");
                }
                throw new RuntimeException("Invalid date '" + n.I(i5).name() + " " + i6 + "'");
            }
        }
        return new h(i4, i5, i6);
    }

    public static h j0(int i4, int i5, int i6) {
        if (i5 == 2) {
            j$.time.chrono.s.f4619c.getClass();
            i6 = Math.min(i6, j$.time.chrono.s.X((long) i4) ? 29 : 28);
        } else if (i5 == 4 || i5 == 6 || i5 == 9 || i5 == 11) {
            i6 = Math.min(i6, 30);
        }
        return new h(i4, i5, i6);
    }

    public h(int i4, int i5, int i6) {
        this.f4713a = i4;
        this.f4714b = (short) i5;
        this.f4715c = (short) i6;
    }

    public static h a0(a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Instant instant = Instant.f4554c;
        long j4 = 1000;
        Instant s3 = Instant.s(Math.floorDiv(currentTimeMillis, j4), ((int) Math.floorMod(currentTimeMillis, j4)) * 1000000);
        ZoneId zoneId = aVar.f4575a;
        Objects.requireNonNull(s3, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return c0(Math.floorDiv(s3.f4555a + zoneId.s().d(s3).f4569b, 86400));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            if (aVar.isDateBased()) {
                int i4 = g.f4709a[aVar.ordinal()];
                if (i4 == 1) {
                    return j$.time.temporal.u.f(1L, Z());
                }
                if (i4 == 2) {
                    return j$.time.temporal.u.f(1L, Y() ? 366 : 365);
                }
                if (i4 == 3) {
                    return j$.time.temporal.u.f(1L, (n.I(this.f4714b) != n.FEBRUARY || Y()) ? 5L : 4L);
                }
                if (i4 != 4) {
                    return ((j$.time.temporal.a) qVar).f4747b;
                }
                return this.f4713a <= 0 ? j$.time.temporal.u.f(1L, 1000000000L) : j$.time.temporal.u.f(1L, 999999999L);
            }
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return I(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.EPOCH_DAY) {
                return K();
            }
            if (qVar != j$.time.temporal.a.PROLEPTIC_MONTH) {
                return I(qVar);
            }
            return ((this.f4713a * 12) + this.f4714b) - 1;
        }
        return qVar.P(this);
    }

    public final int I(j$.time.temporal.q qVar) {
        switch (g.f4709a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f4715c;
            case 2:
                return V();
            case 3:
                return ((this.f4715c - 1) / 7) + 1;
            case 4:
                int i4 = this.f4713a;
                return i4 >= 1 ? i4 : 1 - i4;
            case 5:
                return P().getValue();
            case 6:
                return ((this.f4715c - 1) % 7) + 1;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return ((V() - 1) % 7) + 1;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                throw new RuntimeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((V() - 1) / 7) + 1;
            case 10:
                return this.f4714b;
            case 11:
                throw new RuntimeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f4713a;
            case 13:
                return this.f4713a >= 1 ? 1 : 0;
            default:
                throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final j$.time.chrono.l f() {
        return j$.time.chrono.s.f4619c;
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final j$.time.chrono.m N() {
        return this.f4713a >= 1 ? j$.time.chrono.t.CE : j$.time.chrono.t.BCE;
    }

    public final int V() {
        return (n.I(this.f4714b).s(Y()) + this.f4715c) - 1;
    }

    public final DayOfWeek P() {
        return DayOfWeek.s(((int) Math.floorMod(K() + 3, 7)) + 1);
    }

    public final boolean Y() {
        j$.time.chrono.s sVar = j$.time.chrono.s.f4619c;
        long j4 = this.f4713a;
        sVar.getClass();
        return j$.time.chrono.s.X(j4);
    }

    public final int Z() {
        short s3 = this.f4714b;
        return s3 != 2 ? (s3 == 4 || s3 == 6 || s3 == 9 || s3 == 11) ? 30 : 31 : Y() ? 29 : 28;
    }

    @Override // j$.time.chrono.InterfaceC0384b
    /* renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final h m(j$.time.temporal.n nVar) {
        if (nVar instanceof h) {
            return (h) nVar;
        }
        return (h) nVar.e(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final h c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j4);
            switch (g.f4709a[aVar.ordinal()]) {
                case 1:
                    int i4 = (int) j4;
                    if (this.f4715c != i4) {
                        return b0(this.f4713a, this.f4714b, i4);
                    }
                    return this;
                case 2:
                    int i5 = (int) j4;
                    if (V() != i5) {
                        return d0(this.f4713a, i5);
                    }
                    return this;
                case 3:
                    return h0(j4 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    if (this.f4713a < 1) {
                        j4 = 1 - j4;
                    }
                    return m0((int) j4);
                case 5:
                    return f0(j4 - P().getValue());
                case 6:
                    return f0(j4 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    return f0(j4 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    return c0(j4);
                case 9:
                    return h0(j4 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    int i6 = (int) j4;
                    if (this.f4714b != i6) {
                        j$.time.temporal.a.MONTH_OF_YEAR.X(i6);
                        return j0(this.f4713a, i6, this.f4715c);
                    }
                    return this;
                case 11:
                    return g0(j4 - (((this.f4713a * 12) + this.f4714b) - 1));
                case 12:
                    return m0((int) j4);
                case 13:
                    if (i(j$.time.temporal.a.ERA) != j4) {
                        return m0(1 - this.f4713a);
                    }
                    return this;
                default:
                    throw new RuntimeException(d.a("Unsupported field: ", qVar));
            }
        }
        return (h) qVar.V(this, j4);
    }

    public final h m0(int i4) {
        if (this.f4713a == i4) {
            return this;
        }
        j$.time.temporal.a.YEAR.X(i4);
        return j0(i4, this.f4714b, this.f4715c);
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final InterfaceC0384b R(j$.time.temporal.p pVar) {
        if (pVar != null) {
            s sVar = (s) pVar;
            return g0((sVar.f4740a * 12) + sVar.f4741b).f0(sVar.f4742c);
        }
        Objects.requireNonNull(pVar, "amountToAdd");
        return (h) ((s) pVar).s(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final h d(long j4, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (g.f4710b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return f0(j4);
                case 2:
                    return h0(j4);
                case 3:
                    return g0(j4);
                case 4:
                    return i0(j4);
                case 5:
                    return i0(Math.multiplyExact(j4, 10));
                case 6:
                    return i0(Math.multiplyExact(j4, 100));
                case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    return i0(Math.multiplyExact(j4, 1000));
                case R.j.BYTES_FIELD_NUMBER /* 8 */:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return c(Math.addExact(i(aVar), j4), aVar);
                default:
                    throw new RuntimeException("Unsupported unit: " + sVar);
            }
        }
        return (h) sVar.s(this, j4);
    }

    public final h i0(long j4) {
        if (j4 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return j0(aVar.f4747b.a(this.f4713a + j4, aVar), this.f4714b, this.f4715c);
    }

    public final h g0(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = (this.f4713a * 12) + (this.f4714b - 1) + j4;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j6 = 12;
        return j0(aVar.f4747b.a(Math.floorDiv(j5, j6), aVar), ((int) Math.floorMod(j5, j6)) + 1, this.f4715c);
    }

    public final h h0(long j4) {
        return f0(Math.multiplyExact(j4, 7));
    }

    public final h f0(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = this.f4715c + j4;
        if (j5 > 0) {
            if (j5 <= 28) {
                return new h(this.f4713a, this.f4714b, (int) j5);
            }
            if (j5 <= 59) {
                long Z3 = Z();
                if (j5 <= Z3) {
                    return new h(this.f4713a, this.f4714b, (int) j5);
                }
                short s3 = this.f4714b;
                if (s3 < 12) {
                    return new h(this.f4713a, s3 + 1, (int) (j5 - Z3));
                }
                j$.time.temporal.a.YEAR.X(this.f4713a + 1);
                return new h(this.f4713a + 1, 1, (int) (j5 - Z3));
            }
        }
        return c0(Math.addExact(K(), j4));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        return iVar == j$.time.temporal.r.f4770f ? this : super.b(iVar);
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final InterfaceC0387e L(l lVar) {
        return LocalDateTime.I(this, lVar);
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final long K() {
        long j4 = this.f4713a;
        long j5 = this.f4714b;
        long j6 = 365 * j4;
        long j7 = (((367 * j5) - 362) / 12) + (j4 >= 0 ? ((j4 + 399) / 400) + (((3 + j4) / 4) - ((99 + j4) / 100)) + j6 : j6 - ((j4 / (-400)) + ((j4 / (-4)) - (j4 / (-100))))) + (this.f4715c - 1);
        if (j5 > 2) {
            j7 = !Y() ? j7 - 2 : j7 - 1;
        }
        return j7 - 719528;
    }

    @Override // j$.time.chrono.InterfaceC0384b, java.lang.Comparable
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC0384b interfaceC0384b) {
        if (interfaceC0384b instanceof h) {
            return s((h) interfaceC0384b);
        }
        return super.compareTo(interfaceC0384b);
    }

    public final int s(h hVar) {
        int i4 = this.f4713a - hVar.f4713a;
        if (i4 != 0) {
            return i4;
        }
        int i5 = this.f4714b - hVar.f4714b;
        return i5 == 0 ? this.f4715c - hVar.f4715c : i5;
    }

    public final boolean X(InterfaceC0384b interfaceC0384b) {
        return interfaceC0384b instanceof h ? s((h) interfaceC0384b) < 0 : K() < interfaceC0384b.K();
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && s((h) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final int hashCode() {
        int i4 = this.f4713a;
        return (((i4 << 11) + (this.f4714b << 6)) + this.f4715c) ^ (i4 & (-2048));
    }

    @Override // j$.time.chrono.InterfaceC0384b
    public final String toString() {
        int i4 = this.f4713a;
        short s3 = this.f4714b;
        short s4 = this.f4715c;
        int abs = Math.abs(i4);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i4 > 9999) {
                sb.append('+');
            }
            sb.append(i4);
        } else if (i4 < 0) {
            sb.append(i4 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i4 + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(s3 < 10 ? "-0" : "-");
        sb.append((int) s3);
        sb.append(s4 < 10 ? "-0" : "-");
        sb.append((int) s4);
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
