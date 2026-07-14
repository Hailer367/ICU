package j$.time.temporal;

/* loaded from: classes2.dex */
public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* renamed from: a, reason: collision with root package name */
    public final String f2657a;

    static {
        j$.time.e.A(31556952L, 0);
        j$.time.e.A(7889238L, 0);
    }

    i(String str) {
        this.f2657a = str;
    }

    @Override // j$.time.temporal.s
    public final m s(m mVar, long j2) {
        int i2 = c.f2653a[ordinal()];
        if (i2 == 1) {
            return mVar.c(Math.addExact(mVar.g(r0), j2), j.f2660c);
        }
        if (i2 == 2) {
            return mVar.d(j2 / 4, b.YEARS).d((j2 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f2657a;
    }
}
