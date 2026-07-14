package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import c0.C0170a;
import c0.InterfaceC0171b;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements InterfaceC0171b {
    @Override // c0.InterfaceC0171b
    public final List a() {
        return R0.r.f750c;
    }

    @Override // c0.InterfaceC0171b
    public final Object b(Context context) {
        kotlin.jvm.internal.h.e(context, "context");
        C0170a c2 = C0170a.c(context);
        kotlin.jvm.internal.h.d(c2, "getInstance(context)");
        if (c2.f1990b.contains(ProcessLifecycleInitializer.class)) {
            if (!r.f1850a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                kotlin.jvm.internal.h.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new C0147q());
            }
            J j2 = J.f1784k;
            j2.getClass();
            j2.f1789g = new Handler();
            j2.f1790h.e(EnumC0144n.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            kotlin.jvm.internal.h.c(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new H(j2));
            return j2;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
    }
}
