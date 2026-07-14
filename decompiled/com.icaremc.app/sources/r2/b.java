package r2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f6048f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ b[] f6049g;

    /* JADX WARN: Type inference failed for: r0v0, types: [r2.b, java.lang.Enum] */
    static {
        ?? r02 = new Enum("PLAIN_TEXT", 0);
        f6048f = r02;
        f6049g = new b[]{r02};
    }

    public static b a(String str) {
        for (b bVar : values()) {
            bVar.getClass();
            if ("text/plain".equals(str)) {
                return bVar;
            }
        }
        throw new NoSuchFieldException(k.d("No such ClipboardContentFormat: ", str));
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f6049g.clone();
    }
}
