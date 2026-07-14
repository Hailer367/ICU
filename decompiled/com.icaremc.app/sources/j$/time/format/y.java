package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class y {
    public static final y ALWAYS;
    public static final y EXCEEDS_PAD;
    public static final y NEVER;
    public static final y NORMAL;
    public static final y NOT_NEGATIVE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ y[] f4707a;

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) f4707a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.format.y, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [j$.time.format.y, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [j$.time.format.y, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v2, types: [j$.time.format.y, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r4v2, types: [j$.time.format.y, java.lang.Enum] */
    static {
        ?? r02 = new Enum("NORMAL", 0);
        NORMAL = r02;
        ?? r12 = new Enum("ALWAYS", 1);
        ALWAYS = r12;
        ?? r22 = new Enum("NEVER", 2);
        NEVER = r22;
        ?? r3 = new Enum("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = r3;
        ?? r4 = new Enum("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = r4;
        f4707a = new y[]{r02, r12, r22, r3, r4};
    }
}
