package C1;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f255a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f256b;

    public c(String str, Map map) {
        this.f255a = str;
        this.f256b = map;
    }

    public static c a(String str) {
        return new c(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f255a.equals(cVar.f255a) && this.f256b.equals(cVar.f256b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f256b.hashCode() + (this.f255a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f255a + ", properties=" + this.f256b.values() + "}";
    }
}
