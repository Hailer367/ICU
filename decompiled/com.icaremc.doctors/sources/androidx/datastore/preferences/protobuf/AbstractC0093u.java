package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0093u implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0095w f1492c;

    /* renamed from: d, reason: collision with root package name */
    public AbstractC0095w f1493d;

    public AbstractC0093u(AbstractC0095w abstractC0095w) {
        this.f1492c = abstractC0095w;
        if (!abstractC0095w.g()) {
            this.f1493d = abstractC0095w.i();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    public final AbstractC0095w a() {
        AbstractC0095w b2 = b();
        b2.getClass();
        if (AbstractC0095w.f(b2, true)) {
            return b2;
        }
        throw new c0();
    }

    public final AbstractC0095w b() {
        if (!this.f1493d.g()) {
            return this.f1493d;
        }
        AbstractC0095w abstractC0095w = this.f1493d;
        abstractC0095w.getClass();
        T t2 = T.f1374c;
        t2.getClass();
        t2.a(abstractC0095w.getClass()).d(abstractC0095w);
        abstractC0095w.h();
        return this.f1493d;
    }

    public final void c() {
        if (!this.f1493d.g()) {
            AbstractC0095w i2 = this.f1492c.i();
            AbstractC0095w abstractC0095w = this.f1493d;
            T t2 = T.f1374c;
            t2.getClass();
            t2.a(i2.getClass()).a(i2, abstractC0095w);
            this.f1493d = i2;
        }
    }

    public final Object clone() {
        AbstractC0093u abstractC0093u = (AbstractC0093u) this.f1492c.c(5);
        abstractC0093u.f1493d = b();
        return abstractC0093u;
    }
}
