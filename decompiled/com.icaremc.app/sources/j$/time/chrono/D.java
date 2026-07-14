package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class D implements m {
    public static final D BEFORE_ROC;
    public static final D ROC;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ D[] f4579a;

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) f4579a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.chrono.D] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.chrono.D] */
    static {
        ?? r02 = new Enum("BEFORE_ROC", 0);
        BEFORE_ROC = r02;
        ?? r12 = new Enum("ROC", 1);
        ROC = r12;
        f4579a = new D[]{r02, r12};
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return ordinal();
    }
}
