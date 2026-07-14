package O1;

import G1.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import u1.C0667b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1310a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f1311b;

    /* renamed from: c, reason: collision with root package name */
    public final b f1312c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1313d;

    public a(Context context, String str, b bVar) {
        boolean a4;
        Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        this.f1310a = createDeviceProtectedStorageContext;
        SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f1311b = sharedPreferences;
        this.f1312c = bVar;
        if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
            a4 = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
        } else {
            a4 = a();
        }
        this.f1313d = a4;
    }

    public final boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.f1310a;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public final synchronized void b(boolean z) {
        if (this.f1313d != z) {
            this.f1313d = z;
            this.f1312c.a(new G1.a(new C0667b(0)));
        }
    }
}
