package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class a0 implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public int f1396c = -1;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1397d;

    /* renamed from: e, reason: collision with root package name */
    public Iterator f1398e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Y f1399f;

    public a0(Y y) {
        this.f1399f = y;
    }

    public final Iterator a() {
        if (this.f1398e == null) {
            this.f1398e = this.f1399f.f1389d.entrySet().iterator();
        }
        return this.f1398e;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f1396c + 1;
        Y y = this.f1399f;
        if (i2 < y.f1388c.size() || (!y.f1389d.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f1397d = true;
        int i2 = this.f1396c + 1;
        this.f1396c = i2;
        Y y = this.f1399f;
        if (i2 < y.f1388c.size()) {
            return (Map.Entry) y.f1388c.get(this.f1396c);
        }
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f1397d) {
            this.f1397d = false;
            int i2 = Y.f1387h;
            Y y = this.f1399f;
            y.b();
            if (this.f1396c < y.f1388c.size()) {
                int i3 = this.f1396c;
                this.f1396c = i3 - 1;
                y.h(i3);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
