package W;

import R0.r;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f798a;

    /* renamed from: b, reason: collision with root package name */
    public final int f799b;

    public d(int i2, List list) {
        this.f798a = list;
        this.f799b = i2;
        if (list.isEmpty() && i2 == -1) {
            return;
        }
        if (!list.isEmpty()) {
            int size = list.size();
            if (i2 >= 0 && i2 < size) {
                return;
            }
        }
        throw new IllegalArgumentException(("Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '" + i2 + "', bounds = '" + new h1.a(0, list.size() - 1, 1) + "'.").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f799b == dVar.f799b && kotlin.jvm.internal.h.a(this.f798a, dVar.f798a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f798a.hashCode() + (this.f799b * 31);
    }

    public final String toString() {
        return "NavigationEventHistory(currentIndex=" + this.f799b + ", mergedHistory=" + this.f798a + ')';
    }

    public d() {
        this(-1, r.f750c);
    }
}
