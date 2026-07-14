package Y;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f869c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f870d;

    public /* synthetic */ h(Context context, int i2) {
        this.f869c = i2;
        this.f870d = context;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f869c) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new h(this.f870d, 1));
                return;
            default:
                f.t(this.f870d, new Object(), f.f858a, false);
                return;
        }
    }
}
