package B0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f89c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f90d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f91e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ f[] f92f;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, B0.f] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, B0.f] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, B0.f] */
    static {
        ?? r02 = new Enum("NETWORK_UNMETERED", 0);
        f89c = r02;
        ?? r1 = new Enum("DEVICE_IDLE", 1);
        f90d = r1;
        ?? r2 = new Enum("DEVICE_CHARGING", 2);
        f91e = r2;
        f92f = new f[]{r02, r1, r2};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f92f.clone();
    }
}
