package j$.time.temporal;

import java.util.Objects;

/* loaded from: classes2.dex */
public interface TemporalAccessor {
    boolean h(q qVar);

    long i(q qVar);

    default u l(q qVar) {
        if (qVar instanceof a) {
            if (!h(qVar)) {
                throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
            }
            return ((a) qVar).f4747b;
        }
        Objects.requireNonNull(qVar, "field");
        return qVar.A(this);
    }

    default int g(q qVar) {
        u l3 = l(qVar);
        if (!l3.d()) {
            throw new RuntimeException("Invalid field " + qVar + " for get() method, use getLong() instead");
        }
        long i4 = i(qVar);
        if (l3.e(i4)) {
            return (int) i4;
        }
        throw new RuntimeException("Invalid value for " + qVar + " (valid values " + l3 + "): " + i4);
    }

    default Object b(j$.time.i iVar) {
        if (iVar == r.f4765a || iVar == r.f4766b || iVar == r.f4767c) {
            return null;
        }
        return iVar.k(this);
    }
}
