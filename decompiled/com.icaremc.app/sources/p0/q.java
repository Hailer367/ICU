package p0;

import android.os.Build;
import android.util.Log;
import android.webkit.WebSettings;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import q0.C0595C;
import q0.y;

/* loaded from: classes.dex */
public abstract class q {
    public static C0595C a(WebSettings webSettings) {
        try {
            return new C0595C(5, (WebSettingsBoundaryInterface) k3.b.b(WebSettingsBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) y.f5931a.f5856b).convertSettings(webSettings)));
        } catch (ClassCastException e4) {
            if (Build.VERSION.SDK_INT == 30 && "android.webkit.WebSettingsWrapper".equals(webSettings.getClass().getCanonicalName())) {
                Log.e("WebSettingsCompat", "Error converting WebSettings to Chrome implementation. All AndroidX method calls on this WebSettings instance will be no-op calls. See https://crbug.com/388824130 for more info.", e4);
                return new C0595C(5, null);
            }
            throw e4;
        }
    }
}
