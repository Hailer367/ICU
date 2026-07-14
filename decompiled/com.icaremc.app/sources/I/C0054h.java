package I;

import android.view.DisplayCutout;
import java.util.Objects;

/* renamed from: I.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0054h {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f738a;

    public C0054h(DisplayCutout displayCutout) {
        this.f738a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0054h.class == obj.getClass()) {
            return Objects.equals(this.f738a, ((C0054h) obj).f738a);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f738a.hashCode();
        return hashCode;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f738a + "}";
    }
}
