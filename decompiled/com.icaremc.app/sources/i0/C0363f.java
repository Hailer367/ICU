package i0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.C0214v;
import androidx.lifecycle.EnumC0207n;
import e.C0269d;
import java.util.Map;
import q.C0590d;
import q.C0592f;

/* renamed from: i0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0363f {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0364g f4100a;

    /* renamed from: b, reason: collision with root package name */
    public final C0362e f4101b = new C0362e();

    /* renamed from: c, reason: collision with root package name */
    public boolean f4102c;

    public C0363f(InterfaceC0364g interfaceC0364g) {
        this.f4100a = interfaceC0364g;
    }

    public final void a() {
        InterfaceC0364g interfaceC0364g = this.f4100a;
        AbstractC0208o lifecycle = interfaceC0364g.getLifecycle();
        if (((C0214v) lifecycle).f3024c == EnumC0207n.f3015g) {
            lifecycle.a(new C0359b(0, interfaceC0364g));
            C0362e c0362e = this.f4101b;
            c0362e.getClass();
            if (!c0362e.f4095b) {
                lifecycle.a(new C0269d(2, c0362e));
                c0362e.f4095b = true;
                this.f4102c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public final void b(Bundle bundle) {
        Bundle bundle2;
        if (!this.f4102c) {
            a();
        }
        C0214v c0214v = (C0214v) this.f4100a.getLifecycle();
        if (c0214v.f3024c.compareTo(EnumC0207n.f3017i) < 0) {
            C0362e c0362e = this.f4101b;
            if (c0362e.f4095b) {
                if (!c0362e.f4097d) {
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    } else {
                        bundle2 = null;
                    }
                    c0362e.f4096c = bundle2;
                    c0362e.f4097d = true;
                    return;
                }
                throw new IllegalStateException("SavedStateRegistry was already restored.");
            }
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + c0214v.f3024c).toString());
    }

    public final void c(Bundle bundle) {
        C0362e c0362e = this.f4101b;
        c0362e.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = c0362e.f4096c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C0592f c0592f = c0362e.f4094a;
        c0592f.getClass();
        C0590d c0590d = new C0590d(c0592f);
        c0592f.f5851h.put(c0590d, Boolean.FALSE);
        while (c0590d.hasNext()) {
            Map.Entry entry = (Map.Entry) c0590d.next();
            bundle2.putBundle((String) entry.getKey(), ((InterfaceC0361d) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }
}
