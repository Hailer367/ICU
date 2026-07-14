package d0;

import I2.m;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f3436a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3437b;

    public d(int i4, List list) {
        this.f3436a = list;
        this.f3437b = i4;
        if (list.isEmpty() && i4 == -1) {
            return;
        }
        if (!list.isEmpty()) {
            int size = list.size();
            if (i4 >= 0 && i4 < size) {
                return;
            }
        }
        throw new IllegalArgumentException(("Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '" + i4 + "', bounds = '" + new X2.a(0, list.size() - 1, 1) + "'.").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f3437b == dVar.f3437b && T2.h.a(this.f3436a, dVar.f3436a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f3436a.hashCode() + (this.f3437b * 31);
    }

    public final String toString() {
        return "NavigationEventHistory(currentIndex=" + this.f3437b + ", mergedHistory=" + this.f3436a + ')';
    }

    public d() {
        this(-1, m.f862f);
    }
}
