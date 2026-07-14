package t;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: t.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0652a implements Iterator, U2.a {

    /* renamed from: f, reason: collision with root package name */
    public int f6166f;

    /* renamed from: g, reason: collision with root package name */
    public int f6167g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6168h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6169i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6170j;

    public C0652a(int i4) {
        this.f6166f = i4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6167g < this.f6166f) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object e4;
        if (hasNext()) {
            int i4 = this.f6167g;
            switch (this.f6169i) {
                case 0:
                    e4 = ((C0656e) this.f6170j).e(i4);
                    break;
                case 1:
                    e4 = ((C0656e) this.f6170j).h(i4);
                    break;
                default:
                    e4 = ((C0657f) this.f6170j).f6180g[i4];
                    break;
            }
            this.f6167g++;
            this.f6168h = true;
            return e4;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f6168h) {
            int i4 = this.f6167g - 1;
            this.f6167g = i4;
            switch (this.f6169i) {
                case 0:
                    ((C0656e) this.f6170j).f(i4);
                    break;
                case 1:
                    ((C0656e) this.f6170j).f(i4);
                    break;
                default:
                    ((C0657f) this.f6170j).a(i4);
                    break;
            }
            this.f6166f--;
            this.f6168h = false;
            return;
        }
        throw new IllegalStateException("Call next() before removing an element.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0652a(C0657f c0657f) {
        this(c0657f.f6181h);
        this.f6169i = 2;
        this.f6170j = c0657f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0652a(C0656e c0656e, int i4) {
        this(c0656e.f6196h);
        this.f6169i = i4;
        switch (i4) {
            case 1:
                this.f6170j = c0656e;
                this(c0656e.f6196h);
                return;
            default:
                this.f6170j = c0656e;
                return;
        }
    }
}
