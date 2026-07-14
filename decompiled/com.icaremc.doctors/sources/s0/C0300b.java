package s0;

/* renamed from: s0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0300b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f3583a;

    public C0300b(Integer num) {
        this.f3583a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0300b)) {
            return false;
        }
        C0300b c0300b = (C0300b) obj;
        Integer num = this.f3583a;
        if (num == null) {
            if (c0300b.f3583a == null) {
                return true;
            }
            return false;
        }
        return num.equals(c0300b.f3583a);
    }

    public final int hashCode() {
        int hashCode;
        Integer num = this.f3583a;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode ^ 1000003;
    }

    public final String toString() {
        return "ProductData{productId=" + this.f3583a + "}";
    }
}
