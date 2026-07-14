package b3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: b3.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0244t {

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC0244t f3296f;

    /* renamed from: g, reason: collision with root package name */
    public static final EnumC0244t f3297g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumC0244t[] f3298h;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, b3.t] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, b3.t] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, b3.t] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, b3.t] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f3296f = r02;
        ?? r12 = new Enum("LAZY", 1);
        ?? r22 = new Enum("ATOMIC", 2);
        f3297g = r22;
        f3298h = new EnumC0244t[]{r02, r12, r22, new Enum("UNDISPATCHED", 3)};
    }

    public static EnumC0244t valueOf(String str) {
        return (EnumC0244t) Enum.valueOf(EnumC0244t.class, str);
    }

    public static EnumC0244t[] values() {
        return (EnumC0244t[]) f3298h.clone();
    }
}
