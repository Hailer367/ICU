package q;

import java.util.Iterator;

/* renamed from: q.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0588b extends AbstractC0591e implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public C0589c f5839f;

    /* renamed from: g, reason: collision with root package name */
    public C0589c f5840g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5841h;

    public C0588b(C0589c c0589c, C0589c c0589c2, int i4) {
        this.f5841h = i4;
        this.f5839f = c0589c2;
        this.f5840g = c0589c;
    }

    @Override // q.AbstractC0591e
    public final void a(C0589c c0589c) {
        C0589c c0589c2;
        C0589c c0589c3 = null;
        if (this.f5839f == c0589c && c0589c == this.f5840g) {
            this.f5840g = null;
            this.f5839f = null;
        }
        C0589c c0589c4 = this.f5839f;
        if (c0589c4 == c0589c) {
            switch (this.f5841h) {
                case 0:
                    c0589c2 = c0589c4.f5845i;
                    break;
                default:
                    c0589c2 = c0589c4.f5844h;
                    break;
            }
            this.f5839f = c0589c2;
        }
        C0589c c0589c5 = this.f5840g;
        if (c0589c5 == c0589c) {
            C0589c c0589c6 = this.f5839f;
            if (c0589c5 != c0589c6 && c0589c6 != null) {
                c0589c3 = b(c0589c5);
            }
            this.f5840g = c0589c3;
        }
    }

    public final C0589c b(C0589c c0589c) {
        switch (this.f5841h) {
            case 0:
                return c0589c.f5844h;
            default:
                return c0589c.f5845i;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5840g != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C0589c c0589c;
        C0589c c0589c2 = this.f5840g;
        C0589c c0589c3 = this.f5839f;
        if (c0589c2 != c0589c3 && c0589c3 != null) {
            c0589c = b(c0589c2);
        } else {
            c0589c = null;
        }
        this.f5840g = c0589c;
        return c0589c2;
    }
}
