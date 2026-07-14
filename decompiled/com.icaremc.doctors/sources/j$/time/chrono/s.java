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
public final class s extends AbstractC0205a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final s f2522c = new s();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // j$.time.chrono.l
    public final m B(int i2) {
        if (i2 == 0) {
            return t.BCE;
        }
        if (i2 == 1) {
            return t.CE;
        }
        throw new RuntimeException("Invalid era: " + i2);
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
    public final InterfaceC0206b Q(int i2, int i3, int i4) {
        return j$.time.h.b0(i2, i3, i4);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b v(int i2, int i3) {
        return j$.time.h.d0(i2, i3);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b p(long j2) {
        return j$.time.h.c0(j2);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b G(TemporalAccessor temporalAccessor) {
        return j$.time.h.F(temporalAccessor);
    }

    private s() {
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0209e H(LocalDateTime localDateTime) {
        return LocalDateTime.A(localDateTime);
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime T(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.s(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    @Override // j$.time.chrono.l
    public final InterfaceC0206b M() {
        return j$.time.h.F(j$.time.h.a0(j$.time.b.b()));
    }

    public static boolean X(long j2) {
        if ((3 & j2) == 0) {
            return j2 % 100 != 0 || j2 % 400 == 0;
        }
        return false;
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i2) {
        if (mVar instanceof t) {
            return mVar == t.CE ? i2 : 1 - i2;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // j$.time.chrono.l
    public final List z() {
        return j$.time.b.a(t.values());
    }

    @Override // j$.time.chrono.AbstractC0205a, j$.time.chrono.l
    public final InterfaceC0206b S(Map map, j$.time.format.x xVar) {
        return (j$.time.h) super.S(map, xVar);
    }

    @Override // j$.time.chrono.AbstractC0205a
    public final void I(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l2 = (Long) map.remove(aVar);
        if (l2 != null) {
            if (xVar != j$.time.format.x.LENIENT) {
                aVar.X(l2.longValue());
            }
            AbstractC0205a.s(map, j$.time.temporal.a.MONTH_OF_YEAR, ((int) Math.floorMod(l2.longValue(), r4)) + 1);
            AbstractC0205a.s(map, j$.time.temporal.a.YEAR, Math.floorDiv(l2.longValue(), 12));
        }
    }

    @Override // j$.time.chrono.AbstractC0205a
    public final InterfaceC0206b V(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l2 = (Long) map.remove(aVar);
        if (l2 != null) {
            if (xVar != j$.time.format.x.LENIENT) {
                aVar.X(l2.longValue());
            }
            Long l3 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (l3 != null) {
                if (l3.longValue() == 1) {
                    AbstractC0205a.s(map, j$.time.temporal.a.YEAR, l2.longValue());
                    return null;
                }
                if (l3.longValue() == 0) {
                    AbstractC0205a.s(map, j$.time.temporal.a.YEAR, Math.subtractExact(1L, l2.longValue()));
                    return null;
                }
                throw new RuntimeException("Invalid value for era: " + l3);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            Long l4 = (Long) map.get(aVar2);
            if (xVar != j$.time.format.x.STRICT) {
                AbstractC0205a.s(map, aVar2, (l4 == null || l4.longValue() > 0) ? l2.longValue() : Math.subtractExact(1L, l2.longValue()));
                return null;
            }
            if (l4 != null) {
                long longValue = l4.longValue();
                long longValue2 = l2.longValue();
                if (longValue <= 0) {
                    longValue2 = Math.subtractExact(1L, longValue2);
                }
                AbstractC0205a.s(map, aVar2, longValue2);
                return null;
            }
            map.put(aVar, l2);
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        aVar3.X(((Long) map.get(aVar3)).longValue());
        return null;
    }

    @Override // j$.time.chrono.AbstractC0205a
    public final InterfaceC0206b P(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int a2 = aVar.f2650b.a(((Long) map.remove(aVar)).longValue(), aVar);
        boolean z = true;
        if (xVar == j$.time.format.x.LENIENT) {
            return j$.time.h.b0(a2, 1, 1).g0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L)).f0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L));
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int a3 = aVar2.f2650b.a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int a4 = aVar3.f2650b.a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (xVar == j$.time.format.x.SMART) {
            if (a3 == 4 || a3 == 6 || a3 == 9 || a3 == 11) {
                a4 = Math.min(a4, 30);
            } else if (a3 == 2) {
                j$.time.n nVar = j$.time.n.FEBRUARY;
                long j2 = a2;
                int i2 = j$.time.v.f2681b;
                if ((3 & j2) != 0 || (j2 % 100 == 0 && j2 % 400 != 0)) {
                    z = false;
                }
                a4 = Math.min(a4, nVar.A(z));
            }
        }
        return j$.time.h.b0(a2, a3, a4);
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        return aVar.f2650b;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
