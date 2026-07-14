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
    public static final int[] f4751a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f4752b;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f4752b.clone();
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
                h hVar2 = j.f4755a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f4619c);
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: DayOfQuarter");
                }
                long i4 = temporalAccessor.i(h.QUARTER_OF_YEAR);
                if (i4 == 1) {
                    long i5 = temporalAccessor.i(a.YEAR);
                    j$.time.chrono.s.f4619c.getClass();
                    return j$.time.chrono.s.X(i5) ? u.f(1L, 91L) : u.f(1L, 90L);
                }
                if (i4 == 2) {
                    return u.f(1L, 91L);
                }
                if (i4 == 3 || i4 == 4) {
                    return u.f(1L, 92L);
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new RuntimeException("Unsupported field: DayOfQuarter");
                }
                int g4 = temporalAccessor.g(a.DAY_OF_YEAR);
                int g5 = temporalAccessor.g(a.MONTH_OF_YEAR);
                long i4 = temporalAccessor.i(a.YEAR);
                int i5 = (g5 - 1) / 3;
                j$.time.chrono.s.f4619c.getClass();
                return g4 - h.f4751a[i5 + (j$.time.chrono.s.X(i4) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j4) {
                long P = P(mVar);
                I().b(j4, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.c((j4 - P) + mVar.i(aVar), aVar);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor F(Map map, w wVar, x xVar) {
                long j4;
                j$.time.h hVar2;
                a aVar = a.YEAR;
                Long l3 = (Long) map.get(aVar);
                q qVar = h.QUARTER_OF_YEAR;
                Long l4 = (Long) map.get(qVar);
                if (l3 == null || l4 == null) {
                    return null;
                }
                int a4 = aVar.f4747b.a(l3.longValue(), aVar);
                long longValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                h hVar3 = j.f4755a;
                if (j$.time.chrono.l.r(wVar).equals(j$.time.chrono.s.f4619c)) {
                    if (xVar == x.LENIENT) {
                        hVar2 = j$.time.h.b0(a4, 1, 1).g0(Math.multiplyExact(Math.subtractExact(l4.longValue(), 1L), 3));
                        j4 = Math.subtractExact(longValue, 1L);
                    } else {
                        j$.time.h b02 = j$.time.h.b0(a4, ((qVar.I().a(l4.longValue(), qVar) - 1) * 3) + 1, 1);
                        if (longValue < 1 || longValue > 90) {
                            if (xVar == x.STRICT) {
                                A(b02).b(longValue, this);
                            } else {
                                I().b(longValue, this);
                            }
                        }
                        j4 = longValue - 1;
                        hVar2 = b02;
                    }
                    map.remove(this);
                    map.remove(aVar);
                    map.remove(qVar);
                    return hVar2.f0(j4);
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
                h hVar3 = j.f4755a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f4619c);
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
            public final m V(m mVar, long j4) {
                long P = P(mVar);
                I().b(j4, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.c(((j4 - P) * 3) + mVar.i(aVar), aVar);
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
                h hVar4 = j.f4755a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f4619c);
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
            public final m V(m mVar, long j4) {
                I().b(j4, this);
                return mVar.d(Math.subtractExact(j4, P(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor F(Map map, w wVar, x xVar) {
                j$.time.h c4;
                long j4;
                long j5;
                q qVar = h.WEEK_BASED_YEAR;
                Long l3 = (Long) map.get(qVar);
                a aVar = a.DAY_OF_WEEK;
                Long l4 = (Long) map.get(aVar);
                if (l3 == null || l4 == null) {
                    return null;
                }
                int a4 = qVar.I().a(l3.longValue(), qVar);
                long longValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                h hVar4 = j.f4755a;
                if (j$.time.chrono.l.r(wVar).equals(j$.time.chrono.s.f4619c)) {
                    j$.time.h b02 = j$.time.h.b0(a4, 1, 4);
                    if (xVar == x.LENIENT) {
                        long longValue2 = l4.longValue();
                        if (longValue2 > 7) {
                            long j6 = longValue2 - 1;
                            j4 = 1;
                            b02 = b02.h0(j6 / 7);
                            j5 = j6 % 7;
                        } else {
                            j4 = 1;
                            if (longValue2 < 1) {
                                b02 = b02.h0(Math.subtractExact(longValue2, 7L) / 7);
                                j5 = (longValue2 + 6) % 7;
                            }
                            c4 = b02.h0(Math.subtractExact(longValue, j4)).c(longValue2, aVar);
                        }
                        longValue2 = j5 + j4;
                        c4 = b02.h0(Math.subtractExact(longValue, j4)).c(longValue2, aVar);
                    } else {
                        int a5 = aVar.f4747b.a(l4.longValue(), aVar);
                        if (longValue < 1 || longValue > 52) {
                            if (xVar == x.STRICT) {
                                h.a0(b02).b(longValue, this);
                            } else {
                                I().b(longValue, this);
                            }
                        }
                        c4 = b02.h0(longValue - 1).c(a5, aVar);
                    }
                    map.remove(this);
                    map.remove(qVar);
                    map.remove(aVar);
                    return c4;
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
                return a.YEAR.f4747b;
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.f4755a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f4619c);
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
            public final m V(m mVar, long j4) {
                if (!s(mVar)) {
                    throw new RuntimeException("Unsupported field: WeekBasedYear");
                }
                int a4 = a.YEAR.f4747b.a(j4, h.WEEK_BASED_YEAR);
                j$.time.h F3 = j$.time.h.F(mVar);
                int g4 = F3.g(a.DAY_OF_WEEK);
                int X3 = h.X(F3);
                if (X3 == 53 && h.Z(a4) == 52) {
                    X3 = 52;
                }
                return mVar.m(j$.time.h.b0(a4, 1, 4).f0(((X3 - 1) * 7) + (g4 - r6.g(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f4752b = new h[]{hVar, hVar2, hVar3, hVar4};
        f4751a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static u a0(j$.time.h hVar) {
        return u.f(1L, Z(Y(hVar)));
    }

    public static int Z(int i4) {
        j$.time.h b02 = j$.time.h.b0(i4, 1, 1);
        if (b02.P() != DayOfWeek.THURSDAY) {
            return (b02.P() == DayOfWeek.WEDNESDAY && b02.Y()) ? 53 : 52;
        }
        return 53;
    }

    public static int X(j$.time.h hVar) {
        int ordinal = hVar.P().ordinal();
        int V3 = hVar.V() - 1;
        int i4 = (3 - ordinal) + V3;
        int i5 = i4 - ((i4 / 7) * 7);
        int i6 = i5 - 3;
        if (i6 < -3) {
            i6 = i5 + 4;
        }
        if (V3 >= i6) {
            int i7 = ((V3 - i6) / 7) + 1;
            if (i7 != 53 || i6 == -3 || (i6 == -2 && hVar.Y())) {
                return i7;
            }
            return 1;
        }
        if (hVar.V() != 180) {
            hVar = j$.time.h.d0(hVar.f4713a, 180);
        }
        return (int) a0(hVar.i0(-1L)).f4775d;
    }

    public static int Y(j$.time.h hVar) {
        int i4 = hVar.f4713a;
        int V3 = hVar.V();
        if (V3 <= 3) {
            return V3 - hVar.P().ordinal() < -2 ? i4 - 1 : i4;
        }
        if (V3 >= 363) {
            return ((V3 - 363) - (hVar.Y() ? 1 : 0)) - hVar.P().ordinal() >= 0 ? i4 + 1 : i4;
        }
        return i4;
    }
}
