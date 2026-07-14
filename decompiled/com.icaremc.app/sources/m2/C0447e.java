package m2;

import P1.r;
import Z0.g;
import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.util.DisplayMetrics;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import r2.k;

/* renamed from: m2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0447e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5203a;

    /* renamed from: b, reason: collision with root package name */
    public g f5204b;

    /* renamed from: c, reason: collision with root package name */
    public long f5205c;

    /* renamed from: d, reason: collision with root package name */
    public r f5206d;

    /* renamed from: e, reason: collision with root package name */
    public FlutterJNI f5207e;

    /* renamed from: f, reason: collision with root package name */
    public ExecutorService f5208f;

    /* renamed from: g, reason: collision with root package name */
    public Future f5209g;

    public static String c(Context context, String str) {
        if (str.startsWith("--aot-shared-library-name=")) {
            File file = new File(str.substring(26));
            try {
                String canonicalPath = file.getCanonicalPath();
                boolean startsWith = canonicalPath.startsWith(context.getApplicationContext().getFilesDir().getCanonicalPath() + File.separator);
                boolean endsWith = canonicalPath.endsWith(".so");
                if (startsWith && endsWith) {
                    return "--aot-shared-library-name=".concat(canonicalPath);
                }
                Log.e("FlutterLoader", "External path " + canonicalPath + " rejected; not overriding aot-shared-library-name.");
                return null;
            } catch (IOException unused) {
                Log.e("FlutterLoader", "External path " + file.getPath() + " is not a valid path. Please ensure this shared AOT library exists.");
                return null;
            }
        }
        throw new IllegalArgumentException("AOT shared library name flag was not specified correctly; please use --aot-shared-library-name=<path>.");
    }

    public final void a(Context context, String[] strArr) {
        int i4;
        boolean z;
        String str;
        if (this.f5203a) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.f5204b != null) {
                try {
                    E2.a.b("FlutterLoader#ensureInitializationComplete");
                    try {
                        C0446d c0446d = (C0446d) this.f5209g.get();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                        arrayList.add("--icu-native-lib-path=" + ((String) this.f5206d.f1441e) + File.separator + "libflutter.so");
                        if (strArr != null) {
                            for (String str2 : strArr) {
                                if (str2.startsWith("--aot-shared-library-name=")) {
                                    String c4 = c(context, str2);
                                    if (c4 != null) {
                                        str2 = c4;
                                    } else {
                                        Log.w("FlutterLoader", "Skipping unsafe AOT shared library name flag: " + str2 + ". Please ensure that the library is vetted and placed in your application's internal storage.");
                                    }
                                }
                                arrayList.add(str2);
                            }
                        }
                        arrayList.add("--aot-shared-library-name=" + ((String) this.f5206d.f1438b));
                        arrayList.add("--aot-shared-library-name=" + ((String) this.f5206d.f1441e) + File.separator + ((String) this.f5206d.f1438b));
                        StringBuilder sb = new StringBuilder();
                        sb.append("--cache-dir-path=");
                        sb.append(c0446d.f5202b);
                        arrayList.add(sb.toString());
                        Object obj = this.f5206d.f1440d;
                        arrayList.add("--domain-network-policy=" + ((String) this.f5206d.f1440d));
                        this.f5204b.getClass();
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            i4 = bundle.getInt("io.flutter.embedding.android.OldGenHeapSize");
                        } else {
                            i4 = 0;
                        }
                        if (i4 == 0) {
                            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                            i4 = (int) ((r7.totalMem / 1000000.0d) / 2.0d);
                        }
                        arrayList.add("--old-gen-heap-size=" + i4);
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 48));
                        arrayList.add("--prefetched-default-font-manager");
                        if (bundle != null) {
                            if (bundle.containsKey("io.flutter.embedding.android.EnableImpeller")) {
                                if (bundle.getBoolean("io.flutter.embedding.android.EnableImpeller")) {
                                    arrayList.add("--enable-impeller=true");
                                } else {
                                    arrayList.add("--enable-impeller=false");
                                }
                            }
                            if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", false)) {
                                arrayList.add("--enable-vulkan-validation");
                            }
                            if (bundle.getBoolean("io.flutter.embedding.android.EnableOpenGLGPUTracing", false)) {
                                arrayList.add("--enable-opengl-gpu-tracing");
                            }
                            if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanGPUTracing", false)) {
                                arrayList.add("--enable-vulkan-gpu-tracing");
                            }
                            if (!bundle.getBoolean("io.flutter.embedding.android.DisableMergedPlatformUIThread", false)) {
                                if (bundle.getBoolean("io.flutter.embedding.android.EnableFlutterGPU", false)) {
                                    arrayList.add("--enable-flutter-gpu");
                                }
                                if (bundle.getBoolean("io.flutter.embedding.android.EnableSurfaceControl", false)) {
                                    arrayList.add("--enable-surface-control");
                                }
                                String string = bundle.getString("io.flutter.embedding.android.ImpellerBackend");
                                if (string != null) {
                                    arrayList.add("--impeller-backend=" + string);
                                }
                                if (bundle.getBoolean("io.flutter.embedding.android.ImpellerLazyShaderInitialization")) {
                                    arrayList.add("--impeller-lazy-shader-mode");
                                }
                                if (bundle.getBoolean("io.flutter.embedding.android.ImpellerAntialiasLines")) {
                                    arrayList.add("--impeller-antialias-lines");
                                }
                            } else {
                                throw new IllegalArgumentException("io.flutter.embedding.android.DisableMergedPlatformUIThread is no longer allowed.");
                            }
                        }
                        if (bundle == null) {
                            z = true;
                        } else {
                            z = bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
                        }
                        if (z) {
                            str = "true";
                        } else {
                            str = "false";
                        }
                        arrayList.add("--leak-vm=" + str);
                        this.f5207e.init(context, (String[]) arrayList.toArray(new String[0]), null, c0446d.f5201a, c0446d.f5202b, SystemClock.uptimeMillis() - this.f5205c, Build.VERSION.SDK_INT);
                        this.f5203a = true;
                        Trace.endSection();
                    } finally {
                    }
                } catch (Exception e4) {
                    Log.e("FlutterLoader", "Flutter initialization failed.", e4);
                    throw new RuntimeException(e4);
                }
            } else {
                throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
            }
        } else {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
    }

    public final String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append((String) this.f5206d.f1439c);
        return k.c(sb, File.separator, str);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [Z0.g, java.lang.Object] */
    public final void d(Context context) {
        ?? obj = new Object();
        if (this.f5204b != null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            E2.a.b("FlutterLoader#startInitialization");
            try {
                Context applicationContext = context.getApplicationContext();
                this.f5204b = obj;
                this.f5205c = SystemClock.uptimeMillis();
                this.f5206d = AbstractC0443a.a(applicationContext);
                t a4 = t.a((DisplayManager) applicationContext.getSystemService("display"), this.f5207e);
                a4.f4549b.setAsyncWaitForVsyncDelegate(a4.f4551d);
                this.f5209g = this.f5208f.submit(new CallableC0445c(this, applicationContext));
                Trace.endSection();
                return;
            } catch (Throwable th) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        throw new IllegalStateException("startInitialization must be called on the main thread");
    }
}
