package l1;

import a.AbstractC0051a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: l1.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0243v {

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0243v f3013c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0243v f3014d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumC0243v[] f3015e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, l1.v] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, l1.v] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, l1.v] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, l1.v] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f3013c = r02;
        ?? r1 = new Enum("LAZY", 1);
        ?? r2 = new Enum("ATOMIC", 2);
        f3014d = r2;
        EnumC0243v[] enumC0243vArr = {r02, r1, r2, new Enum("UNDISPATCHED", 3)};
        f3015e = enumC0243vArr;
        AbstractC0051a.t(enumC0243vArr);
    }

    public static EnumC0243v valueOf(String str) {
        return (EnumC0243v) Enum.valueOf(EnumC0243v.class, str);
    }

    public static EnumC0243v[] values() {
        return (EnumC0243v[]) f3015e.clone();
    }
}
