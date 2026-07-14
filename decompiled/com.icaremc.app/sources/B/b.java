package B;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Insets;

/* loaded from: classes.dex */
public abstract class b {
    public static String a(Context context) {
        return context.getOpPackageName();
    }

    public static Insets b(int i4, int i5, int i6, int i7) {
        return Insets.of(i4, i5, i6, i7);
    }

    public static void c(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void d(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void e(Notification.Action.Builder builder, boolean z) {
        builder.setContextual(z);
    }

    public static void f(RemoteInput.Builder builder) {
        builder.setEditChoicesBeforeSending(0);
    }
}
