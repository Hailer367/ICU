package j$.time;

import j$.time.temporal.TemporalAccessor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class DayOfWeek implements TemporalAccessor, j$.time.temporal.n {
    public static final DayOfWeek FRIDAY;
    public static final DayOfWeek MONDAY;
    public static final DayOfWeek SATURDAY;
    public static final DayOfWeek SUNDAY;
    public static final DayOfWeek THURSDAY;
    public static final DayOfWeek TUESDAY;
    public static final DayOfWeek WEDNESDAY;

    /* renamed from: a, reason: collision with root package name */
    public static final DayOfWeek[] f2454a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ DayOfWeek[] f2455b;

    public static DayOfWeek valueOf(String str) {
        return (DayOfWeek) Enum.valueOf(DayOfWeek.class, str);
    }

    public static DayOfWeek[] values() {
        return (DayOfWeek[]) f2455b.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.DayOfWeek, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [j$.time.DayOfWeek, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [j$.time.DayOfWeek, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v2, types: [j$.time.DayOfWeek, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r4v2, types: [j$.time.DayOfWeek, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v2, types: [j$.time.DayOfWeek, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r6v2, types: [j$.time.DayOfWeek, java.lang.Enum] */
    static {
        ?? r02 = new Enum("MONDAY", 0);
        MONDAY = r02;
        ?? r1 = new Enum("TUESDAY", 1);
        TUESDAY = r1;
        ?? r2 = new Enum("WEDNESDAY", 2);
        WEDNESDAY = r2;
        ?? r3 = new Enum("THURSDAY", 3);
        THURSDAY = r3;
        ?? r4 = new Enum("FRIDAY", 4);
        FRIDAY = r4;
        ?? r5 = new Enum("SATURDAY", 5);
        SATURDAY = r5;
        ?? r6 = new Enum("SUNDAY", 6);
        SUNDAY = r6;
        f2455b = new DayOfWeek[]{r02, r1, r2, r3, r4, r5, r6};
        f2454a = values();
    }

    public static DayOfWeek s(int i2) {
        if (i2 < 1 || i2 > 7) {
            throw new RuntimeException("Invalid value for DayOfWeek: " + i2);
        }
        return f2454a[i2 - 1];
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.DAY_OF_WEEK : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return qVar.I();
        }
        return super.l(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return getValue();
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.DAYS;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(getValue(), j$.time.temporal.a.DAY_OF_WEEK);
    }
}
