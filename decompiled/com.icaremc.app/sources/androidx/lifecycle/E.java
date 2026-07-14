package androidx.lifecycle;

import android.os.Handler;

/* loaded from: classes.dex */
public final class E implements InterfaceC0212t {

    /* renamed from: n, reason: collision with root package name */
    public static final E f2957n = new E();

    /* renamed from: f, reason: collision with root package name */
    public int f2958f;

    /* renamed from: g, reason: collision with root package name */
    public int f2959g;

    /* renamed from: j, reason: collision with root package name */
    public Handler f2962j;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2960h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2961i = true;
    public final C0214v k = new C0214v(this);

    /* renamed from: l, reason: collision with root package name */
    public final A.k f2963l = new A.k(7, this);

    /* renamed from: m, reason: collision with root package name */
    public final A2.q f2964m = new A2.q(17, this);

    public final void a() {
        int i4 = this.f2959g + 1;
        this.f2959g = i4;
        if (i4 == 1) {
            if (this.f2960h) {
                this.k.e(EnumC0206m.ON_RESUME);
                this.f2960h = false;
            } else {
                Handler handler = this.f2962j;
                T2.h.b(handler);
                handler.removeCallbacks(this.f2963l);
            }
        }
    }

    @Override // androidx.lifecycle.InterfaceC0212t
    public final AbstractC0208o getLifecycle() {
        return this.k;
    }
}
