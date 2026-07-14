package q0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: d, reason: collision with root package name */
    public static final HashSet f5878d = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f5879a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5880b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5881c;

    public n(int i4, String str, String str2) {
        this.f5881c = i4;
        this.f5879a = str;
        this.f5880b = str2;
        f5878d.add(this);
    }

    public final boolean a(Context context) {
        boolean containsKey;
        PackageManager.ComponentInfoFlags of;
        ServiceInfo serviceInfo;
        if (!b()) {
            PackageInfo d4 = p0.w.d(context);
            Bundle bundle = null;
            if (d4 != null) {
                ComponentName componentName = new ComponentName(d4.packageName, "org.chromium.android_webview.services.StartupFeatureMetadataHolder");
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        of = PackageManager.ComponentInfoFlags.of(640L);
                        serviceInfo = context.getPackageManager().getServiceInfo(componentName, of);
                        bundle = serviceInfo.metaData;
                    } else {
                        bundle = context.getPackageManager().getServiceInfo(componentName, 640).metaData;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            if (bundle == null) {
                containsKey = false;
            } else {
                containsKey = bundle.containsKey(this.f5880b);
            }
            if (!containsKey) {
                return false;
            }
        }
        return true;
    }

    public final boolean b() {
        switch (this.f5881c) {
            case 0:
                return false;
            default:
                if (Build.VERSION.SDK_INT >= 28) {
                    return true;
                }
                return false;
        }
    }
}
