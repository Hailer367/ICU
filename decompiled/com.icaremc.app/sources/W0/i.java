package W0;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import h1.HandlerC0340e;

/* loaded from: classes.dex */
public final class i extends HandlerC0340e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1870a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1871b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i(W0.d r2, android.content.Context r3) {
        /*
            r1 = this;
            r1.f1871b = r2
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r2 != 0) goto Ld
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            goto L11
        Ld:
            android.os.Looper r2 = android.os.Looper.myLooper()
        L11:
            r0 = 0
            r1.<init>(r2, r0)
            android.content.Context r2 = r3.getApplicationContext()
            r1.f1870a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.i.<init>(W0.d, android.content.Context):void");
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        PendingIntent activity;
        int i4 = message.what;
        if (i4 != 1) {
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 39);
            sb.append("Don't know how to handle this message: ");
            sb.append(i4);
            Log.w("GoogleApiAvailability", sb.toString());
            return;
        }
        int i5 = e.f1862a;
        d dVar = this.f1871b;
        Context context = this.f1870a;
        int b4 = dVar.b(context, i5);
        int i6 = f.f1865c;
        if (b4 != 1 && b4 != 2 && b4 != 3 && b4 != 9) {
            return;
        }
        Intent a4 = dVar.a(b4, context, "n");
        if (a4 == null) {
            activity = null;
        } else {
            activity = PendingIntent.getActivity(context, 0, a4, 201326592);
        }
        dVar.f(context, b4, activity);
    }
}
