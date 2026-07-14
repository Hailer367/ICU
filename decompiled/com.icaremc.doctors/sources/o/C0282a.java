package o;

import java.util.HashMap;

/* renamed from: o.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0282a extends C0287f {

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f3355g = new HashMap();

    @Override // o.C0287f
    public final C0284c a(Object obj) {
        return (C0284c) this.f3355g.get(obj);
    }

    @Override // o.C0287f
    public final Object b(Object obj, Object obj2) {
        C0284c a2 = a(obj);
        if (a2 != null) {
            return a2.f3360d;
        }
        C0284c c0284c = new C0284c(obj, obj2);
        this.f3369f++;
        C0284c c0284c2 = this.f3367d;
        if (c0284c2 == null) {
            this.f3366c = c0284c;
            this.f3367d = c0284c;
        } else {
            c0284c2.f3361e = c0284c;
            c0284c.f3362f = c0284c2;
            this.f3367d = c0284c;
        }
        this.f3355g.put(obj, c0284c);
        return null;
    }

    @Override // o.C0287f
    public final Object c(Object obj) {
        Object c2 = super.c(obj);
        this.f3355g.remove(obj);
        return c2;
    }
}
