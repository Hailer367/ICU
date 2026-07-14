package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.InterfaceC0140j;
import b0.C0163e;
import b0.C0164f;
import b0.InterfaceC0165g;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class A0 implements InterfaceC0140j, InterfaceC0165g, androidx.lifecycle.d0 {

    /* renamed from: c, reason: collision with root package name */
    public final H f1497c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.lifecycle.c0 f1498d;

    /* renamed from: e, reason: collision with root package name */
    public final RunnableC0127w f1499e;

    /* renamed from: f, reason: collision with root package name */
    public C0152w f1500f = null;

    /* renamed from: g, reason: collision with root package name */
    public C0164f f1501g = null;

    public A0(H h2, androidx.lifecycle.c0 c0Var, RunnableC0127w runnableC0127w) {
        this.f1497c = h2;
        this.f1498d = c0Var;
        this.f1499e = runnableC0127w;
    }

    public final void a(EnumC0144n enumC0144n) {
        this.f1500f.e(enumC0144n);
    }

    public final void b() {
        if (this.f1500f == null) {
            this.f1500f = new C0152w(this);
            C0164f c0164f = new C0164f(this);
            this.f1501g = c0164f;
            c0164f.a();
            this.f1499e.run();
        }
    }

    @Override // androidx.lifecycle.InterfaceC0140j
    public final T.b getDefaultViewModelCreationExtras() {
        Application application;
        H h2 = this.f1497c;
        Context applicationContext = h2.requireContext().getApplicationContext();
        while (true) {
            if (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            } else {
                application = null;
                break;
            }
        }
        T.c cVar = new T.c(0);
        LinkedHashMap linkedHashMap = cVar.f768a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.Y.f1824a, application);
        }
        linkedHashMap.put(androidx.lifecycle.S.f1806a, h2);
        linkedHashMap.put(androidx.lifecycle.S.f1807b, this);
        if (h2.getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.S.f1808c, h2.getArguments());
        }
        return cVar;
    }

    @Override // androidx.lifecycle.InterfaceC0150u
    public final AbstractC0146p getLifecycle() {
        b();
        return this.f1500f;
    }

    @Override // b0.InterfaceC0165g
    public final C0163e getSavedStateRegistry() {
        b();
        return this.f1501g.f1980b;
    }

    @Override // androidx.lifecycle.d0
    public final androidx.lifecycle.c0 getViewModelStore() {
        b();
        return this.f1498d;
    }
}
