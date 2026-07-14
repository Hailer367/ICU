package E;

import android.view.DisplayCutout;
import java.util.Objects;

/* renamed from: E.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0006f {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f223a;

    public C0006f(DisplayCutout displayCutout) {
        this.f223a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0006f.class == obj.getClass()) {
            return Objects.equals(this.f223a, ((C0006f) obj).f223a);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f223a.hashCode();
        return hashCode;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f223a + "}";
    }
}
