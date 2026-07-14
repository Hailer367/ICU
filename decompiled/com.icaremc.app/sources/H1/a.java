package H1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f646a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f647b;

    public a(String str, ArrayList arrayList) {
        if (str != null) {
            this.f646a = str;
            this.f647b = arrayList;
            return;
        }
        throw new NullPointerException("Null userAgent");
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f646a.equals(aVar.f646a) && this.f647b.equals(aVar.f647b)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f646a.hashCode() ^ 1000003) * 1000003) ^ this.f647b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f646a + ", usedDates=" + this.f647b + "}";
    }
}
