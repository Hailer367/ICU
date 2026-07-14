package q;

import java.util.Iterator;

/* renamed from: q.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0590d extends AbstractC0591e implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public C0589c f5846f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5847g = true;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0592f f5848h;

    public C0590d(C0592f c0592f) {
        this.f5848h = c0592f;
    }

    @Override // q.AbstractC0591e
    public final void a(C0589c c0589c) {
        boolean z;
        C0589c c0589c2 = this.f5846f;
        if (c0589c == c0589c2) {
            C0589c c0589c3 = c0589c2.f5845i;
            this.f5846f = c0589c3;
            if (c0589c3 == null) {
                z = true;
            } else {
                z = false;
            }
            this.f5847g = z;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5847g) {
            if (this.f5848h.f5849f == null) {
                return false;
            }
            return true;
        }
        C0589c c0589c = this.f5846f;
        if (c0589c == null || c0589c.f5844h == null) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C0589c c0589c;
        if (this.f5847g) {
            this.f5847g = false;
            this.f5846f = this.f5848h.f5849f;
        } else {
            C0589c c0589c2 = this.f5846f;
            if (c0589c2 != null) {
                c0589c = c0589c2.f5844h;
            } else {
                c0589c = null;
            }
            this.f5846f = c0589c;
        }
        return this.f5846f;
    }
}
