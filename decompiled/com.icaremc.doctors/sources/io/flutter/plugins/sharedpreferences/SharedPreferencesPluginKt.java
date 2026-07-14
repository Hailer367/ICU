package io.flutter.plugins.sharedpreferences;

import K.InterfaceC0034i;
import android.content.Context;
import i1.j;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.r;

/* loaded from: classes.dex */
public final class SharedPreferencesPluginKt {
    static final /* synthetic */ j[] $$delegatedProperties;
    public static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    public static final String JSON_LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!";
    public static final String LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    public static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    public static final String TAG = "SharedPreferencesPlugin";
    private static final e1.a sharedPreferencesDataStore$delegate;

    static {
        l lVar = new l(SharedPreferencesPluginKt.class, "sharedPreferencesDataStore", "getSharedPreferencesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        r.f2790a.getClass();
        $$delegatedProperties = new j[]{lVar};
        sharedPreferencesDataStore$delegate = android.support.v4.media.session.a.B(SHARED_PREFERENCES_NAME, null, null, 14);
    }

    public static final InterfaceC0034i getSharedPreferencesDataStore(Context context) {
        h.e(context, "<this>");
        return ((N.b) sharedPreferencesDataStore$delegate).a(context, $$delegatedProperties[0]);
    }

    public static final boolean preferencesFilter(String key, Object obj, Set<String> set) {
        h.e(key, "key");
        if (set == null) {
            if (!(obj instanceof Boolean) && !(obj instanceof Long) && !(obj instanceof String) && !(obj instanceof Double)) {
                return false;
            }
            return true;
        }
        return set.contains(key);
    }

    public static final Object transformPref(Object obj, SharedPreferencesListEncoder listEncoder) {
        h.e(listEncoder, "listEncoder");
        if (obj instanceof String) {
            String str = (String) obj;
            h.e(str, "<this>");
            if (str.startsWith(LIST_PREFIX)) {
                if (str.startsWith(JSON_LIST_PREFIX)) {
                    return obj;
                }
                String substring = str.substring(40);
                h.d(substring, "substring(...)");
                List<String> decode = listEncoder.decode(substring);
                h.b(decode);
                return decode;
            }
            if (str.startsWith(DOUBLE_PREFIX)) {
                String substring2 = str.substring(40);
                h.d(substring2, "substring(...)");
                return Double.valueOf(Double.parseDouble(substring2));
            }
            return obj;
        }
        return obj;
    }
}
