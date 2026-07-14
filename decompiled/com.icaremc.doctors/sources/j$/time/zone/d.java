package j$.time.zone;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class d {
    public static final d STANDARD;
    public static final d UTC;
    public static final d WALL;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ d[] f2700a;

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f2700a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.zone.d] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.zone.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, j$.time.zone.d] */
    static {
        ?? r02 = new Enum("UTC", 0);
        UTC = r02;
        ?? r1 = new Enum("WALL", 1);
        WALL = r1;
        ?? r2 = new Enum("STANDARD", 2);
        STANDARD = r2;
        f2700a = new d[]{r02, r1, r2};
    }
}
