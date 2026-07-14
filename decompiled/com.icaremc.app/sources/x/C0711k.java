package x;

import android.app.Notification;
import android.os.Bundle;
import io.flutter.plugin.platform.C0381e;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: x.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0711k extends B {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f6380e;

    /* renamed from: f, reason: collision with root package name */
    public Object f6381f;

    public C0711k(int i4) {
        this.f6380e = i4;
        switch (i4) {
            case 1:
                this.f6381f = new ArrayList();
                return;
            default:
                return;
        }
    }

    @Override // x.B
    public final void b(C0381e c0381e) {
        switch (this.f6380e) {
            case 0:
                Notification.BigTextStyle bigText = new Notification.BigTextStyle((Notification.Builder) c0381e.f4327c).setBigContentTitle(this.f6305b).bigText((CharSequence) this.f6381f);
                if (this.f6307d) {
                    bigText.setSummaryText(this.f6306c);
                    return;
                }
                return;
            default:
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle((Notification.Builder) c0381e.f4327c).setBigContentTitle(this.f6305b);
                if (this.f6307d) {
                    bigContentTitle.setSummaryText(this.f6306c);
                }
                ArrayList arrayList = (ArrayList) this.f6381f;
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    bigContentTitle.addLine((CharSequence) obj);
                }
                return;
        }
    }

    @Override // x.B
    public final String c() {
        switch (this.f6380e) {
            case 0:
                return "androidx.core.app.NotificationCompat$BigTextStyle";
            default:
                return "androidx.core.app.NotificationCompat$InboxStyle";
        }
    }

    @Override // x.B
    public final void d(Bundle bundle) {
        switch (this.f6380e) {
            case 0:
                super.d(bundle);
                this.f6381f = bundle.getCharSequence("android.bigText");
                return;
            default:
                super.d(bundle);
                ArrayList arrayList = (ArrayList) this.f6381f;
                arrayList.clear();
                if (bundle.containsKey("android.textLines")) {
                    Collections.addAll(arrayList, bundle.getCharSequenceArray("android.textLines"));
                    return;
                }
                return;
        }
    }
}
