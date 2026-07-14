package f2;

import I2.d;
import T2.h;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import o2.b;
import o2.c;
import s2.C0644p;
import s2.InterfaceC0642n;

/* renamed from: f2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0288a implements InterfaceC0642n, c {

    /* renamed from: f, reason: collision with root package name */
    public Context f3707f;

    /* renamed from: g, reason: collision with root package name */
    public C0644p f3708g;

    public static String b(byte[] bArr) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        h.b(digest);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[digest.length * 2];
        int length = digest.length;
        for (int i4 = 0; i4 < length; i4++) {
            byte b4 = digest[i4];
            int i5 = i4 * 2;
            cArr2[i5] = cArr[(b4 & 255) >>> 4];
            cArr2[i5 + 1] = cArr[b4 & 15];
        }
        return new String(cArr2);
    }

    public final String a(PackageManager packageManager) {
        SigningInfo signingInfo;
        boolean hasMultipleSigners;
        Signature[] signingCertificateHistory;
        Signature[] apkContentsSigners;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Context context = this.f3707f;
                h.b(context);
                signingInfo = packageManager.getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                if (signingInfo != null) {
                    hasMultipleSigners = signingInfo.hasMultipleSigners();
                    if (hasMultipleSigners) {
                        apkContentsSigners = signingInfo.getApkContentsSigners();
                        h.d(apkContentsSigners, "getApkContentsSigners(...)");
                        byte[] byteArray = ((Signature) d.Z(apkContentsSigners)).toByteArray();
                        h.d(byteArray, "toByteArray(...)");
                        return b(byteArray);
                    }
                    signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    h.d(signingCertificateHistory, "getSigningCertificateHistory(...)");
                    byte[] byteArray2 = ((Signature) d.Z(signingCertificateHistory)).toByteArray();
                    h.d(byteArray2, "toByteArray(...)");
                    return b(byteArray2);
                }
                return null;
            }
            Context context2 = this.f3707f;
            h.b(context2);
            Signature[] signatureArr = packageManager.getPackageInfo(context2.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length != 0 && d.Z(signatureArr) != null) {
                byte[] byteArray3 = ((Signature) d.Z(signatureArr)).toByteArray();
                h.d(byteArray3, "toByteArray(...)");
                return b(byteArray3);
            }
            return null;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Override // o2.c
    public final void onAttachedToEngine(b bVar) {
        h.e(bVar, "binding");
        this.f3707f = bVar.f5785a;
        C0644p c0644p = new C0644p(bVar.f5787c, "dev.fluttercommunity.plus/package_info");
        this.f3708g = c0644p;
        c0644p.b(this);
    }

    @Override // o2.c
    public final void onDetachedFromEngine(b bVar) {
        h.e(bVar, "binding");
        this.f3707f = null;
        C0644p c0644p = this.f3708g;
        h.b(c0644p);
        c0644p.b(null);
        this.f3708g = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0092 A[Catch: NameNotFoundException -> 0x006d, TryCatch #0 {NameNotFoundException -> 0x006d, blocks: (B:3:0x0005, B:5:0x000f, B:7:0x0042, B:8:0x004f, B:11:0x0060, B:13:0x0066, B:16:0x0070, B:19:0x0089, B:21:0x0092, B:22:0x009a, B:24:0x00a3, B:26:0x00aa, B:27:0x00af, B:30:0x0097, B:33:0x004b, B:34:0x00c8), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3 A[Catch: NameNotFoundException -> 0x006d, TryCatch #0 {NameNotFoundException -> 0x006d, blocks: (B:3:0x0005, B:5:0x000f, B:7:0x0042, B:8:0x004f, B:11:0x0060, B:13:0x0066, B:16:0x0070, B:19:0x0089, B:21:0x0092, B:22:0x009a, B:24:0x00a3, B:26:0x00aa, B:27:0x00af, B:30:0x0097, B:33:0x004b, B:34:0x00c8), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa A[Catch: NameNotFoundException -> 0x006d, TryCatch #0 {NameNotFoundException -> 0x006d, blocks: (B:3:0x0005, B:5:0x000f, B:7:0x0042, B:8:0x004f, B:11:0x0060, B:13:0x0066, B:16:0x0070, B:19:0x0089, B:21:0x0092, B:22:0x009a, B:24:0x00a3, B:26:0x00aa, B:27:0x00af, B:30:0x0097, B:33:0x004b, B:34:0x00c8), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097 A[Catch: NameNotFoundException -> 0x006d, TryCatch #0 {NameNotFoundException -> 0x006d, blocks: (B:3:0x0005, B:5:0x000f, B:7:0x0042, B:8:0x004f, B:11:0x0060, B:13:0x0066, B:16:0x0070, B:19:0x0089, B:21:0x0092, B:22:0x009a, B:24:0x00a3, B:26:0x00aa, B:27:0x00af, B:30:0x0097, B:33:0x004b, B:34:0x00c8), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    @Override // s2.InterfaceC0642n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMethodCall(s2.C0641m r13, s2.InterfaceC0643o r14) {
        /*
            r12 = this;
            java.lang.String r0 = "call"
            T2.h.e(r13, r0)
            java.lang.String r13 = r13.f6155a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r0 = "getAll"
            boolean r13 = T2.h.a(r13, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r13 == 0) goto Lc8
            android.content.Context r13 = r12.f3707f     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            T2.h.b(r13)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            android.content.Context r0 = r12.f3707f     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            T2.h.b(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r0 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r1 = 0
            android.content.pm.PackageInfo r0 = r13.getPackageInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r1 = r12.a(r13)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            android.content.Context r2 = r12.f3707f     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            T2.h.b(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            android.content.Context r3 = r12.f3707f     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            T2.h.b(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r3 = r3.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r5 = 30
            if (r4 < r5) goto L4b
            android.content.pm.InstallSourceInfo r2 = F2.b.c(r2, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r2 = F2.b.j(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            goto L4f
        L4b:
            java.lang.String r2 = r2.getInstallerPackageName(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
        L4f:
            long r5 = r0.firstInstallTime     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            long r7 = r0.lastUpdateTime     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.util.HashMap r3 = new java.util.HashMap     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r3.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r9 = "appName"
            android.content.pm.ApplicationInfo r10 = r0.applicationInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r11 = ""
            if (r10 == 0) goto L6f
            java.lang.CharSequence r13 = r10.loadLabel(r13)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r13 == 0) goto L6f
            java.lang.String r13 = r13.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r13 != 0) goto L70
            goto L6f
        L6d:
            r13 = move-exception
            goto Lcf
        L6f:
            r13 = r11
        L70:
            r3.put(r9, r13)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r13 = "packageName"
            android.content.Context r9 = r12.f3707f     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            T2.h.b(r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r9 = r9.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r3.put(r13, r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r13 = "version"
            java.lang.String r9 = r0.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r9 != 0) goto L88
            goto L89
        L88:
            r11 = r9
        L89:
            r3.put(r13, r11)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r13 = "buildNumber"
            r9 = 28
            if (r4 < r9) goto L97
            long r9 = G.b.c(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            goto L9a
        L97:
            int r0 = r0.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            long r9 = (long) r0     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
        L9a:
            java.lang.String r0 = java.lang.String.valueOf(r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r3.put(r13, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r1 == 0) goto La8
            java.lang.String r13 = "buildSignature"
            r3.put(r13, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
        La8:
            if (r2 == 0) goto Laf
            java.lang.String r13 = "installerStore"
            r3.put(r13, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
        Laf:
            java.lang.String r13 = "installTime"
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r3.put(r13, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.String r13 = "updateTime"
            java.lang.String r0 = java.lang.String.valueOf(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r3.put(r13, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r13 = r14
            r2.i r13 = (r2.i) r13     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r13.success(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            return
        Lc8:
            r13 = r14
            r2.i r13 = (r2.i) r13     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r13.notImplemented()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            return
        Lcf:
            java.lang.String r13 = r13.getMessage()
            r0 = 0
            r2.i r14 = (r2.i) r14
            java.lang.String r1 = "Name not found"
            r14.error(r1, r13, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.C0288a.onMethodCall(s2.m, s2.o):void");
    }
}
