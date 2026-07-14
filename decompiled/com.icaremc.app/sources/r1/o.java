package r1;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import n.p;
import p1.C0580i;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: n, reason: collision with root package name */
    public static final HashMap f6031n = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f6032a;

    /* renamed from: b, reason: collision with root package name */
    public final p f6033b;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6038g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f6039h;

    /* renamed from: l, reason: collision with root package name */
    public n f6042l;

    /* renamed from: m, reason: collision with root package name */
    public g f6043m;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f6035d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f6036e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Object f6037f = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final k f6041j = new IBinder.DeathRecipient() { // from class: r1.k
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            o oVar = o.this;
            int i4 = 0;
            oVar.f6033b.o("reportBinderDeath", new Object[0]);
            if (oVar.f6040i.get() == null) {
                oVar.f6033b.o("%s : Binder has died.", oVar.f6034c);
                ArrayList arrayList = oVar.f6035d;
                int size = arrayList.size();
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    RemoteException remoteException = new RemoteException(String.valueOf(oVar.f6034c).concat(" : Binder has died."));
                    C0580i c0580i = ((j) obj).f6024f;
                    if (c0580i != null) {
                        c0580i.c(remoteException);
                    }
                }
                oVar.f6035d.clear();
                synchronized (oVar.f6037f) {
                    oVar.d();
                }
                return;
            }
            throw new ClassCastException();
        }
    };
    public final AtomicInteger k = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final String f6034c = "AppUpdateService";

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference f6040i = new WeakReference(null);

    /* JADX WARN: Type inference failed for: r0v3, types: [r1.k] */
    public o(Context context, p pVar, Intent intent) {
        this.f6032a = context;
        this.f6033b = pVar;
        this.f6039h = intent;
    }

    public static void b(o oVar, j jVar) {
        g gVar = oVar.f6043m;
        p pVar = oVar.f6033b;
        ArrayList arrayList = oVar.f6035d;
        int i4 = 0;
        if (gVar == null && !oVar.f6038g) {
            pVar.o("Initiate binding to the service.", new Object[0]);
            arrayList.add(jVar);
            n nVar = new n(oVar);
            oVar.f6042l = nVar;
            oVar.f6038g = true;
            if (!oVar.f6032a.bindService(oVar.f6039h, nVar, 1)) {
                pVar.o("Failed to bind to the service.", new Object[0]);
                oVar.f6038g = false;
                int size = arrayList.size();
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    RuntimeException runtimeException = new RuntimeException("Failed to bind to the service.");
                    C0580i c0580i = ((j) obj).f6024f;
                    if (c0580i != null) {
                        c0580i.c(runtimeException);
                    }
                }
                arrayList.clear();
                return;
            }
            return;
        }
        if (oVar.f6038g) {
            pVar.o("Waiting to bind to the service.", new Object[0]);
            arrayList.add(jVar);
        } else {
            jVar.run();
        }
    }

    public final Handler a() {
        Handler handler;
        HashMap hashMap = f6031n;
        synchronized (hashMap) {
            try {
                if (!hashMap.containsKey(this.f6034c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f6034c, 10);
                    handlerThread.start();
                    hashMap.put(this.f6034c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) hashMap.get(this.f6034c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(C0580i c0580i) {
        synchronized (this.f6037f) {
            this.f6036e.remove(c0580i);
        }
        a().post(new l(0, this));
    }

    public final void d() {
        HashSet hashSet = this.f6036e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0580i) it.next()).c(new RemoteException(String.valueOf(this.f6034c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
