package j$.time.chrono;

import j$.time.ZoneId;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* renamed from: j$.time.chrono.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0389g implements InterfaceC0387e, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a, reason: collision with root package name */
    public final transient InterfaceC0384b f4591a;

    /* renamed from: b, reason: collision with root package name */
    public final transient j$.time.l f4592b;

    public static C0389g s(l lVar, j$.time.temporal.m mVar) {
        C0389g c0389g = (C0389g) mVar;
        if (lVar.equals(c0389g.f())) {
            return c0389g;
        }
        throw new ClassCastException("Chronology mismatch, required: " + lVar.q() + ", actual: " + c0389g.f().q());
    }

    public C0389g(InterfaceC0384b interfaceC0384b, j$.time.l lVar) {
        Objects.requireNonNull(lVar, "time");
        this.f4591a = interfaceC0384b;
        this.f4592b = lVar;
    }

    public final C0389g P(j$.time.temporal.m mVar, j$.time.l lVar) {
        InterfaceC0384b interfaceC0384b = this.f4591a;
        return (interfaceC0384b == mVar && this.f4592b == lVar) ? this : new C0389g(AbstractC0386d.s(interfaceC0384b.f(), mVar), lVar);
    }

    public final int hashCode() {
        return this.f4591a.hashCode() ^ this.f4592b.hashCode();
    }

    @Override // j$.time.chrono.InterfaceC0387e
    public final InterfaceC0384b n() {
        return this.f4591a;
    }

    public final String toString() {
        return this.f4591a.toString() + "T" + this.f4592b.toString();
    }

    @Override // j$.time.chrono.InterfaceC0387e
    public final j$.time.l j() {
        return this.f4592b;
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
            return (((j$.time.temporal.a) qVar).Y() ? this.f4592b : this.f4591a).l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f4592b.g(qVar) : this.f4591a.g(qVar);
        }
        return l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f4592b.i(qVar) : this.f4591a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return P(hVar, this.f4592b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final C0389g c(long j4, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) qVar).Y()) {
                return P(this.f4591a, this.f4592b.c(j4, qVar));
            }
            return P(this.f4591a.c(j4, qVar), this.f4592b);
        }
        return s(this.f4591a.f(), qVar.V(this, j4));
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final C0389g d(long j4, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return s(this.f4591a.f(), sVar.s(this, j4));
        }
        switch (AbstractC0388f.f4590a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return F(this.f4591a, 0L, 0L, 0L, j4);
            case 2:
                C0389g P = P(this.f4591a.d(j4 / 86400000000L, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f4592b);
                return P.F(P.f4591a, 0L, 0L, 0L, (j4 % 86400000000L) * 1000);
            case 3:
                C0389g P3 = P(this.f4591a.d(j4 / 86400000, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f4592b);
                return P3.F(P3.f4591a, 0L, 0L, 0L, (j4 % 86400000) * 1000000);
            case 4:
                return F(this.f4591a, 0L, 0L, j4, 0L);
            case 5:
                return F(this.f4591a, 0L, j4, 0L, 0L);
            case 6:
                return F(this.f4591a, j4, 0L, 0L, 0L);
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                C0389g P4 = P(this.f4591a.d(j4 / 256, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f4592b);
                return P4.F(P4.f4591a, (j4 % 256) * 12, 0L, 0L, 0L);
            default:
                return P(this.f4591a.d(j4, sVar), this.f4592b);
        }
    }

    public final C0389g F(InterfaceC0384b interfaceC0384b, long j4, long j5, long j6, long j7) {
        if ((j4 | j5 | j6 | j7) == 0) {
            return P(interfaceC0384b, this.f4592b);
        }
        long j8 = j4 / 24;
        long j9 = ((j4 % 24) * 3600000000000L) + ((j5 % 1440) * 60000000000L) + ((j6 % 86400) * 1000000000) + (j7 % 86400000000000L);
        long d02 = this.f4592b.d0();
        long j10 = j9 + d02;
        long floorDiv = Math.floorDiv(j10, 86400000000000L) + j8 + (j5 / 1440) + (j6 / 86400) + (j7 / 86400000000000L);
        long floorMod = Math.floorMod(j10, 86400000000000L);
        return P(interfaceC0384b.d(floorDiv, (j$.time.temporal.s) j$.time.temporal.b.DAYS), floorMod == d02 ? this.f4592b : j$.time.l.V(floorMod));
    }

    @Override // j$.time.chrono.InterfaceC0387e
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
        return (obj instanceof InterfaceC0387e) && compareTo((InterfaceC0387e) obj) == 0;
    }
}
