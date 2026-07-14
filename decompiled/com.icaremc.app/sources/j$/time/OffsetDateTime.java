package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class OffsetDateTime implements j$.time.temporal.m, j$.time.temporal.n, Comparable<OffsetDateTime>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f4561c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f4562a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f4563b;

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int compare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.f4563b.equals(offsetDateTime2.f4563b)) {
            compare = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            compare = Long.compare(this.f4562a.w(this.f4563b), offsetDateTime2.f4562a.w(offsetDateTime2.f4563b));
            if (compare == 0) {
                compare = this.f4562a.f4560b.f4727d - offsetDateTime2.f4562a.f4560b.f4727d;
            }
        }
        return compare == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : compare;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.f4557c;
        ZoneOffset zoneOffset = ZoneOffset.f4568g;
        localDateTime.getClass();
        new OffsetDateTime(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f4558d;
        ZoneOffset zoneOffset2 = ZoneOffset.f4567f;
        localDateTime2.getClass();
        new OffsetDateTime(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime s(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset d4 = zoneId.s().d(instant);
        return new OffsetDateTime(LocalDateTime.P(instant.f4555a, instant.f4556b, d4), d4);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "dateTime");
        this.f4562a = localDateTime;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f4563b = zoneOffset;
    }

    public final OffsetDateTime F(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f4562a == localDateTime && this.f4563b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
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
                return this.f4562a.l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f4747b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i4 = q.f4735a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 1) {
                throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i4 == 2) {
                return this.f4563b.f4569b;
            }
            return this.f4562a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i4 = q.f4735a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 1) {
                return this.f4562a.w(this.f4563b);
            }
            if (i4 == 2) {
                return this.f4563b.f4569b;
            }
            return this.f4562a.i(qVar);
        }
        return qVar.P(this);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f4562a;
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        LocalDateTime localDateTime = this.f4562a;
        return F(localDateTime.a0(hVar, localDateTime.f4560b), this.f4563b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i4 = q.f4735a[aVar.ordinal()];
            if (i4 == 1) {
                return s(Instant.A(j4, this.f4562a.f4560b.f4727d), this.f4563b);
            }
            if (i4 == 2) {
                return F(this.f4562a, ZoneOffset.Y(aVar.f4747b.a(j4, aVar)));
            }
            return F(this.f4562a.c(j4, qVar), this.f4563b);
        }
        return (OffsetDateTime) qVar.V(this, j4);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime d(long j4, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return F(this.f4562a.d(j4, sVar), this.f4563b);
        }
        return (OffsetDateTime) sVar.s(this, j4);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f4768d || iVar == j$.time.temporal.r.f4769e) {
            return this.f4563b;
        }
        if (iVar == j$.time.temporal.r.f4765a) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f4770f) {
            return this.f4562a.f4559a;
        }
        if (iVar == j$.time.temporal.r.f4771g) {
            return this.f4562a.f4560b;
        }
        if (iVar == j$.time.temporal.r.f4766b) {
            return j$.time.chrono.s.f4619c;
        }
        if (iVar == j$.time.temporal.r.f4767c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f4562a.f4559a.K(), j$.time.temporal.a.EPOCH_DAY).c(this.f4562a.f4560b.d0(), j$.time.temporal.a.NANO_OF_DAY).c(this.f4563b.f4569b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.f4562a.equals(offsetDateTime.f4562a) && this.f4563b.equals(offsetDateTime.f4563b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4562a.hashCode() ^ this.f4563b.f4569b;
    }

    public final String toString() {
        return this.f4562a.toString() + this.f4563b.f4570c;
    }

    private Object writeReplace() {
        return new t((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
