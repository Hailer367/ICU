package m2;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import h2.t;

/* renamed from: m2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0444b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5194f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0447e f5195g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Context f5196h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Handler f5197i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t f5198j;

    public /* synthetic */ RunnableC0444b(C0447e c0447e, Context context, Handler handler, t tVar, int i4) {
        this.f5194f = i4;
        this.f5195g = c0447e;
        this.f5196h = context;
        this.f5197i = handler;
        this.f5198j = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        switch (this.f5194f) {
            case 0:
                C0447e c0447e = this.f5195g;
                try {
                    Looper mainLooper = Looper.getMainLooper();
                    if (Build.VERSION.SDK_INT >= 28) {
                        handler = Handler.createAsync(mainLooper);
                    } else {
                        handler = new Handler(mainLooper);
                    }
                    handler.post(new RunnableC0444b(c0447e, this.f5196h, this.f5197i, this.f5198j, 1));
                    return;
                } catch (Exception e4) {
                    Log.e("FlutterLoader", "Flutter initialization failed.", e4);
                    throw new RuntimeException(e4);
                }
            default:
                this.f5195g.a(this.f5196h.getApplicationContext(), null);
                this.f5197i.post(this.f5198j);
                return;
        }
    }
}
