package d;

import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0145o;
import androidx.lifecycle.InterfaceC0150u;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f2153a;

    /* renamed from: b, reason: collision with root package name */
    public final Q0.h f2154b = new Q0.h(new K0.b(1, this));

    public t(Runnable runnable) {
        this.f2153a = runnable;
    }

    public final void a(InterfaceC0150u interfaceC0150u, p onBackPressedCallback) {
        kotlin.jvm.internal.h.e(onBackPressedCallback, "onBackPressedCallback");
        AbstractC0146p lifecycle = interfaceC0150u.getLifecycle();
        if (((C0152w) lifecycle).f1855c == EnumC0145o.f1844c) {
            return;
        }
        o createNavigationEventHandler$activity = onBackPressedCallback.createNavigationEventHandler$activity(new q(interfaceC0150u, onBackPressedCallback));
        createNavigationEventHandler$activity.b(false);
        W.c cVar = b().f2149c;
        cVar.getClass();
        if (cVar.f796c.add(createNavigationEventHandler$activity)) {
            W.g gVar = cVar.f795b;
            gVar.getClass();
            if (createNavigationEventHandler$activity.f2144e == null) {
                gVar.f806e.addFirst(createNavigationEventHandler$activity);
                createNavigationEventHandler$activity.f2144e = cVar;
                gVar.b();
            } else {
                throw new IllegalArgumentException(("Handler '" + createNavigationEventHandler$activity + "' is already registered with a dispatcher").toString());
            }
        }
        s sVar = new s(createNavigationEventHandler$activity, this, lifecycle);
        lifecycle.a(sVar);
        onBackPressedCallback.addCloseable$activity(sVar);
    }

    public final r b() {
        return (r) this.f2154b.a();
    }

    public final void c(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        b().f2149c.b(new W.j(onBackInvokedDispatcher, 0), 1);
        b().f2149c.b(new W.j(onBackInvokedDispatcher, 1000000), 0);
    }
}
