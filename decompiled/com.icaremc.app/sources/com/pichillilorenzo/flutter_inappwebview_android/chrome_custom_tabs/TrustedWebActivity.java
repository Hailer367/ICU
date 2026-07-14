package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import r.BinderC0612g;
import r.C0614i;
import r.o;
import s.C0626c;
import s.C0627d;
import s.InterfaceC0625b;

/* loaded from: classes.dex */
public class TrustedWebActivity extends ChromeCustomTabsActivity {
    protected static final String LOG_TAG = "TrustedWebActivity";
    public C0627d builder;

    private void prepareCustomTabs() {
        Integer num;
        Integer num2;
        Integer num3;
        String str = this.customSettings.toolbarBackgroundColor;
        Integer num4 = null;
        if (str != null && !str.isEmpty()) {
            num = Integer.valueOf(Color.parseColor(this.customSettings.toolbarBackgroundColor) | (-16777216));
        } else {
            num = null;
        }
        String str2 = this.customSettings.navigationBarColor;
        if (str2 != null && !str2.isEmpty()) {
            num2 = Integer.valueOf((-16777216) | Color.parseColor(this.customSettings.navigationBarColor));
        } else {
            num2 = null;
        }
        String str3 = this.customSettings.navigationBarDividerColor;
        if (str3 != null && !str3.isEmpty()) {
            num3 = Integer.valueOf(Color.parseColor(this.customSettings.navigationBarDividerColor));
        } else {
            num3 = null;
        }
        String str4 = this.customSettings.secondaryToolbarColor;
        if (str4 != null && !str4.isEmpty()) {
            num4 = Integer.valueOf(Color.parseColor(this.customSettings.secondaryToolbarColor));
        }
        C0614i c0614i = this.builder.f6120b;
        c0614i.getClass();
        Bundle bundle = new Bundle();
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        if (num4 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num4.intValue());
        }
        if (num2 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num2.intValue());
        }
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num3.intValue());
        }
        c0614i.f6000e = bundle;
        List<String> list = this.customSettings.additionalTrustedOrigins;
        if (list != null && !list.isEmpty()) {
            this.builder.f6121c = this.customSettings.additionalTrustedOrigins;
        }
        ChromeCustomTabsSettings chromeCustomTabsSettings = this.customSettings;
        InterfaceC0625b interfaceC0625b = chromeCustomTabsSettings.displayMode;
        if (interfaceC0625b != null) {
            this.builder.f6122d = interfaceC0625b;
        }
        this.builder.f6123e = chromeCustomTabsSettings.screenOrientation.intValue();
    }

    private void prepareCustomTabsIntent(C0626c c0626c) {
        Intent intent = c0626c.f6118a;
        String str = this.customSettings.packageName;
        if (str != null) {
            intent.setPackage(str);
        } else {
            intent.setPackage(CustomTabsHelper.getPackageNameToUse(this));
        }
        if (this.customSettings.keepAliveEnabled.booleanValue()) {
            CustomTabsHelper.addKeepAliveExtra(this, intent);
        }
        if (this.customSettings.alwaysUseBrowserUI.booleanValue()) {
            if (intent == null) {
                intent = new Intent("android.intent.action.VIEW");
            }
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity
    public void launchUrl(String str, Map<String, String> map, String str2, List<String> list) {
        Uri uri;
        if (this.customTabsSession == null) {
            return;
        }
        Uri parse = Uri.parse(str);
        mayLaunchUrl(str, list);
        this.builder = new C0627d(parse);
        prepareCustomTabs();
        C0627d c0627d = this.builder;
        o oVar = this.customTabsSession;
        C0614i c0614i = c0627d.f6120b;
        if (oVar != null) {
            Intent intent = c0614i.f5996a;
            intent.setPackage(oVar.f6014d.getPackageName());
            BinderC0612g binderC0612g = oVar.f6013c;
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", binderC0612g);
            intent.putExtras(bundle);
            Intent intent2 = c0614i.a().f6003a;
            intent2.setData(c0627d.f6119a);
            intent2.putExtra("android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY", true);
            if (c0627d.f6121c != null) {
                intent2.putExtra("android.support.customtabs.extra.ADDITIONAL_TRUSTED_ORIGINS", new ArrayList(c0627d.f6121c));
            }
            List list2 = Collections.EMPTY_LIST;
            intent2.putExtra("androidx.browser.trusted.extra.DISPLAY_MODE", c0627d.f6122d.b());
            intent2.putExtra("androidx.browser.trusted.extra.SCREEN_ORIENTATION", c0627d.f6123e);
            intent2.putExtra("androidx.browser.trusted.extra.LAUNCH_HANDLER_CLIENT_MODE", 0);
            C0626c c0626c = new C0626c(intent2);
            prepareCustomTabsIntent(c0626c);
            if (str2 != null) {
                uri = Uri.parse(str2);
            } else {
                uri = null;
            }
            CustomTabActivityHelper.openTrustedWebActivity(this, c0626c, parse, map, uri, 100);
            return;
        }
        throw new NullPointerException("CustomTabsSession is required for launching a TWA");
    }
}
