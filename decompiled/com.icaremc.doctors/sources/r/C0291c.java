package r;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: r.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0291c implements Iterator, Map.Entry {

    /* renamed from: c, reason: collision with root package name */
    public int f3554c;

    /* renamed from: d, reason: collision with root package name */
    public int f3555d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3556e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0293e f3557f;

    public C0291c(C0293e c0293e) {
        this.f3557f = c0293e;
        this.f3554c = c0293e.f3573e - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this.f3556e) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int i2 = this.f3555d;
                C0293e c0293e = this.f3557f;
                if (kotlin.jvm.internal.h.a(key, c0293e.f(i2)) && kotlin.jvm.internal.h.a(entry.getValue(), c0293e.i(this.f3555d))) {
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
        if (this.f3556e) {
            return this.f3557f.f(this.f3555d);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f3556e) {
            return this.f3557f.i(this.f3555d);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3555d < this.f3554c) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        if (this.f3556e) {
            int i2 = this.f3555d;
            C0293e c0293e = this.f3557f;
            Object f2 = c0293e.f(i2);
            Object i3 = c0293e.i(this.f3555d);
            int i4 = 0;
            if (f2 == null) {
                hashCode = 0;
            } else {
                hashCode = f2.hashCode();
            }
            if (i3 != null) {
                i4 = i3.hashCode();
            }
            return hashCode ^ i4;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f3555d++;
            this.f3556e = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f3556e) {
            this.f3557f.g(this.f3555d);
            this.f3555d--;
            this.f3554c--;
            this.f3556e = false;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f3556e) {
            return this.f3557f.h(this.f3555d, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
