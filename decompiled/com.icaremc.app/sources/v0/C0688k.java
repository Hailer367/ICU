package v0;

import I.v0;

/* renamed from: v0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0688k {

    /* renamed from: a, reason: collision with root package name */
    public final s0.b f6285a;

    /* renamed from: b, reason: collision with root package name */
    public final v0 f6286b;

    public C0688k(s0.b bVar, v0 v0Var) {
        T2.h.e(v0Var, "_windowInsetsCompat");
        this.f6285a = bVar;
        this.f6286b = v0Var;
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
        if (!C0688k.class.equals(cls)) {
            return false;
        }
        T2.h.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        C0688k c0688k = (C0688k) obj;
        if (T2.h.a(this.f6285a, c0688k.f6285a) && T2.h.a(this.f6286b, c0688k.f6286b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6286b.hashCode() + (this.f6285a.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics( bounds=" + this.f6285a + ", windowInsetsCompat=" + this.f6286b + ')';
    }
}
