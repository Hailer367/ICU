package r;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import p1.C0580i;
import q1.AbstractC0602b;

/* renamed from: r.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0618m implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6005f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f6006g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f6007h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f6008i;

    public /* synthetic */ RunnableC0618m(int i4, Object obj, Object obj2, boolean z) {
        this.f6005f = i4;
        this.f6006g = obj;
        this.f6007h = z;
        this.f6008i = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        String notificationDelegate;
        switch (this.f6005f) {
            case 0:
                ((p) this.f6006g).onSessionEnded(this.f6007h, (Bundle) this.f6008i);
                return;
            case 1:
                ((p) this.f6006g).onVerticalScrollEvent(this.f6007h, (Bundle) this.f6008i);
                return;
            default:
                Context context = (Context) this.f6006g;
                C0580i c0580i = (C0580i) this.f6008i;
                try {
                    if (Binder.getCallingUid() == context.getApplicationInfo().uid) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Log.e("FirebaseMessaging", "error configuring notification delegate for package " + context.getPackageName());
                    } else {
                        SharedPreferences.Editor edit = AbstractC0602b.E(context).edit();
                        edit.putBoolean("proxy_notification_initialized", true);
                        edit.apply();
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                        if (this.f6007h) {
                            notificationManager.setNotificationDelegate("com.google.android.gms");
                        } else {
                            notificationDelegate = notificationManager.getNotificationDelegate();
                            if ("com.google.android.gms".equals(notificationDelegate)) {
                                notificationManager.setNotificationDelegate(null);
                            }
                        }
                    }
                    return;
                } finally {
                    c0580i.d(null);
                }
        }
    }
}
