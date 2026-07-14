package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0163u implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC0165w f2707f;

    /* renamed from: g, reason: collision with root package name */
    public AbstractC0165w f2708g;

    public AbstractC0163u(AbstractC0165w abstractC0165w) {
        this.f2707f = abstractC0165w;
        if (!abstractC0165w.g()) {
            this.f2708g = abstractC0165w.i();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    public final AbstractC0165w a() {
        AbstractC0165w b4 = b();
        b4.getClass();
        if (AbstractC0165w.f(b4, true)) {
            return b4;
        }
        throw new c0();
    }

    public final AbstractC0165w b() {
        if (!this.f2708g.g()) {
            return this.f2708g;
        }
        AbstractC0165w abstractC0165w = this.f2708g;
        abstractC0165w.getClass();
        T t3 = T.f2593c;
        t3.getClass();
        t3.a(abstractC0165w.getClass()).d(abstractC0165w);
        abstractC0165w.h();
        return this.f2708g;
    }

    public final void c() {
        if (!this.f2708g.g()) {
            AbstractC0165w i4 = this.f2707f.i();
            AbstractC0165w abstractC0165w = this.f2708g;
            T t3 = T.f2593c;
            t3.getClass();
            t3.a(i4.getClass()).a(i4, abstractC0165w);
            this.f2708g = i4;
        }
    }

    public final Object clone() {
        AbstractC0163u abstractC0163u = (AbstractC0163u) this.f2707f.c(5);
        abstractC0163u.f2708g = b();
        return abstractC0163u;
    }
}
