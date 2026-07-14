package W;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class i extends AbstractC0051a {

    /* renamed from: f, reason: collision with root package name */
    public final b f817f;

    public i(b latestEvent) {
        kotlin.jvm.internal.h.e(latestEvent, "latestEvent");
        this.f817f = latestEvent;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && i.class == obj.getClass() && kotlin.jvm.internal.h.a(this.f817f, ((i) obj).f817f)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f817f.hashCode() - 31;
    }

    public final String toString() {
        return "InProgress(latestEvent=" + this.f817f + ", direction=-1)";
    }
}
