package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class O implements W {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0074a f1369a;

    /* renamed from: b, reason: collision with root package name */
    public final e0 f1370b;

    /* renamed from: c, reason: collision with root package name */
    public final C0089p f1371c;

    public O(e0 e0Var, C0089p c0089p, AbstractC0074a abstractC0074a) {
        this.f1370b = e0Var;
        c0089p.getClass();
        this.f1371c = c0089p;
        this.f1369a = abstractC0074a;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void a(Object obj, Object obj2) {
        X.k(this.f1370b, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void b(Object obj, F f2) {
        this.f1371c.getClass();
        O.a.l(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final int c(AbstractC0095w abstractC0095w) {
        this.f1370b.getClass();
        return abstractC0095w.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void d(Object obj) {
        this.f1370b.getClass();
        d0 d0Var = ((AbstractC0095w) obj).unknownFields;
        if (d0Var.f1413e) {
            d0Var.f1413e = false;
        }
        this.f1371c.getClass();
        O.a.l(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final boolean e(Object obj) {
        this.f1371c.getClass();
        O.a.l(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final boolean f(AbstractC0095w abstractC0095w, AbstractC0095w abstractC0095w2) {
        this.f1370b.getClass();
        if (!abstractC0095w.unknownFields.equals(abstractC0095w2.unknownFields)) {
            return false;
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void g(Object obj, C0084k c0084k, C0088o c0088o) {
        this.f1370b.getClass();
        e0.a(obj);
        this.f1371c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final int h(AbstractC0095w abstractC0095w) {
        this.f1370b.getClass();
        d0 d0Var = abstractC0095w.unknownFields;
        int i2 = d0Var.f1412d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < d0Var.f1409a; i4++) {
            int i5 = d0Var.f1410b[i4] >>> 3;
            i3 += C0086m.S(3, (C0080g) d0Var.f1411c[i4]) + C0086m.V(i5) + C0086m.U(2) + (C0086m.U(1) * 2);
        }
        d0Var.f1412d = i3;
        return i3;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final AbstractC0095w i() {
        AbstractC0074a abstractC0074a = this.f1369a;
        if (abstractC0074a instanceof AbstractC0095w) {
            return ((AbstractC0095w) abstractC0074a).i();
        }
        return ((AbstractC0093u) ((AbstractC0095w) abstractC0074a).c(5)).b();
    }
}
