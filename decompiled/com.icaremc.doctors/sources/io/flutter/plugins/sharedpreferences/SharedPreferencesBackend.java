package io.flutter.plugins.sharedpreferences;

import R0.j;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.encoders.json.BuildConfig;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class SharedPreferencesBackend implements SharedPreferencesAsyncApi {
    private Context context;
    private SharedPreferencesListEncoder listEncoder;
    private BinaryMessenger messenger;

    public SharedPreferencesBackend(BinaryMessenger messenger, Context context, SharedPreferencesListEncoder listEncoder) {
        h.e(messenger, "messenger");
        h.e(context, "context");
        h.e(listEncoder, "listEncoder");
        this.messenger = messenger;
        this.context = context;
        this.listEncoder = listEncoder;
        try {
            SharedPreferencesAsyncApi.Companion.setUp(messenger, this, "shared_preferences");
        } catch (Exception e2) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesBackend", e2);
        }
    }

    private final SharedPreferences createSharedPreferences(SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        if (sharedPreferencesPigeonOptions.getFileName() == null) {
            Context context = this.context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
            h.b(sharedPreferences);
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = this.context.getSharedPreferences(sharedPreferencesPigeonOptions.getFileName(), 0);
        h.b(sharedPreferences2);
        return sharedPreferences2;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void clear(List<String> list, SharedPreferencesPigeonOptions options) {
        Set set;
        h.e(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        SharedPreferences.Editor edit = createSharedPreferences.edit();
        h.d(edit, "edit(...)");
        Map<String, ?> all = createSharedPreferences.getAll();
        h.d(all, "getAll(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            Object obj = all.get(str);
            if (list != null) {
                set = j.W(list);
            } else {
                set = null;
            }
            if (SharedPreferencesPluginKt.preferencesFilter(str, obj, set)) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        h.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            h.d(next, "next(...)");
            edit.remove((String) next);
        }
        edit.apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Map<String, Object> getAll(List<String> list, SharedPreferencesPigeonOptions options) {
        Set set;
        Object value;
        h.e(options, "options");
        Map<String, ?> all = createSharedPreferences(options).getAll();
        h.d(all, "getAll(...)");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value2 = entry.getValue();
            if (list != null) {
                set = j.W(list);
            } else {
                set = null;
            }
            if (SharedPreferencesPluginKt.preferencesFilter(key, value2, set) && (value = entry.getValue()) != null) {
                String key2 = entry.getKey();
                Object transformPref = SharedPreferencesPluginKt.transformPref(value, this.listEncoder);
                h.c(transformPref, "null cannot be cast to non-null type kotlin.Any");
                hashMap.put(key2, transformPref);
            }
        }
        return hashMap;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Boolean getBool(String key, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (createSharedPreferences.contains(key)) {
            return Boolean.valueOf(createSharedPreferences.getBoolean(key, true));
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Double getDouble(String key, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (createSharedPreferences.contains(key)) {
            Object transformPref = SharedPreferencesPluginKt.transformPref(createSharedPreferences.getString(key, BuildConfig.FLAVOR), this.listEncoder);
            h.c(transformPref, "null cannot be cast to non-null type kotlin.Double");
            return (Double) transformPref;
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Long getInt(String key, SharedPreferencesPigeonOptions options) {
        long j2;
        h.e(key, "key");
        h.e(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (createSharedPreferences.contains(key)) {
            try {
                j2 = createSharedPreferences.getLong(key, 0L);
            } catch (ClassCastException unused) {
                j2 = createSharedPreferences.getInt(key, 0);
            }
            return Long.valueOf(j2);
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getKeys(List<String> list, SharedPreferencesPigeonOptions options) {
        Set set;
        h.e(options, "options");
        Map<String, ?> all = createSharedPreferences(options).getAll();
        h.d(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            h.d(key, "<get-key>(...)");
            String str = key;
            Object value = entry.getValue();
            if (list != null) {
                set = j.W(list);
            } else {
                set = null;
            }
            if (SharedPreferencesPluginKt.preferencesFilter(str, value, set)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return j.U(linkedHashMap.keySet());
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getPlatformEncodedStringList(String key, SharedPreferencesPigeonOptions options) {
        List list;
        h.e(key, "key");
        h.e(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (createSharedPreferences.contains(key)) {
            String string = createSharedPreferences.getString(key, BuildConfig.FLAVOR);
            h.b(string);
            if (string.startsWith(SharedPreferencesPluginKt.LIST_PREFIX) && !string.startsWith(SharedPreferencesPluginKt.JSON_LIST_PREFIX) && (list = (List) SharedPreferencesPluginKt.transformPref(createSharedPreferences.getString(key, BuildConfig.FLAVOR), this.listEncoder)) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof String) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public String getString(String key, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (createSharedPreferences.contains(key)) {
            return createSharedPreferences.getString(key, BuildConfig.FLAVOR);
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public StringListResult getStringList(String key, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (!createSharedPreferences.contains(key)) {
            return null;
        }
        String string = createSharedPreferences.getString(key, BuildConfig.FLAVOR);
        h.b(string);
        if (string.startsWith(SharedPreferencesPluginKt.JSON_LIST_PREFIX)) {
            return new StringListResult(string, StringListLookupResultType.JSON_ENCODED);
        }
        if (string.startsWith(SharedPreferencesPluginKt.LIST_PREFIX)) {
            return new StringListResult(null, StringListLookupResultType.PLATFORM_ENCODED);
        }
        return new StringListResult(null, StringListLookupResultType.UNEXPECTED_STRING);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setBool(String key, boolean z, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(options, "options");
        createSharedPreferences(options).edit().putBoolean(key, z).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDeprecatedStringList(String key, List<String> value, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(value, "value");
        h.e(options, "options");
        createSharedPreferences(options).edit().putString(key, O.a.m(SharedPreferencesPluginKt.LIST_PREFIX, this.listEncoder.encode(value))).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDouble(String key, double d2, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(options, "options");
        createSharedPreferences(options).edit().putString(key, SharedPreferencesPluginKt.DOUBLE_PREFIX + d2).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setEncodedStringList(String key, String value, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(value, "value");
        h.e(options, "options");
        createSharedPreferences(options).edit().putString(key, value).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setInt(String key, long j2, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(options, "options");
        createSharedPreferences(options).edit().putLong(key, j2).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setString(String key, String value, SharedPreferencesPigeonOptions options) {
        h.e(key, "key");
        h.e(value, "value");
        h.e(options, "options");
        createSharedPreferences(options).edit().putString(key, value).apply();
    }

    public final void tearDown() {
        SharedPreferencesAsyncApi.Companion.setUp(this.messenger, null, "shared_preferences");
    }

    public /* synthetic */ SharedPreferencesBackend(BinaryMessenger binaryMessenger, Context context, SharedPreferencesListEncoder sharedPreferencesListEncoder, int i2, e eVar) {
        this(binaryMessenger, context, (i2 & 4) != 0 ? new ListEncoder() : sharedPreferencesListEncoder);
    }
}
