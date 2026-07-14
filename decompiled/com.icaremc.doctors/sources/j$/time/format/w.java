package j$.time.format;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.InterfaceC0206b;
import j$.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class w implements TemporalAccessor {

    /* renamed from: b, reason: collision with root package name */
    public ZoneId f2602b;

    /* renamed from: c, reason: collision with root package name */
    public j$.time.chrono.l f2603c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2604d;

    /* renamed from: e, reason: collision with root package name */
    public x f2605e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0206b f2606f;

    /* renamed from: g, reason: collision with root package name */
    public j$.time.l f2607g;

    /* renamed from: a, reason: collision with root package name */
    public final Map f2601a = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public j$.time.s f2608h = j$.time.s.f2642d;

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (((HashMap) this.f2601a).containsKey(qVar)) {
            return true;
        }
        InterfaceC0206b interfaceC0206b = this.f2606f;
        if (interfaceC0206b != null && interfaceC0206b.h(qVar)) {
            return true;
        }
        j$.time.l lVar = this.f2607g;
        if (lVar == null || !lVar.h(qVar)) {
            return (qVar == null || (qVar instanceof j$.time.temporal.a) || !qVar.s(this)) ? false : true;
        }
        return true;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        Objects.requireNonNull(qVar, "field");
        Long l2 = (Long) ((HashMap) this.f2601a).get(qVar);
        if (l2 != null) {
            return l2.longValue();
        }
        InterfaceC0206b interfaceC0206b = this.f2606f;
        if (interfaceC0206b != null && interfaceC0206b.h(qVar)) {
            return this.f2606f.i(qVar);
        }
        j$.time.l lVar = this.f2607g;
        if (lVar != null && lVar.h(qVar)) {
            return this.f2607g.i(qVar);
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new RuntimeException(j$.time.d.a("Unsupported field: ", qVar));
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f2668a) {
            return this.f2602b;
        }
        if (iVar == j$.time.temporal.r.f2669b) {
            return this.f2603c;
        }
        if (iVar == j$.time.temporal.r.f2673f) {
            InterfaceC0206b interfaceC0206b = this.f2606f;
            if (interfaceC0206b != null) {
                return j$.time.h.F(interfaceC0206b);
            }
            return null;
        }
        if (iVar == j$.time.temporal.r.f2674g) {
            return this.f2607g;
        }
        if (iVar == j$.time.temporal.r.f2671d) {
            Long l2 = (Long) ((HashMap) this.f2601a).get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l2 != null) {
                return ZoneOffset.Y(l2.intValue());
            }
            ZoneId zoneId = this.f2602b;
            return zoneId instanceof ZoneOffset ? zoneId : iVar.k(this);
        }
        if (iVar == j$.time.temporal.r.f2672e) {
            return iVar.k(this);
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return null;
        }
        return iVar.k(this);
    }

    public final void z(j$.time.temporal.q qVar, j$.time.temporal.a aVar, Long l2) {
        Long l3 = (Long) ((HashMap) this.f2601a).put(aVar, l2);
        if (l3 == null || l3.longValue() == l2.longValue()) {
            return;
        }
        throw new RuntimeException("Conflict found: " + aVar + " " + l3 + " differs from " + aVar + " " + l2 + " while resolving  " + qVar);
    }

    public final void q() {
        if (((HashMap) this.f2601a).containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
            ZoneId zoneId = this.f2602b;
            if (zoneId != null) {
                r(zoneId);
                return;
            }
            Long l2 = (Long) ((HashMap) this.f2601a).get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l2 != null) {
                r(ZoneOffset.Y(l2.intValue()));
            }
        }
    }

    public final void r(ZoneId zoneId) {
        Map map = this.f2601a;
        j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
        y(this.f2603c.T(Instant.s(((Long) ((HashMap) map).remove(aVar)).longValue(), 0), zoneId).n());
        z(aVar, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(r5.j().e0()));
    }

    public final void y(InterfaceC0206b interfaceC0206b) {
        InterfaceC0206b interfaceC0206b2 = this.f2606f;
        if (interfaceC0206b2 != null) {
            if (interfaceC0206b == null || interfaceC0206b2.equals(interfaceC0206b)) {
                return;
            }
            throw new RuntimeException("Conflict found: Fields resolved to two different dates: " + this.f2606f + " " + interfaceC0206b);
        }
        if (interfaceC0206b != null) {
            if (!this.f2603c.equals(interfaceC0206b.f())) {
                throw new RuntimeException("ChronoLocalDate must use the effective parsed chronology: " + this.f2603c);
            }
            this.f2606f = interfaceC0206b;
        }
    }

    public final void u() {
        Map map = this.f2601a;
        j$.time.temporal.a aVar = j$.time.temporal.a.CLOCK_HOUR_OF_DAY;
        if (((HashMap) map).containsKey(aVar)) {
            long longValue = ((Long) ((HashMap) this.f2601a).remove(aVar)).longValue();
            x xVar = this.f2605e;
            if (xVar == x.STRICT || (xVar == x.SMART && longValue != 0)) {
                aVar.X(longValue);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            z(aVar, aVar2, Long.valueOf(longValue));
        }
        Map map2 = this.f2601a;
        j$.time.temporal.a aVar3 = j$.time.temporal.a.CLOCK_HOUR_OF_AMPM;
        if (((HashMap) map2).containsKey(aVar3)) {
            long longValue2 = ((Long) ((HashMap) this.f2601a).remove(aVar3)).longValue();
            x xVar2 = this.f2605e;
            if (xVar2 == x.STRICT || (xVar2 == x.SMART && longValue2 != 0)) {
                aVar3.X(longValue2);
            }
            z(aVar3, j$.time.temporal.a.HOUR_OF_AMPM, Long.valueOf(longValue2 != 12 ? longValue2 : 0L));
        }
        Map map3 = this.f2601a;
        j$.time.temporal.a aVar4 = j$.time.temporal.a.AMPM_OF_DAY;
        if (((HashMap) map3).containsKey(aVar4)) {
            Map map4 = this.f2601a;
            j$.time.temporal.a aVar5 = j$.time.temporal.a.HOUR_OF_AMPM;
            if (((HashMap) map4).containsKey(aVar5)) {
                long longValue3 = ((Long) ((HashMap) this.f2601a).remove(aVar4)).longValue();
                long longValue4 = ((Long) ((HashMap) this.f2601a).remove(aVar5)).longValue();
                if (this.f2605e == x.LENIENT) {
                    z(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(Math.addExact(Math.multiplyExact(longValue3, 12), longValue4)));
                } else {
                    aVar4.X(longValue3);
                    aVar5.X(longValue3);
                    z(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf((longValue3 * 12) + longValue4));
                }
            }
        }
        Map map5 = this.f2601a;
        j$.time.temporal.a aVar6 = j$.time.temporal.a.NANO_OF_DAY;
        if (((HashMap) map5).containsKey(aVar6)) {
            long longValue5 = ((Long) ((HashMap) this.f2601a).remove(aVar6)).longValue();
            if (this.f2605e != x.LENIENT) {
                aVar6.X(longValue5);
            }
            z(aVar6, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(longValue5 / 3600000000000L));
            z(aVar6, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((longValue5 / 60000000000L) % 60));
            z(aVar6, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf((longValue5 / 1000000000) % 60));
            z(aVar6, j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(longValue5 % 1000000000));
        }
        Map map6 = this.f2601a;
        j$.time.temporal.a aVar7 = j$.time.temporal.a.MICRO_OF_DAY;
        if (((HashMap) map6).containsKey(aVar7)) {
            long longValue6 = ((Long) ((HashMap) this.f2601a).remove(aVar7)).longValue();
            if (this.f2605e != x.LENIENT) {
                aVar7.X(longValue6);
            }
            z(aVar7, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(longValue6 / 1000000));
            z(aVar7, j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(longValue6 % 1000000));
        }
        Map map7 = this.f2601a;
        j$.time.temporal.a aVar8 = j$.time.temporal.a.MILLI_OF_DAY;
        if (((HashMap) map7).containsKey(aVar8)) {
            long longValue7 = ((Long) ((HashMap) this.f2601a).remove(aVar8)).longValue();
            if (this.f2605e != x.LENIENT) {
                aVar8.X(longValue7);
            }
            z(aVar8, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(longValue7 / 1000));
            z(aVar8, j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(longValue7 % 1000));
        }
        Map map8 = this.f2601a;
        j$.time.temporal.a aVar9 = j$.time.temporal.a.SECOND_OF_DAY;
        if (((HashMap) map8).containsKey(aVar9)) {
            long longValue8 = ((Long) ((HashMap) this.f2601a).remove(aVar9)).longValue();
            if (this.f2605e != x.LENIENT) {
                aVar9.X(longValue8);
            }
            z(aVar9, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(longValue8 / 3600));
            z(aVar9, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((longValue8 / 60) % 60));
            z(aVar9, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf(longValue8 % 60));
        }
        Map map9 = this.f2601a;
        j$.time.temporal.a aVar10 = j$.time.temporal.a.MINUTE_OF_DAY;
        if (((HashMap) map9).containsKey(aVar10)) {
            long longValue9 = ((Long) ((HashMap) this.f2601a).remove(aVar10)).longValue();
            if (this.f2605e != x.LENIENT) {
                aVar10.X(longValue9);
            }
            z(aVar10, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(longValue9 / 60));
            z(aVar10, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf(longValue9 % 60));
        }
        Map map10 = this.f2601a;
        j$.time.temporal.a aVar11 = j$.time.temporal.a.NANO_OF_SECOND;
        if (((HashMap) map10).containsKey(aVar11)) {
            long longValue10 = ((Long) ((HashMap) this.f2601a).get(aVar11)).longValue();
            x xVar3 = this.f2605e;
            x xVar4 = x.LENIENT;
            if (xVar3 != xVar4) {
                aVar11.X(longValue10);
            }
            Map map11 = this.f2601a;
            j$.time.temporal.a aVar12 = j$.time.temporal.a.MICRO_OF_SECOND;
            if (((HashMap) map11).containsKey(aVar12)) {
                long longValue11 = ((Long) ((HashMap) this.f2601a).remove(aVar12)).longValue();
                if (this.f2605e != xVar4) {
                    aVar12.X(longValue11);
                }
                longValue10 = (longValue10 % 1000) + (longValue11 * 1000);
                z(aVar12, aVar11, Long.valueOf(longValue10));
            }
            Map map12 = this.f2601a;
            j$.time.temporal.a aVar13 = j$.time.temporal.a.MILLI_OF_SECOND;
            if (((HashMap) map12).containsKey(aVar13)) {
                long longValue12 = ((Long) ((HashMap) this.f2601a).remove(aVar13)).longValue();
                if (this.f2605e != xVar4) {
                    aVar13.X(longValue12);
                }
                z(aVar13, aVar11, Long.valueOf((longValue10 % 1000000) + (longValue12 * 1000000)));
            }
        }
        Map map13 = this.f2601a;
        j$.time.temporal.a aVar14 = j$.time.temporal.a.HOUR_OF_DAY;
        if (((HashMap) map13).containsKey(aVar14)) {
            Map map14 = this.f2601a;
            j$.time.temporal.a aVar15 = j$.time.temporal.a.MINUTE_OF_HOUR;
            if (((HashMap) map14).containsKey(aVar15)) {
                Map map15 = this.f2601a;
                j$.time.temporal.a aVar16 = j$.time.temporal.a.SECOND_OF_MINUTE;
                if (((HashMap) map15).containsKey(aVar16) && ((HashMap) this.f2601a).containsKey(aVar11)) {
                    s(((Long) ((HashMap) this.f2601a).remove(aVar14)).longValue(), ((Long) ((HashMap) this.f2601a).remove(aVar15)).longValue(), ((Long) ((HashMap) this.f2601a).remove(aVar16)).longValue(), ((Long) ((HashMap) this.f2601a).remove(aVar11)).longValue());
                }
            }
        }
    }

    public final void s(long j2, long j3, long j4, long j5) {
        if (this.f2605e == x.LENIENT) {
            long addExact = Math.addExact(Math.addExact(Math.addExact(Math.multiplyExact(j2, 3600000000000L), Math.multiplyExact(j3, 60000000000L)), Math.multiplyExact(j4, 1000000000L)), j5);
            v(j$.time.l.V(Math.floorMod(addExact, 86400000000000L)), j$.time.s.a(0, 0, (int) Math.floorDiv(addExact, 86400000000000L)));
            return;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.MINUTE_OF_HOUR;
        int a2 = aVar.f2650b.a(j3, aVar);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.NANO_OF_SECOND;
        int a3 = aVar2.f2650b.a(j5, aVar2);
        if (this.f2605e == x.SMART && j2 == 24 && a2 == 0 && j4 == 0 && a3 == 0) {
            v(j$.time.l.f2625g, j$.time.s.a(0, 0, 1));
            return;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.HOUR_OF_DAY;
        int a4 = aVar3.f2650b.a(j2, aVar3);
        j$.time.temporal.a aVar4 = j$.time.temporal.a.SECOND_OF_MINUTE;
        v(j$.time.l.P(a4, a2, aVar4.f2650b.a(j4, aVar4), a3), j$.time.s.f2642d);
    }

    public final void v(j$.time.l lVar, j$.time.s sVar) {
        j$.time.l lVar2 = this.f2607g;
        if (lVar2 != null) {
            if (!lVar2.equals(lVar)) {
                throw new RuntimeException("Conflict found: Fields resolved to different times: " + this.f2607g + " " + lVar);
            }
            j$.time.s sVar2 = this.f2608h;
            sVar2.getClass();
            j$.time.s sVar3 = j$.time.s.f2642d;
            if (sVar2 != sVar3 && sVar != sVar3 && !this.f2608h.equals(sVar)) {
                throw new RuntimeException("Conflict found: Fields resolved to different excess periods: " + this.f2608h + " " + sVar);
            }
            this.f2608h = sVar;
            return;
        }
        this.f2607g = lVar;
        this.f2608h = sVar;
    }

    public final void p(TemporalAccessor temporalAccessor) {
        Iterator it = ((HashMap) this.f2601a).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j$.time.temporal.q qVar = (j$.time.temporal.q) entry.getKey();
            if (temporalAccessor.h(qVar)) {
                try {
                    long i2 = temporalAccessor.i(qVar);
                    long longValue = ((Long) entry.getValue()).longValue();
                    if (i2 != longValue) {
                        throw new RuntimeException("Conflict found: Field " + qVar + " " + i2 + " differs from " + qVar + " " + longValue + " derived from " + temporalAccessor);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.f2601a);
        sb.append(',');
        sb.append(this.f2603c);
        if (this.f2602b != null) {
            sb.append(',');
            sb.append(this.f2602b);
        }
        if (this.f2606f != null || this.f2607g != null) {
            sb.append(" resolved to ");
            InterfaceC0206b interfaceC0206b = this.f2606f;
            if (interfaceC0206b != null) {
                sb.append(interfaceC0206b);
                if (this.f2607g != null) {
                    sb.append('T');
                    sb.append(this.f2607g);
                }
            } else {
                sb.append(this.f2607g);
            }
        }
        return sb.toString();
    }
}
