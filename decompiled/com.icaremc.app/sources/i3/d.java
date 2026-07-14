package i3;

import b3.AbstractC0242q;
import b3.H;
import g3.t;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class d extends H implements Executor {

    /* renamed from: h, reason: collision with root package name */
    public static final d f4172h = new AbstractC0242q();

    /* renamed from: i, reason: collision with root package name */
    public static final AbstractC0242q f4173i;

    /* JADX WARN: Type inference failed for: r0v0, types: [i3.d, b3.q] */
    static {
        l lVar = l.f4186h;
        int i4 = t.f3809a;
        if (64 >= i4) {
            i4 = 64;
        }
        f4173i = lVar.g(g3.a.j(i4, "kotlinx.coroutines.io.parallelism", 12));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // b3.AbstractC0242q
    public final void d(K2.i iVar, Runnable runnable) {
        f4173i.d(iVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        d(K2.j.f942f, runnable);
    }

    @Override // b3.AbstractC0242q
    public final String toString() {
        return "Dispatchers.IO";
    }
}
