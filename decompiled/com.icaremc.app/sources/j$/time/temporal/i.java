package j$.time.temporal;

/* loaded from: classes2.dex */
public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* renamed from: a, reason: collision with root package name */
    public final String f4754a;

    static {
        j$.time.e.A(31556952L, 0);
        j$.time.e.A(7889238L, 0);
    }

    i(String str) {
        this.f4754a = str;
    }

    @Override // j$.time.temporal.s
    public final m s(m mVar, long j4) {
        int i4 = c.f4750a[ordinal()];
        if (i4 == 1) {
            return mVar.c(Math.addExact(mVar.g(r0), j4), j.f4757c);
        }
        if (i4 == 2) {
            return mVar.d(j4 / 4, b.YEARS).d((j4 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4754a;
    }
}
