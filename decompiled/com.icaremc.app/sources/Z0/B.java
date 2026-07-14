package Z0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import c1.C0256b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class B implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2091a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f2092b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2093c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f2094d;

    /* renamed from: e, reason: collision with root package name */
    public final A f2095e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f2096f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C f2097g;

    public B(C c4, A a4) {
        this.f2097g = c4;
        this.f2095e = a4;
    }

    public final W0.a a(String str, Executor executor) {
        try {
            Intent a4 = t.a(this.f2097g.f2102b, this.f2095e);
            this.f2092b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(d1.e.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                C c4 = this.f2097g;
                C0256b c0256b = c4.f2104d;
                Context context = c4.f2102b;
                A a5 = this.f2095e;
                try {
                    boolean c5 = c0256b.c(context, str, a4, this, 4225, executor);
                    this.f2093c = c5;
                    if (c5) {
                        c4.f2103c.sendMessageDelayed(c4.f2103c.obtainMessage(1, a5), c4.f2106f);
                        W0.a aVar = W0.a.k;
                        StrictMode.setVmPolicy(vmPolicy);
                        return aVar;
                    }
                    this.f2092b = 2;
                    try {
                        c4.f2104d.b(c4.f2102b, this);
                    } catch (IllegalArgumentException unused) {
                    }
                    W0.a aVar2 = new W0.a(16, null, null);
                    StrictMode.setVmPolicy(vmPolicy);
                    return aVar2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    StrictMode.setVmPolicy(vmPolicy);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (s e4) {
            return e4.f2178f;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C c4 = this.f2097g;
        synchronized (c4.f2101a) {
            try {
                c4.f2103c.removeMessages(1, this.f2095e);
                this.f2094d = iBinder;
                this.f2096f = componentName;
                Iterator it = this.f2091a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f2092b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C c4 = this.f2097g;
        synchronized (c4.f2101a) {
            try {
                c4.f2103c.removeMessages(1, this.f2095e);
                this.f2094d = null;
                this.f2096f = componentName;
                Iterator it = this.f2091a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f2092b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
