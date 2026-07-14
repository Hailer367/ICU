package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class r implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2639c = 0;
    private static final long serialVersionUID = 7264499704384272492L;

    /* renamed from: a, reason: collision with root package name */
    public final l f2640a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f2641b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        r rVar = (r) obj;
        if (this.f2641b.equals(rVar.f2641b)) {
            return this.f2640a.compareTo(rVar.f2640a);
        }
        int compare = Long.compare(this.f2640a.d0() - (this.f2641b.f2471b * 1000000000), rVar.f2640a.d0() - (rVar.f2641b.f2471b * 1000000000));
        return compare == 0 ? this.f2640a.compareTo(rVar.f2640a) : compare;
    }

    static {
        l lVar = l.f2623e;
        ZoneOffset zoneOffset = ZoneOffset.f2470g;
        lVar.getClass();
        new r(lVar, zoneOffset);
        l lVar2 = l.f2624f;
        ZoneOffset zoneOffset2 = ZoneOffset.f2469f;
        lVar2.getClass();
        new r(lVar2, zoneOffset2);
    }

    public r(l lVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(lVar, "time");
        this.f2640a = lVar;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f2641b = zoneOffset;
    }

    public final r A(l lVar, ZoneOffset zoneOffset) {
        return (this.f2640a == lVar && this.f2641b.equals(zoneOffset)) ? this : new r(lVar, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).Y() || qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f2640a.l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f2650b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f2641b.f2471b;
            }
            return this.f2640a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (r) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
                return A(this.f2640a, ZoneOffset.Y(aVar.f2650b.a(j2, aVar)));
            }
            return A(this.f2640a.c(j2, qVar), this.f2641b);
        }
        return (r) qVar.V(this, j2);
    }

    @Override // j$.time.temporal.m
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final r d(long j2, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return A(this.f2640a.d(j2, sVar), this.f2641b);
        }
        return (r) sVar.s(this, j2);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j2, j$.time.temporal.s sVar) {
        return j2 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j2, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2671d || iVar == j$.time.temporal.r.f2672e) {
            return this.f2641b;
        }
        if (((iVar == j$.time.temporal.r.f2668a) || (iVar == j$.time.temporal.r.f2669b)) || iVar == j$.time.temporal.r.f2673f) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f2674g) {
            return this.f2640a;
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f2640a.d0(), j$.time.temporal.a.NANO_OF_DAY).c(this.f2641b.f2471b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f2640a.equals(rVar.f2640a) && this.f2641b.equals(rVar.f2641b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2640a.hashCode() ^ this.f2641b.f2471b;
    }

    public final String toString() {
        return this.f2640a.toString() + this.f2641b.f2472c;
    }

    private Object writeReplace() {
        return new t((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
