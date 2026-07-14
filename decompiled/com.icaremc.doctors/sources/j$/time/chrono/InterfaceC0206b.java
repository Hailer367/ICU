package j$.time.chrono;

/* renamed from: j$.time.chrono.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0206b extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    InterfaceC0206b R(j$.time.temporal.p pVar);

    @Override // j$.time.temporal.m
    InterfaceC0206b c(long j2, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    InterfaceC0206b d(long j2, j$.time.temporal.s sVar);

    boolean equals(Object obj);

    l f();

    int hashCode();

    InterfaceC0206b m(j$.time.temporal.n nVar);

    String toString();

    default InterfaceC0209e L(j$.time.l lVar) {
        return new C0211g(this, lVar);
    }

    default m N() {
        return f().B(g(j$.time.temporal.a.ERA));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.m
    default InterfaceC0206b a(long j2, j$.time.temporal.s sVar) {
        return AbstractC0208d.s(f(), super.a(j2, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f2668a || iVar == j$.time.temporal.r.f2672e || iVar == j$.time.temporal.r.f2671d || iVar == j$.time.temporal.r.f2674g) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f2669b) {
            return f();
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.DAYS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(K(), j$.time.temporal.a.EPOCH_DAY);
    }

    default long K() {
        return i(j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // java.lang.Comparable
    /* renamed from: U */
    default int compareTo(InterfaceC0206b interfaceC0206b) {
        int compare = Long.compare(K(), interfaceC0206b.K());
        if (compare != 0) {
            return compare;
        }
        return ((AbstractC0205a) f()).q().compareTo(interfaceC0206b.f().q());
    }
}
