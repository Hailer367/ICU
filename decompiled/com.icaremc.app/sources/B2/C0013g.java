package B2;

import f1.AbstractC0286a;
import java.util.List;

/* renamed from: B2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0013g {

    /* renamed from: a, reason: collision with root package name */
    public final String f195a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f196b;

    public C0013g(String str, boolean z) {
        this.f195a = str;
        this.f196b = z;
    }

    public final List a() {
        return I2.f.C(this.f195a, Boolean.valueOf(this.f196b));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0013g)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return AbstractC0286a.f(a(), ((C0013g) obj).a());
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return "SharedPreferencesPigeonOptions(fileName=" + this.f195a + ", useDataStore=" + this.f196b + ")";
    }
}
