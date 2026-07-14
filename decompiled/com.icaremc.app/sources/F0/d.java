package F0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static final d f526f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f527g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f528h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ d[] f529i;

    /* JADX WARN: Type inference failed for: r0v0, types: [F0.d, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [F0.d, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [F0.d, java.lang.Enum] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f526f = r02;
        ?? r12 = new Enum("VERY_LOW", 1);
        f527g = r12;
        ?? r22 = new Enum("HIGHEST", 2);
        f528h = r22;
        f529i = new d[]{r02, r12, r22};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f529i.clone();
    }
}
