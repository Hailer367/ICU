package T1;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1601d = new a("", "", false);

    /* renamed from: a, reason: collision with root package name */
    public final String f1602a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1603b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1604c;

    static {
        new a("\n", "  ", true);
    }

    public a(String str, String str2, boolean z) {
        if (str.matches("[\r\n]*")) {
            if (str2.matches("[ \t]*")) {
                this.f1602a = str;
                this.f1603b = str2;
                this.f1604c = z;
                return;
            }
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
    }
}
