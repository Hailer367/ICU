package W1;

import a2.C0143a;

/* renamed from: W1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0118i implements T1.t {
    @Override // T1.t
    public final T1.s create(T1.e eVar, C0143a c0143a) {
        Class cls = c0143a.f2216a;
        if (Enum.class.isAssignableFrom(cls) && cls != Enum.class) {
            if (!cls.isEnum()) {
                cls = cls.getSuperclass();
            }
            return new C0119j(cls);
        }
        return null;
    }
}
