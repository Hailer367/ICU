package v0;

import T2.q;
import android.content.Context;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;
import w0.InterfaceC0695a;
import y0.AbstractC0737i;
import y0.C0738j;
import y0.C0740l;

/* renamed from: v0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0684g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C0684g f6277a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final H2.g f6278b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0678a f6279c;

    /* JADX WARN: Type inference failed for: r0v0, types: [v0.g, java.lang.Object] */
    static {
        q.a(InterfaceC0685h.class).b();
        f6278b = new H2.g(C0683f.f6276g);
        f6279c = C0678a.f6259a;
    }

    public static C0679b a(Context context) {
        T2.h.e(context, "context");
        InterfaceC0695a interfaceC0695a = (InterfaceC0695a) f6278b.a();
        if (interfaceC0695a == null) {
            C0740l c0740l = C0740l.f6552c;
            if (C0740l.f6552c == null) {
                ReentrantLock reentrantLock = C0740l.f6553d;
                reentrantLock.lock();
                try {
                    if (C0740l.f6552c == null) {
                        C0738j c0738j = null;
                        try {
                            s0.h b4 = AbstractC0737i.b();
                            if (b4 != null) {
                                s0.h hVar = s0.h.k;
                                T2.h.e(hVar, "other");
                                Object a4 = b4.f6145j.a();
                                T2.h.d(a4, "<get-bigInteger>(...)");
                                Object a5 = hVar.f6145j.a();
                                T2.h.d(a5, "<get-bigInteger>(...)");
                                if (((BigInteger) a4).compareTo((BigInteger) a5) >= 0) {
                                    C0738j c0738j2 = new C0738j(context);
                                    if (c0738j2.e()) {
                                        c0738j = c0738j2;
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        C0740l.f6552c = new C0740l(c0738j);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            interfaceC0695a = C0740l.f6552c;
            T2.h.b(interfaceC0695a);
        }
        int i4 = C0690m.f6288b;
        C0679b c0679b = new C0679b(interfaceC0695a);
        f6279c.getClass();
        return c0679b;
    }
}
