package F;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public String f484a;

    /* renamed from: b, reason: collision with root package name */
    public String f485b;

    /* renamed from: c, reason: collision with root package name */
    public List f486c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (Objects.equals(this.f484a, dVar.f484a) && Objects.equals(this.f485b, dVar.f485b) && Objects.equals(this.f486c, dVar.f486c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f484a, this.f485b, this.f486c);
    }
}
