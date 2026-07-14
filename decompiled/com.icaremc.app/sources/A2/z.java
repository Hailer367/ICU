package A2;

import f1.AbstractC0286a;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final y f121a;

    public z(y yVar) {
        this.f121a = yVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(z.class)) {
            if (this == obj) {
                return true;
            }
            return AbstractC0286a.e(this.f121a, ((z) obj).f121a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0286a.g(this.f121a) + (z.class.hashCode() * 31);
    }

    public final String toString() {
        return "MediaSelectionOptions(imageSelectionOptions=" + this.f121a + ")";
    }
}
