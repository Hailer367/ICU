package x1;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final o f6475a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6476b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6477c;

    public g(int i4, int i5, Class cls) {
        this(o.a(cls), i4, i5);
    }

    public static g a(Class cls) {
        return new g(1, 0, cls);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f6475a.equals(gVar.f6475a) && this.f6476b == gVar.f6476b && this.f6477c == gVar.f6477c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f6475a.hashCode() ^ 1000003) * 1000003) ^ this.f6476b) * 1000003) ^ this.f6477c;
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f6475a);
        sb.append(", type=");
        int i4 = this.f6476b;
        if (i4 == 1) {
            str = "required";
        } else if (i4 == 0) {
            str = "optional";
        } else {
            str = "set";
        }
        sb.append(str);
        sb.append(", injection=");
        int i5 = this.f6477c;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    str2 = "deferred";
                } else {
                    throw new AssertionError(A2.i.g(i5, "Unsupported injection: "));
                }
            } else {
                str2 = "provider";
            }
        } else {
            str2 = "direct";
        }
        return r2.k.c(sb, str2, "}");
    }

    public g(o oVar, int i4, int i5) {
        this.f6475a = oVar;
        this.f6476b = i4;
        this.f6477c = i5;
    }
}
