package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class k extends n implements i1.h {
    @Override // kotlin.jvm.internal.b
    public i1.b computeReflected() {
        r.f2790a.getClass();
        return this;
    }

    @Override // i1.h
    public Object getDelegate(Object obj) {
        return ((i1.h) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ i1.f getGetter() {
        mo3getGetter();
        return null;
    }

    @Override // c1.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // i1.h
    /* renamed from: getGetter, reason: collision with other method in class */
    public i1.g mo3getGetter() {
        ((i1.h) getReflected()).mo3getGetter();
        return null;
    }
}
