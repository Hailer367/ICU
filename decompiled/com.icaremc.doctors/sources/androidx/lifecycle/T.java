package androidx.lifecycle;

import android.os.Bundle;
import b0.C0163e;
import b0.InterfaceC0162d;
import java.util.Map;

/* loaded from: classes.dex */
public final class T implements InterfaceC0162d {

    /* renamed from: a, reason: collision with root package name */
    public final C0163e f1809a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1810b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1811c;

    /* renamed from: d, reason: collision with root package name */
    public final Q0.h f1812d;

    public T(C0163e savedStateRegistry, d0 d0Var) {
        kotlin.jvm.internal.h.e(savedStateRegistry, "savedStateRegistry");
        this.f1809a = savedStateRegistry;
        this.f1812d = new Q0.h(new K.V(2, d0Var));
    }

    @Override // b0.InterfaceC0162d
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1811c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((U) this.f1812d.a()).f1813d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle a2 = ((O) entry.getValue()).f1802e.a();
            if (!kotlin.jvm.internal.h.a(a2, Bundle.EMPTY)) {
                bundle.putBundle(str, a2);
            }
        }
        this.f1810b = false;
        return bundle;
    }

    public final void b() {
        if (!this.f1810b) {
            Bundle a2 = this.f1809a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f1811c;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (a2 != null) {
                bundle.putAll(a2);
            }
            this.f1811c = bundle;
            this.f1810b = true;
        }
    }
}
