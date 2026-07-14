package V1;

import java.util.Map;

/* loaded from: classes.dex */
public final class n implements Map.Entry {

    /* renamed from: f, reason: collision with root package name */
    public n f1749f;

    /* renamed from: g, reason: collision with root package name */
    public n f1750g;

    /* renamed from: h, reason: collision with root package name */
    public n f1751h;

    /* renamed from: i, reason: collision with root package name */
    public n f1752i;

    /* renamed from: j, reason: collision with root package name */
    public n f1753j;
    public final Object k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f1754l;

    /* renamed from: m, reason: collision with root package name */
    public Object f1755m;

    /* renamed from: n, reason: collision with root package name */
    public int f1756n;

    public n(boolean z) {
        this.k = null;
        this.f1754l = z;
        this.f1753j = this;
        this.f1752i = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.k;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f1755m;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.k;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1755m;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int i4 = 0;
        Object obj = this.k;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f1755m;
        if (obj2 != null) {
            i4 = obj2.hashCode();
        }
        return i4 ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f1754l) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f1755m;
        this.f1755m = obj;
        return obj2;
    }

    public final String toString() {
        return this.k + "=" + this.f1755m;
    }

    public n(boolean z, n nVar, Object obj, n nVar2, n nVar3) {
        this.f1749f = nVar;
        this.k = obj;
        this.f1754l = z;
        this.f1756n = 1;
        this.f1752i = nVar2;
        this.f1753j = nVar3;
        nVar3.f1752i = this;
        nVar2.f1753j = this;
    }
}
