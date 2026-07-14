package x;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* renamed from: x.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0702b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: f, reason: collision with root package name */
    public Object f6344f;

    /* renamed from: g, reason: collision with root package name */
    public Activity f6345g;

    /* renamed from: h, reason: collision with root package name */
    public final int f6346h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6347i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6348j = false;
    public boolean k = false;

    public C0702b(Activity activity) {
        this.f6345g = activity;
        this.f6346h = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f6345g == activity) {
            this.f6345g = null;
            this.f6348j = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.f6348j && !this.k && !this.f6347i) {
            Object obj = this.f6344f;
            try {
                Object obj2 = AbstractC0703c.f6351c.get(activity);
                if (obj2 == obj && activity.hashCode() == this.f6346h) {
                    AbstractC0703c.f6355g.postAtFrontOfQueue(new F.a(16, AbstractC0703c.f6350b.get(activity), obj2));
                    this.k = true;
                    this.f6344f = null;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while fetching field values", th);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f6345g == activity) {
            this.f6347i = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
