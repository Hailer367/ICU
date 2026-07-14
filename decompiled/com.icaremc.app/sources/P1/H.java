package P1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class H extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public I f1368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I f1369b;

    public H(I i4, I i5) {
        this.f1369b = i4;
        this.f1368a = i5;
    }

    public final void a() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        this.f1369b.f1372f.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        try {
            I i4 = this.f1368a;
            if (i4 == null) {
                return;
            }
            if (!i4.d()) {
                return;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            I i5 = this.f1368a;
            i5.f1375i.f1365f.schedule(i5, 0L, TimeUnit.SECONDS);
            context.unregisterReceiver(this);
            this.f1368a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
