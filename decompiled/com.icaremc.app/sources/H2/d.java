package H2;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class d implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Object f673f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f674g;

    public d(Object obj, Object obj2) {
        this.f673f = obj;
        this.f674g = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (T2.h.a(this.f673f, dVar.f673f) && T2.h.a(this.f674g, dVar.f674g)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i4 = 0;
        Object obj = this.f673f;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i5 = hashCode * 31;
        Object obj2 = this.f674g;
        if (obj2 != null) {
            i4 = obj2.hashCode();
        }
        return i5 + i4;
    }

    public final String toString() {
        return "(" + this.f673f + ", " + this.f674g + ')';
    }
}
