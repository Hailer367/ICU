package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Instant f2456c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a, reason: collision with root package name */
    public final long f2457a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2458b;

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int compare = Long.compare(this.f2457a, instant2.f2457a);
        return compare != 0 ? compare : this.f2458b - instant2.f2458b;
    }

    static {
        ofEpochSecond(-31557014167219200L, 0L);
        ofEpochSecond(31556889864403199L, 999999999L);
    }

    public static Instant ofEpochSecond(long j2, long j3) {
        return s(Math.addExact(j2, Math.floorDiv(j3, 1000000000L)), (int) Math.floorMod(j3, 1000000000L));
    }

    public static Instant s(long j2, int i2) {
        if ((i2 | j2) == 0) {
            return f2456c;
        }
        if (j2 < -31557014167219200L || j2 > 31556889864403199L) {
            throw new RuntimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j2, i2);
    }

    public Instant(long j2, int i2) {
        this.f2457a = j2;
        this.f2458b = i2;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i2 = f.f2540a[((j$.time.temporal.a) qVar).ordinal()];
            if (i2 == 1) {
                return this.f2458b;
            }
            if (i2 == 2) {
                return this.f2458b / 1000;
            }
            if (i2 == 3) {
                return this.f2458b / 1000000;
            }
            if (i2 == 4) {
                j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
                aVar.f2650b.a(this.f2457a, aVar);
            }
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return super.l(qVar).a(qVar.P(this), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        int i2;
        if (qVar instanceof j$.time.temporal.a) {
            int i3 = f.f2540a[((j$.time.temporal.a) qVar).ordinal()];
            if (i3 == 1) {
                i2 = this.f2458b;
            } else if (i3 == 2) {
                i2 = this.f2458b / 1000;
            } else {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return this.f2457a;
                    }
                    throw new RuntimeException(d.a("Unsupported field: ", qVar));
                }
                i2 = this.f2458b / 1000000;
            }
            return i2;
        }
        return qVar.P(this);
    }

    public long getEpochSecond() {
        return this.f2457a;
    }

    public int getNano() {
        return this.f2458b;
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (Instant) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            aVar.X(j2);
            int i2 = f.f2540a[aVar.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = ((int) j2) * 1000;
                    if (i3 != this.f2458b) {
                        return s(this.f2457a, i3);
                    }
                } else if (i2 == 3) {
                    int i4 = ((int) j2) * 1000000;
                    if (i4 != this.f2458b) {
                        return s(this.f2457a, i4);
                    }
                } else {
                    if (i2 != 4) {
                        throw new RuntimeException(d.a("Unsupported field: ", qVar));
                    }
                    if (j2 != this.f2457a) {
                        return s(j2, this.f2458b);
                    }
                }
            } else if (j2 != this.f2458b) {
                return s(this.f2457a, (int) j2);
            }
            return this;
        }
        return (Instant) qVar.V(this, j2);
    }

    @Override // j$.time.temporal.m
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final Instant d(long j2, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (Instant) sVar.s(this, j2);
        }
        switch (f.f2541b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return A(0L, j2);
            case 2:
                return A(j2 / 1000000, (j2 % 1000000) * 1000);
            case 3:
                return A(j2 / 1000, (j2 % 1000) * 1000000);
            case 4:
                return A(j2, 0L);
            case 5:
                return A(Math.multiplyExact(j2, 60), 0L);
            case 6:
                return A(Math.multiplyExact(j2, 3600), 0L);
            case 7:
                return A(Math.multiplyExact(j2, 43200), 0L);
            case 8:
                return A(Math.multiplyExact(j2, 86400), 0L);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final Instant A(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return ofEpochSecond(Math.addExact(Math.addExact(this.f2457a, j2), j3 / 1000000000), this.f2458b + (j3 % 1000000000));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.NANOS;
        }
        if (iVar == j$.time.temporal.r.f2669b || iVar == j$.time.temporal.r.f2668a || iVar == j$.time.temporal.r.f2672e || iVar == j$.time.temporal.r.f2671d || iVar == j$.time.temporal.r.f2673f || iVar == j$.time.temporal.r.f2674g) {
            return null;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f2457a, j$.time.temporal.a.INSTANT_SECONDS).c(this.f2458b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.s(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j2 = this.f2457a;
        if (j2 < 0 && this.f2458b > 0) {
            return Math.addExact(Math.multiplyExact(j2 + 1, 1000), (this.f2458b / 1000000) - 1000);
        }
        return Math.addExact(Math.multiplyExact(j2, 1000), this.f2458b / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f2457a == instant.f2457a && this.f2458b == instant.f2458b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f2457a;
        return (this.f2458b * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f2542f.format(this);
    }

    private Object writeReplace() {
        return new t((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
