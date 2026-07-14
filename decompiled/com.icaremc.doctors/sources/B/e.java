package B;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public String f41a;

    /* renamed from: b, reason: collision with root package name */
    public String f42b;

    /* renamed from: c, reason: collision with root package name */
    public List f43c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (Objects.equals(this.f41a, eVar.f41a) && Objects.equals(this.f42b, eVar.f42b) && Objects.equals(this.f43c, eVar.f43c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f41a, this.f42b, this.f43c);
    }
}
