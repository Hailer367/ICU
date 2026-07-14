package androidx.lifecycle;

import java.lang.reflect.Method;

/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0133c {

    /* renamed from: a, reason: collision with root package name */
    public final int f1831a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f1832b;

    public C0133c(Method method, int i2) {
        this.f1831a = i2;
        this.f1832b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0133c)) {
            return false;
        }
        C0133c c0133c = (C0133c) obj;
        if (this.f1831a == c0133c.f1831a && this.f1832b.getName().equals(c0133c.f1832b.getName())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f1832b.getName().hashCode() + (this.f1831a * 31);
    }
}
