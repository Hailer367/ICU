package H2;

/* loaded from: classes.dex */
public final class b implements Comparable {

    /* renamed from: g, reason: collision with root package name */
    public static final b f671g = new b();

    /* renamed from: f, reason: collision with root package name */
    public final int f672f = 131604;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b bVar = (b) obj;
        T2.h.e(bVar, "other");
        return this.f672f - bVar.f672f;
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
        if (bVar != null && this.f672f == bVar.f672f) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f672f;
    }

    public final String toString() {
        return "2.2.20";
    }
}
