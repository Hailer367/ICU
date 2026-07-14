package r;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: r.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0289a implements Iterator, d1.a {

    /* renamed from: c, reason: collision with root package name */
    public int f3548c;

    /* renamed from: d, reason: collision with root package name */
    public int f3549d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3550e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3551f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3552g;

    public C0289a(int i2) {
        this.f3548c = i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3549d < this.f3548c) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object f2;
        if (hasNext()) {
            int i2 = this.f3549d;
            switch (this.f3551f) {
                case 0:
                    f2 = ((C0293e) this.f3552g).f(i2);
                    break;
                case 1:
                    f2 = ((C0293e) this.f3552g).i(i2);
                    break;
                default:
                    f2 = ((C0294f) this.f3552g).f3563d[i2];
                    break;
            }
            this.f3549d++;
            this.f3550e = true;
            return f2;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f3550e) {
            int i2 = this.f3549d - 1;
            this.f3549d = i2;
            switch (this.f3551f) {
                case 0:
                    ((C0293e) this.f3552g).g(i2);
                    break;
                case 1:
                    ((C0293e) this.f3552g).g(i2);
                    break;
                default:
                    ((C0294f) this.f3552g).a(i2);
                    break;
            }
            this.f3548c--;
            this.f3550e = false;
            return;
        }
        throw new IllegalStateException("Call next() before removing an element.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0289a(C0294f c0294f) {
        this(c0294f.f3564e);
        this.f3551f = 2;
        this.f3552g = c0294f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0289a(C0293e c0293e, int i2) {
        this(c0293e.f3573e);
        this.f3551f = i2;
        switch (i2) {
            case 1:
                this.f3552g = c0293e;
                this(c0293e.f3573e);
                return;
            default:
                this.f3552g = c0293e;
                return;
        }
    }
}
