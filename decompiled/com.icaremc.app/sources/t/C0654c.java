package t;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: t.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0654c implements Iterator, Map.Entry {

    /* renamed from: f, reason: collision with root package name */
    public int f6172f;

    /* renamed from: g, reason: collision with root package name */
    public int f6173g = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6174h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ C0656e f6175i;

    public C0654c(C0656e c0656e) {
        this.f6175i = c0656e;
        this.f6172f = c0656e.f6196h - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this.f6174h) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int i4 = this.f6173g;
                C0656e c0656e = this.f6175i;
                if (T2.h.a(key, c0656e.e(i4)) && T2.h.a(entry.getValue(), c0656e.h(this.f6173g))) {
                    return true;
                }
                return false;
            }
            return false;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f6174h) {
            return this.f6175i.e(this.f6173g);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f6174h) {
            return this.f6175i.h(this.f6173g);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6173g < this.f6172f) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        if (this.f6174h) {
            int i4 = this.f6173g;
            C0656e c0656e = this.f6175i;
            Object e4 = c0656e.e(i4);
            Object h3 = c0656e.h(this.f6173g);
            int i5 = 0;
            if (e4 == null) {
                hashCode = 0;
            } else {
                hashCode = e4.hashCode();
            }
            if (h3 != null) {
                i5 = h3.hashCode();
            }
            return hashCode ^ i5;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f6173g++;
            this.f6174h = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f6174h) {
            this.f6175i.f(this.f6173g);
            this.f6173g--;
            this.f6172f--;
            this.f6174h = false;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f6174h) {
            return this.f6175i.g(this.f6173g, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
