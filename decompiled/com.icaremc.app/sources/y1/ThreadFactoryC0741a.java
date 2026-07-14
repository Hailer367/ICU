package y1;

import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: y1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ThreadFactoryC0741a implements ThreadFactory {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f6556e = Executors.defaultThreadFactory();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f6557a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    public final String f6558b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6559c;

    /* renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f6560d;

    public ThreadFactoryC0741a(String str, int i4, StrictMode.ThreadPolicy threadPolicy) {
        this.f6558b = str;
        this.f6559c = i4;
        this.f6560d = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = f6556e.newThread(new A.j(12, this, runnable));
        Locale locale = Locale.ROOT;
        newThread.setName(this.f6558b + " Thread #" + this.f6557a.getAndIncrement());
        return newThread;
    }
}
