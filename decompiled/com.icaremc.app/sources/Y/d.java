package Y;

import T2.h;
import android.util.Log;
import androidx.fragment.app.AbstractComponentCallbacksC0187t;
import androidx.fragment.app.P;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f2016a = c.f2015a;

    public static c a(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        while (abstractComponentCallbacksC0187t != null) {
            if (abstractComponentCallbacksC0187t.f2942y != null && abstractComponentCallbacksC0187t.f2933p) {
                abstractComponentCallbacksC0187t.e();
            }
            abstractComponentCallbacksC0187t = abstractComponentCallbacksC0187t.f2903A;
        }
        return f2016a;
    }

    public static void b(a aVar) {
        if (P.J(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(aVar.f2010f.getClass().getName()), aVar);
        }
    }

    public static final void c(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, String str) {
        h.e(str, "previousFragmentId");
        b(new a(abstractComponentCallbacksC0187t, "Attempting to reuse fragment " + abstractComponentCallbacksC0187t + " with previous ID " + str));
        a(abstractComponentCallbacksC0187t).getClass();
    }
}
