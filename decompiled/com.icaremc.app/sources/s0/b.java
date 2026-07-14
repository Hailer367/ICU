package s0;

import A2.i;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f6125a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6126b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6127c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6128d;

    public b(Rect rect) {
        int i4 = rect.left;
        int i5 = rect.top;
        int i6 = rect.right;
        int i7 = rect.bottom;
        this.f6125a = i4;
        this.f6126b = i5;
        this.f6127c = i6;
        this.f6128d = i7;
        if (i4 <= i6) {
            if (i5 <= i7) {
                return;
            } else {
                throw new IllegalArgumentException(i.h("top must be less than or equal to bottom, top: ", ", bottom: ", i5, i7).toString());
            }
        }
        throw new IllegalArgumentException(i.h("Left must be less than or equal to right, left: ", ", right: ", i4, i6).toString());
    }

    public final Rect a() {
        return new Rect(this.f6125a, this.f6126b, this.f6127c, this.f6128d);
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
        T2.h.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        b bVar = (b) obj;
        if (this.f6125a == bVar.f6125a && this.f6126b == bVar.f6126b && this.f6127c == bVar.f6127c && this.f6128d == bVar.f6128d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f6125a * 31) + this.f6126b) * 31) + this.f6127c) * 31) + this.f6128d;
    }

    public final String toString() {
        return b.class.getSimpleName() + " { [" + this.f6125a + ',' + this.f6126b + ',' + this.f6127c + ',' + this.f6128d + "] }";
    }
}
