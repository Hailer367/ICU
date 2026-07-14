package q1;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import java.util.HashSet;
import n.p;

/* renamed from: q1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0603c {

    /* renamed from: a, reason: collision with root package name */
    public final p f5944a;

    /* renamed from: b, reason: collision with root package name */
    public final IntentFilter f5945b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f5946c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f5947d;

    /* renamed from: e, reason: collision with root package name */
    public C2.h f5948e;

    public C0603c(Context context) {
        p pVar = new p("AppUpdateListenerRegistry");
        IntentFilter intentFilter = new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS");
        this.f5947d = new HashSet();
        this.f5948e = null;
        this.f5944a = pVar;
        this.f5945b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.f5946c = applicationContext != null ? applicationContext : context;
    }

    public final void a() {
        C2.h hVar;
        HashSet hashSet = this.f5947d;
        boolean isEmpty = hashSet.isEmpty();
        Context context = this.f5946c;
        if (!isEmpty && this.f5948e == null) {
            C2.h hVar2 = new C2.h(2, this);
            this.f5948e = hVar2;
            int i4 = Build.VERSION.SDK_INT;
            IntentFilter intentFilter = this.f5945b;
            if (i4 >= 33) {
                context.registerReceiver(hVar2, intentFilter, 2);
            } else {
                context.registerReceiver(hVar2, intentFilter);
            }
        }
        if (hashSet.isEmpty() && (hVar = this.f5948e) != null) {
            context.unregisterReceiver(hVar);
            this.f5948e = null;
        }
    }
}
