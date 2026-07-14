package L0;

import R0.i;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class a implements MethodChannel.MethodCallHandler, FlutterPlugin {

    /* renamed from: c, reason: collision with root package name */
    public Context f594c;

    /* renamed from: d, reason: collision with root package name */
    public MethodChannel f595d;

    public static String b(byte[] bArr) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        h.b(digest);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[digest.length * 2];
        int length = digest.length;
        for (int i2 = 0; i2 < length; i2++) {
            byte b2 = digest[i2];
            int i3 = i2 * 2;
            cArr2[i3] = cArr[(b2 & 255) >>> 4];
            cArr2[i3 + 1] = cArr[b2 & 15];
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
                Context context = this.f594c;
                h.b(context);
                signingInfo = packageManager.getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                if (signingInfo != null) {
                    hasMultipleSigners = signingInfo.hasMultipleSigners();
                    if (hasMultipleSigners) {
                        apkContentsSigners = signingInfo.getApkContentsSigners();
                        h.d(apkContentsSigners, "getApkContentsSigners(...)");
                        byte[] byteArray = ((Signature) i.b0(apkContentsSigners)).toByteArray();
                        h.d(byteArray, "toByteArray(...)");
                        return b(byteArray);
                    }
                    signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    h.d(signingCertificateHistory, "getSigningCertificateHistory(...)");
                    byte[] byteArray2 = ((Signature) i.b0(signingCertificateHistory)).toByteArray();
                    h.d(byteArray2, "toByteArray(...)");
                    return b(byteArray2);
                }
                return null;
            }
            Context context2 = this.f594c;
            h.b(context2);
            Signature[] signatureArr = packageManager.getPackageInfo(context2.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length != 0 && i.b0(signatureArr) != null) {
                byte[] byteArray3 = ((Signature) i.b0(signatureArr)).toByteArray();
                h.d(byteArray3, "toByteArray(...)");
                return b(byteArray3);
            }
            return null;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        h.e(binding, "binding");
        this.f594c = binding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(binding.getBinaryMessenger(), "dev.fluttercommunity.plus/package_info");
        this.f595d = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        h.e(binding, "binding");
        this.f594c = null;
        MethodChannel methodChannel = this.f595d;
        h.b(methodChannel);
        methodChannel.setMethodCallHandler(null);
        this.f595d = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097 A[Catch: NameNotFoundException -> 0x0072, TryCatch #0 {NameNotFoundException -> 0x0072, blocks: (B:3:0x000a, B:5:0x0014, B:7:0x0047, B:8:0x0054, B:11:0x0065, B:13:0x006b, B:16:0x0075, B:19:0x008e, B:21:0x0097, B:22:0x009f, B:24:0x00a8, B:26:0x00af, B:27:0x00b4, B:30:0x009c, B:33:0x0050, B:34:0x00ca), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8 A[Catch: NameNotFoundException -> 0x0072, TryCatch #0 {NameNotFoundException -> 0x0072, blocks: (B:3:0x000a, B:5:0x0014, B:7:0x0047, B:8:0x0054, B:11:0x0065, B:13:0x006b, B:16:0x0075, B:19:0x008e, B:21:0x0097, B:22:0x009f, B:24:0x00a8, B:26:0x00af, B:27:0x00b4, B:30:0x009c, B:33:0x0050, B:34:0x00ca), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00af A[Catch: NameNotFoundException -> 0x0072, TryCatch #0 {NameNotFoundException -> 0x0072, blocks: (B:3:0x000a, B:5:0x0014, B:7:0x0047, B:8:0x0054, B:11:0x0065, B:13:0x006b, B:16:0x0075, B:19:0x008e, B:21:0x0097, B:22:0x009f, B:24:0x00a8, B:26:0x00af, B:27:0x00b4, B:30:0x009c, B:33:0x0050, B:34:0x00ca), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[Catch: NameNotFoundException -> 0x0072, TryCatch #0 {NameNotFoundException -> 0x0072, blocks: (B:3:0x000a, B:5:0x0014, B:7:0x0047, B:8:0x0054, B:11:0x0065, B:13:0x006b, B:16:0x0075, B:19:0x008e, B:21:0x0097, B:22:0x009f, B:24:0x00a8, B:26:0x00af, B:27:0x00b4, B:30:0x009c, B:33:0x0050, B:34:0x00ca), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMethodCall(io.flutter.plugin.common.MethodCall r13, io.flutter.plugin.common.MethodChannel.Result r14) {
        /*
            r12 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.h.e(r13, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.h.e(r14, r0)
            java.lang.String r13 = r13.method     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r0 = "getAll"
            boolean r13 = kotlin.jvm.internal.h.a(r13, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            if (r13 == 0) goto Lca
            android.content.Context r13 = r12.f594c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            kotlin.jvm.internal.h.b(r13)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            android.content.Context r0 = r12.f594c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            kotlin.jvm.internal.h.b(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r0 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r1 = 0
            android.content.pm.PackageInfo r0 = r13.getPackageInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r1 = r12.a(r13)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            android.content.Context r2 = r12.f594c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            kotlin.jvm.internal.h.b(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            android.content.Context r3 = r12.f594c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            kotlin.jvm.internal.h.b(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r3 = r3.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r5 = 30
            if (r4 < r5) goto L50
            android.content.pm.InstallSourceInfo r2 = E.a0.c(r2, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r2 = E.a0.k(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            goto L54
        L50:
            java.lang.String r2 = r2.getInstallerPackageName(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
        L54:
            long r5 = r0.firstInstallTime     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            long r7 = r0.lastUpdateTime     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.util.HashMap r3 = new java.util.HashMap     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r3.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r9 = "appName"
            android.content.pm.ApplicationInfo r10 = r0.applicationInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r11 = ""
            if (r10 == 0) goto L74
            java.lang.CharSequence r13 = r10.loadLabel(r13)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            if (r13 == 0) goto L74
            java.lang.String r13 = r13.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            if (r13 != 0) goto L75
            goto L74
        L72:
            r13 = move-exception
            goto Lce
        L74:
            r13 = r11
        L75:
            r3.put(r9, r13)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r13 = "packageName"
            android.content.Context r9 = r12.f594c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            kotlin.jvm.internal.h.b(r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r9 = r9.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r3.put(r13, r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r13 = "version"
            java.lang.String r9 = r0.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            if (r9 != 0) goto L8d
            goto L8e
        L8d:
            r11 = r9
        L8e:
            r3.put(r13, r11)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r13 = "buildNumber"
            r9 = 28
            if (r4 < r9) goto L9c
            long r9 = C.b.c(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            goto L9f
        L9c:
            int r0 = r0.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            long r9 = (long) r0     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
        L9f:
            java.lang.String r0 = java.lang.String.valueOf(r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r3.put(r13, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            if (r1 == 0) goto Lad
            java.lang.String r13 = "buildSignature"
            r3.put(r13, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
        Lad:
            if (r2 == 0) goto Lb4
            java.lang.String r13 = "installerStore"
            r3.put(r13, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
        Lb4:
            java.lang.String r13 = "installTime"
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r3.put(r13, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            java.lang.String r13 = "updateTime"
            java.lang.String r0 = java.lang.String.valueOf(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r3.put(r13, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r14.success(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            return
        Lca:
            r14.notImplemented()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            return
        Lce:
            java.lang.String r13 = r13.getMessage()
            r0 = 0
            java.lang.String r1 = "Name not found"
            r14.error(r1, r13, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.a.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
