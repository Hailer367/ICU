package e1;

import I0.p;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: e1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ThreadFactoryC0275a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f3596a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f3597b = Executors.defaultThreadFactory();

    public ThreadFactoryC0275a(String str) {
        this.f3596a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f3597b.newThread(new p(runnable, 1));
        newThread.setName(this.f3596a);
        return newThread;
    }
}
