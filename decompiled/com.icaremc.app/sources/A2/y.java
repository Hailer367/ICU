package A2;

import f1.AbstractC0286a;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final Double f118a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f119b;

    /* renamed from: c, reason: collision with root package name */
    public final long f120c;

    public y(Double d4, Double d5, long j4) {
        this.f118a = d4;
        this.f119b = d5;
        this.f120c = j4;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(y.class)) {
            if (this != obj) {
                y yVar = (y) obj;
                if (AbstractC0286a.e(this.f118a, yVar.f118a) && AbstractC0286a.e(this.f119b, yVar.f119b) && AbstractC0286a.e(Long.valueOf(this.f120c), Long.valueOf(yVar.f120c))) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0286a.g(Long.valueOf(this.f120c)) + ((AbstractC0286a.g(this.f119b) + ((AbstractC0286a.g(this.f118a) + (y.class.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ImageSelectionOptions(maxWidth=" + this.f118a + ", maxHeight=" + this.f119b + ", quality=" + this.f120c + ")";
    }
}
