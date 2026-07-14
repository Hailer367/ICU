package n1;

import a.AbstractC0051a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3306c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f3307d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f3308e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ a[] f3309f;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, n1.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, n1.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, n1.a] */
    static {
        ?? r02 = new Enum("SUSPEND", 0);
        f3306c = r02;
        ?? r1 = new Enum("DROP_OLDEST", 1);
        f3307d = r1;
        ?? r2 = new Enum("DROP_LATEST", 2);
        f3308e = r2;
        a[] aVarArr = {r02, r1, r2};
        f3309f = aVarArr;
        AbstractC0051a.t(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f3309f.clone();
    }
}
