package L2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f1019f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ a[] f1020g;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, L2.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, L2.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, L2.a] */
    static {
        ?? r02 = new Enum("COROUTINE_SUSPENDED", 0);
        f1019f = r02;
        f1020g = new a[]{r02, new Enum("UNDECIDED", 1), new Enum("RESUMED", 2)};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f1020g.clone();
    }
}
