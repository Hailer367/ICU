package b3;

import java.util.concurrent.locks.LockSupport;

/* renamed from: b3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0228c extends AbstractC0226a {

    /* renamed from: i, reason: collision with root package name */
    public final Thread f3267i;

    /* renamed from: j, reason: collision with root package name */
    public final G f3268j;

    public C0228c(K2.i iVar, Thread thread, G g4) {
        super(iVar, true);
        this.f3267i = thread;
        this.f3268j = g4;
    }

    @Override // b3.W
    public final void m(Object obj) {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.f3267i;
        if (!T2.h.a(currentThread, thread)) {
            LockSupport.unpark(thread);
        }
    }
}
