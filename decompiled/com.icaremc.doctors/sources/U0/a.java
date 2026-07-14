package U0;

import a.AbstractC0051a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f780c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a[] f781d;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, U0.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, U0.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, U0.a] */
    static {
        ?? r02 = new Enum("COROUTINE_SUSPENDED", 0);
        f780c = r02;
        a[] aVarArr = {r02, new Enum("UNDECIDED", 1), new Enum("RESUMED", 2)};
        f781d = aVarArr;
        AbstractC0051a.t(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f781d.clone();
    }
}
