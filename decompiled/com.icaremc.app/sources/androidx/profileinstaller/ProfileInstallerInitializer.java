package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import j0.InterfaceC0424b;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements InterfaceC0424b {
    @Override // j0.InterfaceC0424b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // j0.InterfaceC0424b
    public final Object b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this) { // from class: f0.f
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j4) {
                Handler handler;
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = Handler.createAsync(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                int nextInt = new Random().nextInt(Math.max(1000, 1));
                handler.postDelayed(new g(applicationContext, 0), nextInt + 5000);
            }
        });
        return new Object();
    }
}
