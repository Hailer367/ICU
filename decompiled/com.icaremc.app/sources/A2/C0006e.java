package A2;

import f1.AbstractC0286a;

/* renamed from: A2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0006e {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f71a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f72b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f73c;

    public C0006e(boolean z, boolean z3, Long l3) {
        this.f71a = z;
        this.f72b = z3;
        this.f73c = l3;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(C0006e.class)) {
            if (this != obj) {
                C0006e c0006e = (C0006e) obj;
                if (AbstractC0286a.e(Boolean.valueOf(this.f71a), Boolean.valueOf(c0006e.f71a)) && AbstractC0286a.e(Boolean.valueOf(this.f72b), Boolean.valueOf(c0006e.f72b)) && AbstractC0286a.e(this.f73c, c0006e.f73c)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0286a.g(this.f73c) + ((AbstractC0286a.g(Boolean.valueOf(this.f72b)) + ((AbstractC0286a.g(Boolean.valueOf(this.f71a)) + (C0006e.class.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "GeneralOptions(allowMultiple=" + this.f71a + ", usePhotoPicker=" + this.f72b + ", limit=" + this.f73c + ")";
    }
}
