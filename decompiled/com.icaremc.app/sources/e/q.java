package e;

import androidx.fragment.app.G;
import androidx.lifecycle.InterfaceC0212t;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final G f3578a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3579b;

    public q(G g4, InterfaceC0212t interfaceC0212t) {
        T2.h.e(g4, "callback");
        this.f3578a = g4;
        this.f3579b = interfaceC0212t;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof q) {
                q qVar = (q) obj;
                if (!T2.h.a(this.f3578a, qVar.f3578a) || !this.f3579b.equals(qVar.f3579b)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f3579b.hashCode() + (this.f3578a.hashCode() * 31);
    }

    public final String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.f3578a + ", owner=" + this.f3579b + ')';
    }
}
