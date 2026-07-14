package d;

import androidx.lifecycle.InterfaceC0150u;

/* loaded from: classes.dex */
public final class q extends W.e {

    /* renamed from: a, reason: collision with root package name */
    public final p f2147a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0150u f2148b;

    public q(InterfaceC0150u interfaceC0150u, p callback) {
        kotlin.jvm.internal.h.e(callback, "callback");
        this.f2147a = callback;
        this.f2148b = interfaceC0150u;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (kotlin.jvm.internal.h.a(this.f2147a, qVar.f2147a) && kotlin.jvm.internal.h.a(this.f2148b, qVar.f2148b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.f2147a.hashCode() * 31;
        InterfaceC0150u interfaceC0150u = this.f2148b;
        if (interfaceC0150u == null) {
            hashCode = 0;
        } else {
            hashCode = interfaceC0150u.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.f2147a + ", owner=" + this.f2148b + ')';
    }
}
