package androidx.datastore.preferences.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import t.C0654c;
import t.C0656e;

/* loaded from: classes.dex */
public class b0 extends AbstractSet {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2619f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Map f2620g;

    public /* synthetic */ b0(int i4, Map map) {
        this.f2619f = i4;
        this.f2620g = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        switch (this.f2619f) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    ((Y) this.f2620g).put((Comparable) entry.getKey(), entry.getValue());
                    return true;
                }
                return false;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f2619f) {
            case 0:
                ((Y) this.f2620g).clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f2619f) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((Y) this.f2620g).get(entry.getKey());
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
        switch (this.f2619f) {
            case 0:
                return new a0((Y) this.f2620g);
            default:
                return new C0654c((C0656e) this.f2620g);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f2619f) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    ((Y) this.f2620g).remove(entry.getKey());
                    return true;
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f2619f) {
            case 0:
                return ((Y) this.f2620g).size();
            default:
                return ((C0656e) this.f2620g).f6196h;
        }
    }
}
