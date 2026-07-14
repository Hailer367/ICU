package c0;

import android.app.Notification;
import io.flutter.plugin.platform.C0381e;
import x.B;
import x.p;

/* renamed from: c0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0254a extends B {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3316e;

    @Override // x.B
    public final void b(C0381e c0381e) {
        switch (this.f3316e) {
            case 0:
                ((Notification.Builder) c0381e.f4327c).setStyle(new Notification.MediaStyle());
                return;
            default:
                ((Notification.Builder) c0381e.f4327c).setStyle(p.a());
                return;
        }
    }

    @Override // x.B
    public String c() {
        switch (this.f3316e) {
            case 1:
                return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
            default:
                return super.c();
        }
    }
}
