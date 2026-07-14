package t;

import androidx.datastore.preferences.protobuf.b0;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: t.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0656e extends C0661j implements Map {

    /* renamed from: i, reason: collision with root package name */
    public b0 f6177i;

    /* renamed from: j, reason: collision with root package name */
    public C0653b f6178j;
    public C0655d k;

    @Override // java.util.Map
    public final Set entrySet() {
        b0 b0Var = this.f6177i;
        if (b0Var == null) {
            b0 b0Var2 = new b0(1, this);
            this.f6177i = b0Var2;
            return b0Var2;
        }
        return b0Var;
    }

    public final boolean i(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(Collection collection) {
        int i4 = this.f6196h;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        if (i4 != this.f6196h) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final Set keySet() {
        C0653b c0653b = this.f6178j;
        if (c0653b == null) {
            C0653b c0653b2 = new C0653b(this);
            this.f6178j = c0653b2;
            return c0653b2;
        }
        return c0653b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.f6196h;
        int i4 = this.f6196h;
        int[] iArr = this.f6194f;
        if (iArr.length < size) {
            int[] copyOf = Arrays.copyOf(iArr, size);
            T2.h.d(copyOf, "copyOf(this, newSize)");
            this.f6194f = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f6195g, size * 2);
            T2.h.d(copyOf2, "copyOf(this, newSize)");
            this.f6195g = copyOf2;
        }
        if (this.f6196h == i4) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Map
    public final Collection values() {
        C0655d c0655d = this.k;
        if (c0655d == null) {
            C0655d c0655d2 = new C0655d(this);
            this.k = c0655d2;
            return c0655d2;
        }
        return c0655d;
    }
}
