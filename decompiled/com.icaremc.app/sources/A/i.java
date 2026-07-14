package A;

import android.content.res.Resources;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f28a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f29b;

    public i(Resources resources, Resources.Theme theme) {
        this.f28a = resources;
        this.f29b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f28a.equals(iVar.f28a) && Objects.equals(this.f29b, iVar.f29b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f28a, this.f29b);
    }
}
