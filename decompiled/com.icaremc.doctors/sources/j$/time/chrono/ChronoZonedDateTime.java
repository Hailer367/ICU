package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.InterfaceC0206b;

/* loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends InterfaceC0206b> extends j$.time.temporal.m, Comparable<ChronoZonedDateTime<?>> {
    ChronoZonedDateTime D(ZoneId zoneId);

    ZoneId J();

    @Override // j$.time.temporal.m
    ChronoZonedDateTime c(long j2, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    ChronoZonedDateTime d(long j2, j$.time.temporal.s sVar);

    ZoneOffset o();

    InterfaceC0209e x();

    @Override // j$.time.temporal.TemporalAccessor
    default j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.INSTANT_SECONDS && qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return x().l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f2650b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i2 = AbstractC0213i.f2500a[((j$.time.temporal.a) qVar).ordinal()];
            if (i2 == 1) {
                throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i2 != 2) {
                return x().g(qVar);
            }
            return o().f2471b;
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i2 = AbstractC0213i.f2500a[((j$.time.temporal.a) qVar).ordinal()];
            if (i2 == 1) {
                return W();
            }
            if (i2 != 2) {
                return x().i(qVar);
            }
            return o().f2471b;
        }
        return qVar.P(this);
    }

    default InterfaceC0206b n() {
        return x().n();
    }

    default j$.time.l j() {
        return x().j();
    }

    default l f() {
        return n().f();
    }

    @Override // j$.time.temporal.m
    default ChronoZonedDateTime m(j$.time.temporal.n nVar) {
        return k.s(f(), nVar.e(this));
    }

    @Override // j$.time.temporal.m
    default ChronoZonedDateTime a(long j2, j$.time.temporal.s sVar) {
        return k.s(f(), super.a(j2, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f2672e || iVar == j$.time.temporal.r.f2668a) {
            return J();
        }
        if (iVar == j$.time.temporal.r.f2671d) {
            return o();
        }
        if (iVar == j$.time.temporal.r.f2674g) {
            return j();
        }
        if (iVar == j$.time.temporal.r.f2669b) {
            return f();
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    default Instant toInstant() {
        return Instant.ofEpochSecond(W(), j().f2630d);
    }

    default long W() {
        return ((n().K() * 86400) + j().e0()) - o().f2471b;
    }

    @Override // java.lang.Comparable
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    default int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        int compare = Long.compare(W(), chronoZonedDateTime.W());
        return (compare == 0 && (compare = j().f2630d - chronoZonedDateTime.j().f2630d) == 0 && (compare = x().compareTo(chronoZonedDateTime.x())) == 0 && (compare = J().q().compareTo(chronoZonedDateTime.J().q())) == 0) ? ((AbstractC0205a) f()).q().compareTo(chronoZonedDateTime.f().q()) : compare;
    }

    default boolean isBefore(ChronoZonedDateTime<?> chronoZonedDateTime) {
        long W2 = W();
        long W3 = chronoZonedDateTime.W();
        if (W2 >= W3) {
            return W2 == W3 && j().f2630d < chronoZonedDateTime.j().f2630d;
        }
        return true;
    }
}
