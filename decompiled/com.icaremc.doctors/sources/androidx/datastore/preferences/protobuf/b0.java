package androidx.datastore.preferences.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import r.C0291c;
import r.C0293e;

/* loaded from: classes.dex */
public class b0 extends AbstractSet {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1401c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f1402d;

    public /* synthetic */ b0(int i2, Map map) {
        this.f1401c = i2;
        this.f1402d = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        switch (this.f1401c) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    ((Y) this.f1402d).put((Comparable) entry.getKey(), entry.getValue());
                    return true;
                }
                return false;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f1401c) {
            case 0:
                ((Y) this.f1402d).clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f1401c) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((Y) this.f1402d).get(entry.getKey());
                Object value = entry.getValue();
                if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                    return false;
                }
                return true;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        switch (this.f1401c) {
            case 0:
                return new a0((Y) this.f1402d);
            default:
                return new C0291c((C0293e) this.f1402d);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f1401c) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    ((Y) this.f1402d).remove(entry.getKey());
                    return true;
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f1401c) {
            case 0:
                return ((Y) this.f1402d).size();
            default:
                return ((C0293e) this.f1402d).f3573e;
        }
    }
}
