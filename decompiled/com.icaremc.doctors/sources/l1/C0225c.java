package l1;

import java.util.concurrent.locks.LockSupport;

/* renamed from: l1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0225c extends AbstractC0223a {

    /* renamed from: f, reason: collision with root package name */
    public final Thread f2981f;

    /* renamed from: g, reason: collision with root package name */
    public final H f2982g;

    public C0225c(T0.i iVar, Thread thread, H h2) {
        super(iVar, true);
        this.f2981f = thread;
        this.f2982g = h2;
    }

    @Override // l1.X
    public final void l(Object obj) {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.f2981f;
        if (!kotlin.jvm.internal.h.a(currentThread, thread)) {
            LockSupport.unpark(thread);
        }
    }
}
