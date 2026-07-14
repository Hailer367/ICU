package x2;

import a.AbstractC0141a;
import java.util.Map;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public String f6522a;

    /* renamed from: b, reason: collision with root package name */
    public f f6523b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f6524c;

    /* renamed from: d, reason: collision with root package name */
    public Map f6525d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (AbstractC0141a.y(this.f6522a, gVar.f6522a) && AbstractC0141a.y(this.f6523b, gVar.f6523b) && AbstractC0141a.y(this.f6524c, gVar.f6524c) && AbstractC0141a.y(this.f6525d, gVar.f6525d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0141a.z(new Object[]{g.class, this.f6522a, this.f6523b, this.f6524c, this.f6525d});
    }
}
