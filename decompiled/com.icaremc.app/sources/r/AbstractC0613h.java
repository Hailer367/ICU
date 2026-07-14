package r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import b.InterfaceC0221d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: r.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0613h {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0221d f5994a;

    /* renamed from: b, reason: collision with root package name */
    public final ComponentName f5995b;

    public AbstractC0613h(InterfaceC0221d interfaceC0221d, ComponentName componentName) {
        this.f5994a = interfaceC0221d;
        this.f5995b = componentName;
    }

    public static String a(Context context, List list, boolean z) {
        List<String> list2;
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        if (list == null) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList = new ArrayList(list2.size() + 1);
            arrayList.add(str);
            if (list != null) {
                arrayList.addAll(list);
            }
            list2 = arrayList;
        }
        Intent intent2 = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : list2) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
            return null;
        }
        return null;
    }
}
