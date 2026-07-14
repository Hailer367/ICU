package b3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class P extends W {

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3251h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P() {
        super(true);
        C0236k c0236k;
        C0236k c0236k2;
        boolean z = true;
        C(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = W.f3263g;
        InterfaceC0235j interfaceC0235j = (InterfaceC0235j) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0235j instanceof C0236k) {
            c0236k = (C0236k) interfaceC0235j;
        } else {
            c0236k = null;
        }
        if (c0236k != null) {
            W i4 = c0236k.i();
            while (!i4.x()) {
                InterfaceC0235j interfaceC0235j2 = (InterfaceC0235j) atomicReferenceFieldUpdater.get(i4);
                if (interfaceC0235j2 instanceof C0236k) {
                    c0236k2 = (C0236k) interfaceC0235j2;
                } else {
                    c0236k2 = null;
                }
                if (c0236k2 != null) {
                    i4 = c0236k2.i();
                }
            }
            this.f3251h = z;
        }
        z = false;
        this.f3251h = z;
    }

    @Override // b3.W
    public final boolean x() {
        return this.f3251h;
    }

    @Override // b3.W
    public final boolean y() {
        return true;
    }
}
