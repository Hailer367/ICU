package f0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import v.AbstractFutureC0676h;
import v.C0677i;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final C0677i f3696a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f3697b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static H1.f f3698c = null;

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return h.a(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [H1.f, java.lang.Object] */
    public static H1.f b() {
        ?? obj = new Object();
        f3698c = obj;
        C0677i c0677i = f3696a;
        c0677i.getClass();
        if (AbstractFutureC0676h.k.c(c0677i, null, obj)) {
            AbstractFutureC0676h.c(c0677i);
        }
        return f3698c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:33|34|35|(2:75|76)(1:37)|38|(9:45|(1:49)|(1:56)|57|(2:65|66)|61|62|63|64)|(1:72)(1:(1:74))|(1:49)|(3:51|54|56)|57|(1:59)|65|66|61|62|63|64) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c5, code lost:
    
        r5 = 327680;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.j.c(android.content.Context, boolean):void");
    }
}
