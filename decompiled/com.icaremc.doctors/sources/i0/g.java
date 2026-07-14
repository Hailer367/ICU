package i0;

import a.AbstractC0051a;
import c1.l;

/* loaded from: classes.dex */
public final class g extends AbstractC0051a {

    /* renamed from: f, reason: collision with root package name */
    public final Object f2344f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2345g;

    /* renamed from: h, reason: collision with root package name */
    public final C0204a f2346h;

    public g(Object value, int i2, C0204a c0204a) {
        kotlin.jvm.internal.h.e(value, "value");
        O.a.k(i2, "verificationMode");
        this.f2344f = value;
        this.f2345g = i2;
        this.f2346h = c0204a;
    }

    @Override // a.AbstractC0051a
    public final AbstractC0051a L(String str, l lVar) {
        Object obj = this.f2344f;
        if (((Boolean) lVar.invoke(obj)).booleanValue()) {
            return this;
        }
        return new f(obj, str, this.f2346h, this.f2345g);
    }

    @Override // a.AbstractC0051a
    public final Object f() {
        return this.f2344f;
    }
}
