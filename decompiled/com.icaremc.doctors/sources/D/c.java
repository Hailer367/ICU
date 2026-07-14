package D;

import a.AbstractC0051a;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float f168a;

    /* renamed from: b, reason: collision with root package name */
    public final float f169b;

    public c(float f2, float f3) {
        AbstractC0051a.c(f2, "width");
        this.f168a = f2;
        AbstractC0051a.c(f3, "height");
        this.f169b = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f168a == this.f168a && cVar.f169b == this.f169b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f168a) ^ Float.floatToIntBits(this.f169b);
    }

    public final String toString() {
        return this.f168a + "x" + this.f169b;
    }
}
