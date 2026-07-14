package l0;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2943a;

    public k(List list) {
        this.f2943a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class.equals(obj.getClass())) {
            return this.f2943a.equals(((k) obj).f2943a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2943a.hashCode();
    }

    public final String toString() {
        return R0.j.S((Collection) this.f2943a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}
