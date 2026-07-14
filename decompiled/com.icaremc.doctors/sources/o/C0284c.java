package o;

import java.util.Map;

/* renamed from: o.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0284c implements Map.Entry {

    /* renamed from: c, reason: collision with root package name */
    public final Object f3359c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3360d;

    /* renamed from: e, reason: collision with root package name */
    public C0284c f3361e;

    /* renamed from: f, reason: collision with root package name */
    public C0284c f3362f;

    public C0284c(Object obj, Object obj2) {
        this.f3359c = obj;
        this.f3360d = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0284c)) {
            return false;
        }
        C0284c c0284c = (C0284c) obj;
        if (this.f3359c.equals(c0284c.f3359c) && this.f3360d.equals(c0284c.f3360d)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3359c;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3360d;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f3359c.hashCode() ^ this.f3360d.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f3359c + "=" + this.f3360d;
    }
}
