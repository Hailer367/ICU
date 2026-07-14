package u;

import android.app.Notification;
import android.app.RemoteInput;

/* renamed from: u.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0306A {
    public static void a(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void b(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void c(Notification.Action.Builder builder, boolean z) {
        builder.setContextual(z);
    }

    public static void d(RemoteInput.Builder builder) {
        builder.setEditChoicesBeforeSending(0);
    }
}
