package j$.time.chrono;

import j$.time.temporal.TemporalAccessor;

/* loaded from: classes2.dex */
public interface m extends TemporalAccessor, j$.time.temporal.n {
    int getValue();

    @Override // j$.time.temporal.TemporalAccessor
    default boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.ERA : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return getValue();
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long i(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.ERAS;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(getValue(), j$.time.temporal.a.ERA);
    }
}
