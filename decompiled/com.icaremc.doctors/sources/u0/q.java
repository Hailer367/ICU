package u0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    public static final q f3876c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ q[] f3877d;

    /* JADX INFO: Fake field, exist only in values array */
    q EF0;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, u0.q] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, u0.q] */
    static {
        ?? r02 = new Enum("UNKNOWN", 0);
        ?? r1 = new Enum("ANDROID_FIREBASE", 1);
        f3876c = r1;
        f3877d = new q[]{r02, r1};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f3877d.clone();
    }
}
