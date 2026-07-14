package p0;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5813a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5814b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5815c;

    /* renamed from: d, reason: collision with root package name */
    public final s f5816d;

    public t(String str, String str2, boolean z, s sVar) {
        if (!str2.isEmpty() && str2.charAt(0) == '/') {
            if (str2.endsWith("/")) {
                this.f5814b = str;
                this.f5815c = str2;
                this.f5813a = z;
                this.f5816d = sVar;
                return;
            }
            throw new IllegalArgumentException("Path should end with a slash '/'");
        }
        throw new IllegalArgumentException("Path should start with a slash '/'.");
    }
}
