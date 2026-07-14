package Z0;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import c1.C0256b;
import h1.HandlerC0340e;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f2098g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static C f2099h;

    /* renamed from: i, reason: collision with root package name */
    public static HandlerThread f2100i;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2101a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f2102b;

    /* renamed from: c, reason: collision with root package name */
    public volatile HandlerC0340e f2103c;

    /* renamed from: d, reason: collision with root package name */
    public final C0256b f2104d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2105e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2106f;

    /* JADX WARN: Type inference failed for: r3v2, types: [h1.e, android.os.Handler] */
    public C(Context context, Looper looper) {
        V0.k kVar = new V0.k(1, this);
        this.f2102b = context.getApplicationContext();
        ?? handler = new Handler(looper, kVar);
        Looper.getMainLooper();
        this.f2103c = handler;
        this.f2104d = C0256b.a();
        this.f2105e = 5000L;
        this.f2106f = 300000L;
    }

    public final W0.a a(A a4, w wVar, String str) {
        W0.a aVar;
        HashMap hashMap = this.f2101a;
        synchronized (hashMap) {
            try {
                B b4 = (B) hashMap.get(a4);
                if (b4 == null) {
                    b4 = new B(this, a4);
                    b4.f2091a.put(wVar, wVar);
                    aVar = b4.a(str, null);
                    hashMap.put(a4, b4);
                } else {
                    this.f2103c.removeMessages(0, a4);
                    if (!b4.f2091a.containsKey(wVar)) {
                        b4.f2091a.put(wVar, wVar);
                        int i4 = b4.f2092b;
                        if (i4 != 1) {
                            if (i4 == 2) {
                                aVar = b4.a(str, null);
                            }
                        } else {
                            wVar.onServiceConnected(b4.f2096f, b4.f2094d);
                        }
                        aVar = null;
                    } else {
                        String a5 = a4.toString();
                        StringBuilder sb = new StringBuilder(a5.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(a5);
                        throw new IllegalStateException(sb.toString());
                    }
                }
                if (b4.f2093c) {
                    return W0.a.k;
                }
                if (aVar == null) {
                    aVar = new W0.a(-1, null, null);
                }
                return aVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(String str, ServiceConnection serviceConnection, boolean z) {
        A a4 = new A(str, z);
        r.f(serviceConnection, "ServiceConnection must not be null");
        HashMap hashMap = this.f2101a;
        synchronized (hashMap) {
            try {
                B b4 = (B) hashMap.get(a4);
                if (b4 != null) {
                    if (b4.f2091a.containsKey(serviceConnection)) {
                        b4.f2091a.remove(serviceConnection);
                        if (b4.f2091a.isEmpty()) {
                            this.f2103c.sendMessageDelayed(this.f2103c.obtainMessage(0, a4), this.f2105e);
                        }
                    } else {
                        String a5 = a4.toString();
                        StringBuilder sb = new StringBuilder(a5.length() + 76);
                        sb.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                        sb.append(a5);
                        throw new IllegalStateException(sb.toString());
                    }
                } else {
                    String a6 = a4.toString();
                    StringBuilder sb2 = new StringBuilder(a6.length() + 50);
                    sb2.append("Nonexistent connection status for service config: ");
                    sb2.append(a6);
                    throw new IllegalStateException(sb2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
