package s0;

import A2.i;
import S2.l;
import f1.AbstractC0286a;

/* loaded from: classes.dex */
public final class g extends AbstractC0286a {

    /* renamed from: d, reason: collision with root package name */
    public final Object f6138d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6139e;

    /* renamed from: f, reason: collision with root package name */
    public final C0628a f6140f;

    public g(Object obj, int i4, C0628a c0628a) {
        T2.h.e(obj, "value");
        i.m(i4, "verificationMode");
        this.f6138d = obj;
        this.f6139e = i4;
        this.f6140f = c0628a;
    }

    @Override // f1.AbstractC0286a
    public final AbstractC0286a E(String str, l lVar) {
        Object obj = this.f6138d;
        if (((Boolean) lVar.f(obj)).booleanValue()) {
            return this;
        }
        return new f(obj, str, this.f6140f, this.f6139e);
    }

    @Override // f1.AbstractC0286a
    public final Object b() {
        return this.f6138d;
    }
}
