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
    public final transient String f4759a;

    /* renamed from: b, reason: collision with root package name */
    public final transient u f4760b;

    /* renamed from: c, reason: collision with root package name */
    public final transient long f4761c;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j4) {
        this.f4759a = str;
        this.f4760b = u.f((-365243219162L) + j4, 365241780471L + j4);
        this.f4761c = j4;
    }

    @Override // j$.time.temporal.q
    public final u I() {
        return this.f4760b;
    }

    @Override // j$.time.temporal.q
    public final m V(m mVar, long j4) {
        if (!this.f4760b.e(j4)) {
            throw new RuntimeException("Invalid value: " + this.f4759a + " " + j4);
        }
        return mVar.c(Math.subtractExact(j4, this.f4761c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u A(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.h(a.EPOCH_DAY)) {
            return this.f4760b;
        }
        throw new RuntimeException("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.q
    public final boolean s(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final long P(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.EPOCH_DAY) + this.f4761c;
    }

    @Override // j$.time.temporal.q
    public final TemporalAccessor F(Map map, w wVar, x xVar) {
        long longValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.l r3 = j$.time.chrono.l.r(wVar);
        x xVar2 = x.LENIENT;
        long j4 = this.f4761c;
        if (xVar == xVar2) {
            return r3.p(Math.subtractExact(longValue, j4));
        }
        this.f4760b.b(longValue, this);
        return r3.p(longValue - j4);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4759a;
    }
}
