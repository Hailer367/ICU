package d0;

import A2.m;
import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* loaded from: classes.dex */
public final class i extends e {

    /* renamed from: c, reason: collision with root package name */
    public final OnBackInvokedDispatcher f3455c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3456d;

    /* renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f3457e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3458f;

    public i(OnBackInvokedDispatcher onBackInvokedDispatcher, int i4) {
        OnBackInvokedCallback kVar;
        this.f3455c = onBackInvokedDispatcher;
        this.f3456d = i4;
        if (Build.VERSION.SDK_INT == 33) {
            kVar = new j(0, this);
        } else {
            kVar = new k(0, this);
        }
        this.f3457e = kVar;
    }

    @Override // d0.e
    public final void b(boolean z) {
        if (z && !this.f3458f) {
            m.x(this.f3455c, this.f3456d, this.f3457e);
            this.f3458f = true;
        } else if (!z && this.f3458f) {
            m.B(this.f3455c, this.f3457e);
            this.f3458f = false;
        }
    }
}
