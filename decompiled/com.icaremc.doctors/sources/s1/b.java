package s1;

import a.AbstractC0051a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f3598c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f3599d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f3600e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f3601f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f3602g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ b[] f3603h;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, s1.b] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, s1.b] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, s1.b] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, s1.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, s1.b] */
    static {
        ?? r02 = new Enum("CPU_ACQUIRED", 0);
        f3598c = r02;
        ?? r1 = new Enum("BLOCKING", 1);
        f3599d = r1;
        ?? r2 = new Enum("PARKING", 2);
        f3600e = r2;
        ?? r3 = new Enum("DORMANT", 3);
        f3601f = r3;
        ?? r4 = new Enum("TERMINATED", 4);
        f3602g = r4;
        b[] bVarArr = {r02, r1, r2, r3, r4};
        f3603h = bVarArr;
        AbstractC0051a.t(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f3603h.clone();
    }
}
