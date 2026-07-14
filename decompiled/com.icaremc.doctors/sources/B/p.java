package B;

import android.os.Handler;

/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public h f75c;

    /* renamed from: d, reason: collision with root package name */
    public i f76d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f77e;

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        try {
            obj = this.f75c.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f77e.post(new a(1, this.f76d, obj));
    }
}
