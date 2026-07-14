package R0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class b implements Iterator, d1.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f736c;

    /* renamed from: d, reason: collision with root package name */
    public int f737d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f738e;

    public /* synthetic */ b(int i2, Object obj) {
        this.f736c = i2;
        this.f738e = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f736c) {
            case 0:
                if (this.f737d < ((e) this.f738e).a()) {
                    return true;
                }
                return false;
            default:
                if (this.f737d < ((Object[]) this.f738e).length) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f736c) {
            case 0:
                if (hasNext()) {
                    e eVar = (e) this.f738e;
                    int i2 = this.f737d;
                    this.f737d = i2 + 1;
                    return eVar.get(i2);
                }
                throw new NoSuchElementException();
            default:
                try {
                    Object[] objArr = (Object[]) this.f738e;
                    int i3 = this.f737d;
                    this.f737d = i3 + 1;
                    return objArr[i3];
                } catch (ArrayIndexOutOfBoundsException e2) {
                    this.f737d--;
                    throw new NoSuchElementException(e2.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f736c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
