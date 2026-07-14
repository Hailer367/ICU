package W;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* loaded from: classes.dex */
public final class j extends f {

    /* renamed from: c, reason: collision with root package name */
    public final OnBackInvokedDispatcher f818c;

    /* renamed from: d, reason: collision with root package name */
    public final int f819d;

    /* renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f820e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f821f;

    public j(OnBackInvokedDispatcher onBackInvokedDispatcher, int i2) {
        OnBackInvokedCallback lVar;
        this.f818c = onBackInvokedDispatcher;
        this.f819d = i2;
        if (Build.VERSION.SDK_INT == 33) {
            lVar = new OnBackInvokedCallback() { // from class: W.k
                public final void onBackInvoked() {
                    j.this.a();
                }
            };
        } else {
            lVar = new l(this);
        }
        this.f820e = lVar;
    }

    @Override // W.f
    public final void b(boolean z) {
        if (z && !this.f821f) {
            this.f818c.registerOnBackInvokedCallback(this.f819d, this.f820e);
            this.f821f = true;
        } else if (!z && this.f821f) {
            this.f818c.unregisterOnBackInvokedCallback(this.f820e);
            this.f821f = false;
        }
    }
}
