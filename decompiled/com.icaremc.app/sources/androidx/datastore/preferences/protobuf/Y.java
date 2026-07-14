package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class Y extends AbstractMap {
    public static final /* synthetic */ int k = 0;

    /* renamed from: f, reason: collision with root package name */
    public List f2606f;

    /* renamed from: g, reason: collision with root package name */
    public Map f2607g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2608h;

    /* renamed from: i, reason: collision with root package name */
    public volatile b0 f2609i;

    /* renamed from: j, reason: collision with root package name */
    public Map f2610j;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.datastore.preferences.protobuf.Y, java.util.AbstractMap] */
    public static Y f() {
        ?? abstractMap = new AbstractMap();
        abstractMap.f2606f = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        abstractMap.f2607g = map;
        abstractMap.f2610j = map;
        return abstractMap;
    }

    public final int a(Comparable comparable) {
        int i4;
        int size = this.f2606f.size();
        int i5 = size - 1;
        if (i5 >= 0) {
            int compareTo = comparable.compareTo(((Z) this.f2606f.get(i5)).f2611f);
            if (compareTo > 0) {
                i4 = size + 1;
                return -i4;
            }
            if (compareTo == 0) {
                return i5;
            }
        }
        int i6 = 0;
        while (i6 <= i5) {
            int i7 = (i6 + i5) / 2;
            int compareTo2 = comparable.compareTo(((Z) this.f2606f.get(i7)).f2611f);
            if (compareTo2 < 0) {
                i5 = i7 - 1;
            } else if (compareTo2 > 0) {
                i6 = i7 + 1;
            } else {
                return i7;
            }
        }
        i4 = i6 + 1;
        return -i4;
    }

    public final void b() {
        if (!this.f2608h) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i4) {
        return (Map.Entry) this.f2606f.get(i4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f2606f.isEmpty()) {
            this.f2606f.clear();
        }
        if (!this.f2607g.isEmpty()) {
            this.f2607g.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (a(comparable) < 0 && !this.f2607g.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    public final Set d() {
        if (this.f2607g.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return this.f2607g.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f2607g.isEmpty() && !(this.f2607g instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2607g = treeMap;
            this.f2610j = treeMap.descendingMap();
        }
        return (SortedMap) this.f2607g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f2609i == null) {
            this.f2609i = new b0(0, this);
        }
        return this.f2609i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Y)) {
                return super.equals(obj);
            }
            Y y3 = (Y) obj;
            int size = size();
            if (size == y3.size()) {
                int size2 = this.f2606f.size();
                if (size2 != y3.f2606f.size()) {
                    return ((AbstractSet) entrySet()).equals(y3.entrySet());
                }
                for (int i4 = 0; i4 < size2; i4++) {
                    if (c(i4).equals(y3.c(i4))) {
                    }
                }
                if (size2 != size) {
                    return this.f2607g.equals(y3.f2607g);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int a4 = a(comparable);
        if (a4 >= 0) {
            return ((Z) this.f2606f.get(a4)).setValue(obj);
        }
        b();
        if (this.f2606f.isEmpty() && !(this.f2606f instanceof ArrayList)) {
            this.f2606f = new ArrayList(16);
        }
        int i4 = -(a4 + 1);
        if (i4 >= 16) {
            return e().put(comparable, obj);
        }
        if (this.f2606f.size() == 16) {
            Z z = (Z) this.f2606f.remove(15);
            e().put(z.f2611f, z.f2612g);
        }
        this.f2606f.add(i4, new Z(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a4 = a(comparable);
        if (a4 >= 0) {
            return ((Z) this.f2606f.get(a4)).f2612g;
        }
        return this.f2607g.get(comparable);
    }

    public final Object h(int i4) {
        b();
        Object obj = ((Z) this.f2606f.remove(i4)).f2612g;
        if (!this.f2607g.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f2606f;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new Z(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f2606f.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += ((Z) this.f2606f.get(i5)).hashCode();
        }
        if (this.f2607g.size() > 0) {
            return this.f2607g.hashCode() + i4;
        }
        return i4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int a4 = a(comparable);
        if (a4 >= 0) {
            return h(a4);
        }
        if (this.f2607g.isEmpty()) {
            return null;
        }
        return this.f2607g.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f2607g.size() + this.f2606f.size();
    }
}
