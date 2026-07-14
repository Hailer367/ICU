package io.flutter.embedding.engine.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.google.firebase.encoders.json.BuildConfig;
import com.google.firebase.messaging.Constants;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.util.HandlerCompat;
import io.flutter.util.PathUtils;
import io.flutter.util.TraceSection;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class FlutterLoader {
    static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    static final String AOT_VMSERVICE_SHARED_LIBRARY_NAME = "aot-vmservice-shared-library-name";
    static final String AUTOMATICALLY_REGISTER_PLUGINS_KEY = "automatically-register-plugins";
    private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    private static final String DEFAULT_LIBRARY = "libflutter.so";
    private static final String DISABLE_MERGED_PLATFORM_UI_THREAD_KEY = "io.flutter.embedding.android.DisableMergedPlatformUIThread";
    private static final String ENABLE_FLUTTER_GPU = "io.flutter.embedding.android.EnableFlutterGPU";
    private static final String ENABLE_IMPELLER_META_DATA_KEY = "io.flutter.embedding.android.EnableImpeller";
    private static final String ENABLE_SURFACE_CONTROL = "io.flutter.embedding.android.EnableSurfaceControl";
    private static final String ENABLE_VULKAN_VALIDATION_META_DATA_KEY = "io.flutter.embedding.android.EnableVulkanValidation";
    static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    private static final String IMPELLER_ANTIALIAS_LINES = "io.flutter.embedding.android.ImpellerAntialiasLines";
    private static final String IMPELLER_BACKEND_META_DATA_KEY = "io.flutter.embedding.android.ImpellerBackend";
    private static final String IMPELLER_LAZY_SHADER_MODE = "io.flutter.embedding.android.ImpellerLazyShaderInitialization";
    private static final String IMPELLER_OPENGL_GPU_TRACING_DATA_KEY = "io.flutter.embedding.android.EnableOpenGLGPUTracing";
    private static final String IMPELLER_VULKAN_GPU_TRACING_DATA_KEY = "io.flutter.embedding.android.EnableVulkanGPUTracing";
    static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    private static final String LEAK_VM_META_DATA_KEY = "io.flutter.embedding.android.LeakVM";
    private static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
    static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    private static final String TAG = "FlutterLoader";
    private static final String VMSERVICE_SNAPSHOT_LIBRARY = "libvmservice_snapshot.so";
    static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    static final String aotSharedLibraryNameFlag = "--aot-shared-library-name=";
    private static FlutterLoader instance;
    private ExecutorService executorService;
    private FlutterApplicationInfo flutterApplicationInfo;
    private FlutterJNI flutterJNI;
    Future<InitResult> initResultFuture;
    private long initStartTimestampMillis;
    boolean initialized;
    private Settings settings;

    /* renamed from: io.flutter.embedding.engine.loader.FlutterLoader$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Callable<InitResult> {
        final /* synthetic */ Context val$appContext;

        public AnonymousClass1(Context context) {
            this.val$appContext = context;
        }

        public /* synthetic */ void lambda$call$0() {
            FlutterLoader.this.flutterJNI.prefetchDefaultFontManager();
        }

        @Override // java.util.concurrent.Callable
        public InitResult call() {
            TraceSection traceSection;
            String str;
            String str2;
            TraceSection traceSection2;
            TraceSection scoped = TraceSection.scoped("FlutterLoader initTask");
            try {
                ResourceExtractor initResources = FlutterLoader.this.initResources(this.val$appContext);
                try {
                    FlutterLoader.this.flutterJNI.loadLibrary(this.val$appContext);
                    FlutterLoader.this.flutterJNI.updateRefreshRate();
                    FlutterLoader.this.executorService.execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            FlutterLoader.AnonymousClass1.this.lambda$call$0();
                        }
                    });
                    if (initResources != null) {
                        initResources.waitForCompletion();
                    }
                    InitResult initResult = new InitResult(PathUtils.getFilesDir(this.val$appContext), PathUtils.getCacheDirectory(this.val$appContext), PathUtils.getDataDirectory(this.val$appContext), null);
                    if (scoped != null) {
                        scoped.close();
                    }
                    return initResult;
                } catch (UnsatisfiedLinkError e2) {
                    if (!e2.toString().contains("couldn't find \"libflutter.so\"") && !e2.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                        throw e2;
                    }
                    String property = System.getProperty("os.arch");
                    FlutterLoader flutterLoader = FlutterLoader.this;
                    File fileFromPath = flutterLoader.getFileFromPath(flutterLoader.flutterApplicationInfo.nativeLibraryDir);
                    String[] list = fileFromPath.list();
                    ArrayList arrayList = new ArrayList();
                    String[] strArr = Build.SUPPORTED_ABIS;
                    int length = strArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str3 = strArr[i2];
                        StringBuilder sb = new StringBuilder();
                        sb.append("!");
                        String str4 = File.separator;
                        sb.append(str4);
                        sb.append("lib");
                        sb.append(str4);
                        sb.append(str3);
                        String sb2 = sb.toString();
                        String[] strArr2 = this.val$appContext.getApplicationInfo().splitSourceDirs;
                        ArrayList arrayList2 = new ArrayList();
                        if (strArr2 != null) {
                            int length2 = strArr2.length;
                            int i3 = 0;
                            while (i3 < length2) {
                                traceSection = scoped;
                                try {
                                    arrayList2.add(strArr2[i3] + sb2);
                                    i3++;
                                    scoped = traceSection;
                                } catch (Throwable th) {
                                    th = th;
                                    Throwable th2 = th;
                                    if (traceSection == null) {
                                        throw th2;
                                    }
                                    try {
                                        traceSection.close();
                                        throw th2;
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                        throw th2;
                                    }
                                }
                            }
                            traceSection2 = scoped;
                            arrayList.addAll(arrayList2);
                        } else {
                            traceSection2 = scoped;
                        }
                        String str5 = this.val$appContext.getApplicationInfo().sourceDir;
                        if (str5 != null && !str5.isEmpty()) {
                            arrayList.add(str5 + sb2);
                        }
                        i2++;
                        scoped = traceSection2;
                    }
                    traceSection = scoped;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: ");
                    sb3.append(property);
                    sb3.append(", and the native libraries directory (with path ");
                    sb3.append(fileFromPath.getAbsolutePath());
                    sb3.append(") ");
                    if (fileFromPath.exists()) {
                        str = "contains the following files: " + Arrays.toString(list);
                    } else {
                        str = "does not exist";
                    }
                    sb3.append(str);
                    if (arrayList.isEmpty()) {
                        str2 = BuildConfig.FLAVOR;
                    } else {
                        str2 = ", and the split and source libraries directory (with path(s) " + arrayList + ")";
                    }
                    sb3.append(str2);
                    sb3.append(".");
                    throw new UnsupportedOperationException(sb3.toString(), e2);
                }
            } catch (Throwable th4) {
                th = th4;
                traceSection = scoped;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class InitResult {
        final String appStoragePath;
        final String dataDirPath;
        final String engineCachesPath;

        public /* synthetic */ InitResult(String str, String str2, String str3, AnonymousClass1 anonymousClass1) {
            this(str, str2, str3);
        }

        private InitResult(String str, String str2, String str3) {
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

    /* loaded from: classes.dex */
    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    private String fullAssetPathFrom(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.flutterApplicationInfo.flutterAssetsDir);
        return O.a.i(sb, File.separator, str);
    }

    private String getSafeAotSharedLibraryNameFlag(Context context, String str) {
        if (str.startsWith(aotSharedLibraryNameFlag)) {
            File fileFromPath = getFileFromPath(str.substring(26));
            try {
                String canonicalPath = fileFromPath.getCanonicalPath();
                boolean startsWith = canonicalPath.startsWith(context.getApplicationContext().getFilesDir().getCanonicalPath() + File.separator);
                boolean endsWith = canonicalPath.endsWith(".so");
                if (startsWith && endsWith) {
                    return aotSharedLibraryNameFlag.concat(canonicalPath);
                }
                Log.e(TAG, "External path " + canonicalPath + " rejected; not overriding aot-shared-library-name.");
                return null;
            } catch (IOException unused) {
                Log.e(TAG, "External path " + fileFromPath.getPath() + " is not a valid path. Please ensure this shared AOT library exists.");
                return null;
            }
        }
        throw new IllegalArgumentException("AOT shared library name flag was not specified correctly; please use --aot-shared-library-name=<path>.");
    }

    public ResourceExtractor initResources(Context context) {
        return null;
    }

    private static boolean isLeakVM(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean(LEAK_VM_META_DATA_KEY, true);
    }

    public /* synthetic */ void lambda$ensureInitializationCompleteAsync$0(Context context, String[] strArr, Handler handler, Runnable runnable) {
        ensureInitializationComplete(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    public /* synthetic */ void lambda$ensureInitializationCompleteAsync$1(Context context, String[] strArr, Handler handler, Runnable runnable) {
        try {
            this.initResultFuture.get();
            HandlerCompat.createAsyncHandler(Looper.getMainLooper()).post(new a(this, context, strArr, handler, runnable, 1));
        } catch (Exception e2) {
            Log.e(TAG, "Flutter initialization failed.", e2);
            throw new RuntimeException(e2);
        }
    }

    public boolean automaticallyRegisterPlugins() {
        return this.flutterApplicationInfo.automaticallyRegisterPlugins;
    }

    public void ensureInitializationComplete(Context context, String[] strArr) {
        int i2;
        String str;
        if (!this.initialized) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.settings != null) {
                    try {
                        TraceSection scoped = TraceSection.scoped("FlutterLoader#ensureInitializationComplete");
                        try {
                            InitResult initResult = this.initResultFuture.get();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                            arrayList.add("--icu-native-lib-path=" + this.flutterApplicationInfo.nativeLibraryDir + File.separator + DEFAULT_LIBRARY);
                            if (strArr != null) {
                                for (String str2 : strArr) {
                                    if (str2.startsWith(aotSharedLibraryNameFlag)) {
                                        String safeAotSharedLibraryNameFlag = getSafeAotSharedLibraryNameFlag(context, str2);
                                        if (safeAotSharedLibraryNameFlag != null) {
                                            str2 = safeAotSharedLibraryNameFlag;
                                        } else {
                                            Log.w(TAG, "Skipping unsafe AOT shared library name flag: " + str2 + ". Please ensure that the library is vetted and placed in your application's internal storage.");
                                        }
                                    }
                                    arrayList.add(str2);
                                }
                            }
                            arrayList.add(aotSharedLibraryNameFlag + this.flutterApplicationInfo.aotSharedLibraryName);
                            arrayList.add(aotSharedLibraryNameFlag + this.flutterApplicationInfo.nativeLibraryDir + File.separator + this.flutterApplicationInfo.aotSharedLibraryName);
                            StringBuilder sb = new StringBuilder();
                            sb.append("--cache-dir-path=");
                            sb.append(initResult.engineCachesPath);
                            arrayList.add(sb.toString());
                            if (this.flutterApplicationInfo.domainNetworkPolicy != null) {
                                arrayList.add("--domain-network-policy=" + this.flutterApplicationInfo.domainNetworkPolicy);
                            }
                            if (this.settings.getLogTag() != null) {
                                arrayList.add("--log-tag=" + this.settings.getLogTag());
                            }
                            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle != null) {
                                i2 = bundle.getInt(OLD_GEN_HEAP_SIZE_META_DATA_KEY);
                            } else {
                                i2 = 0;
                            }
                            if (i2 == 0) {
                                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                                i2 = (int) ((r7.totalMem / 1000000.0d) / 2.0d);
                            }
                            arrayList.add("--old-gen-heap-size=" + i2);
                            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                            arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 48));
                            arrayList.add("--prefetched-default-font-manager");
                            if (bundle != null) {
                                if (bundle.containsKey(ENABLE_IMPELLER_META_DATA_KEY)) {
                                    if (bundle.getBoolean(ENABLE_IMPELLER_META_DATA_KEY)) {
                                        arrayList.add(FlutterShellArgs.ARG_ENABLE_IMPELLER);
                                    } else {
                                        arrayList.add(FlutterShellArgs.ARG_DISABLE_IMPELLER);
                                    }
                                }
                                if (bundle.getBoolean(ENABLE_VULKAN_VALIDATION_META_DATA_KEY, false)) {
                                    arrayList.add(FlutterShellArgs.ARG_ENABLE_VULKAN_VALIDATION);
                                }
                                if (bundle.getBoolean(IMPELLER_OPENGL_GPU_TRACING_DATA_KEY, false)) {
                                    arrayList.add("--enable-opengl-gpu-tracing");
                                }
                                if (bundle.getBoolean(IMPELLER_VULKAN_GPU_TRACING_DATA_KEY, false)) {
                                    arrayList.add("--enable-vulkan-gpu-tracing");
                                }
                                if (!bundle.getBoolean(DISABLE_MERGED_PLATFORM_UI_THREAD_KEY, false)) {
                                    if (bundle.getBoolean(ENABLE_FLUTTER_GPU, false)) {
                                        arrayList.add("--enable-flutter-gpu");
                                    }
                                    if (bundle.getBoolean(ENABLE_SURFACE_CONTROL, false)) {
                                        arrayList.add("--enable-surface-control");
                                    }
                                    String string = bundle.getString(IMPELLER_BACKEND_META_DATA_KEY);
                                    if (string != null) {
                                        arrayList.add("--impeller-backend=" + string);
                                    }
                                    if (bundle.getBoolean(IMPELLER_LAZY_SHADER_MODE)) {
                                        arrayList.add("--impeller-lazy-shader-mode");
                                    }
                                    if (bundle.getBoolean(IMPELLER_ANTIALIAS_LINES)) {
                                        arrayList.add("--impeller-antialias-lines");
                                    }
                                } else {
                                    throw new IllegalArgumentException("io.flutter.embedding.android.DisableMergedPlatformUIThread is no longer allowed.");
                                }
                            }
                            if (isLeakVM(bundle)) {
                                str = "true";
                            } else {
                                str = "false";
                            }
                            arrayList.add("--leak-vm=" + str);
                            this.flutterJNI.init(context, (String[]) arrayList.toArray(new String[0]), null, initResult.appStoragePath, initResult.engineCachesPath, SystemClock.uptimeMillis() - this.initStartTimestampMillis, Build.VERSION.SDK_INT);
                            this.initialized = true;
                            if (scoped != null) {
                                scoped.close();
                            }
                        } finally {
                        }
                    } catch (Exception e2) {
                        Log.e(TAG, "Flutter initialization failed.", e2);
                        throw new RuntimeException(e2);
                    }
                } else {
                    throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
                }
            } else {
                throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
            }
        }
    }

    public void ensureInitializationCompleteAsync(Context context, String[] strArr, Handler handler, Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.settings != null) {
                if (this.initialized) {
                    handler.post(runnable);
                    return;
                } else {
                    this.executorService.execute(new a(this, context, strArr, handler, runnable, 0));
                    return;
                }
            }
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
    }

    public String findAppBundlePath() {
        return this.flutterApplicationInfo.flutterAssetsDir;
    }

    public File getFileFromPath(String str) {
        return new File(str);
    }

    public String getLookupKeyForAsset(String str) {
        return fullAssetPathFrom(str);
    }

    public boolean initialized() {
        return this.initialized;
    }

    public void startInitialization(Context context) {
        startInitialization(context, new Settings());
    }

    public FlutterLoader(FlutterJNI flutterJNI) {
        this(flutterJNI, FlutterInjector.instance().executorService());
    }

    public String getLookupKeyForAsset(String str, String str2) {
        StringBuilder sb = new StringBuilder("packages");
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(str);
        return getLookupKeyForAsset(sb.toString());
    }

    public void startInitialization(Context context, Settings settings) {
        if (this.settings != null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            TraceSection scoped = TraceSection.scoped("FlutterLoader#startInitialization");
            try {
                Context applicationContext = context.getApplicationContext();
                this.settings = settings;
                this.initStartTimestampMillis = SystemClock.uptimeMillis();
                this.flutterApplicationInfo = ApplicationInfoLoader.load(applicationContext);
                VsyncWaiter.getInstance((DisplayManager) applicationContext.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION), this.flutterJNI).init();
                this.initResultFuture = this.executorService.submit(new AnonymousClass1(applicationContext));
                if (scoped != null) {
                    scoped.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (scoped != null) {
                    try {
                        scoped.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        throw new IllegalStateException("startInitialization must be called on the main thread");
    }

    public FlutterLoader(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.initialized = false;
        this.flutterJNI = flutterJNI;
        this.executorService = executorService;
    }
}
