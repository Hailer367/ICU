package i1;

import a.AbstractC0051a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ l[] f2353c;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, i1.l] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, i1.l] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, i1.l] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, i1.l] */
    static {
        l[] lVarArr = {new Enum("PUBLIC", 0), new Enum("PROTECTED", 1), new Enum("INTERNAL", 2), new Enum("PRIVATE", 3)};
        f2353c = lVarArr;
        AbstractC0051a.t(lVarArr);
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f2353c.clone();
    }
}
