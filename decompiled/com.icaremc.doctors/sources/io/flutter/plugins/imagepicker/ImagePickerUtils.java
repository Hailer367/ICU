package io.flutter.plugins.imagepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ImagePickerUtils {
    public static int getLimitFromOption(GeneralOptions generalOptions) {
        Long limit = generalOptions.getLimit();
        int maxItems = getMaxItems();
        if (limit != null && limit.longValue() < maxItems) {
            return Math.toIntExact(limit.longValue());
        }
        return maxItems;
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static int getMaxItems() {
        int pickImagesMaxLimit;
        int extensionVersion;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 33) {
            if (i2 >= 30) {
                extensionVersion = SdkExtensions.getExtensionVersion(30);
                if (extensionVersion < 2) {
                    return Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
            } else {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
        }
        pickImagesMaxLimit = MediaStore.getPickImagesMaxLimit();
        return pickImagesMaxLimit;
    }

    private static PackageInfo getPermissionsPackageInfoPreApi33(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 4096);
    }

    private static boolean isPermissionPresentInManifest(Context context, String str) {
        PackageInfo permissionsPackageInfoPreApi33;
        PackageManager.PackageInfoFlags of;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 33) {
                String packageName = context.getPackageName();
                of = PackageManager.PackageInfoFlags.of(4096L);
                permissionsPackageInfoPreApi33 = packageManager.getPackageInfo(packageName, of);
            } else {
                permissionsPackageInfoPreApi33 = getPermissionsPackageInfoPreApi33(packageManager, context.getPackageName());
            }
            return Arrays.asList(permissionsPackageInfoPreApi33.requestedPermissions).contains(str);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean needRequestCameraPermission(Context context) {
        return isPermissionPresentInManifest(context, "android.permission.CAMERA");
    }
}
