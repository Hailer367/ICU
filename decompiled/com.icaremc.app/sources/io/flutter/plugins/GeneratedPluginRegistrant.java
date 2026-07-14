package io.flutter.plugins;

import A2.w;
import B2.K;
import C2.g;
import D2.e0;
import F2.a;
import android.util.Log;
import androidx.annotation.Keep;
import c2.C0257a;
import com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin;
import com.github.dart_lang.jni.JniPlugin;
import com.github.dart_lang.jni_flutter.JniFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import d2.C0265f;
import e2.C0278c;
import f2.C0288a;
import i2.C0368c;
import x2.d;
import y2.f;
import z2.C0754a;

@Keep
/* loaded from: classes.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(C0368c c0368c) {
        try {
            c0368c.f4109d.a(new C0257a());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin app_links, com.llfbandit.app_links.AppLinksPlugin", e4);
        }
        try {
            c0368c.f4109d.a(new C0278c());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin connectivity_plus, dev.fluttercommunity.plus.connectivity.ConnectivityPlugin", e5);
        }
        try {
            c0368c.f4109d.a(new d());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin firebase_core, io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin", e6);
        }
        try {
            c0368c.f4109d.a(new f());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin firebase_messaging, io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin", e7);
        }
        try {
            c0368c.f4109d.a(new InAppWebViewFlutterPlugin());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin flutter_inappwebview_android, com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin", e8);
        }
        try {
            c0368c.f4109d.a(new FlutterLocalNotificationsPlugin());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin flutter_local_notifications, com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin", e9);
        }
        try {
            c0368c.f4109d.a(new C0754a());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e10);
        }
        try {
            c0368c.f4109d.a(new a());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin fluttertoast, io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin", e11);
        }
        try {
            c0368c.f4109d.a(new w());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin image_picker_android, io.flutter.plugins.imagepicker.ImagePickerPlugin", e12);
        }
        try {
            c0368c.f4109d.a(new C0265f());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin in_app_update, de.ffuf.in_app_update.InAppUpdatePlugin", e13);
        }
        try {
            c0368c.f4109d.a(new JniPlugin());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin jni, com.github.dart_lang.jni.JniPlugin", e14);
        }
        try {
            c0368c.f4109d.a(new JniFlutterPlugin());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin jni_flutter, com.github.dart_lang.jni_flutter.JniFlutterPlugin", e15);
        }
        try {
            c0368c.f4109d.a(new C0288a());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin package_info_plus, dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin", e16);
        }
        try {
            c0368c.f4109d.a(new K());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e17);
        }
        try {
            c0368c.f4109d.a(new g());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e18);
        }
        try {
            c0368c.f4109d.a(new e0());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin webview_flutter_android, io.flutter.plugins.webviewflutter.WebViewFlutterPlugin", e19);
        }
    }
}
