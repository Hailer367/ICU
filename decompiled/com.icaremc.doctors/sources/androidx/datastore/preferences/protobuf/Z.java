package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* loaded from: classes.dex */
public final class Z implements Map.Entry, Comparable {

    /* renamed from: c, reason: collision with root package name */
    public final Comparable f1393c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1394d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Y f1395e;

    public Z(Y y, Comparable comparable, Object obj) {
        this.f1395e = y;
        this.f1393c = comparable;
        this.f1394d = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1393c.compareTo(((Z) obj).f1393c);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean equals;
        boolean equals2;
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f1393c;
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
                    Object obj2 = this.f1394d;
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
        return this.f1393c;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1394d;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int i2 = 0;
        Comparable comparable = this.f1393c;
        if (comparable == null) {
            hashCode = 0;
        } else {
            hashCode = comparable.hashCode();
        }
        Object obj = this.f1394d;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return i2 ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f1395e.b();
        Object obj2 = this.f1394d;
        this.f1394d = obj;
        return obj2;
    }

    public final String toString() {
        return this.f1393c + "=" + this.f1394d;
    }
}
