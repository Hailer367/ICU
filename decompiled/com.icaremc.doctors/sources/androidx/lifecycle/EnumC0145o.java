package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.lifecycle.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0145o {

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0145o f1844c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0145o f1845d;

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0145o f1846e;

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC0145o f1847f;

    /* renamed from: g, reason: collision with root package name */
    public static final EnumC0145o f1848g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumC0145o[] f1849h;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.lifecycle.o] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.lifecycle.o] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.lifecycle.o] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.lifecycle.o] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.lifecycle.o] */
    static {
        ?? r02 = new Enum("DESTROYED", 0);
        f1844c = r02;
        ?? r1 = new Enum("INITIALIZED", 1);
        f1845d = r1;
        ?? r2 = new Enum("CREATED", 2);
        f1846e = r2;
        ?? r3 = new Enum("STARTED", 3);
        f1847f = r3;
        ?? r4 = new Enum("RESUMED", 4);
        f1848g = r4;
        f1849h = new EnumC0145o[]{r02, r1, r2, r3, r4};
    }

    public static EnumC0145o valueOf(String str) {
        return (EnumC0145o) Enum.valueOf(EnumC0145o.class, str);
    }

    public static EnumC0145o[] values() {
        return (EnumC0145o[]) f1849h.clone();
    }
}
