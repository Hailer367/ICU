package q0;

import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import p0.AbstractC0571j;

/* loaded from: classes.dex */
public final class m extends AbstractC0571j {

    /* renamed from: a, reason: collision with root package name */
    public ServiceWorkerController f5875a;

    /* renamed from: b, reason: collision with root package name */
    public final ServiceWorkerControllerBoundaryInterface f5876b;

    /* renamed from: c, reason: collision with root package name */
    public final C0595C f5877c;

    public m() {
        x.f5913g.getClass();
        ServiceWorkerController serviceWorkerController = ServiceWorkerController.getInstance();
        this.f5875a = serviceWorkerController;
        this.f5876b = null;
        if (serviceWorkerController == null) {
            this.f5875a = ServiceWorkerController.getInstance();
        }
        ServiceWorkerWebSettings serviceWorkerWebSettings = this.f5875a.getServiceWorkerWebSettings();
        C0595C c0595c = new C0595C();
        c0595c.f5856b = serviceWorkerWebSettings;
        this.f5877c = c0595c;
    }
}
