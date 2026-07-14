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
    public static final n[] f4729a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ n[] f4730b;

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f4730b.clone();
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
        ?? r12 = new Enum("FEBRUARY", 1);
        FEBRUARY = r12;
        ?? r22 = new Enum("MARCH", 2);
        MARCH = r22;
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
        f4730b = new n[]{r02, r12, r22, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        f4729a = values();
    }

    public static n I(int i4) {
        if (i4 < 1 || i4 > 12) {
            throw new RuntimeException("Invalid value for MonthOfYear: " + i4);
        }
        return f4729a[i4 - 1];
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
        int i4 = m.f4728a[ordinal()];
        return i4 != 1 ? (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) ? 30 : 31 : z ? 29 : 28;
    }

    public final int F() {
        int i4 = m.f4728a[ordinal()];
        if (i4 != 1) {
            return (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) ? 30 : 31;
        }
        return 29;
    }

    public final int s(boolean z) {
        switch (m.f4728a[ordinal()]) {
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
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return (z ? 1 : 0) + 60;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
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
        if (iVar == j$.time.temporal.r.f4766b) {
            return j$.time.chrono.s.f4619c;
        }
        if (iVar == j$.time.temporal.r.f4767c) {
            return j$.time.temporal.b.MONTHS;
        }
        return super.b(iVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.r(mVar).equals(j$.time.chrono.s.f4619c)) {
            throw new RuntimeException("Adjustment only supported on ISO date-time");
        }
        return mVar.c(getValue(), j$.time.temporal.a.MONTH_OF_YEAR);
    }
}
