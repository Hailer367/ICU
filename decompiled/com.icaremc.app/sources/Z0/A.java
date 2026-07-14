package Z0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public final String f2088a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2089b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2090c;

    public A(String str, boolean z) {
        r.c(str);
        this.f2088a = str;
        r.c("com.google.android.gms");
        this.f2089b = "com.google.android.gms";
        this.f2090c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        A a4 = (A) obj;
        if (r.g(this.f2088a, a4.f2088a) && r.g(this.f2089b, a4.f2089b) && r.g(null, null) && this.f2090c == a4.f2090c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2088a, this.f2089b, null, 4225, Boolean.valueOf(this.f2090c)});
    }

    public final String toString() {
        String str = this.f2088a;
        if (str != null) {
            return str;
        }
        r.e(null);
        throw null;
    }
}
