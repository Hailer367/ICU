package o;

import java.util.Iterator;

/* renamed from: o.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0283b extends AbstractC0286e implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public C0284c f3356c;

    /* renamed from: d, reason: collision with root package name */
    public C0284c f3357d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3358e;

    public C0283b(C0284c c0284c, C0284c c0284c2, int i2) {
        this.f3358e = i2;
        this.f3356c = c0284c2;
        this.f3357d = c0284c;
    }

    @Override // o.AbstractC0286e
    public final void a(C0284c c0284c) {
        C0284c c0284c2;
        C0284c c0284c3 = null;
        if (this.f3356c == c0284c && c0284c == this.f3357d) {
            this.f3357d = null;
            this.f3356c = null;
        }
        C0284c c0284c4 = this.f3356c;
        if (c0284c4 == c0284c) {
            switch (this.f3358e) {
                case 0:
                    c0284c2 = c0284c4.f3362f;
                    break;
                default:
                    c0284c2 = c0284c4.f3361e;
                    break;
            }
            this.f3356c = c0284c2;
        }
        C0284c c0284c5 = this.f3357d;
        if (c0284c5 == c0284c) {
            C0284c c0284c6 = this.f3356c;
            if (c0284c5 != c0284c6 && c0284c6 != null) {
                c0284c3 = b(c0284c5);
            }
            this.f3357d = c0284c3;
        }
    }

    public final C0284c b(C0284c c0284c) {
        switch (this.f3358e) {
            case 0:
                return c0284c.f3361e;
            default:
                return c0284c.f3362f;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3357d != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C0284c c0284c;
        C0284c c0284c2 = this.f3357d;
        C0284c c0284c3 = this.f3356c;
        if (c0284c2 != c0284c3 && c0284c3 != null) {
            c0284c = b(c0284c2);
        } else {
            c0284c = null;
        }
        this.f3357d = c0284c;
        return c0284c2;
    }
}
