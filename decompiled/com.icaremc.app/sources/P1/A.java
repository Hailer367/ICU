package P1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import f1.AbstractC0286a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: b, reason: collision with root package name */
    public static A f1339b;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f1340a;

    public A(Context context) {
        boolean isEmpty;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f1340a = sharedPreferences;
        File file = new File(context.getNoBackupFilesDir(), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    synchronized (this) {
                        isEmpty = sharedPreferences.getAll().isEmpty();
                    }
                    if (!isEmpty) {
                        Log.i("FirebaseMessaging", "App restored, clearing state");
                        synchronized (this) {
                            sharedPreferences.edit().clear().commit();
                        }
                    }
                }
            } catch (IOException e4) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e4.getMessage());
                }
            }
        }
    }

    public static String a(String str, String str2) {
        return str + "|T|" + str2 + "|*";
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [P1.A, java.lang.Object] */
    public static A c() {
        if (f1339b == null) {
            f1339b = new Object();
        }
        return f1339b;
    }

    public static ArrayList e(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            Object obj = jSONArray.get(i4);
            if (obj instanceof JSONArray) {
                obj = e((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = f((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static HashMap f(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = e((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = f((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public HashMap b(String str) {
        String string = d().getString(str, null);
        if (string != null) {
            try {
                HashMap hashMap = new HashMap(1);
                HashMap f4 = f(new JSONObject(string));
                f4.put("to", str);
                hashMap.put("message", f4);
                return hashMap;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public SharedPreferences d() {
        if (this.f1340a == null) {
            this.f1340a = AbstractC0286a.f3704c.getSharedPreferences("io.flutter.plugins.firebase.messaging", 0);
        }
        return this.f1340a;
    }

    public void g(String str) {
        d().edit().remove(str).apply();
        String string = d().getString("notification_ids", "");
        if (!string.isEmpty()) {
            d().edit().putString("notification_ids", string.replace(str.concat(","), "")).apply();
        }
    }
}
