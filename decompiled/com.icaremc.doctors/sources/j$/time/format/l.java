package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class l implements e {
    public static final l INSENSITIVE;
    public static final l LENIENT;
    public static final l SENSITIVE;
    public static final l STRICT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ l[] f2575a;

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        return true;
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f2575a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.format.l] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.format.l] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, j$.time.format.l] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, j$.time.format.l] */
    static {
        ?? r02 = new Enum("SENSITIVE", 0);
        SENSITIVE = r02;
        ?? r1 = new Enum("INSENSITIVE", 1);
        INSENSITIVE = r1;
        ?? r2 = new Enum("STRICT", 2);
        STRICT = r2;
        ?? r3 = new Enum("LENIENT", 3);
        LENIENT = r3;
        f2575a = new l[]{r02, r1, r2, r3};
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i2) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            pVar.f2588b = true;
            return i2;
        }
        if (ordinal == 1) {
            pVar.f2588b = false;
            return i2;
        }
        if (ordinal == 2) {
            pVar.f2589c = true;
            return i2;
        }
        if (ordinal != 3) {
            return i2;
        }
        pVar.f2589c = false;
        return i2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return "ParseCaseSensitive(true)";
        }
        if (ordinal == 1) {
            return "ParseCaseSensitive(false)";
        }
        if (ordinal == 2) {
            return "ParseStrict(true)";
        }
        if (ordinal == 3) {
            return "ParseStrict(false)";
        }
        throw new IllegalStateException("Unreachable");
    }
}
