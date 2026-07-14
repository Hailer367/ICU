package H0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: f, reason: collision with root package name */
    public static final p f638f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ p[] f639g;

    /* JADX INFO: Fake field, exist only in values array */
    p EF0;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, H0.p] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, H0.p] */
    static {
        ?? r02 = new Enum("UNKNOWN", 0);
        ?? r12 = new Enum("ANDROID_FIREBASE", 1);
        f638f = r12;
        f639g = new p[]{r02, r12};
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) f639g.clone();
    }
}
