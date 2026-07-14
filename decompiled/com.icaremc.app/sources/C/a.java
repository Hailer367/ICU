package C;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a {
    public static Notification.Builder a(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static Icon b(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }

    public static List c(NotificationManager notificationManager) {
        return notificationManager.getNotificationChannels();
    }

    public static float d(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static float e(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    public static boolean f(File file, File file2) {
        try {
            Files.move(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Intent g(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return context.registerReceiver(broadcastReceiver, intentFilter, null, null, 0);
    }

    public static Intent h(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return context.registerReceiver(broadcastReceiver, intentFilter, null, null, 2);
    }

    public static void i(RemoteInput.Builder builder, String str) {
        builder.setAllowDataType(str, true);
    }

    public static void j(MenuItem menuItem, char c4, int i4) {
        menuItem.setAlphabeticShortcut(c4, i4);
    }

    public static void k(Notification.Builder builder) {
        builder.setBadgeIconType(0);
    }

    public static void l(Notification.Builder builder, boolean z) {
        builder.setColorized(z);
    }

    public static void m(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setContentDescription(charSequence);
    }

    public static void n(Notification.Builder builder, int i4) {
        builder.setGroupAlertBehavior(i4);
    }

    public static void o(MenuItem menuItem, ColorStateList colorStateList) {
        menuItem.setIconTintList(colorStateList);
    }

    public static void p(MenuItem menuItem, PorterDuff.Mode mode) {
        menuItem.setIconTintMode(mode);
    }

    public static void q(MenuItem menuItem, char c4, int i4) {
        menuItem.setNumericShortcut(c4, i4);
    }

    public static void r(Notification.Builder builder) {
        builder.setSettingsText(null);
    }

    public static void s(Notification.Builder builder, String str) {
        builder.setShortcutId(str);
    }

    public static void t(Notification.Builder builder, long j4) {
        builder.setTimeoutAfter(j4);
    }

    public static void u(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setTooltipText(charSequence);
    }

    public static void v(Context context, Intent intent) {
        context.startForegroundService(intent);
    }
}
