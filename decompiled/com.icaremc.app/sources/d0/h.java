package d0;

import a.AbstractC0141a;

/* loaded from: classes.dex */
public final class h extends AbstractC0141a {

    /* renamed from: e, reason: collision with root package name */
    public final b f3454e;

    public h(b bVar) {
        T2.h.e(bVar, "latestEvent");
        this.f3454e = bVar;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && h.class == obj.getClass() && T2.h.a(this.f3454e, ((h) obj).f3454e)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f3454e.hashCode() - 31;
    }

    public final String toString() {
        return "InProgress(latestEvent=" + this.f3454e + ", direction=-1)";
    }
}
