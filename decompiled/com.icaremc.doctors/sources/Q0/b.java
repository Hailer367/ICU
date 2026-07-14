package Q0;

/* loaded from: classes.dex */
public final class b implements Comparable {

    /* renamed from: d, reason: collision with root package name */
    public static final b f712d = new b();

    /* renamed from: c, reason: collision with root package name */
    public final int f713c = 131604;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b other = (b) obj;
        kotlin.jvm.internal.h.e(other, "other");
        return this.f713c - other.f713c;
    }

    public final boolean equals(Object obj) {
        b bVar;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            bVar = (b) obj;
        } else {
            bVar = null;
        }
        if (bVar != null && this.f713c == bVar.f713c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f713c;
    }

    public final String toString() {
        return "2.2.20";
    }
}
