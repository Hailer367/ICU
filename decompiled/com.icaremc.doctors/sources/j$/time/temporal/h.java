package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.format.w;
import j$.time.format.x;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class h implements q {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f2654a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f2655b;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f2655b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.q
            public final u I() {
                return u.g(90L, 92L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.DAY_OF_YEAR) || !temporalAccessor.h(a.MONTH_OF_YEAR) || !temporalAccessor.h(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.f2658a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f2522c);
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: DayOfQuarter");
                }
                long i2 = temporalAccessor.i(h.QUARTER_OF_YEAR);
                if (i2 == 1) {
                    long i3 = temporalAccessor.i(a.YEAR);
                    j$.time.chrono.s.f2522c.getClass();
                    return j$.time.chrono.s.X(i3) ? u.f(1L, 91L) : u.f(1L, 90L);
                }
                if (i2 == 2) {
                    return u.f(1L, 91L);
                }
                if (i2 == 3 || i2 == 4) {
                    return u.f(1L, 92L);
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: DayOfQuarter");
                }
                int g2 = temporalAccessor.g(a.DAY_OF_YEAR);
                int g3 = temporalAccessor.g(a.MONTH_OF_YEAR);
                long i2 = temporalAccessor.i(a.YEAR);
                int i3 = (g3 - 1) / 3;
                j$.time.chrono.s.f2522c.getClass();
                return g2 - h.f2654a[i3 + (j$.time.chrono.s.X(i2) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j2) {
                long P2 = P(mVar);
                I().b(j2, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.c((j2 - P2) + mVar.i(aVar), aVar);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor F(Map map, w wVar, x xVar) {
                long j2;
                j$.time.h hVar2;
                a aVar = a.YEAR;
                Long l2 = (Long) map.get(aVar);
                q qVar = h.QUARTER_OF_YEAR;
                Long l3 = (Long) map.get(qVar);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int a2 = aVar.f2650b.a(l2.longValue(), aVar);
                long longValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                h hVar3 = j.f2658a;
                if (j$.time.chrono.l.r(wVar).equals(j$.time.chrono.s.f2522c)) {
                    if (xVar == x.LENIENT) {
                        hVar2 = j$.time.h.b0(a2, 1, 1).g0(Math.multiplyExact(Math.subtractExact(l3.longValue(), 1L), 3));
                        j2 = Math.subtractExact(longValue, 1L);
                    } else {
                        j$.time.h b02 = j$.time.h.b0(a2, ((qVar.I().a(l3.longValue(), qVar) - 1) * 3) + 1, 1);
                        if (longValue < 1 || longValue > 90) {
                            if (xVar == x.STRICT) {
                                A(b02).b(longValue, this);
                            } else {
                                I().b(longValue, this);
                            }
                        }
                        j2 = longValue - 1;
                        hVar2 = b02;
                    }
                    map.remove(this);
                    map.remove(aVar);
                    map.remove(qVar);
                    return hVar2.f0(j2);
                }
                throw new RuntimeException("Resolve requires IsoChronology");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.q
            public final u I() {
                return u.f(1L, 4L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.f2658a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f2522c);
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.i(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: QuarterOfYear");
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j2) {
                long P2 = P(mVar);
                I().b(j2, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.c(((j2 - P2) * 3) + mVar.i(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.q
            public final u I() {
                return u.g(52L, 53L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.f2658a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f2522c);
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.a0(j$.time.h.F(temporalAccessor));
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.X(j$.time.h.F(temporalAccessor));
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j2) {
                I().b(j2, this);
                return mVar.d(Math.subtractExact(j2, P(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor F(Map map, w wVar, x xVar) {
                j$.time.h c2;
                long j2;
                long j3;
                q qVar = h.WEEK_BASED_YEAR;
                Long l2 = (Long) map.get(qVar);
                a aVar = a.DAY_OF_WEEK;
                Long l3 = (Long) map.get(aVar);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int a2 = qVar.I().a(l2.longValue(), qVar);
                long longValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                h hVar4 = j.f2658a;
                if (j$.time.chrono.l.r(wVar).equals(j$.time.chrono.s.f2522c)) {
                    j$.time.h b02 = j$.time.h.b0(a2, 1, 4);
                    if (xVar == x.LENIENT) {
                        long longValue2 = l3.longValue();
                        if (longValue2 > 7) {
                            long j4 = longValue2 - 1;
                            j2 = 1;
                            b02 = b02.h0(j4 / 7);
                            j3 = j4 % 7;
                        } else {
                            j2 = 1;
                            if (longValue2 < 1) {
                                b02 = b02.h0(Math.subtractExact(longValue2, 7L) / 7);
                                j3 = (longValue2 + 6) % 7;
                            }
                            c2 = b02.h0(Math.subtractExact(longValue, j2)).c(longValue2, aVar);
                        }
                        longValue2 = j3 + j2;
                        c2 = b02.h0(Math.subtractExact(longValue, j2)).c(longValue2, aVar);
                    } else {
                        int a3 = aVar.f2650b.a(l3.longValue(), aVar);
                        if (longValue < 1 || longValue > 52) {
                            if (xVar == x.STRICT) {
                                h.a0(b02).b(longValue, this);
                            } else {
                                I().b(longValue, this);
                            }
                        }
                        c2 = b02.h0(longValue - 1).c(a3, aVar);
                    }
                    map.remove(this);
                    map.remove(qVar);
                    map.remove(aVar);
                    return c2;
                }
                throw new RuntimeException("Resolve requires IsoChronology");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.q
            public final u I() {
                return a.YEAR.f2650b;
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.f2658a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f2522c);
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: WeekBasedYear");
                }
                return h.Y(j$.time.h.F(temporalAccessor));
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: WeekBasedYear");
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j2) {
                if (!s(mVar)) {
                    throw new RuntimeException("Unsupported field: WeekBasedYear");
                }
                int a2 = a.YEAR.f2650b.a(j2, h.WEEK_BASED_YEAR);
                j$.time.h F2 = j$.time.h.F(mVar);
                int g2 = F2.g(a.DAY_OF_WEEK);
                int X2 = h.X(F2);
                if (X2 == 53 && h.Z(a2) == 52) {
                    X2 = 52;
                }
                return mVar.m(j$.time.h.b0(a2, 1, 4).f0(((X2 - 1) * 7) + (g2 - r6.g(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f2655b = new h[]{hVar, hVar2, hVar3, hVar4};
        f2654a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static u a0(j$.time.h hVar) {
        return u.f(1L, Z(Y(hVar)));
    }

    public static int Z(int i2) {
        j$.time.h b02 = j$.time.h.b0(i2, 1, 1);
        if (b02.P() != DayOfWeek.THURSDAY) {
            return (b02.P() == DayOfWeek.WEDNESDAY && b02.Y()) ? 53 : 52;
        }
        return 53;
    }

    public static int X(j$.time.h hVar) {
        int ordinal = hVar.P().ordinal();
        int V2 = hVar.V() - 1;
        int i2 = (3 - ordinal) + V2;
        int i3 = i2 - ((i2 / 7) * 7);
        int i4 = i3 - 3;
        if (i4 < -3) {
            i4 = i3 + 4;
        }
        if (V2 >= i4) {
            int i5 = ((V2 - i4) / 7) + 1;
            if (i5 != 53 || i4 == -3 || (i4 == -2 && hVar.Y())) {
                return i5;
            }
            return 1;
        }
        if (hVar.V() != 180) {
            hVar = j$.time.h.d0(hVar.f2616a, 180);
        }
        return (int) a0(hVar.i0(-1L)).f2678d;
    }

    public static int Y(j$.time.h hVar) {
        int i2 = hVar.f2616a;
        int V2 = hVar.V();
        if (V2 <= 3) {
            return V2 - hVar.P().ordinal() < -2 ? i2 - 1 : i2;
        }
        if (V2 >= 363) {
            return ((V2 - 363) - (hVar.Y() ? 1 : 0)) - hVar.P().ordinal() >= 0 ? i2 + 1 : i2;
        }
        return i2;
    }
}
