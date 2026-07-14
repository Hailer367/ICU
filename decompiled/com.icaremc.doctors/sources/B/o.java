package B;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class o implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new n(runnable);
    }
}
