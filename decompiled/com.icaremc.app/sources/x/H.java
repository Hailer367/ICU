package x;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: d, reason: collision with root package name */
    public static String f6324d;

    /* renamed from: g, reason: collision with root package name */
    public static G f6327g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6328a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f6329b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f6323c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static HashSet f6325e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f6326f = new Object();

    public H(Context context) {
        this.f6328a = context;
        this.f6329b = (NotificationManager) context.getSystemService("notification");
    }

    public final void a(int i4, String str) {
        this.f6329b.cancel(str, i4);
    }

    public final void b(String str, int i4, Notification notification) {
        Bundle bundle = notification.extras;
        if (bundle != null && bundle.getBoolean("android.support.useSideChannel")) {
            D d4 = new D(this.f6328a.getPackageName(), i4, str, notification);
            synchronized (f6326f) {
                try {
                    if (f6327g == null) {
                        f6327g = new G(this.f6328a.getApplicationContext());
                    }
                    f6327g.f6320b.obtainMessage(0, d4).sendToTarget();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f6329b.cancel(str, i4);
            return;
        }
        this.f6329b.notify(str, i4, notification);
    }
}
