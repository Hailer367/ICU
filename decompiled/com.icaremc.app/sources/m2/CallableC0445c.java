package m2;

import A.k;
import android.content.Context;
import android.os.Build;
import android.os.Trace;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* renamed from: m2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class CallableC0445c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f5199a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0447e f5200b;

    public CallableC0445c(C0447e c0447e, Context context) {
        this.f5200b = c0447e;
        this.f5199a = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        String str2;
        C0447e c0447e = this.f5200b;
        Context context = this.f5199a;
        E2.a.b("FlutterLoader initTask");
        int i4 = 0;
        try {
            try {
                FlutterJNI flutterJNI = c0447e.f5207e;
                flutterJNI.loadLibrary(context);
                flutterJNI.updateRefreshRate();
                c0447e.f5208f.execute(new k(13, this));
                File filesDir = context.getFilesDir();
                if (filesDir == null) {
                    filesDir = new File(context.getDataDir().getPath(), "files");
                }
                String path = filesDir.getPath();
                File codeCacheDir = context.getCodeCacheDir();
                if (codeCacheDir == null) {
                    codeCacheDir = context.getCacheDir();
                }
                if (codeCacheDir == null) {
                    codeCacheDir = new File(context.getDataDir().getPath(), "cache");
                }
                String path2 = codeCacheDir.getPath();
                File dir = context.getDir("flutter", 0);
                if (dir == null) {
                    dir = new File(context.getDataDir().getPath(), "app_flutter");
                }
                dir.getPath();
                C0446d c0446d = new C0446d(path, path2);
                Trace.endSection();
                return c0446d;
            } catch (UnsatisfiedLinkError e4) {
                if (!e4.toString().contains("couldn't find \"libflutter.so\"") && !e4.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                    throw e4;
                }
                String property = System.getProperty("os.arch");
                File file = new File((String) c0447e.f5206d.f1441e);
                String[] list = file.list();
                ArrayList arrayList = new ArrayList();
                String[] strArr = Build.SUPPORTED_ABIS;
                int length = strArr.length;
                int i5 = 0;
                while (i5 < length) {
                    String str3 = strArr[i5];
                    StringBuilder sb = new StringBuilder();
                    sb.append("!");
                    String str4 = File.separator;
                    sb.append(str4);
                    sb.append("lib");
                    sb.append(str4);
                    sb.append(str3);
                    String sb2 = sb.toString();
                    String[] strArr2 = context.getApplicationInfo().splitSourceDirs;
                    ArrayList arrayList2 = new ArrayList();
                    if (strArr2 != null) {
                        int length2 = strArr2.length;
                        for (int i6 = i4; i6 < length2; i6++) {
                            arrayList2.add(strArr2[i6] + sb2);
                        }
                        arrayList.addAll(arrayList2);
                    }
                    String str5 = context.getApplicationInfo().sourceDir;
                    if (str5 != null && !str5.isEmpty()) {
                        arrayList.add(str5 + sb2);
                    }
                    i5++;
                    i4 = 0;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: ");
                sb3.append(property);
                sb3.append(", and the native libraries directory (with path ");
                sb3.append(file.getAbsolutePath());
                sb3.append(") ");
                if (file.exists()) {
                    str = "contains the following files: " + Arrays.toString(list);
                } else {
                    str = "does not exist";
                }
                sb3.append(str);
                if (arrayList.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = ", and the split and source libraries directory (with path(s) " + arrayList + ")";
                }
                sb3.append(str2);
                sb3.append(".");
                throw new UnsupportedOperationException(sb3.toString(), e4);
            }
        } finally {
        }
    }
}
