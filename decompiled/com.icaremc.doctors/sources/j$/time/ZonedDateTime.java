package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC0206b;
import j$.time.chrono.InterfaceC0209e;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.m, ChronoZonedDateTime<h>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f2473a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f2474b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneId f2475c;

    public static ZonedDateTime now(ZoneId zoneId) {
        a aVar;
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            aVar = a.f2476b;
        } else {
            aVar = new a(zoneId);
        }
        Objects.requireNonNull(aVar, "clock");
        long currentTimeMillis = System.currentTimeMillis();
        Instant instant = Instant.f2456c;
        long j2 = 1000;
        Instant s2 = Instant.s(Math.floorDiv(currentTimeMillis, j2), ((int) Math.floorMod(currentTimeMillis, j2)) * 1000000);
        ZoneId zoneId2 = aVar.f2477a;
        Objects.requireNonNull(zoneId2, "zone");
        return s(s2.getEpochSecond(), s2.getNano(), zoneId2);
    }

    public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zoneId) {
        return A(localDateTime, zoneId, null);
    }

    public static ZonedDateTime of(int i2, int i3, int i4, int i5, int i6, int i7, int i8, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.f2459c;
        return A(new LocalDateTime(h.b0(i2, i3, i4), l.P(i5, i6, i7, i8)), zoneId, null);
    }

    public static ZonedDateTime A(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f s2 = zoneId.s();
        List f2 = s2.f(localDateTime);
        if (f2.size() == 1) {
            zoneOffset = (ZoneOffset) f2.get(0);
        } else if (f2.size() != 0) {
            if (zoneOffset == null || !f2.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) f2.get(0);
                Objects.requireNonNull(zoneOffset, "offset");
            }
        } else {
            Object e2 = s2.e(localDateTime);
            j$.time.zone.b bVar = e2 instanceof j$.time.zone.b ? (j$.time.zone.b) e2 : null;
            localDateTime = localDateTime.X(e.A(bVar.f2698d.f2471b - bVar.f2697c.f2471b, 0).f2538a);
            zoneOffset = bVar.f2698d;
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime s(long j2, int i2, ZoneId zoneId) {
        ZoneOffset d2 = zoneId.s().d(Instant.ofEpochSecond(j2, i2));
        return new ZonedDateTime(LocalDateTime.P(j2, i2, d2), zoneId, d2);
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f2473a = localDateTime;
        this.f2474b = zoneOffset;
        this.f2475c = zoneId;
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
                return ((j$.time.temporal.a) qVar).f2650b;
            }
            return this.f2473a.l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i2 = z.f2691a[((j$.time.temporal.a) qVar).ordinal()];
            if (i2 == 1) {
                throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i2 == 2) {
                return this.f2474b.f2471b;
            }
            return this.f2473a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i2 = z.f2691a[((j$.time.temporal.a) qVar).ordinal()];
            if (i2 == 1) {
                return W();
            }
            if (i2 == 2) {
                return this.f2474b.f2471b;
            }
            return this.f2473a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset o() {
        return this.f2474b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId J() {
        return this.f2475c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime D(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f2475c.equals(zoneId) ? this : A(this.f2473a, zoneId, this.f2474b);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC0209e x() {
        return this.f2473a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC0206b n() {
        return this.f2473a.f2461a;
    }

    public int getYear() {
        return this.f2473a.f2461a.f2616a;
    }

    public int getMonthValue() {
        return this.f2473a.f2461a.f2617b;
    }

    public int getDayOfMonth() {
        return this.f2473a.f2461a.f2618c;
    }

    public DayOfWeek getDayOfWeek() {
        return this.f2473a.f2461a.P();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final l j() {
        return this.f2473a.f2462b;
    }

    public int getHour() {
        return this.f2473a.f2462b.f2627a;
    }

    public int getMinute() {
        return this.f2473a.f2462b.f2628b;
    }

    public int getSecond() {
        return this.f2473a.f2462b.f2629c;
    }

    public int getNano() {
        return this.f2473a.f2462b.f2630d;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime m(h hVar) {
        return A(LocalDateTime.I(hVar, this.f2473a.f2462b), this.f2475c, this.f2474b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i2 = z.f2691a[aVar.ordinal()];
            if (i2 == 1) {
                return s(j2, getNano(), this.f2475c);
            }
            if (i2 != 2) {
                return A(this.f2473a.c(j2, qVar), this.f2475c, this.f2474b);
            }
            ZoneOffset Y2 = ZoneOffset.Y(aVar.f2650b.a(j2, aVar));
            return (Y2.equals(this.f2474b) || !this.f2475c.s().f(this.f2473a).contains(Y2)) ? this : new ZonedDateTime(this.f2473a, this.f2475c, Y2);
        }
        return (ZonedDateTime) qVar.V(this, j2);
    }

    @Override // j$.time.temporal.m
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime d(long j2, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
            if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0 && bVar != j$.time.temporal.b.FOREVER) {
                return A(this.f2473a.d(j2, sVar), this.f2475c, this.f2474b);
            }
            LocalDateTime d2 = this.f2473a.d(j2, sVar);
            ZoneOffset zoneOffset = this.f2474b;
            ZoneId zoneId = this.f2475c;
            Objects.requireNonNull(d2, "localDateTime");
            Objects.requireNonNull(zoneOffset, "offset");
            Objects.requireNonNull(zoneId, "zone");
            if (zoneId.s().f(d2).contains(zoneOffset)) {
                return new ZonedDateTime(d2, zoneId, zoneOffset);
            }
            return s(d2.w(zoneOffset), d2.f2462b.f2630d, zoneId);
        }
        return (ZonedDateTime) sVar.s(this, j2);
    }

    public ZonedDateTime plusDays(long j2) {
        return A(this.f2473a.plusDays(j2), this.f2475c, this.f2474b);
    }

    @Override // j$.time.temporal.m
    public final ChronoZonedDateTime a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2673f) {
            return this.f2473a.f2461a;
        }
        return super.b(iVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.f2473a.equals(zonedDateTime.f2473a) && this.f2474b.equals(zonedDateTime.f2474b) && this.f2475c.equals(zonedDateTime.f2475c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f2473a.hashCode() ^ this.f2474b.f2471b) ^ Integer.rotateLeft(this.f2475c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f2473a.toString() + this.f2474b.f2472c;
        ZoneOffset zoneOffset = this.f2474b;
        ZoneId zoneId = this.f2475c;
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
