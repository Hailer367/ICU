package io.flutter.plugins.urllauncher;

import E.AbstractC0025z;
import F.e;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
final class UrlLauncher implements UrlLauncherApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "UrlLauncher";
    private Activity activity;
    private final Context applicationContext;
    private final IntentResolver intentResolver;

    /* loaded from: classes.dex */
    public interface IntentResolver {
        String getHandlerComponentName(Intent intent);
    }

    public UrlLauncher(Context context, IntentResolver intentResolver) {
        this.applicationContext = context;
        this.intentResolver = intentResolver;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0024. Please report as an issue. */
    private static boolean containsRestrictedHeader(Map<String, String> map) {
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            char c2 = 0;
            if (!it.hasNext()) {
                return false;
            }
            String lowerCase = it.next().toLowerCase(Locale.US);
            lowerCase.getClass();
            switch (lowerCase.hashCode()) {
                case -1423461112:
                    if (lowerCase.equals("accept")) {
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1229727188:
                    if (lowerCase.equals("content-language")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 785670158:
                    if (lowerCase.equals("content-type")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 802785917:
                    if (lowerCase.equals("accept-language")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                case 3:
                default:
                    return true;
            }
        }
    }

    private void ensureActivity() {
        if (this.activity != null) {
        } else {
            throw new FlutterError("NO_ACTIVITY", "Launching a URL requires a foreground activity.", null);
        }
    }

    private static Bundle extractBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    public static /* synthetic */ String lambda$new$0(Context context, Intent intent) {
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity == null) {
            return null;
        }
        return resolveActivity.toShortString();
    }

    private static boolean openCustomTab(Context context, Uri uri, Bundle bundle, BrowserOptions browserOptions) {
        String str;
        ActivityOptions activityOptions;
        Bundle bundle2;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", browserOptions.getShowTitle() ? 1 : 0);
        Bundle bundle3 = null;
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle4 = new Bundle();
            bundle4.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle4);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
        intent.putExtras(new Bundle());
        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
        int i2 = Build.VERSION.SDK_INT;
        LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
        if (adjustedDefault.size() > 0) {
            str = adjustedDefault.get(0).toLanguageTag();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (intent.hasExtra("com.android.browser.headers")) {
                bundle2 = intent.getBundleExtra("com.android.browser.headers");
            } else {
                bundle2 = new Bundle();
            }
            if (!bundle2.containsKey("Accept-Language")) {
                bundle2.putString("Accept-Language", str);
                intent.putExtra("com.android.browser.headers", bundle2);
            }
        }
        if (i2 >= 34) {
            activityOptions = ActivityOptions.makeBasic();
            AbstractC0025z.h(activityOptions);
        } else {
            activityOptions = null;
        }
        if (i2 >= 36) {
            if (activityOptions == null) {
                activityOptions = ActivityOptions.makeBasic();
            }
            e.e(activityOptions, !intent.getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false));
        }
        if (activityOptions != null) {
            bundle3 = activityOptions.toBundle();
        }
        intent.putExtra("com.android.browser.headers", bundle);
        try {
            intent.setData(uri);
            context.startActivity(intent, bundle3);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.plugins.urllauncher.UrlLauncherApi
    public boolean canLaunchUrl(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (this.intentResolver.getHandlerComponentName(intent) == null) {
            return false;
        }
        return !"{com.android.fallback/com.android.fallback.Fallback}".equals(r3);
    }

    @Override // io.flutter.plugins.urllauncher.UrlLauncherApi
    public void closeWebView() {
        this.applicationContext.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }

    @Override // io.flutter.plugins.urllauncher.UrlLauncherApi
    public boolean launchUrl(String str, Map<String, String> map, boolean z) {
        ensureActivity();
        Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", extractBundle(map));
        if (z && Build.VERSION.SDK_INT >= 30) {
            putExtra.addFlags(1024);
        }
        try {
            this.activity.startActivity(putExtra);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.plugins.urllauncher.UrlLauncherApi
    public boolean openUrlInApp(String str, boolean z, WebViewOptions webViewOptions, BrowserOptions browserOptions) {
        ensureActivity();
        Bundle extractBundle = extractBundle(webViewOptions.getHeaders());
        if (z && !containsRestrictedHeader(webViewOptions.getHeaders())) {
            if (openCustomTab(this.activity, Uri.parse(str), extractBundle, browserOptions)) {
                return true;
            }
        }
        try {
            this.activity.startActivity(WebViewActivity.createIntent(this.activity, str, webViewOptions.getEnableJavaScript(), webViewOptions.getEnableDomStorage(), extractBundle));
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override // io.flutter.plugins.urllauncher.UrlLauncherApi
    public boolean supportsCustomTabs() {
        List list;
        String str;
        Context context = this.applicationContext;
        List list2 = Collections.EMPTY_LIST;
        PackageManager packageManager = context.getPackageManager();
        if (list2 == null) {
            list = new ArrayList();
        } else {
            list = list2;
        }
        ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://")), 0);
        if (resolveActivity != null) {
            String str2 = resolveActivity.activityInfo.packageName;
            ArrayList arrayList = new ArrayList(list.size() + 1);
            arrayList.add(str2);
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            list = arrayList;
        }
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                str = (String) it.next();
                intent.setPackage(str);
                if (packageManager.resolveService(intent, 0) != null) {
                    break;
                }
            } else {
                if (Build.VERSION.SDK_INT >= 30) {
                    Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
                }
                str = null;
            }
        }
        if (str == null) {
            return false;
        }
        return true;
    }

    public UrlLauncher(Context context) {
        this(context, new a(5, context));
    }
}
