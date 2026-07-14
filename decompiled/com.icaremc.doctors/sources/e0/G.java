package e0;

import android.view.ViewGroup;
import android.view.WindowId;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f2179a;

    public G(ViewGroup viewGroup) {
        this.f2179a = viewGroup.getWindowId();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof G) && ((G) obj).f2179a.equals(this.f2179a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f2179a.hashCode();
    }
}
