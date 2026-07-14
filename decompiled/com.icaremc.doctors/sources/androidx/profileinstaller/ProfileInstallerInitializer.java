package androidx.profileinstaller;

import A0.f;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import c0.InterfaceC0171b;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements InterfaceC0171b {
    @Override // c0.InterfaceC0171b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // c0.InterfaceC0171b
    public final Object b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this) { // from class: Y.g
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                Handler handler;
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = Handler.createAsync(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                int nextInt = new Random().nextInt(Math.max(1000, 1));
                handler.postDelayed(new h(applicationContext, 0), nextInt + 5000);
            }
        });
        return new f(9);
    }
}
