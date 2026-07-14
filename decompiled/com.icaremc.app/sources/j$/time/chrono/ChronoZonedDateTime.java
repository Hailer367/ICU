package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.InterfaceC0384b;

/* loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends InterfaceC0384b> extends j$.time.temporal.m, Comparable<ChronoZonedDateTime<?>> {
    ChronoZonedDateTime D(ZoneId zoneId);

    ZoneId J();

    @Override // j$.time.temporal.m
    ChronoZonedDateTime c(long j4, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    ChronoZonedDateTime d(long j4, j$.time.temporal.s sVar);

    ZoneOffset o();

    InterfaceC0387e x();

    @Override // j$.time.temporal.TemporalAccessor
    default j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.INSTANT_SECONDS && qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return x().l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f4747b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i4 = AbstractC0391i.f4598a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 1) {
                throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i4 != 2) {
                return x().g(qVar);
            }
            return o().f4569b;
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i4 = AbstractC0391i.f4598a[((j$.time.temporal.a) qVar).ordinal()];
            if (i4 == 1) {
                return W();
            }
            if (i4 != 2) {
                return x().i(qVar);
            }
            return o().f4569b;
        }
        return qVar.P(this);
    }

    default InterfaceC0384b n() {
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
    default ChronoZonedDateTime a(long j4, j$.time.temporal.s sVar) {
        return k.s(f(), super.a(j4, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f4769e || iVar == j$.time.temporal.r.f4765a) {
            return J();
        }
        if (iVar == j$.time.temporal.r.f4768d) {
            return o();
        }
        if (iVar == j$.time.temporal.r.f4771g) {
            return j();
        }
        if (iVar == j$.time.temporal.r.f4766b) {
            return f();
        }
        if (iVar == j$.time.temporal.r.f4767c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    default Instant toInstant() {
        return Instant.A(W(), j().f4727d);
    }

    default long W() {
        return ((n().K() * 86400) + j().e0()) - o().f4569b;
    }

    @Override // java.lang.Comparable
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    default int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        int compare = Long.compare(W(), chronoZonedDateTime.W());
        return (compare == 0 && (compare = j().f4727d - chronoZonedDateTime.j().f4727d) == 0 && (compare = x().compareTo(chronoZonedDateTime.x())) == 0 && (compare = J().q().compareTo(chronoZonedDateTime.J().q())) == 0) ? ((AbstractC0383a) f()).q().compareTo(chronoZonedDateTime.f().q()) : compare;
    }

    default boolean isBefore(ChronoZonedDateTime<?> chronoZonedDateTime) {
        long W3 = W();
        long W4 = chronoZonedDateTime.W();
        if (W3 >= W4) {
            return W3 == W4 && j().f4727d < chronoZonedDateTime.j().f4727d;
        }
        return true;
    }
}
