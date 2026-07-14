package u;

import android.app.Notification;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: u.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0318i extends z {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3736e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3737f;

    public C0318i(int i2) {
        this.f3736e = i2;
        switch (i2) {
            case 1:
                this.f3737f = new ArrayList();
                return;
            default:
                return;
        }
    }

    @Override // u.z
    public final void b(C0308C c0308c) {
        switch (this.f3736e) {
            case 0:
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(c0308c.f3674b).setBigContentTitle(this.f3805b).bigText((CharSequence) this.f3737f);
                if (this.f3807d) {
                    bigText.setSummaryText(this.f3806c);
                    return;
                }
                return;
            default:
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(c0308c.f3674b).setBigContentTitle(this.f3805b);
                if (this.f3807d) {
                    bigContentTitle.setSummaryText(this.f3806c);
                }
                ArrayList arrayList = (ArrayList) this.f3737f;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    bigContentTitle.addLine((CharSequence) obj);
                }
                return;
        }
    }

    @Override // u.z
    public final String c() {
        switch (this.f3736e) {
            case 0:
                return "androidx.core.app.NotificationCompat$BigTextStyle";
            default:
                return "androidx.core.app.NotificationCompat$InboxStyle";
        }
    }

    @Override // u.z
    public final void d(Bundle bundle) {
        switch (this.f3736e) {
            case 0:
                super.d(bundle);
                this.f3737f = bundle.getCharSequence("android.bigText");
                return;
            default:
                super.d(bundle);
                ArrayList arrayList = (ArrayList) this.f3737f;
                arrayList.clear();
                if (bundle.containsKey("android.textLines")) {
                    Collections.addAll(arrayList, bundle.getCharSequenceArray("android.textLines"));
                    return;
                }
                return;
        }
    }
}
