package l0;

import androidx.window.extensions.layout.WindowLayoutComponent;

/* loaded from: classes.dex */
public final class f extends kotlin.jvm.internal.i implements c1.a {

    /* renamed from: c, reason: collision with root package name */
    public static final f f2933c = new kotlin.jvm.internal.i(0);

    @Override // c1.a
    public final Object invoke() {
        e eVar;
        WindowLayoutComponent a2;
        try {
            ClassLoader loader = h.class.getClassLoader();
            if (loader != null) {
                eVar = new e(loader, new h0.b(loader));
            } else {
                eVar = null;
            }
            if (eVar == null || (a2 = eVar.a()) == null) {
                return null;
            }
            kotlin.jvm.internal.h.d(loader, "loader");
            h0.b bVar = new h0.b(loader);
            int a3 = i0.e.a();
            if (a3 >= 2) {
                return new n0.d(a2);
            }
            if (a3 == 1) {
                return new n0.c(a2, bVar);
            }
            return new Object();
        } catch (Throwable unused) {
            g gVar = g.f2934a;
            return null;
        }
    }
}
