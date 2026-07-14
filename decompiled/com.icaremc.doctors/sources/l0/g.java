package l0;

import android.content.Context;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.r;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ g f2934a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Q0.h f2935b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0222a f2936c;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, l0.g] */
    static {
        r.a(h.class).b();
        f2935b = new Q0.h(f.f2933c);
        f2936c = C0222a.f2915a;
    }

    public static b a(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        m0.a aVar = (m0.a) f2935b.a();
        if (aVar == null) {
            o0.m mVar = o0.m.f3388c;
            if (o0.m.f3388c == null) {
                ReentrantLock reentrantLock = o0.m.f3389d;
                reentrantLock.lock();
                try {
                    if (o0.m.f3388c == null) {
                        o0.k kVar = null;
                        try {
                            i0.h b2 = o0.i.b();
                            if (b2 != null) {
                                i0.h other = i0.h.f2347h;
                                kotlin.jvm.internal.h.e(other, "other");
                                Object a2 = b2.f2352g.a();
                                kotlin.jvm.internal.h.d(a2, "<get-bigInteger>(...)");
                                Object a3 = other.f2352g.a();
                                kotlin.jvm.internal.h.d(a3, "<get-bigInteger>(...)");
                                if (((BigInteger) a2).compareTo((BigInteger) a3) >= 0) {
                                    o0.k kVar2 = new o0.k(context);
                                    if (kVar2.e()) {
                                        kVar = kVar2;
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        o0.m.f3388c = new o0.m(kVar);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            aVar = o0.m.f3388c;
            kotlin.jvm.internal.h.b(aVar);
        }
        int i2 = n.f2947b;
        b bVar = new b(aVar);
        f2936c.getClass();
        return bVar;
    }
}
