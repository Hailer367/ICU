package P1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: classes.dex */
public final class B extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1341a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Context f1342b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1343c;

    public /* synthetic */ B() {
    }

    public void a() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        C c4 = (C) this.f1343c;
        if (c4 != null) {
            Context context = c4.f1346h.f3410b;
            this.f1342b = context;
            context.registerReceiver(this, intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        switch (this.f1341a) {
            case 0:
                C c4 = (C) this.f1343c;
                if (c4 != null && c4.a()) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    C c5 = (C) this.f1343c;
                    c5.f1346h.getClass();
                    FirebaseMessaging.b(c5, 0L);
                    Context context2 = this.f1342b;
                    if (context2 != null) {
                        context2.unregisterReceiver(this);
                    }
                    this.f1343c = null;
                    return;
                }
                return;
            default:
                Uri data = intent.getData();
                if (data != null) {
                    str = data.getSchemeSpecificPart();
                } else {
                    str = null;
                }
                if (!"com.google.android.gms".equals(str)) {
                    return;
                }
                ((F.b) ((E0.a) this.f1343c).f460h).getClass();
                throw null;
        }
    }

    public B(E0.a aVar) {
        this.f1343c = aVar;
    }
}
