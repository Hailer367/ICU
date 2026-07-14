package s1;

import java.util.concurrent.Executor;
import l1.AbstractC0240s;
import l1.I;
import q1.t;

/* loaded from: classes.dex */
public final class d extends I implements Executor {

    /* renamed from: e, reason: collision with root package name */
    public static final d f3615e = new AbstractC0240s();

    /* renamed from: f, reason: collision with root package name */
    public static final AbstractC0240s f3616f;

    /* JADX WARN: Type inference failed for: r0v0, types: [s1.d, l1.s] */
    static {
        l lVar = l.f3629e;
        int i2 = t.f3544a;
        if (64 >= i2) {
            i2 = 64;
        }
        f3616f = lVar.h(q1.a.j("kotlinx.coroutines.io.parallelism", i2, 12));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // l1.AbstractC0240s
    public final void e(T0.i iVar, Runnable runnable) {
        f3616f.e(iVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        e(T0.j.f774c, runnable);
    }

    @Override // l1.AbstractC0240s
    public final String toString() {
        return "Dispatchers.IO";
    }
}
