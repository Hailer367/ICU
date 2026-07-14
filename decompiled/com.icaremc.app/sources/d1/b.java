package d1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f3464a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f3465b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f3466c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f3467d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f3468e;

    /* renamed from: f, reason: collision with root package name */
    public static String f3469f;

    /* renamed from: g, reason: collision with root package name */
    public static int f3470g;

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f3471h;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r2 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = d1.b.f3469f
            if (r0 != 0) goto L75
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L11
            java.lang.String r0 = G.b.p()
            d1.b.f3469f = r0
            goto L75
        L11:
            int r0 = d1.b.f3470g
            if (r0 != 0) goto L1b
            int r0 = android.os.Process.myPid()
            d1.b.f3470g = r0
        L1b:
            java.lang.String r1 = "/cmdline"
            java.lang.String r2 = "/proc/"
            r3 = 0
            if (r0 > 0) goto L23
            goto L73
        L23:
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            int r4 = r4 + 14
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r2)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L64
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L64
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L64
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L64
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
            Z0.r.e(r0)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
            java.lang.String r3 = r0.trim()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
        L5b:
            r2.close()     // Catch: java.io.IOException -> L73
            goto L73
        L5f:
            r0 = move-exception
            r3 = r2
            goto L69
        L62:
            r0 = move-exception
            goto L69
        L64:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            throw r0     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
        L69:
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L6e
        L6e:
            throw r0
        L6f:
            r2 = r3
        L70:
            if (r2 == 0) goto L73
            goto L5b
        L73:
            d1.b.f3469f = r3
        L75:
            java.lang.String r0 = d1.b.f3469f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.b.a():java.lang.String");
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f3465b == null) {
            f3465b = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        f3465b.booleanValue();
        if (f3466c == null) {
            f3466c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (f3466c.booleanValue()) {
            if (!b() || Build.VERSION.SDK_INT >= 30) {
                return true;
            }
            return false;
        }
        return false;
    }
}
