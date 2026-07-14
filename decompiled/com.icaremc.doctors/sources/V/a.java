package V;

import android.app.Notification;
import u.AbstractC0323n;
import u.C0308C;
import u.z;

/* loaded from: classes.dex */
public final class a extends z {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f782e;

    @Override // u.z
    public final void b(C0308C c0308c) {
        switch (this.f782e) {
            case 0:
                c0308c.f3674b.setStyle(new Notification.MediaStyle());
                return;
            default:
                c0308c.f3674b.setStyle(AbstractC0323n.a());
                return;
        }
    }

    @Override // u.z
    public String c() {
        switch (this.f782e) {
            case 1:
                return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
            default:
                return super.c();
        }
    }
}
