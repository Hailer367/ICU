package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC0206b;
import j$.time.chrono.InterfaceC0209e;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC0209e, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f2459c = I(h.f2614d, l.f2623e);

    /* renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f2460d = I(h.f2615e, l.f2624f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a, reason: collision with root package name */
    public final h f2461a;

    /* renamed from: b, reason: collision with root package name */
    public final l f2462b;

    public static LocalDateTime I(h hVar, l lVar) {
        Objects.requireNonNull(hVar, "date");
        Objects.requireNonNull(lVar, "time");
        return new LocalDateTime(hVar, lVar);
    }

    public static LocalDateTime P(long j2, int i2, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j3 = i2;
        j$.time.temporal.a.NANO_OF_SECOND.X(j3);
        return new LocalDateTime(h.c0(Math.floorDiv(j2 + zoneOffset.f2471b, 86400)), l.V((((int) Math.floorMod(r5, r7)) * 1000000000) + j3));
    }

    public static LocalDateTime A(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (!(temporalAccessor instanceof ZonedDateTime)) {
            if (temporalAccessor instanceof OffsetDateTime) {
                return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
            }
            try {
                return new LocalDateTime(h.F(temporalAccessor), l.F(temporalAccessor));
            } catch (c e2) {
                throw new RuntimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e2);
            }
        }
        return ((ZonedDateTime) temporalAccessor).f2473a;
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        String charSequence2;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        i iVar = new i(0);
        Objects.requireNonNull(charSequence, "text");
        try {
            return (LocalDateTime) dateTimeFormatter.a(charSequence).b(iVar);
        } catch (j$.time.format.q e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (charSequence.length() > 64) {
                charSequence2 = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                charSequence2 = charSequence.toString();
            }
            RuntimeException runtimeException = new RuntimeException("Text '" + charSequence2 + "' could not be parsed: " + e3.getMessage(), e3);
            charSequence.toString();
            throw runtimeException;
        }
    }

    public LocalDateTime(h hVar, l lVar) {
        this.f2461a = hVar;
        this.f2462b = lVar;
    }

    public final LocalDateTime a0(h hVar, l lVar) {
        return (this.f2461a == hVar && this.f2462b == lVar) ? this : new LocalDateTime(hVar, lVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.s(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.Y();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f2462b.l(qVar) : this.f2461a.l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f2462b.g(qVar) : this.f2461a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f2462b.i(qVar) : this.f2461a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.InterfaceC0209e
    public final InterfaceC0206b n() {
        return this.f2461a;
    }

    @Override // j$.time.chrono.InterfaceC0209e
    public final l j() {
        return this.f2462b;
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return a0(hVar, this.f2462b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) qVar).Y()) {
                return a0(this.f2461a, this.f2462b.c(j2, qVar));
            }
            return a0(this.f2461a.c(j2, qVar), this.f2462b);
        }
        return (LocalDateTime) qVar.V(this, j2);
    }

    @Override // j$.time.temporal.m
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime d(long j2, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) sVar.s(this, j2);
        }
        switch (j.f2620a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return Y(this.f2461a, 0L, 0L, 0L, j2);
            case 2:
                LocalDateTime plusDays = plusDays(j2 / 86400000000L);
                return plusDays.Y(plusDays.f2461a, 0L, 0L, 0L, (j2 % 86400000000L) * 1000);
            case 3:
                LocalDateTime plusDays2 = plusDays(j2 / 86400000);
                return plusDays2.Y(plusDays2.f2461a, 0L, 0L, 0L, (j2 % 86400000) * 1000000);
            case 4:
                return X(j2);
            case 5:
                return Y(this.f2461a, 0L, j2, 0L, 0L);
            case 6:
                return Y(this.f2461a, j2, 0L, 0L, 0L);
            case 7:
                LocalDateTime plusDays3 = plusDays(j2 / 256);
                return plusDays3.Y(plusDays3.f2461a, (j2 % 256) * 12, 0L, 0L, 0L);
            default:
                return a0(this.f2461a.d(j2, sVar), this.f2462b);
        }
    }

    public LocalDateTime plusWeeks(long j2) {
        return a0(this.f2461a.h0(j2), this.f2462b);
    }

    public LocalDateTime plusDays(long j2) {
        return a0(this.f2461a.f0(j2), this.f2462b);
    }

    public final LocalDateTime X(long j2) {
        return Y(this.f2461a, 0L, 0L, j2, 0L);
    }

    @Override // j$.time.temporal.m
    public final InterfaceC0209e a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    public final LocalDateTime Y(h hVar, long j2, long j3, long j4, long j5) {
        if ((j2 | j3 | j4 | j5) == 0) {
            return a0(hVar, this.f2462b);
        }
        long j6 = 1;
        long d02 = this.f2462b.d0();
        long j7 = ((((j2 % 24) * 3600000000000L) + ((j3 % 1440) * 60000000000L) + ((j4 % 86400) * 1000000000) + (j5 % 86400000000000L)) * j6) + d02;
        long floorDiv = Math.floorDiv(j7, 86400000000000L) + (((j2 / 24) + (j3 / 1440) + (j4 / 86400) + (j5 / 86400000000000L)) * j6);
        long floorMod = Math.floorMod(j7, 86400000000000L);
        return a0(hVar.f0(floorDiv), floorMod == d02 ? this.f2462b : l.V(floorMod));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2673f) {
            return this.f2461a;
        }
        return super.b(iVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.chrono.InterfaceC0209e
    public final ChronoZonedDateTime E(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // j$.time.chrono.InterfaceC0209e, java.lang.Comparable
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC0209e interfaceC0209e) {
        if (interfaceC0209e instanceof LocalDateTime) {
            return s((LocalDateTime) interfaceC0209e);
        }
        return super.compareTo(interfaceC0209e);
    }

    public final int s(LocalDateTime localDateTime) {
        int s2 = this.f2461a.s(localDateTime.f2461a);
        return s2 == 0 ? this.f2462b.compareTo(localDateTime.f2462b) : s2;
    }

    public final boolean F(InterfaceC0209e interfaceC0209e) {
        if (interfaceC0209e instanceof LocalDateTime) {
            return s((LocalDateTime) interfaceC0209e) < 0;
        }
        long K2 = this.f2461a.K();
        long K3 = interfaceC0209e.n().K();
        if (K2 >= K3) {
            return K2 == K3 && this.f2462b.d0() < interfaceC0209e.j().d0();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f2461a.equals(localDateTime.f2461a) && this.f2462b.equals(localDateTime.f2462b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2461a.hashCode() ^ this.f2462b.hashCode();
    }

    public final String toString() {
        return this.f2461a.toString() + "T" + this.f2462b.toString();
    }

    private Object writeReplace() {
        return new t((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
