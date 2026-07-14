package u1;

import I0.h;
import b3.I;
import java.util.concurrent.Executor;
import w1.InterfaceC0696a;
import w1.InterfaceC0697b;
import w1.InterfaceC0698c;
import w1.InterfaceC0699d;
import x1.o;

/* renamed from: u1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0667b implements x1.c {

    /* renamed from: g, reason: collision with root package name */
    public static final C0667b f6211g = new C0667b(1);

    /* renamed from: h, reason: collision with root package name */
    public static final C0667b f6212h = new C0667b(2);

    /* renamed from: i, reason: collision with root package name */
    public static final C0667b f6213i = new C0667b(3);

    /* renamed from: j, reason: collision with root package name */
    public static final C0667b f6214j = new C0667b(4);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6215f;

    public /* synthetic */ C0667b(int i4) {
        this.f6215f = i4;
    }

    @Override // x1.c
    public Object a(h hVar) {
        switch (this.f6215f) {
            case 1:
                Object e4 = hVar.e(new o(InterfaceC0696a.class, Executor.class));
                T2.h.d(e4, "get(...)");
                return new I((Executor) e4);
            case 2:
                Object e5 = hVar.e(new o(InterfaceC0698c.class, Executor.class));
                T2.h.d(e5, "get(...)");
                return new I((Executor) e5);
            case 3:
                Object e6 = hVar.e(new o(InterfaceC0697b.class, Executor.class));
                T2.h.d(e6, "get(...)");
                return new I((Executor) e6);
            default:
                Object e7 = hVar.e(new o(InterfaceC0699d.class, Executor.class));
                T2.h.d(e7, "get(...)");
                return new I((Executor) e7);
        }
    }
}
