package R;

import android.util.Log;
import androidx.fragment.app.H;
import androidx.fragment.app.h0;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f732a = c.f731a;

    public static c a(H h2) {
        while (h2 != null) {
            if (h2.isAdded()) {
                kotlin.jvm.internal.h.d(h2.getParentFragmentManager(), "declaringFragment.parentFragmentManager");
            }
            h2 = h2.getParentFragment();
        }
        return f732a;
    }

    public static void b(h hVar) {
        if (h0.K(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(hVar.f733c.getClass().getName()), hVar);
        }
    }

    public static final void c(H fragment, String previousFragmentId) {
        kotlin.jvm.internal.h.e(fragment, "fragment");
        kotlin.jvm.internal.h.e(previousFragmentId, "previousFragmentId");
        b(new h(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId));
        a(fragment).getClass();
    }
}
