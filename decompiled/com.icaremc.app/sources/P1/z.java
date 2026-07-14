package P1;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: d, reason: collision with root package name */
    public static final long f1473d = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a, reason: collision with root package name */
    public final String f1474a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1475b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1476c;

    public z(String str, String str2, long j4) {
        this.f1474a = str;
        this.f1475b = str2;
        this.f1476c = j4;
    }

    public static String a(String str, String str2, long j4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j4);
            return jSONObject.toString();
        } catch (JSONException e4) {
            Log.w("FirebaseMessaging", "Failed to encode token: " + e4);
            return null;
        }
    }

    public static z b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new z(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e4) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + e4);
                return null;
            }
        }
        return new z(str, null, 0L);
    }
}
