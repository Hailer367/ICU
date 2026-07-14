package j$.time;

import j$.time.chrono.InterfaceC0206b;
import j$.time.chrono.InterfaceC0209e;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class h implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC0206b, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final h f2614d = b0(-999999999, 1, 1);

    /* renamed from: e, reason: collision with root package name */
    public static final h f2615e = b0(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a, reason: collision with root package name */
    public final int f2616a;

    /* renamed from: b, reason: collision with root package name */
    public final short f2617b;

    /* renamed from: c, reason: collision with root package name */
    public final short f2618c;

    static {
        b0(1970, 1, 1);
    }

    public static h b0(int i2, int i3, int i4) {
        j$.time.temporal.a.YEAR.X(i2);
        j$.time.temporal.a.MONTH_OF_YEAR.X(i3);
        j$.time.temporal.a.DAY_OF_MONTH.X(i4);
        return A(i2, i3, i4);
    }

    public static h d0(int i2, int i3) {
        long j2 = i2;
        j$.time.temporal.a.YEAR.X(j2);
        j$.time.temporal.a.DAY_OF_YEAR.X(i3);
        j$.time.chrono.s.f2522c.getClass();
        boolean X2 = j$.time.chrono.s.X(j2);
        if (i3 == 366 && !X2) {
            throw new RuntimeException("Invalid date 'DayOfYear 366' as '" + i2 + "' is not a leap year");
        }
        n I2 = n.I(((i3 - 1) / 31) + 1);
        if (i3 > (I2.A(X2) + I2.s(X2)) - 1) {
            I2 = n.f2632a[((((int) 1) + 12) + I2.ordinal()) % 12];
        }
        return new h(i2, I2.getValue(), (i3 - I2.s(X2)) + 1);
    }

    public static h c0(long j2) {
        long j3;
        j$.time.temporal.a.EPOCH_DAY.X(j2);
        long j4 = 719468 + j2;
        if (j4 < 0) {
            long j5 = ((j2 + 719469) / 146097) - 1;
            j3 = j5 * 400;
            j4 += (-j5) * 146097;
        } else {
            j3 = 0;
        }
        long j6 = ((j4 * 400) + 591) / 146097;
        long j7 = j4 - ((j6 / 400) + (((j6 / 4) + (j6 * 365)) - (j6 / 100)));
        if (j7 < 0) {
            j6--;
            j7 = j4 - ((j6 / 400) + (((j6 / 4) + (365 * j6)) - (j6 / 100)));
        }
        int i2 = (int) j7;
        int i3 = ((i2 * 5) + 2) / 153;
        int i4 = ((i3 + 2) % 12) + 1;
        int i5 = (i2 - (((i3 * 306) + 5) / 10)) + 1;
        long j8 = j6 + j3 + (i3 / 10);
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new h(aVar.f2650b.a(j8, aVar), i4, i5);
    }

    public static h F(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        h hVar = (h) temporalAccessor.b(j$.time.temporal.r.f2673f);
        if (hVar != null) {
            return hVar;
        }
        throw new RuntimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static h A(int i2, int i3, int i4) {
        int i5 = 28;
        if (i4 > 28) {
            if (i3 != 2) {
                i5 = (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.f2522c.getClass();
                if (j$.time.chrono.s.X(i2)) {
                    i5 = 29;
                }
            }
            if (i4 > i5) {
                if (i4 == 29) {
                    throw new RuntimeException("Invalid date 'February 29' as '" + i2 + "' is not a leap year");
                }
                throw new RuntimeException("Invalid date '" + n.I(i3).name() + " " + i4 + "'");
            }
        }
        return new h(i2, i3, i4);
    }

    public static h j0(int i2, int i3, int i4) {
        if (i3 == 2) {
            j$.time.chrono.s.f2522c.getClass();
            i4 = Math.min(i4, j$.time.chrono.s.X((long) i2) ? 29 : 28);
        } else if (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) {
            i4 = Math.min(i4, 30);
        }
        return new h(i2, i3, i4);
    }

    public h(int i2, int i3, int i4) {
        this.f2616a = i2;
        this.f2617b = (short) i3;
        this.f2618c = (short) i4;
    }

    public static h a0(a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Instant instant = Instant.f2456c;
        long j2 = 1000;
        Instant s2 = Instant.s(Math.floorDiv(currentTimeMillis, j2), ((int) Math.floorMod(currentTimeMillis, j2)) * 1000000);
        Objects.requireNonNull(aVar.f2477a, "zone");
        return c0(Math.floorDiv(s2.getEpochSecond() + r6.s().d(s2).f2471b, 86400));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            if (aVar.isDateBased()) {
                int i2 = g.f2612a[aVar.ordinal()];
                if (i2 == 1) {
                    return j$.time.temporal.u.f(1L, Z());
                }
                if (i2 == 2) {
                    return j$.time.temporal.u.f(1L, Y() ? 366 : 365);
                }
                if (i2 == 3) {
                    return j$.time.temporal.u.f(1L, (n.I(this.f2617b) != n.FEBRUARY || Y()) ? 5L : 4L);
                }
                if (i2 != 4) {
                    return ((j$.time.temporal.a) qVar).f2650b;
                }
                return this.f2616a <= 0 ? j$.time.temporal.u.f(1L, 1000000000L) : j$.time.temporal.u.f(1L, 999999999L);
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
            return ((this.f2616a * 12) + this.f2617b) - 1;
        }
        return qVar.P(this);
    }

    public final int I(j$.time.temporal.q qVar) {
        switch (g.f2612a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f2618c;
            case 2:
                return V();
            case 3:
                return ((this.f2618c - 1) / 7) + 1;
            case 4:
                int i2 = this.f2616a;
                return i2 >= 1 ? i2 : 1 - i2;
            case 5:
                return P().getValue();
            case 6:
                return ((this.f2618c - 1) % 7) + 1;
            case 7:
                return ((V() - 1) % 7) + 1;
            case 8:
                throw new RuntimeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((V() - 1) / 7) + 1;
            case 10:
                return this.f2617b;
            case 11:
                throw new RuntimeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f2616a;
            case 13:
                return this.f2616a >= 1 ? 1 : 0;
            default:
                throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final j$.time.chrono.l f() {
        return j$.time.chrono.s.f2522c;
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final j$.time.chrono.m N() {
        return this.f2616a >= 1 ? j$.time.chrono.t.CE : j$.time.chrono.t.BCE;
    }

    public final int V() {
        return (n.I(this.f2617b).s(Y()) + this.f2618c) - 1;
    }

    public final DayOfWeek P() {
        return DayOfWeek.s(((int) Math.floorMod(K() + 3, 7)) + 1);
    }

    public final boolean Y() {
        j$.time.chrono.s sVar = j$.time.chrono.s.f2522c;
        long j2 = this.f2616a;
        sVar.getClass();
        return j$.time.chrono.s.X(j2);
    }

    public final int Z() {
        short s2 = this.f2617b;
        return s2 != 2 ? (s2 == 4 || s2 == 6 || s2 == 9 || s2 == 11) ? 30 : 31 : Y() ? 29 : 28;
    }

    @Override // j$.time.chrono.InterfaceC0206b
    /* renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final h m(j$.time.temporal.n nVar) {
        if (nVar instanceof h) {
            return (h) nVar;
        }
        return (h) nVar.e(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final h c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j2);
            switch (g.f2612a[aVar.ordinal()]) {
                case 1:
                    int i2 = (int) j2;
                    if (this.f2618c != i2) {
                        return b0(this.f2616a, this.f2617b, i2);
                    }
                    return this;
                case 2:
                    int i3 = (int) j2;
                    if (V() != i3) {
                        return d0(this.f2616a, i3);
                    }
                    return this;
                case 3:
                    return h0(j2 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    if (this.f2616a < 1) {
                        j2 = 1 - j2;
                    }
                    return m0((int) j2);
                case 5:
                    return f0(j2 - P().getValue());
                case 6:
                    return f0(j2 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return f0(j2 - i(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return c0(j2);
                case 9:
                    return h0(j2 - i(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    int i4 = (int) j2;
                    if (this.f2617b != i4) {
                        j$.time.temporal.a.MONTH_OF_YEAR.X(i4);
                        return j0(this.f2616a, i4, this.f2618c);
                    }
                    return this;
                case 11:
                    return g0(j2 - (((this.f2616a * 12) + this.f2617b) - 1));
                case 12:
                    return m0((int) j2);
                case 13:
                    if (i(j$.time.temporal.a.ERA) != j2) {
                        return m0(1 - this.f2616a);
                    }
                    return this;
                default:
                    throw new RuntimeException(d.a("Unsupported field: ", qVar));
            }
        }
        return (h) qVar.V(this, j2);
    }

    public final h m0(int i2) {
        if (this.f2616a == i2) {
            return this;
        }
        j$.time.temporal.a.YEAR.X(i2);
        return j0(i2, this.f2617b, this.f2618c);
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final InterfaceC0206b R(j$.time.temporal.p pVar) {
        if (pVar != null) {
            s sVar = (s) pVar;
            return g0((sVar.f2643a * 12) + sVar.f2644b).f0(sVar.f2645c);
        }
        Objects.requireNonNull(pVar, "amountToAdd");
        return (h) ((s) pVar).s(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final h d(long j2, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (g.f2613b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return f0(j2);
                case 2:
                    return h0(j2);
                case 3:
                    return g0(j2);
                case 4:
                    return i0(j2);
                case 5:
                    return i0(Math.multiplyExact(j2, 10));
                case 6:
                    return i0(Math.multiplyExact(j2, 100));
                case 7:
                    return i0(Math.multiplyExact(j2, 1000));
                case 8:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return c(Math.addExact(i(aVar), j2), aVar);
                default:
                    throw new RuntimeException("Unsupported unit: " + sVar);
            }
        }
        return (h) sVar.s(this, j2);
    }

    public final h i0(long j2) {
        if (j2 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return j0(aVar.f2650b.a(this.f2616a + j2, aVar), this.f2617b, this.f2618c);
    }

    public final h g0(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (this.f2616a * 12) + (this.f2617b - 1) + j2;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j4 = 12;
        return j0(aVar.f2650b.a(Math.floorDiv(j3, j4), aVar), ((int) Math.floorMod(j3, j4)) + 1, this.f2618c);
    }

    public final h h0(long j2) {
        return f0(Math.multiplyExact(j2, 7));
    }

    public final h f0(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = this.f2618c + j2;
        if (j3 > 0) {
            if (j3 <= 28) {
                return new h(this.f2616a, this.f2617b, (int) j3);
            }
            if (j3 <= 59) {
                long Z2 = Z();
                if (j3 <= Z2) {
                    return new h(this.f2616a, this.f2617b, (int) j3);
                }
                short s2 = this.f2617b;
                if (s2 < 12) {
                    return new h(this.f2616a, s2 + 1, (int) (j3 - Z2));
                }
                j$.time.temporal.a.YEAR.X(this.f2616a + 1);
                return new h(this.f2616a + 1, 1, (int) (j3 - Z2));
            }
        }
        return c0(Math.addExact(K(), j2));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        return iVar == j$.time.temporal.r.f2673f ? this : super.b(iVar);
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final InterfaceC0209e L(l lVar) {
        return LocalDateTime.I(this, lVar);
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final long K() {
        long j2 = this.f2616a;
        long j3 = this.f2617b;
        long j4 = 365 * j2;
        long j5 = (((367 * j3) - 362) / 12) + (j2 >= 0 ? ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4 : j4 - ((j2 / (-400)) + ((j2 / (-4)) - (j2 / (-100))))) + (this.f2618c - 1);
        if (j3 > 2) {
            j5 = !Y() ? j5 - 2 : j5 - 1;
        }
        return j5 - 719528;
    }

    @Override // j$.time.chrono.InterfaceC0206b, java.lang.Comparable
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC0206b interfaceC0206b) {
        if (interfaceC0206b instanceof h) {
            return s((h) interfaceC0206b);
        }
        return super.compareTo(interfaceC0206b);
    }

    public final int s(h hVar) {
        int i2 = this.f2616a - hVar.f2616a;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f2617b - hVar.f2617b;
        return i3 == 0 ? this.f2618c - hVar.f2618c : i3;
    }

    public final boolean X(InterfaceC0206b interfaceC0206b) {
        return interfaceC0206b instanceof h ? s((h) interfaceC0206b) < 0 : K() < interfaceC0206b.K();
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && s((h) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final int hashCode() {
        int i2 = this.f2616a;
        return (((i2 << 11) + (this.f2617b << 6)) + this.f2618c) ^ (i2 & (-2048));
    }

    @Override // j$.time.chrono.InterfaceC0206b
    public final String toString() {
        int i2 = this.f2616a;
        short s2 = this.f2617b;
        short s3 = this.f2618c;
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        } else if (i2 < 0) {
            sb.append(i2 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i2 + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        sb.append(s3 < 10 ? "-0" : "-");
        sb.append((int) s3);
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
