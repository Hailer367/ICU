package s2;

import java.nio.ByteBuffer;

/* renamed from: s2.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0644p {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0634f f6157a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6158b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0645q f6159c;

    public C0644p(InterfaceC0634f interfaceC0634f, String str) {
        this(interfaceC0634f, str, C0651w.f6163a);
    }

    public final void a(String str, Object obj, InterfaceC0643o interfaceC0643o) {
        C0629a c0629a;
        ByteBuffer f4 = this.f6159c.f(new C0641m(obj, str));
        if (interfaceC0643o == null) {
            c0629a = null;
        } else {
            c0629a = new C0629a(1, this, interfaceC0643o);
        }
        this.f6157a.e(this.f6158b, f4, c0629a);
    }

    public final void b(InterfaceC0642n interfaceC0642n) {
        io.flutter.plugin.platform.s sVar;
        if (interfaceC0642n == null) {
            sVar = null;
        } else {
            sVar = new io.flutter.plugin.platform.s(14, this, interfaceC0642n);
        }
        this.f6157a.a(this.f6158b, sVar);
    }

    public C0644p(InterfaceC0634f interfaceC0634f, String str, InterfaceC0645q interfaceC0645q) {
        this.f6157a = interfaceC0634f;
        this.f6158b = str;
        this.f6159c = interfaceC0645q;
    }
}
