package i0;

import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.r;

/* loaded from: classes.dex */
public abstract class e {
    static {
        r.a(e.class).b();
    }

    public static int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return 0;
        }
    }
}
