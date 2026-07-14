package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0207n {

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC0207n f3014f;

    /* renamed from: g, reason: collision with root package name */
    public static final EnumC0207n f3015g;

    /* renamed from: h, reason: collision with root package name */
    public static final EnumC0207n f3016h;

    /* renamed from: i, reason: collision with root package name */
    public static final EnumC0207n f3017i;

    /* renamed from: j, reason: collision with root package name */
    public static final EnumC0207n f3018j;
    public static final /* synthetic */ EnumC0207n[] k;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    static {
        ?? r02 = new Enum("DESTROYED", 0);
        f3014f = r02;
        ?? r12 = new Enum("INITIALIZED", 1);
        f3015g = r12;
        ?? r22 = new Enum("CREATED", 2);
        f3016h = r22;
        ?? r3 = new Enum("STARTED", 3);
        f3017i = r3;
        ?? r4 = new Enum("RESUMED", 4);
        f3018j = r4;
        k = new EnumC0207n[]{r02, r12, r22, r3, r4};
    }

    public static EnumC0207n valueOf(String str) {
        return (EnumC0207n) Enum.valueOf(EnumC0207n.class, str);
    }

    public static EnumC0207n[] values() {
        return (EnumC0207n[]) k.clone();
    }
}
