package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.base.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;
import r.j;

/* loaded from: classes.dex */
public final class zaf {
    private static final j zaa = new j(0);
    private static Locale zab;

    public static String zaa(Context context, int i2) {
        Resources resources = context.getResources();
        switch (i2) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zah(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zah(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 22);
                sb.append("Unexpected error code ");
                sb.append(i2);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zah(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zah(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String zab(Context context, int i2) {
        String zaa2;
        if (i2 == 6) {
            zaa2 = zah(context, "common_google_play_services_resolution_required_title");
        } else {
            zaa2 = zaa(context, i2);
        }
        if (zaa2 == null) {
            return context.getResources().getString(R.string.common_google_play_services_notification_ticker);
        }
        return zaa2;
    }

    public static String zac(Context context, int i2) {
        Resources resources = context.getResources();
        String zaf = zaf(context);
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        if (i2 != 7) {
                            if (i2 != 9) {
                                if (i2 != 20) {
                                    switch (i2) {
                                        case 16:
                                            return zag(context, "common_google_play_services_api_unavailable_text", zaf);
                                        case 17:
                                            return zag(context, "common_google_play_services_sign_in_failed_text", zaf);
                                        case ConnectionResult.SERVICE_UPDATING /* 18 */:
                                            return resources.getString(R.string.common_google_play_services_updating_text, zaf);
                                        default:
                                            return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, zaf);
                                    }
                                }
                                return zag(context, "common_google_play_services_restricted_profile_text", zaf);
                            }
                            return resources.getString(R.string.common_google_play_services_unsupported_text, zaf);
                        }
                        return zag(context, "common_google_play_services_network_error_text", zaf);
                    }
                    return zag(context, "common_google_play_services_invalid_account_text", zaf);
                }
                return resources.getString(R.string.common_google_play_services_enable_text, zaf);
            }
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                return resources.getString(R.string.common_google_play_services_wear_update_text);
            }
            return resources.getString(R.string.common_google_play_services_update_text, zaf);
        }
        return resources.getString(R.string.common_google_play_services_install_text, zaf);
    }

    public static String zad(Context context, int i2) {
        if (i2 != 6 && i2 != 19) {
            return zac(context, i2);
        }
        return zag(context, "common_google_play_services_resolution_required_text", zaf(context));
    }

    public static String zae(Context context, int i2) {
        Resources resources = context.getResources();
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return resources.getString(android.R.string.ok);
                }
                return resources.getString(R.string.common_google_play_services_enable_button);
            }
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        return resources.getString(R.string.common_google_play_services_install_button);
    }

    public static String zaf(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    private static String zag(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zah = zah(context, str);
        if (zah == null) {
            zah = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zah, str2);
    }

    private static String zah(Context context, String str) {
        j jVar = zaa;
        synchronized (jVar) {
            try {
                Locale locale = context.getResources().getConfiguration().getLocales().get(0);
                if (!locale.equals(zab)) {
                    jVar.clear();
                    zab = locale;
                }
                String str2 = (String) jVar.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
                if (remoteResource == null) {
                    return null;
                }
                int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    StringBuilder sb = new StringBuilder(str.length() + 18);
                    sb.append("Missing resource: ");
                    sb.append(str);
                    Log.w("GoogleApiAvailability", sb.toString());
                    return null;
                }
                String string = remoteResource.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    StringBuilder sb2 = new StringBuilder(str.length() + 20);
                    sb2.append("Got empty resource: ");
                    sb2.append(str);
                    Log.w("GoogleApiAvailability", sb2.toString());
                    return null;
                }
                jVar.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
