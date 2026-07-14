package T1;

import W1.B;
import b2.C0223a;
import b2.C0224b;

/* loaded from: classes.dex */
public class d extends B {

    /* renamed from: a, reason: collision with root package name */
    public s f1608a = null;

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        s sVar = this.f1608a;
        if (sVar != null) {
            return sVar.b(c0223a);
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        s sVar = this.f1608a;
        if (sVar != null) {
            sVar.c(c0224b, obj);
            return;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // W1.B
    public final s d() {
        s sVar = this.f1608a;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }
}
