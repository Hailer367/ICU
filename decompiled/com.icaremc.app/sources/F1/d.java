package F1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static final d f532f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ d[] f533g;

    /* JADX WARN: Type inference failed for: r0v0, types: [F1.d, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [F1.d, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [F1.d, java.lang.Enum] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f532f = r02;
        f533g = new d[]{r02, new Enum("SIGNED", 1), new Enum("FIXED", 2)};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f533g.clone();
    }
}
