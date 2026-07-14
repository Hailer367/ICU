package j$.time.chrono;

import j$.time.ZoneId;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* renamed from: j$.time.chrono.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0211g implements InterfaceC0209e, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a, reason: collision with root package name */
    public final transient InterfaceC0206b f2493a;

    /* renamed from: b, reason: collision with root package name */
    public final transient j$.time.l f2494b;

    public static C0211g s(l lVar, j$.time.temporal.m mVar) {
        C0211g c0211g = (C0211g) mVar;
        if (lVar.equals(c0211g.f())) {
            return c0211g;
        }
        throw new ClassCastException("Chronology mismatch, required: " + lVar.q() + ", actual: " + c0211g.f().q());
    }

    public C0211g(InterfaceC0206b interfaceC0206b, j$.time.l lVar) {
        Objects.requireNonNull(lVar, "time");
        this.f2493a = interfaceC0206b;
        this.f2494b = lVar;
    }

    public final C0211g P(j$.time.temporal.m mVar, j$.time.l lVar) {
        InterfaceC0206b interfaceC0206b = this.f2493a;
        return (interfaceC0206b == mVar && this.f2494b == lVar) ? this : new C0211g(AbstractC0208d.s(interfaceC0206b.f(), mVar), lVar);
    }

    public final int hashCode() {
        return this.f2493a.hashCode() ^ this.f2494b.hashCode();
    }

    @Override // j$.time.chrono.InterfaceC0209e
    public final InterfaceC0206b n() {
        return this.f2493a;
    }

    public final String toString() {
        return this.f2493a.toString() + "T" + this.f2494b.toString();
    }

    @Override // j$.time.chrono.InterfaceC0209e
    public final j$.time.l j() {
        return this.f2494b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.s(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.Y();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return (((j$.time.temporal.a) qVar).Y() ? this.f2494b : this.f2493a).l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f2494b.g(qVar) : this.f2493a.g(qVar);
        }
        return l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f2494b.i(qVar) : this.f2493a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return P(hVar, this.f2494b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final C0211g c(long j2, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) qVar).Y()) {
                return P(this.f2493a, this.f2494b.c(j2, qVar));
            }
            return P(this.f2493a.c(j2, qVar), this.f2494b);
        }
        return s(this.f2493a.f(), qVar.V(this, j2));
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final C0211g d(long j2, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return s(this.f2493a.f(), sVar.s(this, j2));
        }
        switch (AbstractC0210f.f2492a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return F(this.f2493a, 0L, 0L, 0L, j2);
            case 2:
                C0211g P2 = P(this.f2493a.d(j2 / 86400000000L, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f2494b);
                return P2.F(P2.f2493a, 0L, 0L, 0L, (j2 % 86400000000L) * 1000);
            case 3:
                C0211g P3 = P(this.f2493a.d(j2 / 86400000, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f2494b);
                return P3.F(P3.f2493a, 0L, 0L, 0L, (j2 % 86400000) * 1000000);
            case 4:
                return F(this.f2493a, 0L, 0L, j2, 0L);
            case 5:
                return F(this.f2493a, 0L, j2, 0L, 0L);
            case 6:
                return F(this.f2493a, j2, 0L, 0L, 0L);
            case 7:
                C0211g P4 = P(this.f2493a.d(j2 / 256, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f2494b);
                return P4.F(P4.f2493a, (j2 % 256) * 12, 0L, 0L, 0L);
            default:
                return P(this.f2493a.d(j2, sVar), this.f2494b);
        }
    }

    public final C0211g F(InterfaceC0206b interfaceC0206b, long j2, long j3, long j4, long j5) {
        if ((j2 | j3 | j4 | j5) == 0) {
            return P(interfaceC0206b, this.f2494b);
        }
        long j6 = j2 / 24;
        long j7 = ((j2 % 24) * 3600000000000L) + ((j3 % 1440) * 60000000000L) + ((j4 % 86400) * 1000000000) + (j5 % 86400000000000L);
        long d02 = this.f2494b.d0();
        long j8 = j7 + d02;
        long floorDiv = Math.floorDiv(j8, 86400000000000L) + j6 + (j3 / 1440) + (j4 / 86400) + (j5 / 86400000000000L);
        long floorMod = Math.floorMod(j8, 86400000000000L);
        return P(interfaceC0206b.d(floorDiv, (j$.time.temporal.s) j$.time.temporal.b.DAYS), floorMod == d02 ? this.f2494b : j$.time.l.V(floorMod));
    }

    @Override // j$.time.chrono.InterfaceC0209e
    public final ChronoZonedDateTime E(ZoneId zoneId) {
        return k.A(zoneId, null, this);
    }

    private Object writeReplace() {
        return new E((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterfaceC0209e) && compareTo((InterfaceC0209e) obj) == 0;
    }
}
