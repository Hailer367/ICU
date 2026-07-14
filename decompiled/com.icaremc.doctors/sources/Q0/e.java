package Q0;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Object f714c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f715d;

    public e(Object obj, Object obj2) {
        this.f714c = obj;
        this.f715d = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (kotlin.jvm.internal.h.a(this.f714c, eVar.f714c) && kotlin.jvm.internal.h.a(this.f715d, eVar.f715d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i2 = 0;
        Object obj = this.f714c;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i3 = hashCode * 31;
        Object obj2 = this.f715d;
        if (obj2 != null) {
            i2 = obj2.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "(" + this.f714c + ", " + this.f715d + ')';
    }
}
