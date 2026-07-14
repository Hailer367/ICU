package v0;

import O.S;
import a.AbstractC0141a;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import r0.C0619a;

/* renamed from: v0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0682e {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f6273a;

    /* renamed from: b, reason: collision with root package name */
    public final C0619a f6274b;

    /* renamed from: c, reason: collision with root package name */
    public final C0619a f6275c;

    public C0682e(ClassLoader classLoader, C0619a c0619a) {
        this.f6273a = classLoader;
        this.f6274b = c0619a;
        this.f6275c = new C0619a(classLoader);
    }

    public final WindowLayoutComponent a() {
        C0619a c0619a = this.f6275c;
        c0619a.getClass();
        boolean z = false;
        try {
            T2.h.d(c0619a.f6015a.loadClass("androidx.window.extensions.WindowExtensionsProvider"), "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
            if (AbstractC0141a.I("WindowExtensionsProvider#getWindowExtensions is not valid", new S(3, c0619a)) && AbstractC0141a.I("WindowExtensions#getWindowLayoutComponent is not valid", new C0681d(this, 3)) && AbstractC0141a.I("FoldingFeature class is not valid", new C0681d(this, 0))) {
                int a4 = s0.e.a();
                if (a4 == 1) {
                    z = b();
                } else if (2 <= a4 && a4 <= Integer.MAX_VALUE && b()) {
                    if (AbstractC0141a.I("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new C0681d(this, 2))) {
                        z = true;
                    }
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        if (!z) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused2) {
            return null;
        }
    }

    public final boolean b() {
        return AbstractC0141a.I("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new C0681d(this, 1));
    }
}
