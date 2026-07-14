package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class k implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* renamed from: a, reason: collision with root package name */
    public final transient C0211g f2502a;

    /* renamed from: b, reason: collision with root package name */
    public final transient ZoneOffset f2503b;

    /* renamed from: c, reason: collision with root package name */
    public final transient ZoneId f2504c;

    public static k A(ZoneId zoneId, ZoneOffset zoneOffset, C0211g c0211g) {
        Objects.requireNonNull(c0211g, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new k(zoneId, (ZoneOffset) zoneId, c0211g);
        }
        j$.time.zone.f s2 = zoneId.s();
        LocalDateTime A2 = LocalDateTime.A(c0211g);
        List f2 = s2.f(A2);
        if (f2.size() == 1) {
            zoneOffset = (ZoneOffset) f2.get(0);
        } else if (f2.size() != 0) {
            if (zoneOffset == null || !f2.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) f2.get(0);
            }
            c0211g = c0211g;
        } else {
            Object e2 = s2.e(A2);
            j$.time.zone.b bVar = e2 instanceof j$.time.zone.b ? (j$.time.zone.b) e2 : null;
            c0211g = c0211g.F(c0211g.f2493a, 0L, 0L, j$.time.e.A(bVar.f2698d.f2471b - bVar.f2697c.f2471b, 0).f2538a, 0L);
            zoneOffset = bVar.f2698d;
        }
        Objects.requireNonNull(zoneOffset, "offset");
        return new k(zoneId, zoneOffset, c0211g);
    }

    public static k F(l lVar, Instant instant, ZoneId zoneId) {
        ZoneOffset d2 = zoneId.s().d(instant);
        Objects.requireNonNull(d2, "offset");
        return new k(zoneId, d2, (C0211g) lVar.H(LocalDateTime.P(instant.getEpochSecond(), instant.getNano(), d2)));
    }

    public static k s(l lVar, j$.time.temporal.m mVar) {
        k kVar = (k) mVar;
        if (lVar.equals(kVar.f())) {
            return kVar;
        }
        throw new ClassCastException("Chronology mismatch, required: " + lVar.q() + ", actual: " + kVar.f().q());
    }

    public k(ZoneId zoneId, ZoneOffset zoneOffset, C0211g c0211g) {
        Objects.requireNonNull(c0211g, "dateTime");
        this.f2502a = c0211g;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f2503b = zoneOffset;
        Objects.requireNonNull(zoneId, "zone");
        this.f2504c = zoneId;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset o() {
        return this.f2503b;
    }

    public final int hashCode() {
        return (this.f2502a.hashCode() ^ this.f2503b.f2471b) ^ Integer.rotateLeft(this.f2504c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f2502a.toString() + this.f2503b.f2472c;
        ZoneOffset zoneOffset = this.f2503b;
        ZoneId zoneId = this.f2504c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC0209e x() {
        return this.f2502a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId J() {
        return this.f2504c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime D(ZoneId zoneId) {
        return A(zoneId, this.f2503b, this.f2502a);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.m
    public final ChronoZonedDateTime c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i2 = AbstractC0214j.f2501a[aVar.ordinal()];
            if (i2 == 1) {
                return d(j2 - W(), (j$.time.temporal.s) j$.time.temporal.b.SECONDS);
            }
            if (i2 == 2) {
                ZoneOffset Y2 = ZoneOffset.Y(aVar.f2650b.a(j2, aVar));
                return F(f(), Instant.ofEpochSecond(this.f2502a.w(Y2), r5.f2494b.f2630d), this.f2504c);
            }
            return A(this.f2504c, this.f2503b, this.f2502a.c(j2, qVar));
        }
        return s(f(), qVar.V(this, j2));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.m
    public final ChronoZonedDateTime d(long j2, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return m(this.f2502a.d(j2, sVar));
        }
        return s(f(), sVar.s(this, j2));
    }

    private Object writeReplace() {
        return new E((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime) obj) == 0;
    }
}
