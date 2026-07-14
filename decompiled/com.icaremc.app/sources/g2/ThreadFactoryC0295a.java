package g2;

import java.util.concurrent.ThreadFactory;

/* renamed from: g2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ThreadFactoryC0295a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public int f3769a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder sb = new StringBuilder("flutter-worker-");
        int i4 = this.f3769a;
        this.f3769a = i4 + 1;
        sb.append(i4);
        thread.setName(sb.toString());
        return thread;
    }
}
