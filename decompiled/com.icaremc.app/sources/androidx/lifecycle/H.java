package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class H extends Fragment {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f2965g = 0;

    /* renamed from: f, reason: collision with root package name */
    public A2.q f2966f;

    /* loaded from: classes.dex */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final G Companion = new Object();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            T2.h.e(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            T2.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            T2.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            T2.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            T2.h.e(activity, "activity");
            int i4 = H.f2965g;
            F.a(activity, EnumC0206m.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            T2.h.e(activity, "activity");
            int i4 = H.f2965g;
            F.a(activity, EnumC0206m.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            T2.h.e(activity, "activity");
            int i4 = H.f2965g;
            F.a(activity, EnumC0206m.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            T2.h.e(activity, "activity");
            int i4 = H.f2965g;
            F.a(activity, EnumC0206m.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            T2.h.e(activity, "activity");
            int i4 = H.f2965g;
            F.a(activity, EnumC0206m.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            T2.h.e(activity, "activity");
            int i4 = H.f2965g;
            F.a(activity, EnumC0206m.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            T2.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            T2.h.e(activity, "activity");
            T2.h.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            T2.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            T2.h.e(activity, "activity");
        }
    }

    public final void a(EnumC0206m enumC0206m) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            T2.h.d(activity, "activity");
            F.a(activity, enumC0206m);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(EnumC0206m.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(EnumC0206m.ON_DESTROY);
        this.f2966f = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(EnumC0206m.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        A2.q qVar = this.f2966f;
        if (qVar != null) {
            ((E) qVar.f93g).a();
        }
        a(EnumC0206m.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        A2.q qVar = this.f2966f;
        if (qVar != null) {
            E e4 = (E) qVar.f93g;
            int i4 = e4.f2958f + 1;
            e4.f2958f = i4;
            if (i4 == 1 && e4.f2961i) {
                e4.k.e(EnumC0206m.ON_START);
                e4.f2961i = false;
            }
        }
        a(EnumC0206m.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(EnumC0206m.ON_STOP);
    }
}
