package H0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i extends o {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f620a;

    public i(ArrayList arrayList) {
        this.f620a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return this.f620a.equals(((i) ((o) obj)).f620a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f620a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f620a + "}";
    }
}
