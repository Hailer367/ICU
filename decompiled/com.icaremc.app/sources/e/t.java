package e;

import android.window.OnBackInvokedDispatcher;
import d2.C0262c;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f3584a;

    /* renamed from: b, reason: collision with root package name */
    public final H2.g f3585b = new H2.g(new C0262c(1, this));

    public t(Runnable runnable) {
        this.f3584a = runnable;
    }

    public final r a() {
        return (r) this.f3585b.a();
    }

    public final void b(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        a().f3580c.b(new d0.i(onBackInvokedDispatcher, 0), 1);
        a().f3580c.b(new d0.i(onBackInvokedDispatcher, 1000000), 0);
    }
}
