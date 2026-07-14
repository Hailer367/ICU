package C2;

import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f257a;

    public a(boolean z) {
        this.f257a = z;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(a.class)) {
            if (this == obj) {
                return true;
            }
            return AbstractC0602b.s(Boolean.valueOf(this.f257a), Boolean.valueOf(((a) obj).f257a));
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0602b.t(Boolean.valueOf(this.f257a)) + (a.class.hashCode() * 31);
    }

    public final String toString() {
        return "BrowserOptions(showTitle=" + this.f257a + ")";
    }
}
