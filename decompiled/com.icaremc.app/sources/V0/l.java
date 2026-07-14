package V0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import c1.C0256b;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class l implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public int f1701a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Messenger f1702b;

    /* renamed from: c, reason: collision with root package name */
    public E0.a f1703c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f1704d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f1705e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n f1706f;

    public l(n nVar) {
        this.f1706f = nVar;
        Handler handler = new Handler(Looper.getMainLooper(), new k(0, this));
        Looper.getMainLooper();
        this.f1702b = new Messenger(handler);
        this.f1704d = new ArrayDeque();
        this.f1705e = new SparseArray();
    }

    public final synchronized void a(String str) {
        b(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Exception, P1.x] */
    public final synchronized void b(String str, SecurityException securityException) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i4 = this.f1701a;
            if (i4 != 0) {
                if (i4 != 1 && i4 != 2) {
                    if (i4 != 3) {
                        return;
                    }
                    this.f1701a = 4;
                    return;
                }
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f1701a = 4;
                C0256b.a().b(this.f1706f.f1713a, this);
                ?? exc = new Exception(str, securityException);
                Iterator it = this.f1704d.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).b(exc);
                }
                this.f1704d.clear();
                for (int i5 = 0; i5 < this.f1705e.size(); i5++) {
                    ((m) this.f1705e.valueAt(i5)).b(exc);
                }
                this.f1705e.clear();
                return;
            }
            throw new IllegalStateException();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        try {
            if (this.f1701a == 2 && this.f1704d.isEmpty() && this.f1705e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f1701a = 3;
                C0256b.a().b(this.f1706f.f1713a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean d(m mVar) {
        Throwable th;
        int i4;
        try {
            try {
                i4 = this.f1701a;
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
            try {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return false;
                        }
                        this.f1704d.add(mVar);
                        this.f1706f.f1714b.execute(new j(this, 0));
                        return true;
                    }
                    this.f1704d.add(mVar);
                    return true;
                }
                this.f1704d.add(mVar);
                if (this.f1701a == 0) {
                    if (Log.isLoggable("MessengerIpcClient", 2)) {
                        Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                    }
                    this.f1701a = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    try {
                        C0256b a4 = C0256b.a();
                        Context context = this.f1706f.f1713a;
                        try {
                            if (!a4.c(context, context.getClass().getName(), intent, this, 1, null)) {
                                a("Unable to bind to service");
                            } else {
                                this.f1706f.f1714b.schedule(new j(this, 1), 30L, TimeUnit.SECONDS);
                            }
                        } catch (SecurityException e4) {
                            e = e4;
                            b("Unable to bind to service", e);
                            return true;
                        }
                    } catch (SecurityException e5) {
                        e = e5;
                    }
                    return true;
                }
                throw new IllegalStateException();
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f1706f.f1714b.execute(new F.a(2, this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f1706f.f1714b.execute(new j(this, 2));
    }
}
