package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Instant f4554c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a, reason: collision with root package name */
    public final long f4555a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4556b;

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int compare = Long.compare(this.f4555a, instant2.f4555a);
        return compare != 0 ? compare : this.f4556b - instant2.f4556b;
    }

    static {
        A(-31557014167219200L, 0L);
        A(31556889864403199L, 999999999L);
    }

    public static Instant A(long j4, long j5) {
        return s(Math.addExact(j4, Math.floorDiv(j5, 1000000000L)), (int) Math.floorMod(j5, 1000000000L));
    }

    public static Instant s(long j4, int i4) {
        if ((i4 | j4) == 0) {
            return f4554c;
        }
        if (j4 < -31557014167219200L || j4 > 31556889864403199L) {
            throw new RuntimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j4, i4);
    }

    public Instant(long j4, int i4) {
        this.f4555a = j4;
        this.f4556b = i4;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i4 = f.f4637a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 1) {
                return this.f4556b;
            }
            if (i4 == 2) {
                return this.f4556b / 1000;
            }
            if (i4 == 3) {
                return this.f4556b / 1000000;
            }
            if (i4 == 4) {
                j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
                aVar.f4747b.a(this.f4555a, aVar);
            }
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return super.l(qVar).a(qVar.P(this), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        int i4;
        if (qVar instanceof j$.time.temporal.a) {
            int i5 = f.f4637a[((j$.time.temporal.a) qVar).ordinal()];
            if (i5 == 1) {
                i4 = this.f4556b;
            } else if (i5 == 2) {
                i4 = this.f4556b / 1000;
            } else {
                if (i5 != 3) {
                    if (i5 == 4) {
                        return this.f4555a;
                    }
                    throw new RuntimeException(d.a("Unsupported field: ", qVar));
                }
                i4 = this.f4556b / 1000000;
            }
            return i4;
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (Instant) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j4);
            int i4 = f.f4637a[aVar.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = ((int) j4) * 1000;
                    if (i5 != this.f4556b) {
                        return s(this.f4555a, i5);
                    }
                } else if (i4 == 3) {
                    int i6 = ((int) j4) * 1000000;
                    if (i6 != this.f4556b) {
                        return s(this.f4555a, i6);
                    }
                } else {
                    if (i4 != 4) {
                        throw new RuntimeException(d.a("Unsupported field: ", qVar));
                    }
                    if (j4 != this.f4555a) {
                        return s(j4, this.f4556b);
                    }
                }
            } else if (j4 != this.f4556b) {
                return s(this.f4555a, (int) j4);
            }
            return this;
        }
        return (Instant) qVar.V(this, j4);
    }

    @Override // j$.time.temporal.m
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final Instant d(long j4, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (Instant) sVar.s(this, j4);
        }
        switch (f.f4638b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return F(0L, j4);
            case 2:
                return F(j4 / 1000000, (j4 % 1000000) * 1000);
            case 3:
                return F(j4 / 1000, (j4 % 1000) * 1000000);
            case 4:
                return F(j4, 0L);
            case 5:
                return F(Math.multiplyExact(j4, 60), 0L);
            case 6:
                return F(Math.multiplyExact(j4, 3600), 0L);
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return F(Math.multiplyExact(j4, 43200), 0L);
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                return F(Math.multiplyExact(j4, 86400), 0L);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final Instant F(long j4, long j5) {
        if ((j4 | j5) == 0) {
            return this;
        }
        return A(Math.addExact(Math.addExact(this.f4555a, j4), j5 / 1000000000), this.f4556b + (j5 % 1000000000));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f4767c) {
            return j$.time.temporal.b.NANOS;
        }
        if (iVar == j$.time.temporal.r.f4766b || iVar == j$.time.temporal.r.f4765a || iVar == j$.time.temporal.r.f4769e || iVar == j$.time.temporal.r.f4768d || iVar == j$.time.temporal.r.f4770f || iVar == j$.time.temporal.r.f4771g) {
            return null;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f4555a, j$.time.temporal.a.INSTANT_SECONDS).c(this.f4556b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.s(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j4 = this.f4555a;
        if (j4 < 0 && this.f4556b > 0) {
            return Math.addExact(Math.multiplyExact(j4 + 1, 1000), (this.f4556b / 1000000) - 1000);
        }
        return Math.addExact(Math.multiplyExact(j4, 1000), this.f4556b / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f4555a == instant.f4555a && this.f4556b == instant.f4556b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f4555a;
        return (this.f4556b * 51) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f4639f.format(this);
    }

    private Object writeReplace() {
        return new t((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
