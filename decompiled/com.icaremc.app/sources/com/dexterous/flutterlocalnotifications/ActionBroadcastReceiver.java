package com.dexterous.flutterlocalnotifications;

import A2.q;
import A2.t;
import A2.x;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Keep;
import i2.C0368c;
import io.flutter.view.FlutterCallbackInformation;
import j2.C0427b;
import java.util.ArrayList;
import java.util.Map;
import m2.C0447e;
import s2.C0635g;
import x.H;

/* loaded from: classes.dex */
public class ActionBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    public static E0.a f3329b;

    /* renamed from: c, reason: collision with root package name */
    public static C0368c f3330c;

    /* renamed from: a, reason: collision with root package name */
    public x f3331a;

    @Keep
    public ActionBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!"com.dexterous.flutterlocalnotifications.ActionBroadcastReceiver.ACTION_TAPPED".equalsIgnoreCase(intent.getAction())) {
            return;
        }
        x xVar = this.f3331a;
        if (xVar == null) {
            xVar = new x(context, false);
        }
        this.f3331a = xVar;
        Map<String, Object> extractNotificationResponseMap = FlutterLocalNotificationsPlugin.extractNotificationResponseMap(intent);
        if (intent.getBooleanExtra("cancelNotification", false)) {
            int intValue = ((Integer) extractNotificationResponseMap.get("notificationId")).intValue();
            Object obj = extractNotificationResponseMap.get("notificationTag");
            if (obj instanceof String) {
                new H(context).a(intValue, (String) obj);
            } else {
                new H(context).a(intValue, null);
            }
        }
        if (f3329b == null) {
            f3329b = new E0.a(22);
        }
        E0.a aVar = f3329b;
        C0635g c0635g = (C0635g) aVar.f460h;
        if (c0635g != null) {
            c0635g.a(extractNotificationResponseMap);
        } else {
            ((ArrayList) aVar.f459g).add(extractNotificationResponseMap);
        }
        if (f3330c != null) {
            Log.e("ActionBroadcastReceiver", "Engine is already initialised");
            return;
        }
        C0447e c0447e = (C0447e) t.O().f99g;
        c0447e.d(context);
        c0447e.a(context, null);
        f3330c = new C0368c(context, null);
        FlutterCallbackInformation lookupCallbackInformation = FlutterCallbackInformation.lookupCallbackInformation(this.f3331a.f117a.getSharedPreferences("flutter_local_notifications_plugin", 0).getLong("com.dexterous.flutterlocalnotifications.CALLBACK_DISPATCHER_HANDLE_KEY", -1L));
        if (lookupCallbackInformation == null) {
            Log.w("ActionBroadcastReceiver", "Callback information could not be retrieved");
            return;
        }
        C0427b c0427b = f3330c.f4108c;
        new t((q) c0427b.k, "dexterous.com/flutter/local_notifications/actions").X(f3329b);
        c0427b.c(new t(context.getAssets(), (String) c0447e.f5206d.f1439c, lookupCallbackInformation, 20));
    }
}
