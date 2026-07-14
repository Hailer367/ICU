package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class x {
    public static final x LENIENT;
    public static final x SMART;
    public static final x STRICT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ x[] f4706a;

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f4706a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.format.x, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [j$.time.format.x, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [j$.time.format.x, java.lang.Enum] */
    static {
        ?? r02 = new Enum("STRICT", 0);
        STRICT = r02;
        ?? r12 = new Enum("SMART", 1);
        SMART = r12;
        ?? r22 = new Enum("LENIENT", 2);
        LENIENT = r22;
        f4706a = new x[]{r02, r12, r22};
    }
}
