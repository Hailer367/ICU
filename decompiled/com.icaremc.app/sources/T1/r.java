package T1;

import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public final class r extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f1626a;

    public r(s sVar) {
        this.f1626a = sVar;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        return this.f1626a.b(c0223a);
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        if (obj == null) {
            c0224b.i();
        } else {
            this.f1626a.c(c0224b, obj);
        }
    }

    public final String toString() {
        return "NullSafeTypeAdapter[" + this.f1626a + "]";
    }
}
