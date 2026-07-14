package androidx.lifecycle;

/* renamed from: androidx.lifecycle.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0154y implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C f1864c;

    public RunnableC0154y(C c2) {
        this.f1864c = c2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        synchronized (this.f1864c.mDataLock) {
            obj = this.f1864c.mPendingData;
            this.f1864c.mPendingData = C.NOT_SET;
        }
        this.f1864c.setValue(obj);
    }
}
