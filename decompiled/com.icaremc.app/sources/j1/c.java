package j1;

import a.AbstractC0141a;

/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: h, reason: collision with root package name */
    public final transient e f5043h;

    public c(e eVar) {
        this.f5043h = eVar;
    }

    @Override // j1.e, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f5043h.contains(obj);
    }

    @Override // j1.e
    public final e e() {
        return this.f5043h;
    }

    @Override // j1.e, java.util.List
    /* renamed from: f */
    public final e subList(int i4, int i5) {
        e eVar = this.f5043h;
        AbstractC0141a.T(i4, i5, eVar.size());
        return eVar.subList(eVar.size() - i5, eVar.size() - i4).e();
    }

    @Override // java.util.List
    public final Object get(int i4) {
        e eVar = this.f5043h;
        AbstractC0141a.R(i4, eVar.size());
        return eVar.get((eVar.size() - 1) - i4);
    }

    @Override // j1.e, java.util.List
    public final int indexOf(Object obj) {
        int lastIndexOf = this.f5043h.lastIndexOf(obj);
        if (lastIndexOf < 0) {
            return -1;
        }
        return (r0.size() - 1) - lastIndexOf;
    }

    @Override // j1.e, java.util.List
    public final int lastIndexOf(Object obj) {
        int indexOf = this.f5043h.indexOf(obj);
        if (indexOf < 0) {
            return -1;
        }
        return (r0.size() - 1) - indexOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5043h.size();
    }
}
