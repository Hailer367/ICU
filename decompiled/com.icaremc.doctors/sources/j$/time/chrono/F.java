package j$.time.chrono;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class F {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2484a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f2484a = iArr;
        try {
            iArr[j$.time.temporal.a.PROLEPTIC_MONTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2484a[j$.time.temporal.a.YEAR_OF_ERA.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2484a[j$.time.temporal.a.YEAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
