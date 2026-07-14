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

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f1387h = 0;

    /* renamed from: c, reason: collision with root package name */
    public List f1388c;

    /* renamed from: d, reason: collision with root package name */
    public Map f1389d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1390e;

    /* renamed from: f, reason: collision with root package name */
    public volatile b0 f1391f;

    /* renamed from: g, reason: collision with root package name */
    public Map f1392g;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.datastore.preferences.protobuf.Y, java.util.AbstractMap] */
    public static Y f() {
        ?? abstractMap = new AbstractMap();
        abstractMap.f1388c = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        abstractMap.f1389d = map;
        abstractMap.f1392g = map;
        return abstractMap;
    }

    public final int a(Comparable comparable) {
        int i2;
        int size = this.f1388c.size();
        int i3 = size - 1;
        if (i3 >= 0) {
            int compareTo = comparable.compareTo(((Z) this.f1388c.get(i3)).f1393c);
            if (compareTo > 0) {
                i2 = size + 1;
                return -i2;
            }
            if (compareTo == 0) {
                return i3;
            }
        }
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) / 2;
            int compareTo2 = comparable.compareTo(((Z) this.f1388c.get(i5)).f1393c);
            if (compareTo2 < 0) {
                i3 = i5 - 1;
            } else if (compareTo2 > 0) {
                i4 = i5 + 1;
            } else {
                return i5;
            }
        }
        i2 = i4 + 1;
        return -i2;
    }

    public final void b() {
        if (!this.f1390e) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i2) {
        return (Map.Entry) this.f1388c.get(i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f1388c.isEmpty()) {
            this.f1388c.clear();
        }
        if (!this.f1389d.isEmpty()) {
            this.f1389d.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (a(comparable) < 0 && !this.f1389d.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    public final Set d() {
        if (this.f1389d.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return this.f1389d.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f1389d.isEmpty() && !(this.f1389d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f1389d = treeMap;
            this.f1392g = treeMap.descendingMap();
        }
        return (SortedMap) this.f1389d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f1391f == null) {
            this.f1391f = new b0(0, this);
        }
        return this.f1391f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Y)) {
                return super.equals(obj);
            }
            Y y = (Y) obj;
            int size = size();
            if (size == y.size()) {
                int size2 = this.f1388c.size();
                if (size2 != y.f1388c.size()) {
                    return ((AbstractSet) entrySet()).equals(y.entrySet());
                }
                for (int i2 = 0; i2 < size2; i2++) {
                    if (c(i2).equals(y.c(i2))) {
                    }
                }
                if (size2 != size) {
                    return this.f1389d.equals(y.f1389d);
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
        int a2 = a(comparable);
        if (a2 >= 0) {
            return ((Z) this.f1388c.get(a2)).setValue(obj);
        }
        b();
        if (this.f1388c.isEmpty() && !(this.f1388c instanceof ArrayList)) {
            this.f1388c = new ArrayList(16);
        }
        int i2 = -(a2 + 1);
        if (i2 >= 16) {
            return e().put(comparable, obj);
        }
        if (this.f1388c.size() == 16) {
            Z z = (Z) this.f1388c.remove(15);
            e().put(z.f1393c, z.f1394d);
        }
        this.f1388c.add(i2, new Z(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return ((Z) this.f1388c.get(a2)).f1394d;
        }
        return this.f1389d.get(comparable);
    }

    public final Object h(int i2) {
        b();
        Object obj = ((Z) this.f1388c.remove(i2)).f1394d;
        if (!this.f1389d.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f1388c;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new Z(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f1388c.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += ((Z) this.f1388c.get(i3)).hashCode();
        }
        if (this.f1389d.size() > 0) {
            return this.f1389d.hashCode() + i2;
        }
        return i2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return h(a2);
        }
        if (this.f1389d.isEmpty()) {
            return null;
        }
        return this.f1389d.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f1389d.size() + this.f1388c.size();
    }
}
