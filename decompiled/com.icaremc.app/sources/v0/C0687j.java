package v0;

import java.util.Collection;
import java.util.List;

/* renamed from: v0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0687j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6284a;

    public C0687j(List list) {
        this.f6284a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0687j.class.equals(obj.getClass())) {
            return this.f6284a.equals(((C0687j) obj).f6284a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6284a.hashCode();
    }

    public final String toString() {
        return I2.e.G((Collection) this.f6284a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}
