package P1;

import I.C0050d;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p1.C0580i;
import p1.C0585n;
import q1.AbstractC0602b;
import t.C0656e;
import t.C0661j;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: i, reason: collision with root package name */
    public static final long f1358i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f1359j = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f1360a;

    /* renamed from: b, reason: collision with root package name */
    public final C0050d f1361b;

    /* renamed from: c, reason: collision with root package name */
    public final I0.h f1362c;

    /* renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f1363d;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f1365f;

    /* renamed from: h, reason: collision with root package name */
    public final E f1367h;

    /* renamed from: e, reason: collision with root package name */
    public final C0656e f1364e = new C0661j(0);

    /* renamed from: g, reason: collision with root package name */
    public boolean f1366g = false;

    /* JADX WARN: Type inference failed for: r0v0, types: [t.j, t.e] */
    public G(FirebaseMessaging firebaseMessaging, C0050d c0050d, E e4, I0.h hVar, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f1363d = firebaseMessaging;
        this.f1361b = c0050d;
        this.f1367h = e4;
        this.f1362c = hVar;
        this.f1360a = context;
        this.f1365f = scheduledThreadPoolExecutor;
    }

    public static void a(C0585n c0585n) {
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            AbstractC0602b.d(c0585n, 30L);
        } catch (InterruptedException | TimeoutException e4) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e4);
        } catch (ExecutionException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e5);
            }
            throw ((IOException) cause);
        }
    }

    public final void b(String str) {
        String a4 = this.f1363d.a();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        I0.h hVar = this.f1362c;
        a(hVar.k(hVar.p(a4, "/topics/" + str, bundle)));
    }

    public final void c(String str) {
        String a4 = this.f1363d.a();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        I0.h hVar = this.f1362c;
        a(hVar.k(hVar.p(a4, "/topics/" + str, bundle)));
    }

    public final C0585n d(D d4) {
        ArrayDeque arrayDeque;
        E e4 = this.f1367h;
        synchronized (e4) {
            D2.L l3 = e4.f1352a;
            String str = d4.f1350c;
            l3.getClass();
            if (!TextUtils.isEmpty(str) && !str.contains((String) l3.f298h)) {
                synchronized (((ArrayDeque) l3.f299i)) {
                    if (((ArrayDeque) l3.f299i).add(str)) {
                        ((ScheduledThreadPoolExecutor) l3.f300j).execute(new A.k(4, l3));
                    }
                }
            }
        }
        C0580i c0580i = new C0580i();
        synchronized (this.f1364e) {
            try {
                String str2 = d4.f1350c;
                if (this.f1364e.containsKey(str2)) {
                    arrayDeque = (ArrayDeque) this.f1364e.get(str2);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f1364e.put(str2, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(c0580i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0580i.f5821a;
    }

    public final synchronized void e(boolean z) {
        this.f1366g = z;
    }

    public final void f() {
        boolean z;
        if (this.f1367h.a() != null) {
            synchronized (this) {
                z = this.f1366g;
            }
            if (!z) {
                h(0L);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0094 A[Catch: IOException -> 0x0047, TryCatch #0 {IOException -> 0x0047, blocks: (B:8:0x002c, B:16:0x0059, B:18:0x0061, B:64:0x0076, B:66:0x0081, B:67:0x0094, B:69:0x009f, B:70:0x003d, B:73:0x004a), top: B:7:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g() {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P1.G.g():boolean");
    }

    public final void h(long j4) {
        this.f1365f.schedule(new I(this, this.f1360a, this.f1361b, Math.min(Math.max(30L, 2 * j4), f1358i)), j4, TimeUnit.SECONDS);
        e(true);
    }
}
