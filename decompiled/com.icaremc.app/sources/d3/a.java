package d3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f3492f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f3493g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f3494h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ a[] f3495i;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, d3.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, d3.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, d3.a] */
    static {
        ?? r02 = new Enum("SUSPEND", 0);
        f3492f = r02;
        ?? r12 = new Enum("DROP_OLDEST", 1);
        f3493g = r12;
        ?? r22 = new Enum("DROP_LATEST", 2);
        f3494h = r22;
        f3495i = new a[]{r02, r12, r22};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f3495i.clone();
    }
}
