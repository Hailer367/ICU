package q0;

import android.webkit.SafeBrowsingResponse;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import p0.AbstractC0567f;

/* loaded from: classes.dex */
public final class k extends AbstractC0567f {

    /* renamed from: a, reason: collision with root package name */
    public SafeBrowsingResponse f5872a;

    /* renamed from: b, reason: collision with root package name */
    public SafeBrowsingResponseBoundaryInterface f5873b;

    @Override // p0.AbstractC0567f
    public final void a(boolean z) {
        C0597b c0597b = x.f5920o;
        if (c0597b.a()) {
            c().showInterstitial(z);
        } else {
            if (c0597b.b()) {
                b().showInterstitial(z);
                return;
            }
            throw x.a();
        }
    }

    public final SafeBrowsingResponseBoundaryInterface b() {
        if (this.f5873b == null) {
            C0595C c0595c = y.f5931a;
            this.f5873b = (SafeBrowsingResponseBoundaryInterface) k3.b.b(SafeBrowsingResponseBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) c0595c.f5856b).convertSafeBrowsingResponse(this.f5872a));
        }
        return this.f5873b;
    }

    public final SafeBrowsingResponse c() {
        if (this.f5872a == null) {
            C0595C c0595c = y.f5931a;
            this.f5872a = AbstractC0599d.b(((WebkitToCompatConverterBoundaryInterface) c0595c.f5856b).convertSafeBrowsingResponse(Proxy.getInvocationHandler(this.f5873b)));
        }
        return this.f5872a;
    }
}
