package androidx.lifecycle;

import java.lang.reflect.Method;

/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0196c {

    /* renamed from: a, reason: collision with root package name */
    public final int f3004a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f3005b;

    public C0196c(int i4, Method method) {
        this.f3004a = i4;
        this.f3005b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0196c)) {
            return false;
        }
        C0196c c0196c = (C0196c) obj;
        if (this.f3004a == c0196c.f3004a && this.f3005b.getName().equals(c0196c.f3005b.getName())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f3005b.getName().hashCode() + (this.f3004a * 31);
    }
}
