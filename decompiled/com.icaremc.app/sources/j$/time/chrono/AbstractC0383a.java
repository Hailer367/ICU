package j$.time.chrono;

import j$.time.DayOfWeek;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: j$.time.chrono.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0383a implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f4587a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f4588b = new ConcurrentHashMap();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return q().compareTo(((l) obj).q());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    public static l A(l lVar, String str) {
        String u3;
        l lVar2 = (l) f4587a.putIfAbsent(str, lVar);
        if (lVar2 == null && (u3 = lVar.u()) != null) {
            f4588b.putIfAbsent(u3, lVar);
        }
        return lVar2;
    }

    @Override // j$.time.chrono.l
    public InterfaceC0384b S(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return p(((Long) map.remove(aVar)).longValue());
        }
        I(map, xVar);
        InterfaceC0384b V3 = V(map, xVar);
        if (V3 != null) {
            return V3;
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
                    int a4 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (xVar == j$.time.format.x.LENIENT) {
                        long subtractExact = Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L);
                        return Q(a4, 1, 1).d(subtractExact, (j$.time.temporal.s) j$.time.temporal.b.MONTHS).d(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.WEEKS).d(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                    }
                    int a5 = y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int a6 = y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    InterfaceC0384b d4 = Q(a4, a5, 1).d((y(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((a6 - 1) * 7), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                    if (xVar != j$.time.format.x.STRICT || d4.g(aVar3) == a5) {
                        return d4;
                    }
                    throw new RuntimeException("Strict mode rejected resolved date as it is in a different month");
                }
                j$.time.temporal.a aVar6 = j$.time.temporal.a.DAY_OF_WEEK;
                if (map.containsKey(aVar6)) {
                    int a7 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (xVar == j$.time.format.x.LENIENT) {
                        return F(Q(a7, 1, 1), Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar6)).longValue(), 1L));
                    }
                    int a8 = y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    InterfaceC0384b m3 = Q(a7, a8, 1).d((y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (j$.time.temporal.s) j$.time.temporal.b.DAYS).m(new j$.time.temporal.o(DayOfWeek.s(y(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).getValue(), 0));
                    if (xVar != j$.time.format.x.STRICT || m3.g(aVar3) == a8) {
                        return m3;
                    }
                    throw new RuntimeException("Strict mode rejected resolved date as it is in a different month");
                }
            }
        }
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_YEAR;
        if (map.containsKey(aVar7)) {
            int a9 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (xVar != j$.time.format.x.LENIENT) {
                return v(a9, y(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
            }
            return v(a9, 1).d(Math.subtractExact(((Long) map.remove(aVar7)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar8 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(aVar8)) {
            return null;
        }
        j$.time.temporal.a aVar9 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(aVar9)) {
            int a10 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (xVar == j$.time.format.x.LENIENT) {
                return v(a10, 1).d(Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.WEEKS).d(Math.subtractExact(((Long) map.remove(aVar9)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
            }
            int a11 = y(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8);
            InterfaceC0384b d5 = v(a10, 1).d((y(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((a11 - 1) * 7), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
            if (xVar != j$.time.format.x.STRICT || d5.g(aVar2) == a10) {
                return d5;
            }
            throw new RuntimeException("Strict mode rejected resolved date as it is in a different year");
        }
        j$.time.temporal.a aVar10 = j$.time.temporal.a.DAY_OF_WEEK;
        if (!map.containsKey(aVar10)) {
            return null;
        }
        int a12 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        if (xVar == j$.time.format.x.LENIENT) {
            return F(v(a12, 1), 0L, Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar10)).longValue(), 1L));
        }
        InterfaceC0384b m4 = v(a12, 1).d((y(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (j$.time.temporal.s) j$.time.temporal.b.DAYS).m(new j$.time.temporal.o(DayOfWeek.s(y(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).getValue(), 0));
        if (xVar != j$.time.format.x.STRICT || m4.g(aVar2) == a12) {
            return m4;
        }
        throw new RuntimeException("Strict mode rejected resolved date as it is in a different year");
    }

    public void I(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l3 = (Long) map.remove(aVar);
        if (l3 != null) {
            if (xVar != j$.time.format.x.LENIENT) {
                aVar.X(l3.longValue());
            }
            InterfaceC0384b c4 = M().c(1L, (j$.time.temporal.q) j$.time.temporal.a.DAY_OF_MONTH).c(l3.longValue(), (j$.time.temporal.q) aVar);
            s(map, j$.time.temporal.a.MONTH_OF_YEAR, c4.g(r0));
            s(map, j$.time.temporal.a.YEAR, c4.g(r0));
        }
    }

    public InterfaceC0384b V(Map map, j$.time.format.x xVar) {
        int intExact;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l3 = (Long) map.remove(aVar);
        if (l3 != null) {
            Long l4 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (xVar != j$.time.format.x.LENIENT) {
                intExact = y(aVar).a(l3.longValue(), aVar);
            } else {
                intExact = Math.toIntExact(l3.longValue());
            }
            if (l4 != null) {
                s(map, j$.time.temporal.a.YEAR, C(B(y(r2).a(l4.longValue(), r2)), intExact));
                return null;
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            if (map.containsKey(aVar2)) {
                s(map, aVar2, C(v(y(aVar2).a(((Long) map.get(aVar2)).longValue(), aVar2), 1).N(), intExact));
                return null;
            }
            if (xVar == j$.time.format.x.STRICT) {
                map.put(aVar, l3);
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

    public InterfaceC0384b P(Map map, j$.time.format.x xVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int a4 = y(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (xVar == j$.time.format.x.LENIENT) {
            long subtractExact = Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return Q(a4, 1, 1).d(subtractExact, (j$.time.temporal.s) j$.time.temporal.b.MONTHS).d(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int a5 = y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int a6 = y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (xVar == j$.time.format.x.SMART) {
            try {
                return Q(a4, a5, a6);
            } catch (j$.time.c unused) {
                return Q(a4, a5, 1).m(new j$.time.i(2));
            }
        }
        return Q(a4, a5, a6);
    }

    public static InterfaceC0384b F(InterfaceC0384b interfaceC0384b, long j4, long j5, long j6) {
        long j7;
        InterfaceC0384b d4 = interfaceC0384b.d(j4, (j$.time.temporal.s) j$.time.temporal.b.MONTHS);
        j$.time.temporal.b bVar = j$.time.temporal.b.WEEKS;
        InterfaceC0384b d5 = d4.d(j5, (j$.time.temporal.s) bVar);
        if (j6 > 7) {
            long j8 = j6 - 1;
            d5 = d5.d(j8 / 7, (j$.time.temporal.s) bVar);
            j7 = j8 % 7;
        } else {
            if (j6 < 1) {
                d5 = d5.d(Math.subtractExact(j6, 7L) / 7, (j$.time.temporal.s) bVar);
                j7 = (j6 + 6) % 7;
            }
            return d5.m(new j$.time.temporal.o(DayOfWeek.s((int) j6).getValue(), 0));
        }
        j6 = j7 + 1;
        return d5.m(new j$.time.temporal.o(DayOfWeek.s((int) j6).getValue(), 0));
    }

    public static void s(Map map, j$.time.temporal.a aVar, long j4) {
        Long l3 = (Long) map.get(aVar);
        if (l3 != null && l3.longValue() != j4) {
            throw new RuntimeException("Conflict found: " + aVar + " " + l3 + " differs from " + aVar + " " + j4);
        }
        map.put(aVar, Long.valueOf(j4));
    }

    @Override // j$.time.chrono.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC0383a) && q().compareTo(((AbstractC0383a) obj).q()) == 0;
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
