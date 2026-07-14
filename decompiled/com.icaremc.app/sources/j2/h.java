package j2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class h implements e {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f5074a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f5075b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f5076c = new AtomicBoolean(false);

    public h(ExecutorService executorService) {
        this.f5074a = executorService;
    }

    @Override // j2.e
    public final void a(RunnableC0428c runnableC0428c) {
        this.f5075b.add(runnableC0428c);
        this.f5074a.execute(new A.k(12, this));
    }
}
