package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC0384b;
import j$.time.chrono.InterfaceC0387e;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.m, ChronoZonedDateTime<h>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f4571a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f4572b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneId f4573c;

    public static ZonedDateTime now(ZoneId zoneId) {
        a aVar;
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            aVar = a.f4574b;
        } else {
            aVar = new a(zoneId);
        }
        Objects.requireNonNull(aVar, "clock");
        long currentTimeMillis = System.currentTimeMillis();
        Instant instant = Instant.f4554c;
        long j4 = 1000;
        Instant s3 = Instant.s(Math.floorDiv(currentTimeMillis, j4), ((int) Math.floorMod(currentTimeMillis, j4)) * 1000000);
        ZoneId zoneId2 = aVar.f4575a;
        Objects.requireNonNull(s3, "instant");
        Objects.requireNonNull(zoneId2, "zone");
        return s(s3.f4555a, s3.f4556b, zoneId2);
    }

    public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zoneId) {
        return A(localDateTime, zoneId, null);
    }

    public static ZonedDateTime of(int i4, int i5, int i6, int i7, int i8, int i9, int i10, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.f4557c;
        return A(new LocalDateTime(h.b0(i4, i5, i6), l.P(i7, i8, i9, i10)), zoneId, null);
    }

    public static ZonedDateTime A(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f s3 = zoneId.s();
        List f4 = s3.f(localDateTime);
        if (f4.size() == 1) {
            zoneOffset = (ZoneOffset) f4.get(0);
        } else if (f4.size() != 0) {
            if (zoneOffset == null || !f4.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) f4.get(0);
                Objects.requireNonNull(zoneOffset, "offset");
            }
        } else {
            Object e4 = s3.e(localDateTime);
            j$.time.zone.b bVar = e4 instanceof j$.time.zone.b ? (j$.time.zone.b) e4 : null;
            localDateTime = localDateTime.X(e.A(bVar.f4795d.f4569b - bVar.f4794c.f4569b, 0).f4635a);
            zoneOffset = bVar.f4795d;
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime s(long j4, int i4, ZoneId zoneId) {
        ZoneOffset d4 = zoneId.s().d(Instant.A(j4, i4));
        return new ZonedDateTime(LocalDateTime.P(j4, i4, d4), zoneId, d4);
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f4571a = localDateTime;
        this.f4572b = zoneOffset;
        this.f4573c = zoneId;
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
            if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) qVar).f4747b;
            }
            return this.f4571a.l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i4 = z.f4788a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 1) {
                throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i4 == 2) {
                return this.f4572b.f4569b;
            }
            return this.f4571a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i4 = z.f4788a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 1) {
                return W();
            }
            if (i4 == 2) {
                return this.f4572b.f4569b;
            }
            return this.f4571a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset o() {
        return this.f4572b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId J() {
        return this.f4573c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime D(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f4573c.equals(zoneId) ? this : A(this.f4571a, zoneId, this.f4572b);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC0387e x() {
        return this.f4571a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC0384b n() {
        return this.f4571a.f4559a;
    }

    public int getYear() {
        return this.f4571a.f4559a.f4713a;
    }

    public int getMonthValue() {
        return this.f4571a.f4559a.f4714b;
    }

    public int getDayOfMonth() {
        return this.f4571a.f4559a.f4715c;
    }

    public DayOfWeek getDayOfWeek() {
        return this.f4571a.f4559a.P();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final l j() {
        return this.f4571a.f4560b;
    }

    public int getHour() {
        return this.f4571a.f4560b.f4724a;
    }

    public int getMinute() {
        return this.f4571a.f4560b.f4725b;
    }

    public int getSecond() {
        return this.f4571a.f4560b.f4726c;
    }

    public int getNano() {
        return this.f4571a.f4560b.f4727d;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime m(h hVar) {
        return A(LocalDateTime.I(hVar, this.f4571a.f4560b), this.f4573c, this.f4572b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i4 = z.f4788a[aVar.ordinal()];
            if (i4 == 1) {
                return s(j4, getNano(), this.f4573c);
            }
            if (i4 != 2) {
                return A(this.f4571a.c(j4, qVar), this.f4573c, this.f4572b);
            }
            ZoneOffset Y3 = ZoneOffset.Y(aVar.f4747b.a(j4, aVar));
            return (Y3.equals(this.f4572b) || !this.f4573c.s().f(this.f4571a).contains(Y3)) ? this : new ZonedDateTime(this.f4571a, this.f4573c, Y3);
        }
        return (ZonedDateTime) qVar.V(this, j4);
    }

    @Override // j$.time.temporal.m
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime d(long j4, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
            if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0 && bVar != j$.time.temporal.b.FOREVER) {
                return A(this.f4571a.d(j4, sVar), this.f4573c, this.f4572b);
            }
            LocalDateTime d4 = this.f4571a.d(j4, sVar);
            ZoneOffset zoneOffset = this.f4572b;
            ZoneId zoneId = this.f4573c;
            Objects.requireNonNull(d4, "localDateTime");
            Objects.requireNonNull(zoneOffset, "offset");
            Objects.requireNonNull(zoneId, "zone");
            if (zoneId.s().f(d4).contains(zoneOffset)) {
                return new ZonedDateTime(d4, zoneId, zoneOffset);
            }
            return s(d4.w(zoneOffset), d4.f4560b.f4727d, zoneId);
        }
        return (ZonedDateTime) sVar.s(this, j4);
    }

    public ZonedDateTime plusDays(long j4) {
        return A(this.f4571a.plusDays(j4), this.f4573c, this.f4572b);
    }

    @Override // j$.time.temporal.m
    public final ChronoZonedDateTime a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f4770f) {
            return this.f4571a.f4559a;
        }
        return super.b(iVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.f4571a.equals(zonedDateTime.f4571a) && this.f4572b.equals(zonedDateTime.f4572b) && this.f4573c.equals(zonedDateTime.f4573c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f4571a.hashCode() ^ this.f4572b.f4569b) ^ Integer.rotateLeft(this.f4573c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f4571a.toString() + this.f4572b.f4570c;
        ZoneOffset zoneOffset = this.f4572b;
        ZoneId zoneId = this.f4573c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new t((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
