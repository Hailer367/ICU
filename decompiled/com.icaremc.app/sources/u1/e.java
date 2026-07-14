package u1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import t.C0655d;

/* loaded from: classes.dex */
public final class e extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f6218b = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final Context f6219a;

    public e(Context context) {
        this.f6219a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        synchronized (f.k) {
            try {
                Iterator it = ((C0655d) f.f6220l.values()).iterator();
                while (it.hasNext()) {
                    ((f) it.next()).g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f6219a.unregisterReceiver(this);
    }
}
