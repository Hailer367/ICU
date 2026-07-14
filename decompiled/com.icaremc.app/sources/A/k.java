package A;

import D2.C0023b;
import D2.C0024c;
import D2.C0026e;
import D2.C0029h;
import D2.J;
import D2.L;
import P1.A;
import P1.y;
import T.q;
import T2.s;
import a.AbstractC0141a;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.C0214v;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0206m;
import com.google.firebase.messaging.FirebaseMessaging;
import e2.C0277b;
import f1.AbstractC0286a;
import io.flutter.plugin.platform.r;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import m2.CallableC0445c;
import o.C0496W;
import q1.AbstractC0602b;
import s2.C0635g;
import s2.InterfaceC0640l;
import x.AbstractC0703c;
import x.C0702b;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f33f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f34g;

    public /* synthetic */ k(int i4, Object obj) {
        this.f33f = i4;
        this.f34g = obj;
    }

    private final void a() {
        q qVar = (q) this.f34g;
        synchronized (qVar.f1581d) {
            try {
                if (qVar.f1585h == null) {
                    return;
                }
                try {
                    F.l c4 = qVar.c();
                    int i4 = c4.f516f;
                    if (i4 == 2) {
                        synchronized (qVar.f1581d) {
                        }
                    }
                    if (i4 == 0) {
                        try {
                            int i5 = E.g.f456a;
                            Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            W0.g gVar = qVar.f1580c;
                            Context context = qVar.f1578a;
                            gVar.getClass();
                            F.l[] lVarArr = {c4};
                            AbstractC0602b abstractC0602b = B.f.f128a;
                            Trace.beginSection(k3.b.B("TypefaceCompat.createFromFontInfo"));
                            try {
                                Typeface l3 = B.f.f128a.l(context, lVarArr, 0);
                                Trace.endSection();
                                MappedByteBuffer w2 = AbstractC0141a.w(qVar.f1578a, c4.f511a);
                                if (w2 != null && l3 != null) {
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        y yVar = new y(l3, k3.b.u(w2));
                                        Trace.endSection();
                                        synchronized (qVar.f1581d) {
                                            try {
                                                AbstractC0286a abstractC0286a = qVar.f1585h;
                                                if (abstractC0286a != null) {
                                                    abstractC0286a.B(yVar);
                                                }
                                            } finally {
                                            }
                                        }
                                        qVar.b();
                                        return;
                                    } finally {
                                        int i6 = E.g.f456a;
                                    }
                                }
                                throw new RuntimeException("Unable to open file.");
                            } finally {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    throw new RuntimeException("fetchFonts result is not OK. (" + i4 + ")");
                } catch (Throwable th2) {
                    synchronized (qVar.f1581d) {
                        try {
                            AbstractC0286a abstractC0286a2 = qVar.f1585h;
                            if (abstractC0286a2 != null) {
                                abstractC0286a2.A(th2);
                            }
                            qVar.b();
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    @Override // java.lang.Runnable
    public final void run() {
        boolean isEmpty;
        Object obj;
        Application application;
        ?? r3 = 1;
        r3 = 1;
        C0702b c0702b = null;
        switch (this.f33f) {
            case 0:
                ((C0496W) this.f34g).getClass();
                return;
            case 1:
                C0024c c0024c = (C0024c) this.f34g;
                if (c0024c.f371j) {
                    return;
                }
                while (true) {
                    C0023b c0023b = (C0023b) c0024c.f366e.poll();
                    if (c0023b != null) {
                        HashMap hashMap = c0024c.f367f;
                        if (!(hashMap instanceof U2.a)) {
                            Long l3 = (Long) hashMap.remove(c0023b);
                            if (l3 != null) {
                                c0024c.f364c.remove(l3);
                                c0024c.f365d.remove(l3);
                                new y(((C0026e) c0024c.f362a.f93g).f382a, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", (InterfaceC0640l) C0026e.f381b.a(), null).v(android.support.v4.media.session.a.p(l3), new C2.c(1 == true ? 1 : 0, new C0029h(l3.longValue(), false ? 1 : 0)));
                            }
                        } else {
                            s.e(hashMap, "kotlin.collections.MutableMap");
                            throw null;
                        }
                    } else {
                        c0024c.f368g.postDelayed(c0024c.f369h, c0024c.k);
                        return;
                    }
                }
            case 2:
                Toast toast = (Toast) ((E0.a) this.f34g).f460h;
                if (toast != null) {
                    toast.show();
                    return;
                }
                return;
            case 3:
                O0.m mVar = (O0.m) this.f34g;
                ((P0.h) mVar.f1309d).f(new J(10, mVar));
                return;
            case 4:
                L l4 = (L) this.f34g;
                synchronized (((ArrayDeque) l4.f299i)) {
                    SharedPreferences.Editor edit = ((SharedPreferences) l4.f296f).edit();
                    String str = (String) l4.f297g;
                    StringBuilder sb = new StringBuilder();
                    Iterator it = ((ArrayDeque) l4.f299i).iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        sb.append((String) l4.f298h);
                    }
                    edit.putString(str, sb.toString()).apply();
                }
                return;
            case 5:
                P1.L l5 = (P1.L) this.f34g;
                Log.w("FirebaseMessaging", "Service took too long to process intent: " + l5.f1381a.getAction() + " finishing.");
                l5.f1382b.d(null);
                return;
            case 6:
                a();
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                E e4 = (E) this.f34g;
                C0214v c0214v = e4.k;
                if (e4.f2959g == 0) {
                    e4.f2960h = true;
                    c0214v.e(EnumC0206m.ON_PAUSE);
                }
                if (e4.f2958f == 0 && e4.f2960h) {
                    c0214v.e(EnumC0206m.ON_STOP);
                    e4.f2961i = true;
                    return;
                }
                return;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                e.i iVar = (e.i) this.f34g;
                Runnable runnable = iVar.f3556g;
                if (runnable != null) {
                    runnable.run();
                    iVar.f3556g = null;
                    return;
                }
                return;
            case 9:
                e.n.a((e.n) this.f34g);
                return;
            case 10:
                C0277b c0277b = (C0277b) this.f34g;
                C0635g c0635g = c0277b.f3600g;
                ConnectivityManager connectivityManager = (ConnectivityManager) c0277b.f3599f.f1532g;
                c0635g.a(R1.c.j(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())));
                return;
            case 11:
                ((r) this.f34g).f(false);
                return;
            case 12:
                j2.h hVar = (j2.h) this.f34g;
                ExecutorService executorService = hVar.f5074a;
                ConcurrentLinkedQueue concurrentLinkedQueue = hVar.f5075b;
                AtomicBoolean atomicBoolean = hVar.f5076c;
                if (atomicBoolean.compareAndSet(false, true)) {
                    int i4 = 12;
                    try {
                        Runnable runnable2 = (Runnable) concurrentLinkedQueue.poll();
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        if (!isEmpty) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        atomicBoolean.set(false);
                        if (!concurrentLinkedQueue.isEmpty()) {
                            executorService.execute(new k(i4, hVar));
                        }
                    }
                }
                return;
            case 13:
                ((CallableC0445c) this.f34g).f5200b.f5207e.prefetchDefaultFontManager();
                return;
            case 14:
                Activity activity = (Activity) this.f34g;
                if (!activity.isFinishing()) {
                    Handler handler = AbstractC0703c.f6355g;
                    Method method = AbstractC0703c.f6354f;
                    int i5 = Build.VERSION.SDK_INT;
                    if (i5 >= 28) {
                        activity.recreate();
                        return;
                    }
                    if (((i5 != 26 && i5 != 27) || method != null) && (AbstractC0703c.f6353e != null || AbstractC0703c.f6352d != null)) {
                        try {
                            Object obj2 = AbstractC0703c.f6351c.get(activity);
                            if (obj2 != null && (obj = AbstractC0703c.f6350b.get(activity)) != null) {
                                Application application2 = activity.getApplication();
                                C0702b c0702b2 = new C0702b(activity);
                                application2.registerActivityLifecycleCallbacks(c0702b2);
                                handler.post(new F.a(14, c0702b2, obj2));
                                if (i5 != 26 && i5 != 27) {
                                    r3 = 0;
                                }
                                int i6 = 15;
                                try {
                                    if (r3 != 0) {
                                        try {
                                            Boolean bool = Boolean.FALSE;
                                            r3 = application2;
                                            c0702b = c0702b2;
                                            method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                        } catch (Throwable th) {
                                            th = th;
                                            application = application2;
                                            c0702b = c0702b2;
                                            handler.post(new F.a(i6, application, c0702b));
                                            throw th;
                                        }
                                    } else {
                                        r3 = application2;
                                        c0702b = c0702b2;
                                        activity.recreate();
                                    }
                                    handler.post(new F.a(i6, r3, c0702b));
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    application = r3;
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    activity.recreate();
                    return;
                }
                return;
            default:
                P1.r rVar = ((P1.q) ((Map.Entry) this.f34g).getKey()).f1436a;
                if (rVar.b()) {
                    FirebaseMessaging firebaseMessaging = (FirebaseMessaging) rVar.f1441e;
                    A a4 = FirebaseMessaging.f3406l;
                    firebaseMessaging.k();
                    return;
                }
                return;
        }
    }

    public /* synthetic */ k(Map.Entry entry, G1.a aVar) {
        this.f33f = 15;
        this.f34g = entry;
    }
}
