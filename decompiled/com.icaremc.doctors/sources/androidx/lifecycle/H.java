package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: classes.dex */
public final class H extends AbstractC0138h {
    final /* synthetic */ J this$0;

    /* loaded from: classes.dex */
    public static final class a extends AbstractC0138h {
        final /* synthetic */ J this$0;

        public a(J j2) {
            this.this$0 = j2;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.h.e(activity, "activity");
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.h.e(activity, "activity");
            J j2 = this.this$0;
            int i2 = j2.f1785c + 1;
            j2.f1785c = i2;
            if (i2 == 1 && j2.f1788f) {
                j2.f1790h.e(EnumC0144n.ON_START);
                j2.f1788f = false;
            }
        }
    }

    public H(J j2) {
        this.this$0 = j2;
    }

    @Override // androidx.lifecycle.AbstractC0138h, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.h.e(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i2 = M.f1793d;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            kotlin.jvm.internal.h.c(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((M) findFragmentByTag).f1794c = this.this$0.f1792j;
        }
    }

    @Override // androidx.lifecycle.AbstractC0138h, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.h.e(activity, "activity");
        J j2 = this.this$0;
        int i2 = j2.f1786d - 1;
        j2.f1786d = i2;
        if (i2 == 0) {
            Handler handler = j2.f1789g;
            kotlin.jvm.internal.h.b(handler);
            handler.postDelayed(j2.f1791i, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.h.e(activity, "activity");
        G.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.AbstractC0138h, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.h.e(activity, "activity");
        J j2 = this.this$0;
        int i2 = j2.f1785c - 1;
        j2.f1785c = i2;
        if (i2 == 0 && j2.f1787e) {
            j2.f1790h.e(EnumC0144n.ON_STOP);
            j2.f1788f = true;
        }
    }
}
