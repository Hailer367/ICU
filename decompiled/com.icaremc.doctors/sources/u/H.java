package u;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: d, reason: collision with root package name */
    public static String f3694d;

    /* renamed from: g, reason: collision with root package name */
    public static G f3697g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3698a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f3699b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f3693c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static HashSet f3695e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f3696f = new Object();

    public H(Context context) {
        this.f3698a = context;
        this.f3699b = (NotificationManager) context.getSystemService("notification");
    }

    public final void a(int i2, String str) {
        this.f3699b.cancel(str, i2);
    }

    public final void b(String str, int i2, Notification notification) {
        Bundle bundle = notification.extras;
        if (bundle != null && bundle.getBoolean("android.support.useSideChannel")) {
            C0309D c0309d = new C0309D(this.f3698a.getPackageName(), i2, str, notification);
            synchronized (f3696f) {
                try {
                    if (f3697g == null) {
                        f3697g = new G(this.f3698a.getApplicationContext());
                    }
                    f3697g.f3690b.obtainMessage(0, c0309d).sendToTarget();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f3699b.cancel(str, i2);
            return;
        }
        this.f3699b.notify(str, i2, notification);
    }
}
