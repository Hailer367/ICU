package io.flutter.embedding.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.flutter.Log;

/* loaded from: classes.dex */
class ContentSizingFlag {
    private static final boolean DEFAULT = false;
    private static final String ENABLE_CONTENT_SIZING = "io.flutter.embedding.android.EnableContentSizing";
    private static final String TAG = "ContentSizingFlag";

    public static boolean isEnabled(Context context) {
        Bundle bundle;
        Context applicationContext = context.getApplicationContext();
        try {
            bundle = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "Could not get metadata");
            bundle = null;
        }
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(ENABLE_CONTENT_SIZING, false);
    }
}
