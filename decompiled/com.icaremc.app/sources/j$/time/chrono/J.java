package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class J implements m {
    public static final J BE;
    public static final J BEFORE_BE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ J[] f4586a;

    public static J valueOf(String str) {
        return (J) Enum.valueOf(J.class, str);
    }

    public static J[] values() {
        return (J[]) f4586a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.chrono.J] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.chrono.J] */
    static {
        ?? r02 = new Enum("BEFORE_BE", 0);
        BEFORE_BE = r02;
        ?? r12 = new Enum("BE", 1);
        BE = r12;
        f4586a = new J[]{r02, r12};
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return ordinal();
    }
}
