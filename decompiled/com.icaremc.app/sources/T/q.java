package T;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import f1.AbstractC0286a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class q implements j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1578a;

    /* renamed from: b, reason: collision with root package name */
    public final F.f f1579b;

    /* renamed from: c, reason: collision with root package name */
    public final W0.g f1580c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1581d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public Handler f1582e;

    /* renamed from: f, reason: collision with root package name */
    public ThreadPoolExecutor f1583f;

    /* renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f1584g;

    /* renamed from: h, reason: collision with root package name */
    public AbstractC0286a f1585h;

    public q(Context context, F.f fVar) {
        android.support.v4.media.session.a.h(context, "Context cannot be null");
        this.f1578a = context.getApplicationContext();
        this.f1579b = fVar;
        this.f1580c = r.f1586d;
    }

    @Override // T.j
    public final void a(AbstractC0286a abstractC0286a) {
        synchronized (this.f1581d) {
            this.f1585h = abstractC0286a;
        }
        synchronized (this.f1581d) {
            try {
                if (this.f1585h == null) {
                    return;
                }
                if (this.f1583f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f1584g = threadPoolExecutor;
                    this.f1583f = threadPoolExecutor;
                }
                this.f1583f.execute(new A.k(6, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f1581d) {
            try {
                this.f1585h = null;
                Handler handler = this.f1582e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f1582e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f1584g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f1583f = null;
                this.f1584g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final F.l c() {
        try {
            W0.g gVar = this.f1580c;
            Context context = this.f1578a;
            F.f fVar = this.f1579b;
            gVar.getClass();
            Object[] objArr = {fVar};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            F.k a4 = F.e.a(context, Collections.unmodifiableList(arrayList));
            int i4 = a4.f509a;
            if (i4 == 0) {
                F.l[] lVarArr = (F.l[]) ((List) a4.f510b).get(0);
                if (lVarArr != null && lVarArr.length != 0) {
                    return lVarArr[0];
                }
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            throw new RuntimeException("fetchFonts failed (" + i4 + ")");
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException("provider not found", e4);
        }
    }
}
