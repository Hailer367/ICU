package P1;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import y1.ThreadFactoryC0741a;

/* renamed from: P1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0108l implements J1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1426a;

    @Override // J1.a
    public final Object get() {
        switch (this.f1426a) {
            case 0:
                A a4 = FirebaseMessaging.f3406l;
                return null;
            case 1:
                return Collections.EMPTY_SET;
            case 2:
                return null;
            case 3:
                x1.k kVar = ExecutorsRegistrar.f3400a;
                StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                int i4 = Build.VERSION.SDK_INT;
                detectNetwork.detectResourceMismatches();
                if (i4 >= 26) {
                    detectNetwork.detectUnbufferedIo();
                }
                return new y1.f(Executors.newFixedThreadPool(4, new ThreadFactoryC0741a("Firebase Background", 10, detectNetwork.penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f3403d.get());
            case 4:
                x1.k kVar2 = ExecutorsRegistrar.f3400a;
                return new y1.f(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new ThreadFactoryC0741a("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f3403d.get());
            case 5:
                x1.k kVar3 = ExecutorsRegistrar.f3400a;
                return new y1.f(Executors.newCachedThreadPool(new ThreadFactoryC0741a("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f3403d.get());
            default:
                x1.k kVar4 = ExecutorsRegistrar.f3400a;
                return Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC0741a("Firebase Scheduler", 0, null));
        }
    }
}
