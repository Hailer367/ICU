package v0;

import androidx.window.extensions.layout.WindowLayoutComponent;
import r0.C0619a;
import x0.C0717c;
import x0.C0718d;

/* renamed from: v0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0683f extends T2.i implements S2.a {

    /* renamed from: g, reason: collision with root package name */
    public static final C0683f f6276g = new T2.i(0);

    @Override // S2.a
    public final Object a() {
        C0682e c0682e;
        WindowLayoutComponent a4;
        try {
            ClassLoader classLoader = InterfaceC0685h.class.getClassLoader();
            if (classLoader != null) {
                c0682e = new C0682e(classLoader, new C0619a(classLoader));
            } else {
                c0682e = null;
            }
            if (c0682e == null || (a4 = c0682e.a()) == null) {
                return null;
            }
            T2.h.d(classLoader, "loader");
            C0619a c0619a = new C0619a(classLoader);
            int a5 = s0.e.a();
            if (a5 >= 2) {
                return new C0718d(a4);
            }
            if (a5 == 1) {
                return new C0717c(a4, c0619a);
            }
            return new Object();
        } catch (Throwable unused) {
            C0684g c0684g = C0684g.f6277a;
            return null;
        }
    }
}
