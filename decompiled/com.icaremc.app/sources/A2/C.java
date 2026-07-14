package A2;

import f1.AbstractC0286a;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public final D f53a;

    /* renamed from: b, reason: collision with root package name */
    public final B f54b;

    public C(D d4, B b4) {
        this.f53a = d4;
        this.f54b = b4;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(C.class)) {
            if (this != obj) {
                C c4 = (C) obj;
                if (AbstractC0286a.e(this.f53a, c4.f53a) && AbstractC0286a.e(this.f54b, c4.f54b)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0286a.g(this.f54b) + ((AbstractC0286a.g(this.f53a) + (C.class.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SourceSpecification(type=" + this.f53a + ", camera=" + this.f54b + ")";
    }
}
