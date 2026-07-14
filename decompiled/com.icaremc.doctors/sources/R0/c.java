package R0;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class c extends b implements ListIterator {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f739f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, int i2) {
        super(0, eVar);
        this.f739f = eVar;
        int a2 = eVar.a();
        if (i2 >= 0 && i2 <= a2) {
            this.f737d = i2;
            return;
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", a2));
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f737d > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f737d;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i2 = this.f737d - 1;
            this.f737d = i2;
            return this.f739f.get(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f737d - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
