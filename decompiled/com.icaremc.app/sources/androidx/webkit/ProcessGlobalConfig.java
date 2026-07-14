package androidx.webkit;

import android.webkit.WebView;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.chromium.support_lib_boundary.ProcessGlobalConfigConstants;
import q0.x;

/* loaded from: classes.dex */
public class ProcessGlobalConfig {

    /* renamed from: a, reason: collision with root package name */
    public String f3190a;

    /* renamed from: b, reason: collision with root package name */
    public String f3191b;

    /* renamed from: c, reason: collision with root package name */
    public String f3192c;
    private static final AtomicReference<HashMap<String, Object>> sProcessGlobalConfig = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f3188d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static boolean f3189e = false;

    public static void a(ProcessGlobalConfig processGlobalConfig) {
        synchronized (f3188d) {
            if (!f3189e) {
                f3189e = true;
            } else {
                throw new IllegalStateException("ProcessGlobalConfig#apply was called more than once, which is an illegal operation. The configuration settings provided by ProcessGlobalConfig take effect only once, when WebView is first loaded into the current process. Every process should only ever create a single instance of ProcessGlobalConfig and apply it once, before any calls to android.webkit APIs, such as during early app startup.");
            }
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            Field declaredField = Class.forName("android.webkit.WebViewFactory").getDeclaredField("sProviderInstance");
            declaredField.setAccessible(true);
            if (declaredField.get(null) != null) {
                throw new IllegalStateException("WebView has already been loaded in the current process, so any attempt to apply the settings in ProcessGlobalConfig will have no effect. ProcessGlobalConfig#apply needs to be called before any calls to android.webkit APIs, such as during early app startup.");
            }
        } catch (Exception unused) {
        }
        if (processGlobalConfig.f3190a != null) {
            if (x.f5927v.b()) {
                WebView.setDataDirectorySuffix(processGlobalConfig.f3190a);
            } else {
                hashMap.put(ProcessGlobalConfigConstants.DATA_DIRECTORY_SUFFIX, processGlobalConfig.f3190a);
            }
        }
        String str = processGlobalConfig.f3191b;
        if (str != null) {
            hashMap.put(ProcessGlobalConfigConstants.DATA_DIRECTORY_BASE_PATH, str);
        }
        String str2 = processGlobalConfig.f3192c;
        if (str2 != null) {
            hashMap.put(ProcessGlobalConfigConstants.CACHE_DIRECTORY_BASE_PATH, str2);
        }
        AtomicReference<HashMap<String, Object>> atomicReference = sProcessGlobalConfig;
        while (!atomicReference.compareAndSet(null, hashMap)) {
            if (atomicReference.get() != null) {
                throw new RuntimeException("Attempting to set ProcessGlobalConfig#sProcessGlobalConfig when it was already set");
            }
        }
    }
}
