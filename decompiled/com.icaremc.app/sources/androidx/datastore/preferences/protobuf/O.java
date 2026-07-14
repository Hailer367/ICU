package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class O implements W {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0144a f2588a;

    /* renamed from: b, reason: collision with root package name */
    public final e0 f2589b;

    /* renamed from: c, reason: collision with root package name */
    public final C0159p f2590c;

    public O(e0 e0Var, C0159p c0159p, AbstractC0144a abstractC0144a) {
        this.f2589b = e0Var;
        c0159p.getClass();
        this.f2590c = c0159p;
        this.f2588a = abstractC0144a;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void a(Object obj, Object obj2) {
        X.k(this.f2589b, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void b(Object obj, F f4) {
        this.f2590c.getClass();
        A2.i.o(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final int c(AbstractC0165w abstractC0165w) {
        this.f2589b.getClass();
        return abstractC0165w.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void d(Object obj) {
        this.f2589b.getClass();
        d0 d0Var = ((AbstractC0165w) obj).unknownFields;
        if (d0Var.f2631e) {
            d0Var.f2631e = false;
        }
        this.f2590c.getClass();
        A2.i.o(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final boolean e(Object obj) {
        this.f2590c.getClass();
        A2.i.o(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final boolean f(AbstractC0165w abstractC0165w, AbstractC0165w abstractC0165w2) {
        this.f2589b.getClass();
        if (!abstractC0165w.unknownFields.equals(abstractC0165w2.unknownFields)) {
            return false;
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final void g(Object obj, C0154k c0154k, C0158o c0158o) {
        this.f2589b.getClass();
        e0.a(obj);
        this.f2590c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final int h(AbstractC0165w abstractC0165w) {
        this.f2589b.getClass();
        d0 d0Var = abstractC0165w.unknownFields;
        int i4 = d0Var.f2630d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < d0Var.f2627a; i6++) {
            int i7 = d0Var.f2628b[i6] >>> 3;
            i5 += C0156m.V(3, (C0150g) d0Var.f2629c[i6]) + C0156m.Y(i7) + C0156m.X(2) + (C0156m.X(1) * 2);
        }
        d0Var.f2630d = i5;
        return i5;
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public final AbstractC0165w i() {
        AbstractC0144a abstractC0144a = this.f2588a;
        if (abstractC0144a instanceof AbstractC0165w) {
            return ((AbstractC0165w) abstractC0144a).i();
        }
        return ((AbstractC0163u) ((AbstractC0165w) abstractC0144a).c(5)).b();
    }
}
