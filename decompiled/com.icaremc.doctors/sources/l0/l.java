package l0;

import E.k0;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final i0.b f2944a;

    /* renamed from: b, reason: collision with root package name */
    public final k0 f2945b;

    public l(i0.b bVar, k0 _windowInsetsCompat) {
        kotlin.jvm.internal.h.e(_windowInsetsCompat, "_windowInsetsCompat");
        this.f2944a = bVar;
        this.f2945b = _windowInsetsCompat;
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!l.class.equals(cls)) {
            return false;
        }
        kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        l lVar = (l) obj;
        if (kotlin.jvm.internal.h.a(this.f2944a, lVar.f2944a) && kotlin.jvm.internal.h.a(this.f2945b, lVar.f2945b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f2945b.hashCode() + (this.f2944a.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics( bounds=" + this.f2944a + ", windowInsetsCompat=" + this.f2945b + ')';
    }
}
