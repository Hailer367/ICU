package P1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1437a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1438b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1439c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1440d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1441e;

    public r(String str, String str2, String str3, String str4, boolean z) {
        this.f1438b = str == null ? "libapp.so" : str;
        this.f1439c = str2 == null ? "flutter_assets" : str2;
        this.f1441e = str4;
        this.f1440d = str3 == null ? "" : str3;
        this.f1437a = z;
    }

    public synchronized void a() {
        try {
            if (this.f1437a) {
                return;
            }
            Boolean c4 = c();
            this.f1440d = c4;
            if (c4 == null) {
                q qVar = new q(this);
                this.f1439c = qVar;
                ((x1.i) ((G1.c) this.f1438b)).b(qVar);
            }
            this.f1437a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean b() {
        boolean z;
        boolean z3;
        try {
            a();
            Boolean bool = (Boolean) this.f1440d;
            if (bool != null) {
                z3 = bool.booleanValue();
            } else {
                u1.f fVar = ((FirebaseMessaging) this.f1441e).f3409a;
                fVar.a();
                O1.a aVar = (O1.a) fVar.f6227g.get();
                synchronized (aVar) {
                    z = aVar.f1313d;
                }
                z3 = z;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z3;
    }

    public Boolean c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        u1.f fVar = ((FirebaseMessaging) this.f1441e).f3409a;
        fVar.a();
        Context context = fVar.f6221a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public r(FirebaseMessaging firebaseMessaging, G1.c cVar) {
        this.f1441e = firebaseMessaging;
        this.f1438b = cVar;
    }
}
