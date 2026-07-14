package h0;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0202a extends i implements c1.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2318c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f2319d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0202a(b bVar, int i2) {
        super(0);
        this.f2318c = i2;
        this.f2319d = bVar;
    }

    @Override // c1.a
    public final Object invoke() {
        boolean z;
        switch (this.f2318c) {
            case 0:
                Class<?> loadClass = this.f2319d.f2320a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                h.d(loadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                return loadClass;
            default:
                b bVar = this.f2319d;
                Class<?> loadClass2 = bVar.f2320a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                h.d(loadClass2, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                Method getWindowExtensionsMethod = loadClass2.getDeclaredMethod("getWindowExtensions", null);
                Class<?> loadClass3 = bVar.f2320a.loadClass("androidx.window.extensions.WindowExtensions");
                h.d(loadClass3, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
                h.d(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                if (getWindowExtensionsMethod.getReturnType().equals(loadClass3) && Modifier.isPublic(getWindowExtensionsMethod.getModifiers())) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
        }
    }
}
