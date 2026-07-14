package A2;

import f1.AbstractC0286a;

/* renamed from: A2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0002a {

    /* renamed from: a, reason: collision with root package name */
    public final String f59a;

    /* renamed from: b, reason: collision with root package name */
    public final String f60b;

    public C0002a(String str, String str2) {
        T2.h.e(str, "code");
        this.f59a = str;
        this.f60b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(C0002a.class)) {
            if (this != obj) {
                C0002a c0002a = (C0002a) obj;
                if (AbstractC0286a.e(this.f59a, c0002a.f59a) && AbstractC0286a.e(this.f60b, c0002a.f60b)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0286a.g(this.f60b) + ((AbstractC0286a.g(this.f59a) + (C0002a.class.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "CacheRetrievalError(code=" + this.f59a + ", message=" + this.f60b + ")";
    }
}
