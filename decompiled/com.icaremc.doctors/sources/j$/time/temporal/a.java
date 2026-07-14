package j$.time.temporal;

/* loaded from: classes2.dex */
public enum a implements q {
    NANO_OF_SECOND("NanoOfSecond", u.f(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", u.f(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", u.f(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", u.f(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", u.f(0, 999)),
    MILLI_OF_DAY("MilliOfDay", u.f(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", u.f(0, 59), 0),
    SECOND_OF_DAY("SecondOfDay", u.f(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", u.f(0, 59), 0),
    MINUTE_OF_DAY("MinuteOfDay", u.f(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", u.f(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", u.f(1, 12)),
    HOUR_OF_DAY("HourOfDay", u.f(0, 23), 0),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", u.f(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", u.f(0, 1), 0),
    DAY_OF_WEEK("DayOfWeek", u.f(1, 7), 0),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", u.f(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", u.f(1, 7)),
    DAY_OF_MONTH("DayOfMonth", u.g(28, 31), 0),
    DAY_OF_YEAR("DayOfYear", u.g(365, 366)),
    EPOCH_DAY("EpochDay", u.f(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", u.g(4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", u.f(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", u.f(1, 12), 0),
    PROLEPTIC_MONTH("ProlepticMonth", u.f(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", u.g(999999999, 1000000000)),
    YEAR("Year", u.f(-999999999, 999999999), 0),
    ERA("Era", u.f(0, 1), 0),
    INSTANT_SECONDS("InstantSeconds", u.f(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", u.f(-64800, 64800));


    /* renamed from: a, reason: collision with root package name */
    public final String f2649a;

    /* renamed from: b, reason: collision with root package name */
    public final u f2650b;

    static {
        b bVar = b.NANOS;
    }

    a(String str, u uVar) {
        this.f2649a = str;
        this.f2650b = uVar;
    }

    a(String str, u uVar, int i2) {
        this.f2649a = str;
        this.f2650b = uVar;
    }

    @Override // j$.time.temporal.q
    public final u I() {
        return this.f2650b;
    }

    public final void X(long j2) {
        this.f2650b.b(j2, this);
    }

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public final boolean Y() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    @Override // j$.time.temporal.q
    public final boolean s(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(this);
    }

    @Override // j$.time.temporal.q
    public final u A(TemporalAccessor temporalAccessor) {
        return temporalAccessor.l(this);
    }

    @Override // j$.time.temporal.q
    public final long P(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(this);
    }

    @Override // j$.time.temporal.q
    public final m V(m mVar, long j2) {
        return mVar.c(j2, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f2649a;
    }
}
