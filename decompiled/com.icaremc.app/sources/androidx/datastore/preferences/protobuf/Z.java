package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* loaded from: classes.dex */
public final class Z implements Map.Entry, Comparable {

    /* renamed from: f, reason: collision with root package name */
    public final Comparable f2611f;

    /* renamed from: g, reason: collision with root package name */
    public Object f2612g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Y f2613h;

    public Z(Y y3, Comparable comparable, Object obj) {
        this.f2613h = y3;
        this.f2611f = comparable;
        this.f2612g = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f2611f.compareTo(((Z) obj).f2611f);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean equals;
        boolean equals2;
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f2611f;
                if (comparable == null) {
                    if (key == null) {
                        equals = true;
                    } else {
                        equals = false;
                    }
                } else {
                    equals = comparable.equals(key);
                }
                if (equals) {
                    Object obj2 = this.f2612g;
                    Object value = entry.getValue();
                    if (obj2 == null) {
                        if (value == null) {
                            equals2 = true;
                        } else {
                            equals2 = false;
                        }
                    } else {
                        equals2 = obj2.equals(value);
                    }
                    if (equals2) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f2611f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f2612g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int i4 = 0;
        Comparable comparable = this.f2611f;
        if (comparable == null) {
            hashCode = 0;
        } else {
            hashCode = comparable.hashCode();
        }
        Object obj = this.f2612g;
        if (obj != null) {
            i4 = obj.hashCode();
        }
        return i4 ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f2613h.b();
        Object obj2 = this.f2612g;
        this.f2612g = obj;
        return obj2;
    }

    public final String toString() {
        return this.f2611f + "=" + this.f2612g;
    }
}
