package i0;

import android.graphics.Rect;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f2331a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2332b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2333c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2334d;

    public b(Rect rect) {
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        this.f2331a = i2;
        this.f2332b = i3;
        this.f2333c = i4;
        this.f2334d = i5;
        if (i2 <= i4) {
            if (i3 <= i5) {
                return;
            } else {
                throw new IllegalArgumentException(O.a.d("top must be less than or equal to bottom, top: ", i3, ", bottom: ", i5).toString());
            }
        }
        throw new IllegalArgumentException(O.a.d("Left must be less than or equal to right, left: ", i2, ", right: ", i4).toString());
    }

    public final Rect a() {
        return new Rect(this.f2331a, this.f2332b, this.f2333c, this.f2334d);
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
        if (!b.class.equals(cls)) {
            return false;
        }
        kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        b bVar = (b) obj;
        if (this.f2331a == bVar.f2331a && this.f2332b == bVar.f2332b && this.f2333c == bVar.f2333c && this.f2334d == bVar.f2334d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f2331a * 31) + this.f2332b) * 31) + this.f2333c) * 31) + this.f2334d;
    }

    public final String toString() {
        return b.class.getSimpleName() + " { [" + this.f2331a + ',' + this.f2332b + ',' + this.f2333c + ',' + this.f2334d + "] }";
    }
}
