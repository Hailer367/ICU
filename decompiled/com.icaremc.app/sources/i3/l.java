package i3;

import b3.AbstractC0242q;

/* loaded from: classes.dex */
public final class l extends AbstractC0242q {

    /* renamed from: h, reason: collision with root package name */
    public static final l f4186h = new AbstractC0242q();

    @Override // b3.AbstractC0242q
    public final void d(K2.i iVar, Runnable runnable) {
        e.f4174i.f4176h.b(runnable, true);
    }

    @Override // b3.AbstractC0242q
    public final AbstractC0242q g(int i4) {
        g3.a.a(i4);
        if (i4 >= k.f4183d) {
            return this;
        }
        return super.g(i4);
    }

    @Override // b3.AbstractC0242q
    public final String toString() {
        return "Dispatchers.IO";
    }
}
