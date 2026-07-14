package u0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends p {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3858a;

    public j(ArrayList arrayList) {
        this.f3858a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            return this.f3858a.equals(((j) ((p) obj)).f3858a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3858a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f3858a + "}";
    }
}
