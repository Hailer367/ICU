package V0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import f1.C0287b;
import java.util.List;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1717a;

    /* renamed from: b, reason: collision with root package name */
    public int f1718b;

    /* renamed from: c, reason: collision with root package name */
    public int f1719c = 0;

    public o(Context context) {
        this.f1717a = context;
    }

    public final synchronized int a() {
        PackageInfo packageInfo;
        if (this.f1718b == 0) {
            try {
                packageInfo = C0287b.a(this.f1717a).f117a.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e4) {
                Log.w("Metadata", "Failed to find package ".concat(e4.toString()));
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.f1718b = packageInfo.versionCode;
            }
        }
        return this.f1718b;
    }

    public final synchronized int b() {
        int i4 = this.f1719c;
        if (i4 != 0) {
            return i4;
        }
        Context context = this.f1717a;
        PackageManager packageManager = context.getPackageManager();
        if (C0287b.a(context).f117a.getPackageManager().checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i5 = 1;
        if (!d1.b.b()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                this.f1719c = i5;
                return i5;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
            i5 = 2;
            this.f1719c = i5;
            return i5;
        }
        Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
        if (true == d1.b.b()) {
            i5 = 2;
        }
        this.f1719c = i5;
        return i5;
    }
}
