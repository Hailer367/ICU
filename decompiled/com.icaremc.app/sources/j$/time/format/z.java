package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class z {
    public static final z FULL;
    public static final z FULL_STANDALONE;
    public static final z NARROW;
    public static final z NARROW_STANDALONE;
    public static final z SHORT;
    public static final z SHORT_STANDALONE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ z[] f4708a;

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) f4708a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.format.z] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.format.z] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, j$.time.format.z] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, j$.time.format.z] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, j$.time.format.z] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, j$.time.format.z] */
    static {
        ?? r02 = new Enum("FULL", 0);
        FULL = r02;
        ?? r12 = new Enum("FULL_STANDALONE", 1);
        FULL_STANDALONE = r12;
        ?? r22 = new Enum("SHORT", 2);
        SHORT = r22;
        ?? r3 = new Enum("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = r3;
        ?? r4 = new Enum("NARROW", 4);
        NARROW = r4;
        ?? r5 = new Enum("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = r5;
        f4708a = new z[]{r02, r12, r22, r3, r4, r5};
    }
}
