package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class OffsetDateTime implements j$.time.temporal.m, j$.time.temporal.n, Comparable<OffsetDateTime>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2463c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f2464a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f2465b;

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int compare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.f2465b.equals(offsetDateTime2.f2465b)) {
            compare = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            compare = Long.compare(this.f2464a.w(this.f2465b), offsetDateTime2.f2464a.w(offsetDateTime2.f2465b));
            if (compare == 0) {
                compare = this.f2464a.f2462b.f2630d - offsetDateTime2.f2464a.f2462b.f2630d;
            }
        }
        return compare == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : compare;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.f2459c;
        ZoneOffset zoneOffset = ZoneOffset.f2470g;
        localDateTime.getClass();
        new OffsetDateTime(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f2460d;
        ZoneOffset zoneOffset2 = ZoneOffset.f2469f;
        localDateTime2.getClass();
        new OffsetDateTime(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime s(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset d2 = zoneId.s().d(instant);
        return new OffsetDateTime(LocalDateTime.P(instant.getEpochSecond(), instant.getNano(), d2), d2);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "dateTime");
        this.f2464a = localDateTime;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f2465b = zoneOffset;
    }

    public final OffsetDateTime F(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f2464a == localDateTime && this.f2465b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.INSTANT_SECONDS && qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f2464a.l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f2650b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i2 = q.f2638a[((j$.time.temporal.a) qVar).ordinal()];
            if (i2 == 1) {
                throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i2 == 2) {
                return this.f2465b.f2471b;
            }
            return this.f2464a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i2 = q.f2638a[((j$.time.temporal.a) qVar).ordinal()];
            if (i2 == 1) {
                return this.f2464a.w(this.f2465b);
            }
            if (i2 == 2) {
                return this.f2465b.f2471b;
            }
            return this.f2464a.i(qVar);
        }
        return qVar.P(this);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f2464a;
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        LocalDateTime localDateTime = this.f2464a;
        return F(localDateTime.a0(hVar, localDateTime.f2462b), this.f2465b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i2 = q.f2638a[aVar.ordinal()];
            if (i2 == 1) {
                return s(Instant.ofEpochSecond(j2, this.f2464a.f2462b.f2630d), this.f2465b);
            }
            if (i2 == 2) {
                return F(this.f2464a, ZoneOffset.Y(aVar.f2650b.a(j2, aVar)));
            }
            return F(this.f2464a.c(j2, qVar), this.f2465b);
        }
        return (OffsetDateTime) qVar.V(this, j2);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime d(long j2, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return F(this.f2464a.d(j2, sVar), this.f2465b);
        }
        return (OffsetDateTime) sVar.s(this, j2);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2671d || iVar == j$.time.temporal.r.f2672e) {
            return this.f2465b;
        }
        if (iVar == j$.time.temporal.r.f2668a) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f2673f) {
            return this.f2464a.f2461a;
        }
        if (iVar == j$.time.temporal.r.f2674g) {
            return this.f2464a.f2462b;
        }
        if (iVar == j$.time.temporal.r.f2669b) {
            return j$.time.chrono.s.f2522c;
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f2464a.f2461a.K(), j$.time.temporal.a.EPOCH_DAY).c(this.f2464a.f2462b.d0(), j$.time.temporal.a.NANO_OF_DAY).c(this.f2465b.f2471b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.f2464a.equals(offsetDateTime.f2464a) && this.f2465b.equals(offsetDateTime.f2465b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2464a.hashCode() ^ this.f2465b.f2471b;
    }

    public final String toString() {
        return this.f2464a.toString() + this.f2465b.f2472c;
    }

    private Object writeReplace() {
        return new t((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
