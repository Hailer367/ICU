package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: c, reason: collision with root package name */
    public final E f1779c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1780d;

    /* renamed from: e, reason: collision with root package name */
    public int f1781e = -1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C f1782f;

    public B(C c2, E e2) {
        this.f1782f = c2;
        this.f1779c = e2;
    }

    public final void b(boolean z) {
        int i2;
        if (z != this.f1780d) {
            this.f1780d = z;
            if (z) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            C c2 = this.f1782f;
            c2.changeActiveCounter(i2);
            if (this.f1780d) {
                c2.dispatchingValue(this);
            }
        }
    }

    public void c() {
    }

    public boolean d(InterfaceC0150u interfaceC0150u) {
        return false;
    }

    public abstract boolean e();
}
