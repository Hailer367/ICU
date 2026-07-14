package b0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0145o;
import java.util.Map;
import o.C0285d;
import o.C0287f;

/* renamed from: b0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0164f {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0165g f1979a;

    /* renamed from: b, reason: collision with root package name */
    public final C0163e f1980b = new C0163e();

    /* renamed from: c, reason: collision with root package name */
    public boolean f1981c;

    public C0164f(InterfaceC0165g interfaceC0165g) {
        this.f1979a = interfaceC0165g;
    }

    public final void a() {
        InterfaceC0165g interfaceC0165g = this.f1979a;
        AbstractC0146p lifecycle = interfaceC0165g.getLifecycle();
        if (((C0152w) lifecycle).f1855c == EnumC0145o.f1845d) {
            lifecycle.a(new C0160b(interfaceC0165g, 0));
            C0163e c0163e = this.f1980b;
            c0163e.getClass();
            if (!c0163e.f1974b) {
                lifecycle.a(new d.d(2, c0163e));
                c0163e.f1974b = true;
                this.f1981c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public final void b(Bundle bundle) {
        Bundle bundle2;
        if (!this.f1981c) {
            a();
        }
        C0152w c0152w = (C0152w) this.f1979a.getLifecycle();
        if (c0152w.f1855c.compareTo(EnumC0145o.f1847f) < 0) {
            C0163e c0163e = this.f1980b;
            if (c0163e.f1974b) {
                if (!c0163e.f1976d) {
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    } else {
                        bundle2 = null;
                    }
                    c0163e.f1975c = bundle2;
                    c0163e.f1976d = true;
                    return;
                }
                throw new IllegalStateException("SavedStateRegistry was already restored.");
            }
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + c0152w.f1855c).toString());
    }

    public final void c(Bundle bundle) {
        C0163e c0163e = this.f1980b;
        c0163e.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = c0163e.f1975c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C0287f c0287f = c0163e.f1973a;
        c0287f.getClass();
        C0285d c0285d = new C0285d(c0287f);
        c0287f.f3368e.put(c0285d, Boolean.FALSE);
        while (c0285d.hasNext()) {
            Map.Entry entry = (Map.Entry) c0285d.next();
            bundle2.putBundle((String) entry.getKey(), ((InterfaceC0162d) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }
}
