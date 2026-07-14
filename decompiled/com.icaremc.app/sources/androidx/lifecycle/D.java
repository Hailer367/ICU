package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: classes.dex */
public final class D extends AbstractC0200g {
    final /* synthetic */ E this$0;

    /* loaded from: classes.dex */
    public static final class a extends AbstractC0200g {
        final /* synthetic */ E this$0;

        public a(E e4) {
            this.this$0 = e4;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            T2.h.e(activity, "activity");
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            T2.h.e(activity, "activity");
            E e4 = this.this$0;
            int i4 = e4.f2958f + 1;
            e4.f2958f = i4;
            if (i4 == 1 && e4.f2961i) {
                e4.k.e(EnumC0206m.ON_START);
                e4.f2961i = false;
            }
        }
    }

    public D(E e4) {
        this.this$0 = e4;
    }

    @Override // androidx.lifecycle.AbstractC0200g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        T2.h.e(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i4 = H.f2965g;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            T2.h.c(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((H) findFragmentByTag).f2966f = this.this$0.f2964m;
        }
    }

    @Override // androidx.lifecycle.AbstractC0200g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        T2.h.e(activity, "activity");
        E e4 = this.this$0;
        int i4 = e4.f2959g - 1;
        e4.f2959g = i4;
        if (i4 == 0) {
            Handler handler = e4.f2962j;
            T2.h.b(handler);
            handler.postDelayed(e4.f2963l, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        T2.h.e(activity, "activity");
        C.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.AbstractC0200g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        T2.h.e(activity, "activity");
        E e4 = this.this$0;
        int i4 = e4.f2958f - 1;
        e4.f2958f = i4;
        if (i4 == 0 && e4.f2960h) {
            e4.k.e(EnumC0206m.ON_STOP);
            e4.f2961i = true;
        }
    }
}
