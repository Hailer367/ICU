package androidx.lifecycle;

import android.os.Bundle;
import i0.C0362e;
import i0.InterfaceC0361d;
import java.util.Map;

/* loaded from: classes.dex */
public final class N implements InterfaceC0361d {

    /* renamed from: a, reason: collision with root package name */
    public final C0362e f2981a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2982b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f2983c;

    /* renamed from: d, reason: collision with root package name */
    public final H2.g f2984d;

    public N(C0362e c0362e, Y y3) {
        T2.h.e(c0362e, "savedStateRegistry");
        this.f2981a = c0362e;
        this.f2984d = new H2.g(new O.S(2, y3));
    }

    @Override // i0.InterfaceC0361d
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2983c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((O) this.f2984d.a()).f2985d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle a4 = ((J) entry.getValue()).f2974e.a();
            if (!T2.h.a(a4, Bundle.EMPTY)) {
                bundle.putBundle(str, a4);
            }
        }
        this.f2982b = false;
        return bundle;
    }

    public final void b() {
        if (!this.f2982b) {
            Bundle a4 = this.f2981a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f2983c;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (a4 != null) {
                bundle.putAll(a4);
            }
            this.f2983c = bundle;
            this.f2982b = true;
        }
    }
}
