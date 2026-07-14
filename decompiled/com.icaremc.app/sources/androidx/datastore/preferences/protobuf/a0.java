package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class a0 implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public int f2614f = -1;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2615g;

    /* renamed from: h, reason: collision with root package name */
    public Iterator f2616h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Y f2617i;

    public a0(Y y3) {
        this.f2617i = y3;
    }

    public final Iterator a() {
        if (this.f2616h == null) {
            this.f2616h = this.f2617i.f2607g.entrySet().iterator();
        }
        return this.f2616h;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i4 = this.f2614f + 1;
        Y y3 = this.f2617i;
        if (i4 < y3.f2606f.size() || (!y3.f2607g.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f2615g = true;
        int i4 = this.f2614f + 1;
        this.f2614f = i4;
        Y y3 = this.f2617i;
        if (i4 < y3.f2606f.size()) {
            return (Map.Entry) y3.f2606f.get(this.f2614f);
        }
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f2615g) {
            this.f2615g = false;
            int i4 = Y.k;
            Y y3 = this.f2617i;
            y3.b();
            if (this.f2614f < y3.f2606f.size()) {
                int i5 = this.f2614f;
                this.f2614f = i5 - 1;
                y3.h(i5);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
