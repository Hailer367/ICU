package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.util.Objects;

/* renamed from: j$.time.chrono.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0387e extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    ChronoZonedDateTime E(ZoneId zoneId);

    j$.time.l j();

    InterfaceC0384b n();

    default l f() {
        return n().f();
    }

    @Override // j$.time.temporal.m
    default InterfaceC0387e a(long j4, j$.time.temporal.s sVar) {
        return C0389g.s(f(), super.a(j4, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f4765a || iVar == j$.time.temporal.r.f4769e || iVar == j$.time.temporal.r.f4768d) {
            return null;
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

    @Override // j$.time.temporal.n
    default j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(n().K(), j$.time.temporal.a.EPOCH_DAY).c(j().d0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    default long w(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return ((n().K() * 86400) + j().e0()) - zoneOffset.f4569b;
    }

    @Override // java.lang.Comparable
    /* renamed from: O */
    default int compareTo(InterfaceC0387e interfaceC0387e) {
        int compareTo = n().compareTo(interfaceC0387e.n());
        return (compareTo == 0 && (compareTo = j().compareTo(interfaceC0387e.j())) == 0) ? ((AbstractC0383a) f()).q().compareTo(interfaceC0387e.f().q()) : compareTo;
    }
}
