package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.util.Objects;

/* renamed from: j$.time.chrono.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0209e extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    ChronoZonedDateTime E(ZoneId zoneId);

    j$.time.l j();

    InterfaceC0206b n();

    default l f() {
        return n().f();
    }

    @Override // j$.time.temporal.m
    default InterfaceC0209e a(long j2, j$.time.temporal.s sVar) {
        return C0211g.s(f(), super.a(j2, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f2668a || iVar == j$.time.temporal.r.f2672e || iVar == j$.time.temporal.r.f2671d) {
            return null;
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

    @Override // j$.time.temporal.n
    default j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(n().K(), j$.time.temporal.a.EPOCH_DAY).c(j().d0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    default long w(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return ((n().K() * 86400) + j().e0()) - zoneOffset.f2471b;
    }

    @Override // java.lang.Comparable
    /* renamed from: O */
    default int compareTo(InterfaceC0209e interfaceC0209e) {
        int compareTo = n().compareTo(interfaceC0209e.n());
        return (compareTo == 0 && (compareTo = j().compareTo(interfaceC0209e.j())) == 0) ? ((AbstractC0205a) f()).q().compareTo(interfaceC0209e.f().q()) : compareTo;
    }
}
