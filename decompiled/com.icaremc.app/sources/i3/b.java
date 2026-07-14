package i3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f4157f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f4158g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f4159h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f4160i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f4161j;
    public static final /* synthetic */ b[] k;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, i3.b] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, i3.b] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, i3.b] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, i3.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, i3.b] */
    static {
        ?? r02 = new Enum("CPU_ACQUIRED", 0);
        f4157f = r02;
        ?? r12 = new Enum("BLOCKING", 1);
        f4158g = r12;
        ?? r22 = new Enum("PARKING", 2);
        f4159h = r22;
        ?? r3 = new Enum("DORMANT", 3);
        f4160i = r3;
        ?? r4 = new Enum("TERMINATED", 4);
        f4161j = r4;
        k = new b[]{r02, r12, r22, r3, r4};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) k.clone();
    }
}
