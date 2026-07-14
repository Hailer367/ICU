package j$.time;

import j$.time.temporal.TemporalAccessor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class n implements TemporalAccessor, j$.time.temporal.n {
    public static final n APRIL;
    public static final n AUGUST;
    public static final n DECEMBER;
    public static final n FEBRUARY;
    public static final n JANUARY;
    public static final n JULY;
    public static final n JUNE;
    public static final n MARCH;
    public static final n MAY;
    public static final n NOVEMBER;
    public static final n OCTOBER;
    public static final n SEPTEMBER;

    /* renamed from: a, reason: collision with root package name */
    public static final n[] f2632a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ n[] f2633b;

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f2633b.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, j$.time.n] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, j$.time.n] */
    static {
        ?? r02 = new Enum("JANUARY", 0);
        JANUARY = r02;
        ?? r1 = new Enum("FEBRUARY", 1);
        FEBRUARY = r1;
        ?? r2 = new Enum("MARCH", 2);
        MARCH = r2;
        ?? r3 = new Enum("APRIL", 3);
        APRIL = r3;
        ?? r4 = new Enum("MAY", 4);
        MAY = r4;
        ?? r5 = new Enum("JUNE", 5);
        JUNE = r5;
        ?? r6 = new Enum("JULY", 6);
        JULY = r6;
        ?? r7 = new Enum("AUGUST", 7);
        AUGUST = r7;
        ?? r8 = new Enum("SEPTEMBER", 8);
        SEPTEMBER = r8;
        ?? r9 = new Enum("OCTOBER", 9);
        OCTOBER = r9;
        ?? r10 = new Enum("NOVEMBER", 10);
        NOVEMBER = r10;
        ?? r11 = new Enum("DECEMBER", 11);
        DECEMBER = r11;
        f2633b = new n[]{r02, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        f2632a = values();
    }

    public static n I(int i2) {
        if (i2 < 1 || i2 > 12) {
            throw new RuntimeException("Invalid value for MonthOfYear: " + i2);
        }
        return f2632a[i2 - 1];
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.MONTH_OF_YEAR : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return qVar.I();
        }
        return super.l(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return getValue();
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new RuntimeException(d.a("Unsupported field: ", qVar));
        }
        return qVar.P(this);
    }

    public final int A(boolean z) {
        int i2 = m.f2631a[ordinal()];
        return i2 != 1 ? (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) ? 30 : 31 : z ? 29 : 28;
    }

    public final int F() {
        int i2 = m.f2631a[ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) ? 30 : 31;
        }
        return 29;
    }

    public final int s(boolean z) {
        switch (m.f2631a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z ? 1 : 0) + 91;
            case 3:
                return (z ? 1 : 0) + 152;
            case 4:
                return (z ? 1 : 0) + 244;
            case 5:
                return (z ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z ? 1 : 0) + 60;
            case 8:
                return (z ? 1 : 0) + 121;
            case 9:
                return (z ? 1 : 0) + 182;
            case 10:
                return (z ? 1 : 0) + 213;
            case 11:
                return (z ? 1 : 0) + 274;
            default:
                return (z ? 1 : 0) + 335;
        }
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f2669b) {
            return j$.time.chrono.s.f2522c;
        }
        if (iVar == j$.time.temporal.r.f2670c) {
            return j$.time.temporal.b.MONTHS;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.r(mVar).equals(j$.time.chrono.s.f2522c)) {
            throw new RuntimeException("Adjustment only supported on ISO date-time");
        }
        return mVar.c(getValue(), j$.time.temporal.a.MONTH_OF_YEAR);
    }
}
