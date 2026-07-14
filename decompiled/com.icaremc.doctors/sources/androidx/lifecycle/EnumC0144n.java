package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0144n {
    private static final /* synthetic */ EnumC0144n[] $VALUES;
    public static final C0142l Companion;
    public static final EnumC0144n ON_ANY;
    public static final EnumC0144n ON_CREATE;
    public static final EnumC0144n ON_DESTROY;
    public static final EnumC0144n ON_PAUSE;
    public static final EnumC0144n ON_RESUME;
    public static final EnumC0144n ON_START;
    public static final EnumC0144n ON_STOP;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.lifecycle.l] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    static {
        ?? r02 = new Enum("ON_CREATE", 0);
        ON_CREATE = r02;
        ?? r1 = new Enum("ON_START", 1);
        ON_START = r1;
        ?? r2 = new Enum("ON_RESUME", 2);
        ON_RESUME = r2;
        ?? r3 = new Enum("ON_PAUSE", 3);
        ON_PAUSE = r3;
        ?? r4 = new Enum("ON_STOP", 4);
        ON_STOP = r4;
        ?? r5 = new Enum("ON_DESTROY", 5);
        ON_DESTROY = r5;
        ?? r6 = new Enum("ON_ANY", 6);
        ON_ANY = r6;
        $VALUES = new EnumC0144n[]{r02, r1, r2, r3, r4, r5, r6};
        Companion = new Object();
    }

    public static EnumC0144n valueOf(String str) {
        return (EnumC0144n) Enum.valueOf(EnumC0144n.class, str);
    }

    public static EnumC0144n[] values() {
        return (EnumC0144n[]) $VALUES.clone();
    }

    public final EnumC0145o a() {
        switch (AbstractC0143m.f1843a[ordinal()]) {
            case 1:
            case 2:
                return EnumC0145o.f1846e;
            case 3:
            case 4:
                return EnumC0145o.f1847f;
            case 5:
                return EnumC0145o.f1848g;
            case 6:
                return EnumC0145o.f1844c;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
