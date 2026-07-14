package com.pichillilorenzo.flutter_inappwebview_android;

import android.os.Build;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class PlatformUtil extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "PlatformUtil";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_platformutil";
    public InAppWebViewFlutterPlugin plugin;

    public PlatformUtil(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new C0644p(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public static String formatDate(long j4, String str, Locale locale, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date(j4));
    }

    public static Locale getLocaleFromString(String str) {
        String str2;
        if (str == null) {
            return Locale.US;
        }
        String[] split = str.split("_");
        String str3 = split[0];
        String str4 = "";
        if (split.length <= 1) {
            str2 = "";
        } else {
            str2 = split[1];
        }
        if (split.length > 2) {
            str4 = split[2];
        }
        return new Locale(str3, str2, str4);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        String str = c0641m.f6155a;
        str.getClass();
        if (!str.equals("formatDate")) {
            if (!str.equals("getSystemVersion")) {
                interfaceC0643o.notImplemented();
                return;
            } else {
                interfaceC0643o.success(String.valueOf(Build.VERSION.SDK_INT));
                return;
            }
        }
        long longValue = ((Long) c0641m.a("date")).longValue();
        String str2 = (String) c0641m.a("format");
        Locale localeFromString = getLocaleFromString((String) c0641m.a("locale"));
        String str3 = (String) c0641m.a("timezone");
        if (str3 == null) {
            str3 = "UTC";
        }
        interfaceC0643o.success(formatDate(longValue, str2, localeFromString, DesugarTimeZone.getTimeZone(str3)));
    }
}
