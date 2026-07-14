package D;

import android.graphics.drawable.Drawable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f166a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f167b;

    public b(CharSequence charSequence, Drawable drawable) {
        this.f166a = charSequence;
        this.f167b = drawable;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equals(bVar.f166a, this.f166a) || !Objects.equals(bVar.f167b, this.f167b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int i2 = 0;
        Object obj = this.f166a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f167b;
        if (obj2 != null) {
            i2 = obj2.hashCode();
        }
        return i2 ^ hashCode;
    }

    public final String toString() {
        return "Pair{" + this.f166a + " " + this.f167b + "}";
    }
}
