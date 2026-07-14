package j2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class k implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f5086a;

    public k() {
        Handler handler;
        Looper mainLooper = Looper.getMainLooper();
        if (Build.VERSION.SDK_INT >= 28) {
            handler = Handler.createAsync(mainLooper);
        } else {
            handler = new Handler(mainLooper);
        }
        this.f5086a = handler;
    }

    @Override // j2.e
    public final void a(RunnableC0428c runnableC0428c) {
        this.f5086a.post(runnableC0428c);
    }
}
