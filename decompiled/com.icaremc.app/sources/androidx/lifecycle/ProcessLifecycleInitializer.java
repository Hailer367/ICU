package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import j0.C0423a;
import j0.InterfaceC0424b;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements InterfaceC0424b {
    @Override // j0.InterfaceC0424b
    public final List a() {
        return I2.m.f862f;
    }

    @Override // j0.InterfaceC0424b
    public final Object b(Context context) {
        T2.h.e(context, "context");
        C0423a c4 = C0423a.c(context);
        T2.h.d(c4, "getInstance(context)");
        if (c4.f5037b.contains(ProcessLifecycleInitializer.class)) {
            if (!AbstractC0210q.f3019a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                T2.h.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new C0209p());
            }
            E e4 = E.f2957n;
            e4.getClass();
            e4.f2962j = new Handler();
            e4.k.e(EnumC0206m.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            T2.h.c(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new D(e4));
            return e4;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
    }
}
