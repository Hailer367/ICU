package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class s extends AbstractC0383a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final s f4619c = new s();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // j$.time.chrono.l
    public final m B(int i4) {
        if (i4 == 0) {
            return t.BCE;
        }
        if (i4 == 1) {
            return t.CE;
        }
        throw new RuntimeException("Invalid era: " + i4);
    }

    @Override // j$.time.chrono.l
    public final String q() {
        return "ISO";
    }

    @Override // j$.time.chrono.l
    public final String u() {
        return "iso8601";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b Q(int i4, int i5, int i6) {
        return j$.time.h.b0(i4, i5, i6);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b v(int i4, int i5) {
        return j$.time.h.d0(i4, i5);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b p(long j4) {
        return j$.time.h.c0(j4);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b G(TemporalAccessor temporalAccessor) {
        return j$.time.h.F(temporalAccessor);
    }

    private s() {
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0387e H(LocalDateTime localDateTime) {
        return LocalDateTime.A(localDateTime);
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime T(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.s(instant.f4555a, instant.f4556b, zoneId);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0384b M() {
        return j$.time.h.F(j$.time.h.a0(j$.time.b.b()));
    }

    public static boolean X(long j4) {
        if ((3 & j4) == 0) {
            return j4 % 100 != 0 || j4 % 400 == 0;
        }
        return false;
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i4) {
        if (mVar instanceof t) {
            return mVar == t.CE ? i4 : 1 - i4;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // j$.time.chrono.l
    public final List z() {
        return j$.time.b.a(t.values());
    }

    @Override // j$.time.chrono.AbstractC0383a, j$.time.chrono.l
    public final InterfaceC0384b S(Map map, j$.time.format.x xVar) {
        return (j$.time.h) super.S(map, xVar);
    }

    @Override // j$.time.chrono.AbstractC0383a
    public final void I(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l3 = (Long) map.remove(aVar);
        if (l3 != null) {
            if (xVar != j$.time.format.x.LENIENT) {
                aVar.X(l3.longValue());
            }
            AbstractC0383a.s(map, j$.time.temporal.a.MONTH_OF_YEAR, ((int) Math.floorMod(l3.longValue(), r4)) + 1);
            AbstractC0383a.s(map, j$.time.temporal.a.YEAR, Math.floorDiv(l3.longValue(), 12));
        }
    }

    @Override // j$.time.chrono.AbstractC0383a
    public final InterfaceC0384b V(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l3 = (Long) map.remove(aVar);
        if (l3 != null) {
            if (xVar != j$.time.format.x.LENIENT) {
                aVar.X(l3.longValue());
            }
            Long l4 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (l4 != null) {
                if (l4.longValue() == 1) {
                    AbstractC0383a.s(map, j$.time.temporal.a.YEAR, l3.longValue());
                    return null;
                }
                if (l4.longValue() == 0) {
                    AbstractC0383a.s(map, j$.time.temporal.a.YEAR, Math.subtractExact(1L, l3.longValue()));
                    return null;
                }
                throw new RuntimeException("Invalid value for era: " + l4);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            Long l5 = (Long) map.get(aVar2);
            if (xVar != j$.time.format.x.STRICT) {
                AbstractC0383a.s(map, aVar2, (l5 == null || l5.longValue() > 0) ? l3.longValue() : Math.subtractExact(1L, l3.longValue()));
                return null;
            }
            if (l5 != null) {
                long longValue = l5.longValue();
                long longValue2 = l3.longValue();
                if (longValue <= 0) {
                    longValue2 = Math.subtractExact(1L, longValue2);
                }
                AbstractC0383a.s(map, aVar2, longValue2);
                return null;
            }
            map.put(aVar, l3);
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        aVar3.X(((Long) map.get(aVar3)).longValue());
        return null;
    }

    @Override // j$.time.chrono.AbstractC0383a
    public final InterfaceC0384b P(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int a4 = aVar.f4747b.a(((Long) map.remove(aVar)).longValue(), aVar);
        boolean z = true;
        if (xVar == j$.time.format.x.LENIENT) {
            return j$.time.h.b0(a4, 1, 1).g0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L)).f0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L));
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int a5 = aVar2.f4747b.a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int a6 = aVar3.f4747b.a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (xVar == j$.time.format.x.SMART) {
            if (a5 == 4 || a5 == 6 || a5 == 9 || a5 == 11) {
                a6 = Math.min(a6, 30);
            } else if (a5 == 2) {
                j$.time.n nVar = j$.time.n.FEBRUARY;
                long j4 = a4;
                int i4 = j$.time.v.f4778b;
                if ((3 & j4) != 0 || (j4 % 100 == 0 && j4 % 400 != 0)) {
                    z = false;
                }
                a6 = Math.min(a6, nVar.A(z));
            }
        }
        return j$.time.h.b0(a4, a5, a6);
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        return aVar.f4747b;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
