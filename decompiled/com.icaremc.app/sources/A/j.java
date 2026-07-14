package A;

import D2.C0024c;
import D2.C0034m;
import D2.C0037p;
import D2.C0042v;
import D2.L;
import I.C0059m;
import P1.C0107k;
import P1.s;
import P1.y;
import android.app.job.JobParameters;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Process;
import android.os.StrictMode;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractActivityC0192y;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import e.t;
import e2.C0277b;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundService;
import j.ExecutorC0399G;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import n.p;
import o.C0496W;
import p1.C0580i;
import s2.InterfaceC0634f;
import v.AbstractFutureC0676h;
import y1.ThreadFactoryC0741a;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f30f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f31g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f32h;

    public /* synthetic */ j(int i4, Object obj, Object obj2) {
        this.f30f = i4;
        this.f31g = obj;
        this.f32h = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V1.f fVar;
        int i4 = 0;
        switch (this.f30f) {
            case 0:
                ((C0496W) this.f31g).b((Typeface) this.f32h);
                return;
            case 1:
                C0042v c0042v = (C0042v) this.f31g;
                String str = (String) this.f32h;
                C0034m c0034m = c0042v.f438b;
                C0037p c0037p = new C0037p(i4);
                T2.h.e(str, "messageArg");
                L l3 = c0034m.f416a;
                l3.getClass();
                if (!((C0024c) l3.f297g).d(c0042v)) {
                    A2.i.p("missing-instance-error", "Callback to `JavaScriptChannel.postMessage` failed because native instance was not in the instance manager.", "");
                    return;
                } else {
                    new y((InterfaceC0634f) l3.f296f, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.postMessage", l3.b(), null).v(I2.f.C(c0042v, str), new A1.c(8, c0037p));
                    return;
                }
            case 2:
                JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.f31g;
                JobParameters jobParameters = (JobParameters) this.f32h;
                int i5 = JobInfoSchedulerService.f3350f;
                jobInfoSchedulerService.jobFinished(jobParameters, false);
                return;
            case 3:
                ((C0107k) this.f31g).a((Intent) this.f32h);
                return;
            case 4:
                s sVar = (s) this.f31g;
                C0580i c0580i = (C0580i) this.f32h;
                try {
                    c0580i.b(sVar.a());
                    return;
                } catch (Exception e4) {
                    c0580i.a(e4);
                    return;
                }
            case 5:
                ViewGroup viewGroup = (ViewGroup) this.f31g;
                T2.h.e(viewGroup, "$container");
                viewGroup.endViewTransition(null);
                throw null;
            case 6:
                AbstractActivityC0192y abstractActivityC0192y = (AbstractActivityC0192y) this.f31g;
                abstractActivityC0192y.getLifecycle().a(new C0059m(1, (t) this.f32h, abstractActivityC0192y));
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                C0277b c0277b = (C0277b) this.f31g;
                c0277b.f3600g.a((ArrayList) this.f32h);
                return;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                ExecutorC0399G executorC0399G = (ExecutorC0399G) this.f31g;
                Runnable runnable = (Runnable) this.f32h;
                executorC0399G.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    executorC0399G.a();
                }
            case 9:
                x1.m mVar = (x1.m) this.f31g;
                J1.a aVar = (J1.a) this.f32h;
                if (mVar.f6489b == x1.m.f6487d) {
                    synchronized (mVar) {
                        fVar = mVar.f6488a;
                        mVar.f6488a = null;
                        mVar.f6489b = aVar;
                    }
                    fVar.getClass();
                    return;
                }
                throw new IllegalStateException("provide() can be called only once.");
            case 10:
                x1.l lVar = (x1.l) this.f31g;
                J1.a aVar2 = (J1.a) this.f32h;
                synchronized (lVar) {
                    try {
                        if (lVar.f6485b == null) {
                            lVar.f6484a.add(aVar2);
                        } else {
                            lVar.f6485b.add(aVar2.get());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 11:
                String str2 = (String) this.f31g;
                C0580i c0580i2 = (C0580i) this.f32h;
                HashMap hashMap = x2.d.f6504h;
                try {
                    try {
                        u1.f.e(str2).b();
                    } catch (IllegalStateException unused) {
                    }
                    c0580i2.b(null);
                    return;
                } catch (Exception e5) {
                    c0580i2.a(e5);
                    return;
                }
            case 12:
                ThreadFactoryC0741a threadFactoryC0741a = (ThreadFactoryC0741a) this.f31g;
                Runnable runnable2 = (Runnable) this.f32h;
                Process.setThreadPriority(threadFactoryC0741a.f6559c);
                StrictMode.ThreadPolicy threadPolicy = threadFactoryC0741a.f6560d;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                runnable2.run();
                return;
            case 13:
                Callable callable = (Callable) this.f31g;
                p pVar = (p) this.f32h;
                try {
                    Object call = callable.call();
                    y1.h hVar = (y1.h) pVar.f5322g;
                    if (call == null) {
                        call = AbstractFutureC0676h.f6255l;
                    }
                    if (AbstractFutureC0676h.k.c(hVar, null, call)) {
                        AbstractFutureC0676h.c(hVar);
                        return;
                    }
                    return;
                } catch (Exception e6) {
                    pVar.k(e6);
                    return;
                }
            default:
                FlutterFirebaseMessagingBackgroundService.f4410n.C((Intent) this.f31g, (CountDownLatch) this.f32h);
                return;
        }
    }
}
