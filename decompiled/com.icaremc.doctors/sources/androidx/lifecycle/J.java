package androidx.lifecycle;

import android.os.Handler;

/* loaded from: classes.dex */
public final class J implements InterfaceC0150u {

    /* renamed from: k, reason: collision with root package name */
    public static final J f1784k = new J();

    /* renamed from: c, reason: collision with root package name */
    public int f1785c;

    /* renamed from: d, reason: collision with root package name */
    public int f1786d;

    /* renamed from: g, reason: collision with root package name */
    public Handler f1789g;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1787e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1788f = true;

    /* renamed from: h, reason: collision with root package name */
    public final C0152w f1790h = new C0152w(this);

    /* renamed from: i, reason: collision with root package name */
    public final B0.o f1791i = new B0.o(1, this);

    /* renamed from: j, reason: collision with root package name */
    public final I f1792j = new I(this);

    public final void a() {
        int i2 = this.f1786d + 1;
        this.f1786d = i2;
        if (i2 == 1) {
            if (this.f1787e) {
                this.f1790h.e(EnumC0144n.ON_RESUME);
                this.f1787e = false;
            } else {
                Handler handler = this.f1789g;
                kotlin.jvm.internal.h.b(handler);
                handler.removeCallbacks(this.f1791i);
            }
        }
    }

    @Override // androidx.lifecycle.InterfaceC0150u
    public final AbstractC0146p getLifecycle() {
        return this.f1790h;
    }
}
