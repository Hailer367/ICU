package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class r implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f4736c = 0;
    private static final long serialVersionUID = 7264499704384272492L;

    /* renamed from: a, reason: collision with root package name */
    public final l f4737a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f4738b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        r rVar = (r) obj;
        if (this.f4738b.equals(rVar.f4738b)) {
            return this.f4737a.compareTo(rVar.f4737a);
        }
        int compare = Long.compare(this.f4737a.d0() - (this.f4738b.f4569b * 1000000000), rVar.f4737a.d0() - (rVar.f4738b.f4569b * 1000000000));
        return compare == 0 ? this.f4737a.compareTo(rVar.f4737a) : compare;
    }

    static {
        l lVar = l.f4720e;
        ZoneOffset zoneOffset = ZoneOffset.f4568g;
        lVar.getClass();
        new r(lVar, zoneOffset);
        l lVar2 = l.f4721f;
        ZoneOffset zoneOffset2 = ZoneOffset.f4567f;
        lVar2.getClass();
        new r(lVar2, zoneOffset2);
    }

    public r(l lVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(lVar, "time");
        this.f4737a = lVar;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f4738b = zoneOffset;
    }

    public final r A(l lVar, ZoneOffset zoneOffset) {
        return (this.f4737a == lVar && this.f4738b.equals(zoneOffset)) ? this : new r(lVar, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).Y() || qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f4737a.l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f4747b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f4738b.f4569b;
            }
            return this.f4737a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (r) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
                return A(this.f4737a, ZoneOffset.Y(aVar.f4747b.a(j4, aVar)));
            }
            return A(this.f4737a.c(j4, qVar), this.f4738b);
        }
        return (r) qVar.V(this, j4);
    }

    @Override // j$.time.temporal.m
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final r d(long j4, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return A(this.f4737a.d(j4, sVar), this.f4738b);
        }
        return (r) sVar.s(this, j4);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j4, j$.time.temporal.s sVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j4, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f4768d || iVar == j$.time.temporal.r.f4769e) {
            return this.f4738b;
        }
        if (((iVar == j$.time.temporal.r.f4765a) || (iVar == j$.time.temporal.r.f4766b)) || iVar == j$.time.temporal.r.f4770f) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f4771g) {
            return this.f4737a;
        }
        if (iVar == j$.time.temporal.r.f4767c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f4737a.d0(), j$.time.temporal.a.NANO_OF_DAY).c(this.f4738b.f4569b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f4737a.equals(rVar.f4737a) && this.f4738b.equals(rVar.f4738b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4737a.hashCode() ^ this.f4738b.f4569b;
    }

    public final String toString() {
        return this.f4737a.toString() + this.f4738b.f4570c;
    }

    private Object writeReplace() {
        return new t((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
