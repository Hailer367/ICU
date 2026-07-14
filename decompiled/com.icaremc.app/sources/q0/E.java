package q0;

import android.webkit.WebViewRenderProcess;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import o.AbstractC0540r0;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* loaded from: classes.dex */
public final class E extends p0.x {

    /* renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f5858c = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public WebViewRendererBoundaryInterface f5859a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f5860b;

    @Override // p0.x
    public final boolean a() {
        boolean terminate;
        C0597b c0597b = x.f5925t;
        if (c0597b.a()) {
            WebViewRenderProcess c4 = AbstractC0540r0.c(this.f5860b.get());
            if (c4 != null) {
                terminate = c4.terminate();
                if (terminate) {
                    return true;
                }
                return false;
            }
            return false;
        }
        if (c0597b.b()) {
            return this.f5859a.terminate();
        }
        throw x.a();
    }
}
