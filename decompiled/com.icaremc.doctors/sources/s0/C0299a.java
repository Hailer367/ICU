package s0;

import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* renamed from: s0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0299a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3581a;

    /* renamed from: b, reason: collision with root package name */
    public final C0300b f3582b;

    public C0299a(MessagingClientEventExtension messagingClientEventExtension, C0300b c0300b) {
        if (messagingClientEventExtension != null) {
            this.f3581a = messagingClientEventExtension;
            this.f3582b = c0300b;
            return;
        }
        throw new NullPointerException("Null payload");
    }

    public final boolean equals(Object obj) {
        C0300b c0300b;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0299a) {
            C0299a c0299a = (C0299a) obj;
            c0299a.getClass();
            Object obj2 = c0299a.f3581a;
            C0300b c0300b2 = c0299a.f3582b;
            if (this.f3581a.equals(obj2)) {
                Object obj3 = d.f3585c;
                if (obj3.equals(obj3) && ((c0300b = this.f3582b) != null ? c0300b.equals(c0300b2) : c0300b2 == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3582b.hashCode() ^ (((((1000003 * 1000003) ^ this.f3581a.hashCode()) * 1000003) ^ d.f3585c.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f3581a + ", priority=" + d.f3585c + ", productData=" + this.f3582b + "}";
    }
}
