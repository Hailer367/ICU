package A2;

import f1.AbstractC0286a;
import java.util.List;

/* renamed from: A2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0003b {

    /* renamed from: a, reason: collision with root package name */
    public final EnumC0004c f61a;

    /* renamed from: b, reason: collision with root package name */
    public final C0002a f62b;

    /* renamed from: c, reason: collision with root package name */
    public final List f63c;

    public C0003b(EnumC0004c enumC0004c, C0002a c0002a, List list) {
        this.f61a = enumC0004c;
        this.f62b = c0002a;
        this.f63c = list;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(C0003b.class)) {
            if (this != obj) {
                C0003b c0003b = (C0003b) obj;
                if (AbstractC0286a.e(this.f61a, c0003b.f61a) && AbstractC0286a.e(this.f62b, c0003b.f62b) && AbstractC0286a.e(this.f63c, c0003b.f63c)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0286a.g(this.f63c) + ((AbstractC0286a.g(this.f62b) + ((AbstractC0286a.g(this.f61a) + (C0003b.class.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "CacheRetrievalResult(type=" + this.f61a + ", error=" + this.f62b + ", paths=" + this.f63c + ")";
    }
}
