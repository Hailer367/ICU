package l0;

import a.AbstractC0051a;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import h0.C0202a;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f2930a;

    /* renamed from: b, reason: collision with root package name */
    public final h0.b f2931b;

    /* renamed from: c, reason: collision with root package name */
    public final h0.b f2932c;

    public e(ClassLoader classLoader, h0.b bVar) {
        this.f2930a = classLoader;
        this.f2931b = bVar;
        this.f2932c = new h0.b(classLoader);
    }

    public final WindowLayoutComponent a() {
        h0.b bVar = this.f2932c;
        bVar.getClass();
        boolean z = false;
        try {
            new C0202a(bVar, 0).invoke();
            if (AbstractC0051a.W("WindowExtensionsProvider#getWindowExtensions is not valid", new C0202a(bVar, 1)) && AbstractC0051a.W("WindowExtensions#getWindowLayoutComponent is not valid", new d(this, 3)) && AbstractC0051a.W("FoldingFeature class is not valid", new d(this, 0))) {
                int a2 = i0.e.a();
                if (a2 == 1) {
                    z = b();
                } else if (2 <= a2 && a2 <= Integer.MAX_VALUE && b()) {
                    if (AbstractC0051a.W("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new d(this, 2))) {
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
        return AbstractC0051a.W("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new d(this, 1));
    }
}
