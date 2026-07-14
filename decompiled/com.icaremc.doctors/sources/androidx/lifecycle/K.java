package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import androidx.lifecycle.M;

/* loaded from: classes.dex */
public abstract class K {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, EnumC0144n event) {
        kotlin.jvm.internal.h.e(event, "event");
        if (activity instanceof InterfaceC0150u) {
            AbstractC0146p lifecycle = ((InterfaceC0150u) activity).getLifecycle();
            if (lifecycle instanceof C0152w) {
                ((C0152w) lifecycle).e(event);
            }
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            M.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new M.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new Fragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
