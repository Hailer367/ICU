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
    public final transient C0389g f4600a;

    /* renamed from: b, reason: collision with root package name */
    public final transient ZoneOffset f4601b;

    /* renamed from: c, reason: collision with root package name */
    public final transient ZoneId f4602c;

    public static k A(ZoneId zoneId, ZoneOffset zoneOffset, C0389g c0389g) {
        Objects.requireNonNull(c0389g, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new k(zoneId, (ZoneOffset) zoneId, c0389g);
        }
        j$.time.zone.f s3 = zoneId.s();
        LocalDateTime A3 = LocalDateTime.A(c0389g);
        List f4 = s3.f(A3);
        if (f4.size() == 1) {
            zoneOffset = (ZoneOffset) f4.get(0);
        } else if (f4.size() != 0) {
            if (zoneOffset == null || !f4.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) f4.get(0);
            }
            c0389g = c0389g;
        } else {
            Object e4 = s3.e(A3);
            j$.time.zone.b bVar = e4 instanceof j$.time.zone.b ? (j$.time.zone.b) e4 : null;
            c0389g = c0389g.F(c0389g.f4591a, 0L, 0L, j$.time.e.A(bVar.f4795d.f4569b - bVar.f4794c.f4569b, 0).f4635a, 0L);
            zoneOffset = bVar.f4795d;
        }
        Objects.requireNonNull(zoneOffset, "offset");
        return new k(zoneId, zoneOffset, c0389g);
    }

    public static k F(l lVar, Instant instant, ZoneId zoneId) {
        ZoneOffset d4 = zoneId.s().d(instant);
        Objects.requireNonNull(d4, "offset");
        return new k(zoneId, d4, (C0389g) lVar.H(LocalDateTime.P(instant.f4555a, instant.f4556b, d4)));
    }

    public static k s(l lVar, j$.time.temporal.m mVar) {
        k kVar = (k) mVar;
        if (lVar.equals(kVar.f())) {
            return kVar;
        }
        throw new ClassCastException("Chronology mismatch, required: " + lVar.q() + ", actual: " + kVar.f().q());
    }

    public k(ZoneId zoneId, ZoneOffset zoneOffset, C0389g c0389g) {
        Objects.requireNonNull(c0389g, "dateTime");
        this.f4600a = c0389g;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f4601b = zoneOffset;
        Objects.requireNonNull(zoneId, "zone");
        this.f4602c = zoneId;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset o() {
        return this.f4601b;
    }

    public final int hashCode() {
        return (this.f4600a.hashCode() ^ this.f4601b.f4569b) ^ Integer.rotateLeft(this.f4602c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f4600a.toString() + this.f4601b.f4570c;
        ZoneOffset zoneOffset = this.f4601b;
        ZoneId zoneId = this.f4602c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC0387e x() {
        return this.f4600a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId J() {
        return this.f4602c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime D(ZoneId zoneId) {
        return A(zoneId, this.f4601b, this.f4600a);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.m
    public final ChronoZonedDateTime c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i4 = AbstractC0392j.f4599a[aVar.ordinal()];
            if (i4 == 1) {
                return d(j4 - W(), (j$.time.temporal.s) j$.time.temporal.b.SECONDS);
            }
            if (i4 == 2) {
                ZoneOffset Y3 = ZoneOffset.Y(aVar.f4747b.a(j4, aVar));
                return F(f(), Instant.A(this.f4600a.w(Y3), r5.f4592b.f4727d), this.f4602c);
            }
            return A(this.f4602c, this.f4601b, this.f4600a.c(j4, qVar));
        }
        return s(f(), qVar.V(this, j4));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.m
    public final ChronoZonedDateTime d(long j4, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return m(this.f4600a.d(j4, sVar));
        }
        return s(f(), sVar.s(this, j4));
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
