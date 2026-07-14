package q;

import java.util.Map;

/* renamed from: q.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0589c implements Map.Entry {

    /* renamed from: f, reason: collision with root package name */
    public final Object f5842f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f5843g;

    /* renamed from: h, reason: collision with root package name */
    public C0589c f5844h;

    /* renamed from: i, reason: collision with root package name */
    public C0589c f5845i;

    public C0589c(Object obj, Object obj2) {
        this.f5842f = obj;
        this.f5843g = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0589c)) {
            return false;
        }
        C0589c c0589c = (C0589c) obj;
        if (this.f5842f.equals(c0589c.f5842f) && this.f5843g.equals(c0589c.f5843g)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5842f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5843g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f5842f.hashCode() ^ this.f5843g.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f5842f + "=" + this.f5843g;
    }
}
