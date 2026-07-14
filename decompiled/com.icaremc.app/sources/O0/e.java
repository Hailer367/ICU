package O0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: f, reason: collision with root package name */
    public static final e f1272f;

    /* renamed from: g, reason: collision with root package name */
    public static final e f1273g;

    /* renamed from: h, reason: collision with root package name */
    public static final e f1274h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ e[] f1275i;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, O0.e] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, O0.e] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, O0.e] */
    static {
        ?? r02 = new Enum("NETWORK_UNMETERED", 0);
        f1272f = r02;
        ?? r12 = new Enum("DEVICE_IDLE", 1);
        f1273g = r12;
        ?? r22 = new Enum("DEVICE_CHARGING", 2);
        f1274h = r22;
        f1275i = new e[]{r02, r12, r22};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f1275i.clone();
    }
}
