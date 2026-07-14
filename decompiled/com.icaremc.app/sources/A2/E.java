package A2;

import f1.AbstractC0286a;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public final Long f58a;

    public E(Long l3) {
        this.f58a = l3;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(E.class)) {
            if (this == obj) {
                return true;
            }
            return AbstractC0286a.e(this.f58a, ((E) obj).f58a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0286a.g(this.f58a) + (E.class.hashCode() * 31);
    }

    public final String toString() {
        return "VideoSelectionOptions(maxDurationSeconds=" + this.f58a + ")";
    }
}
