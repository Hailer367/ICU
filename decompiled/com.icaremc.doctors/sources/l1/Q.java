package l1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class Q extends X {

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2965e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q() {
        super(true);
        C0234l c0234l;
        C0234l c0234l2;
        boolean z = true;
        B(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X.f2977d;
        InterfaceC0233k interfaceC0233k = (InterfaceC0233k) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0233k instanceof C0234l) {
            c0234l = (C0234l) interfaceC0233k;
        } else {
            c0234l = null;
        }
        if (c0234l != null) {
            X i2 = c0234l.i();
            while (!i2.w()) {
                InterfaceC0233k interfaceC0233k2 = (InterfaceC0233k) atomicReferenceFieldUpdater.get(i2);
                if (interfaceC0233k2 instanceof C0234l) {
                    c0234l2 = (C0234l) interfaceC0233k2;
                } else {
                    c0234l2 = null;
                }
                if (c0234l2 != null) {
                    i2 = c0234l2.i();
                }
            }
            this.f2965e = z;
        }
        z = false;
        this.f2965e = z;
    }

    @Override // l1.X
    public final boolean w() {
        return this.f2965e;
    }

    @Override // l1.X
    public final boolean x() {
        return true;
    }
}
