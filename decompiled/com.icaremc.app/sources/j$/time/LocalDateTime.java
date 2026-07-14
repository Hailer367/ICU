package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC0384b;
import j$.time.chrono.InterfaceC0387e;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC0387e, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f4557c = I(h.f4711d, l.f4720e);

    /* renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f4558d = I(h.f4712e, l.f4721f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a, reason: collision with root package name */
    public final h f4559a;

    /* renamed from: b, reason: collision with root package name */
    public final l f4560b;

    public static LocalDateTime I(h hVar, l lVar) {
        Objects.requireNonNull(hVar, "date");
        Objects.requireNonNull(lVar, "time");
        return new LocalDateTime(hVar, lVar);
    }

    public static LocalDateTime P(long j4, int i4, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j5 = i4;
        j$.time.temporal.a.NANO_OF_SECOND.X(j5);
        return new LocalDateTime(h.c0(Math.floorDiv(j4 + zoneOffset.f4569b, 86400)), l.V((((int) Math.floorMod(r5, r7)) * 1000000000) + j5));
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
            } catch (c e4) {
                throw new RuntimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e4);
            }
        }
        return ((ZonedDateTime) temporalAccessor).f4571a;
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        String charSequence2;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        i iVar = new i(0);
        Objects.requireNonNull(charSequence, "text");
        try {
            return (LocalDateTime) dateTimeFormatter.a(charSequence).b(iVar);
        } catch (j$.time.format.q e4) {
            throw e4;
        } catch (RuntimeException e5) {
            if (charSequence.length() > 64) {
                charSequence2 = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                charSequence2 = charSequence.toString();
            }
            RuntimeException runtimeException = new RuntimeException("Text '" + charSequence2 + "' could not be parsed: " + e5.getMessage(), e5);
            charSequence.toString();
            throw runtimeException;
        }
    }

    public LocalDateTime(h hVar, l lVar) {
        this.f4559a = hVar;
        this.f4560b = lVar;
    }

    public final LocalDateTime a0(h hVar, l lVar) {
        return (this.f4559a == hVar && this.f4560b == lVar) ? this : new LocalDateTime(hVar, lVar);
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
            return ((j$.time.temporal.a) qVar).Y() ? this.f4560b.l(qVar) : this.f4559a.l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f4560b.g(qVar) : this.f4559a.g(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f4560b.i(qVar) : this.f4559a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.chrono.InterfaceC0387e
    public final InterfaceC0384b n() {
        return this.f4559a;
    }

    @Override // j$.time.chrono.InterfaceC0387e
    public final l j() {
        return this.f4560b;
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return a0(hVar, this.f4560b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) qVar).Y()) {
                return a0(this.f4559a, this.f4560b.c(j4, qVar));
            }
            return a0(this.f4559a.c(j4, qVar), this.f4560b);
        }
        return (LocalDateTime) qVar.V(this, j4);
    }

    @Override // j$.time.temporal.m
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime d(long j4, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) sVar.s(this, j4);
        }
        switch (j.f4717a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return Y(this.f4559a, 0L, 0L, 0L, j4);
            case 2:
                LocalDateTime plusDays = plusDays(j4 / 86400000000L);
                return plusDays.Y(plusDays.f4559a, 0L, 0L, 0L, (j4 % 86400000000L) * 1000);
            case 3:
                LocalDateTime plusDays2 = plusDays(j4 / 86400000);
                return plusDays2.Y(plusDays2.f4559a, 0L, 0L, 0L, (j4 % 86400000) * 1000000);
            case 4:
                return X(j4);
            case 5:
                return Y(this.f4559a, 0L, j4, 0L, 0L);
            case 6:
                return Y(this.f4559a, j4, 0L, 0L, 0L);
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                LocalDateTime plusDays3 = plusDays(j4 / 256);
                return plusDays3.Y(plusDays3.f4559a, (j4 % 256) * 12, 0L, 0L, 0L);
            default:
                return a0(this.f4559a.d(j4, sVar), this.f4560b);
        }
    }

    public LocalDateTime plusWeeks(long j4) {
        return a0(this.f4559a.h0(j4), this.f4560b);
    }

    public LocalDateTime plusDays(long j4) {
        return a0(this.f4559a.f0(j4), this.f4560b);
    }

    public final LocalDateTime X(long j4) {
        return Y(this.f4559a, 0L, 0L, j4, 0L);
    }

    @Override // j$.time.temporal.m
    public final InterfaceC0387e a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    public final LocalDateTime Y(h hVar, long j4, long j5, long j6, long j7) {
        if ((j4 | j5 | j6 | j7) == 0) {
            return a0(hVar, this.f4560b);
        }
        long j8 = 1;
        long d02 = this.f4560b.d0();
        long j9 = ((((j4 % 24) * 3600000000000L) + ((j5 % 1440) * 60000000000L) + ((j6 % 86400) * 1000000000) + (j7 % 86400000000000L)) * j8) + d02;
        long floorDiv = Math.floorDiv(j9, 86400000000000L) + (((j4 / 24) + (j5 / 1440) + (j6 / 86400) + (j7 / 86400000000000L)) * j8);
        long floorMod = Math.floorMod(j9, 86400000000000L);
        return a0(hVar.f0(floorDiv), floorMod == d02 ? this.f4560b : l.V(floorMod));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f4770f) {
            return this.f4559a;
        }
        return super.b(iVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.chrono.InterfaceC0387e
    public final ChronoZonedDateTime E(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // j$.time.chrono.InterfaceC0387e, java.lang.Comparable
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC0387e interfaceC0387e) {
        if (interfaceC0387e instanceof LocalDateTime) {
            return s((LocalDateTime) interfaceC0387e);
        }
        return super.compareTo(interfaceC0387e);
    }

    public final int s(LocalDateTime localDateTime) {
        int s3 = this.f4559a.s(localDateTime.f4559a);
        return s3 == 0 ? this.f4560b.compareTo(localDateTime.f4560b) : s3;
    }

    public final boolean F(InterfaceC0387e interfaceC0387e) {
        if (interfaceC0387e instanceof LocalDateTime) {
            return s((LocalDateTime) interfaceC0387e) < 0;
        }
        long K3 = this.f4559a.K();
        long K4 = interfaceC0387e.n().K();
        if (K3 >= K4) {
            return K3 == K4 && this.f4560b.d0() < interfaceC0387e.j().d0();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f4559a.equals(localDateTime.f4559a) && this.f4560b.equals(localDateTime.f4560b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4559a.hashCode() ^ this.f4560b.hashCode();
    }

    public final String toString() {
        return this.f4559a.toString() + "T" + this.f4560b.toString();
    }

    private Object writeReplace() {
        return new t((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
