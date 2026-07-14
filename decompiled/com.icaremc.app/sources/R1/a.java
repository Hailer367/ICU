package R1;

import r2.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1526a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1527b;

    public a(String str, String str2) {
        this.f1526a = str;
        if (str2 != null) {
            this.f1527b = str2;
            return;
        }
        throw new NullPointerException("Null version");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f1526a.equals(aVar.f1526a) && this.f1527b.equals(aVar.f1527b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f1526a.hashCode() ^ 1000003) * 1000003) ^ this.f1527b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.f1526a);
        sb.append(", version=");
        return k.c(sb, this.f1527b, "}");
    }
}
