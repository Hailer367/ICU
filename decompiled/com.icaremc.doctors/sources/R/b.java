package R;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f723c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f724d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f725e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f726f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f727g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f728h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f729i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ b[] f730j;

    /* JADX INFO: Fake field, exist only in values array */
    b EF0;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, R.b] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, R.b] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, R.b] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, R.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, R.b] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, R.b] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, R.b] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, R.b] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, R.b] */
    static {
        ?? r02 = new Enum("PENALTY_LOG", 0);
        ?? r1 = new Enum("PENALTY_DEATH", 1);
        ?? r2 = new Enum("DETECT_FRAGMENT_REUSE", 2);
        f723c = r2;
        ?? r3 = new Enum("DETECT_FRAGMENT_TAG_USAGE", 3);
        f724d = r3;
        ?? r4 = new Enum("DETECT_WRONG_NESTED_HIERARCHY", 4);
        f725e = r4;
        ?? r5 = new Enum("DETECT_RETAIN_INSTANCE_USAGE", 5);
        f726f = r5;
        ?? r6 = new Enum("DETECT_SET_USER_VISIBLE_HINT", 6);
        f727g = r6;
        ?? r7 = new Enum("DETECT_TARGET_FRAGMENT_USAGE", 7);
        f728h = r7;
        ?? r8 = new Enum("DETECT_WRONG_FRAGMENT_CONTAINER", 8);
        f729i = r8;
        f730j = new b[]{r02, r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f730j.clone();
    }
}
