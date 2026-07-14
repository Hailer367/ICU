package s0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f3585c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f3586d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f3587e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ d[] f3588f;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, s0.d] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, s0.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, s0.d] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f3585c = r02;
        ?? r1 = new Enum("VERY_LOW", 1);
        f3586d = r1;
        ?? r2 = new Enum("HIGHEST", 2);
        f3587e = r2;
        f3588f = new d[]{r02, r1, r2};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f3588f.clone();
    }
}
