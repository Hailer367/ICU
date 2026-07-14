package j$.time.chrono;

import j$.time.DayOfWeek;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: j$.time.chrono.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0205a implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f2489a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f2490b = new ConcurrentHashMap();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return q().compareTo(((l) obj).q());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    public static l A(l lVar, String str) {
        String u2;
        l lVar2 = (l) f2489a.putIfAbsent(str, lVar);
        if (lVar2 == null && (u2 = lVar.u()) != null) {
            f2490b.putIfAbsent(u2, lVar);
        }
        return lVar2;
    }

    @Override // j$.time.chrono.l
    public InterfaceC0206b S(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return p(((Long) map.remove(aVar)).longValue());
        }
        I(map, xVar);
        InterfaceC0206b V2 = V(map, xVar);
        if (V2 != null) {
            return V2;
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
        if (!map.containsKey(aVar2)) {
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
        if (map.containsKey(aVar3)) {
            if (map.containsKey(j$.time.temporal.a.DAY_OF_MONTH)) {
                return P(map, xVar);
            }
            j$.time.temporal.a aVar4 = j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(aVar4)) {
                j$.time.temporal.a aVar5 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (map.containsKey(aVar5)) {
                    int a2 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (xVar == j$.time.format.x.LENIENT) {
                        long subtractExact = Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L);
                        return Q(a2, 1, 1).d(subtractExact, (j$.time.temporal.s) j$.time.temporal.b.MONTHS).d(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.WEEKS).d(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                    }
                    int a3 = y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int a4 = y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    InterfaceC0206b d2 = Q(a2, a3, 1).d((y(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((a4 - 1) * 7), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                    if (xVar != j$.time.format.x.STRICT || d2.g(aVar3) == a3) {
                        return d2;
                    }
                    throw new RuntimeException("Strict mode rejected resolved date as it is in a different month");
                }
                j$.time.temporal.a aVar6 = j$.time.temporal.a.DAY_OF_WEEK;
                if (map.containsKey(aVar6)) {
                    int a5 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (xVar == j$.time.format.x.LENIENT) {
                        return F(Q(a5, 1, 1), Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar6)).longValue(), 1L));
                    }
                    int a6 = y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    InterfaceC0206b m2 = Q(a5, a6, 1).d((y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (j$.time.temporal.s) j$.time.temporal.b.DAYS).m(new j$.time.temporal.o(DayOfWeek.s(y(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).getValue(), 0));
                    if (xVar != j$.time.format.x.STRICT || m2.g(aVar3) == a6) {
                        return m2;
                    }
                    throw new RuntimeException("Strict mode rejected resolved date as it is in a different month");
                }
            }
        }
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_YEAR;
        if (map.containsKey(aVar7)) {
            int a7 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (xVar != j$.time.format.x.LENIENT) {
                return v(a7, y(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
            }
            return v(a7, 1).d(Math.subtractExact(((Long) map.remove(aVar7)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar8 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(aVar8)) {
            return null;
        }
        j$.time.temporal.a aVar9 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(aVar9)) {
            int a8 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (xVar == j$.time.format.x.LENIENT) {
                return v(a8, 1).d(Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.WEEKS).d(Math.subtractExact(((Long) map.remove(aVar9)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
            }
            int a9 = y(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8);
            InterfaceC0206b d3 = v(a8, 1).d((y(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((a9 - 1) * 7), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
            if (xVar != j$.time.format.x.STRICT || d3.g(aVar2) == a8) {
                return d3;
            }
            throw new RuntimeException("Strict mode rejected resolved date as it is in a different year");
        }
        j$.time.temporal.a aVar10 = j$.time.temporal.a.DAY_OF_WEEK;
        if (!map.containsKey(aVar10)) {
            return null;
        }
        int a10 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        if (xVar == j$.time.format.x.LENIENT) {
            return F(v(a10, 1), 0L, Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar10)).longValue(), 1L));
        }
        InterfaceC0206b m3 = v(a10, 1).d((y(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (j$.time.temporal.s) j$.time.temporal.b.DAYS).m(new j$.time.temporal.o(DayOfWeek.s(y(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).getValue(), 0));
        if (xVar != j$.time.format.x.STRICT || m3.g(aVar2) == a10) {
            return m3;
        }
        throw new RuntimeException("Strict mode rejected resolved date as it is in a different year");
    }

    public void I(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l2 = (Long) map.remove(aVar);
        if (l2 != null) {
            if (xVar != j$.time.format.x.LENIENT) {
                aVar.X(l2.longValue());
            }
            InterfaceC0206b c2 = M().c(1L, (j$.time.temporal.q) j$.time.temporal.a.DAY_OF_MONTH).c(l2.longValue(), (j$.time.temporal.q) aVar);
            s(map, j$.time.temporal.a.MONTH_OF_YEAR, c2.g(r0));
            s(map, j$.time.temporal.a.YEAR, c2.g(r0));
        }
    }

    public InterfaceC0206b V(Map map, j$.time.format.x xVar) {
        int intExact;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l2 = (Long) map.remove(aVar);
        if (l2 != null) {
            Long l3 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (xVar != j$.time.format.x.LENIENT) {
                intExact = y(aVar).a(l2.longValue(), aVar);
            } else {
                intExact = Math.toIntExact(l2.longValue());
            }
            if (l3 != null) {
                s(map, j$.time.temporal.a.YEAR, C(B(y(r2).a(l3.longValue(), r2)), intExact));
                return null;
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            if (map.containsKey(aVar2)) {
                s(map, aVar2, C(v(y(aVar2).a(((Long) map.get(aVar2)).longValue(), aVar2), 1).N(), intExact));
                return null;
            }
            if (xVar == j$.time.format.x.STRICT) {
                map.put(aVar, l2);
                return null;
            }
            if (z().isEmpty()) {
                s(map, aVar2, intExact);
                return null;
            }
            s(map, aVar2, C((m) r9.get(r9.size() - 1), intExact));
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        y(aVar3).b(((Long) map.get(aVar3)).longValue(), aVar3);
        return null;
    }

    public InterfaceC0206b P(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int a2 = y(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (xVar == j$.time.format.x.LENIENT) {
            long subtractExact = Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return Q(a2, 1, 1).d(subtractExact, (j$.time.temporal.s) j$.time.temporal.b.MONTHS).d(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int a3 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int a4 = y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (xVar == j$.time.format.x.SMART) {
            try {
                return Q(a2, a3, a4);
            } catch (j$.time.c unused) {
                return Q(a2, a3, 1).m(new j$.time.i(2));
            }
        }
        return Q(a2, a3, a4);
    }

    public static InterfaceC0206b F(InterfaceC0206b interfaceC0206b, long j2, long j3, long j4) {
        long j5;
        InterfaceC0206b d2 = interfaceC0206b.d(j2, (j$.time.temporal.s) j$.time.temporal.b.MONTHS);
        j$.time.temporal.b bVar = j$.time.temporal.b.WEEKS;
        InterfaceC0206b d3 = d2.d(j3, (j$.time.temporal.s) bVar);
        if (j4 > 7) {
            long j6 = j4 - 1;
            d3 = d3.d(j6 / 7, (j$.time.temporal.s) bVar);
            j5 = j6 % 7;
        } else {
            if (j4 < 1) {
                d3 = d3.d(Math.subtractExact(j4, 7L) / 7, (j$.time.temporal.s) bVar);
                j5 = (j4 + 6) % 7;
            }
            return d3.m(new j$.time.temporal.o(DayOfWeek.s((int) j4).getValue(), 0));
        }
        j4 = j5 + 1;
        return d3.m(new j$.time.temporal.o(DayOfWeek.s((int) j4).getValue(), 0));
    }

    public static void s(Map map, j$.time.temporal.a aVar, long j2) {
        Long l2 = (Long) map.get(aVar);
        if (l2 != null && l2.longValue() != j2) {
            throw new RuntimeException("Conflict found: " + aVar + " " + l2 + " differs from " + aVar + " " + j2);
        }
        map.put(aVar, Long.valueOf(j2));
    }

    @Override // j$.time.chrono.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC0205a) && q().compareTo(((AbstractC0205a) obj).q()) == 0;
    }

    @Override // j$.time.chrono.l
    public final int hashCode() {
        return getClass().hashCode() ^ q().hashCode();
    }

    @Override // j$.time.chrono.l
    public final String toString() {
        return q();
    }
}
