package j$.time.chrono;

/* renamed from: j$.time.chrono.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0384b extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    InterfaceC0384b R(j$.time.temporal.p pVar);

    @Override // j$.time.temporal.m
    InterfaceC0384b c(long j4, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    InterfaceC0384b d(long j4, j$.time.temporal.s sVar);

    boolean equals(Object obj);

    l f();

    int hashCode();

    InterfaceC0384b m(j$.time.temporal.n nVar);

    String toString();

    default InterfaceC0387e L(j$.time.l lVar) {
        return new C0389g(this, lVar);
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
    default InterfaceC0384b a(long j4, j$.time.temporal.s sVar) {
        return AbstractC0386d.s(f(), super.a(j4, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f4765a || iVar == j$.time.temporal.r.f4769e || iVar == j$.time.temporal.r.f4768d || iVar == j$.time.temporal.r.f4771g) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f4766b) {
            return f();
        }
        if (iVar == j$.time.temporal.r.f4767c) {
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
    default int compareTo(InterfaceC0384b interfaceC0384b) {
        int compare = Long.compare(K(), interfaceC0384b.K());
        if (compare != 0) {
            return compare;
        }
        return ((AbstractC0383a) f()).q().compareTo(interfaceC0384b.f().q());
    }
}
