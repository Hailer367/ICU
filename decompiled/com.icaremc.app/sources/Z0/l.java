package Z0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.icaremc.app.R;
import f1.C0287b;
import java.util.Locale;
import t.C0661j;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final C0661j f2154a = new C0661j(0);

    /* renamed from: b, reason: collision with root package name */
    public static Locale f2155b;

    public static String a(Context context, int i4) {
        Resources resources = context.getResources();
        switch (i4) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return e(context, "common_google_play_services_invalid_account_title");
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return e(context, "common_google_play_services_network_error_title");
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
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
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 22);
                sb.append("Unexpected error code ");
                sb.append(i4);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return e(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return e(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String b(Context context, int i4) {
        Resources resources = context.getResources();
        String c4 = c(context);
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 5) {
                        if (i4 != 7) {
                            if (i4 != 9) {
                                if (i4 != 20) {
                                    switch (i4) {
                                        case 16:
                                            return d(context, "common_google_play_services_api_unavailable_text", c4);
                                        case 17:
                                            return d(context, "common_google_play_services_sign_in_failed_text", c4);
                                        case 18:
                                            return resources.getString(R.string.common_google_play_services_updating_text, c4);
                                        default:
                                            return resources.getString(R.string.common_google_play_services_unknown_issue, c4);
                                    }
                                }
                                return d(context, "common_google_play_services_restricted_profile_text", c4);
                            }
                            return resources.getString(R.string.common_google_play_services_unsupported_text, c4);
                        }
                        return d(context, "common_google_play_services_network_error_text", c4);
                    }
                    return d(context, "common_google_play_services_invalid_account_text", c4);
                }
                return resources.getString(R.string.common_google_play_services_enable_text, c4);
            }
            if (d1.b.c(context)) {
                return resources.getString(R.string.common_google_play_services_wear_update_text);
            }
            return resources.getString(R.string.common_google_play_services_update_text, c4);
        }
        return resources.getString(R.string.common_google_play_services_install_text, c4);
    }

    public static String c(Context context) {
        String packageName = context.getPackageName();
        try {
            Context context2 = C0287b.a(context).f117a;
            return context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    public static String d(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String e4 = e(context, str);
        if (e4 == null) {
            e4 = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, e4, str2);
    }

    public static String e(Context context, String str) {
        Resources resources;
        C0661j c0661j = f2154a;
        synchronized (c0661j) {
            try {
                Locale locale = context.getResources().getConfiguration().getLocales().get(0);
                if (!locale.equals(f2155b)) {
                    c0661j.clear();
                    f2155b = locale;
                }
                String str2 = (String) c0661j.get(str);
                if (str2 != null) {
                    return str2;
                }
                int i4 = W0.f.f1865c;
                try {
                    resources = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resources = null;
                }
                if (resources != null) {
                    int identifier = resources.getIdentifier(str, "string", "com.google.android.gms");
                    if (identifier == 0) {
                        StringBuilder sb = new StringBuilder(str.length() + 18);
                        sb.append("Missing resource: ");
                        sb.append(str);
                        Log.w("GoogleApiAvailability", sb.toString());
                    } else {
                        String string = resources.getString(identifier);
                        if (TextUtils.isEmpty(string)) {
                            StringBuilder sb2 = new StringBuilder(str.length() + 20);
                            sb2.append("Got empty resource: ");
                            sb2.append(str);
                            Log.w("GoogleApiAvailability", sb2.toString());
                        } else {
                            c0661j.put(str, string);
                            return string;
                        }
                    }
                }
                return null;
            } finally {
            }
        }
    }
}
