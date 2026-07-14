package io.flutter.plugins.firebase.messaging;

import P1.A;
import P1.w;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import androidx.lifecycle.AbstractC0217y;
import f1.AbstractC0286a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import k3.b;
import org.json.JSONObject;
import y2.h;
import y2.o;

/* loaded from: classes.dex */
public class FlutterFirebaseMessagingReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f4411a = new HashMap();

    /* JADX WARN: Type inference failed for: r10v3, types: [y2.h, androidx.lifecycle.y] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z;
        Context context2;
        Log.d("FLTFireMsgReceiver", "broadcast received for message");
        if (AbstractC0286a.f3704c == null) {
            if (context.getApplicationContext() != null) {
                context2 = context.getApplicationContext();
            } else {
                context2 = context;
            }
            Log.d("FLTFireContextHolder", "received application context.");
            AbstractC0286a.f3704c = context2;
        }
        if (intent.getExtras() == null) {
            Log.d("FLTFireMsgReceiver", "broadcast received but intent contained no extras to process RemoteMessage. Operation cancelled.");
            return;
        }
        w wVar = new w(intent.getExtras());
        if (wVar.c() != null) {
            f4411a.put(wVar.b(), wVar);
            A c4 = A.c();
            c4.getClass();
            c4.d().edit().putString(wVar.b(), new JSONObject(b.v(wVar)).toString()).apply();
            String str = c4.d().getString("notification_ids", "") + wVar.b() + ",";
            ArrayList arrayList = new ArrayList(Arrays.asList(str.split(",")));
            if (arrayList.size() > 100) {
                String str2 = (String) arrayList.get(0);
                c4.d().edit().remove(str2).apply();
                str = str.replace(str2 + ",", "");
            }
            c4.d().edit().putString("notification_ids", str).apply();
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if ((keyguardManager == null || !keyguardManager.isKeyguardLocked()) && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                    if (h.f6613l == null) {
                        h.f6613l = new AbstractC0217y();
                    }
                    h.f6613l.d(wVar);
                    return;
                }
            }
        }
        Intent intent2 = new Intent(context, (Class<?>) FlutterFirebaseMessagingBackgroundService.class);
        Parcel obtain = Parcel.obtain();
        wVar.writeToParcel(obtain, 0);
        intent2.putExtra("notification", obtain.marshall());
        Bundle bundle = wVar.f1465f;
        String string = bundle.getString("google.original_priority");
        if (string == null) {
            string = bundle.getString("google.priority");
        }
        if ("high".equals(string)) {
            z = true;
        } else {
            "normal".equals(string);
            z = false;
        }
        List list = FlutterFirebaseMessagingBackgroundService.f4409m;
        ComponentName componentName = new ComponentName(context, (Class<?>) FlutterFirebaseMessagingBackgroundService.class);
        synchronized (a.k) {
            o b4 = a.b(context, componentName, true, 2020, z);
            b4.b(2020);
            try {
                b4.a(intent2);
            } catch (IllegalStateException e4) {
                if (z) {
                    a.b(context, componentName, true, 2020, false).a(intent2);
                } else {
                    throw e4;
                }
            }
        }
    }
}
