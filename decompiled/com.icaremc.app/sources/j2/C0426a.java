package j2;

/* renamed from: j2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0426a {

    /* renamed from: a, reason: collision with root package name */
    public final String f5053a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5054b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5055c;

    public C0426a(String str, String str2) {
        this.f5053a = str;
        this.f5054b = null;
        this.f5055c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0426a.class != obj.getClass()) {
            return false;
        }
        C0426a c0426a = (C0426a) obj;
        if (!this.f5053a.equals(c0426a.f5053a)) {
            return false;
        }
        return this.f5055c.equals(c0426a.f5055c);
    }

    public final int hashCode() {
        return this.f5055c.hashCode() + (this.f5053a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DartEntrypoint( bundle path: ");
        sb.append(this.f5053a);
        sb.append(", function: ");
        return r2.k.c(sb, this.f5055c, " )");
    }

    public C0426a(String str, String str2, String str3) {
        this.f5053a = str;
        this.f5054b = str2;
        this.f5055c = str3;
    }
}
