package B2;

import f1.AbstractC0286a;

/* loaded from: classes.dex */
public final class O {

    /* renamed from: a, reason: collision with root package name */
    public final String f182a;

    /* renamed from: b, reason: collision with root package name */
    public final M f183b;

    public O(String str, M m3) {
        this.f182a = str;
        this.f183b = m3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof O)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        O o3 = (O) obj;
        return AbstractC0286a.f(I2.f.C(this.f182a, this.f183b), I2.f.C(o3.f182a, o3.f183b));
    }

    public final int hashCode() {
        return I2.f.C(this.f182a, this.f183b).hashCode();
    }

    public final String toString() {
        return "StringListResult(jsonEncodedValue=" + this.f182a + ", type=" + this.f183b + ")";
    }
}
