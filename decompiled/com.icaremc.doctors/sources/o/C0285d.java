package o;

import java.util.Iterator;

/* renamed from: o.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0285d extends AbstractC0286e implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public C0284c f3363c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3364d = true;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0287f f3365e;

    public C0285d(C0287f c0287f) {
        this.f3365e = c0287f;
    }

    @Override // o.AbstractC0286e
    public final void a(C0284c c0284c) {
        boolean z;
        C0284c c0284c2 = this.f3363c;
        if (c0284c == c0284c2) {
            C0284c c0284c3 = c0284c2.f3362f;
            this.f3363c = c0284c3;
            if (c0284c3 == null) {
                z = true;
            } else {
                z = false;
            }
            this.f3364d = z;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3364d) {
            if (this.f3365e.f3366c == null) {
                return false;
            }
            return true;
        }
        C0284c c0284c = this.f3363c;
        if (c0284c == null || c0284c.f3361e == null) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C0284c c0284c;
        if (this.f3364d) {
            this.f3364d = false;
            this.f3363c = this.f3365e.f3366c;
        } else {
            C0284c c0284c2 = this.f3363c;
            if (c0284c2 != null) {
                c0284c = c0284c2.f3361e;
            } else {
                c0284c = null;
            }
            this.f3363c = c0284c;
        }
        return this.f3363c;
    }
}
