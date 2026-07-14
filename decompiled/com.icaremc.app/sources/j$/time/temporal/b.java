package j$.time.temporal;

/* loaded from: classes2.dex */
public enum b implements s {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");


    /* renamed from: a, reason: collision with root package name */
    public final String f4749a;

    static {
        j$.time.e.F(1L);
        j$.time.e.F(1000L);
        j$.time.e.F(1000000L);
        j$.time.e.A(1L, 0);
        j$.time.e.A(60L, 0);
        j$.time.e.A(3600L, 0);
        j$.time.e.A(43200L, 0);
        j$.time.e.A(86400L, 0);
        j$.time.e.A(604800L, 0);
        j$.time.e.A(2629746L, 0);
        j$.time.e.A(31556952L, 0);
        j$.time.e.A(315569520L, 0);
        j$.time.e.A(3155695200L, 0);
        j$.time.e.A(31556952000L, 0);
        j$.time.e.A(31556952000000000L, 0);
        j$.time.e.A(Math.addExact(Long.MAX_VALUE, Math.floorDiv(999999999L, 1000000000L)), (int) Math.floorMod(999999999L, 1000000000L));
    }

    b(String str) {
        this.f4749a = str;
    }

    @Override // j$.time.temporal.s
    public final m s(m mVar, long j4) {
        return mVar.d(j4, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4749a;
    }
}
