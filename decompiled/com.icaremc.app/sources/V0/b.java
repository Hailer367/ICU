package V0;

import A2.t;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import i1.AbstractC0365a;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p1.C0580i;
import p1.C0585n;
import t.C0661j;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: h, reason: collision with root package name */
    public static int f1673h;

    /* renamed from: i, reason: collision with root package name */
    public static PendingIntent f1674i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f1675j = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: b, reason: collision with root package name */
    public final Context f1677b;

    /* renamed from: c, reason: collision with root package name */
    public final o f1678c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f1679d;

    /* renamed from: f, reason: collision with root package name */
    public Messenger f1681f;

    /* renamed from: g, reason: collision with root package name */
    public g f1682g;

    /* renamed from: a, reason: collision with root package name */
    public final C0661j f1676a = new C0661j(0);

    /* renamed from: e, reason: collision with root package name */
    public final Messenger f1680e = new Messenger(new e(this, Looper.getMainLooper()));

    public b(Context context) {
        this.f1677b = context;
        this.f1678c = new o(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f1679d = scheduledThreadPoolExecutor;
    }

    public final C0585n a(Bundle bundle) {
        String num;
        synchronized (b.class) {
            int i4 = f1673h;
            f1673h = i4 + 1;
            num = Integer.toString(i4);
        }
        C0580i c0580i = new C0580i();
        synchronized (this.f1676a) {
            this.f1676a.put(num, c0580i);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f1678c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        Context context = this.f1677b;
        synchronized (b.class) {
            try {
                if (f1674i == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    f1674i = PendingIntent.getBroadcast(context, 0, intent2, AbstractC0365a.f4103a);
                }
                intent.putExtra("app", f1674i);
            } finally {
            }
        }
        intent.putExtra("kid", "|ID|" + num + "|");
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.f1680e);
        if (this.f1681f != null || this.f1682g != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f1681f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    Messenger messenger2 = this.f1682g.f1689f;
                    messenger2.getClass();
                    messenger2.send(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            c0580i.f5821a.g(h.f1691h, new t(this, num, this.f1679d.schedule(new F.b(2, c0580i), 30L, TimeUnit.SECONDS), 12));
            return c0580i.f5821a;
        }
        if (this.f1678c.b() == 2) {
            this.f1677b.sendBroadcast(intent);
        } else {
            this.f1677b.startService(intent);
        }
        c0580i.f5821a.g(h.f1691h, new t(this, num, this.f1679d.schedule(new F.b(2, c0580i), 30L, TimeUnit.SECONDS), 12));
        return c0580i.f5821a;
    }

    public final void b(String str, Bundle bundle) {
        synchronized (this.f1676a) {
            try {
                C0580i c0580i = (C0580i) this.f1676a.remove(str);
                if (c0580i == null) {
                    Log.w("Rpc", "Missing callback for " + str);
                    return;
                }
                c0580i.b(bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
