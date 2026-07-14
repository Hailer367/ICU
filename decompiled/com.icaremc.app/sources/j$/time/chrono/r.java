package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class r implements m {
    public static final r AH;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ r[] f4618a;

    @Override // j$.time.chrono.m
    public final int getValue() {
        return 1;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f4618a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.chrono.r] */
    static {
        ?? r02 = new Enum("AH", 0);
        AH = r02;
        f4618a = new r[]{r02};
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return j$.time.temporal.u.f(1L, 1L);
        }
        return super.l(qVar);
    }
}
