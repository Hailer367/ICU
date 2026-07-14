package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class t implements m {
    public static final t BCE;
    public static final t CE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ t[] f2523a;

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f2523a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.chrono.t] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.chrono.t] */
    static {
        ?? r02 = new Enum("BCE", 0);
        BCE = r02;
        ?? r1 = new Enum("CE", 1);
        CE = r1;
        f2523a = new t[]{r02, r1};
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return ordinal();
    }
}
