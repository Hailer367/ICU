package j$.time.temporal;

import j$.time.format.w;
import j$.time.format.x;
import java.util.Map;

/* loaded from: classes2.dex */
public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a, reason: collision with root package name */
    public final transient String f2662a;

    /* renamed from: b, reason: collision with root package name */
    public final transient u f2663b;

    /* renamed from: c, reason: collision with root package name */
    public final transient long f2664c;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j2) {
        this.f2662a = str;
        this.f2663b = u.f((-365243219162L) + j2, 365241780471L + j2);
        this.f2664c = j2;
    }

    @Override // j$.time.temporal.q
    public final u I() {
        return this.f2663b;
    }

    @Override // j$.time.temporal.q
    public final m V(m mVar, long j2) {
        if (!this.f2663b.e(j2)) {
            throw new RuntimeException("Invalid value: " + this.f2662a + " " + j2);
        }
        return mVar.c(Math.subtractExact(j2, this.f2664c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u A(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.h(a.EPOCH_DAY)) {
            return this.f2663b;
        }
        throw new RuntimeException("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.q
    public final boolean s(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final long P(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.EPOCH_DAY) + this.f2664c;
    }

    @Override // j$.time.temporal.q
    public final TemporalAccessor F(Map map, w wVar, x xVar) {
        long longValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.l r2 = j$.time.chrono.l.r(wVar);
        x xVar2 = x.LENIENT;
        long j2 = this.f2664c;
        if (xVar == xVar2) {
            return r2.p(Math.subtractExact(longValue, j2));
        }
        this.f2663b.b(longValue, this);
        return r2.p(longValue - j2);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f2662a;
    }
}
